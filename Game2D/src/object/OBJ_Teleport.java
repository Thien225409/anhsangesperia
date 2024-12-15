package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Teleport extends Entity{
	 GamePanel gp;
	 public OBJ_Teleport(GamePanel gp){
	        super(gp);
	        type = type_obstacle;
	        name = "DoorTeleport";	        
	        down1 = setup("/objects/teleport6", gp.tileSize*2, gp.tileSize*2);	       
	    } 
}	 
