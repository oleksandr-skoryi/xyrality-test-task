package com.xyrality.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oleksandr Skoryi on 22.03.16.
 */
public class Player {

    private String lastName;
    private String firstName;
    private String country;
    private List<String> lotteryCombinations;
    private int points;

    public Player(String lastName, String firstName, String country, List<String> lotteryCombinations) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.country = country;
        this.lotteryCombinations = lotteryCombinations;
    }

    public String toFileFormat() {
        return firstName + "," + lastName + "," + country + "," + points;
    }

    public List<String> getLotteryCombinations() {
        return new ArrayList<>(lotteryCombinations);
    }

    public void increasePoints(int value) {
        this.points += value;
    }

    @Override
    public String toString() {
        return "Player{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", country='" + country + '\'' +
                ", lotteryCombinations=" + lotteryCombinations +
                ", points=" + points +
                '}';
    }
}
