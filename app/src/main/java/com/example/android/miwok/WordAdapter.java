package com.example.android.miwok;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    private int mColorResourceId;

    public WordAdapter(Context context, ArrayList<Word> words, int mColorResourceId) {
        super(context, 0, words);
        this.mColorResourceId = mColorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Word currentWordsFlavor = getItem(position);

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }


        TextView mMiwokNameTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        mMiwokNameTextView.setText(currentWordsFlavor.getMiwokTranslation());

        TextView mDefaultNameTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        mDefaultNameTextView.setText(currentWordsFlavor.getDefaultTranslation());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        if (currentWordsFlavor.hasImage()) {
            imageView.setImageResource(currentWordsFlavor.getmImageResourceID());
        } else {
            imageView.setVisibility(View.GONE);
        }

        View textContainer = listItemView.findViewById(R.id.text_container);
//      get the color from the mColorResourceID entered
        int color = ContextCompat.getColor(getContext(), mColorResourceId);

        textContainer.setBackgroundColor(color);

        return listItemView;
    }
}
