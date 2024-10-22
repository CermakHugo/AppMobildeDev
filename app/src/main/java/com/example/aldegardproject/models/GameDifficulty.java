package com.example.aldegardproject.models;

import java.io.Serializable;

public enum GameDifficulty implements Serializable {


    EASY(1, "Easy"),
    MEDIUM(2, "Normal"),
    HARD(4, "Hard");

    private final int scoreBonus;
    private final String name;

    GameDifficulty(int scoreBonus, String name) {
        this.scoreBonus = scoreBonus;
        this.name = name;
    }

    public int getScoreBonus(){
        return this.scoreBonus;
    }

}
