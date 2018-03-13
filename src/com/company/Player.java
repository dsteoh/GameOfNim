package com.company;

public class Player {

    //Property to store player's name
    public String Name;

    //Constructor
    public Player(String name)
    {
        Name = name;
    }

    public void removeStone(int num)
    {
        Game.RemoveStone(num);
    }
}
