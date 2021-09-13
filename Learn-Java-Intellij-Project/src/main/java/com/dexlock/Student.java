package com.dexlock;

public class Student {
    private String name;
    private Integer roll_number;
    private String class_name;
    private Integer marks;

    public Student(String name, int roll_number, String class_name, int marks) {
        this.name = name;
        this.roll_number = roll_number;
        this.class_name = class_name;
        this.marks = marks;
    }

    public String getName() {
        return this.name;
    }

    public String getClassName() {
        return this.class_name;
    }

    public Integer getMarks() {
        return this.marks;
    }

    public Integer getRollNumber() {
        return this.roll_number;
    }


}
