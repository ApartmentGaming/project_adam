/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project.adam;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;


public class Floor extends Actor{

    public Floor(int a, int b)
    {
        super(a,b);
    }
    
    
    @Override
    public void simple_render(ShapeRenderer sr)
    {
        sr.setColor(Color.GREEN);
        super.simple_render(sr);
    }
}
