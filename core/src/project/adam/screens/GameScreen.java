/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.adam.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

/**
 *
 * @author Wilson
 */
public abstract class GameScreen implements Screen {

    Game game;

    public GameScreen(Game game) {
        this.game = game;
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void show() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
    }
}
