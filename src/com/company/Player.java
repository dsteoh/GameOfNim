package com.company;

public class Player {

    //Property to store player's name
    private String Name;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    //Constructor
    public Player(String name)
    {
        Name = name;
    }

    public void removeStone(int num)
    {
        Game.removeStone(num);
    }
}
