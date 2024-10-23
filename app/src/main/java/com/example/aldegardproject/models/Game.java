package com.example.aldegardproject.models;

import static java.lang.Math.abs;

import com.example.aldegardproject.models.cards.Card;
import com.example.aldegardproject.models.cards.EconomyCard;
import com.example.aldegardproject.models.cards.FaithCard;
import com.example.aldegardproject.models.cards.MilitaryCard;
import com.example.aldegardproject.models.cards.SatisfactionCard;
import com.example.aldegardproject.models.characteristics.Characteristic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game implements Serializable {


    private King currentKing;
    private GameDifficulty gameDifficulty;
    private final List<FaithCard> allFaithCard = new ArrayList<>();
    private final List<MilitaryCard> allMilitaryCard = new ArrayList<>();
    private final List<EconomyCard> allEconomyCard = new ArrayList<>();
    private final List<SatisfactionCard> allSatisfactionCard = new ArrayList<>();
    private final List<Card> allCard = new ArrayList<>();
    private int currentDays = 0;
    private final List<Card> cardsForTheDays = new ArrayList<>();

    private Card currentCard;
    private final Random random = new Random(27062002);

    public Game() {
        initFaithCards();
        initMilitaryCards();
        initEconomyCards();
        initSatisfactionCards();
        currentKing = new King();
    }

    public void initFaithCards() {
        allFaithCard.add(new FaithCard("Nouvelle Église", "Construire une nouvelle église pour le clergé", new int[]{8, 0, -8, 0, 4, 0}, 44, false));
        allFaithCard.add(new FaithCard("Guerre Sainte", "Envoyer vos soldats en croisade pour propager votre religion", new int[]{4, -2, 0, 0, 0, 0}, 55, false));
        allFaithCard.add(new FaithCard("Sorcière !", "Une femme est accusé de sorcellerie, l\'église propose de la brûler au bûcher publique", new int[]{6, 0, 0, 4, -4, 0}, 70, false));
        allFaithCard.add(new FaithCard("Quête Sainte", "Demander à vos soldats d\'aller chercher une relique sacrée", new int[]{12, 0, 8, 0, 4, 0}, 1, false));
        allFaithCard.add(new FaithCard("Pacte", "Un homme vous propose un pacte, plus d\'argent contre quelque civil", new int[]{-12, 0, 14, -4, 0, 0}, 88, false));
        allFaithCard.add(new FaithCard("Nouvelle École", "L\'église vous demande de construire une nouvelle école pour pouvoir éduquer la population", new int[]{6, 0, -14, 4, 10, 0}, 36, false));
        allFaithCard.add(new FaithCard("Hérésie", "Un homme viens vous présenter une nouvelle découverte qui va à l\'encontre de l\'église, pendons-le sur la place publique", new int[]{10, 0, 0, 4, -10, 0}, 38, false));
        allFaithCard.add(new FaithCard("Plus de Croisade", "L\'église vous demande de recruter plus de Soldat pour leurs croisade", new int[]{6, 4, -4, 0, 0, 0}, 56, false));
        allFaithCard.add(new FaithCard("Prophète", "Un homme se présente comme messager de dieu, l\'accueillir ?", new int[]{14, 0, -4, 0, 0, 0}, 31, false));
        allFaithCard.add(new FaithCard("Don", "Voulez-vous faire un don pour l\'église", new int[]{2, 0, -2, 0, 0, 0}, 9, false));
        allFaithCard.add(new FaithCard("Sacrement", "Faîte vous élire roi par dieu", new int[]{16, 0, 0, 8, 6, 0}, 3, false));
        allFaithCard.add(new FaithCard("Fête Religieuse", "L\'église veux faire une fête religieuse", new int[]{4, 0, -4, 4, 0, 0}, 74, false));
        allFaithCard.add(new FaithCard("Païens", "Des païens se sont installé dans votre royaume, l\'église vous demande de les chasser", new int[]{6, 0, 0, -4, 0, 0}, 30, false));
        allFaithCard.add(new FaithCard("Indépendance", "L\'église demande de reconnaître l\'indépendance des tribunaux ecclésiastiques pour juger les affaires relevant de la morale et de la discipline ecclésiastique.", new int[]{8, 0, 0, -2, 0, 0}, 87, false));
        allFaithCard.add(new FaithCard("Censure des écrits hérétiques", "L\'église demande une censure plus stricte des écrits jugés hérétiques ou subversifs pour préserver la foi.", new int[]{6, 0, 0, -8, 0, 0}, 87, false));
        allFaithCard.add(new FaithCard("Médecine", "L\'église demande l\'ouverture d\'un centre médicale pour pouvoir prédire des soins au peuple", new int[]{6, 0, -10, 0, 10, 0}, 86, false));
        allFaithCard.add(new FaithCard("Pèlerinage", "L\'église souhaite que vous incité à participer au prochain pèlerinage", new int[]{4, 0, 0, -4, 0, 0}, 53, false));
        allFaithCard.add(new FaithCard("Protection Divine", "L\'église vous demande des soldats pour protéger des site sacré", new int[]{4, 2, 0, 0, 0, 0}, 4, false));
        allFaithCard.add(new FaithCard("Influence", "L\'église demande plus d\'importance politique dans le royaume", new int[]{10, 0, 0, 0, 0, 0}, 73, false));
        allFaithCard.add(new FaithCard("Augmentation des dîmes", "L\'église demande plus d\'argent pour ce qu\'elle produit", new int[]{6, 0, -4, 0, 0, 0}, 97, false));
        allCard.addAll(allFaithCard);
    }

    public void initMilitaryCards() {
        allMilitaryCard.add(new MilitaryCard("Technologie Militaire", "Votre général demande d\'investir plus d\'argent dans la recherche de nouvelle arme", new int[]{0, 4, -10, 0, 6, 0}, 31, false));
        allMilitaryCard.add(new MilitaryCard("Espion", "Envoyer des Espions dans vos pays voisin pour obtenir des informations", new int[]{0, 2, 0, 0, 0, 0}, 29, false));
        allMilitaryCard.add(new MilitaryCard("Garde de Nuit", "Alterner vos gardes pour avoir une protection pendant 24H", new int[]{0, 8, -6, 0, 0, 0}, 16, false));
        allMilitaryCard.add(new MilitaryCard("Plus de Soldat", "Financer une meilleure armée avec plus de soldat", new int[]{0, 8, -4, 0, 0, 0}, 70, false));
        allMilitaryCard.add(new MilitaryCard("Mercenaire", "Acheter des mercenaires pour accomplir certaine mission dangereuse", new int[]{0, 2, -4, 0, 0, 0}, 47, false));
        allMilitaryCard.add(new MilitaryCard("Réduire Les Frontières", "Donner des territoires à vos ville voisine pour être sûr de pouvoir surveiller l\'intégralité de vos frontières avec vos effectif actuelle", new int[]{0, 4, 0, -6, 0, 0}, 28, false));
        allMilitaryCard.add(new MilitaryCard("Poste de Garde", "Financer de quoi rénover et réaffecter les postes de garde de vos frontières", new int[]{0, 8, -10, 0, 4, 0}, 76, false));
        allMilitaryCard.add(new MilitaryCard("10 Catapultes", "Acheter plus d\'armement e siège pour votre armé", new int[]{0, 10, -10, 0, 0, 0}, 41, false));
        allMilitaryCard.add(new MilitaryCard("Démonstration de Force", "Faite une parade militaire pour rappeler au pays voisin de la grandeur de votre armé", new int[]{0, 2, 0, 2, 0, 0}, 19, false));
        allMilitaryCard.add(new MilitaryCard("Une Légende", "Construisais une légende autour d\'un de vos chevaliers pour intimider leurs futur adversaires", new int[]{4, 4, 0, 4, 0, 0}, 16, false));
        allMilitaryCard.add(new MilitaryCard("Fédération", "Fédéré les seigneur de vos royaumes pour profiter de leurs puissance militaire", new int[]{0, 10, 0, 0, 10, 0}, 50, false));
        allMilitaryCard.add(new MilitaryCard("Protection Civil", "La population demande plus de garde dans les villes et villages pour arrêter les pillages continue", new int[]{0, 4, -6, 2, 2, 0}, 91, false));
        allMilitaryCard.add(new MilitaryCard("Logistique", "Augmenter l\'organisation au sein de l\'armée pour être plus efficace", new int[]{0, 4, 0, 0, 0, 0}, 67, false));
        allMilitaryCard.add(new MilitaryCard("Général", "Former plusieurs groupes militaires diriger par des généraux eux même diriger par vous-même", new int[]{0, 6, 0, -2, 0, 0}, 94, false));
        allMilitaryCard.add(new MilitaryCard("Chevalerie", "Les chevalier demande la réforme des ordres de chevalerie pour être plus efficace", new int[]{0, 6, 0, 2, 0, 0}, 22, false));
        allMilitaryCard.add(new MilitaryCard("Sorcellerie", "Les généraux demande l\'intervention d\'un enchanteur sur les champs de bataille", new int[]{-4, 6, 0, 0, -4, 0}, 25, false));
        allMilitaryCard.add(new MilitaryCard("Paladin", "Les généraux ont besoin de renfort sur les champs de bataille, utilisé les paladins de l\'église pour renforcer votre armé", new int[]{4, 4, 0, 0, 0, 0}, 2, false));
        allMilitaryCard.add(new MilitaryCard("Armé Royal", "Formé un groupe de soldat d\'élite pour votre propre armé", new int[]{0, 4, 0, 2, 0, 0}, 51, false));
        allMilitaryCard.add(new MilitaryCard("Caserne", "Crée un centre de formation militaire", new int[]{0, 10, -14, 0, 6, 0}, 29, false));
        allMilitaryCard.add(new MilitaryCard("Marine", "Investir dans la puissance militaire maritime pour lutter contre la piraterie", new int[]{0, 8, -10, 0, 0, 0}, 70, false));
        allCard.addAll(allMilitaryCard);
    }

    public void initEconomyCards() {
        allEconomyCard.add(new EconomyCard("Famine", "Une famine sévit dans le sud du royaume, causant désespoir et pénurie. Le royaume devrait envoyer des ressources pour soutenir les populations touchées", new int[]{0, 0, -15, 5, 5, 0}, 90, false));
        allEconomyCard.add(new EconomyCard("Banque en Faillite", "La banque royale est au bord de la faillite, mettant en péril l\'économie. Le royaume devrait fournir un soutien financier pour la sauver", new int[]{0, 0, -10, 6, 4, 0}, 75, false));
        allEconomyCard.add(new EconomyCard("Port de Pêche Détruit", "Un port de pêche crucial a été détruit par une tempête. Il serait nécessaire de financer sa reconstruction pour relancer les activités locales", new int[]{0, 0, -10, 8, 2, 0}, 70, false));
        allEconomyCard.add(new EconomyCard("Accident de Marché", "Le principal marché du royaume a été saccagé par un incident. Il serait prudent de financer la réparation des infrastructures marchandes", new int[]{0, 0, -8, 6, 0, 0}, 67, false));
        allEconomyCard.add(new EconomyCard("Taxe sur le Commerce", "Les revenus du royaume sont insuffisants en raison des dépenses militaires. Le royaume devrait augmenter les taxes sur les marchands pour financer la trésorerie", new int[]{0, 0, 10, -8, 0, 0}, 2, false));
        allEconomyCard.add(new EconomyCard("Réduction des Taxes Marchandes", "Le commerce local est en déclin et peine à prospérer. Il faudrait réduire les taxes pour alléger les charges des marchands", new int[]{0, 0, 6, -6, 0, 0}, 51, false));
        allEconomyCard.add(new EconomyCard("Route Marchande Instable", "La principale route marchande est dangereuse en raison d\'attaques fréquentes. Le royaume devrait sécuriser la route pour rétablir le commerce", new int[]{0, 0, -8, 0, 8, 0}, 14, false));
        allEconomyCard.add(new EconomyCard("Réforme Fiscale", "Les caisses du royaume sont vides en raison de dépenses mal gérées. Une réforme fiscale permettrait d\'augmenter les recettes via une collecte plus efficace", new int[]{-5, 0, 10, -5, 0, 0}, 31, false));
        allEconomyCard.add(new EconomyCard("Exportation de Ressources", "Des ressources en surplus sont disponibles dans le royaume. Ces ressources devraient être exportées vers d\'autres royaumes pour faire entrer des fonds", new int[]{0, 0, 10, -6, -4, 0}, 31, false));
        allEconomyCard.add(new EconomyCard("Nouvelle Banque Privée", "L\'absence de banques limite les opportunités financières du royaume. Il faudrait créer une nouvelle banque privée pour stimuler l\'économie", new int[]{0, 0, 8, -4, 0, 0}, 56, false));
        allEconomyCard.add(new EconomyCard("Nouvelle Route Marchande", "Les échanges commerciaux sont limités par des infrastructures médiocres. Construire une nouvelle route marchande permettrait de relancer les échanges", new int[]{0, 0, 8, -4, 6, 0}, 42, false));
        allEconomyCard.add(new EconomyCard("Marché Saccagé", "Des bandits ont pillé un marché important, causant des pertes massives. Le royaume devrait compenser les pertes pour apaiser la population", new int[]{2, 0, -6, 4, 0, 0}, 93, false));
        allEconomyCard.add(new EconomyCard("Travaux Publics", "Les infrastructures publiques sont en état de délabrement dans certaines régions. Le royaume devrait financer des travaux publics pour restaurer ces infrastructures", new int[]{0, 0, -10, 2, 8, 0}, 73, false));
        allEconomyCard.add(new EconomyCard("Récolte Abondante", "Une récolte exceptionnelle a eu lieu cette année grâce à des conditions optimales. Le royaume devrait réinvestir ces gains pour les prochaines récoltes", new int[]{0, 0, 0, 5, 5, 0}, 54, false));
        allEconomyCard.add(new EconomyCard("Soutien aux Commerçants", "De nombreux commerçants rencontrent des difficultés à cause de taxes élevées. Il serait judicieux d\'offrir des subventions pour soutenir leur activité", new int[]{0, 0, -6, 6, 4, 0}, 67, false));
        allEconomyCard.add(new EconomyCard("Moulin à Vent", "Les terres agricoles manquent de technologie pour accroître leur rendement. Financer des moulins à vent améliorerait la productivité", new int[]{0, 0, -6, 0, 8, 0}, 20, false));
        allEconomyCard.add(new EconomyCard("Nouvel Aqueduc", "Certaines régions souffrent d\'un accès insuffisant à l\'eau potable. Construire un aqueduc améliorerait la qualité de vie et l\'agriculture", new int[]{0, 0, -10, 5, 10, 0}, 91, false));
        allEconomyCard.add(new EconomyCard("Nouvelle Foire Commerciale", "Les échanges sont en déclin, affectant le commerce local. Organiser une foire annuelle attirerait les artisans et relancerait l\'économie", new int[]{0, 0, 6, 4, -8, 0}, 76, false));
        allEconomyCard.add(new EconomyCard("Mine d\'Or Découverte", "Une nouvelle veine d\'or a été découverte dans les montagnes. Le royaume devrait investir dans son exploitation pour accroître les richesses", new int[]{0, 0, 10, -5, 5, 0}, 79, false));
        allEconomyCard.add(new EconomyCard("Croissance Commerciale", "Une période de prospérité commerciale s\'ouvre pour le royaume. Il faudrait encourager cette dynamique pour soutenir la prospérité générale", new int[]{0, 0, 10, 5, 5, 0}, 96, false));
        allCard.addAll(allEconomyCard);
    }

    public void initSatisfactionCards() {
        allSatisfactionCard.add(new SatisfactionCard("Épidémie", "Une épidémie frappe le royaume, mettant en péril la santé publique. Il faudrait organiser des soins d\'urgence pour réduire les pertes", new int[]{5, 0, -5, -10, 0, 0}, 37, false));
        allSatisfactionCard.add(new SatisfactionCard("Incendie au Village", "Un incendie a ravagé un village important, laissant de nombreuses personnes sans abri. Le royaume devrait mobiliser des ressources pour reconstruire les habitations", new int[]{2, 0, 5, -8, 0, 0}, 79, false));
        allSatisfactionCard.add(new SatisfactionCard("Théâtre en Ruine", "Un théâtre culturel a été détruit, impactant le moral des citoyens. Le royaume devrait financer sa reconstruction pour restaurer la vie culturelle", new int[]{3, 0, 2, -7, 0, 0}, 10, false));
        allSatisfactionCard.add(new SatisfactionCard("Réduction des Taxes", "Les paysans souffrent de lourdes taxes qui affectent leur qualité de vie. Il serait judicieux de réduire les taxes pour soulager le peuple", new int[]{0, 0, -6, 4, 0, 0}, 17, false));
        allSatisfactionCard.add(new SatisfactionCard("Suppression de la Corvée", "La corvée imposée aux paysans entraîne un mécontentement général. Le royaume devrait supprimer cette obligation, même si cela réduit les revenus", new int[]{-2, 0, -5, 3, 0, 0}, 40, false));
        allSatisfactionCard.add(new SatisfactionCard("Distribution de Nourriture", "Une crise alimentaire touche certaines régions. Il serait approprié de distribuer des vivres pour aider les plus démunis", new int[]{0, 0, -5, 4, 0, 0}, 6, false));
        allSatisfactionCard.add(new SatisfactionCard("Campagne de Santé Publique", "Le niveau d\'hygiène est insuffisant, causant des maladies évitables. Il faudrait lancer une campagne de prévention sanitaire pour améliorer la santé publique", new int[]{0, 0, -6, 5, 0, 0}, 50, false));
        allSatisfactionCard.add(new SatisfactionCard("Fête de la Moisson", "Une bonne récolte est une opportunité de célébration pour le peuple. Organiser une fête de la moisson augmenterait le moral général", new int[]{0, 0, -5, 4, 0, 0}, 12, false));
        allSatisfactionCard.add(new SatisfactionCard("Parc Public", "Les habitants manquent d\'espaces de loisirs et de détente. Il serait bénéfique de construire un parc public pour améliorer leur qualité de vie", new int[]{0, 0, -5, 5, 0, 0}, 91, false));
        allSatisfactionCard.add(new SatisfactionCard("Protection Contre les Bandits", "Les bandits menacent la sécurité des villages, créant une insécurité générale. Embaucher des gardes supplémentaires aiderait à protéger les citoyens", new int[]{0, 0, -6, 6, 0, 0}, 29, false));
        allSatisfactionCard.add(new SatisfactionCard("Marché de Nuit", "La demande de biens est forte, mais les horaires de marché sont limités. Organiser un marché de nuit stimulerait l\'économie locale", new int[]{0, 0, 2, 4, -3, 0}, 35, false));
        allSatisfactionCard.add(new SatisfactionCard("Nouvelle École", "L\'accès à l\'éducation est limité dans certaines régions. Construire une nouvelle école permettrait d\'instruire les jeunes générations", new int[]{0, 0, -4, 5, 4, 0}, 5, false));
        allSatisfactionCard.add(new SatisfactionCard("Hôpital Rural", "Les habitants des régions rurales n\'ont pas accès aux soins. Il serait important de construire un hôpital pour améliorer leur santé", new int[]{0, 0, -5, 6, 0, 0}, 40, false));
        allSatisfactionCard.add(new SatisfactionCard("Festival de Printemps", "Le moral de la population est bas à cause des récentes difficultés. Organiser un festival de printemps remonterait le moral des citoyens", new int[]{0, 0, -3, 4, 0, 0}, 20, false));
        allSatisfactionCard.add(new SatisfactionCard("Bains Publics", "Les conditions d\'hygiène ne sont pas optimales dans les villes. Construire des bains publics permettrait d\'améliorer la santé des habitants", new int[]{0, 0, -6, 6, 4, 0}, 95, false));
        allSatisfactionCard.add(new SatisfactionCard("Théâtre", "Les citoyens manquent d\'options de divertissement. Construire un théâtre contribuerait à la culture et au moral de la population", new int[]{0, 0, -6, 6, 4, 0}, 43, false));
        allSatisfactionCard.add(new SatisfactionCard("Réforme Paysanne", "Les paysans demandent plus de droits et d\'accès à la terre. Le royaume devrait offrir plus de droits aux paysans pour encourager leur productivité", new int[]{-2, 0, -5, 8, 0, 0}, 15, false));
        allSatisfactionCard.add(new SatisfactionCard("Fête Interdite", "Les ressources financières sont limitées en raison d\'une crise récente. Annuler une fête permettrait de réaliser des économies importantes", new int[]{1, 0, 5, -3, 0, 0}, 45, false));
        allSatisfactionCard.add(new SatisfactionCard("Subventions pour Mariages", "De nombreux couples ont du mal à se marier en raison de leurs finances. Offrir des subventions pour organiser des mariages favoriserait la cohésion sociale", new int[]{0, 0, -6, 8, 0, 0}, 82, false));
        allSatisfactionCard.add(new SatisfactionCard("Église en Ruine Restaurée", "Une ancienne église importante pour la communauté est en ruine. Restaurer cette église renforcerait la foi et l\'esprit communautaire", new int[]{10, 0, 0, 5, 5, 0}, 69, false));

        allCard.addAll(allSatisfactionCard);
    }

    public void startGame(){
        currentKing = new King();
        startNewDay();
    }

    public void endGame(){

    }

    public void endDay(){

        startNewDay();
    }

    public void startNewDay(){
        currentDays++;
        updateWeightOfCard();
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
                    else if (characteristic.getValue() <= characteristic.getMinValue()) {
                        characteristic.setIsDisgrace(true);
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
        int weightValue = random.nextInt(maxIndex);
        int selectedCardIndex = 0;

        while (weightValue > 0) {
            int currentCardWeight = allFaithCard.get(selectedCardIndex).getWeight();
            if (currentCardWeight < weightValue) {
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
        int weightValue = random.nextInt(maxIndex);
        int selectedCardIndex = 0;

        while (weightValue > 0) {
            int currentCardWeight = allMilitaryCard.get(selectedCardIndex).getWeight();
            if (currentCardWeight < weightValue) {
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
        int weightValue = random.nextInt(maxIndex);
        int selectedCardIndex = 0;

        while (weightValue > 0) {
            int currentCardWeight = allEconomyCard.get(selectedCardIndex).getWeight();
            if (currentCardWeight < weightValue) {
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
        int weightValue = random.nextInt(maxIndex);
        int selectedCardIndex = 0;

        while (weightValue > 0) {
            int currentCardWeight = allSatisfactionCard.get(selectedCardIndex).getWeight();
            if (currentCardWeight < weightValue) {
                selectedCardIndex++;
            }
            weightValue -= currentCardWeight;

        }
        return allSatisfactionCard.get(selectedCardIndex);
    }

    public Card getCurrentCard(){return currentCard;}

    public King getCurrentKing() {
        return currentKing;
    }

    public int getCurrentDays() {
        return currentDays;
    }

    public GameDifficulty getGameDifficulty() {
        return gameDifficulty;
    }

    public void setGameDifficulty(GameDifficulty gameDifficulty) {
        this.gameDifficulty = gameDifficulty;
    }
}
