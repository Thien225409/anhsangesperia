package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import main.GamePanel;
import main.KeyHandler;
import object.OBJ_EnergyDrink;
import object.OBJ_HP;
import object.OBJ_HP_half;

public class Player extends Entity {

    KeyHandler keyH;

    public final int screenX;
    public final int screenY;
    public int hasKey = 0;
    public boolean killBoss = false;
    public int standCounter = 0;
    public boolean attackCanceled = false;


    public Player(GamePanel gp, KeyHandler keyH) {

        super(gp);
        this.keyH = keyH;
        
        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2 - (gp.tileSize/2);

        solidArea = new Rectangle();
        solidArea.x = 9;
        solidArea.y = 18;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.height = 30;
        solidArea.width = 30;

        attackArea.width = 36;
        attackArea.height = 36;

        setDefaultValues();
        getPlayerImage();
        getPlayerAttackImage();
        getPlayerDefendImage();
        setItems();
        updateKey();
    }
    
    public void setDefaultValues(){
        worldX = gp.tileSize * 3;
        worldY = gp.tileSize * 16;
        speed = 3;
        direction = "up";

        // PLAYER STATUS (TRẠNG THÁI NHÂN VẬT)
        level = 1;
        maxLife = 6;
        life = maxLife;// 1 life = 1/2 heart
        exp = 0;
        nextLevelExp = 5;
        attack = 1;
        defense = 1;
    }
    public void setDefaultPositions(){
        
        worldX = gp.tileSize * 3;
        worldY = gp.tileSize * 16;
        direction = "up";
    }
    public void restoreLife(){
        life = maxLife;
        invincible = false;
    }

    public void setItems(){
        inventory.clear();
        // inventory.add(new OBJ_Key(gp));
        inventory.add(new OBJ_HP(gp));
        inventory.add(new OBJ_HP_half(gp));
        inventory.add(new OBJ_EnergyDrink(gp));
    }

