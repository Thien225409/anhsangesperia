package main;

import entity.NPC_OldMan;
import main.Monster.MON_Boss;
import main.Monster.MON_FlyingEye;
import main.Monster.MON_Ghost;
import main.Monster.MON_Goblin;
import main.Monster.MON_Miniboss;
import main.Monster.MON_Mushroom;
import main.Monster.MON_Skeleton;
import main.Monster.MON_Slime;
import object.OBJ_Chest;
import object.OBJ_Door;
import object.OBJ_EnergyDrink;
import object.OBJ_HP_half;
import object.OBJ_Key;
import object.OBJ_Teleport;

public class AssetSetter {

    GamePanel gp;

    public AssetSetter(GamePanel gp){
        this.gp = gp;
        
    }
    public void setObject(){
        gp.obj[1] = new OBJ_Door(gp);
        gp.obj[1].worldX =  gp.tileSize *21;
        gp.obj[1].worldY =  gp.tileSize *6;
        
        gp.obj[2] = new OBJ_Chest(gp, new OBJ_Key(gp));
        gp.obj[2].worldX =  gp.tileSize *67;
        gp.obj[2].worldY =  gp.tileSize *48;

        gp.obj[3] = new OBJ_Chest(gp,new OBJ_EnergyDrink(gp));
        gp.obj[3].worldX =  gp.tileSize *65;
        gp.obj[3].worldY =  gp.tileSize *26;

        gp.obj[4] = new OBJ_Teleport(gp);
        gp.obj[4].worldX =  gp.tileSize *20;
        gp.obj[4].worldY =  gp.tileSize *1;

        gp.obj[5] = new OBJ_Chest(gp,new OBJ_Key(gp));
        gp.obj[5].worldX =  gp.tileSize *1;
        gp.obj[5].worldY =  gp.tileSize *48;

        gp.obj[6] = new OBJ_Chest(gp,new OBJ_HP_half(gp));
        gp.obj[6].worldX =  gp.tileSize *43;
        gp.obj[6].worldY =  gp.tileSize *14;

        gp.obj[7] = new OBJ_Chest(gp,new OBJ_EnergyDrink(gp));
        gp.obj[7].worldX =  gp.tileSize *3;
        gp.obj[7].worldY =  gp.tileSize *28;

        gp.obj[8] = new OBJ_Chest(gp, new OBJ_HP_half(gp));
        gp.obj[8].worldX =  gp.tileSize *35;
        gp.obj[8].worldY =  gp.tileSize *34;

        // gp.obj[9] = new OBJ_Door(gp);
        // gp.obj[9].worldX = 67* gp.tileSize;
        // gp.obj[9].worldY = gp.tileSize*45;
    }

    public void setNPC(){
        gp.npc[0] = new NPC_OldMan(gp);
        gp.npc[0].worldX = gp.tileSize * 3;
        gp.npc[0].worldY = gp.tileSize * 13;

    }

