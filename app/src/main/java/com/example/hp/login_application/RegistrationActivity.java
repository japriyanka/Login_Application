package com.example.hp.login_application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
            case R.id.btnRegLogin:
                Intent intent = new Intent(RegistrationActivity.this,MainActivity.class);
                startActivity(intent);
            case R.id.btnRegSignUp:
                String name,mail,password;
                name = RegName.getText().toString().trim();
                mail = RegEmail.getText().toString().trim();
                password = RegPassword.getText().toString().trim();
                if (!((name.length() == 0) && (mail.length() == 0) && (password.length() == 0))){
                    Toast.makeText(this,"password/username/email has not entered",Toast.LENGTH_SHORT);
                    //  Intent i = new Intent(RegistrationActivity.this,MainActivity.class);
                    //startActivity(i);
                }

        }


    }
}
