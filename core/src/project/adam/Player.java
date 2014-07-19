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
        handle_bounds();
        state = IDLE;
        stateTime = 0;
    }

    public void update(float deltaTime) {
        processKeys();

        tryMove();
        
        stateTime += deltaTime;
        
        
    }

    public void tryMove()
    {
        if(state != IDLE)
            pos.x = pos.x + dir;
        if(!grounded)
            pos.y = pos.y - 5;
        grounded = false;
        handle_bounds();
        for(Floor f: map.floors)
        {
            f.touching = false;
            if(f.bounds.overlaps(bounds))
            {
                floor_collision(f);
            }
        }
        handle_bounds();
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

        if ((Gdx.input.isKeyPressed(Keys.W)) && grounded) {
            pos.y = pos.y + 100;
            grounded = false;
        }

        if (Gdx.input.isKeyPressed(Keys.A)) {
           
                state = RUN;
            
            dir = LEFT;
        } else if (Gdx.input.isKeyPressed(Keys.D)) {
          
                state = RUN;
            
            dir = RIGHT;
        } else {

                state = IDLE;
            
        }
    }
    
    public void handle_bounds()
    {
        bounds.set(pos.x,pos.y,32,64);
        feet_bounds.set(pos.x+8,pos.y,16,16);
        left_bounds.set(pos.x,pos.y+16,16,32);
        right_bounds.set(pos.x+16,pos.y+16,16,32);
        head_bounds.set(pos.x+8,pos.y+bounds.height-16,16,16);
    }

    public void floor_collision(Floor f)
    {
        if(f.bounds.overlaps(feet_bounds))
        {
            pos.y = f.bounds.y + f.bounds.height;
            f.touching = true;
            grounded = true;

        }
        if(f.bounds.overlaps(head_bounds))
        {
            pos.y = f.bounds.y - bounds.height;
            f.touching = true;

        }
                
        if(f.bounds.overlaps(left_bounds))
        {
            pos.x = f.bounds.x + f.bounds.width;
            f.touching = true;

        }
        if(f.bounds.overlaps(right_bounds))
        {
            pos.x = f.bounds.x - bounds.width;
            f.touching = true;
    
        }
        
        
    }
}
