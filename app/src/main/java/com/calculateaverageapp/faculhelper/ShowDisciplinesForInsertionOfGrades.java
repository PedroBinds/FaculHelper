package com.calculateaverageapp.faculhelper;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.calculateaverageapp.faculhelper.Domain.Discipline;
import com.calculateaverageapp.faculhelper.Repository.Repository;

import java.util.Objects;

public class ShowDisciplinesForInsertionOfGrades extends AppCompatActivity implements SelectListener {

    private final Repository repository;

    public ShowDisciplinesForInsertionOfGrades(){
        repository = Repository.getInstance();
    }

    @Override
    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.show_disciplines_for_insertion_of_grades);

        if (repository.getDisciplinesBySemester().isEmpty()) {
            Toast.makeText(this, "There are no disciplines inserted", Toast.LENGTH_SHORT).show();
            finish();
        }

        RecyclerView recyclerView = findViewById(R.id.recyclerViewInsertGrades);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new NewAdapter(getApplicationContext(), repository.getDisciplinesBySemester(), this));
    }

    @Override
    public void onItemClicked(Discipline discipline) {
        Intent intent = new Intent(getApplicationContext(), InsertGrades.class);
        intent.putExtra("discipline", discipline.getName());
        startActivity(intent);
    }
}