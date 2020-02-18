package com.example.hackerkernel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class profile extends AppCompatActivity {

   private SharedPreferenceConfig sharedPreferenceConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        sharedPreferenceConfig = new SharedPreferenceConfig(getApplicationContext());
    }
    public void logout(View view) {

        sharedPreferenceConfig.writeloginstatus(false);
        Toast.makeText(this,"Logout Successful",Toast.LENGTH_LONG).show();
        Intent intent =new Intent(this,MainActivity.class);
        startActivity(intent);


    }
}
