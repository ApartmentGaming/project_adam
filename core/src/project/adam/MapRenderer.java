/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.adam;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ImmediateModeRenderer20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector3;

/**
 *
 * @author Wilson
 */
public class MapRenderer {

    Map map;
    OrthographicCamera cam;
    ImmediateModeRenderer20 renderer = new ImmediateModeRenderer20(false, true, 0);
    ShapeRenderer shaperenderer = new ShapeRenderer();
    FPSLogger fps = new FPSLogger();

    public MapRenderer(Map map) {
        this.map = map;
        this.cam = new OrthographicCamera(24, 16);
        //this.cam.position.set(map.player.pos.x, map.player.pos.y, 0);
    }

    float stateTime = 0;
    Vector3 lerpTarget = new Vector3();

    public void render(float deltaTime) {
        
        //cam.position.lerp(lerpTarget.set(map.player.pos.x, map.player.pos.y, 0), 2f * deltaTime);
        cam.update();
        stateTime += deltaTime;
        //shaperenderer.setProjectionMatrix(cam.combined);
        shaperenderer.begin(ShapeType.Filled);
        //renderPlayer();
        
        for(Floor f :map.floors)
        {
            f.render(shaperenderer);
        }
        
        map.player.render(shaperenderer);
        shaperenderer.end();
        fps.log();
    }


    public void dispose() {
        shaperenderer.dispose();
    }
}
