package GameWorld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;

import GameObjects.PlayerShip;
import Helpers.AssetLoader;

public class GameRenderer {

    private GameWorld myWorld;
    private OrthographicCamera cam;
    private ShapeRenderer shapeRenderer;

    private SpriteBatch batcher;

    private int midPointY;
    private int gameHeight;

    public GameRenderer(GameWorld world, int gameHeight, int midPointY) {
        myWorld = world;

        // The word "this" refers to this instance.
        // We are setting the instance variables' values to be that of the
        // parameters passed in from GameScreen.
        this.gameHeight = gameHeight;
        this.midPointY = midPointY;

        cam = new OrthographicCamera();
        cam.setToOrtho(true, 136, gameHeight);

        batcher = new SpriteBatch();
        batcher.setProjectionMatrix(cam.combined);
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined);
    }

    public void buttons(){
        Stage stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        ImageButton buttonLeft = AssetLoader.buttonLeft(25, 100);
        stage.addActor(buttonLeft);

        ImageButton buttonRight = AssetLoader.buttonRight(125, 100);
        stage.addActor(buttonRight);

        ImageButton buttonShoot = AssetLoader.buttonShoot(200, 100);
        stage.addActor(buttonShoot);

        // aqui va la funcionalidad de los botones
        buttonLeft.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.log("buttonLeft", "Boton izquierdo pulsado");
                return true;
            }});

        buttonRight.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.log("buttonRight", "Boton derecho pulsado");
                return true;
            }});

        buttonShoot.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.log("buttonShoot", "Boton de disparo pulsado");
                return true;
            }});

        stage.act();
        stage.draw();
    }

    public void render(float runTime) {

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        shapeRenderer.setColor(Color.BLUE);
        shapeRenderer.rect(0, 0, 136, midPointY + 66);

        shapeRenderer.setColor(Color.GREEN);
        shapeRenderer.rect(0, midPointY + 77, 136, 52);

        shapeRenderer.end();

        batcher.begin();
            batcher.disableBlending();
            batcher.draw(AssetLoader.textureBg,0, 0, 200, 500);
            batcher.enableBlending();
            batcher.draw(AssetLoader.texturePlayer,10,50, PlayerShip.getWidth(),PlayerShip.getHeight());

        batcher.end();

        buttons(); // Pone los botones

        //Falta el sprite
    }

}