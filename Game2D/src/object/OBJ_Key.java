package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Key extends Entity {
    GamePanel gp;
    public OBJ_Key(GamePanel gp){
        super(gp);
        this.gp = gp;
        name = "Chìa khóa cũ";
        type = type_consumable;
        down1 = setup("/objects/key", gp.tileSize, gp.tileSize);
        decription = "[" + name + "]\nVật phẩm quý hiếm\n dùng để giao nộp cho NPC.";
    }

    public boolean use(Entity entity){

        gp.gameState = gp.dialogueState;
        int npcIndex = gp.cChecker.checkEntity(entity, gp.npc);
        if(npcIndex != 999){
            gp.ui.currentDialogue = "Chúc cậu may mắn, quái vật bên trong sẽ mới chỉ là một thách thức nhỏ trong hành trình của cậu!";
            gp.npc[npcIndex] = null;
            return true;
        }
        else{
            gp.ui.currentDialogue = "Không thể dùng vật phẩm?";
            return false;
        }
    }
}
