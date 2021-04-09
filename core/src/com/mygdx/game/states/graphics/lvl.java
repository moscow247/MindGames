package com.mygdx.game.states.graphics;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.states.GameState;
import com.mygdx.game.states.StartMenuState;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class lvl{
    private ArrayList<String> block = new ArrayList<>();
    private ArrayList<String> get = new ArrayList<>();
    private int numberOfRoom;
    private static Map<String, String[]> roomsAndData = new HashMap<>();

    public lvl(int numberOfRoom){
        this.numberOfRoom = numberOfRoom;
    }

    public static void whatsAboutGraphic(String nameOfRoom){
//        GameState.img = new Texture("gg.png");
//        GameState.backgroundRoom = new Texture("backgroundsAndOther/roomOne.jpg");
        whatIsGraphic();
        switch (nameOfRoom){
            case ("GameState"):
                GameState.backgroundRoom = new Texture(roomsAndData.get(nameOfRoom)[0]);
                GameState.img = new Texture(roomsAndData.get(nameOfRoom)[1]);
                break;
            case ("StartMenuState"):
                StartMenuState.background = new Texture(roomsAndData.get(nameOfRoom)[1]);
                StartMenuState.playButton = new Texture(roomsAndData.get(nameOfRoom)[3]);
                StartMenuState.buttonProfiles = new Texture(roomsAndData.get(nameOfRoom)[2]);
                StartMenuState.title = new Texture(roomsAndData.get(nameOfRoom)[0]);
                break;
        }
    }

    private static void whatIsGraphic(){
        roomsAndData.put("StartMenuState", new String[]{"backgroundsAndOther/title.png", "backgroundsAndOther/backgroundMain.jpg",
                "backgroundsAndOther/ButtonProfiles.png", "backgroundsAndOther/buttonStart.png"});
        roomsAndData.put("GameState", new String[]{"backgroundsAndOther/roomOne.jpg", "gg.png"});

    }

//    private
}
