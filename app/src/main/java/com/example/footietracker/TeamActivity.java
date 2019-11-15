package com.example.footietracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class TeamActivity extends AppCompatActivity {

    Spinner spinner;
    TextView teamName, league, matches, points, wins, losses, draws, goalsFor, goalsAgainst;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);

        spinner = (Spinner) findViewById(R.id.teamSpinner);
        image = (ImageView) findViewById(R.id.teamImageView);
        teamName = (TextView) findViewById(R.id.teamNameTextView);
        league = (TextView) findViewById(R.id.leagueTextView);
        matches = (TextView) findViewById(R.id.matchesPlayedTextView);
        points = (TextView) findViewById(R.id.pointsTextView);
        wins = (TextView) findViewById(R.id.winsTextView);
        losses = (TextView) findViewById(R.id.lossesTextView);
        draws = (TextView) findViewById(R.id.drawsTextView);
        goalsFor = (TextView) findViewById(R.id.goalsForTextView);
        goalsAgainst = (TextView) findViewById(R.id.goalsAgainstTextView);
    }

    public void goHome(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void submit(View v){
        image.setImageResource(0);
        teamName.setText("");
        league.setText("");
        matches.setText("");
        points.setText("");
        wins.setText("");
        losses.setText("");
        draws.setText("");
        goalsFor.setText("");
        goalsAgainst.setText("");

        String name = "";
        if(spinner != null && spinner.getSelectedItem() !=null ) {
            name = (String)spinner.getSelectedItem();
        } else  {
            Toast toast = Toast.makeText(getApplicationContext(), "No team selected!", Toast.LENGTH_SHORT);
            toast.show();
        }

        Toast toast = Toast.makeText(getApplicationContext(), name, Toast.LENGTH_SHORT);
        toast.show();

        switch(name){
            case "FC Barcelona":
                image.setImageResource(R.drawable.barcelonalogo);
                teamName.setText(name);
                break;
            case "Real Madrid":
                image.setImageResource(R.drawable.realmadridlogo);
                teamName.setText(name);
                break;
            case "Manchester City":
                image.setImageResource(R.drawable.manchestercitylogo);
                teamName.setText(name);
                break;
            case "Manchester United":
                image.setImageResource(R.drawable.manchesterunitedlogo);
                teamName.setText(name);
                break;
            case "Chelsea FC":
                image.setImageResource(R.drawable.chelsealogo);
                teamName.setText(name);
                break;
            case "Liverpool FC":
                image.setImageResource(R.drawable.liverpoollogo);
                teamName.setText(name);
                break;
            case "Bayern Munich":
                image.setImageResource(R.drawable.bayernmunichlogo);
                teamName.setText(name);
                break;
            case "Juventus":
                image.setImageResource(R.drawable.juventuslogo);
                teamName.setText(name);
                break;
            case "AC Milan":
                image.setImageResource(R.drawable.acmilanlogo);
                teamName.setText(name);
                break;
            case "Inter Milan":
                image.setImageResource(R.drawable.intermilanlogo);
                teamName.setText(name);
                break;
            case "Paris Saint Germain":
                image.setImageResource(R.drawable.psglogo);
                teamName.setText(name);
                break;
            case "AS Monaco":
                image.setImageResource(R.drawable.asmonacologo);
                teamName.setText(name);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + name);
        }
    }
}
