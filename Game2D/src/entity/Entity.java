package entity;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.imageio.ImageIO;
import main.GamePanel;
import main.UtilityTool;
import object.OBJ_EnergyDrink;
import object.OBJ_HP;
import object.OBJ_HP_half;

public class Entity {

    GamePanel gp;
    public BufferedImage up1 , up2 ,up3, up4,up5,up6,up7,up8,up9,
    down1 , down2 ,down3 ,down4,down5,down6,down7,down8,down9,
    right1 , right2 ,right3 ,right4,right5,right6,right7,right8,right9,
    left1 , left2 ,left3 ,left4,left5,left6,left7,left8,left9,
    idleL1, idleL2, idleL3, idleL4, idleL5, idleL6,
    idleR1, idleR2, idleR3, idleR4, idleR5, idleR6;

    public BufferedImage die;

    public BufferedImage attackUp1, attackUp2, attackUp3, attackUp4, attackUp5,
    attackUp6,attackUp7, attackUp8, attackUp9,
    attackDown1, attackDown2, attackDown3, attackDown4, attackDown5,
    attackDown6,attackDown7, attackDown8,attackDown9,
    attackLeft1, attackLeft2, attackLeft3, attackLeft4, attackLeft5,
    attackLeft6,attackLeft7,attackLeft8, attackLeft9,attackLeft10,
    attackRight1, attackRight2, attackRight3, attackRight4, attackRight5,
    attackRight6,attackRight7, attackRight8, attackRight9, attackRight10;

    public BufferedImage defendLeft1, defendLeft2, defendLeft3, defendLeft4, defendLeft5, defendLeft6,
    defendRight1, defendRight2, defendRight3, defendRight4, defendRight5, defendRight6;

    public BufferedImage image, image2, image3;
    public Rectangle solidArea = new Rectangle(0 , 0 , 48 , 48);
    public Rectangle attackArea = new Rectangle(0, 0, 0,0);
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collision = false;
    String dialogues [] = new String[20];

    // STATE (TRẠNG THÁI)
    public int worldX , worldY;
    public String direction = "down";
    public int spriteNum = 1;
    int dialogueIndex = 0;
    public boolean collisionOn = false;
    public boolean invincible = false;
    public boolean attacking = false;
    public boolean alive = true;
    public boolean dying = false;
    public boolean hpBarOn = false;
    public boolean onPath = false;

    // COUNTER (BIẾN ĐẾM)
    public int spriteCounter = 0;
    public int actionLockCounter = 0;
    public int invincibleCounter = 0;
    public int shotAvailableCounter = 0;
    public int dyingCounter = 0;
    public int hpBarCounter = 0;

    // CHARACTER ATTIBUTES (ĐẶC ĐIỂM NHÂN VẬT)
    public String name;
    public int speed;
    public int maxLife;
    public int life;
    public int level;// Cấp độ
    public int strength;// Sức mạnh
    public int dexterity;// Khéo léo 
    public int attack;// Tấn công
    public int defense;// Phòng thủ
    public int exp;// Kinh nghiệm
    public int nextLevelExp;

    //Lớp attackMonster
    public Projectile projectile;

    //Kiểm tra khoảng cách tấn công của monster
    public int getXdistance(Entity target) {
    	int xDistance = Math.abs(worldX - target.worldX);
    	return xDistance;
    }
    public int getYdistance(Entity target) {
    	int yDistance = Math.abs(worldY - target.worldY);
    	return yDistance;
    }
    public int getTileDistance(Entity target){
        int tileDistance = (getXdistance(target) + getYdistance(target))/gp.tileSize;
        return tileDistance;
    }
    public int getGoalCol(Entity target){
        int goalCol = (target.worldX + target.solidArea.x)/gp.tileSize;
        return goalCol;
    }
    public int getGoalRow(Entity target){
        int goalRow = (target.worldY + target.solidArea.y)/gp.tileSize;
        return goalRow;
    }

    // ITEM ATTRIBUTES (ĐẶC ĐIỂM VẬT PHẨM)
    public int value;
    public int attackValue;
    public int defenseValue;
    public String decription = "";

