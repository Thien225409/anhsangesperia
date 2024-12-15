package entity;

import java.awt.Rectangle;
import main.GamePanel;
public class NPC_OldMan extends Entity {

    public NPC_OldMan(GamePanel gp){

        super(gp);
        speed = 1;
        name = "Demon Door";
        solidArea = new Rectangle();
        solidArea.x = 9;
        solidArea.y = 18;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.height = 30;
        solidArea.width = 30;
        
        getImage();
        setDialogue();
    }
    public void getImage(){
        down1 = setup("/npc/01_Demon Door_NPC", gp.tileSize, gp.tileSize);
    }
    public void setDialogue(){
        dialogues[0] = "Ngươi... kẻ phàm tục. Muốn đi qua đây ư? Không dễ đâu...";
        dialogues[1] = "Ta không mở ra cho những kẻ tay không. Để vượt qua, ngươi phải dâng nộp Chìa Khóa Định Mệnh.";
        dialogues[2] = "Nhưng đừng tưởng ta sẽ chỉ chỗ. Chiếc chìa khóa đó đang ngủ say trong một chiếc rương nào đó, sâu bên trong khu rừng này... Heh heh heh... Hãy tìm nó, nếu ngươi còn đủ dũng khí!";
        dialogues[3] = "Ngươi đã tìm ra chìa khóa chưa? Có nó, ta sẽ để ngươi qua. Nếu chưa... ngươi phải tìm, và có lẽ sẽ phải đối mặt với những nguy hiểm không ngờ.";
    }
    
    public void speak(){
        if(gp.player.hasKey >= 1){
            dialogues[0] = "Ngươi đã tìm ra chìa khóa chưa? Có nó, ta sẽ để ngươi qua. Nếu chưa... ngươi phải tìm, và có lẽ sẽ phải đối mặt với những nguy hiểm không ngờ.";
            // System.out.println("Hello");
        }
        if(dialogues[dialogueIndex] == null){
            dialogueIndex = 0;
        }
        gp.ui.currentDialogue = dialogues[dialogueIndex];
        dialogueIndex ++;
    }
}
