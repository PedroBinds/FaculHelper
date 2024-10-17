package com.calculateaverageapp.faculhelper;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NewViewHolder extends RecyclerView.ViewHolder {

    TextView textView;
    RelativeLayout relativeLayout;
    RelativeLayout background;

    public NewViewHolder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.disciplineNameRemove);
        relativeLayout = itemView.findViewById(R.id.relativeLayoutRemove);
        background = itemView.findViewById(R.id.backgroundDividerSimple);
    }
}
