package com.xyrality.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Player model
 *
 * @author Oleksandr Skoryi
 */
public class Player implements Comparable<Player> {

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

    public int getPoints() {
        return points;
    }

    /**
     * Best practice doesn't recommend to get list from object, because you can still add, remove and do whatever
     * you want with list, therefore need to return copy of list which contains lottery combinations
     *
     * @return copy of lottery combination list
     */
    public List<String> getLotteryCombinations() {
        return new ArrayList<>(lotteryCombinations);
    }

    /**
     * Method set value of points after analyzing player's combinations
     *
     * @param value to set
     */
    public void increasePoints(int value) {
        this.points += value;
    }

    @Override
    public String toString() {
        return lastName + "," + firstName + "," + country + "," + points;
    }

    @Override
    public int compareTo(Player player) {
        if (!this.lastName.equals(player.lastName)) {
            return this.lastName.compareTo(player.lastName);
        }
        if (!this.firstName.equals(player.firstName)) {
            return this.firstName.compareTo(player.firstName);
        }
        return this.country.compareTo(player.country);
    }
}
