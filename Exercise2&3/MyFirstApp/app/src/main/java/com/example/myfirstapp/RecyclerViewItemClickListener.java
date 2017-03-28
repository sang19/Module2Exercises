package com.example.myfirstapp;

import android.view.View;

/**
 * Created by macuser on 2017-03-21.
 */

public interface RecyclerViewItemClickListener {
    public void onClick(View view, int position);

    public void onLongClick(View view, int position);
}