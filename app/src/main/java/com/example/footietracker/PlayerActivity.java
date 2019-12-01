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
    TextView playerName, team, position, age, number, nationality, goals, assists, shotAccuracy, passAccuracy;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        spinner = (Spinner) findViewById(R.id.playerSpinner);
        image = (ImageView) findViewById(R.id.imageView2);
        playerName = (TextView) findViewById(R.id.playerNameTextView);
        team = (TextView) findViewById(R.id.teamPlayedForTextView);
        position = (TextView) findViewById(R.id.positionTextView);
        age = (TextView) findViewById(R.id.ageTextView);
        number = (TextView) findViewById(R.id.numberTextView);
        nationality = (TextView) findViewById(R.id.nationalityTextView);
        goals = (TextView) findViewById(R.id.goalsTextView);
        assists = (TextView) findViewById(R.id.assistsTextView);
        shotAccuracy = (TextView) findViewById(R.id.shotAccuracyTextView);
        passAccuracy = (TextView) findViewById(R.id.passAccuracyTextView);

    }

    public void goHome(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void submit(View v){
        image.setImageResource(0);
        playerName.setText("");
        team.setText("");
        position.setText("");
        age.setText("");
        number.setText("");
        nationality.setText("");
        goals.setText("");
        assists.setText("");
        shotAccuracy.setText("");
        passAccuracy.setText("");

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
                team.setText("FC Barcelona");
                position.setText("Forward");
                age.setText("32");
                number.setText("10");
                nationality.setText("Argentine");
                goals.setText("36");
                assists.setText("14");
                shotAccuracy.setText("62%");
                passAccuracy.setText("81%");
                break;
            case "Cristiano Ronaldo":
                image.setImageResource(R.drawable.cristianoronaldo);
                playerName.setText(name);
                team.setText("Juventus");
                position.setText("Forward");
                age.setText("34");
                number.setText("7");
                nationality.setText("Portuguese");
                goals.setText("21");
                assists.setText("9");
                shotAccuracy.setText("52%");
                passAccuracy.setText("85%");
                break;
            case "Neymar Da Silva":
                image.setImageResource(R.drawable.neymardasilva);
                playerName.setText(name);
                team.setText("Paris St. Germain");
                position.setText("Forward");
                age.setText("27");
                number.setText("10");
                nationality.setText("Brazilian");
                goals.setText("15");
                assists.setText("7");
                shotAccuracy.setText("62%");
                passAccuracy.setText("81%");
                break;
            case "Kylian Mbappe":
                image.setImageResource(R.drawable.kylianmbappe);
                playerName.setText(name);
                team.setText("Paris St. Germain");
                position.setText("Forward");
                age.setText("20");
                number.setText("7");
                nationality.setText("French");
                goals.setText("33");
                assists.setText("7");
                shotAccuracy.setText("67%");
                passAccuracy.setText("79%");
                break;
            case "Frankie De Jong":
                image.setImageResource(R.drawable.frankiedejong);
                playerName.setText(name);
                team.setText("FC Barcelona");
                position.setText("Midfielder");
                age.setText("22");
                number.setText("21");
                nationality.setText("Dutch");
                goals.setText("1");
                assists.setText("2");
                shotAccuracy.setText("100%");
                passAccuracy.setText("93%");
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + name);
        }
    }
}
