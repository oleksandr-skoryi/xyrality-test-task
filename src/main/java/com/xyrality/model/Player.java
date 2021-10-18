package com.xyrality.model;

import java.util.Arrays;

/**
 * Player model
 *
 * @author Oleksandr Skoryi
 */
public class Player implements Comparable<Player> {

    private final String lastName;
    private final String firstName;
    private final String country;
    private final String[] lotteryCombinations;
    private int points;

    public Player(
            final String lastName,
            final String firstName,
            final String country,
            final String[] lotteryCombinations
    ) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.country = country;
        this.lotteryCombinations = lotteryCombinations;
    }

    public int getPoints() {
        return points;
    }

    /**
     *
     * @return copy of lottery combination list
     */
    public String[] getLotteryCombinations() {
        return Arrays.copyOf(lotteryCombinations, lotteryCombinations.length);
    }

    /**
     * Method set value of points after analyzing player's combinations
     *
     * @param value to set
     */
    public void increasePoints(final int value) {
        this.points += value;
    }

    @Override
    public String toString() {
        return lastName + "," + firstName + "," + country + "," + points;
    }

    @Override
    public int compareTo(final Player player) {
        if (!this.lastName.equals(player.lastName)) {
            return this.lastName.compareTo(player.lastName);
        }
        if (!this.firstName.equals(player.firstName)) {
            return this.firstName.compareTo(player.firstName);
        }
        return this.country.compareTo(player.country);
    }
}
