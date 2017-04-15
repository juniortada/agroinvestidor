package com.tadasoftware.agroinvestidor;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;


public class Agroinvestidor extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	TiledMap map;
  OrthographicCamera camera;
  TiledMapRenderer tiledMapRenderer;

	@Override
	public void create () {
		float w = Gdx.graphics.getWidth();
    float h = Gdx.graphics.getHeight();
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");

		camera = new OrthographicCamera();
    camera.setToOrtho(false,w,h);
    camera.update();
		map = new TmxMapLoader().load("mapa.tmx");
    tiledMapRenderer = new OrthogonalTiledMapRenderer(map);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
		camera.update();
    tiledMapRenderer.setView(camera);
    tiledMapRenderer.render();
		batch.end();
	}

	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
