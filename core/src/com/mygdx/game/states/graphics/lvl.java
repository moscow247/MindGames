package com.mygdx.game.states.graphics;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Mindgames;
import com.mygdx.game.states.objects.Profiles;
import com.mygdx.game.states.game.GameMenu;
import com.mygdx.game.states.game.GameState;
import com.mygdx.game.states.StartMenuState;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class lvl{
    private ArrayList<String> block = new ArrayList<>();
    private ArrayList<String> get = new ArrayList<>();
    private int numberOfRoom;
    private static Map<String, String[]> roomsAndData = new HashMap<>();
    public static Map<Integer, Profiles.Objects[]> allObj = new HashMap<>();

    public lvl(int numberOfRoom){
        this.numberOfRoom = numberOfRoom;
    }

    public static void whatsAboutGraphic(String nameOfRoom){
//        GameState.img = new Texture("gg.png");
//        GameState.backgroundRoom = new Texture("backgroundsAndOther/roomOne.jpg");
        whatIsGraphic();
        switch (nameOfRoom){
            case ("GameStateOne"):
                GameState.backgroundRoom = new Texture(roomsAndData.get(nameOfRoom)[0]);
                GameState.texture = new Texture(roomsAndData.get(nameOfRoom)[1]);
                GameState.btn = new Texture(roomsAndData.get(nameOfRoom)[2]);
                GameState.backgroundRoomTwo = new Texture(roomsAndData.get(nameOfRoom)[3]);
                Profiles.Objects doorUp = new Profiles.Objects((int) (Mindgames.width*0.804), (int) (Mindgames.height*0.055),
                        (int) (Mindgames.width*0.88), (int) (Mindgames.height*0.1422),
                        new String[][]{new String[]{"out-up"}});
                Profiles.Objects doorLeft =  new Profiles.Objects(0, (int) (Mindgames.height*0.8348),
                        (int) (Mindgames.width*0.0214592), (int) (Mindgames.height*0.671),
                        new String[][]{new String[]{"out-left"}});
                allObj.put(0, new Profiles.Objects[]{doorLeft, doorUp});
                GameState.startX= (int) (Mindgames.width*0.06);
                GameState.startY= (int) (Mindgames.height*0.23);
                break;
            case ("GameStateTwo"):
                GameState.backgroundRoom = new Texture(roomsAndData.get(nameOfRoom)[0]);
                GameState.texture = new Texture(roomsAndData.get(nameOfRoom)[1]);
                GameState.btn = new Texture(roomsAndData.get(nameOfRoom)[2]);
                GameState.startX= (int) (Mindgames.width*0.91);
                GameState.startY= (int) (Mindgames.height*0.23);
                Profiles.Objects doorRight =  new Profiles.Objects((int) (Mindgames.width*0.94), (int) (Mindgames.height*0.8348),
                        Mindgames.width, (int) (Mindgames.height*0.671),
                        new String[][]{new String[]{"out-left"}});
                allObj.put(1, new Profiles.Objects[]{doorRight});
                break;
            case ("StartMenuState"):
                StartMenuState.background = new Texture(roomsAndData.get(nameOfRoom)[1]);
                StartMenuState.playButton = new Texture(roomsAndData.get(nameOfRoom)[3]);
                StartMenuState.buttonProfiles = new Texture(roomsAndData.get(nameOfRoom)[2]);
                StartMenuState.title = new Texture(roomsAndData.get(nameOfRoom)[0]);
                break;
            case("GameMenu"):
                GameMenu.background = new Texture(roomsAndData.get(nameOfRoom)[0]);
                GameMenu.buttonFirstLvl = new Texture(roomsAndData.get(nameOfRoom)[1]);
                GameMenu.buttonSecondLvl = new Texture(roomsAndData.get(nameOfRoom)[2]);
                break;
            case("StartAnimation"):
                StartAnimation.logo = new Texture(roomsAndData.get(nameOfRoom)[0]);
        }
    }

    private static void whatIsGraphic(){
        roomsAndData.put("StartMenuState", new String[]{"backgroundsAndOther/title.png", "backgroundsAndOther/backgroundMenu.jpg",
                "backgroundsAndOther/ButtonProfiles.png", "backgroundsAndOther/buttonStart.png"});
        roomsAndData.put("GameStateOne", new String[]{"backgroundsAndOther/roomOne.png", "gg.png", "backgroundsAndOther/sq.png", "backgroundsAndOther/roomTwo.png"});
        roomsAndData.put("GameStateTwo", new String[]{"backgroundsAndOther/roomTwo.png", "gg.png", "backgroundsAndOther/sq.png"});
        roomsAndData.put("GameMenu", new String[]{"backgroundsAndOther/backgroundStart.jpg", "backgroundsAndOther/btnlvlone.png", "backgroundsAndOther/btnlvltwo.png"});
        roomsAndData.put("StartAnimation", new String[]{"backgroundsAndOther/logo.jpg"});
    }

}
