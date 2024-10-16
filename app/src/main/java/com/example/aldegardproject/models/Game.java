package com.example.aldegardproject.models;

import com.example.aldegardproject.models.cards.EconomyCard;
import com.example.aldegardproject.models.cards.FaithCard;
import com.example.aldegardproject.models.cards.MilitaryCard;
import com.example.aldegardproject.models.cards.SatisfactionCard;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    private King currentKing;
    private final List<FaithCard> allFaithCard = new ArrayList<>();
    private final List<MilitaryCard> allMilitaryCard = new ArrayList<>();
    private final List<EconomyCard> allEconomyCard = new ArrayList<>();
    private final List<SatisfactionCard> allSatisfactionCard = new ArrayList<>();
    private int currentDays;
    private final Random random = new Random(27062002);

    public Game() {
        initFaithCards();
        initMilitaryCards();
        initEconomyCards();
        initSatisfactionCards();
    }

    public void initFaithCards() {

    }

    public void initMilitaryCards() {

    }

    public void initEconomyCards() {

    }

    public void initSatisfactionCards() {

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
