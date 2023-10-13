package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Emp {
    private int id;
    private String name;
    private int age;
    private double salary;

    public Emp(int id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public Emp() {
    }

    public static List<Emp> getEmployees(){
        List<Emp> list = new ArrayList<>();

        list.add(new Emp(1001, "马化腾", 34, 6000.38));
        list.add(new Emp(1002, "马云", 12, 9876.12));
        list.add(new Emp(1002, "刘强东", 33, 3000.82));
        list.add(new Emp(1002, "雷军", 26, 7657.37));
        list.add(new Emp(1002, "李彦宏", 65, 5555.32));
        list.add(new Emp(1006, "比尔盖茨", 42, 9500.43));
        list.add(new Emp(1006, "任正非", 26, 4333.32));
        list.add(new Emp(1006, "扎克伯格", 35, 2500.32));
        return list;
    }

    @Override
    public String toString() {
        return "Emp{" + "id=" + id + ",name=" + name + ",age=" + age + ",salary=" + salary + "}";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
