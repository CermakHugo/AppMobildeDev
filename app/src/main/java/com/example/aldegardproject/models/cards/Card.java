package com.example.aldegardproject.models.cards;

import com.example.aldegardproject.models.King;
import com.example.aldegardproject.models.characteristics.Characteristic;

import java.io.Serializable;

public abstract class Card implements Serializable {
    public String getTitle() {
        return title;
    }

    protected String title;

    public String getDescription() {
        return description;
    }

    public boolean isConstantCard() {
        return isConstantCard;
    }

    protected String description;
    protected boolean isConstantCard;
    protected int optimalValue;
    protected int weight;
    // {FaithBonus , MilitaryBonus, EconomyBonus, SatisfactionBonus, DevelopmentBonus, LuckBonus }
    final int[] bonusCharacteristics = new int[6];

    public Card(String title, String description, int[] bonus, int optimalValue, boolean isConstantCard){
        this.title = title;
        this.description = description;
        if (bonusCharacteristics.length - 1 >= 0)
            System.arraycopy(bonus, 0, bonusCharacteristics, 0, bonusCharacteristics.length - 1);
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
