package com.calculateaverageapp.faculhelper.Domain;

import androidx.annotation.NonNull;

public class Evaluation {
    private final Integer id;
    private final Double grade;
    private final Double weight;
    private final Double percentage;

    public Evaluation(Integer id, Double grade, Double weight) {
        if (grade < 0 || grade > 20)
            throw new IllegalArgumentException("Grade must be between 0 and 20");
        if (weight < 0 || weight > 100)
            throw new IllegalArgumentException("Weight must be between 0 and 100");
        this.id = id;
        this.grade = grade;
        this.weight = weight;
        this.percentage = grade * weight / 100.0;
    }

    public Integer getId() {
        return id;
    }

    public Double getWeight() {
        return weight;
    }

    public Double getPercentage() {
        return percentage;
    }

    @NonNull
    @Override
    public String toString() {
        return "Evaluation" + "id=" + id + ", weight=" + weight + ", grade=" + grade + "\n";
    }
}

