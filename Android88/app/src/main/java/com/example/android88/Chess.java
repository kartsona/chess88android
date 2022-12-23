package com.example.android88;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Chess extends AppCompatActivity {

    Button selectPlayChess, selectWatchReplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chess);

        selectPlayChess = findViewById(R.id.selectPlayChess);
        selectWatchReplay = findViewById(R.id.selectWatchReplay);

        selectPlayChess.setOnClickListener((parent) -> playChess());
        selectWatchReplay.setOnClickListener((parent) -> playReplay());
    }


    private void playChess() {
        Intent intent = new Intent(this, com.example.android88.ChessPlay.class);
        startActivity(intent);
    }

    private void playReplay() {
        Intent intent = new Intent(this, com.example.android88.ReplayList.class);
        startActivity(intent);
    }
}