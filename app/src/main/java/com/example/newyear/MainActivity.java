package com.example.newyear;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private AudioPlayer mPlayer = new 	AudioPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPlayer.play(this);
    }
    public class AudioPlayer {
        private MediaPlayer mPlayer;

        public void stop() {
            if (mPlayer != null) {
                mPlayer.release();
                mPlayer = null;
            }
        }
        public void play(Context c){

            MediaPlayer mPlayer = MediaPlayer.create(c, R.raw.frank);

            mPlayer.setOnCompletionListener ( new MediaPlayer.OnCompletionListener() {
                public void onCompletion(MediaPlayer mp) {
                    stop();
                }
           });
            mPlayer.start();

        }
    }
}