    public void getPlayerImage(){
        up1 = setup("/player/walk_right1", gp.tileSize, gp.tileSize);
        up2 = setup("/player/walk_right2", gp.tileSize, gp.tileSize);
        up3 = setup("/player/walk_right3", gp.tileSize, gp.tileSize);
        up4 = setup("/player/walk_right4", gp.tileSize, gp.tileSize);
        up5 = setup("/player/walk_right5", gp.tileSize, gp.tileSize);
        up6 = setup("/player/walk_right6", gp.tileSize, gp.tileSize);
        up7 = setup("/player/walk_right7", gp.tileSize, gp.tileSize);
        up8 = setup("/player/walk_right8", gp.tileSize, gp.tileSize);

        down1 = setup("/player/walk_left1", gp.tileSize, gp.tileSize);
        down2 = setup("/player/walk_left2", gp.tileSize, gp.tileSize);
        down3 = setup("/player/walk_left3", gp.tileSize, gp.tileSize);
        down4 = setup("/player/walk_left4", gp.tileSize, gp.tileSize);
        down5 = setup("/player/walk_left5", gp.tileSize, gp.tileSize);
        down6 = setup("/player/walk_left6", gp.tileSize, gp.tileSize);
        down7 = setup("/player/walk_left7", gp.tileSize, gp.tileSize);
        down8 = setup("/player/walk_left8", gp.tileSize, gp.tileSize);

        right1 = setup("/player/walk_right1", gp.tileSize, gp.tileSize);
        right2 = setup("/player/walk_right2", gp.tileSize, gp.tileSize);
        right3 = setup("/player/walk_right3", gp.tileSize, gp.tileSize);
        right4 = setup("/player/walk_right4", gp.tileSize, gp.tileSize);
        right5 = setup("/player/walk_right5", gp.tileSize, gp.tileSize);
        right6 = setup("/player/walk_right6", gp.tileSize, gp.tileSize);
        right7 = setup("/player/walk_right7", gp.tileSize, gp.tileSize);
        right8 = setup("/player/walk_right8", gp.tileSize, gp.tileSize);

        left1 = setup("/player/walk_left1", gp.tileSize, gp.tileSize);
        left2 = setup("/player/walk_left2", gp.tileSize, gp.tileSize);
        left3 = setup("/player/walk_left3", gp.tileSize, gp.tileSize);
        left4 = setup("/player/walk_left4", gp.tileSize, gp.tileSize);
        left5 = setup("/player/walk_left5", gp.tileSize, gp.tileSize);
        left6 = setup("/player/walk_left6", gp.tileSize, gp.tileSize);
        left7 = setup("/player/walk_left7", gp.tileSize, gp.tileSize);
        left8 = setup("/player/walk_left8", gp.tileSize, gp.tileSize);
    }
    public void getPlayerAttackImage(){
        attackUp1 = setup("/player/attack_right1.1", gp.tileSize*2, gp.tileSize);
        attackUp2 = setup("/player/attack_right1.2", gp.tileSize*2, gp.tileSize);
        attackUp3 = setup("/player/attack_right1.3", gp.tileSize*2, gp.tileSize);
        attackUp4 = setup("/player/attack_right1.4", gp.tileSize*2, gp.tileSize);
        attackUp5 = setup("/player/attack_right1.5", gp.tileSize*2, gp.tileSize);
        attackUp6 = setup("/player/attack_right1.6", gp.tileSize*2, gp.tileSize);

        attackDown1 = setup("/player/attack_left1.1", gp.tileSize*2, gp.tileSize);
        attackDown2 = setup("/player/attack_left1.2", gp.tileSize*2, gp.tileSize);
        attackDown3 = setup("/player/attack_left1.3", gp.tileSize*2, gp.tileSize);
        attackDown4 = setup("/player/attack_left1.4", gp.tileSize*2, gp.tileSize);
        attackDown5 = setup("/player/attack_left1.5", gp.tileSize*2, gp.tileSize);
        attackDown6 = setup("/player/attack_left1.6", gp.tileSize*2, gp.tileSize);

        attackRight1 = setup("/player/attack_right1.1", gp.tileSize*2, gp.tileSize);
        attackRight2 = setup("/player/attack_right1.2", gp.tileSize*2, gp.tileSize);
        attackRight3 = setup("/player/attack_right1.3", gp.tileSize*2, gp.tileSize);
        attackRight4 = setup("/player/attack_right1.4", gp.tileSize*2, gp.tileSize);
        attackRight5 = setup("/player/attack_right1.5", gp.tileSize*2, gp.tileSize);
        attackRight6 = setup("/player/attack_right1.6", gp.tileSize*2, gp.tileSize);

        attackLeft1 = setup("/player/attack_left1.1", gp.tileSize*2, gp.tileSize);
        attackLeft2 = setup("/player/attack_left1.2", gp.tileSize*2, gp.tileSize);
        attackLeft3 = setup("/player/attack_left1.3", gp.tileSize*2, gp.tileSize);
        attackLeft4 = setup("/player/attack_left1.4", gp.tileSize*2, gp.tileSize);
        attackLeft5 = setup("/player/attack_left1.5", gp.tileSize*2, gp.tileSize);
        attackLeft6 = setup("/player/attack_left1.6", gp.tileSize*2, gp.tileSize);

    }
    public void getPlayerDefendImage(){

        defendLeft1 = setup("/player/defend_left1", gp.tileSize, gp.tileSize);
        defendLeft2 = setup("/player/defend_left2", gp.tileSize, gp.tileSize);
        defendLeft3 = setup("/player/defend_left3", gp.tileSize, gp.tileSize);
        defendLeft4 = setup("/player/defend_left4", gp.tileSize, gp.tileSize);
        defendLeft5 = setup("/player/defend_left5", gp.tileSize, gp.tileSize);
        defendLeft6 = setup("/player/defend_left6", gp.tileSize, gp.tileSize);

        defendRight1 = setup("/player/defend_right1", gp.tileSize, gp.tileSize);
        defendRight2 = setup("/player/defend_right2", gp.tileSize, gp.tileSize);
        defendRight3 = setup("/player/defend_right3", gp.tileSize, gp.tileSize);
        defendRight4 = setup("/player/defend_right4", gp.tileSize, gp.tileSize);
        defendRight5 = setup("/player/defend_right5", gp.tileSize, gp.tileSize);
        defendRight6 = setup("/player/defend_right6", gp.tileSize, gp.tileSize);
    }
    public void update(){

        if(attacking == true){
            attacking();
        }

        else if(keyH.upPressed == true || keyH.downPressed == true 
            || keyH.rightPressed == true || keyH.leftPressed == true
            || keyH.enterPressed == true){
            
                if(keyH.upPressed == true && keyH.rightPressed == true){
                direction = "up_right";
            }
            else if(keyH.upPressed == true && keyH.leftPressed == true){
                direction = "up_left";
            }
            else if(keyH.downPressed == true && keyH.rightPressed == true){
                direction = "down_right";
            }
            else if(keyH.downPressed == true && keyH.leftPressed == true){
                direction = "down_left";
            }

            else if(keyH.upPressed == true){
                direction = "up";
            }
            else if(keyH.downPressed == true){
                direction = "down";
            }
            else if(keyH.rightPressed == true){
                direction = "right";
            }
            else if(keyH.leftPressed == true){
                direction = "left";
            }

            //CHECK TILE COLLISION (KIỂM TRA VA CHẠM TILE)
            collisionOn = false;
            gp.cChecker.checkTile(this);

            //CHECK OBJECT COLLISION (KIỂM TRA VA CHẠM VẬT THỂ)
            int objIndex = gp.cChecker.checkObject(this, true);
            pickUpObject(objIndex);

            // CHECK NPC COLLISION (KIỂM TRA VA CHẠM NPC)
            int npcIndex = gp.cChecker.checkEntity(this, gp.npc);
            interactNPC(npcIndex);

            // CHECK MONSTER COLLISION (KIỂM TRA VA CHẠM QUÁI)
            int monsterIndex = gp.cChecker.checkEntity(this, gp.monster);
            contactMonster(monsterIndex);

            // KIỂM TRA SỰ KIỆN
            gp.eHandler.checkEvent();

            if(collisionOn == false && keyH.enterPressed == false){
                switch (direction) {
                    case "up": worldY -= speed ; break;
                    case "down": worldY += speed; break;
                    case "right": worldX += speed; break;
                    case "left": worldX -= speed; break;
                    case "up_right":
                        worldY -= (int) (speed / Math.sqrt(2));
                        worldX += (int) (speed / Math.sqrt(2));
                        break;
                    case "up_left":
                        worldY -= (int) (speed / Math.sqrt(2));
                        worldX -= (int) (speed / Math.sqrt(2));
                        break;
                    case "down_right":
                        worldY += (int) (speed / Math.sqrt(2));
                        worldX += (int) (speed / Math.sqrt(2));
                        break;
                    case "down_left":
                        worldY += (int) (speed / Math.sqrt(2));
                        worldX -= (int) (speed / Math.sqrt(2));
                        break;
                }
            }

            if(keyH.enterPressed == true && attackCanceled == false){
                attacking = true;
                spriteCounter = 0;
            }

            attackCanceled = false;
            gp.keyH.enterPressed = false;
            
            spriteCounter ++;
            if(spriteCounter > 5){
                if(spriteNum == 1) spriteNum = 2;
                else if(spriteNum == 2) spriteNum = 3;
                else if(spriteNum == 3) spriteNum = 4;
                else if(spriteNum == 4) spriteNum = 5;
                else if(spriteNum == 5) spriteNum = 6;
                else if(spriteNum == 6) spriteNum = 7;
                else if(spriteNum == 7) spriteNum = 8;
                else if(spriteNum == 8) spriteNum = 1;
                spriteCounter = 0;
            }
        }
        else{
            standCounter ++;
            if(standCounter == 8){
                spriteNum = 8;
                standCounter = 0;
            }
        }

        // INVINCIBLE COUNTER (Bộ đếm invincible)
        if(invincible == true){
            invincibleCounter ++;
            if(invincibleCounter > 40){
                invincible = false;
                invincibleCounter = 0;
            }
        }
        if(life > maxLife) life = maxLife;
        if(life <= 0){
            gp.gameState = gp.gameOverState;
        }
        if(killBoss == true){
            gp.gameState = gp.winState;
        }
    }
    public void updateKey(){
        for(int  i = 0; i< inventory.size(); i++){
            if(inventory.get(i).name.equals("Chìa khóa cũ") == true) hasKey++;
        }
    }
    public void pickUpObject(int i){
        if(i != 999){
            if(gp.obj[i].type == type_obstacle){

                if(keyH.enterPressed == true){
                    attackCanceled = true;
                    gp.obj[i].interact();
                }
            }
            else{
                // INVENTORY ITEMS (TÚI ĐỒ)
                String text;
                if(canObtainItem(gp.obj[i]) == true){
                    text = "Đã nhận được " + gp.obj[i].name + "!";
                }
                else{
                    text = "Túi đã đầy!";
                }
                gp.ui.addMessage(text);
                gp.obj[i] = null;
            }
        }
    }
    public int searchItemIndexInInventory(String itemName){
        for(int i = 0; i < inventory.size(); i ++){
            if(inventory.get(i).name.equals(itemName) == true){
                return i;
            }
        }
        return -1;
    }
    public boolean canObtainItem(Entity item){

        boolean canObtain = false;

        // CHECK IF STACKABLE
        if(item.stackable == true){
            int index = searchItemIndexInInventory(item.name);

            if(index != -1){
                inventory.get(index).amount++;
                // System.out.println(amount);
                canObtain = true;
            }
            else{// New item so need to check vacancy
                if(inventory.size() != maxInventorySize){
                    inventory.add(item);
                    canObtain = true;
                }

            }
        }
        else{// NOT STACKABLE so check vacancy
            if(inventory.size() != maxInventorySize){
                inventory.add(item);
                canObtain = true;
            }
        }
        return canObtain;
    }
    public void interactNPC(int i){
        if(gp.keyH.enterPressed == true){
            if(i != 999){
                attackCanceled = true;
                gp.gameState = gp.dialogueState;
                gp.npc[i].speak();
            }
        }
    }
    public void contactMonster(int i){
        if(i != 999){
            if(invincible == false && gp.monster[i].dying == false ){
                int damage = gp.monster[i].attack - defense;
                if(damage < 0) damage = 0;
                gp.player.life -= damage;
                invincible = true;
            }
        }
    }
    public void damageMonster(int i){
        if(i != 999){
            
            if(gp.monster[i].invincible == false){

                int damage = attack - gp.monster[i].defense;
                if(damage < 0) damage = 0;
                gp.monster[i].life -= damage;
                gp.monster[i].invincible = true;
                gp.monster[i].damageReaction();

                if(gp.monster[i].life <= 0){
                    gp.monster[i].dying = true;
                    gp.ui.addMessage("Đã tiêu diệt " + gp.monster[i].name + "!");
                    gp.ui.addMessage("Kinh nghiệm + " + gp.monster[i].exp);
                    exp += gp.monster[i].exp;
                    if(gp.monster[i].name.equals("Final_Boss") == true) killBoss = true;
                    checkLevelUp();
                }
            }
        }
    }
    public void checkLevelUp(){

        if(exp >= nextLevelExp){
            level ++;
            nextLevelExp = nextLevelExp * 2;
            maxLife += 2;
            life += 2;
            attack ++;
            gp.ui.addMessage("Lên cấp!");
            gp.ui.addMessage("Cấp " + level);
        }
    }
    public void selectItem(){

        int itemIndex = gp.ui.getItemIndexOnSlot();

        if(itemIndex < inventory.size()){
            
            Entity selectedItem = inventory.get(itemIndex);
            if(selectedItem.type  == type_consumable){
                if(selectedItem.use(this) == true){
                    if(selectedItem.amount > 1){
                        selectedItem.amount --;
                    }
                    else{
                        inventory.remove(itemIndex);
                    }
                }
            }
        }
    }
    public void draw(Graphics2D g2){

        BufferedImage image = null;
        // STOP CAMERA: Dừng camera khi người chơi ra rìa map
        int x = screenX;
        int y = screenY;

        if(screenX > worldX){
            x = worldX;
        }
        if(screenY > worldY){
            y = worldY;
        }
        int rightOffset = gp.screenWidth - screenX;
        if(rightOffset > gp.worldWidth - worldX){
            x = gp.screenWidth - (gp.worldWidth - worldX);
        }

        int bottomOffset = gp.screenHeight - screenY;
        if(bottomOffset > gp.worldHeight - worldY){
            y = gp.screenHeight - (gp.worldHeight - worldY);
        }
        
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
                    x = x - gp.tileSize;
                    if(spriteNum == 1) image = attackDown1;
                    if(spriteNum == 2) image = attackDown2;
                    if(spriteNum == 3) image = attackDown3;
                    if(spriteNum == 4) image = attackDown4;
                    if(spriteNum == 5) image = attackDown5;
                    if(spriteNum == 6) image = attackDown6;
                }
                break;    
            case "right", "up_right", "down_right":
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
            case "left", "up_left", "down_left":
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
                    x = x - gp.tileSize;
                    if(spriteNum == 1) image = attackLeft1;
                    if(spriteNum == 2) image = attackLeft2;
                    if(spriteNum == 3) image = attackLeft3;
                    if(spriteNum == 4) image = attackLeft4;
                    if(spriteNum == 5) image = attackLeft5;
                    if(spriteNum == 6) image = attackLeft6;
                }
                break;
    
        }
        // KHI NHẬN SÁT THƯƠNG THÌ GIƠ KHIÊN
        if(invincible == true){
            switch (direction) {
                case "up":
                    if(invincibleCounter < 5) image = defendRight1;
                    if(invincibleCounter >= 5 && invincibleCounter < 10) image = defendRight2;
                    if(invincibleCounter >= 10 && invincibleCounter < 15) image = defendRight3;
                    if(invincibleCounter >= 15 && invincibleCounter < 20) image = defendRight4;
                    if(invincibleCounter >= 20 && invincibleCounter < 25) image = defendRight5;
                    if(invincibleCounter >= 25 && invincibleCounter < 30) image = defendRight6;
                    break;
                case "down":
                    if(invincibleCounter < 5) image = defendLeft1;
                    if(invincibleCounter >= 5 && invincibleCounter < 10) image = defendLeft2;
                    if(invincibleCounter >= 10 && invincibleCounter < 15) image = defendLeft3;
                    if(invincibleCounter >= 15 && invincibleCounter < 20) image = defendLeft4;
                    if(invincibleCounter >= 20 && invincibleCounter < 25) image = defendLeft5;
                    if(invincibleCounter >= 25 && invincibleCounter < 20) image = defendLeft6;
                    break;
                case "right":
                    if(invincibleCounter < 5) image = defendRight1;
                    if(invincibleCounter >= 5 && invincibleCounter < 10) image = defendRight2;
                    if(invincibleCounter >= 10 && invincibleCounter < 15) image = defendRight3;
                    if(invincibleCounter >= 15 && invincibleCounter < 20) image = defendRight4;
                    if(invincibleCounter >= 20 && invincibleCounter < 25) image = defendRight5;
                    if(invincibleCounter >= 25 && invincibleCounter < 30) image = defendRight6;
                    break;
                case "left":
                    if(invincibleCounter < 5) image = defendLeft1;
                    if(invincibleCounter >= 5 && invincibleCounter < 10) image = defendLeft2;
                    if(invincibleCounter >= 10 && invincibleCounter < 15) image = defendLeft3;
                    if(invincibleCounter >= 15 && invincibleCounter < 20) image = defendLeft4;
                    if(invincibleCounter >= 20 && invincibleCounter < 25) image = defendLeft5;
                    if(invincibleCounter >= 25 && invincibleCounter < 20) image = defendLeft6;
                    break;
            }
        }
        g2.drawImage(image , x, y, null );
    }
}
