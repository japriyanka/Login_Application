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
    private int count = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = findViewById(R.id.etname);
        Password = findViewById(R.id.etpassword);
        Login = findViewById(R.id.btnlogin);
        Attempts_info = findViewById(R.id.tvattempts);
        Login.setOnClickListener(this);
    }
    private void validate(String username, String password){
        if ((username.equals("Admin")) && (password.equals("sarvesh"))){
            Intent intent = new Intent(MainActivity.this,TodoActivity.class);
            startActivity(intent);
        }else {
            count--;
            if (count == 0){
                Login.setEnabled(false);
            }
        }
    }

    @Override
    public void onClick(View view) {
        validate(Name.getText().toString(), Password.getText().toString());
    }
}
