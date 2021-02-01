/*
    Команда:
        1. Бачаев Ахмед Зеудинович, ученик
        2. Мустафаев Зильбухар Шахидович, ученик

    Руководитель:
        1. Магомадов Джабраил Ризванович, преподаватель по МР,
           сертифицированный преподаватель IT школы Samsung
 */


package com.example.timemachine;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class MainActivity extends AppCompatActivity {

    private TextView tvData;

    private ImageView imageView;

    private ImageButton buttonFuture;
    private ImageButton buttonPast;

    private MediaPlayer mediaPlayerFuture = new MediaPlayer();
    private MediaPlayer mediaPlayerPast = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.getDefaultNightMode());

        tvData = (TextView) findViewById(R.id.textViewData);

        imageView = (ImageView) findViewById(R.id.iv);

        buttonFuture = (ImageButton) findViewById(R.id.imageButtonFuture);
        buttonPast = (ImageButton) findViewById(R.id.imageButtonPast);

        imageView.setBackgroundResource(R.drawable.time);

    }

    public void onClickFuture(View view) {
        if (mediaPlayerPast.isPlaying())
            mediaPlayerPast.pause();

        if (!mediaPlayerFuture.isPlaying()) {
            mediaPlayerFuture = MediaPlayer.create(this, R.raw.newgrozny);
            mediaPlayerFuture.start();
            mediaPlayerFuture.setLooping(false);
        }

        int randomDataFuture = (int) (1 + Math.random() * 3);

        switch (randomDataFuture) {
            case 1:
                imageView.setBackgroundResource(R.drawable.time2020);
                tvData.setText("2020");
                break;
            case 2:
                imageView.setBackgroundResource(R.drawable.time2030);
                tvData.setText("2030");
                break;
            case 3:
                imageView.setBackgroundResource(R.drawable.time2040);
                tvData.setText("2040");
                break;
        }
    }

    public void onClickPast(View view) {
        if (mediaPlayerFuture.isPlaying())
            mediaPlayerFuture.pause();

        if (!mediaPlayerPast.isPlaying()) {
            mediaPlayerPast = MediaPlayer.create(this, R.raw.oldgrozny);
            mediaPlayerPast.start();
            mediaPlayerPast.setLooping(false);
        }

        int randomDataPast = (int) (1 + Math.random() * 5);

        switch (randomDataPast) {
            case 1:
                imageView.setBackgroundResource(R.drawable.time1970);
                tvData.setText("1970");
                break;
            case 2:
                imageView.setBackgroundResource(R.drawable.time1980);
                tvData.setText("1980");
                break;
            case 3:
                imageView.setBackgroundResource(R.drawable.time1990);
                tvData.setText("1990");
                break;
            case 4:
                imageView.setBackgroundResource(R.drawable.time2000);
                tvData.setText("2000");
                break;
            case 5:
                imageView.setBackgroundResource(R.drawable.time1020);
                tvData.setText("2010");
                break;
        }
    }

    @Override
    protected void onPause() {
        mediaPlayerPast.stop();
        mediaPlayerFuture.stop();
        super.onPause();
    }
}