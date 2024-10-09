package com.example.aldegardproject.models.characteristics;

public class Characteristic {
    private final String name;
    private int value;

    private final int minValue = 0;
    private final int maxValue = 100;

    public Characteristic(String name){
        this.name = name;
        value = 50;
    }

    public void changeValue(int addValue) {
        this.value += addValue;
    }
}
