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
        floors.add(new Floor(60,100,100,30));
        floors.add(new Floor(90,100,100,30));
        floors.add(new Floor(120,100,100,30));
        floors.add(new Floor(150,100,100,30));
        floors.add(new Floor(180,100,100,30));
        floors.add(new Floor(210,100,100,30));
        floors.add(new Floor(240,100,100,30));
        floors.add(new Floor(270,100,100,30));
        floors.add(new Floor(300,100,100,30));
        floors.add(new Floor(330,130,100,30));
        floors.add(new Floor(360,130,100,30));
        floors.add(new Floor(390,130,100,30));
        floors.add(new Floor(420,130,100,30));
        floors.add(new Floor(450,130,100,30));
        floors.add(new Floor(480,130,100,30));
        floors.add(new Floor(520,130,100,30));
        floors.add(new Floor(550,130,100,30));
        floors.add(new Floor(580,130,100,30));
        floors.add(new Floor(610,130,100,30));
        
        
        player = new Player(this,20,200);
    }

   

    public void update(float deltaTime) {
       // player.update(deltaTime);

    }
}
