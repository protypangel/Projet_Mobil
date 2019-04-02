package com.example.apiriot;
import android.util.Log;
public class Riot_Api {
    private String api_key;
    private String server;
    private String link;
    public Riot_Api(String server_Riot){
        this.api_key="RGAPI-0be60bbb-0f6e-4246-8e8e-151f9627ccce";
        this.server="";
        if(server_Riot=="euw"){this.server="https://euw1.api.riotgames.com";}
        this.link=this.server+"/lol/status/v3/shard-data?api_key="+this.api_key;
        Log.d("link",this.link);
    }
}
