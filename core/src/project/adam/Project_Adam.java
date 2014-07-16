/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project.adam;

import com.badlogic.gdx.Game;
import project.adam.screens.TestScreen;

/**
 *
 * @author Wilson
 */
public class Project_Adam extends Game{
    
    public void create(){
        setScreen(new TestScreen(this));
    }
}
