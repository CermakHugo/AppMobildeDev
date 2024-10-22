package com.example.aldegardproject.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aldegardproject.R;

public class CreateGameController extends AppCompatActivity {

    private final Intent intent = new Intent(this, GameActivity.class);

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        getDelegate();
        setContentView(R.layout.layout_game);
        startActivity(intent);
    }

    public void enterYourName(){

    }

    public void chooseDifficulty(){
        setContentView(R.layout.layout_choose_difficulty_game);
        RadioGroup chosenDifficultyGroup = findViewById(R.id.difficulty_choice);
        RadioButton easyButton = findViewById(R.id.easyRadioButton);
        RadioButton mediumButton = findViewById(R.id.mediumRadioButton);
        RadioButton hardButton = findViewById(R.id.hardRadioButton);
        int chosenDifficultyButtonId = chosenDifficultyGroup.getCheckedRadioButtonId();
        switch (chosenDifficultyButtonId){
            case R.id.easyRadioButton :
                break;
            case R.id.mediumRadioButton :
                break;
            case R.id.hardRadioButton :
                break;
        }

    }
}
