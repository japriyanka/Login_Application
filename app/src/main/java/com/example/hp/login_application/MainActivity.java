package com.example.hp.login_application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText Name;
    private EditText Password;
    private Button Login;
    private TextView Attempts_info;
    private Button SignUp;
    private int count = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = findViewById(R.id.etname);
        Password = findViewById(R.id.etpassword);
        Login = findViewById(R.id.btnlogin);
        Attempts_info = findViewById(R.id.tvattempts);
        SignUp = findViewById(R.id.btnsignup);
        Login.setOnClickListener(this);
        SignUp.setOnClickListener(this);
    }
    private void validate(String username, String password){
        if ((username.equals("Priyanka")) && (password.equals("sarvesh"))){
            Intent intent = new Intent(MainActivity.this,TodoActivity.class);
            startActivity(intent);
        }else {
            count--;
            Attempts_info.setText("Number of attempts remaining :" + String.valueOf(count));
            if (count == 0){
                Login.setEnabled(false);
                Attempts_info.setText("No more attempts remaining");
            }
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnlogin:
            validate(Name.getText().toString(), Password.getText().toString());
            case R.id.btnsignup:
                Intent intent = new Intent(MainActivity.this, RegistrationActivity.class);
                startActivity(intent);
        }
    }
}
