package com.mygdx.game.states;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

import java.time.temporal.IsoFields;

public class GameScreen extends State {
    private TiledMap map;
    private AssetManager manager;
    private int tileWidth, tileHeight,
            mapWidthInTiles, mapHeightInTiles,
            mapWidthInPixels, mapHeightInPixels,
            weigth, height;
    private OrthographicCamera camera;
    private OrthogonalTiledMapRenderer renderer;
    private float    rotationSpeed;
    private SpriteBatch batch;
    private Texture texture;
    private Texture textureR;
    private Texture textureL;
    private SpriteBatch GR;
    private SpriteBatch GL;
    private  int GSpeed=10;
    private boolean isVisible;

    public GameScreen(GameStateManager gms) {
        super(gms);
    }

    @Override
    protected void handleInput() {

    }


    @Override
    public void create () {
        rotationSpeed = 0.5f;
        manager = new AssetManager();
        manager.setLoader(TiledMap.class, new TmxMapLoader());
        manager.load("maps/hello.tmx", TiledMap.class);
        manager.finishLoading();


        batch = new SpriteBatch();
        GR = new SpriteBatch();
        GL = new SpriteBatch();
        textureR = new Texture(Gdx.files.internal("gg.png"));
        textureL = new Texture(Gdx.files.internal("gg.png"));
        texture = new Texture(Gdx.files.internal("character.png"));


        map = manager.get("maps/hello.tmx", TiledMap.class);
        MapLayer layer = map.getLayers().get(0);
        isVisible = layer.isVisible();
        MapProperties properties = map.getProperties();
        tileWidth         = properties.get("tilewidth", Integer.class);
        tileHeight        = properties.get("tileheight", Integer.class);
        mapWidthInTiles   = properties.get("width", Integer.class);
        mapHeightInTiles  = properties.get("height", Integer.class);
        mapWidthInPixels  = mapWidthInTiles  * tileWidth;
        mapHeightInPixels = mapHeightInTiles * tileHeight;
        camera = new OrthographicCamera(400.f, 200.f);
        camera.position.x = mapWidthInPixels / 2;
        camera.position.y = mapHeightInPixels / 2;
        renderer = new OrthogonalTiledMapRenderer(map);
        weigth = Gdx.graphics.getWidth();
        height = Gdx.graphics.getHeight();
    }
//
//    @Override
//    public void render () {
//
//        Gdx.gl.glClearColor(.5f, .7f, .9f, 1);
//        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//
//        camera.update();
//        renderer.setView(camera);
//        renderer.render();
//        drawG(false);
//        isVisible = true;
//
//        Gdx.input.setInputProcessor(new InputAdapter() {
//            public boolean touchDown(int x,int y,int pointer,int button) {
//
//                if (x > weigth / 4 && x < weigth /2) {
//                    camera.translate(GSpeed, 0);
//                }else if(x < weigth / 4){
//
//                    camera.translate(-1*GSpeed, 0);
//                }else if(x < 3*(weigth/4) && x > weigth/2){
//                    camera.translate(0, GSpeed);
//                }else if(x > 3*(weigth/4)) {
//                    camera.translate(0, -1*GSpeed);
//                }
//                return false;
//            }
//        });


//        handleInput();
//    }

    private void drawG(boolean naw){
        if (naw){
            GL.begin();
            GL.draw(textureL, weigth/2-4, height/2-8,  tileWidth*3.5f , tileHeight * 3.5f );
            GL.end();
        }else{
            GR.begin();
            GR.draw(textureR, weigth/2-8, height/2-8,  tileWidth *7f+7, tileHeight * 5f+4);
            GR.end();
        }

    }


//    private void handleInput() {
//        if(Gdx.input.isKeyPressed(Input.Keys.A)) {
//            camera.zoom += 0.02;
//        }
//        if(Gdx.input.isKeyPressed(Input.Keys.Q)) {
//            camera.zoom -= 0.02;
//        }
//        if(Gdx.input.isKeyPressed(Input.Keys.S)){
//            camera.zoom = 1;
//        }
//        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
//            if (camera.position.x > 0)
//                camera.translate(-1*(GSpeed), 0, 0);
//        }
//        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
////			if (camera.position.x < 2048)
//            camera.translate(GSpeed, 0, 0);
//        }
//        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
//            if (camera.position.y > 0)
//                camera.translate(0, -1* GSpeed, 0);
//        }
//        if(Gdx.input.isKeyPressed(Input.Keys.UP)) {
////			if (camera.position.y < 2048)
//            camera.translate(0, GSpeed, 0);
//        }
//        if(Gdx.input.isKeyPressed(Input.Keys.W)) {
//            camera.rotate(-rotationSpeed, 0, 0, 1);
//        }
//        if(Gdx.input.isKeyPressed(Input.Keys.E)) {
//            camera.rotate(rotationSpeed, 0, 0, 1);
//        }
//    }

    @Override
    public void dispose () {
        manager.dispose();
    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render(SpriteBatch sb) {

    }
}
