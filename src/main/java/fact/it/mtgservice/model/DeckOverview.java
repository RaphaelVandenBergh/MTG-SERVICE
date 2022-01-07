package fact.it.mtgservice.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeckOverview {
    private String deckname;
    private String author;
    private String[] cards;
    private String colors;
    private String type;
    private int cost;
    private List<Card> cardList;

    public DeckOverview(String deckname, String author, String[] cards, String colors, String type, int cost, List<Card> cardList) {
        this.deckname = deckname;
        this.author = author;
        this.cards = cards;
        this.colors = colors;
        this.type = type;
        this.cost = cost;
        this.cardList = cardList;
    }

    public String getDeckname() {
        return deckname;
    }

    public void setDeckname(String deckname) {
        this.deckname = deckname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String[] getCards() {
        return cards;
    }

    public void setCards(String[] cards) {
        this.cards = cards;
    }

    public String getColors() {
        return colors;
    }

    public void setColors(String colors) {
        this.colors = colors;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public List<Card> getCardList() {
        return cardList;
    }

    public void setCardList(List<Card> cardList) {
        this.cardList = cardList;
    }
}
