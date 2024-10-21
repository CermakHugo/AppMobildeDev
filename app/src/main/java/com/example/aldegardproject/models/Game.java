package com.example.aldegardproject.models;

import static java.lang.Math.abs;

import com.example.aldegardproject.GameDifficulty;
import com.example.aldegardproject.models.cards.Card;
import com.example.aldegardproject.models.cards.EconomyCard;
import com.example.aldegardproject.models.cards.FaithCard;
import com.example.aldegardproject.models.cards.MilitaryCard;
import com.example.aldegardproject.models.cards.SatisfactionCard;
import com.example.aldegardproject.models.characteristics.Characteristic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    private King currentKing;

    private final GameDifficulty gameDifficulty;
    private final List<FaithCard> allFaithCard = new ArrayList<>();
    private final List<MilitaryCard> allMilitaryCard = new ArrayList<>();
    private final List<EconomyCard> allEconomyCard = new ArrayList<>();
    private final List<SatisfactionCard> allSatisfactionCard = new ArrayList<>();
    private final List<Card> allCard = new ArrayList<>();
    private int currentDays = 0;
    private final List<Card> cardsForTheDays = new ArrayList<>();

    private Card currentCard;
    private final Random random = new Random(27062002);

    public Game(GameDifficulty difficulty) {
        initFaithCards();
        initMilitaryCards();
        initEconomyCards();
        initSatisfactionCards();
        gameDifficulty = difficulty;
    }

    public void initFaithCards() {
        allCard.addAll(allFaithCard);
    }

    public void initMilitaryCards() {
        allCard.addAll(allMilitaryCard);
    }

    public void initEconomyCards() {
        allCard.addAll(allEconomyCard);
    }

    public void initSatisfactionCards() {
        allCard.addAll(allSatisfactionCard);
    }

    public void startGame(){
        currentKing = new King("FanDeCroco", "Lord Aldegard III");
        startNewDay();
    }

    public void endGame(){

    }

    public void endDay(){
        updateWeightOfCard();
        startNewDay();
    }

    public void startNewDay(){
        currentDays++;
        if(isNewMonth()){
            for (Characteristic characteristic : currentKing.getCharacteristics()) {
                characteristic.setIsDisgrace(false);
            }
        }
        addFaithCardForDays(random.nextInt(currentDays+1));
        addMilitaryCardForDays(random.nextInt(currentDays+1));
        addEconomyCardForDays(random.nextInt(currentDays+1));
        addSatisfactionCardForDays(random.nextInt(currentDays+1));
        nextCard();
    }

    public void acceptCurrentCard(){
        currentCard.acceptCard(currentKing);
        nextCard();
    }

    public void refuseCurrentCard(){
        currentCard.refuseCard(currentKing);
        nextCard();
    }

    public void nextCard(){
        if(!IsLoose()){
            cardsForTheDays.remove(currentCard);
            if(!cardsForTheDays.isEmpty()){
                int index = random.nextInt(cardsForTheDays.size());
                currentCard = cardsForTheDays.get(index);
            } else {
                endDay();
            }
        } else {
            endGame();
        }
    }

    public boolean IsLoose(){
        boolean isLoose = false;
        switch(gameDifficulty){
            case EASY:
                for (Characteristic characteristic : currentKing.getCharacteristics()) {
                    if(characteristic.isDisgrace() && characteristic.getValue() <= characteristic.getMinValue()){
                        isLoose = true;
                        break;
                    }
                }
                break;
            case MEDIUM:
                for (Characteristic characteristic : currentKing.getCharacteristics()) {
                    if(characteristic.getValue() <= characteristic.getMinValue()){
                        isLoose = true;
                        break;
                    }
                }
                break;
            case HARD:
                for (Characteristic characteristic : currentKing.getCharacteristics()) {
                    if(characteristic.getValue() <= characteristic.getMinValue() || characteristic.getValue() >= characteristic.getMaxValue() ){
                        isLoose = true;
                        break;
                    }
                }
                break;
        }
        return isLoose;
    }

    public boolean isNewMonth(){
        return currentDays % 30 == 0;
    }

    public void updateWeightOfCard(){
        int newOptimalValue = currentKing.getDevelopment().getValue() + currentKing.getLuck().getValue()/10;
        for (Card card: allCard) {
            card.setWeight(abs(card.getWeight() - newOptimalValue));
        }
    }

    public void addFaithCardForDays(int numberOfCard){
        for (int i = 0; i<numberOfCard ; i++){
            cardsForTheDays.add(selectFaithCardInList());
        }
    }

    public void addMilitaryCardForDays(int numberOfCard){
        for (int i = 0; i<numberOfCard ; i++){
            cardsForTheDays.add(selectMilitaryCardInList());
        }
    }

    public void addEconomyCardForDays(int numberOfCard){
        for (int i = 0; i<numberOfCard ; i++){
            cardsForTheDays.add(selectEconomyCardInList());
        }
    }

    public void addSatisfactionCardForDays(int numberOfCard){
        for (int i = 0; i < numberOfCard ; i++){
            cardsForTheDays.add(selectSatisfactionCardInList());
        }
    }

    public FaithCard selectFaithCardInList() {
        int maxIndex = 0;
        for (FaithCard faithCard : allFaithCard) {
            maxIndex += faithCard.getWeight();
        }
        int weightValue = random.nextInt(maxIndex - 1);
        int selectedCardIndex = 0;

        while (weightValue > 0) {
            int currentCardWeight = allFaithCard.get(selectedCardIndex).getWeight();
            if (currentCardWeight > weightValue) {
                selectedCardIndex++;
            }
            weightValue -= currentCardWeight;

        }
        return allFaithCard.get(selectedCardIndex);
    }

    public MilitaryCard selectMilitaryCardInList() {
        int maxIndex = 0;
        for (MilitaryCard militaryCard : allMilitaryCard) {
            maxIndex += militaryCard.getWeight();
        }
        int weightValue = random.nextInt(maxIndex - 1);
        int selectedCardIndex = 0;

        while (weightValue > 0) {
            int currentCardWeight = allMilitaryCard.get(selectedCardIndex).getWeight();
            if (currentCardWeight > weightValue) {
                selectedCardIndex++;
            }
            weightValue -= currentCardWeight;

        }
        return allMilitaryCard.get(selectedCardIndex);
    }

    public EconomyCard selectEconomyCardInList() {
        int maxIndex = 0;
        for (EconomyCard economyCard : allEconomyCard) {
            maxIndex += economyCard.getWeight();
        }
        int weightValue = random.nextInt(maxIndex - 1);
        int selectedCardIndex = 0;

        while (weightValue > 0) {
            int currentCardWeight = allEconomyCard.get(selectedCardIndex).getWeight();
            if (currentCardWeight > weightValue) {
                selectedCardIndex++;
            }
            weightValue -= currentCardWeight;

        }
        return allEconomyCard.get(selectedCardIndex);
    }

    public SatisfactionCard selectSatisfactionCardInList() {
        int maxIndex = 0;
        for (SatisfactionCard satisfactionCard : allSatisfactionCard) {
            maxIndex += satisfactionCard.getWeight();
        }
        int weightValue = random.nextInt(maxIndex - 1);
        int selectedCardIndex = 0;

        while (weightValue > 0) {
            int currentCardWeight = allSatisfactionCard.get(selectedCardIndex).getWeight();
            if (currentCardWeight > weightValue) {
                selectedCardIndex++;
            }
            weightValue -= currentCardWeight;

        }
        return allSatisfactionCard.get(selectedCardIndex);
    }
}
