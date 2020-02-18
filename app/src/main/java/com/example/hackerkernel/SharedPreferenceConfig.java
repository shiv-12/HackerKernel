package com.example.hackerkernel;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceConfig {
    SharedPreferences sharedPreferences;
    Context context;

    public SharedPreferenceConfig(Context context) {

        this.context = context;
        sharedPreferences= context.getSharedPreferences(context.getResources().getString(R.string.login_preference),Context.MODE_PRIVATE);
    }

    public void writeloginstatus(Boolean status)
    {
        SharedPreferences.Editor editor = sharedPreferences.edit().putBoolean(context.getResources().getString(R.string.login_status_preference),status);
        editor.commit();

    }

    public boolean readloginstatus(){
        Boolean status = false;
        status= sharedPreferences.getBoolean(context.getResources().getString(R.string.login_status_preference),false);
        return status;

    }
}
