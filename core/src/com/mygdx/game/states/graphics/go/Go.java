package com.mygdx.game.states.graphics.go;

import com.mygdx.game.Mindgames;
import com.mygdx.game.states.People;

import java.util.HashMap;
import java.util.Map;


public class Go {
    private int height = Mindgames.height;
    private int width = Mindgames.width;

    private static Map<Integer, int[]> blocks = new HashMap<>();

    public Go(){
//        for what?
        blocks.put(1, new int[]{1200, 130});
    }

    public static void letsgo(int distanceX, int distanceY, int numberOfRoom, People obj){
        if(!(isBlock(distanceX, distanceY, numberOfRoom, obj))){
            obj.setCurY(obj.getCurY()+distanceY);
            obj.setCurX(obj.getCurX()+distanceX);
        }
    }

    private static boolean isBlock(int distanceX, int distanceY, int numberOfRoom, People obj) {
        whatIsBlock();
        for (int i = 0; i < 6; i++) {
            if (blocks.get(i).length == 2) {
                if (obj.getCurX() + distanceX <= blocks.get(i)[0] &&
                        (i < 2==true? obj.getCurY() + distanceY >= blocks.get(i)[1]: obj.getCurY() + distanceY <= blocks.get(i)[1]))return true;
            }else if(blocks.get(i).length == 4){
                if(obj.getCurX() + distanceX >= blocks.get(i)[0] && obj.getCurY() + distanceY >= blocks.get(i)[1] &&
                        obj.getCurX() + distanceX <= blocks.get(i)[2] && obj.getCurY() + distanceY <= blocks.get(i)[3])return true;
            }
        }
        return false;
    }

    private static void whatIsBlock(){
        blocks.put(0, new int[]{Mindgames.width+100, (int) (Mindgames.height*0.83)});
        blocks.put(1, new int[]{(int) (Mindgames.width*0.48), (int) (Mindgames.height*0.32407), (int) (Mindgames.width*0.590129), Mindgames.height});
        blocks.put(2, new int[]{(int) (Mindgames.width*0.55794), (int) (Mindgames.height*0.3241), (int) (Mindgames.width*0.699571), (int) (Mindgames.height*0.45)});
        blocks.put(3, new int[]{Mindgames.width, (int) (Mindgames.height*0.04629)});
        blocks.put(4, new int[]{0, 0, (int) (Mindgames.width*0.0214592), Mindgames.height});
        blocks.put(5, new int[]{(int) (Mindgames.width*0.869099), 0, Mindgames.width, Mindgames.height});
    }

}

//