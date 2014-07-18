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
    float x = 0;
    float y = 0;
    float width = 32;
    float height = 32;
    Rectangle bounds;
    public Floor(float a, float b, float w, float h)
    {
        x = a;
        y = b;
        width = w;
        height = h;
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
        sr.rect(x, y, width, height);
    }
}
