package com.example.foodofshivar;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class SignupActivity extends AppCompatActivity {
    TextView login_btn;
    EditText User_name, User_email, User_Password;
    AppCompatButton create_account_button;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        User_name = findViewById(R.id.User_name);
        User_email = findViewById(R.id.User_email);
        User_Password = findViewById(R.id.User_Password);
        create_account_button = findViewById(R.id.create_account_button);
        login_btn = findViewById(R.id.login_btn);
        firebaseAuth = FirebaseAuth.getInstance();

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });


        create_account_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = User_name.getText().toString();
                String email = User_email.getText().toString();
                String password = User_Password.getText().toString();

                if (TextUtils.isEmpty(name) || TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                    Toast.makeText(SignupActivity.this, "Plz Fill the all details", Toast.LENGTH_SHORT).show();
                } else {
                    Account_User(email, password, name);
                }

                HashMap<String, Object> m = new HashMap<>();
                m.put("Name", User_name.getText().toString());
                m.put("Email", User_email.getText().toString());
                m.put("Password", User_Password.getText().toString());

                FirebaseDatabase.getInstance().getReference().child("User").push().setValue(m);


            }
        });

    }

    private void Account_User(String email, String password, final String name) {
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(SignupActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    FirebaseFirestore db = FirebaseFirestore.getInstance();
                    String userId = firebaseAuth.getCurrentUser().getUid();

                    // Creating a user map to store in Firestore
                    Map<String, Object> user = new HashMap<>();
                    user.put("name", name);
                    user.put("email", email);
                    user.put("password", password);
                    FirebaseDatabase.getInstance().getReference().child("User").push().setValue(user);


                    // Adding user data to Firestore under 'users' collection with UID
                    FirebaseFirestore.getInstance().collection("users").document(userId)
                            .set(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Intent intent;
                                        intent = new Intent(SignupActivity.this, LoginActivity.class);
                                        startActivity(intent);
                                        finish();
                                        Toast.makeText(SignupActivity.this, "Registration successful", Toast.LENGTH_SHORT).show();
                                        // Redirect the user or perform other actions upon successful registration
                                    } else {
                                        Toast.makeText(SignupActivity.this, "Failed to add user data to Firestore", Toast.LENGTH_SHORT).show();
                                    }
                                }

                            });
                    Toast.makeText(SignupActivity.this, "Account Create successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Log.e("Firebase Authentication", "Registration failed", task.getException());
                    Toast.makeText(SignupActivity.this, "Failed to add user data to Firestore", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}