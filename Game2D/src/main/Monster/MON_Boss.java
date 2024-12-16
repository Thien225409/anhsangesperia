package main.Monster;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import entity.Entity;
import main.GamePanel;

public class MON_Boss extends Entity{
	GamePanel gp;
    public MON_Boss(GamePanel gp){
        super(gp);

        this.gp = gp;
        type = 2;
        name = "Final_Boss";
        speed = 2;
        maxLife = 20;
        life = maxLife;
		exp = 10;
        attack = 4;
        defense = 2;

        solidArea.x = 61;
        solidArea.y = 32;
        solidArea.width = 49;
        solidArea.height = 64;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
		attackArea.width = 151;
		attackArea.height = 149;
        getImage();
        getAttackImage();
    }	 

    public void getImage(){
    	
    	left1 = setup("/monster/final_boss_0", gp.tileSize*3 , gp.tileSize*2 );
    	left2 = setup("/monster/final_boss_1", gp.tileSize*3 , gp.tileSize*2 );
    	left3 = setup("/monster/final_boss_2", gp.tileSize*3 , gp.tileSize*2 );
    	left4 = setup("/monster/final_boss_3", gp.tileSize*3 , gp.tileSize*2 );
    	left5 = setup("/monster/final_boss_4", gp.tileSize*3 , gp.tileSize*2 );
    	left6 = setup("/monster/final_boss_5", gp.tileSize*3 , gp.tileSize*2 );
    	left7 = setup("/monster/final_boss_6", gp.tileSize*3 , gp.tileSize*2 );
    	left8 = setup("/monster/final_boss_7", gp.tileSize*3 , gp.tileSize*2 );
    	
    	right1 = setup("/monster/final_boss_8", gp.tileSize*3 , gp.tileSize*2 );
    	right2 = setup("/monster/final_boss_9", gp.tileSize*3 , gp.tileSize*2 );
    	right3 = setup("/monster/final_boss_10", gp.tileSize*3 , gp.tileSize*2 );
    	right4 = setup("/monster/final_boss_11", gp.tileSize*3 , gp.tileSize*2 );
    	right5 = setup("/monster/final_boss_12", gp.tileSize*3 , gp.tileSize*2 );
    	right6 = setup("/monster/final_boss_13", gp.tileSize*3 , gp.tileSize*2 );
    	right7 = setup("/monster/final_boss_14", gp.tileSize*3 , gp.tileSize*2 );
    	right8 = setup("/monster/final_boss_15", gp.tileSize*3 , gp.tileSize*2 );
    	
    	
//        die = setup("/monster/miniboss_died",gp.tileSize*2,gp.tileSize);
    }
    public void getAttackImage() { 	
    	attackLeft1 = setup("/monster/final_boss_attack_L00",gp.tileSize*6 , gp.tileSize*3+7);
    	attackLeft2 = setup("/monster/final_boss_attack_L01",gp.tileSize*6 , gp.tileSize*3+7);
    	attackLeft3 = setup("/monster/final_boss_attack_L02",gp.tileSize*6 , gp.tileSize*3+7);
    	attackLeft4 = setup("/monster/final_boss_attack_L03",gp.tileSize*6 , gp.tileSize*3+7);
    	attackLeft5 = setup("/monster/final_boss_attack_L04",gp.tileSize*6 , gp.tileSize*3+7);
    	attackLeft6 = setup("/monster/final_boss_attack_L05",gp.tileSize*6 , gp.tileSize*3+7);
    	attackLeft7 = setup("/monster/final_boss_attack_L06",gp.tileSize*6 , gp.tileSize*3+7);
    	attackLeft8 = setup("/monster/final_boss_attack_L07",gp.tileSize*6 , gp.tileSize*3+7);
		attackLeft9 = setup("/monster/final_boss_attack_L08",gp.tileSize*6 , gp.tileSize*3+7);
		attackLeft10 = setup("/monster/final_boss_attack_L09",gp.tileSize*6 , gp.tileSize*3+7);

    	
    	attackRight1 = setup("/monster/final_boss_attack_R00",gp.tileSize*6 , gp.tileSize*3+7);
    	attackRight2 = setup("/monster/final_boss_attack_R01",gp.tileSize*6 , gp.tileSize*3+7);
    	attackRight3 = setup("/monster/final_boss_attack_R02",gp.tileSize*6 , gp.tileSize*3+7);
    	attackRight4 = setup("/monster/final_boss_attack_R03",gp.tileSize*6 , gp.tileSize*3+7);
    	attackRight5 = setup("/monster/final_boss_attack_R04",gp.tileSize*6 , gp.tileSize*3+7);
    	attackRight6 = setup("/monster/final_boss_attack_R05",gp.tileSize*6 , gp.tileSize*3+7);
    	attackRight7 = setup("/monster/final_boss_attack_R06",gp.tileSize*6 , gp.tileSize*3+7);
    	attackRight8 = setup("/monster/final_boss_attack_R07",gp.tileSize*6 , gp.tileSize*3+7);
		attackRight9 = setup("/monster/final_boss_attack_R08",gp.tileSize*6 , gp.tileSize*3+7);
		attackRight10 = setup("/monster/final_boss_attack_R09",gp.tileSize*6 , gp.tileSize*3+7);
    }
    public void attacking(){
        spriteCounter++;

        // Lưu trạng thái trước hiện tại
        int currentWorldX = worldX;
        int currentWorldY = worldY;
        int solidAreaWidth = solidArea.width;
        int solidAreaHeight = solidArea.height;
        if(spriteCounter <= 3){
            spriteNum = 1;
        }
        if(spriteCounter > 3 && spriteCounter <= 8){
            spriteNum = 2;
        }
        if(spriteCounter > 8 && spriteCounter <= 13){
            spriteNum = 3;
        }
        if(spriteCounter > 13 && spriteCounter <= 18){
            spriteNum = 4;
        }
        if(spriteCounter > 18 && spriteCounter <= 25){
            spriteNum = 5;
            changeSolid();
        }
        if(spriteCounter > 25 && spriteCounter <= 32){
            spriteNum = 6;
			changeSolid();
        }
		if(spriteCounter > 32 && spriteCounter <= 39){
            spriteNum = 7;
			changeSolid();
        }
		if(spriteCounter > 39 && spriteCounter <= 46){
            spriteNum = 8;
			changeSolid();
        }
		if(spriteCounter > 46 && spriteCounter <= 53){
            spriteNum = 9;
			changeSolid();
        }
		if(spriteCounter > 53 && spriteCounter <= 60){
            spriteNum = 10;
        }
        // After checking restore data (Cập nhật dữ liệu sau khi kiểm tra)
        worldX = currentWorldX;
        worldY = currentWorldY;
        solidArea.width = solidAreaWidth;
        solidArea.height = solidAreaHeight;

        if(spriteCounter > 60){
            spriteNum = 1;
            spriteCounter = 0;
            attacking = false;
        }
    }
	public void changeSolid(){
		// Chỉ thay đổi vùng va chạm của player khi attack
		switch(direction){
			case "up","right": 
				worldX += 120;
				worldY -= 43;
				break;
            case "down","left":
				worldX -= 194;
				worldY -= 58;
				break;
		}
		// Attack area becomes solidArea (chuyển vùng bị tấn công thành vùng rắn)
		solidArea.width = attackArea.width;
		solidArea.height = attackArea.height;

		// Check monster collision with updated worldX, worldY and solidArea (kiểm tra va chạm của quái với worldX, worldY và vùng rắn)
		if(type == type_monster){
			if(gp.cChecker.checkPlayer(this) == true){
				damagePlayer(attack);
			}
		}
		else{
			// Check monster collision with updated worldX, worldY and solidArea (kiểm tra va chạm của quái với worldX, worldY và vùng rắn)
			int monsterIndex = gp.cChecker.checkEntity(this, gp.monster);
			gp.player.damageMonster(monsterIndex);
		}
	}
    public void update(){

		if(attacking == true){
            attacking();
        }
		else{
			setAction();
			checkCollison();
			if(collisionOn == false){
				switch (direction) {
				case "up": worldY -= speed; break;
				case "down": worldY += speed; break;
				case "right": worldX += speed; break;
				case "left": worldX -= speed; break;        
				default: break;
				}
			}
			spriteCounter ++;
			if(spriteCounter > 5){
				if(spriteNum == 1) spriteNum = 2;
				else if(spriteNum == 2) spriteNum = 3;
				else if(spriteNum == 3) spriteNum = 4;
				else if(spriteNum == 4) spriteNum = 5;
				else if(spriteNum == 5) spriteNum = 6;
				else if(spriteNum == 6) spriteNum = 7;
				else if(spriteNum == 7) spriteNum = 8;
				else if(spriteNum == 8) spriteNum = 9;
				else if(spriteNum == 9) spriteNum = 10;
				else if(spriteNum == 10) spriteNum = 1;
				spriteCounter = 0;
			}
		}
        if(invincible == true){
            invincibleCounter ++;
            if(invincibleCounter > 40){
                invincible = false;
                invincibleCounter = 0;
            }
        }	
    }
    public void subdraw(Graphics2D g2, int screenX, int screenY){
        BufferedImage image = null;
        switch(direction){
            case "up":
            	if(attacking == false) {
					if(spriteNum == 1) image = right1;
	                if(spriteNum == 2) image = right2;
	                if(spriteNum == 3) image = right3;
	                if(spriteNum == 4) image = right4;
	                if(spriteNum == 5) image = right5;
	                if(spriteNum == 6) image = right6;
	            	if(spriteNum == 7) image = right7;
	                if(spriteNum == 8) image = right8;
					if(spriteNum == 9) image = right1;
					if(spriteNum == 10) image = right2;  
            	}
            	if(attacking == true) {
					screenX -= left1.getWidth();
					screenY -= (left1.getHeight() - gp.tileSize +7) ;
	                if(spriteNum == 1) image = attackLeft1;
	                if(spriteNum == 2) image = attackLeft2;
	                if(spriteNum == 3) image = attackLeft3;
	                if(spriteNum == 4) image = attackLeft4;
	                if(spriteNum == 5) image = attackLeft5;
	            	if(spriteNum == 6) image = attackLeft6;
	                if(spriteNum == 7) image = attackLeft7;
	                if(spriteNum == 8) image = attackLeft8;
					if(spriteNum == 9) image = attackLeft9;	
					if(spriteNum == 10) image = attackLeft10;
	                
                }
                break;
            case "down":
            	if(attacking == false) {
            		if(spriteNum == 1) image = left1;
	                if(spriteNum == 2) image = left2;
	                if(spriteNum == 3) image = left3;
	                if(spriteNum == 4) image = left4;
	                if(spriteNum == 5) image = left5;
	                if(spriteNum == 6) image = left6;
	            	if(spriteNum == 7) image = left7;
	                if(spriteNum == 8) image = left8;
					if(spriteNum == 9) image = left1; 
					if(spriteNum == 10) image = left2;
            	}            	  
                if(attacking == true) {
					screenY -= (left1.getHeight() - gp.tileSize +7);
	                if(spriteNum == 1) image = attackRight1;
	                if(spriteNum == 2) image = attackRight2;
	                if(spriteNum == 3) image = attackRight3;
	                if(spriteNum == 4) image = attackRight4;
	                if(spriteNum == 5) image = attackRight5;
	            	if(spriteNum == 6) image = attackRight6;
	                if(spriteNum == 7) image = attackRight7;
	                if(spriteNum == 8) image = attackRight8;
					if(spriteNum == 9) image = attackRight9;
					if(spriteNum == 10) image = attackRight10;
	                
                }
                break;    
            case "right":
            	if(attacking == false) {
            		if(spriteNum == 1) image = right1;
	                if(spriteNum == 2) image = right2;
	                if(spriteNum == 3) image = right3;
	                if(spriteNum == 4) image = right4;
	                if(spriteNum == 5) image = right5;
	                if(spriteNum == 6) image = right6;
	            	if(spriteNum == 7) image = right7;
	                if(spriteNum == 8) image = right8;
					if(spriteNum == 9) image = right1;
					if(spriteNum == 10) image = right2;
					
            	}	            			                
                if(attacking == true) {
					screenY -= (left1.getHeight() - gp.tileSize +7);
                	if(spriteNum == 1) image = attackRight1;
	                if(spriteNum == 2) image = attackRight2;
	                if(spriteNum == 3) image = attackRight3;
	                if(spriteNum == 4) image = attackRight4;
	                if(spriteNum == 5) image = attackRight5;
	            	if(spriteNum == 6) image = attackRight6;
	                if(spriteNum == 7) image = attackRight7;
	                if(spriteNum == 8) image = attackRight8;
					if(spriteNum == 9) image = attackRight9;
					if(spriteNum == 10) image = attackRight10;
                }
                break;
            case "left":
            	if(attacking == false) {
            		if(spriteNum == 1) image = left1;
	                if(spriteNum == 2) image = left2;
	                if(spriteNum == 3) image = left3;
	                if(spriteNum == 4) image = left4;
	                if(spriteNum == 5) image = left5;
	                if(spriteNum == 6) image = left6;
	            	if(spriteNum == 7) image = left7;
	                if(spriteNum == 8) image = left8;
					if(spriteNum == 9) image = left1; 
					if(spriteNum == 10) image = left2;  
            	}	            		                
                if(attacking == true) {
					screenX -= left1.getWidth();
					screenY -= (left1.getHeight() - gp.tileSize +7);
                	if(spriteNum == 1) image = attackLeft1;
	                if(spriteNum == 2) image = attackLeft2;
	                if(spriteNum == 3) image = attackLeft3;
	                if(spriteNum == 4) image = attackLeft4;
	                if(spriteNum == 5) image = attackLeft5;
	            	if(spriteNum == 6) image = attackLeft6;
	                if(spriteNum == 7) image = attackLeft7;
	                if(spriteNum == 8) image = attackLeft8;
					if(spriteNum == 9) image = attackLeft9;	
					if(spriteNum == 10) image = attackLeft10;
                }
                break;
        }

        // Monster HP bar
        if(hpBarOn == true){
            double oneScale = (double) gp.tileSize*8/maxLife;
            double hpBarValue = oneScale*life;

			int x = gp.screenWidth/2 - gp.tileSize*4;
			int y = gp.tileSize*10;

            g2.setColor(new Color(35,35,35));
            g2.fillRect(x-1,y-1,gp.tileSize*8+2,22);
            g2.setColor(new Color(255,0,30));
            g2.fillRect(x, y, (int) hpBarValue, 20);

			g2.setFont(g2.getFont().deriveFont(Font.BOLD, 24f));
			g2.setColor(Color.white);
			g2.drawString("Final Boss",x+4, y-10);

            hpBarCounter++;
            if(hpBarCounter > 600){
                hpBarCounter = 0;
                hpBarOn = false;
            }
        }

        // Làm mờ khi nhân sát thương
        if(invincible == true){
            hpBarOn = true;
            hpBarCounter = 0;
            changeAlpha(g2, 0.4f);
        }

        if(dying == true){
            dyingCounter ++;
            int jump = 5;
            if(dyingCounter <= jump) changeAlpha(g2, 1f);
            if(dyingCounter > jump && dyingCounter <= jump*2) changeAlpha(g2, 0f);
            if(dyingCounter > jump*2 && dyingCounter <= jump*3) changeAlpha(g2, 1f);
            if(dyingCounter > jump*3 && dyingCounter <= jump*4) changeAlpha(g2, 0f);
            if(dyingCounter > jump*4 && dyingCounter <= jump*5) changeAlpha(g2, 1f);
            if(dyingCounter > jump*5 && dyingCounter <= jump*6) changeAlpha(g2, 0f);
            if(dyingCounter > jump*6 && dyingCounter <= jump*7) changeAlpha(g2, 1f);
            if(dyingCounter > jump*7 && dyingCounter <= jump*8) changeAlpha(g2, 0f); 
            if(dyingCounter > jump*8 && dyingCounter <= jump*31) {        		 
                changeAlpha(g2, 1f);
                hpBarOn = false;
                image = die;
            }
            if(dyingCounter > jump*31){	 
                alive = false;
            }
        }
        g2.drawImage(image, screenX , screenY , null);
        changeAlpha(g2, 1f);
    }
	public void damageReaction(){
        actionLockCounter = 0;
    }
    public void setAction() {
		getRandomDirection();
		if(attacking == false) {
			checkAttackOrNot(10,gp.tileSize*10, gp.tileSize*5);
		}
    	       
    }
}
