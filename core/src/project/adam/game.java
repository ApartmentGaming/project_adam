package project.adam;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import java.util.ArrayList;

public class game extends ApplicationAdapter {

    SpriteBatch batch;
    Texture img;

    ShapeRenderer sr;
    BitmapFont font;
    OrthographicCamera camera;
    Player player;
    ArrayList<Floor> floors;
    
    @Override
    public void create() {
        batch = new SpriteBatch();
        sr = new ShapeRenderer();
        player = new Player(100,100);
        floors = new ArrayList<Floor>();
        
        boolean dummy = false;
        for(int i = 0; i < Gdx.graphics.getWidth(); i+=30)
        {
            if(dummy)
            {
                dummy = false;
                floors.add(new Floor(i,100));
            }
            else
            {
                dummy = true;
            }
        }
    }

    @Override
    public void render() {
        update();
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.end();
        //scamera.update();
        //batch.setProjectionMatrix(camera.combined);

        sr.begin(ShapeRenderer.ShapeType.Filled);
        sr.setColor(0, 1, 0, 1);
        player.simple_render(sr);
        for(Floor f:floors)
        {
            f.simple_render(sr);
        }
        sr.end();

    }
    
    public void update()
    {
        
        player.update();
        for(Floor f:floors)
        {
            if(f.bounds.overlaps(player.bounds))
            {
                player.collision(f);
            }
        }
        
    }

    public void dispose() {

    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }
}
