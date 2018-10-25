package com.example.ehill.musicalstructureapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Views
    private Button mNowPlayingButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();

        // Create demo books
        final ArrayList<Audiobook> audiobooks = new ArrayList<>();
        for (int i = 0; i < 1; i++) {

            audiobooks.add(new Audiobook(getString(R.string.hp1), getString(R.string.author),
                    R.drawable.hp1, "8:33:36"));
            audiobooks.add(new Audiobook(getString(R.string.hp2), getString(R.string.author),
                    R.drawable.hp2, "9:24:27"));
            audiobooks.add(new Audiobook(getString(R.string.hp3), getString(R.string.author),
                    R.drawable.hp3, "12:15:12"));
            audiobooks.add(new Audiobook(getString(R.string.hp4), getString(R.string.author),
                    R.drawable.hp4, "21:12:42"));
            audiobooks.add(new Audiobook(getString(R.string.hp5), getString(R.string.author),
                    R.drawable.hp5, "27:02:31"));
            audiobooks.add(new Audiobook(getString(R.string.hp6), getString(R.string.author),
                    R.drawable.hp6, "18:56:02"));
            audiobooks.add(new Audiobook(getString(R.string.hp7), getString(R.string.author),
                    R.drawable.hp7, "21:36:11"));

        }

        // Create custom adapter and attached it to the GridView
        AudiobookAdapter audiobookAdapter = new AudiobookAdapter(this, audiobooks);
        GridView list = findViewById(R.id.bookList);
        list.setAdapter(audiobookAdapter);

        // Setting click listener to each items in the GridView
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Creates an intent and puts the information inside it from the item in the arrayList
                Intent intent = new Intent(MainActivity.this, NowPlaying.class);
                intent.putExtra(BookInformation.NOW_PLAYING, false);
                intent.putExtra(BookInformation.BOOK_TITLE, audiobooks.get(position).getTitle());
                intent.putExtra(BookInformation.BOOK_DURATION, audiobooks.get(position).getDuration());
                intent.putExtra(BookInformation.BOOK_COVER, audiobooks.get(position).getImageResourceId());
                startActivity(intent);
            }
        });

        // Setting click listener to the button Listen Now
        mNowPlayingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NowPlaying.class);
                intent.putExtra(BookInformation.NOW_PLAYING, true);
                startActivity(intent);
            }
        });

    }

    private void findViews() {
        mNowPlayingButton = findViewById(R.id.nowPlaying);
    }

}
