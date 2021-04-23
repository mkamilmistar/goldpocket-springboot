package com.enigma.pocket.entity;

public class Car {
    private String name;
    private String brand;
    private Engine engine;

    public Car(String name, String brand, Engine engine) {
        this.name = name;
        this.brand = brand;
        engine.setCar(this);
        this.engine = engine;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}
