package com.team.aaa450.cricketscorekeeper;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

        EditText mainScreenTotalOvers ;
        EditText mainScreenTotalPlayers ;
        TextView mainScreenTotalPlayersView ;
        Button mainsScreenSubmitButton ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);


            mainScreenTotalOvers = (EditText) findViewById(R.id.mainScreenTotalNumberOfOvers);
            mainScreenTotalPlayers = (EditText) findViewById(R.id.mainScreenTotalNumberOfPlayers);
            mainScreenTotalPlayersView = (TextView) findViewById(R.id.mainScreenTotalPlayers);
            mainsScreenSubmitButton = (Button) findViewById(R.id.mainScreenSubmitButton);






        mainsScreenSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int teamLimit = Integer.parseInt(mainScreenTotalPlayers.getText().toString());
                int overLimit = Integer.parseInt(mainScreenTotalOvers.getText().toString());

                if (mainScreenTotalOvers.getText() == null) {
                    Toast.makeText(MainActivity.this, "\"Overs\" cannot be empty",
                            Toast.LENGTH_LONG).show();
                    /*
                    Doesn't work
                     */

                }
                else if(containsCharacters(mainScreenTotalOvers.getText().toString())){
                    Toast.makeText(MainActivity.this, "I can only read numbers in the \"Overs\" field !!!",
                            Toast.LENGTH_LONG).show();
                    /*
                    Doesn't work
                     */
                }
                else if(overLimit<1 || overLimit>50){
                    if(overLimit<1){
                        Toast.makeText(MainActivity.this, "You cannot have less than 1 overs in a game",
                                Toast.LENGTH_LONG).show();
                    }
                    else{
                        Toast.makeText(MainActivity.this, "This match will never end ! Please reduce total Number of overs",
                                Toast.LENGTH_LONG).show();
                    }
                }
                else if (mainScreenTotalPlayers.getText() == null){
                    Toast.makeText(MainActivity.this, "\"Players\" cannot be empty",
                            Toast.LENGTH_LONG).show();
                    /*
                    Doesn't work
                     */
                }
                else if(containsCharacters(mainScreenTotalPlayers.getText().toString())){
                    Toast.makeText(MainActivity.this, "Please input numbers only in \"Players\" field",
                            Toast.LENGTH_LONG).show();
                    /*
                    Doesn't work
                     */
                }
                else if(teamLimit<2 || teamLimit>11){
                    if(teamLimit <2){
                        Toast.makeText(MainActivity.this, "A team cannot have less than 2 players !!",
                                Toast.LENGTH_LONG).show();
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Too big team size !",
                                Toast.LENGTH_LONG).show();
                    }
                }
                else{
                    Intent intent = new Intent(getApplicationContext(), MatchProgress.class);
                    startActivity(intent);
                    MatchProgress.teamLimit = teamLimit;
                    MatchProgress.overLimit = overLimit;
                }
            }
        });


    }

    public boolean containsCharacters(String s){
        String pattern= "^[a-zA-Z]*$";
        if(s.matches(pattern)){
            return true;
        }
        return false;
    }



}

