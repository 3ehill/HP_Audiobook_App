package com.example.ehill.musicalstructureapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AudiobookAdapter extends ArrayAdapter<Audiobook> {

    public AudiobookAdapter(@NonNull Context context, @NonNull List<Audiobook> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (convertView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.item_list, parent, false);
        }

        // Get object located at the position in the list
        Audiobook currentAudiobook = getItem(position);
        ImageView bookCoverImageView = listItemView.findViewById(R.id.bookCoverImgView);
        TextView bookTitleTextView = listItemView.findViewById(R.id.bookTitleTextView);
        TextView bookAuthorTextView = listItemView.findViewById(R.id.authorTextView);

        // for the item clicked set to the correct values
        bookCoverImageView.setImageResource(currentAudiobook.getImageResourceId());
        bookTitleTextView.setText(currentAudiobook.getTitle());
        bookAuthorTextView.setText(currentAudiobook.getAuthor());

        return listItemView;
    }

}
