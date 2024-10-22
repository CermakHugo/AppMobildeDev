package com.example.aldegardproject.models.characteristics;

import java.io.Serializable;

public abstract class Characteristic implements Serializable {
    protected final String name;
    protected int value;

    protected boolean isDisgrace = false;

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

    public boolean isDisgrace() {
        return isDisgrace;
    }

    public void setIsDisgrace(boolean isDisgrace){
        this.isDisgrace = isDisgrace;
    }

    public int getValue() {
        return value;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public int getMinValue() {
        return minValue;
    }
}
