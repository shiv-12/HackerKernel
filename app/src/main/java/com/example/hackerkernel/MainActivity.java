package com.example.hackerkernel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    Button btn;
     RequestQueue requestQueue;

     String url="https://reqres.in/api/login";
     EditText email,pass;

    private SharedPreferenceConfig preferenceConfig;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.button);
        email = (EditText) findViewById(R.id.editnumber);
        pass = (EditText)findViewById(R.id.editpassword);

        preferenceConfig = new SharedPreferenceConfig(getApplicationContext());

        if (preferenceConfig.readloginstatus())
        {
            Intent intent1 = new Intent(MainActivity.this, home.class);
            startActivity(intent1);
            finish();
        }



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendReq();



            }
        });

    }
    public void sendReq(){

        final String email1 = email.getText().toString();
        String password1 = pass.getText().toString();
        Map<String,String> params = new HashMap<String,String>();
        params.put("email",email1);
        params.put("password",password1);
        requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest postRequest = new JsonObjectRequest(Request.Method.POST, url,
                new JSONObject(params), new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(MainActivity.this, home.class);
                startActivity(intent1);

                preferenceConfig.writeloginstatus(true);
                finish();



            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_LONG).show();
                email.setText("");
                pass.setText("");
            }
        }){
            @Override
            public Map<String,String> getHeaders() throws AuthFailureError{
                HashMap<String,String> headers = new HashMap<String,String>();
                headers.put("content-Type","application/json; charset=utf-8");
                headers.put("user-agent",System.getProperty("http.agent"));
                return  headers;
            }
        };
          requestQueue.add(postRequest);

            }
    public void clickhere(View view){
        Intent intent = new Intent(MainActivity.this, Register.class);
        startActivity(intent);
    }

    public void forgot(View view){
        Toast.makeText(MainActivity.this,"forgot option selected",Toast.LENGTH_SHORT).show();
    }
}
