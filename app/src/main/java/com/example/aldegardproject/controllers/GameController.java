package com.example.aldegardproject.controllers;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aldegardproject.MainActivity;
import com.example.aldegardproject.R;
import com.example.aldegardproject.models.Game;
import com.example.aldegardproject.models.cards.Card;

import java.util.Objects;


public class GameController extends AppCompatActivity {
    private Game game;
    private Intent intent;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        getDelegate();

        getIntent().getExtras();
        setContentView(R.layout.layout_game);

        intent = getIntent();
        game = Objects.requireNonNull(intent.getExtras()).getSerializable("game", Game.class);

        initGame();
        updateProgressBar();
        initButtons();

    }


    public void initGame(){
        TextView titleName = findViewById(R.id.NameText);
        titleName.setText(game.getCurrentKing().getName());
        game.startGame();
        Card currentCard = game.getCurrentCard();
        TextView requestText =  findViewById(R.id.RequestText);
        requestText.setText(currentCard.getDescription());
    }

    public void initButtons(){
        Button acceptButton = findViewById(R.id.AcceptButton);
        Button refuseButton = findViewById(R.id.RefuseButton);

        acceptButton.setOnClickListener(e ->{
            if(!game.IsLoose()){
                game.acceptCurrentCard();
                updateUI();
            } else {
                endGame();
            }

        });

        refuseButton.setOnClickListener(e->{
            if(!game.IsLoose()){
                game.refuseCurrentCard();
                updateUI();
            } else {
                endGame();
            }

        });
    }

    public void updateProgressBar(){
        ProgressBar faithBar = findViewById(R.id.FaithBar);
        ProgressBar militaryBar = findViewById(R.id.MilitaryBar);
        ProgressBar economyBar = findViewById(R.id.EconomyBar);
        ProgressBar satisfactionBar = findViewById(R.id.SatisfactionBar);

        faithBar.setProgress(game.getCurrentKing().getFaith().getValue());
        militaryBar.setProgress(game.getCurrentKing().getMilitary().getValue());
        economyBar.setProgress(game.getCurrentKing().getEconomy().getValue());
        satisfactionBar.setProgress(game.getCurrentKing().getSatisfaction().getValue());
    }

    public void updateUI(){
        updateRequestText();
        updateDayText();
        updateProgressBar();
    }

    public void updateRequestText(){
        Card currentCard = game.getCurrentCard();
        TextView requestText =  findViewById(R.id.RequestText);
        requestText.setText(currentCard.getDescription());
    }

    public void updateDayText(){
        TextView dayText = findViewById(R.id.dayInt);
        int newDay = game.getCurrentDays();
        dayText.setText("" + newDay);
    }

    public void endGame(){
        Intent intent = new Intent(this, MainActivity.class);
        int bonus = ( 1 + game.getGameDifficulty().getScoreBonus()) ;
        int score = game.getCurrentDays() * bonus;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage( getString(R.string.defeat) + "\n"
                        + getString(R.string.maxDay) +" "+ game.getCurrentDays() + " " + getString(R.string.day)+  "\n"
                        + getString(R.string.score) + " " + score )
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(intent);
                        dialog.dismiss();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();


    }

}
