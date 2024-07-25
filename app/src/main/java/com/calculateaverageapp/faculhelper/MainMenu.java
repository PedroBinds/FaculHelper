package com.calculateaverageapp.faculhelper;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.calculateaverageapp.faculhelper.Repository.Repository;
import com.calculateaverageapp.faculhelper.Utils.Bootstrap;
import com.calculateaverageapp.faculhelper.Utils.Utils;

import java.util.Objects;

public class MainMenu extends AppCompatActivity {

    private final Repository repository;
    private final Bootstrap bootstrap;
    private final Utils utils = new Utils();
    private int counter;

    private TextView average;
    private TextView ets;

    public MainMenu() {
        repository = Repository.getInstance();
        bootstrap = new Bootstrap();
        counter = 0;
    }

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.main_menu);

        Button preData = findViewById(R.id.preData);
        Button insertDiscipline = findViewById(R.id.insertDiscipline);
        Button removeDiscipline = findViewById(R.id.removeDiscipline);
        Button insertGrade = findViewById(R.id.insertGrade);
        Button showDisciplines = findViewById(R.id.showDisciplines);
        Button saveData = findViewById(R.id.saveButton);
        Button cleanAllData = findViewById(R.id.cleanData);

        average = findViewById(R.id.average);
        ets = findViewById(R.id.totalCredits);

        utils.loadData(getApplicationContext());

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        preData.setOnClickListener(view -> {
            bootstrap.loadPreDefinedData();
            onResume();
        });

        insertDiscipline.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(), InsertDiscipline.class));
            onResume();
        });

        removeDiscipline.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(), RemoveDiscipline.class));
            onResume();
        });

        insertGrade.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(), ShowDisciplinesForInsertionOfGrades.class));
            onResume();
        });

        showDisciplines.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(), ShowDisciplines.class));
            onResume();
        });

        saveData.setOnClickListener(view ->   {
            Toast.makeText(this, "Saved All Data", Toast.LENGTH_SHORT).show();
            onResume();
        });

        cleanAllData.setOnClickListener(view -> {
            counter++;
            if (counter == 2) {
                repository.cleanAllData();
                counter = 0;
                Toast.makeText(getApplicationContext(), "Cleaned All Data", Toast.LENGTH_SHORT).show();
                onResume();
            }
        });

    }

    @Override
    protected void onResume(){
        super.onResume();
        utils.saveData(getApplicationContext());
        average.setText(String.valueOf(repository.getAverage()));
        String totalEts = repository.getTotalCredits() + "ETS";
        ets.setText(totalEts);
        counter = 0;
    }
}
