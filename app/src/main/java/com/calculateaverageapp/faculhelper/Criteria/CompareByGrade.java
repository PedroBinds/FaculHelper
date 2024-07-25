package com.calculateaverageapp.faculhelper.Criteria;

import com.calculateaverageapp.faculhelper.Domain.Discipline;

import java.util.Comparator;

public class CompareByGrade implements Comparator<Discipline> {
    @Override
    public int compare(Discipline o1, Discipline o2) {
        if (o1.getFinalGrade() > o2.getFinalGrade()) {
            return -1;
        } else if (o1.getFinalGrade() < o2.getFinalGrade()) {
            return 1;
        } else {
            return 0;
        }
    }
}
