package com.example.aldegardproject.models;

import java.io.Serializable;

public enum GameDifficulty implements Serializable {

    EASY(1, "Easy"),
    MEDIUM(2, "Normal"),
    HARD(4, "Hard");

    GameDifficulty(int scoreBonus, String name) {

    }
}
