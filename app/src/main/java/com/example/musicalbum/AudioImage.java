package com.example.musicalbum;

import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AudioImage extends AppCompatActivity {

    MediaPlayer mp = new MediaPlayer();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.audio_image);

        setTitle("노래재생");
        Intent it = getIntent();
        String tag = it.getStringExtra("it_tag");

        TextView title = findViewById(R.id.title);
        ImageView song_image = findViewById(R.id.song_image);
        TextView lyrics = findViewById(R.id.lyrics);

        int stringId;
        String mkKey;
        Resources res = getResources();
        stringId = res.getIdentifier("title"+tag,"string", getPackageName());
        //mkKey = res.getString(stringID);
        title.setText(stringId);

        stringId = res.getIdentifier("song_image"+tag,"string",getPackageName());
        mkKey = res.getString(stringId);
        int imageId = res.getIdentifier(mkKey,"drawable",getPackageName());
        song_image.setImageResource(imageId);

        stringId = res.getIdentifier("lyrics"+tag,"string",getPackageName());
        lyrics.setText(stringId);

        stringId = res.getIdentifier("audio"+tag,"string",getPackageName());
        mkKey = res.getString(stringId);
        int audioId = res.getIdentifier(mkKey,"raw",getPackageName());

        mp = MediaPlayer.create(this, audioId);
        mp.setLooping(false);
        mp.start();


    }

    public void goBack(View view) {
        if (mp.isPlaying()) {
            mp.stop();
            mp.release();
        }
        finish();
    }
}
