package com.xyrality.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by homedevelop on 22.03.16.
 */
public class Player {

    private String lastName;
    private String firstName;
    private String country;
    private List<String> lotteryCombinatons;
    private int points;

    public Player(String lastName, String firstName, String country) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.country = country;
        lotteryCombinatons = new ArrayList<>();
    }

    public String toFileFormat() {
        return firstName + "," + lastName + "," + country + "," + points;
    }

    public String getKeyForHelpersMap() {
        return firstName  + lastName  + country;
    }
}
