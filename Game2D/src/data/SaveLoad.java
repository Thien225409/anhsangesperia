package data;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.File;
import java.io.ObjectOutputStream;

import main.GamePanel;

public class SaveLoad {

    GamePanel gp;
    ObjectOutputStream oos;
    ObjectInputStream ois;

    public SaveLoad(GamePanel gp){
        this.gp = gp;

    }
    public void save(){
        
        try {
            oos = new ObjectOutputStream(new FileOutputStream(new File("save.dat")));

            DataStorage ds = new DataStorage();
            ds.level = gp.player.level;
            ds.maxLife = gp.player.maxLife;
            ds.life = gp.player.life;
            ds.attack = gp.player.attack;
            ds.defense = gp.player.defense;
            ds.exp = gp.player.exp;
            ds.nextLevelExp = gp.player.nextLevelExp;
            ds.worldX = gp.player.worldX;
            ds.worldY = gp.player.worldY;
            ds.inventory = gp.player.inventory;
            // Write the DataStorage object
            oos.writeObject(ds);
        } catch (Exception e) {
            System.out.println("Save Exception");
        }
        
    }
    public void load(){
        try {
            ois = new ObjectInputStream(new FileInputStream(new File("save.dat")));

            // Read the datastorage object
            DataStorage ds = (DataStorage) ois.readObject();
            gp.player.level = ds.level;
            gp.player.maxLife = ds.maxLife;
            gp.player.life = ds.life;
            gp.player.attack = ds.attack;
            gp.player.defense = ds.defense;
            gp.player.exp = ds.exp;
            gp.player.nextLevelExp = ds.nextLevelExp;
            gp.player.worldX = ds.worldX;
            gp.player.worldY = ds.worldY;
            gp.player.inventory = ds.inventory;
            
        } catch (Exception e) {
            System.out.println("Load Exception!");
        }
    }
}
