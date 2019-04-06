package com.example.apiriot;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import android.util.Log;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "loggerApplication";
    public static ArrayList<String> nom_Personnage = new ArrayList<String>();
    public static HashMap<String,Personnage> personnage = new HashMap<String,Personnage>();

    public RecyclerView recycler;
    public AdaptateurRecycler adaptateur;

    @TargetApi(Build.VERSION_CODES.N)
    @RequiresApi(api = Build.VERSION_CODES.N)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.recycler = (RecyclerView) findViewById(R.id.recycler);
        Picasso.with(this).load("http://rly-chrono.fr/api/League_of_legend/image/lol.png").into((ImageView)findViewById(R.id.logo_lol));
        Picasso.with(this).load("http://rly-chrono.fr/api/League_of_legend/image/logo.png").resize(128,128).into((ImageView)findViewById(R.id.logo_logo));
        initPersonnage();
    }
    public void initPersonnage(){
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        nom_Personnage = new Gson().fromJson(sharedPreferences.getString("nom_personnage",null),new TypeToken<ArrayList<String>>() {}.getType());
        personnage = new Gson().fromJson(sharedPreferences.getString("personnage",null),new TypeToken<HashMap<String,Personnage>>() {}.getType());
        if(nom_Personnage == null || personnage == null){
            saveData();
        }
        this.setadptateur();
    }
    public void saveData(){
        nom_Personnage = new ArrayList<String>();
        personnage = new HashMap<String,Personnage>();
        Personnage.initialisation("http://rly-chrono.fr/api/League_of_legend/personnage.json");
        while(!Personnage.initialisation);
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("nom_personnage", new Gson().toJson(nom_Personnage));
        editor.putString("personnage", new Gson().toJson(personnage));
        editor.apply();
    }
    private void setadptateur(){
        this.adaptateur = new AdaptateurRecycler(MainActivity.nom_Personnage);
        this.recycler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        this.recycler.setAdapter(this.adaptateur);
        this.adaptateur.setOnItemClickListener(new AdaptateurRecycler.OnItemClickListener() {
            @Override
            public void click(int position) {
                otherActivity(position);
            }
        });
    }
    private void otherActivity(int position){
        Intent intent = new Intent(this, DetailPersonnage.class);
        intent.putExtra("RiotPersonnage",nom_Personnage.get(position));
        startActivity(intent);
        overridePendingTransition(R.anim.slide_int_right,R.anim.slide_out_right);
    }
}
