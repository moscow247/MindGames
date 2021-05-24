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
    private People me = new People((int)(Mindgames.width*0.2), Mindgames.height/2, 12, gg, false);
    private Objects box = new Objects((int) (Mindgames.width*0.457), (int) (Mindgames.height*0.3055),
            (int) (Mindgames.width*0.568), (int) (Mindgames.height*0.09259), new String[][]{new String[]{"book"}});
    public static Texture backgroundRoom, backgroundRoomTwo, btnUp, btnDown,
            btnLeft, btnRight, btn, btnTake, back, table,sq;
    public static int startY, startX;

    private int numberOfRoom, flag=1, SMNear=0,takeFlag=0, nav=0;




    public GameState(GameStateManager gms, int numberOfRoom) {

        super(gms);
        this.numberOfRoom = numberOfRoom;
        if(Mindgames.wereHere == 0){
            flag=0;
            Mindgames.wereHere=1;
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

            }else if((lvl.allObj.get(0)[1]).isNear(me, 50)){
                gms.set(new GameWait(gms, 2));
            }
            if((lvl.allObj.get(0)[2].isNear(me, 50))){
                SMNear=1;
            }else SMNear=0;

            if(numberOfRoom == 1) {
                if ((lvl.allObj.get(1)[0]).isNear(me, 50)) {
                    gms.set(new GameWait(gms, 0));
                }
            }

        }

    }


    @Override
    public void update(float dt) {
        handleInput();
            if (Gdx.input.isTouched()) {
                flag=1;
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
            prefs.putBoolean("first", false);
            sb.draw(sq, 0, 0, (float) (Mindgames.width), (float) (Mindgames.height));
        }
        if(SMNear == 1){
            sb.draw(btnTake, (float)(Mindgames.width*0.76), (float)(Mindgames.height*0.1),(float) (Mindgames.width*0.1), (float) (Mindgames.height*0.13));
            if(takeFlag==1){
                sb.draw(table, 0, 0, (float) (Mindgames.width), (float) (Mindgames.height));
                sb.draw(back, (float) (Mindgames.width*0.9), (float) (Mindgames.height*0.9), (float) (Mindgames.width*0.098), (float) (Mindgames.height*0.09836));
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
        System.out.println(me.getCurX());
        System.out.println(me.getCurY());
    }

    @Override
    public void dispose () {
        gg.dispose();
        backgroundRoom.dispose();
        btn.dispose();
    }
}
