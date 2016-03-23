package com.xyrality.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Player model
 *
 * @author Oleksandr Skoryi
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

    /**
     * Convert object to file format. Can be moved into util class, but it is OK to leave it here
     *
     * @return object for file writing.
     */
    public String toFileFormat() {
        return lastName + "," + firstName + "," + country + "," + points;
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
        return "Player{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", country='" + country + '\'' +
                ", lotteryCombinations=" + lotteryCombinations +
                ", points=" + points +
                '}';
    }
}
