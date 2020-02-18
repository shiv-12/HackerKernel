package com.example.hackerkernel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void terms(View view) {
            Toast.makeText(this,"terms & conditions option selected",Toast.LENGTH_SHORT).show();
          }

    public void clickhere2(View view) {
        Intent intent =new Intent(this,MainActivity.class);
        startActivity(intent);

    }
}
