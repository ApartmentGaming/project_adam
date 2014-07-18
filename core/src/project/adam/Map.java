/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.adam;

import java.util.ArrayList;

/**
 *
 * @author Wilson
 */
public class Map {

    static int EMPTY = 0;
    static int TILE = 1;

    public ArrayList<Floor> floors = new ArrayList<Floor>();
    public Player player;

    public Map() {
        floors.add(new Floor(0,100,100,30));
        floors.add(new Floor(80,110,50,40));
        player = new Player(this,20,200);
    }

   

    public void update(float deltaTime) {
       // player.update(deltaTime);

    }
}
