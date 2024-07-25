package com.calculateaverageapp.faculhelper.Domain;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Discipline {
    private final String name;
    private final Integer credits;
    private Integer finalGrade;
    private final List<Evaluation> evaluations;
    private final Integer semester;
    private final Integer year;
    private final Integer numEvaluation;

    public Discipline(String name, Integer credits, Integer semester, Integer year, Integer numEvaluation) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (name.split("").length > 5) {
            throw new IllegalArgumentException("Name cannot be more than 5 characters");
        }
        if (credits < 0) {
            throw new IllegalArgumentException("Credits must be positive");
        }
        if (semester < 0) {
            throw new IllegalArgumentException("Semester must be positive");
        }
        if (year < 0) {
            throw new IllegalArgumentException("Year must be positive");
        }
        if (numEvaluation < 0) {
            throw new IllegalArgumentException("Number of evaluations must be positive");
        }
        this.name = name;
        this.credits = credits;
        this.evaluations = new ArrayList<>();
        this.semester = semester;
        this.year = year;
        this.finalGrade = 0;
        this.numEvaluation = numEvaluation;
    }

    public String getName() {
        return name;
    }

    public Integer getCredits() {
        return credits;
    }

    public Integer getFinalGrade() {
        return finalGrade;
    }

    public Integer getSemester() {
        return this.semester;
    }

    public Integer getYear() {
        return year;
    }

    public Integer getNumEvaluation() {
        return numEvaluation;
    }

    public void setFinalGrade() {
        Double finalGrade = 0.0;
        for (Evaluation evaluation : evaluations) {
            finalGrade += evaluation.getPercentage();
        }
        int aux = ((int) ((finalGrade * 100) % 100)) >= 50 ? 1 : 0;
        this.finalGrade = finalGrade.intValue() + aux;
    }

    public boolean addEvaluation(Double grade, Double weight) {
        boolean res = false;
        if(checkIfEvaluationCanBeAdded(grade, weight)) {
            res = evaluations.add(new Evaluation(evaluations.size() + 1, grade, weight));
            setFinalGrade();
        }
        return res;
    }

    private boolean checkIfEvaluationCanBeAdded(Double grade, Double weight) {
        if (this.numEvaluation <= evaluations.size()) return false;
        if (grade < 0 || grade > 20) return false;
        Double sum = 0.0;
        for (Evaluation evaluation : evaluations) {
            sum += evaluation.getWeight();
        }
        return !(sum + weight > 100);
    }

    @NonNull
    @Override
    public String toString() {
        return year + "y, " + semester + "s - " + name + " - (" + finalGrade + ") - " + credits + " credits" + " - " +
            evaluations.size() + " evaluations\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Discipline that = (Discipline) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, credits, finalGrade, semester);
    }

}
