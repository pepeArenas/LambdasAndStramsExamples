package com.ns.training.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SchoolMapFilter {

    public static void main(String[] args) {
        List<School> schools = new ArrayList<>();
        schools.add(new School("Republica de Haiti", SchoolType.VIRTUL));
        schools.add(new School("Prepa 3", SchoolType.CAMPUS));
        schools.add(new School("TESOEM", SchoolType.VIRTUL));
        schools.add(new School("UTEC", SchoolType.CAMPUS));
        schools.add(new School("TEC Milenio", SchoolType.CAMPUS));

        Predicate<School> filterByType = schoolType -> schoolType.getType() == SchoolType.CAMPUS;

        schools.stream()
                .filter(filterByType)
                .forEach(System.out::println);
    }
}
