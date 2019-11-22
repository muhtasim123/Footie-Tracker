package com.example.footietracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class FavouriteActivity extends AppCompatActivity {

    DatabaseHelper mySQLiteHelper;
    ListView resultsList;
    TextView teamName, teamLeague, teamWins, teamDraws, teamLosses;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite);

        mySQLiteHelper = new DatabaseHelper(this,null,null,1);
        resultsList = (ListView) findViewById(R.id.favouritesListView);
        teamName = (TextView) findViewById(R.id.teamNameTextView);
        teamLeague = (TextView) findViewById(R.id.leagueTextView);
        teamWins = (TextView) findViewById(R.id.winsTextView);
        teamDraws = (TextView) findViewById(R.id.drawsTextView);
        teamLosses = (TextView) findViewById(R.id.lossesTextView);

        ArrayList<String> names = new ArrayList<>();
        names = mySQLiteHelper.getTeamNames();
      //  Cursor c = mySQLiteHelper.getAllRows();
        ArrayAdapter adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,names);
        resultsList.setAdapter(adapter);
        resultsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = (String) parent.getItemAtPosition(position);
                DatabaseReceiver Tname = mySQLiteHelper.getName(name);
                teamName.setText(Tname.getTeamName());
                teamLeague.setText(Tname.getLeague());
                teamWins.setText(Tname.getWins());
                teamDraws.setText(Tname.getDraws());
                teamLosses.setText(Tname.getLosses());
            }
        });

    }

    public void goHome(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
