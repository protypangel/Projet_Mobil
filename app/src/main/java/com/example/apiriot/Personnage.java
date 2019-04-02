package com.example.apiriot;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import java.io.*;
import java.net.*;

public class Personnage {
    private double pv;
    private double degat;
    private double vitesse_attaque;
    private double vitesse_deplacement;
    private double regeneration_pv;
    private double armure;
    private double resistance_magique;
    private double pv_par_niveau;
    private double degat_par_niveau;
    private double vitesse_attaque_par_niveau;
    private double regeneration_des_pv_par_niveau;
    private double armure_par_niveau;
    private double resistance_magique_par_niveau;
    public Personnage(double pv,double degat,double vitesse_attaque,double vitesse_deplacement,double regeneration_pv,double armure,double resistance_magique,double pv_par_niveau,double degat_par_niveau,double vitesse_attaque_par_niveau,double regeneration_des_pv_par_niveau,double armure_par_niveau,double resistance_magique_par_niveau) {
        this.pv=pv;
        this.degat=degat;
        this.vitesse_attaque=vitesse_attaque;
        this.vitesse_deplacement=vitesse_deplacement;
        this.regeneration_pv=regeneration_pv;
        this.armure=armure;
        this.resistance_magique=resistance_magique;
        this.pv_par_niveau=pv_par_niveau;
        this.degat_par_niveau=pv_par_niveau;
        this.vitesse_attaque_par_niveau=vitesse_attaque_par_niveau;
        this.regeneration_des_pv_par_niveau=regeneration_des_pv_par_niveau;
        this.armure_par_niveau=armure_par_niveau;
        this.resistance_magique_par_niveau=resistance_magique_par_niveau;
    }
    public static boolean initialisation = false;
    public static void initialisation(String path){
        new Thread(new Runnable(){
            @TargetApi(Build.VERSION_CODES.N)
            public void run() {
                try {
                    String line;
                    BufferedReader buffer = new BufferedReader(new InputStreamReader(new URL(path).openConnection().getInputStream()));
                    buffer.readLine();
                    line = buffer.readLine().split(":")[1].split(",")[0];
                    int nb_personnage = Integer.parseInt(line);
                    buffer.readLine();
                    for(int i=0;i<nb_personnage;i++){
                        String name = buffer.readLine().split(":")[0].split("\t\t")[1];
                        double pv=0,degat=0,vitesse_attaque=0,vitesse_deplacement=0,regeneration_pv=0,armure=0,resistance_magique=0,pv_par_niveau=0,degat_par_niveau=0,vitesse_attaque_par_niveau=0,regeneration_des_pv_par_niveau=0,armure_par_niveau=0,resistance_magique_par_niveau=0;
                        for(int j=0;j<13;j++){
                            double v = 0;
                            try{
                                line = buffer.readLine();
                                line = line.split(":")[1].split(",")[0];
                                v = Double.parseDouble(line);
                            } catch (Exception e) {
                                Log.i(MainActivity.TAG,e.getMessage());
                            }
                            switch(j){
                                case 0:pv=v;break;
                                case 1:degat=v;break;
                                case 2:vitesse_attaque=v;break;
                                case 3:vitesse_deplacement=v;break;
                                case 4:regeneration_pv=v;break;
                                case 5:armure=v;break;
                                case 6:resistance_magique=v;break;
                                case 7:pv_par_niveau=v;break;
                                case 8:degat_par_niveau=v;break;
                                case 9:vitesse_attaque_par_niveau=v;break;
                                case 10:regeneration_des_pv_par_niveau=v;break;
                                case 11:armure_par_niveau=v;break;
                                case 12:resistance_magique_par_niveau=v;break;
                            }
                        }
                        Personnage p = new Personnage(pv,degat,vitesse_attaque,vitesse_deplacement,regeneration_pv,armure,resistance_magique,pv_par_niveau,degat_par_niveau,vitesse_attaque_par_niveau,regeneration_des_pv_par_niveau,armure_par_niveau,resistance_magique_par_niveau);
                        MainActivity.personnage.put(name,p);
                        MainActivity.nom_Personnage.add(name);
                        buffer.readLine();
                    }
                } catch(Exception e) {
                    Log.i(MainActivity.TAG,e.getMessage());
                }
                Personnage.initialisation=true;
            }
        }).start();
    }
    public double get(int index) {
        double v=0;
        switch(index) {
            case 1:v=pv;break;
            case 2:v=degat;break;
            case 3:v=vitesse_attaque;break;
            case 4:v=vitesse_deplacement;break;
            case 5:v=regeneration_pv;break;
            case 6:v=armure;break;
            case 7:v=resistance_magique;break;
            case 8:v=pv_par_niveau;break;
            case 9:v=degat_par_niveau;break;
            case 10:v=vitesse_attaque_par_niveau;break;
            case 11:v=regeneration_des_pv_par_niveau;break;
            case 12:v=armure_par_niveau;break;
            case 13:v=resistance_magique_par_niveau;break;
        }
        return v;
    }
    public String toString() {
        String string="";
        string +="\tPV:"+this.pv+",\n";
        string +="\tDegat:"+this.degat+",\n";
        string +="\tVitesse attaque:"+this.vitesse_attaque+",\n";
        string +="\tVitesse déplacement:"+this.vitesse_deplacement+",\n";
        string +="\tRegeneration pv:"+this.regeneration_pv+",\n";
        string +="\tArmure:"+this.armure+",\n";
        string +="\tResistance_magique:"+this.resistance_magique+",\n";
        string +="\tPV par niveau:"+this.pv_par_niveau+",\n";
        string +="\tDegat par niveau:"+this.degat_par_niveau+",\n";
        string +="\tVitesse attaque par niveau:"+this.vitesse_attaque_par_niveau+",\n";
        string +="\tRegeneration des pv par niveau:"+this.regeneration_des_pv_par_niveau+",\n";
        string +="\tArmure par niveau:"+this.armure_par_niveau+",\n";
        string +="\tResistance magique par niveau:"+this.resistance_magique_par_niveau+"\n";
        return string;
    }
}
