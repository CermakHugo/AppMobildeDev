package com.example.aldegardproject.models.characteristics;

public abstract class Characteristic {
    protected final String name;
    protected int value;

    protected final int minValue = 0;
    protected final int maxValue = 100;

    public Characteristic(String name){
        this.name = name;
        value = 50;
    }

    public void addValue(int addValue) {
        {
            this.value += addValue;
        }
    }
}
