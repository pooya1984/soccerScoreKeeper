package com.example.android.footballcounter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    String message;
    String messageTwo;
    int scoreTeamA = 0;
    int scoreTeamB=0;
    int cornerTeamA = 0;
    int cornerTeamB=0;
    int redCard = 0;
    int redCardTeamB;
    int yellowCard=0;
    int yellowCardTeamB=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent mIntent = getIntent();
        message = mIntent.getStringExtra("message_key");
        messageTwo=mIntent.getStringExtra("message_key_do");


        TextView teamA = (TextView) findViewById(R.id.name_a);
        teamA.setText(message);
        TextView teamB = (TextView) findViewById(R.id.name_b);
        teamB.setText(messageTwo);
    }

    public void addOneForGoal(View view){
        scoreTeamA= scoreTeamA + 1;
        displayForTeamA(scoreTeamA);
    }

    public void addOneForCorner(View view){
        cornerTeamA= cornerTeamA + 1;
        displayForTeamACorner(cornerTeamA);
    }

    public void addOneForRedCard(View view){
        redCard= redCard + 1;
        displayForTeamACartRed(redCard);
    }

    public void addOneForYellowCard(View view){
        yellowCard= yellowCard + 1;
        displayForTeamACartYellow(yellowCard);
    }

    /**
     * Team B
     */

    public void addOneForBGoal(View view){
        scoreTeamB= scoreTeamB + 1;
        displayForTeamB(scoreTeamB);
    }

    public void addOneForBCorner(View view){
        cornerTeamB= cornerTeamB + 1;
        displayForTeamBCorner(cornerTeamB);
    }

    public void addOneForBRedCard(View view){
        redCardTeamB= redCardTeamB + 1;
        displayForTeamBCartRed(redCardTeamB);
    }

    public void addOneForBYellowCard(View view){
        yellowCardTeamB= yellowCardTeamB + 1;
        displayForTeamBCartYellow(yellowCardTeamB);
    }



    public void showResult (View view) {

        Intent myIntent = new Intent(Main2Activity.this, Main3Activity.class);
        myIntent.putExtra("score", scoreTeamA);
        myIntent.putExtra("redCard", redCard);
        myIntent.putExtra("yellowCard", yellowCard);
        myIntent.putExtra("score_b", scoreTeamB);
        myIntent.putExtra("redCardB", redCardTeamB);
        myIntent.putExtra("YelloCardB", yellowCardTeamB);
        myIntent.putExtra("message_key",message);
        myIntent.putExtra("message_key_do",messageTwo);
        startActivity(myIntent);
    }








        /**
         * Displays the given score for Team A.
         */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given corner for Team A.
     */
    public void displayForTeamACorner (int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_corner);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given Red Cart for Team A.
     */
    public void displayForTeamACartRed(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_cart_red);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given Yellow Cart for Team A.
     */
    public void displayForTeamACartYellow(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_cart_yellow);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given corner for Team B.
     */
    public void displayForTeamBCorner (int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_corner);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given Red Cart for Team B.
     */
    public void displayForTeamBCartRed(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_cart_red);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given Yellow Cart for Team B.
     */
    public void displayForTeamBCartYellow(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_cart_yellow);
        scoreView.setText(String.valueOf(score));
    }








}
