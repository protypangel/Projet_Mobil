package com.example.apiriot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailPersonnage extends AppCompatActivity {
    private String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_personnage);
        Intent intent = getIntent();
        name = intent.getStringExtra("RiotPersonnage");
        valueText();
        valueImg();
    }
    private void valueText(){
        ((TextView) findViewById(R.id.name)).setText(name);
        ((TextView) findViewById(R.id.name_pv)).setText(Double.toString(MainActivity.personnage.get(name).get(1))+" (+"+Double.toString(MainActivity.personnage.get(name).get(8))+" par niveau) point vie");
        ((TextView) findViewById(R.id.name_degat)).setText(Double.toString(MainActivity.personnage.get(name).get(2))+" (+"+Double.toString(MainActivity.personnage.get(name).get(9))+" par niveau) degat");
        ((TextView) findViewById(R.id.name_vitesse_attaque)).setText(Double.toString(MainActivity.personnage.get(name).get(3))+" (+"+Double.toString(MainActivity.personnage.get(name).get(10))+"% par niveau) vitesse d'attaque");
        ((TextView) findViewById(R.id.name_vitesse_deplacement)).setText(Double.toString(MainActivity.personnage.get(name).get(4))+" vitesse de déplacement");
        ((TextView) findViewById(R.id.name_regeneration_pv)).setText(Double.toString(MainActivity.personnage.get(name).get(5))+" (+"+Double.toString(MainActivity.personnage.get(name).get(11))+" par niveau) regeneration des pv");
        ((TextView) findViewById(R.id.name_armure)).setText(Double.toString(MainActivity.personnage.get(name).get(6))+" (+"+Double.toString(MainActivity.personnage.get(name).get(12))+" par niveau) armure");
        ((TextView) findViewById(R.id.name_resistance_magique)).setText(Double.toString(MainActivity.personnage.get(name).get(7))+" (+"+Double.toString(MainActivity.personnage.get(name).get(13))+" par niveau) resistance magique");
    }
    private void valueImg(){
        Picasso.with(this).load("http://rly-chrono.fr/api/League_of_legend/image/Personnage/"+name+".png").into((ImageView)findViewById(R.id.logo));
        Picasso.with(this).load("http://rly-chrono.fr/api/League_of_legend/image/Icon_Personnage/pv.png").into((ImageView)findViewById(R.id.logo_pv));
        Picasso.with(this).load("http://rly-chrono.fr/api/League_of_legend/image/Icon_Personnage/degat.png").into((ImageView)findViewById(R.id.logo_degat));
        Picasso.with(this).load("http://rly-chrono.fr/api/League_of_legend/image/Icon_Personnage/vitesse_d_attaque.png").into((ImageView)findViewById(R.id.logo_vitesse_attaque));
        Picasso.with(this).load("http://rly-chrono.fr/api/League_of_legend/image/Icon_Personnage/vitesse_de_deplacement.png").into((ImageView)findViewById(R.id.logo_vitesse_deplacement));
        Picasso.with(this).load("http://rly-chrono.fr/api/League_of_legend/image/Icon_Personnage/regeneration_pv.png").into((ImageView)findViewById(R.id.logo_regeneration_pv));
        Picasso.with(this).load("http://rly-chrono.fr/api/League_of_legend/image/Icon_Personnage/armure.png").into((ImageView)findViewById(R.id.logo_armure));
        Picasso.with(this).load("http://rly-chrono.fr/api/League_of_legend/image/Icon_Personnage/resistance_magique.png").into((ImageView)findViewById(R.id.logo_resistance_magique));
    }
}
