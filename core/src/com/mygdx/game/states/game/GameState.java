package com.mygdx.game.states.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Mindgames;
import com.mygdx.game.states.objects.Objects;
import com.mygdx.game.states.objects.People;
import com.mygdx.game.states.State;
import com.mygdx.game.states.graphics.go.Go;
import com.mygdx.game.states.graphics.lvl;

import org.omg.PortableInterceptor.INACTIVE;

import static com.mygdx.game.Mindgames.prefs;


public class GameState extends State {
    public static Texture gg, gg1;
    private People me = new People((int)(Mindgames.width*0.2), Mindgames.height/2, 12, gg, prefs.getBoolean("isBusy", false));
    private Objects box = new Objects((int) (Mindgames.width*0.457), (int) (Mindgames.height*0.3055),
            (int) (Mindgames.width*0.568), (int) (Mindgames.height*0.09259),null, new Integer[][]{new  Integer[]{1}});
    public static Texture backgroundRoom, backgroundRoomTwo, btnUp, btnDown,
            btnLeft, btnRight, btn, btnTake, back, table,sq;
    public static int startY, startX;

    private int numberOfRoom, flag=1, SMNear=0,takeFlag=0, nav=0, who;




    public GameState(GameStateManager gms, int numberOfRoom) {

        super(gms);
        this.numberOfRoom = numberOfRoom;
        if(Mindgames.wereHere == 0){
            flag=0;
        }
        lvl.whatsAboutGraphic(GameMenu.namesAndNumbers[numberOfRoom]);
        me.setCurX(startX);
        me.setCurY(startY);
    }

    @Override
    protected void handleInput() {

        if (Gdx.input.isTouched()) {
            int x =Gdx.input.getX();
            int y = Gdx.input.getY();

            //control
            if (x> Mindgames.width*0.085 && x < Mindgames.width*0.18 && y > Mindgames.height*0.82 && y < Mindgames.height*0.95) {
                Go.letsgo(-1 * me.getSpeed(), 0, numberOfRoom, me);
                nav=0;
            } else if (x > Mindgames.width*0.3 && x<Mindgames.width*0.4 && y>Mindgames.height*0.82 && y < Mindgames.height*0.95) {
                Go.letsgo(me.getSpeed(), 0, numberOfRoom, me);
                nav=1;
            } else if (x < Mindgames.width*0.3 && x>Mindgames.width*0.18 && y > Mindgames.height *0.82 && y < Mindgames.height*0.95) {
                Go.letsgo(0, -1 * me.getSpeed(), numberOfRoom, me);
            } else if (x < Mindgames.width*0.3 && x>Mindgames.width*0.18 && y < Mindgames.height *0.82&& y > Mindgames.height *0.69) {
                Go.letsgo(0, me.getSpeed(), numberOfRoom, me);
            } else if (y < (Mindgames.height * 0.1) && x < (Mindgames.width * 0.05)) {
                gms.set(new GameMenu(gms));
            }
            if(x>Mindgames.width*0.78 && x<Mindgames.width*0.83 &&
                    y>Mindgames.height *0.82 && y < Mindgames.height*0.95){
                takeFlag=1;
            }
//            else takeFlag=0;
            if((lvl.allObj.get(0)[0]).isNear(me, 50)){
                gms.set(new GameWait(gms, 1));

            }

            if((lvl.allObj.get(0)[1]).isNear(me, 75) && numberOfRoom==0 && prefs.getBoolean("isBusy", false)){
                gms.push(new GameWait(gms, 2));
            }

            if((lvl.allObj.get(0)[2].isNear(me, (int) (Mindgames.height*0.067))) ||
                    (lvl.allObj.get(0)[3].isNear(me, (int) (Mindgames.height*0.067)))){
                SMNear=1;
            }else SMNear=0;

            if((lvl.allObj.get(0)[3].isNear(me, (int) (Mindgames.height*0.067)))){
                who=3;
            }else if((lvl.allObj.get(0)[2].isNear(me, (int) (Mindgames.height*0.067)))){
                who=2;
            }

            if(numberOfRoom == 1) {
                if ((lvl.allObj.get(1)[0]).isNear(me, 50)) {
                    gms.set(new GameWait(gms, 0));
                }
            }

            if(numberOfRoom == 2) {
                if (me.getCurX() < Mindgames.width*0.44 && me.getCurX() > Mindgames.width*0.22
                        && me.getCurY()>Mindgames.height*0.32 && me.getCurY()<Mindgames.height*0.53) {
                    gms.push(new FinishGame(gms));
                }
            }

        }

    }


