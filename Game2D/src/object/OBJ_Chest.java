package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Chest extends Entity {

    GamePanel gp;
    Entity loot;
    boolean opened = false;
    public OBJ_Chest(GamePanel gp, Entity loot){

        super(gp);
        this.gp = gp;
        this.loot = loot;

        type = type_obstacle;
        name = "Rương";
        image = setup("/objects/chest", gp.tileSize, gp.tileSize);
        image2 = setup("/objects/chest_opened", gp.tileSize, gp.tileSize);
        down1 = image;
        collision = true;

        solidArea.x = 4;
        solidArea.y = 16;
        solidArea.width = 40;
        solidArea.height = 32;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }

    public void interact(){
        gp.gameState = gp.dialogueState;
        if(opened == false){

           StringBuilder sb = new StringBuilder();

            if(gp.player.inventory.size() == gp.player.maxInventorySize){
                sb.append("\n....Túi đồ đã đầy!");

            }
            else{
                sb.append("\nBạn đã nhận được " + loot.name + "!");
                if(loot.name.equals("Chìa khóa cũ")) gp.player.hasKey++;
                gp.player.inventory.add(loot);
                down1 = image2;
                opened = true;

            }
            gp.ui.currentDialogue = sb.toString();
        }
        else{
            gp.ui.currentDialogue = "Rương rỗng!";
        }
        
    }
}
