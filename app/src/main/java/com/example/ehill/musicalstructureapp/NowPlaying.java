package com.example.ehill.musicalstructureapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class NowPlaying extends AppCompatActivity {

    // Views
    private Button mLibraryButton;
    private TextView mBookTitleTextView;
    private TextView mDurationTextView;
    private ImageView mBookCoverImageView;

    // objects
    private boolean isPlaying;
    private String mBookTitle;
    private String mBookDuration;
    private int mBookCoverID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        setTitle(new String("NowPlaying"));
        findViews();

        // Getting data from the intent
        Intent intent = getIntent();
        // Determine is this intent comes from "Now Playing" button, or the user clicks on book in the list.
        isPlaying = intent.getBooleanExtra(BookInformation.NOW_PLAYING, false);
        if (isPlaying) {
            // show current playing audiobook - we assume the user playing "Invisible book".
            mBookTitle = "Harry Potter and the Sorcerer's Stone";
            mBookDuration = "8:33:36";
            mBookCoverID = R.drawable.hp1;
        } else {
            // play this clicked book
            mBookTitle = intent.getStringExtra(BookInformation.BOOK_TITLE);
            mBookDuration = intent.getStringExtra(BookInformation.BOOK_DURATION);
            mBookCoverID = intent.getIntExtra(BookInformation.BOOK_COVER, 0);
        }

        // Setting data to the views
        mBookTitleTextView.setText(mBookTitle);
        mDurationTextView.setText(mBookDuration);
        mBookCoverImageView.setImageResource(mBookCoverID);

        // Setting click listener to "Back to your Library" button
        mLibraryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NowPlaying.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void findViews() {
        mLibraryButton = findViewById(R.id.libraryButton);
        mBookTitleTextView = findViewById(R.id.bookTitleTextView);
        mDurationTextView = findViewById(R.id.duration);
        mBookCoverImageView = findViewById(R.id.bookCoverImgView);
    }
}