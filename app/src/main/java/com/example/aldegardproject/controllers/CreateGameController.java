package com.example.aldegardproject.controllers;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aldegardproject.R;
import com.example.aldegardproject.models.Game;
import com.example.aldegardproject.models.GameDifficulty;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class CreateGameController extends AppCompatActivity {

    private Intent intent;
    private final Game game = new Game();

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        intent = new Intent(this, GameActivity.class);
        getDelegate();
        enterYourName();
    }

    public void enterYourName(){
        setContentView(R.layout.layout_choose_username);
        TextInputLayout usernameChooser = findViewById(R.id.usernameChooser);

        Button continueButton = findViewById(R.id.continue_button);

        continueButton.setOnClickListener(e->{
            String username = String.valueOf(Objects.requireNonNull(usernameChooser.getEditText()).getText());
            game.getCurrentKing().setName(username);
            chooseDifficulty();
        });
    }

    public void chooseDifficulty(){
        setContentView(R.layout.layout_choose_difficulty_game);
        RadioGroup chosenDifficultyGroup = findViewById(R.id.difficulty_choice);

        int easyButtonId = R.id.easyRadioButton;
        int mediumButtonId = R.id.mediumRadioButton;

        Button continueButton = findViewById(R.id.continue_button);

        continueButton.setOnClickListener(e->{
            GameDifficulty difficulty;
            int chosenDifficultyButtonId = chosenDifficultyGroup.getCheckedRadioButtonId();

            if(chosenDifficultyButtonId == easyButtonId){
                difficulty = GameDifficulty.EASY;
            } else if (chosenDifficultyButtonId == mediumButtonId) {
                difficulty = GameDifficulty.MEDIUM;
            } else {
                difficulty = GameDifficulty.HARD;
            }
            game.setGameDifficulty(difficulty);
            intent.putExtra("game", game);
            startActivity(intent);
        });

    }
}
