package com.calculateaverageapp.faculhelper;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.calculateaverageapp.faculhelper.Repository.Repository;

import java.util.Objects;

public class InsertDiscipline extends AppCompatActivity {
    private final Repository repository;

    private EditText name;
    private EditText credits;
    private EditText year;
    private EditText semester;
    private EditText numEval;

    private String disciplineName;
    private Integer disciplineCredits;
    private Integer disciplineYear;
    private Integer disciplineSemester;
    private Integer disciplineEvaluations;

    public InsertDiscipline() {
        this.repository = Repository.getInstance();
    }

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.insert_discipline);

        name = findViewById(R.id.nameDiscipline);
        credits = findViewById(R.id.creditsDiscipline);
        year = findViewById(R.id.yearDiscipline);
        semester = findViewById(R.id.semesterDiscipline);
        numEval = findViewById(R.id.evaluationsDiscipline);

        Button insert = findViewById(R.id.addDiscipline);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        insert.setOnClickListener(view -> {
            try {
                receiveInputs();
                repository.addDiscipline(disciplineName, disciplineCredits, disciplineSemester, disciplineYear, disciplineEvaluations);
                Toast.makeText(getApplicationContext(), "Discipline \"" + disciplineName + "\" insert with success!", Toast.LENGTH_SHORT).show();
                finish();
            } catch (NullPointerException | NumberFormatException e) {
                Toast.makeText(getApplicationContext(), "Please, fill all the fields!", Toast.LENGTH_SHORT).show();
            } catch (IllegalArgumentException e) {
                Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void receiveInputs() {
        disciplineName = name.getText().toString();
        disciplineCredits = Integer.parseInt(credits.getText().toString());
        disciplineYear = Integer.parseInt(year.getText().toString());
        disciplineSemester = Integer.parseInt(semester.getText().toString());
        disciplineEvaluations = Integer.parseInt(numEval.getText().toString());
    }
}
