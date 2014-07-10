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
        vx = 1;
        vy = 1;
        yspeed = 0;
        xspeed = 5;
    }

    public void update() {
        handle_Input();
        y = y + vy*yspeed;
        x = x + vx*xspeed;
       
        
        if (moving_left) {
            vx = -1;
        }
        else if (moving_right) {
            vx = 1;
        }
        else
        {
            vx = 0;
        }
        
        if(grounded)
        {
            yspeed = 0;
            System.out.println("grounded" + bounds.y);
        }
        else
        {
           yspeed += -.001;
        }

        grounded = false;

        if(x < 0)
        {
            x = Gdx.graphics.getWidth() - bounds.width;
        }
        if(x > Gdx.graphics.getWidth())
        {
            x = 0;
        }
        if (y + height < 0) {
            y = Gdx.graphics.getHeight();
        }
        
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
        
        if (Gdx.input.isKeyPressed(Keys.W)) {
            if(grounded)
            {
                yspeed = 3;
            }
        } 

    }

    public void simple_render(ShapeRenderer sr) {
        sr.setColor(Color.RED);
        super.simple_render(sr);
    }

    public void collision(Actor a) {
        if (a instanceof Floor) {
            float vdist = 0;
            float hdist = 0;
            if (collide_down(a)) {
                vdist = a.bounds.y + a.bounds.height - bounds.y;
                y = y + vdist;
                grounded = true;
                super.update();
            }
            if (collide_right(a)) {
                hdist = bounds.x + bounds.width - a.bounds.x;
                x = x - hdist;
                super.update();
            }
            if (collide_left(a)) {
                hdist = a.bounds.x + a.bounds.width - bounds.x;
                x = x + hdist;
                super.update();
            }



        }

    }

}
