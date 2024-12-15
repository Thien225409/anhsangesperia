package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_HP_half extends Entity{

    GamePanel gp;
    public OBJ_HP_half(GamePanel gp){

        super(gp);
        this.gp = gp;
        type = type_consumable;
        value = 1;
        name = "Thuốc hồi phục I";
        down1 = setup("/objects/hp_half", gp.tileSize, gp.tileSize);
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
