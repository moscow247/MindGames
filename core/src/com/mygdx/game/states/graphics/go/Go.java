package com.mygdx.game.states.graphics.go;

import com.mygdx.game.Mindgames;
import com.mygdx.game.states.objects.People;

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
        int k;
        switch (numberOfRoom){
            case (1):
                k=20;
                break;
            case(2):
                k = 40;
                break;
            case(3):
                k=60;
                break;
            default:
                k=0;

        }
        whatIsBlock();
        for (int i = k; i < 7+k; i++) {
            if (blocks.get(i).length == 2) {
                if (obj.getCurX() + distanceX <= blocks.get(i)[0] &&
                        (i < 2 + k ? obj.getCurY() + distanceY >= blocks.get(i)[1]: obj.getCurY()
                                + distanceY <= blocks.get(i)[1]))return true;
            }else if(blocks.get(i).length == 4){
                if(obj.getCurX() + distanceX >= blocks.get(i)[0] && obj.getCurY() + distanceY >= blocks.get(i)[1] &&
                        obj.getCurX() + distanceX <= blocks.get(i)[2] && obj.getCurY() + distanceY <= blocks.get(i)[3])return true;
            }
        }
        return false;
    }

    private static void whatIsBlock(){
        blocks.put(0, new int[]{Mindgames.width+100, (int) (Mindgames.height*0.83)});
        blocks.put(1, new int[]{(int) (Mindgames.width*0.28), (int) (Mindgames.height*0.25), (int) (Mindgames.width*0.35), Mindgames.height});
        blocks.put(2, new int[]{(int) (Mindgames.width*0.44), (int) (Mindgames.height*0.279), (int) (Mindgames.width*0.967), (int) (Mindgames.height*0.42)});
        blocks.put(3, new int[]{Mindgames.width, (int) (Mindgames.height*0.04629)});
        blocks.put(4, new int[]{0, (int) (Mindgames.height*0.345), (int) (Mindgames.width*0.0214592), (int) (Mindgames.height)});
        blocks.put(5, new int[]{0, 0, (int) (Mindgames.width*0.0214592), (int) (Mindgames.height*0.214)});
        blocks.put(6, new int[]{(int) (Mindgames.width*0.92), 0, Mindgames.width, Mindgames.height});

        ///

        blocks.put(20, new int[]{Mindgames.width+100, (int) (Mindgames.height*0.83)});
        blocks.put(21, new int[]{});
        blocks.put(22, new int[]{(int) (Mindgames.width*0.92), (int) (Mindgames.height*0.329), Mindgames.width, (int) (Mindgames.height)});
        blocks.put(23, new int[]{Mindgames.width, (int) (Mindgames.height*0.04629)});
        blocks.put(24, new int[]{0, 0, (int) (Mindgames.width*0.0214592), Mindgames.height});
        blocks.put(25, new int[]{(int) (Mindgames.width*0.92), 0, Mindgames.width, (int) (Mindgames.height*0.1652)});
        blocks.put(26, new int[]{});

    }

}

//