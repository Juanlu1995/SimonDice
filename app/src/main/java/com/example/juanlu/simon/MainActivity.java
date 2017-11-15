package com.example.juanlu.simon;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button green, red, yellow, blue;
    private MediaPlayer greenSound;
    private MediaPlayer redSound;
    private MediaPlayer yellowSound;
    private MediaPlayer blueSound;
    private String secuence = "";
    private boolean play = false;
    private int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        conectWidgets();
        connectEventsToWidgets();

        gameStart();
    }

    private void gameStart() {
        replaySecuence();
    }

    private void replaySecuence() {
        secuence += (int)(Math.random() * 4 + 1) + "";

        for (int i = 0; i < secuence.length(); i++) {
            switch (secuence.charAt(i)) {
                case '1':
                    new CountDownTimer(1000, 50) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                            green.setBackgroundColor(getResources().getColor(R.color.green));
                            greenSound.start();
                        }

                        @Override
                        public void onFinish() {
                            green.setBackgroundColor(getResources().getColor(R.color.softGreen));
                        }
                    }.start();
                    break;
                case '2':
                    new CountDownTimer(1000, 50) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                            red.setBackgroundColor(getResources().getColor(R.color.red));
                            redSound.start();
                        }

                        @Override
                        public void onFinish() {
                            red.setBackgroundColor(getResources().getColor(R.color.softRed));
                        }
                    }.start();
                    break;
                case '3':
                    new CountDownTimer(1000, 50) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                            yellow.setBackgroundColor(getResources().getColor(R.color.yellow));
                            yellowSound.start();
                        }

                        @Override
                        public void onFinish() {
                            yellow.setBackgroundColor(getResources().getColor(R.color.softYellow));
                        }
                    }.start();
                    break;
                case '4':
                    new CountDownTimer(1000, 50) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                            blue.setBackgroundColor(getResources().getColor(R.color.blue));
                            blueSound.start();
                        }

                        @Override
                        public void onFinish() {
                            blue.setBackgroundColor(getResources().getColor(R.color.softBlue));
                        }
                    }.start();
                    break;
                default:
                    //error
            }
        }
        Toast.makeText(this, "Te toca", Toast.LENGTH_LONG).show();
        play = true;
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
        if (play) {
            if (contador < secuence.length()) {
                if (secuence.charAt(contador) == correspondencia(v)) {
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
                    contador++;
                }else {
                    // @TODO tiene que llevar a otro layout donde diga los puntos y que ha perdido
                }
            } else {
                replaySecuence();
            }
        }
    }

    private char correspondencia(View v) {
        char num;
        switch (v.getId()) {
            case R.id.green:
                num = '1';
            break;
            case R.id.red:
                num = '2';
            break;
            case R.id.yellow:
                num = '3';
            break;
            case R.id.blue:
                num = '4';
            break;

            default:
                num = 0;
        }
        return num;
    }
}
