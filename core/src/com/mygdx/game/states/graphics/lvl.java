package com.mygdx.game.states.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Mindgames;
import com.mygdx.game.states.game.GameMenu;
import com.mygdx.game.states.game.GameState;
import com.mygdx.game.states.StartMenuState;
import com.mygdx.game.states.game.Profiles;
import com.mygdx.game.states.game.Settings;
import com.mygdx.game.states.objects.Objects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.mygdx.game.Mindgames.prefs;

public class lvl{
    private ArrayList<String> block = new ArrayList<>();
    private ArrayList<String> get = new ArrayList<>();
    private int numberOfRoom;
    private static Map<String, String[]> roomsAndData = new HashMap<>();
    public static Map<Integer, Objects[]> allObj = new HashMap<>();

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
                GameState.gg = new Texture(roomsAndData.get(nameOfRoom)[1]);
                GameState.gg1 = new Texture(roomsAndData.get(nameOfRoom)[10]);
                GameState.btn = new Texture(roomsAndData.get(nameOfRoom)[2]);
                GameState.btnRight = new Texture(roomsAndData.get(nameOfRoom)[3]);
                GameState.btnDown = new Texture(roomsAndData.get(nameOfRoom)[4]);
                GameState.btnUp = new Texture(roomsAndData.get(nameOfRoom)[5]);
                GameState.btnLeft = new Texture(roomsAndData.get(nameOfRoom)[6]);
                GameState.btnTake = new Texture(roomsAndData.get(nameOfRoom)[7]);
                GameState.table = new Texture(roomsAndData.get(nameOfRoom)[8]);
                GameState.back = new Texture(roomsAndData.get(nameOfRoom)[9]);
                GameState.sq = new Texture(roomsAndData.get(nameOfRoom)[11]);
                GameState.backgroundRoomTwo = new Texture(roomsAndData.get(nameOfRoom)[3]);
                Objects doorUp = new Objects((int) (Mindgames.width*0.732), 0,
                        (int) (Mindgames.width*0.79), (int) (Mindgames.height*0.1962),
                        new String[][]{new String[]{"out-up"}});
                Objects doorLeft =  new Objects(0, (int) (Mindgames.height*0.8348),
                        (int) (Mindgames.width*0.0214592), (int) (Mindgames.height*0.671),
                        new String[][]{new String[]{"out-left"}});
                Objects sofa =  new Objects((int) (Mindgames.width*0.7142),
                        (int) (Mindgames.height*0.15),
                        (int) (Mindgames.width*0.73),
                        (int) (Mindgames.height*0.25),
                        new String[][]{new String[]{"1234"}});

                allObj.put(0, new Objects[]{doorLeft, doorUp, sofa});
                GameState.startX= (int) (Mindgames.width*0.06);
                GameState.startY= (int) (Mindgames.height*0.23);
                break;
            case ("GameStateTwo"):
                GameState.backgroundRoom = new Texture(roomsAndData.get(nameOfRoom)[0]);
                GameState.gg = new Texture(roomsAndData.get(nameOfRoom)[1]);
                GameState.btn = new Texture(roomsAndData.get(nameOfRoom)[2]);
                GameState.startX= (int) (Mindgames.width*0.91);
                GameState.startY= (int) (Mindgames.height*0.23);
                Objects doorRight =  new Objects((int) (Mindgames.width*0.94), (int) (Mindgames.height*0.8348),
                        Mindgames.width, (int) (Mindgames.height*0.671),
                        new String[][]{new String[]{"out-right"}});
                allObj.put(1, new Objects[]{doorRight});
                break;
            case("GameStateThree"):
                GameState.backgroundRoom = new Texture(roomsAndData.get(nameOfRoom)[0]);
                GameState.gg = new Texture(roomsAndData.get(nameOfRoom)[1]);
                GameState.btn = new Texture(roomsAndData.get(nameOfRoom)[2]);
                GameState.startX= (int) (Mindgames.width*0.91);
                GameState.startY= (int) (Mindgames.height*0.23);

