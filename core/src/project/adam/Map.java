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
        floors.add(new Floor(0,100,30,30));
        floors.add(new Floor(30,110,50,40));
        floors.add(new Floor(60,100,30,30));
        floors.add(new Floor(90,100,30,30));
        floors.add(new Floor(120,100,30,30));
        floors.add(new Floor(150,100,30,30));
        floors.add(new Floor(180,100,30,30));
        floors.add(new Floor(210,100,30,30));
        floors.add(new Floor(240,100,30,30));
        floors.add(new Floor(270,100,30,30));
        floors.add(new Floor(300,100,30,30));
        floors.add(new Floor(330,110,30,30));
        floors.add(new Floor(360,120,30,30));
        floors.add(new Floor(390,130,30,30));
        floors.add(new Floor(420,140,30,30));
        floors.add(new Floor(450,130,30,30));
        floors.add(new Floor(480,120,30,30));
        floors.add(new Floor(520,110,30,30));
        floors.add(new Floor(550,100,30,30));
        floors.add(new Floor(580,90,30,30));
        floors.add(new Floor(610,100,30,30));
        
        
        player = new Player(this,20,200);
    }

   

    public void update(float deltaTime) {
          player.update(deltaTime);
    }
    
  
}