    public void setMonster(){
        gp.monster[0] = new MON_Slime(gp);
        gp.monster[0].worldX = gp.tileSize *4;
        gp.monster[0].worldY = gp.tileSize *15;

        gp.monster[1] = new MON_Slime(gp);
        gp.monster[1].worldX = gp.tileSize *15;
        gp.monster[1].worldY = gp.tileSize *15;

        gp.monster[2] = new MON_Slime(gp);
        gp.monster[2].worldX = gp.tileSize *25;
        gp.monster[2].worldY = gp.tileSize *15;

        gp.monster[3] = new MON_Slime(gp);
        gp.monster[3].worldX = gp.tileSize *35;
        gp.monster[3].worldY = gp.tileSize *15;

        gp.monster[4] = new MON_Slime(gp);
        gp.monster[4].worldX = gp.tileSize *48;
        gp.monster[4].worldY = gp.tileSize *20;

        gp.monster[5] = new MON_Slime(gp);
        gp.monster[5].worldX = gp.tileSize *45;
        gp.monster[5].worldY = gp.tileSize *25;

        gp.monster[6] = new MON_Slime(gp);
        gp.monster[6].worldX = gp.tileSize *45;
        gp.monster[6].worldY = gp.tileSize *35;

        gp.monster[7] = new MON_Slime(gp);
        gp.monster[7].worldX = gp.tileSize *10;
        gp.monster[7].worldY = gp.tileSize *48;

        gp.monster[8] = new MON_Slime(gp);
        gp.monster[8].worldX = gp.tileSize *4;
        gp.monster[8].worldY = gp.tileSize *43;

        gp.monster[9] = new MON_Slime(gp);
        gp.monster[9].worldX = gp.tileSize *25;
        gp.monster[9].worldY = gp.tileSize *48;

        gp.monster[10] = new MON_Slime(gp);
        gp.monster[10].worldX = gp.tileSize *21;
        gp.monster[10].worldY = gp.tileSize *35;

        gp.monster[11] = new MON_Slime(gp);
        gp.monster[11].worldX = gp.tileSize *66;
        gp.monster[11].worldY = gp.tileSize *39;

        // gp.monster[12] = new MON_Slime(gp);
        // gp.monster[12].worldX = gp.tileSize *;
        // gp.monster[12].worldY = gp.tileSize *;

        // gp.monster[13] = new MON_Slime(gp);
        // gp.monster[13].worldX = gp.tileSize *;
        // gp.monster[13].worldY = gp.tileSize *;

        // gp.monster[14] = new MON_Slime(gp);
        // gp.monster[14].worldX = gp.tileSize *;
        // gp.monster[14].worldY = gp.tileSize *;

        // gp.monster[15] = new MON_Slime(gp);
        // gp.monster[15].worldX = gp.tileSize *;
        // gp.monster[15].worldY = gp.tileSize *;

        gp.monster[16] = new MON_Skeleton(gp);
        gp.monster[16].worldX = gp.tileSize *38;
        gp.monster[16].worldY = gp.tileSize *15;

        gp.monster[17] = new MON_Skeleton(gp);
        gp.monster[17].worldX = gp.tileSize *45;
        gp.monster[17].worldY = gp.tileSize *20;

        gp.monster[18] = new MON_Skeleton(gp);
        gp.monster[18].worldX = gp.tileSize *55;
        gp.monster[18].worldY = gp.tileSize *23;

        gp.monster[19] = new MON_Skeleton(gp);
        gp.monster[19].worldX = gp.tileSize *67;
        gp.monster[19].worldY = gp.tileSize *25;

        gp.monster[20] = new MON_Skeleton(gp);
        gp.monster[20].worldX = gp.tileSize *50;
        gp.monster[20].worldY = gp.tileSize *29;

        gp.monster[21] = new MON_Skeleton(gp);
        gp.monster[21].worldX = gp.tileSize *40;
        gp.monster[21].worldY = gp.tileSize *31;

        // gp.monster[22] = new MON_Skeleton(gp);
        // gp.monster[22].worldX = gp.tileSize *;
        // gp.monster[22].worldY = gp.tileSize *;

        // gp.monster[23] = new MON_Skeleton(gp);
        // gp.monster[23].worldX = gp.tileSize *;
        // gp.monster[23].worldY = gp.tileSize *;

        // gp.monster[24] = new MON_Skeleton(gp);
        // gp.monster[24].worldX = gp.tileSize *;
        // gp.monster[24].worldY = gp.tileSize *;

        // gp.monster[25] = new MON_Skeleton(gp);
        // gp.monster[25].worldX = gp.tileSize *;
        // gp.monster[25].worldY = gp.tileSize *;

        gp.monster[26] = new MON_Mushroom(gp);
        gp.monster[26].worldX = gp.tileSize *5;
        gp.monster[26].worldY = gp.tileSize *2;

        gp.monster[27] = new MON_Mushroom(gp);
        gp.monster[27].worldX = gp.tileSize *10;
        gp.monster[27].worldY = gp.tileSize *5;

        gp.monster[28] = new MON_Mushroom(gp);
        gp.monster[28].worldX = gp.tileSize *15;
        gp.monster[28].worldY = gp.tileSize *8;

        // gp.monster[29] = new MON_Mushroom(gp);
        // gp.monster[29].worldX = gp.tileSize *;
        // gp.monster[29].worldY = gp.tileSize *;

        // gp.monster[30] = new MON_Mushroom(gp);
        // gp.monster[30].worldX = gp.tileSize *;
        // gp.monster[30].worldY = gp.tileSize *;

        gp.monster[31] = new MON_Ghost(gp);
        gp.monster[31].worldX = gp.tileSize *11;
        gp.monster[31].worldY = gp.tileSize *15;

        gp.monster[32] = new MON_Ghost(gp);
        gp.monster[32].worldX = gp.tileSize *22;
        gp.monster[32].worldY = gp.tileSize *16;

        gp.monster[33] = new MON_Ghost(gp);
        gp.monster[33].worldX = gp.tileSize *27;
        gp.monster[33].worldY = gp.tileSize *20;

        gp.monster[34] = new MON_Ghost(gp);
        gp.monster[34].worldX = gp.tileSize *17;
        gp.monster[34].worldY = gp.tileSize *22;

        gp.monster[35] = new MON_Ghost(gp);
        gp.monster[35].worldX = gp.tileSize *10;
        gp.monster[35].worldY = gp.tileSize *26;

        gp.monster[36] = new MON_Ghost(gp);
        gp.monster[36].worldX = gp.tileSize *23;
        gp.monster[36].worldY = gp.tileSize *27;

        // gp.monster[37] = new MON_Ghost(gp);
        // gp.monster[37].worldX = gp.tileSize *;
        // gp.monster[37].worldY = gp.tileSize *;

        // gp.monster[38] = new MON_Ghost(gp);
        // gp.monster[38].worldX = gp.tileSize *;
        // gp.monster[38].worldY = gp.tileSize *;

        // gp.monster[39] = new MON_Ghost(gp);
        // gp.monster[39].worldX = gp.tileSize *;
        // gp.monster[39].worldY = gp.tileSize *;

        // gp.monster[40] = new MON_Ghost(gp);
        // gp.monster[40].worldX = gp.tileSize *;
        // gp.monster[40].worldY = gp.tileSize *;

        gp.monster[41] = new MON_FlyingEye(gp);
        gp.monster[41].worldX = gp.tileSize *14;
        gp.monster[41].worldY = gp.tileSize *31;

        gp.monster[42] = new MON_FlyingEye(gp);
        gp.monster[42].worldX = gp.tileSize *12;
        gp.monster[42].worldY = gp.tileSize *38;

        gp.monster[43] = new MON_FlyingEye(gp);
        gp.monster[43].worldX = gp.tileSize *3;
        gp.monster[43].worldY = gp.tileSize *42;

        gp.monster[44] = new MON_FlyingEye(gp);
        gp.monster[44].worldX = gp.tileSize *11;
        gp.monster[44].worldY = gp.tileSize *48;

        gp.monster[45] = new MON_FlyingEye(gp);
        gp.monster[45].worldX = gp.tileSize *22;
        gp.monster[45].worldY = gp.tileSize *47;

        gp.monster[46] = new MON_FlyingEye(gp);
        gp.monster[46].worldX = gp.tileSize *27;
        gp.monster[46].worldY = gp.tileSize *39;

        gp.monster[47] = new MON_FlyingEye(gp);
        gp.monster[47].worldX = gp.tileSize *28;
        gp.monster[47].worldY = gp.tileSize *30;

        // gp.monster[48] = new MON_FlyingEye(gp);
        // gp.monster[48].worldX = gp.tileSize *;
        // gp.monster[48].worldY = gp.tileSize *;

        // gp.monster[49] = new MON_FlyingEye(gp);
        // gp.monster[49].worldX = gp.tileSize *;
        // gp.monster[49].worldY = gp.tileSize *;

        // gp.monster[50] = new MON_FlyingEye(gp);
        // gp.monster[50].worldX = gp.tileSize *;
        // gp.monster[50].worldY = gp.tileSize *;

        gp.monster[51] = new MON_Goblin(gp);
        gp.monster[51].worldX = gp.tileSize *41;
        gp.monster[51].worldY = gp.tileSize *32;

        gp.monster[52] = new MON_Goblin(gp);
        gp.monster[52].worldX = gp.tileSize *42;
        gp.monster[52].worldY = gp.tileSize *46;

        gp.monster[53] = new MON_Goblin(gp);
        gp.monster[53].worldX = gp.tileSize *54;
        gp.monster[53].worldY = gp.tileSize *43;

        gp.monster[54] = new MON_Goblin(gp);
        gp.monster[54].worldX = gp.tileSize *65;
        gp.monster[54].worldY = gp.tileSize *43;

        gp.monster[55] = new MON_Goblin(gp);
        gp.monster[55].worldX = gp.tileSize *64;
        gp.monster[55].worldY = gp.tileSize *36;

        gp.monster[56] = new MON_Goblin(gp);
        gp.monster[56].worldX = gp.tileSize *56;
        gp.monster[56].worldY = gp.tileSize *32;

        // gp.monster[57] = new MON_Goblin(gp);
        // gp.monster[57].worldX = gp.tileSize *;
        // gp.monster[57].worldY = gp.tileSize *;

        // gp.monster[58] = new MON_Goblin(gp);
        // gp.monster[58].worldX = gp.tileSize *;
        // gp.monster[58].worldY = gp.tileSize *;

        // gp.monster[59] = new MON_Goblin(gp);
        // gp.monster[59].worldX = gp.tileSize *;
        // gp.monster[59].worldY = gp.tileSize *;

        gp.monster[60] = new MON_Miniboss(gp);
        gp.monster[60].worldX = gp.tileSize *18;
        gp.monster[60].worldY = gp.tileSize *6;
        
        gp.monster[61] = new MON_Boss(gp);
        gp.monster[61].worldX = gp.tileSize *60;
        gp.monster[61].worldY = gp.tileSize *5;

    }
}
