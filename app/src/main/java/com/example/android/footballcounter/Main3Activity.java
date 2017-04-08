package com.example.android.footballcounter;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class Main3Activity extends AppCompatActivity {

    int scoreTeamA;
    int scoreTeamB;
    int yellowCard;
    int yellowCardTeamB;
    int redCard;
    int redCardTeamB;
    String message;
    String messageTwo;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Intent mIntent = getIntent();
        scoreTeamA = mIntent.getIntExtra("score", 0);
        yellowCard = mIntent.getIntExtra("yellowCard", 0);
        redCard = mIntent.getIntExtra("redCard", 0);

        scoreTeamB = mIntent.getIntExtra("score_b", 0);
        yellowCardTeamB = mIntent.getIntExtra("yellowCardB", 0);
        redCardTeamB = mIntent.getIntExtra("redCardB", 0);
        message = mIntent.getStringExtra("message_key");
        messageTwo = mIntent.getStringExtra("message_key_do");

        String ResultMessage = message + ":" + scoreTeamA + "\nRed Card: " + redCard + "\nYellow Card: "
                + yellowCard + "\nVS\n" + messageTwo + ":" + scoreTeamB + "\nRed Card: " + redCardTeamB
                + "\nYellow Card: " + yellowCardTeamB;
        displayMessage(ResultMessage);


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void mail(View view) {
        String ResultMessage = message + ":" + scoreTeamA + "\nRed Card: " + redCard + "\nYellow Card: "
                + yellowCard + "\nVS\n" + messageTwo + ":" + scoreTeamB + "\nRed Card: " + redCardTeamB
                + "\nYellow Card: " + yellowCardTeamB;
        displayMessage(ResultMessage);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Result for" + message + messageTwo);
        intent.putExtra(Intent.EXTRA_SUBJECT, ResultMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void reset(View view) {
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        switch (item.getItemId()){


            case R.id.theme_id:
                Toast.makeText(getApplicationContext(),"This App is for Football counter",Toast.LENGTH_LONG).show();
                return true;
            case R.id.share_id:
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody =  message + ":" + scoreTeamA + "\nRed Card: " + redCard + "\nYellow Card: "
                        + yellowCard + "\nVS\n" + messageTwo + ":" + scoreTeamB + "\nRed Card: " + redCardTeamB
                        + "\nYellow Card: " + yellowCardTeamB;;
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share via"));
            default:
        }
        return super.onOptionsItemSelected(item);}


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main3 Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}

