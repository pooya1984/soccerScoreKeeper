package com.example.android.footballcounter;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    int scoreTeamA;
    int scoreTeamB;
    String message;
    String messageTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Intent mIntent = getIntent();
        scoreTeamA = mIntent.getIntExtra("score", 0);
        scoreTeamB = mIntent.getIntExtra("score_b", 0);
        message = mIntent.getStringExtra("message_key");
        messageTwo=mIntent.getStringExtra("message_key_do");

        String ResultMessage = message + ":" + scoreTeamA + "\nVS\n" + messageTwo + ":" + scoreTeamB;
        displayMessage(ResultMessage);


    }

    public void mail (View view){
        String ResultMessage = message + ":" + scoreTeamA + "\nVS\n" + messageTwo + ":" + scoreTeamB;
        displayMessage(ResultMessage);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Result for"+message+messageTwo);
        intent.putExtra(Intent.EXTRA_SUBJECT, ResultMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void reset (View view){
        Intent myIntent = new Intent(Main3Activity.this, MainActivity.class);
        startActivity(myIntent);
    }



    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.show_result_summary);
        orderSummaryTextView.setText(message);
    }

}
