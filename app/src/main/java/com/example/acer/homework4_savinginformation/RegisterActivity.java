package com.example.acer.homework4_savinginformation;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    EditText edtName;
    EditText edtPassword;
    EditText edtConfirmPassword;
    Button btnCreate;
    Button btnCancel;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtName = (EditText) findViewById(R.id.edt_name_new);
        edtPassword = (EditText) findViewById(R.id.edt_password_new);
        edtConfirmPassword = (EditText) findViewById(R.id.edt_password_confirm);
        btnCreate = (Button) findViewById(R.id.btn_create);
        btnCancel = (Button) findViewById(R.id.btn_cancel);
        sp = this.getPreferences(MODE_PRIVATE);

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!edtName.getText().toString().equals("")){
                    if(!edtPassword.getText().toString().equals("")
                            && edtPassword.getText().toString().equals(edtConfirmPassword.getText().toString())){
                        Intent i = new Intent(RegisterActivity.this, MainActivity.class);
                        sp.edit().putString(edtName.getText().toString(), edtName.getText().toString()).apply();
                        sp.edit().putString(edtPassword.getText().toString(), edtPassword.getText().toString()).apply();
                        startActivity(i);
                    } else {
                        edtConfirmPassword.setError("passwords don't math!");
                    }
                } else {
                    edtName.setError("Invalid username!");
                }
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

    }
}
