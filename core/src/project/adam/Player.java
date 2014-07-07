/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.adam;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

/**
 *
 * @author Wilson
 */
public class Player extends Actor {

    public Player(int a, int b) {
        super(a, b);
        vx = 2;
    }

    public void update() {

        handle_Input();
        if(moving_left) x = x - vx;
        if(moving_right) x = x + vx;
        super.update();
        
        if(x < 0)
        {
            x = 0;
        }
        if(x + width > Gdx.graphics.getWidth())
        {
            x = Gdx.graphics.getWidth() - width;
        }
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

}
