package com.example.android.footballcounter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText nameField;
    EditText nameFieldB;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameField = (EditText) findViewById(R.id.name_field);
        nameFieldB = (EditText) findViewById(R.id.name_field_b);



        Button openp = (Button) findViewById(R.id.open_second_p);


        openp.setOnClickListener(new View.OnClickListener()
        {
            // The code in this method will be called when the numbers view is clicked on.
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, Main2Activity.class);
                String message = nameField.getText().toString();
                myIntent.putExtra("message_key",message);
                String messageTwo= nameFieldB.getText().toString();
                myIntent.putExtra("message_key_do",messageTwo);
                startActivity(myIntent);
            }

        });
    }
}
