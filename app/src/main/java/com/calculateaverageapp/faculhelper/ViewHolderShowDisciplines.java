package com.calculateaverageapp.faculhelper;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolderShowDisciplines extends RecyclerView.ViewHolder {
    TextView name;
    TextView details;
    RelativeLayout relativeLayout;

    public ViewHolderShowDisciplines(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.disciplineNameShow);
        details = itemView.findViewById(R.id.disciplineInfoShow);
        relativeLayout = itemView.findViewById(R.id.relativeLayoutShow);
    }
}