    public ArrayList<Entity> inventory = new ArrayList<>();
    public final int maxInventorySize = 20;
    
    public boolean stackable = false;
    public int amount = 1;
    
    // TYPE (LOẠI)
    public int type; // 0: player , 1: npc , 2: monster
    public final int type_player  = 0;
    public final int type_npc = 1;
    public final int type_monster = 2;
    public final int type_consumable = 3;
    public final int type_obstacle = 5;

    public Entity(GamePanel gp){
        this.gp = gp;
    }
    public int getLeftX(){
        return worldX + solidArea.x;
    }
    public int getRightX(){
        return worldX + solidArea.x + solidArea.width;
    }
    public int getTopY(){
        return worldY +solidArea.y;
    }
    public int getBottomY(){
        return worldY + solidArea.y + solidArea.height;
    }
    public int getCol(){
        return (worldX + solidArea.x)/gp.tileSize;
    }
    public int getRow(){
        return (worldY + solidArea.y)/gp.tileSize;
    }
    public void setAction() {}
    public void speak() {}
    public void interact(){}
    public boolean use(Entity entity){return false;}
    public void damageReaction(){
        actionLockCounter = 0;
        onPath = true;
    }
    public void checkDrop(){
        int i = new Random().nextInt(100) + 1;
        //SET THE MONSTER DROP
        if(i < 25){
            dropItem(new OBJ_HP(gp));
        }
        if(i >= 50 && i < 75){
            dropItem(new OBJ_HP_half(gp));
        }
        if(i >= 95 && i < 100){
            dropItem(new OBJ_EnergyDrink(gp));
        }
    }
    public void dropItem(Entity droppedItem){

        for(int i = 0; i < gp.obj.length; i++){
            if(gp.obj[i] == null){
                gp.obj[i] = droppedItem;
                gp.obj[i].worldX =  worldX;
                gp.obj[i].worldY = worldY;
                break;
            }
        }
    }
    public void checkCollison(){
        collisionOn = false;
        gp.cChecker.checkTile(this);
        gp.cChecker.checkObject(this, false);
        gp.cChecker.checkEntity(this, gp.npc);
        gp.cChecker.checkEntity(this, gp.monster);

        boolean contactPlayer = gp.cChecker.checkPlayer(this);
        if(this.type == type_monster && contactPlayer == true){
            damagePlayer(attack);
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
                    case "up": worldY -= speed ; break;
                    case "down": worldY += speed; break;
                    case "right": worldX += speed; break;
                    case "left": worldX -= speed; break;
                    default: break;
                }
            }
            spriteCounter ++;
            if(spriteCounter > 10){
                if(spriteNum == 1) spriteNum = 2;
                else if(spriteNum == 2) spriteNum =1;
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
        if(shotAvailableCounter < 30) {
        	shotAvailableCounter ++;
        }
    }
    public void checkAttackOrNot(int rate, int straight, int horizontal){

        boolean targetInRange = false;
        int xDis = getXdistance(gp.player);
        int yDis = getYdistance(gp.player);
        
        switch (direction) {
            case "up":
                if(gp.player.worldY < worldY && yDis < straight && xDis < horizontal){
                    targetInRange = true;
                }
                else targetInRange = false;
                break;
            case "down":
                if(gp.player.worldY > worldY && yDis < straight && xDis < horizontal){
                    targetInRange = true;
                }
                else targetInRange = false;
                break;
            case "right":
                if(gp.player.worldX > worldX && xDis < straight && yDis < horizontal){
                    targetInRange = true;
                }
                else targetInRange = false;
                break;
            case "left":
                if(gp.player.worldX < worldX && xDis < straight && yDis < horizontal){
                    targetInRange = true;
                }
                else targetInRange = false;
                break;
        }
        if(targetInRange == true){
            int i = new Random().nextInt(rate);
            if(i == 0){
                attacking = true;
                spriteNum = 1;
                spriteCounter = 0;
                shotAvailableCounter = 0;
            }
        }
        else{
            attacking = false;
        }
    }
    public void checkStopChasingOrNot(Entity target, int distance, int rate){
        if(getTileDistance(target) > distance){
            int i = new Random().nextInt(rate);
            if(i == 0){
                onPath = false;
            }
        }
    }
    public void checkStartChasingOrNot(Entity target, int distance, int rate){
        if(getTileDistance(target) < distance){
            int i = new Random().nextInt(rate);
            if(i == 0){
                onPath = true;
            }
        }
    }
    public void checkShootOrNot(int rate, int shootInterval){
        int i = new Random().nextInt(rate);
            if(i == 0 && projectile.alive == false && shotAvailableCounter == shootInterval){
                projectile.set(worldX, worldY, direction, true, this);
                gp.projectileList.add(projectile);
                shotAvailableCounter = 0;
            }
    }
    public void getRandomDirection(){
        actionLockCounter ++;
        if(actionLockCounter == 120){	        	
            Random random = new Random();
            int i = random.nextInt(100) + 1;
            if(i <= 25 ) direction = "up";
            if(i > 25 && i <= 50) direction = "down";
            if(i > 50 && i <= 75) direction = "left";
            if(i > 75) direction = "right";
            actionLockCounter = 0;			            
        }
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

            // Chỉ thay đổi vùng va chạm của player khi attack
            switch(direction){
                case "up","right","up_right","down_right": worldX += attackArea.height; break;
                case "down","left","down_left","up_left": worldX -= attackArea.width; break;
            }
            // Attack area becomes solidArea (chuyển vùng bị tấn công thành vùng rắn)
            solidArea.width = attackArea.width;
            solidArea.height = attackArea.height;

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
        if(spriteCounter > 18 && spriteCounter <= 23){
            spriteNum = 5;

            // Chỉ thay đổi vùng va chạm của player khi attack
            switch(direction){
                case "up","right","up_right","down_right": worldX += attackArea.height; break;
                case "down","left","down_left","up_left": worldX -= attackArea.width; break;
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
        if(spriteCounter > 23 && spriteCounter <= 28){
            spriteNum = 6;

            // Chỉ thay đổi vùng va chạm của player khi attack
            switch(direction){
                case "up","right","up_right","down_right": worldX += attackArea.height; break;
                case "down","left","down_left","up_left": worldX -= attackArea.width; break;
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
        // After checking restore data (Cập nhật dữ liệu sau khi kiểm tra)
        worldX = currentWorldX;
        worldY = currentWorldY;
        solidArea.width = solidAreaWidth;
        solidArea.height = solidAreaHeight;

        if(spriteCounter > 28){
            spriteNum = 1;
            spriteCounter = 0;
            attacking = false;
        }
    }
    public void damagePlayer(int attack) {
    	if(gp.player.invincible == false){
            // NGƯỜI CHƠI CÓ THỂ CHỊU DMGDMG
            int damage = attack - gp.player.defense;
            if(damage < 0) damage = 0;
            gp.player.life -= damage;
            gp.player.invincible = true;
        }
    }
    public void draw(Graphics2D g2){

        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;
        // Stop moving the camere at the edge (Ngừng di chuyển camera khi ở lề)

        if(gp.player.screenX > gp.player.worldX){
            screenX = worldX;
        }
        if(gp.player.screenY > gp.player.worldY){
            screenY = worldY;
        }
        int rightOffset = gp.screenWidth - gp.player.screenX;
        if(rightOffset > gp.worldWidth - gp.player.worldX){
            screenX = gp.screenWidth - (gp.worldWidth - worldX);
        }

        int bottomOffset = gp.screenHeight - gp.player.screenY;
        if(bottomOffset > gp.worldHeight - gp.player.worldY){
            screenY = gp.screenHeight - (gp.worldHeight - worldY);
        }

        if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
            worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
            worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
            worldY - gp.tileSize < gp.player.worldY + gp.player.screenY){
            
                subdraw(g2, screenX, screenY);
        }
        else if(gp.player.screenX > gp.player.worldX || gp.player.screenY > gp.player.worldY ||
            rightOffset > gp.worldWidth - gp.player.worldX ||
            bottomOffset > gp.worldHeight - gp.player.worldY) {
                // WHEN STOP CAMERA (ngừng camera)
                subdraw(g2, screenX, screenY);
        }
    }
    // SUBDRAW (Vẽ phụ)
    public void subdraw(Graphics2D g2, int screenX, int screenY){

        BufferedImage image = null;
        switch(direction){
            case "up":
                if(attacking == false){
                    if(spriteNum == 1) image = up1;
                    if(spriteNum == 2) image = up2;
                    if(spriteNum == 3) image = up3;
                    if(spriteNum == 4) image = up4;
                    if(spriteNum == 5) image = up5;
                    if(spriteNum == 6) image = up6;
                    if(spriteNum == 7) image = up7;
                    if(spriteNum == 8) image = up8;
                }
                if(attacking == true){ 
                    if(spriteNum == 1) image = attackUp1;
                    if(spriteNum == 2) image = attackUp2;
                    if(spriteNum == 3) image = attackUp3;
                    if(spriteNum == 4) image = attackUp4;
                    if(spriteNum == 5) image = attackUp5;
                    if(spriteNum == 6) image = attackUp6;
                }
                break;
            case "down":
                if(attacking == false){
                    
                    if(spriteNum == 1) image = down1;
                    if(spriteNum == 2) image = down2;
                    if(spriteNum == 3) image = down3;
                    if(spriteNum == 4) image = down4;
                    if(spriteNum == 5) image = down5;
                    if(spriteNum == 6) image = down6;
                    if(spriteNum == 7) image = down7;
                    if(spriteNum == 8) image = down8;
                }
                if(attacking == true){
                    if(spriteNum == 1) image = attackDown1;
                    if(spriteNum == 2) image = attackDown2;
                    if(spriteNum == 3) image = attackDown3;
                    if(spriteNum == 4) image = attackDown4;
                    if(spriteNum == 5) image = attackDown5;
                    if(spriteNum == 6) image = attackDown6;
                }
                break;    
            case "right":
                if(attacking == false){
                    if(spriteNum == 1) image = right1;
                    if(spriteNum == 2) image = right2;
                    if(spriteNum == 3) image = right3;
                    if(spriteNum == 4) image = right4;
                    if(spriteNum == 5) image = right5;
                    if(spriteNum == 6) image = right6;
                    if(spriteNum == 7) image = right7;
                    if(spriteNum == 8) image = right8;
                }
                if(attacking == true){
                    if(spriteNum == 1) image = attackRight1;
                    if(spriteNum == 2) image = attackRight2;
                    if(spriteNum == 3) image = attackRight3;
                    if(spriteNum == 4) image = attackRight4;
                    if(spriteNum == 5) image = attackRight5;
                    if(spriteNum == 6) image = attackRight6;
                }
                break;
            case "left":
                if(attacking == false){
                    if(spriteNum == 1) image = left1;
                    if(spriteNum == 2) image = left2;
                    if(spriteNum == 3) image = left3;
                    if(spriteNum == 4) image = left4;
                    if(spriteNum == 5) image = left5;
                    if(spriteNum == 6) image = left6;
                    if(spriteNum == 7) image = left7;
                    if(spriteNum == 8) image = left8;
                }
                if(attacking == true){
                    if(spriteNum == 1) image = attackLeft1;
                    if(spriteNum == 2) image = attackLeft2;
                    if(spriteNum == 3) image = attackLeft3;
                    if(spriteNum == 4) image = attackLeft4;
                    if(spriteNum == 5) image = attackLeft5;
                    if(spriteNum == 6) image = attackLeft6;
                }
                break;
    
        }
        // Monster HP bar (Thanh HP của quái)
        if(type == type_monster && hpBarOn == true){
            double oneScale = (double) gp.tileSize/maxLife;
            double hpBarValue = oneScale*life;

            g2.setColor(new Color(35,35,35));
            g2.fillRect(screenX - 1,screenY - 16,gp.tileSize+2,7);
            g2.setColor(new Color(255,0,30));
            g2.fillRect(screenX, screenY-15, (int) hpBarValue, 5);

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
                if(die == null) dyingCounter = jump*32;
                image = die;
            }
            if(dyingCounter > jump*31){
                alive = false;
            }
        }
        g2.drawImage(image, screenX , screenY, null);
        changeAlpha(g2, 1f);
    }
    public void changeAlpha(Graphics2D g2, float alphaValue){

        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alphaValue));
    }
    public BufferedImage setup(String imagePath, int width, int height){

        UtilityTool uTool = new UtilityTool();
        BufferedImage image = null;

        try {
            
            image = ImageIO.read(getClass().getResourceAsStream("/res" + imagePath + ".png"));
            image = uTool.scaleImage(image, width, height);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }
    public void searchPath(int goalCol, int goalRow){

        int startCol = (worldX + solidArea.x)/gp.tileSize;
        int startRow = (worldY + solidArea.y)/gp.tileSize;

        gp.pFinder.setNodes(startCol, startRow, goalCol, goalRow);

        if(gp.pFinder.search() == true){

            // Next worldX & worldY
            int nextX = gp.pFinder.pathList.get(0).col * gp.tileSize;
            int nextY = gp.pFinder.pathList.get(0).row * gp.tileSize;

            // Entity's solidArea position
            int enLeftX = worldX + solidArea.x;
            int enRightX = worldX + solidArea.x + solidArea.width;
            int enTopY = worldY + solidArea.y;
            int enBottomY = worldY   + solidArea.y + solidArea.height;

            if(enTopY > nextY && enLeftX >= nextX && enRightX  < nextX + gp.tileSize){
                direction = "up";
            }
            else if(enTopY < nextY && enLeftX >= nextX && enRightX  < nextX + gp.tileSize){
                direction = "down";
            }
            else if(enTopY >= nextY && enBottomY < nextY + gp.tileSize){
                // left or right
                if(enLeftX > nextX) direction = "left";
                if(enLeftX < nextX) direction = "right";
            }
            else if(enTopY > nextY && enLeftX > nextX){
                //up or left
                direction = "up";
                checkCollison();
                if(collisionOn == true) direction = "left";
            }
            else if(enTopY > nextY && enLeftX < nextX){
                //up or right
                direction = "up";
                checkCollison();
                if(collisionOn == true) direction = "right";
            }
            else if(enTopY < nextY && enLeftX > nextX){
                //down or left
                direction = "down";
                checkCollison();
                if(collisionOn == true) direction = "left";
            }
            else if(enTopY < nextY && enLeftX < nextX){
                //down or right
                direction = "down";
                checkCollison();
                if(collisionOn == true) direction = "right";
            }
            // // Nếu tìm được đích thì dừng search()
            // int nextCol = gp.pFinder.pathList.get(0).col;
            // int nextRow = gp.pFinder.pathList.get(0).row;
            // if(nextCol == goalCol && nextRow == goalRow){
            //     onPath = false;
            // }
        }

    }
    public int getDetected(Entity user, Entity target[]){

        int index = 999;

        // Check the surrounding object 
        int nextWorldX = user.getLeftX();
        int nextWorldY = user.getTopY();

        switch(user.direction){
        case "up": nextWorldY = user.getTopY() - 1; break;
        case "down": nextWorldY = user.getBottomY() + 1; break;
        case "left": nextWorldX = user.getLeftX() - 1; break;
        case "right": nextWorldX = user.getRightX() + 1; break;
        case "up_right": 
            nextWorldY = user.getTopY() - 1;
            nextWorldX = user.getRightX() + 1;
            break;
        case "up_left": 
            nextWorldY = user.getTopY() - 1;
            nextWorldX = user.getLeftX() - 1;
            break;
        case "down_right":
            nextWorldY = user.getBottomY() + 1;
            nextWorldX = user.getRightX() + 1;
            break;
        case "down_left":
            nextWorldY = user.getBottomY() + 1;
            nextWorldX = user.getLeftX() - 1;
            break;
        }

        int col = nextWorldX/gp.tileSize;
        int row = nextWorldY/gp.tileSize;

        for(int  i = 0; i < target.length; i++){
            if(target[i] != null){
                if(target[i].getCol() == col && target[i].getRow() == row){
                    index = i;
                    break;
                }
            }
        }
        return index;
    }
}
