package com.example.footietracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class LeagueActivity extends AppCompatActivity {

    Spinner spinner;
    TextView position, teamName, points, wins, losses, draws;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_league);
        spinner = (Spinner) findViewById(R.id.leagueSpinner);
        position = (TextView) findViewById(R.id.positionResultTextView);
        teamName = (TextView) findViewById(R.id.teamNameResultTextView);
        points = (TextView) findViewById(R.id.pointsResultTextView);
        wins = (TextView) findViewById(R.id.winsResultTextView);
        losses = (TextView) findViewById(R.id.lossesResultTextView);
        draws = (TextView) findViewById(R.id.drawsResultsTextView);
    }

    public void goHome(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void submit(View v){
        position.setText("");
        teamName.setText("");
        points.setText("");
        wins.setText("");
        losses.setText("");
        draws.setText("");

        String name = "";
        if(spinner != null && spinner.getSelectedItem() !=null ) {
            name = (String)spinner.getSelectedItem();
        } else  {
            Toast toast = Toast.makeText(getApplicationContext(), "No league selected!", Toast.LENGTH_SHORT);
            toast.show();
        }

        Toast toast = Toast.makeText(getApplicationContext(), name, Toast.LENGTH_SHORT);
        toast.show();
        
        switch(name){
            case "English Premier League":
                break;
            case "Spanish La Liga":
                break;
            case "German Bundesliga":
                break;
            case "French Ligue 1":
                break;
            case "Italian Serie A":
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + name);
        }
    }
}
