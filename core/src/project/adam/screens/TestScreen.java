/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.adam.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import project.adam.Map;
import project.adam.MapRenderer;

/**
 *
 * @author Wilson
 */
public class TestScreen extends GameScreen {

    Map map;
    MapRenderer renderer;

    public TestScreen(Game game) {
        super(game);
    }

    @Override
    public void show() {
        map = new Map();
        renderer = new MapRenderer(map);
    }

    @Override
    public void render(float delta) {
        delta = Math.min(0.06f, Gdx.graphics.getDeltaTime());
        map.update(delta);
        Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        renderer.render(delta);

    }

    @Override
    public void hide() {

        renderer.dispose();
    }

}
