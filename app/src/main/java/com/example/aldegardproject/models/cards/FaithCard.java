package com.example.aldegardproject.models.cards;

public class FaithCard extends Card{

    public FaithCard(String title, String description, int[] bonus) {
        this.title = title;
        this.description = description;
        for (int i = 0; i < bonus.length - 1; i++) {
            bonusCharacteristics[i] = bonus[i];
        }
    }
}
