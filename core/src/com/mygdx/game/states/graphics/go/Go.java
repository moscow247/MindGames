package com.mygdx.game.states.graphics.go;

import com.mygdx.game.Mindgames;

import java.util.HashMap;
import java.util.Map;

public class Go {
    private int height = Mindgames.height;
    private int width = Mindgames.width;
    public static int currentX=100;
    public static int currentY=500;
    private static Map<Integer, int[]> blocks = new HashMap<>();

    public Go(){
//        for what?
        blocks.put(1, new int[]{1200, 130});
    }

    public static void letsgo(int distanceX, int distanceY, int numberOfRoom){
        if(!(isBlock(distanceX, distanceY, numberOfRoom))){
            currentY+=distanceY;
            currentX+=distanceX;
        }
    }

    private static boolean isBlock(int distanceX, int distanceY, int numberOfRoom) {
        whatIsBlock();
        for (int i = 0; i < 6; i++) {
            if (blocks.get(i).length == 2) {
                if (currentX + distanceX <= blocks.get(i)[0] &&
                        (i < 2==true? currentY + distanceY >= blocks.get(i)[1]: currentY + distanceY <= blocks.get(i)[1]))return true;
            }else if(blocks.get(i).length == 4){
                if(currentX + distanceX >= blocks.get(i)[0] && currentY + distanceY >= blocks.get(i)[1] &&
                        currentX + distanceX <= blocks.get(i)[2] && currentY + distanceY <= blocks.get(i)[3])return true;
            }
        }
        return false;
    }

    private static void whatIsBlock(){
        blocks.put(0, new int[]{2600, 900});
        blocks.put(1, new int[]{1150, 350, 1375, 1080});
        blocks.put(2, new int[]{1300, 350, 1630, 450});
        blocks.put(3, new int[]{2600, 50});
        blocks.put(4, new int[]{0, 0, 50, 1080});
        blocks.put(5, new int[]{2025, 0, 2335, 1080});
    }

}
