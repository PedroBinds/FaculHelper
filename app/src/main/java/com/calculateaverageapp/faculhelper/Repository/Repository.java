package com.calculateaverageapp.faculhelper.Repository;


import com.calculateaverageapp.faculhelper.Criteria.CompareByGrade;
import com.calculateaverageapp.faculhelper.Criteria.CompareBySemester;
import com.calculateaverageapp.faculhelper.Criteria.CompareByYear;
import com.calculateaverageapp.faculhelper.Domain.Discipline;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Repository {
    private static final Repository instance = new Repository();
    private HashMap<String, Discipline> grades;

    public Repository() {
        this.grades = new HashMap<>();
    }

    public static Repository getInstance() {
        return instance;
    }

    public Integer getTotalCredits() {
        Integer totalCredits = 0;
        for (Discipline aux : grades.values()) {
            if (aux.getFinalGrade() != null)
                if (aux.getFinalGrade() > 9)
                    totalCredits += aux.getCredits();
        }
        return totalCredits;
    }

    public Double getAverage() {
        double sum = 0;
        for (Discipline aux : grades.values()) {
            if (aux.getFinalGrade() != null)
                if (aux.getFinalGrade() > 9)
                    sum += aux.getFinalGrade() * ((double) aux.getCredits() / getTotalCredits());
        }
        return Math.round(sum * 100.0) / 100.0;
    }

    public boolean addDiscipline(String name, Integer credits, Integer semester, Integer year, Integer numEvaluations) {
        if (grades.containsKey(name)) return false;
        Discipline aux = createDiscipline(name, credits, semester, year, numEvaluations);
        grades.put(name, aux);
        return true;
    }

    public Discipline createDiscipline(String name, Integer credits, Integer semester, Integer year, Integer numEvaluations) {
        return new Discipline(name, credits, semester, year, numEvaluations);
    }

    public boolean removeDiscipline(String name) {
        if (!grades.containsKey(name)) return false;
        grades.remove(name);
        return true;
    }

    public void cleanAllData() {
        this.grades.clear();
    }

    public void setDisciplines(HashMap<String, Discipline> grades) {
        if (grades == null) {
            this.grades = new HashMap<>();
        } else {
            this.grades = new HashMap<>(grades);
        }
    }

    public HashMap<String, Discipline> getDisciplines() {
        return this.grades;
    }

    public List<Discipline> getDisciplinesBySemester() {
        CompareByGrade compareByGrade = new CompareByGrade();
        CompareBySemester compareBySemester = new CompareBySemester();
        CompareByYear compareByYear = new CompareByYear();
        List<Discipline> disciplines = new ArrayList<>(grades.values());
        disciplines.sort(compareByGrade);
        disciplines.sort(compareBySemester);
        disciplines.sort(compareByYear);

        return disciplines;
    }

    public boolean addGrade(String name, Double grade, Double weight) {
        if (!grades.containsKey(name)) return false;
        Discipline aux = grades.get(name);
        assert aux != null;
        return aux.addEvaluation(grade, weight);
    }

    public void initializeList() {
        this.grades = new HashMap<>();
    }

    public Discipline getDisciplineByName(String discipline) {
        for (Discipline aux : grades.values()){
            if(aux.getName().equals(discipline)) {
                return aux;
            }
        }
        return null;
    }
}
