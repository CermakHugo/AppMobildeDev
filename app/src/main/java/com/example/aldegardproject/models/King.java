package com.example.aldegardproject.models;

import com.example.aldegardproject.models.characteristics.Characteristic;
import com.example.aldegardproject.models.characteristics.PublicCharacteristic;
import com.example.aldegardproject.models.characteristics.SecretCharacteristic;

public class King {

    private final String username;
    private final String name;
    private final PublicCharacteristic faith = new PublicCharacteristic("Faith");
    private final PublicCharacteristic military = new PublicCharacteristic("Military");
    private final PublicCharacteristic economy = new PublicCharacteristic("Economy");
    private final PublicCharacteristic satisfaction = new PublicCharacteristic("Satisfaction");
    private final SecretCharacteristic development = new SecretCharacteristic("Development");
    private final SecretCharacteristic luck = new SecretCharacteristic("Luck");
    private final Characteristic[] characteristics = {faith, military, economy, satisfaction, development, luck};
    private int maxDays = 0;

    public King(String username, String name){
        this.username = username;
        this.name = name;
    }

    public PublicCharacteristic getFaith() {
        return faith;
    }

    public PublicCharacteristic getMilitary() {
        return military;
    }

    public PublicCharacteristic getEconomy() {
        return economy;
    }

    public PublicCharacteristic getSatisfaction() {
        return satisfaction;
    }

    public SecretCharacteristic getDevelopment() {
        return development;
    }

    public SecretCharacteristic getLuck() {
        return luck;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public Characteristic[] getCharacteristics() {
        return characteristics;
    }

    public int getMaxDays() {
        return maxDays;
    }

    public void setMaxDays(int newMaxDays){
        this.maxDays = newMaxDays;
    }
}
