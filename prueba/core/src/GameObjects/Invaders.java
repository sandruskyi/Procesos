package GameObjects;

import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

public class Invaders {

    Vector2 velocity;
    Vector2 position;
    Vector2 acceleration;
    int width;
    int height;
    boolean alive;

    public Invaders(float x, float y, int width, int height, boolean alive) {
        position = new Vector2(x, y);
        velocity = new Vector2(5, 0);
        acceleration = new Vector2(0, 0);
        this.width = width;
        this.height = height;
        this.alive=true;
    }

    public void update(float delta, int signo) {

        velocity.set(velocity.x*signo, velocity.y);

        velocity.add(acceleration.cpy().scl(delta));
        position.add(velocity.cpy().scl(delta));

    }

   /* public void update(float delta) {
        if (position.x > 110) {     //CAMBIAR POR EL TAMANO DE LA PANTALLA
            position.x = 110;
            velocity.set(velocity.x*-1, velocity.y);
        }

        if (position.x < 15) {     //CAMBIAR POR EL TAMANO DE LA PANTALLA
            position.x = 15;
            velocity.set(velocity.x*-1, velocity.y);
        }

            velocity.add(acceleration.cpy().scl(delta));
            position.add(velocity.cpy().scl(delta));

    }/*
/*
    public void update(float delta) {
        position.add(velocity.cpy().scl(delta));

    }*/

    public int getWidth(){
        return this.width;
    }

    public int getHeight(){
        return this.height;
    }

    public Vector2 getPosition(){
        return this.position;
    }


    public boolean isAlive(){
        return this.alive;
    }
}
