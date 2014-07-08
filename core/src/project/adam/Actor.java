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
    
    float x;
    float y;
    int height;
    int width;
    float vx;
    float vy;
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
    
    public boolean collide_right(Actor a){
        if(a.bounds.contains(bounds.x+bounds.width,bounds.y)
          || a.bounds.contains(bounds.x+bounds.width,bounds.y+bounds.height)
          || a.bounds.contains(bounds.x+bounds.width,bounds.y+bounds.height/2))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public boolean collide_left(Actor a){
        if(a.bounds.contains(bounds.x,bounds.y)
          || a.bounds.contains(bounds.x,bounds.y+bounds.height)
          || a.bounds.contains(bounds.x,bounds.y+bounds.height/2))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public boolean collide_down(Actor a){
        if(a.bounds.contains(bounds.x,bounds.y)
          || a.bounds.contains(bounds.x+width,bounds.y)
          || a.bounds.contains(bounds.x+width/2,bounds.y))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public boolean collide_up(Actor a){
        if(a.bounds.contains(bounds.x,bounds.y+height)
          || a.bounds.contains(bounds.x+width,bounds.y+height)
          || a.bounds.contains(bounds.x+width/2,bounds.y+height))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
