package main.Monster;

import entity.Entity;
import main.GamePanel;
import object.OBJ_Bow;

public class MON_Skeleton extends Entity{

    GamePanel gp;
    public MON_Skeleton(GamePanel gp){
        super(gp);

        this.gp = gp;
        type = type_monster;
        name = "Skeleton";
        speed = 1;
        maxLife = 3;
        life = maxLife;

        attack = 2;
        defense = 0;
        projectile = new OBJ_Bow(gp);
        exp = 1;
        
        solidArea.x = 3;
        solidArea.y = 18;
        solidArea.width = 42;
        solidArea.height = 30;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        getImage();
    }

    public void getImage(){

        up1 = setup("/monster/skeleton_up1", gp.tileSize, gp.tileSize);
        up2 = setup("/monster/skeleton_up2", gp.tileSize, gp.tileSize);
        down1 = setup("/monster/skeleton_down1", gp.tileSize, gp.tileSize);
        down2 = setup("/monster/skeleton_down2", gp.tileSize, gp.tileSize);
        right1 = setup("/monster/skeleton_right1", gp.tileSize, gp.tileSize);
        right2 = setup("/monster/skeleton_right2", gp.tileSize, gp.tileSize);
        left1 = setup("/monster/skeleton_left1", gp.tileSize, gp.tileSize);
        left2 = setup("/monster/skeleton_left2", gp.tileSize, gp.tileSize);

        die = setup("/monster/skeleton_died",gp.tileSize,gp.tileSize);
    }

    public void setAction(){
        if(onPath == true){
            checkStopChasingOrNot(gp.player, 15, 100);
            searchPath(getGoalCol(gp.player), getGoalRow(gp.player));
            checkShootOrNot(200,30);
        }
        else{
            checkStartChasingOrNot(gp.player, 5, 100);
            getRandomDirection();
        }
    }
}
