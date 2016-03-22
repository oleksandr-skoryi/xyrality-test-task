package com.xyrality.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by homedevelop on 22.03.16.
 */
public class Player {
    private String firstName;
    private String lastName;
    private String country;
    private List<String> lotteryCombinatons;
    private int points;

    public Player(String firstName, String lastName, String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        lotteryCombinatons = new ArrayList<>();
    }
}
