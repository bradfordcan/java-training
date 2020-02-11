package com.cdv.training.creational.builder;

/**
 * The concrete builder classes follow the builder interface and provide specific implementations of the building steps.
 */
public class StudentBuilder implements Builder {

    private int id;
    private String name;

    public StudentBuilder() {
    }

    public StudentBuilder(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public StudentBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public StudentBuilder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public Student build() {
        return new Student(id, name);
    }

}
