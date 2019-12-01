package com.example.footietracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
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
    String name;
    DatabaseHelper mySQLiteHelper;

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

        mySQLiteHelper = new DatabaseHelper(this,null,null,1);
    }

    public void goHome(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


    public void favourite(View v){
        Toast toast = Toast.makeText(getApplicationContext(), "Favourited!", Toast.LENGTH_SHORT);
        toast.show();
        String dName = teamName.getText().toString();
        String dLeague = league.getText().toString();
        String dWins = wins.getText().toString();
        String dDraws = draws.getText().toString();
        String dLosses = losses.getText().toString();
        toast = Toast.makeText(getApplicationContext(), dName, Toast.LENGTH_SHORT);
        toast.show();
        DatabaseReceiver record = new DatabaseReceiver(dName, dLeague, dWins, dDraws, dLosses);
        mySQLiteHelper.addRecord(record);
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

        name = "";
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
                league.setText("Spanish La Liga");
                matches.setText("38");
                points.setText("87");
                wins.setText("26");
                draws.setText("9");
                losses.setText("3");
                goalsFor.setText("90");
                goalsAgainst.setText("36");
                break;
            case "Real Madrid":
                image.setImageResource(R.drawable.realmadridlogo);
                teamName.setText(name);
                league.setText("Spanish La Liga");
                matches.setText("38");
                points.setText("68");
                wins.setText("21");
                draws.setText("5");
                losses.setText("12");
                goalsFor.setText("63");
                goalsAgainst.setText("46");
                break;
            case "Manchester City":
                image.setImageResource(R.drawable.manchestercitylogo);
                teamName.setText(name);
                league.setText("English Premier League");
                matches.setText("38");
                points.setText("98");
                wins.setText("32");
                draws.setText("2");
                losses.setText("4");
                goalsFor.setText("95");
                goalsAgainst.setText("23");
                break;
            case "Manchester United":
                image.setImageResource(R.drawable.manchesterunitedlogo);
                teamName.setText(name);
                league.setText("English Premier League");
                matches.setText("38");
                points.setText("66");
                wins.setText("19");
                draws.setText("9");
                losses.setText("10");
                goalsFor.setText("65");
                goalsAgainst.setText("54");
                break;
            case "Chelsea FC":
                image.setImageResource(R.drawable.chelsealogo);
                teamName.setText(name);
                league.setText("English Premier League");
                matches.setText("38");
                points.setText("66");
                wins.setText("19");
                draws.setText("9");
                losses.setText("10");
                goalsFor.setText("63");
                goalsAgainst.setText("39");
                break;
            case "Liverpool FC":
                image.setImageResource(R.drawable.liverpoollogo);
                teamName.setText(name);
                league.setText("English Premier League");
                matches.setText("38");
                points.setText("97");
                wins.setText("30");
                draws.setText("7");
                losses.setText("1");
                goalsFor.setText("89");
                goalsAgainst.setText("22");
                break;
            case "Bayern Munich":
                image.setImageResource(R.drawable.bayernmunichlogo);
                teamName.setText(name);
                league.setText("German Bundesliga");
                matches.setText("34");
                points.setText("78");
                wins.setText("24");
                draws.setText("6");
                losses.setText("4");
                goalsFor.setText("88");
                goalsAgainst.setText("32");
                break;
            case "Juventus":
                image.setImageResource(R.drawable.juventuslogo);
                teamName.setText(name);
                league.setText("Italian Serie A");
                matches.setText("38");
                points.setText("90");
                wins.setText("28");
                draws.setText("6");
                losses.setText("4");
                goalsFor.setText("70");
                goalsAgainst.setText("30");
                break;
            case "AC Milan":
                image.setImageResource(R.drawable.acmilanlogo);
                teamName.setText(name);
                league.setText("Italian Serie A");
                matches.setText("38");
                points.setText("68");
                wins.setText("19");
                draws.setText("11");
                losses.setText("8");
                goalsFor.setText("55");
                goalsAgainst.setText("36");
                break;
            case "Inter Milan":
                image.setImageResource(R.drawable.intermilanlogo);
                teamName.setText(name);
                league.setText("Italian Serie A");
                matches.setText("38");
                points.setText("69");
                wins.setText("20");
                draws.setText("9");
                losses.setText("9");
                goalsFor.setText("57");
                goalsAgainst.setText("33");
                break;
            case "Paris Saint Germain":
                image.setImageResource(R.drawable.psglogo);
                teamName.setText(name);
                league.setText("France Ligue 1");
                matches.setText("38");
                points.setText("91");
                wins.setText("29");
                draws.setText("4");
                losses.setText("5");
                goalsFor.setText("105");
                goalsAgainst.setText("35");
                break;
            case "AS Monaco":
                image.setImageResource(R.drawable.asmonacologo);
                teamName.setText(name);
                league.setText("France Ligue 1");
                matches.setText("38");
                points.setText("36");
                wins.setText("8");
                draws.setText("12");
                losses.setText("18");
                goalsFor.setText("38");
                goalsAgainst.setText("57");
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + name);
        }
    }
}
