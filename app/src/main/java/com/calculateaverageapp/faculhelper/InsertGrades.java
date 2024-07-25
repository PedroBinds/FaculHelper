package com.calculateaverageapp.faculhelper;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.calculateaverageapp.faculhelper.Domain.Discipline;
import com.calculateaverageapp.faculhelper.Repository.Repository;

import java.util.Objects;

public class InsertGrades extends AppCompatActivity {

    private final Repository repository;
    private Integer gradeValue = 0;
    private Integer gradeValueDecimals = 0;
    private Double weightValue = 1.0;

    public InsertGrades() {
        repository = Repository.getInstance();
    }

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.insert_grades);

        String discipline = getIntent().getStringExtra("discipline");
        Discipline selectedDiscipline = repository.getDisciplineByName(discipline);

        Button addGrade = findViewById(R.id.addGradeButton);
        NumberPicker numberPickerGrade = findViewById(R.id.numberPickerGrade);
        NumberPicker numberPickerGradeDecimals = findViewById(R.id.numberPickerGradeDecimals);
        NumberPicker numberPickerWeight = findViewById(R.id.numberPickerWeight);

        numberPickerWeight.setMinValue(1);
        numberPickerWeight.setMaxValue(100);

        numberPickerGrade.setMinValue(0);
        numberPickerGrade.setMaxValue(20);

        numberPickerGradeDecimals.setMinValue(0);
        numberPickerGradeDecimals.setMaxValue(9);

        numberPickerGrade.setOnValueChangedListener((numberPicker, oldValue, newValue) -> gradeValue = newValue);

        numberPickerGradeDecimals.setOnValueChangedListener((numberPicker, oldValue, newValue) -> gradeValueDecimals = newValue);

        numberPickerWeight.setOnValueChangedListener((numberPicker, oldValue, newValue) -> weightValue = (double) newValue);

        addGrade.setOnClickListener(view -> {
            try {
                Double grade = (double) gradeValue + gradeValueDecimals % 10;
                if (repository.addGrade(selectedDiscipline.getName(), grade, weightValue)) {
                    Toast.makeText(InsertGrades.this, "Grade inserted with success", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(InsertGrades.this, "Total weight must be less than 100%", Toast.LENGTH_SHORT).show();
                    Toast.makeText(InsertGrades.this, "Grades must be between 0.0 and 20.0", Toast.LENGTH_SHORT).show();
                    Toast.makeText(InsertGrades.this, "Number of evaluations exceeded", Toast.LENGTH_SHORT).show();
                }
            } catch (NumberFormatException e) {
                Toast.makeText(InsertGrades.this, "Please enter valid fields", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
