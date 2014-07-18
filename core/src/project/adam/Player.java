/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.adam;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 *
 * @author Wilson
 */
public class Player {

    static final int IDLE = 0;
    static final int RUN = 1;
    static final int JUMP = 2;
    static final int LEFT = -1;
    static final int RIGHT = 1;
    static final float ACCELERATION = 20f;
    static final float JUMP_VELOCITY = 10;
    static final float GRAVITY = 20.0f;
    static final float MAX_VEL = 6f;
    static final float DAMP = 0.90f;

    Vector2 pos = new Vector2();
    Vector2 accel = new Vector2();
    Vector2 vel = new Vector2();
    public Rectangle bounds = new Rectangle();

    int state = IDLE;
    float stateTime = 0;
    int dir = LEFT;
    Map map;
    boolean grounded = false;

    public Player(Map map, float x, float y) {
        this.map = map;
        pos.x = x;
        pos.y = y;
        bounds.width = 32;
        bounds.height = 64;
        bounds.x = x;
        bounds.y = y;
        state = IDLE;
        stateTime = 0;
    }

    public void update(float deltaTime) {
        processKeys();

        accel.y = -GRAVITY;
        accel.scl(deltaTime);
        vel.add(accel.x, accel.y);
        if (accel.x == 0) {
            vel.x *= DAMP;
        }
        if (vel.x > MAX_VEL) {
            vel.x = MAX_VEL;
        }
        if (vel.x < -MAX_VEL) {
            vel.x = -MAX_VEL;
        }
        vel.scl(deltaTime);
       // tryMove();
        vel.scl(1.0f / deltaTime);

        stateTime += deltaTime;
    }

    private void processKeys() {

        float x0 = (Gdx.input.getX(0) / (float) Gdx.graphics.getWidth()) * 480;
        float x1 = (Gdx.input.getX(1) / (float) Gdx.graphics.getWidth()) * 480;
        float y0 = 320 - (Gdx.input.getY(0) / (float) Gdx.graphics.getHeight()) * 320;

        boolean leftButton = (Gdx.input.isTouched(0) && x0 < 70) || (Gdx.input.isTouched(1) && x1 < 70);
        boolean rightButton = (Gdx.input.isTouched(0) && x0 > 70 && x0 < 134) || (Gdx.input.isTouched(1) && x1 > 70 && x1 < 134);
        boolean jumpButton = (Gdx.input.isTouched(0) && x0 > 416 && x0 < 480 && y0 < 64)
                || (Gdx.input.isTouched(1) && x1 > 416 && x1 < 480 && y0 < 64);

        if ((Gdx.input.isKeyPressed(Keys.W) || jumpButton) && state != JUMP) {
            state = JUMP;
            vel.y = JUMP_VELOCITY;
            grounded = false;
        }

        if (Gdx.input.isKeyPressed(Keys.A) || leftButton) {
            if (state != JUMP) {
                state = RUN;
            }
            dir = LEFT;
            accel.x = ACCELERATION * dir;
        } else if (Gdx.input.isKeyPressed(Keys.D) || rightButton) {
            if (state != JUMP) {
                state = RUN;
            }
            dir = RIGHT;
            accel.x = ACCELERATION * dir;
        } else {
            if (state != JUMP) {
                state = IDLE;
            }
            accel.x = 0;
        }
    }

    private void tryMove() {
        // try x
        //try y
    }

    
}
