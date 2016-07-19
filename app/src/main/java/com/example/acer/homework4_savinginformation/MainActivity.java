package com.example.acer.homework4_savinginformation;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edtName;
    EditText edtPassword;
    Button btnSignIn;
    Button btnSignUp;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtName = (EditText) findViewById(R.id.edt_name);
        edtPassword = (EditText) findViewById(R.id.edt_password);
        btnSignIn = (Button) findViewById(R.id.btn_sign_in);
        btnSignUp = (Button) findViewById(R.id.btn_sign_up);
        sp = this.getPreferences(MODE_PRIVATE);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtName.getText().toString().equals(sp.getString(edtName.getText().toString(), edtName.getText().toString() + "."))){
                    if(edtPassword.getText().toString().equals(sp.getString(edtPassword.getText().toString(), edtPassword.getText().toString() + "."))){
                        Intent i = new Intent(MainActivity.this, HelloActivity.class);
                        startActivity(i);
                    } else {
                        edtPassword.setError("wrong password!");
                    }
                } else {
                    edtName.setError("wrong username!");
                }
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(i);
            }
        });
    }
}
