package com.example.foodofshivar;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    TextView signup_btn;
    EditText email,User_Password;
    Button login_btn1;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        email=findViewById(R.id.email);
        User_Password=findViewById(R.id.User_Password);
        signup_btn=findViewById(R.id.signup_btn);
        login_btn1=findViewById(R.id.login_btn1);
        firebaseAuth=FirebaseAuth.getInstance();

        login_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent=new Intent(LoginActivity.this,ChooseYourLocationActivity.class);
                startActivity(intent);
                finish();
                String email1=email.getText().toString();
                String password1=User_Password.getText().toString();
                if (TextUtils.isEmpty(email1)||TextUtils.isEmpty(password1))
                {
                    Toast.makeText(LoginActivity.this, "Plz Fill the all details", Toast.LENGTH_SHORT).show();
                }else {
                    Account_User(email1,password1);
                }
            }
        });



        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent=new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();

        // Check if the user is already logged in
        if (firebaseAuth.getCurrentUser() != null) {
            // If logged in, redirect to the main activity
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish(); // Close the login activity
        }
    }

    private void Account_User(String email1, String password1) {

        firebaseAuth.signInWithEmailAndPassword(email1,password1).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(LoginActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();
//                Intent intent;
//                intent=new Intent(LoginActivity.this,MainActivity.class);
//                startActivity(intent);
//                finish();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(LoginActivity.this, "Please Enter Correct Email or Password", Toast.LENGTH_SHORT).show();
            }
        });
    }

    
}

