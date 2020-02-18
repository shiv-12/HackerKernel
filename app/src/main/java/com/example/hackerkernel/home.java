package com.example.hackerkernel;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class home extends AppCompatActivity {

    ListView listView;
    ArrayAdapter<String> adapter;
    ArrayList<String> list;
    SearchView searchView;
    CircleImageView civ ;
    LinearLayout lin;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);



        searchView = (SearchView) findViewById(R.id.searchbar);
        civ = (CircleImageView) findViewById(R.id.profile);
        lin = (LinearLayout)findViewById(R.id.lin);


        civ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Pair[] pairs = new Pair[1];
                pairs[0] = new Pair<View,String>(civ,"imagee");
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(home.this,pairs);

                Intent intent33 = new Intent(home.this, profile.class);
                startActivity(intent33,options.toBundle());
            }
        });





    }


    public void my_drives(View view){

        Snackbar.make(lin,"My Drives Option Selected",Snackbar.LENGTH_SHORT).show();

    }


}
