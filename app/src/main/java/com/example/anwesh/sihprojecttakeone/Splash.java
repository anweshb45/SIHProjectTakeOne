package com.example.anwesh.sihprojecttakeone;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Splash extends AppCompatActivity {

    protected SharedPreferences prefLang;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        prefLang = getApplicationContext().getSharedPreferences("Arpit Shared Preferences" , MODE_PRIVATE);
        intent = new Intent(this, LoginPage.class);
    }

    public void setLangEn(View view) {

        prefLang.edit().putString("Lang" , "en");
        prefLang.edit().commit();
        Toast.makeText(getApplicationContext(),"Chose English" , Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }

    public void setLangHi(View view) {
        prefLang.edit().putString("Lang" , "hi");
        prefLang.edit().commit();
        Toast.makeText(getApplicationContext(),"Chose Hindi" , Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }
}
