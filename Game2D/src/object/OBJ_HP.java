package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_HP extends Entity{

    GamePanel gp;
    public OBJ_HP(GamePanel gp){

        super(gp);
        
        this.gp = gp;
        type = type_consumable;
        value = 2;
        name = "Thuốc hồi phục II";
        down1 = setup("/objects/hp", gp.tileSize, gp.tileSize);
        decription = "[" + name + "]\nSử dụng để hồi phục \n" + value + "điểm HP.";
    }
    public boolean use(Entity entity){

        gp.gameState = gp.playState;
        gp.ui.addMessage("Bạn vừa uống " + name);
        gp.ui.addMessage("Sinh mệnh đã phục hổi " + value + " điểm.");
        entity.life += value;
        return true;
    }
}

