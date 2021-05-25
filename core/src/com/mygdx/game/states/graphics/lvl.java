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

import java.io.IOException;
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
    public static Objects[] items;




    public lvl(int numberOfRoom){
        this.numberOfRoom = numberOfRoom;
    }

    public static void whatsAboutGraphic(String nameOfRoom){
//        GameState.img = new Texture("gg.png");
//        GameState.backgroundRoom = new Texture("backgroundsAndOther/roomOne.jpg");
        Objects book1 = new Objects(
                (int)(Mindgames.width*0.147),
                (int)(Mindgames.height*0.196),
                (int)(Mindgames.width*0.196),
                (int)(Mindgames.height*0.262),
                new Texture("backgroundsAndOther/obj/book1.png"),
                new  Integer[][]{new  Integer[]{}}
        );

        Objects book2 = new Objects(
                (int)(Mindgames.width*0.247),
                (int)(Mindgames.height*0.196),
                (int)(Mindgames.width*0.296),
                (int)(Mindgames.height*0.262),
                new Texture("backgroundsAndOther/obj/book2.png"),
                new  Integer[][]{new  Integer[]{}}
        );

        Objects grib = new Objects(
                (int)(Mindgames.width*0.347),
                (int)(Mindgames.height*0.196),
                (int)(Mindgames.width*0.396),
                (int)(Mindgames.height*0.262),
                new Texture("backgroundsAndOther/obj/grib.png"),
                new  Integer[][]{new  Integer[]{}}
        );

        Objects cat = new Objects(
                (int)(Mindgames.width*0.447),
                (int)(Mindgames.height*0.196),
                (int)(Mindgames.width*0.496),
                (int)(Mindgames.height*0.262),
                new Texture("backgroundsAndOther/obj/cat.png"),
                new  Integer[][]{new  Integer[]{}}
        );


        Objects lattop = new Objects(
                (int)(Mindgames.width*0.547),
                (int)(Mindgames.height*0.196),
                (int)(Mindgames.width*0.596),
                (int)(Mindgames.height*0.262),
                new Texture("backgroundsAndOther/obj/lattop.png"),
                new  Integer[][]{new  Integer[]{}}
        );

        Objects paper1 = new Objects(
                (int)(Mindgames.width*0.647),
                (int)(Mindgames.height*0.196),
                (int)(Mindgames.width*0.696),
                (int)(Mindgames.height*0.262),
                new Texture("backgroundsAndOther/obj/paper1.png"),
                new  Integer[][]{new  Integer[]{2}}
        );

        Objects paper2 = new Objects(
                (int)(Mindgames.width*0.747),
                (int)(Mindgames.height*0.196),
                (int)(Mindgames.width*0.796),
                (int)(Mindgames.height*0.262),
                new Texture("backgroundsAndOther/obj/paper2.png"),
                new  Integer[][]{new  Integer[]{2}}
        );

        items = new Objects[]{book1, book2, cat, lattop, paper1, paper2, grib};


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
                Objects doorUp = new Objects(
                        (int) (Mindgames.width*0.78),
                        (int) (Mindgames.height*0.12),
                        (int) (Mindgames.width*0.8),
                        (int) (Mindgames.height*0.21),null,
                        new  Integer[][]{new  Integer[]{}});
                Objects doorLeft =  new Objects(
                        0,
                        (int) (Mindgames.height*0.8348),
                        (int) (Mindgames.width*0.0001),
                        (int) (Mindgames.height*0.671),null,
                        new  Integer[][]{new  Integer[]{}});
                Objects sofa =  new Objects((int) (Mindgames.width*0.7142),
                        (int) (Mindgames.height*0.13),
                        (int) (Mindgames.width*0.73),
                        (int) (Mindgames.height*0.23),null,
                        new  Integer[][]{new  Integer[]{1, 2, 5, 4}});
                Objects wardrobe =  new Objects((int) (Mindgames.width*0.127),
                        (int) (Mindgames.height*0.13),
                        (int) (Mindgames.width*0.15),
                        (int) (Mindgames.height*0.23),null,
                        new  Integer[][]{new  Integer[]{4, 6, 3, 0}});

                allObj.put(0, new Objects[]{doorLeft, doorUp, sofa, wardrobe});
                GameState.startX= (int) (Mindgames.width*0.06);
                GameState.startY= (int) (Mindgames.height*0.23);
                break;
            case ("GameStateTwo"):
                GameState.backgroundRoom = new Texture(roomsAndData.get(nameOfRoom)[0]);
                GameState.gg = new Texture(roomsAndData.get(nameOfRoom)[1]);
                GameState.btn = new Texture(roomsAndData.get(nameOfRoom)[2]);
                GameState.startX= (int) (Mindgames.width*0.91);
                GameState.startY= (int) (Mindgames.height*0.23);
                Objects doorRight =  new Objects((int) (Mindgames.width*0.97), (int) (Mindgames.height*0.8348),
                        Mindgames.width, (int) (Mindgames.height*0.671),null,
                        new  Integer[][]{new  Integer[]{}});
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
                Profiles.face = new Texture(roomsAndData.get(nameOfRoom)[2]);
                break;
            case("Settings"):
                Settings.background = new Texture(roomsAndData.get(nameOfRoom)[0]);
                Settings.sound = new Texture(roomsAndData.get(nameOfRoom)[1]);
                Settings.notSound = new Texture(roomsAndData.get(nameOfRoom)[2]);
                Settings.back = new Texture(roomsAndData.get(nameOfRoom)[3]);
                break;
        }
    }

    public static Objects[] WhatIn(int howMany){
        Objects[] obj = new Objects[8];
        for (int i = 0; i < howMany; i++) {
            try{
                obj[i] = items[i];
            }catch (ArrayIndexOutOfBoundsException e){

            }
        }
        return (obj);
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
        roomsAndData.put("Profiles", new String[]{"backgroundsAndOther/BackgroundProfiles.png", "backgroundsAndOther/icons/back.png", "backgroundsAndOther/face.png"});
        roomsAndData.put("Settings", new String[]{"backgroundsAndOther/BackgroundProfiles.png", "backgroundsAndOther/icons/sound.png", "backgroundsAndOther/icons/notSound.png", "backgroundsAndOther/icons/back.png"});
    }


}
