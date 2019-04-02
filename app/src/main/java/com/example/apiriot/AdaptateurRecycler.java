package com.example.apiriot;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdaptateurRecycler extends RecyclerView.Adapter<AdaptateurRecycler.MyViewHolder> {
    ArrayList<String> nom;
    private OnItemClickListener listener;
    public interface OnItemClickListener{
        void click(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }
    public AdaptateurRecycler(ArrayList<String> nom){
        this.nom = nom;
    }
    public AdaptateurRecycler.MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler,viewGroup,false);
        return new MyViewHolder(view);
    }
    public void onBindViewHolder(AdaptateurRecycler.MyViewHolder myViewHolder, int i) {
        myViewHolder.display(this.nom.get(i));
    }
    public int getItemCount() {
        return this.nom.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView text;
        private ImageView image;
        public MyViewHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.Text);
            image = (ImageView) itemView.findViewById(R.id.Image);
            itemView.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    int position = getAdapterPosition();
                    listener.click(position);
                }
            });
        }
        public void display(String name){
            Picasso.with(image.getContext()).load("http://rly-chrono.fr/api/League_of_legend/image/Personnage/"+name+".png").resize(128,128).into(image);
            text.setText(name);
        }
    }
}
