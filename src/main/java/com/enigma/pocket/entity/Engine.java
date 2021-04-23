package com.enigma.pocket.entity;


public class Engine {
    private String name;
    private Integer cc;
    private Car car;

    public Engine(String name, Integer cc) {
        this.name = name;
        this.cc = cc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCc() {
        return cc;
    }

    public void setCc(Integer cc) {
        this.cc = cc;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
