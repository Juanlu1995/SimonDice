package com.example.juanlu.simon;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button green, red, yellow, blue;
    private MediaPlayer greenSound;
    private MediaPlayer redSound;
    private MediaPlayer yellowSound;
    private MediaPlayer blueSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        conectWidgets();
        connectEventsToWidgets();

    }

    private void connectEventsToWidgets() {
        green.setOnClickListener(this);
        red.setOnClickListener(this);
        yellow.setOnClickListener(this);
        blue.setOnClickListener(this);
    }


    private void conectWidgets() {
        green = findViewById(R.id.green);
        red = findViewById(R.id.red);
        yellow = findViewById(R.id.yellow);
        blue = findViewById(R.id.blue);
        greenSound = MediaPlayer.create(this, R.raw.green);
        redSound = MediaPlayer.create(this, R.raw.red);
        yellowSound = MediaPlayer.create(this, R.raw.yellow);
        blueSound = MediaPlayer.create(this, R.raw.blue);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.green:
                greenSound.start();
                break;
            case R.id.red:
                redSound.start();
                break;
            case R.id.yellow:
                yellowSound.start();
                break;
            case R.id.blue:
                blueSound.start();
                break;

                default:
                    //error
        }
    }
}
