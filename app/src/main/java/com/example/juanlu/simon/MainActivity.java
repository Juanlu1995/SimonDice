package com.example.juanlu.simon;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button green, red, yellow, blue;
    final private MediaPlayer greenSound = MediaPlayer.create(this, R.raw.green);
    final private MediaPlayer redSound = MediaPlayer.create(this, R.raw.red);
    final private MediaPlayer yellowSound = MediaPlayer.create(this, R.raw.yellow);
    final private MediaPlayer blueSound = MediaPlayer.create(this, R.raw.blue);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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
    }

    @Override
    public void onClick(View v) {
        Button button = (Button) v;
        switch (button.getId()) {
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
        }
    }
}
