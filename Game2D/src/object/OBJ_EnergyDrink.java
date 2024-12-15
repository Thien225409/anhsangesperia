package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_EnergyDrink extends Entity{

    GamePanel gp;
    public OBJ_EnergyDrink(GamePanel gp){

        super(gp);
        this.gp = gp;
        type = type_consumable;
        value = 1;
        name = "Thuốc tăng lực";
        down1 = setup("/objects/buff_attack", gp.tileSize, gp.tileSize);
        decription = "[" + name + "]\nSử dụng để tăng " + value + "\nđiểm tấn công.";
    }
    public boolean use(Entity entity){

        gp.gameState = gp.playState;
        gp.ui.addMessage("Bạn vừa uống " + name);
        gp.ui.addMessage("Sức tấn công tăng " + value + " điểm.");
        entity.attack += value;
        return true;
    }
}
