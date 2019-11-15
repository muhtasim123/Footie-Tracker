package com.example.footietracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class PlayerActivity extends AppCompatActivity {

    Spinner spinner;
    TextView playerName, team;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        spinner = (Spinner) findViewById(R.id.playerSpinner);
        image = (ImageView) findViewById(R.id.imageView2);
        playerName = (TextView) findViewById(R.id.playerNameTextView);
        team = (TextView) findViewById(R.id.teamPlayedForTextView);
    }

    public void goHome(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void submit(View v){
        image.setImageResource(0);
        playerName.setText("");

        String name = "";
        if(spinner != null && spinner.getSelectedItem() !=null ) {
            name = (String)spinner.getSelectedItem();
        } else  {
            Toast toast = Toast.makeText(getApplicationContext(), "No player selected!", Toast.LENGTH_SHORT);
            toast.show();
        }

        Toast toast = Toast.makeText(getApplicationContext(), name, Toast.LENGTH_SHORT);
        toast.show();

        switch(name){
            case "Lionel Messi":
                image.setImageResource(R.drawable.lionelmessi);
                playerName.setText(name);
                break;
            case "Cristiano Ronaldo":
                image.setImageResource(R.drawable.cristianoronaldo);
                playerName.setText(name);
                break;
            case "Neymar Da Silva":
                image.setImageResource(R.drawable.neymardasilva);
                playerName.setText(name);
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
