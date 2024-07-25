package com.calculateaverageapp.faculhelper.Criteria;

import com.calculateaverageapp.faculhelper.Domain.Discipline;

import java.util.Comparator;

public class CompareBySemester implements Comparator<Discipline> {
    @Override
    public int compare(Discipline o1, Discipline o2) {
        if (o1.getSemester() > o2.getSemester()) {
            return -1;
        } else if (o1.getSemester() < o2.getSemester()) {
            return 1;
        } else {
            return 0;
        }
    }
}
