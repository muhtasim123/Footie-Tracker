package com.example.footietracker;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

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



        //Toast toast = Toast.makeText(getApplicationContext(), name, Toast.LENGTH_SHORT);
       // toast.show();


        switch(name){
            case "English Premier League":
                getTable(2);
                break;
            case "Spanish La Liga":
                break;
            case "German Bundesliga":
                break;
            case "French Ligue 1":
                getTable(4);
                break;
            case "Italian Serie A":
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + name);
        }
    }

    public void getTable(int id){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://server1.api-football.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        FootballApi footballApi = retrofit.create(FootballApi.class);

        Call<List<Standings>> call = footballApi.getStandings(id);

        call.enqueue(new Callback<List<Standings>>() {
            @Override
            public void onResponse(Call<List<Standings>> call, Response<List<Standings>> response) {
                if (!response.isSuccessful()){
                    Toast toast = Toast.makeText(getApplicationContext(), "Code: " + response.code(), Toast.LENGTH_LONG);
                    toast.show();
                }

                List<Standings> standings = response.body();

                for (Standings standing : standings){
                    String positionSet = "";
                    String teamNameSet = "";
                    String pointsSet = "";
                    String winsSet = "";
                    String lossesSet = "";
                    String drawsSet = "";

                    positionSet += standing.getRank() + "\n";
                    teamNameSet += standing.getTeamName() + "\n";
                    pointsSet += standing.getPoints() + "\n";
                    winsSet += standing.getAll().getWins() + "\n";
                    lossesSet += standing.getAll().getLose() + "\n";
                    drawsSet += standing.getAll().getDraw() + "\n";

                    position.append(positionSet);
                    teamName.append(teamNameSet);
                    points.append(pointsSet);
                    wins.append(winsSet);
                    losses.append(lossesSet);
                    draws.append(drawsSet);
                }
            }

            @Override
            public void onFailure(Call<List<Standings>> call, Throwable t) {
                Toast toast = Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }
}
