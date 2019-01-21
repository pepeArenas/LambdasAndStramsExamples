package com.ns.training.streams;

import java.util.StringJoiner;

public class School {
    private String name;
    private SchoolType type;

    public School(String name, SchoolType type) {
        this.name = name;
        this.type = type;
    }

    public SchoolType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", School.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("type=" + type)
                .toString();
    }
}