            case ("StartMenuState"):
                StartMenuState.background = new Texture(roomsAndData.get(nameOfRoom)[1]);
                StartMenuState.playButton = new Texture(roomsAndData.get(nameOfRoom)[3]);
                StartMenuState.buttonProfiles = new Texture(roomsAndData.get(nameOfRoom)[2]);
                StartMenuState.buttonSettings = new Texture(roomsAndData.get(nameOfRoom)[4]);
                StartMenuState.title = new Texture(roomsAndData.get(nameOfRoom)[0]);
                break;
            case("GameMenu"):
                GameMenu.background = new Texture(roomsAndData.get(nameOfRoom)[0]);
                GameMenu.buttonFirstLvl = new Texture(roomsAndData.get(nameOfRoom)[1]);
                GameMenu.buttonSecondLvl = new Texture(roomsAndData.get(nameOfRoom)[2]);
                break;
            case("StartAnimation"):
                StartAnimation.logo = new Texture(roomsAndData.get(nameOfRoom)[0]);
                break;
            case("Profiles"):
                Profiles.backgroundProfiles = new Texture(roomsAndData.get(nameOfRoom)[0]);
                Profiles.back = new Texture(roomsAndData.get(nameOfRoom)[1]);
                break;
            case("Settings"):
                Settings.background = new Texture(roomsAndData.get(nameOfRoom)[0]);
                Settings.sound = new Texture(roomsAndData.get(nameOfRoom)[1]);
                Settings.notSound = new Texture(roomsAndData.get(nameOfRoom)[2]);
                Settings.back = new Texture(roomsAndData.get(nameOfRoom)[3]);
                break;
        }
    }

    private static void whatIsGraphic(){
        roomsAndData.put("StartMenuState", new String[]{"backgroundsAndOther/icons/title.png", "backgroundsAndOther/backgroundMenu.jpg",
                "backgroundsAndOther/icons/ButtonProfiles.png", "backgroundsAndOther/icons/buttonStart.png", "backgroundsAndOther/icons/buttonSettings.png"});
        roomsAndData.put("GameStateOne", new String[]{
                "backgroundsAndOther/roomOne.png",
                "gg.png",
                "backgroundsAndOther/icons/sq.png",
                "backgroundsAndOther/icons/down.png",
                "backgroundsAndOther/icons/right.png",
                "backgroundsAndOther/icons/sq.png",
                "backgroundsAndOther/icons/left.png",
                "backgroundsAndOther/icons/take.png",
                "backgroundsAndOther/table.png",
                "backgroundsAndOther/icons/back.png",
                "gg1.png",
                "backgroundsAndOther/icons/sq1.png"
        });
        roomsAndData.put("GameStateTwo", new String[]{"backgroundsAndOther/roomTwo.png",
                "gg.png", "backgroundsAndOther/icons/sq.png"});
        roomsAndData.put("GameStateThree", new String[]{"backgroundsAndOther/roomThree.png",
                "gg.png", "backgroundsAndOther/icons/sq.png"});
        roomsAndData.put("GameMenu", new String[]{"backgroundsAndOther/backgroundStart.jpg", "backgroundsAndOther/icons/btnlvlone.png", "backgroundsAndOther/icons/btnlvltwo.png"});
        roomsAndData.put("StartAnimation", new String[]{"backgroundsAndOther/logo.jpg"});
        roomsAndData.put("Profiles", new String[]{"backgroundsAndOther/BackgroundProfiles.png", "backgroundsAndOther/icons/back.png"});
        roomsAndData.put("Settings", new String[]{"backgroundsAndOther/BackgroundProfiles.png", "backgroundsAndOther/icons/sound.png", "backgroundsAndOther/icons/notSound.png", "backgroundsAndOther/icons/back.png"});
    }


}
