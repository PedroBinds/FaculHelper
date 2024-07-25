package com.calculateaverageapp.faculhelper.Utils;


import com.calculateaverageapp.faculhelper.Repository.Repository;

public class Bootstrap {
    private final Repository repository;

    public Bootstrap() {
        this.repository = Repository.getInstance();
    }

    public void loadPreDefinedData() {
        loadFirstYear();
        loadSecondYear();
    }

    private void loadSecondYear() {
        // First Semester
        if (repository.addDiscipline("ARQCP", 5, 1, 2, 2)) {
            repository.addGrade("ARQCP", 17.32, 60.0);
            repository.addGrade("ARQCP", 12.73, 40.0);
        }

        if (repository.addDiscipline("BDDAD", 6, 1, 2, 4)) {
            repository.addGrade("BDDAD", 13.40, 20.0);
            repository.addGrade("BDDAD", 8.00, 20.0);
            repository.addGrade("BDDAD", 5.80, 20.0);
            repository.addGrade("BDDAD", 15.50, 40.0);
        }

        if (repository.addDiscipline("ESINF", 6, 1, 2, 4)) {
            repository.addGrade("ESINF", 16.00, 10.0);
            repository.addGrade("ESINF", 15.30, 20.0);
            repository.addGrade("ESINF", 15.00, 25.0);
            repository.addGrade("ESINF", 12.60, 45.0);
        }

        if (repository.addDiscipline("FSIAP", 5, 1, 2, 3)) {
            repository.addGrade("FSIAP", 15.23, 40.00);
            repository.addGrade("FSIAP", 7.80, 30.00);
            repository.addGrade("FSIAP", 10.91, 30.00);
        }

        if (repository.addDiscipline("LAPR3", 8, 1, 2, 2)) {
            repository.addGrade("LAPR3", 15.20, 30.00);
            repository.addGrade("LAPR3", 12.96, 70.00);
        }
        // Second Semester
        if (repository.addDiscipline("EAPLI", 6, 1, 2, 3)) {
            repository.addGrade("EAPLI", 16.60, 30.00);
            repository.addGrade("EAPLI", 14.10, 30.00);
            repository.addGrade("EAPLI", 15.80, 40.00);
        }

        if (repository.addDiscipline("LAPR4", 6, 1, 2, 3)) {
            repository.addGrade("LAPR4", 16.19, 15.00);
            repository.addGrade("LAPR4", 17.30, 35.00);
            repository.addGrade("LAPR4", 18.05, 50.00);
        }

        if (repository.addDiscipline("LPROG", 6, 1, 2, 2)) {
            repository.addGrade("LPROG", 12.00, 40.00);
            repository.addGrade("LPROG", 16.20, 60.00);
        }

        if (repository.addDiscipline("RCOMP", 6, 1, 2, 3)) {
            repository.addGrade("RCOMP", 18.93, 56.00);
            repository.addGrade("RCOMP", 17.67, 14.00);
            repository.addGrade("RCOMP", 12.12, 30.00);
        }

        if (repository.addDiscipline("SCOMP", 6, 1, 2, 2)) {
            repository.addGrade("SCOMP", 15.69, 40.00);
            repository.addGrade("SCOMP", 17.40, 60.00);
        }
    }

    private void loadFirstYear() {
        // First semester
        if (repository.addDiscipline("ALGAN", 5, 1, 1, 2)) {
            repository.addGrade("ALGAN", 16.1, 50.0);
            repository.addGrade("ALGAN", 9.2, 50.0);
        }
        if (repository.addDiscipline("AMATA", 5, 1, 1, 3)) {
            repository.addGrade("AMATA", 16.2, 40.0);
            repository.addGrade("AMATA", 16.1, 20.0);
            repository.addGrade("AMATA", 18.1, 40.0);
        }
        if (repository.addDiscipline("APROG", 6, 1, 1, 4)) {
            repository.addGrade("APROG", 19.0, 20.0);
            repository.addGrade("APROG", 20.0, 10.0);
            repository.addGrade("APROG", 19.5, 20.0);
            repository.addGrade("APROG", 14.9, 50.0);
        }
        if (repository.addDiscipline("PRCMP", 6, 1, 1, 2)) {
            repository.addGrade("PRCMP", 19.5, 45.0);
            repository.addGrade("PRCMP", 10.0, 55.0);
        }
        if (repository.addDiscipline("LAPR1", 8, 1, 1, 3)) {
            repository.addGrade("LAPR1", 17.8, 20.0);
            repository.addGrade("LAPR1", 19.9, 70.0);
            repository.addGrade("LAPR1", 13.8, 10.0);
        }
        // Second semester
        if (repository.addDiscipline("MATCP", 5, 2, 1, 5)) {
            repository.addGrade("MATCP", 14.58, 10.0);
            repository.addGrade("MATCP", 16.23, 10.0);
            repository.addGrade("MATCP", 18.28, 15.0);
            repository.addGrade("MATCP", 6.85, 15.0);
            repository.addGrade("MATCP", 8.7, 50.0);
        }
        if (repository.addDiscipline("MDISC", 5, 2, 1, 3)) {
            repository.addGrade("MDISC", 15.9, 40.0);
            repository.addGrade("MDISC", 17.83, 20.0);
            repository.addGrade("MDISC", 12.6, 40.0);
        }
        if (repository.addDiscipline("ESOFT", 6, 2, 1, 2)) {
            repository.addGrade("ESOFT", 18.0, 40.0);
            repository.addGrade("ESOFT", 15.0, 60.0);
        }
        if (repository.addDiscipline("PPROG", 6, 2, 1, 3)) {
            repository.addGrade("PPROG", 16.48, 25.0);
            repository.addGrade("PPROG", 17.76, 35.0);
            repository.addGrade("PPROG", 15.23, 40.0);
        }
        if (repository.addDiscipline("LAPR2", 8, 2, 1, 3)) {
            repository.addGrade("LAPR2", 17.7, 20.0);
            repository.addGrade("LAPR2", 17.2, 70.0);
            repository.addGrade("LAPR2", 16.0, 10.0);
        }
    }
}