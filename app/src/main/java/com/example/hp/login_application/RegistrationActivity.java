package com.example.hp.login_application;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText RegName, RegPassword, RegEmail;
    private Button RegLogin, RegSignUp;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        idAssignment();
        RegLogin.setOnClickListener(this);
        RegSignUp.setOnClickListener(this);
        firebaseAuth = FirebaseAuth.getInstance();

    }
    //Assigning all ID's
    private void idAssignment(){
        RegName = findViewById(R.id.etRegName);
        RegEmail = findViewById(R.id.etRegMail);
        RegPassword = findViewById(R.id.etRegPassword);
        RegLogin = findViewById(R.id.btnRegLogin);
        RegSignUp = findViewById(R.id.btnRegSignUp);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            //The user has already signed up and he again wants to go to main activity to sign in
            case R.id.btnRegLogin:
                Intent intent = new Intent(RegistrationActivity.this,MainActivity.class);
                startActivity(intent);
                break;
            //Register new user with the firebase if all details are correct
            case R.id.btnRegSignUp:
                String name,mail,password;
                name = RegName.getText().toString().trim();
                mail = RegEmail.getText().toString().trim();
                password = RegPassword.getText().toString().trim();
                //Check all details are filled
                if ((name.length() == 0) || (mail.length() == 0) || (password.length() == 0)){
                    Toast.makeText(this,"password/username/email has not entered",Toast.LENGTH_SHORT).show();
                    //  Intent i = new Intent(RegistrationActivity.this,MainActivity.class);
                    //startActivity(i);
                }
                else {
                    //Details added in firebase if successful
                    firebaseAuth.createUserWithEmailAndPassword(mail,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(RegistrationActivity.this,"Registration Successful",Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(RegistrationActivity.this,MainActivity.class);
                                startActivity(i);
                            }
                            else {
                                Toast.makeText(RegistrationActivity.this,"Registration Failed",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
                break;

        }


    }
}
