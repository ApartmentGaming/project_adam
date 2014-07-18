/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.adam;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
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
    static final int LEFT = -5;
    static final int RIGHT = 5;
    
    
    static final float JUMP_VELOCITY = 10;
    static final float GRAVITY = 20;
    static final float MAX_VEL = 6;

    Vector2 pos = new Vector2();
    Vector2 accel = new Vector2();
    Vector2 vel = new Vector2();
    public Rectangle bounds = new Rectangle();
    Rectangle feet_bounds = new Rectangle();
    Rectangle left_bounds = new Rectangle();
    Rectangle right_bounds = new Rectangle();
    Rectangle head_bounds = new Rectangle();

    int state = IDLE;
    float stateTime = 0;
    int dir = LEFT;
    Map map;
    boolean grounded = false;

    public Player(Map map, float x, float y) {
        this.map = map;
        pos.x = x;
        pos.y = y;
        bounds.set(x,y,32,64);
        feet_bounds.set(x+8,y,16,16);
        left_bounds.set(x,y+16,16,32);
        right_bounds.set(x+16,y+16,16,32);
        head_bounds.set(x+8,y+bounds.height-16,16,16);
        
        state = IDLE;
        stateTime = 0;
    }

    public void update(float deltaTime) {
        processKeys();

        vel.scl(deltaTime);
        vel.scl(1.0f / deltaTime);

        
        if(state != IDLE)
            pos.x = pos.x + dir;
        
        //pos.y = pos.y + vel.y;
        
        stateTime += deltaTime;
        bounds.set(pos.x,pos.y,32,64);
        feet_bounds.set(pos.x+8,pos.y,16,16);
        left_bounds.set(pos.x,pos.y+16,16,32);
        right_bounds.set(pos.x+16,pos.y+16,16,32);
        head_bounds.set(pos.x+8,pos.y+bounds.height-16,16,16);
        
    }

    public void render(ShapeRenderer sr)
    {

        sr.setColor(Color.RED);
        sr.rect(feet_bounds.x,feet_bounds.y,feet_bounds.width,feet_bounds.height);
        sr.rect(head_bounds.x,head_bounds.y,head_bounds.width,head_bounds.height);
        
        sr.setColor(Color.ORANGE);
        sr.rect(left_bounds.x,left_bounds.y,left_bounds.width,left_bounds.height);
        sr.setColor(Color.YELLOW);
        sr.rect(right_bounds.x,right_bounds.y,right_bounds.width,right_bounds.height);
    }
    private void processKeys() {

//        if ((Gdx.input.isKeyPressed(Keys.W)) && state != JUMP) {
//            state = JUMP;
//            vel.y = JUMP_VELOCITY;
//            grounded = false;
//        }

        if (Gdx.input.isKeyPressed(Keys.A)) {
            if (state != JUMP) {
                state = RUN;
            }
            dir = LEFT;
        } else if (Gdx.input.isKeyPressed(Keys.D)) {
            if (state != JUMP) {
                state = RUN;
            }
            dir = RIGHT;
        } else {
            if (state != JUMP) {
                state = IDLE;
            }
        }
    }

    public void floor_collision(Floor f)
    {
        
    }
}
