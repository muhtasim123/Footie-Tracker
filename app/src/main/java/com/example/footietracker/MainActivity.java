package com.example.footietracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void leagueButton(View v){
        Intent intent = new Intent(this, LeagueActivity.class);
        startActivity(intent);
    }

    public void teamButton(View v){
        Intent intent = new Intent(this, TeamActivity.class);
        startActivity(intent);
    }

    public void playerButton(View v){
        Intent intent = new Intent(this, PlayerActivity.class);
        startActivity(intent);
    }

    public void favouriteButton(View v){
        Intent intent = new Intent(this, FavouriteActivity.class);
        startActivity(intent);
    }
}