    @Override
    public void update(float dt) {
        handleInput();
            if (Gdx.input.isTouched()) {
                int x =Gdx.input.getX();
                int y = Gdx.input.getY();
                if(y < (Mindgames.height * 0.1) && x > (Mindgames.width * 0.95))flag=1;
                prefs.putBoolean("first", false);
                prefs.flush();
            }
        }

        protected void isHereNow(){

        }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(backgroundRoom, 0, 0, Mindgames.width, Mindgames.height);
        if(nav==0) sb.draw(gg, me.getCurX(), me.getCurY(), Mindgames.width/20, Mindgames.height/16);
        else sb.draw(gg1, me.getCurX(), me.getCurY(), Mindgames.width/20, Mindgames.height/16);
        sb.draw(btnLeft, (float) (Mindgames.width*0.085), (float) (Mindgames.height*0.05), (float) (Mindgames.width*0.1), (float) (Mindgames.height*0.13));
        sb.draw(btnDown, (float) (Mindgames.width*0.3), (float) (Mindgames.height*0.05), (float) (Mindgames.width*0.1), (float) (Mindgames.height*0.13));
        sb.draw(btnRight, (float) (Mindgames.width * 0.2), (float) (Mindgames.height * 0.05), (float) (Mindgames.width * 0.09), (float) (Mindgames.height * 0.13));
        sb.draw(btnUp, (float) (Mindgames.width*0.2), (float) (Mindgames.height*0.2), (float) (Mindgames.width*0.09), (float) (Mindgames.height*0.11));
        if (flag == 0 && numberOfRoom==0 && prefs.getBoolean("first", true)) {
            sb.draw(sq, 0, 0, (float) (Mindgames.width), (float) (Mindgames.height));
        }
        if(SMNear == 1){
            sb.draw(btnTake, (float)(Mindgames.width*0.76), (float)(Mindgames.height*0.1),(float) (Mindgames.width*0.1), (float) (Mindgames.height*0.13));
            if(takeFlag==1){
                sb.draw(table, 0, 0, (float) (Mindgames.width), (float) (Mindgames.height));
                sb.draw(back, (float) (Mindgames.width*0.9),
                        (float) (Mindgames.height*0.9),
                        (float) (Mindgames.width*0.098),
                        (float) (Mindgames.height*0.09836));
                for (int i = 0; i < lvl.allObj.get(0)[who].getWhatIn()[0].length; i++) {
                    if(!prefs.getBoolean("isBusy") || (lvl.allObj.get(0)[who].getWhatIn()[0][i]!=4)){
                    sb.draw(lvl.items[lvl.allObj.get(0)[who].getWhatIn()[0][i]].getImg(),
                            lvl.items[lvl.allObj.get(0)[who].getWhatIn()[0][i]].getCurX1(),
                            lvl.items[lvl.allObj.get(0)[who].getWhatIn()[0][i]].getCurY1(),
                            (float) (Mindgames.width*0.149),
                            (float) (Mindgames.height*0.16));
                    }
                    System.out.println(lvl.items[4].getCurX1());
                    System.out.println(lvl.items[4].getCurY1());
                }
                if(Gdx.input.isTouched()){
                    int x =Gdx.input.getX();
                    int y = Gdx.input.getY();;
                    if(lvl.items[4].isHere(x,Mindgames.height-y)) {
                        prefs.putBoolean("isBusy", true);
                        prefs.flush();
                    }
                }
            }
            if(Gdx.input.isTouched()){
                int x =Gdx.input.getX();
                int y = Gdx.input.getY();
                if(y < (Mindgames.height * 0.1) && x > (Mindgames.width * 0.95)){
                    SMNear=0;
                    takeFlag=0;
                }
            }
        }
        sb.end();

        System.out.println(prefs.getBoolean("isBusy", false));
    }

    @Override
    public void dispose () {
        gg.dispose();
        backgroundRoom.dispose();
        btn.dispose();
    }
}
