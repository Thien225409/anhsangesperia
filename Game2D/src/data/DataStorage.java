package data;

import java.io.Serializable;
import java.util.ArrayList;

import entity.Entity;

public class DataStorage implements Serializable{

    // PLAYER STATUS
    int level;
    int maxLife;
    int life;
    int attack;
    int defense;
    int exp;
    int nextLevelExp;
    int worldX;
    int worldY;
    public ArrayList<Entity> inventory = new ArrayList<>();
}
