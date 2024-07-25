package com.calculateaverageapp.faculhelper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.calculateaverageapp.faculhelper.Domain.Discipline;

import java.util.List;

public class AdapterShowDisciplines extends RecyclerView.Adapter<ViewHolderShowDisciplines> {

    private final Context context;
    private final List<Discipline> disciplines;
    private final SelectListener listener;

    public AdapterShowDisciplines(Context context, List<Discipline> disciplines, SelectListener listener) {
        this.context = context;
        this.disciplines = disciplines;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolderShowDisciplines onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolderShowDisciplines(LayoutInflater.from(context).inflate(R.layout.detailed_discipline_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderShowDisciplines holder, int position) {
        Discipline discipline = disciplines.get(position);
        holder.name.setText(discipline.getName());
        String message = "Final Grade: " + discipline.getFinalGrade() + " -> " + discipline.getCredits() + " ETS";
        holder.details.setText(message);
        holder.relativeLayout.setOnClickListener(view -> listener.onItemClicked(discipline));
    }

    @Override
    public int getItemCount() {
        return disciplines.size();
    }
}
