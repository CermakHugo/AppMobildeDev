package com.example.aldegardproject.models.cards;

public class EconomyCard extends Card{
    public EconomyCard(String title, String description, int[] bonus) {
        this.title = title;
        this.description = description;
        for (int i = 0; i < bonusCharacteristics.length - 1; i++) {
            bonusCharacteristics[i] = bonus[i];
        }
    }
}
