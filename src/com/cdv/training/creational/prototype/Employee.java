package com.cdv.training.creational.prototype;

/**
* Concrete prototype
* The cloning method creates a new object and passes it to the constructor.
* Until the constructor is finished, it has a reference to a fresh clone.
* Therefore, nobody has access to a partly-built clone.
* This keeps the cloning result consistent.
*/
public class Employee implements Prototype {

    private int id;
    private String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void showRecord() {
        System.out.println(id + "\t" + name);
    }

    @Override
    public Prototype clone() {
        return new Employee(id, name);
    }

}
