/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project.adam;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;


public class Floor{

    boolean touching;
    Rectangle bounds = new Rectangle();
    public Floor(float a, float b, float w, float h)
    {
        bounds.x = a;
        bounds.y = b;
        bounds.width = w;
        bounds.height = h;
    }
    
    
    public void render(ShapeRenderer sr)
    {
        if(touching)
        {
        sr.setColor(Color.GREEN);
        }
        else
        {
            sr.setColor(Color.BLACK);
        }
        sr.rect(bounds.x, bounds.y, bounds.width, bounds.height);
    }
}
