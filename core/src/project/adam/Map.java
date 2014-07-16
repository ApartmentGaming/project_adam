/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.adam;

import com.badlogic.gdx.Gdx;
import static com.badlogic.gdx.Input.Keys.END;
import com.badlogic.gdx.graphics.Pixmap;
import static javax.sound.sampled.LineEvent.Type.START;

/**
 *
 * @author Wilson
 */
public class Map {

    static int EMPTY = 0;
    static int TILE = 1;

    int[][] tiles;
    public Player player;

    public Map() {
        loadBinary();
    }

    private void loadBinary() {
        tiles = new int[Gdx.graphics.getWidth()/32 + 1][Gdx.graphics.getHeight()/32 + 1];

        //player = new Player(this, 100, 200);

        for (int y = 0; y < tiles[0].length; y++) {
            for (int x = 0; x < tiles.length; x++) {

                if(y == 2)
                {
                    tiles[x][y] = 1;
                }
                else
                {
                    tiles[x][y] = 0;
                }
            }
        }

    }

    public void update(float deltaTime) {
       // player.update(deltaTime);

    }
}
