package com.ornella.lupee_accounting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ornella.lupee_accounting.entities.User;
import com.ornella.lupee_accounting.manager.UserManager;

public class Login extends AppCompatActivity {
    private EditText loginName, loginPwd;
    private Button btnSubmit, cancelSignUp;
    private Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ctx = this;
        setContentView(R.layout.activity_login);
        loginName = findViewById(R.id.loginName);
        loginPwd = findViewById(R.id.loginPwd);
        btnSubmit = findViewById(R.id.submitBtn);
        cancelSignUp = findViewById(R.id.cancelLogin);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            String login = loginName.getText().toString();
            String mdp  = loginPwd.getText().toString();
            User userToAdd = new User(login, mdp);
            UserManager.add(ctx, userToAdd);
            finish();
            }

        });

        cancelSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}