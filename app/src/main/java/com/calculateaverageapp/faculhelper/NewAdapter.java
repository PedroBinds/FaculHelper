package com.calculateaverageapp.faculhelper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.calculateaverageapp.faculhelper.Domain.Discipline;

import java.util.List;

public class NewAdapter extends RecyclerView.Adapter<NewViewHolder> {

    private final Context context;
    private final List<Discipline> disciplines;
    private final SelectListener listener;

    public NewAdapter(Context context, List<Discipline> disciplines, SelectListener listener) {
        this.context = context;
        this.disciplines = disciplines;
        this.listener = listener;
    }

    @NonNull
    @Override
    public NewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NewViewHolder(LayoutInflater.from(context).inflate(R.layout.discipline_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull NewViewHolder holder, int position) {
        holder.textView.setText(disciplines.get(position).getName());

        holder.relativeLayout.setOnClickListener(view -> listener.onItemClicked(disciplines.get(position)));
    }

    @Override
    public int getItemCount() {
        return disciplines.size();
    }
}
