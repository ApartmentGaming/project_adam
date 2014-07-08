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

/**
 *
 * @author Wilson
 */
public class Player extends Actor {

    public boolean grounded = false;
    public boolean jumping = false;
    
    public Player(int a, int b) {
        super(a, b);
        vx = 5;
        vy = 0;
    }

    public void update() {

        handle_Input();
        if(moving_left) x = x - vx;
        if(moving_right) x = x + vx;
        super.update();
        
    }

    boolean moving_left = false;
    boolean moving_right = false;

    public void handle_Input() {
        if (Gdx.input.isKeyPressed(Keys.A)) {
            if (!moving_right) {
                moving_left = true;
            }
        } else {
            moving_left = false;
        }
        if (Gdx.input.isKeyPressed(Keys.D)) {
            if (!moving_left) {
                moving_right = true;
            }
        } else {
            moving_right = false;
        }
        
    }
    
    public void simple_render(ShapeRenderer sr)
    {
        sr.setColor(Color.RED);
        super.simple_render(sr);
    }
    
    public void collision(Actor a)
    {
        if(a instanceof Floor)
        {
            if(collide_right(a))
            {
                x = a.x - width;
            }
            if(collide_left(a))
            {
                x = a.x + a.width;
            }
            super.update();
        }
        
    }

}
