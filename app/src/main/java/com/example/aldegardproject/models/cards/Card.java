package com.example.aldegardproject.models.cards;

import com.example.aldegardproject.models.King;
import com.example.aldegardproject.models.characteristics.Characteristic;

public abstract class Card {
    protected String title;
    protected String description;
    protected boolean isConstantCard;
    protected int optimalValue;
    protected int weight;

    final int[] bonusCharacteristics = new int[6];

    public Card(String title, String description, int[] bonus, int optimalValue, boolean isConstantCard){
        this.title = title;
        this.description = description;
        for (int i = 0; i < bonusCharacteristics.length - 1; i++) {
            bonusCharacteristics[i] = bonus[i];
        }
        this.optimalValue = optimalValue;
        this.isConstantCard = isConstantCard;
    }

    public void acceptCard(King king){
        Characteristic[] kingCharacteristics = king.getCharacteristics();
        for (int i = 0 ; i < bonusCharacteristics.length; i++){
            kingCharacteristics[i].addValue(bonusCharacteristics[i]);
        }
    }

    public void refuseCard(King king){
        Characteristic[] kingCharacteristics = king.getCharacteristics();
        for (int i = 0 ; i < bonusCharacteristics.length; i++){
            kingCharacteristics[i].addValue(-bonusCharacteristics[i]);
        }
    }

    public int getWeight(){
        return this.weight;
    }

    public void setWeight(int newWeight){
        this.weight = newWeight;
    }
}
