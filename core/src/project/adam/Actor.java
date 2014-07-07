/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project.adam;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

/**
 *
 * @author Wilson
 */
public class Actor {
    
    int x;
    int y;
    int height;
    int width;
    int vx;
    int vy;
    Texture sprite;
    Rectangle bounds;
    
    public Actor(int a, int b){
        x = a;
        y = b;
        width = 32;
        height = 32;
        
        bounds = new Rectangle(x,y,width,height);
             
    }
    
    public void update()
    {
        bounds.setPosition(x,y);
    }
    
    public void sprite_render(SpriteBatch batch)
    {
        batch.draw(sprite,x,y);
    }
    
    public void simple_render(ShapeRenderer sp)
    {
        sp.rect(bounds.x, bounds.y, bounds.width, bounds.height);
    }
    
    public boolean collision(Actor a){
        return a.bounds.overlaps(bounds);
    }
}
