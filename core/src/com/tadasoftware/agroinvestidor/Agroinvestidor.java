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
// menu
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.kotcrab.vis.ui.VisUI;
import com.kotcrab.vis.ui.VisUI.SkinScale;
import com.kotcrab.vis.ui.widget.MenuBar;
import com.kotcrab.vis.ui.widget.Menu;
import com.kotcrab.vis.ui.widget.MenuItem;

public class Agroinvestidor extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	TiledMap map;
  	OrthographicCamera camera;
  	TiledMapRenderer tiledMapRenderer;

  	// menu
  	private Stage stage;
  	private MenuBar menuBar;

	@Override
	public void create () {
		float w = Gdx.graphics.getWidth();
    	float h = Gdx.graphics.getHeight();
		batch = new SpriteBatch();
		img = new Texture(Gdx.files.internal("tendatocos.png"));

		camera = new OrthographicCamera();
    	camera.setToOrtho(false,w,h);
    	camera.update();
		map = new TmxMapLoader().load("mapa.tmx");
    	tiledMapRenderer = new OrthogonalTiledMapRenderer(map);

    	// menu
    	VisUI.load(SkinScale.X1);
    	stage = new Stage(new ScreenViewport());
    	final Table root = new Table();
    	root.setFillParent(true);
    	stage.addActor(root);

    	Gdx.input.setInputProcessor(stage);

    	menuBar = new MenuBar();
    	menuBar.setMenuListener(new MenuBar.MenuBarListener(){
    		@Override
    		public void menuOpened (Menu menu){
    			System.out.println("Opened menu: " + menu.getTitle());
    		}

    		@Override
    		public void menuClosed (Menu menu){
    			System.out.println("Closed menu: " + menu.getTitle());
    		}
    	});
    	root.add(menuBar.getTable()).expandX().fillX().row();
    	root.add().expand().fill();

    	createMenus();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.update();
    	tiledMapRenderer.setView(camera);
    	tiledMapRenderer.render();
	 	batch.setProjectionMatrix(camera.combined);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
		// menu
		//stage.act(Match.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
		stage.draw();

	}

	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
		// menu
		VisUI.dispose();
		stage.dispose();
	}

	private void createMenus () {
		Menu mercadoMenu = new Menu("Mercado");
		Menu configMenu = new Menu("Configurações");
		Menu ajudaMenu = new Menu("Ajuda");

		mercadoMenu.addItem(new MenuItem("Compra #1"));
		mercadoMenu.addItem(new MenuItem("Venda  #2").setShortcut("f1"));
		mercadoMenu.addItem(new MenuItem("Banco  #3").setShortcut("f2"));

		configMenu.addItem(new MenuItem("Salvar #4"));
		configMenu.addItem(new MenuItem("Sair   #5").setShortcut("f3"));
		configMenu.addSeparator();
		configMenu.addItem(new MenuItem("menuitem #6").setShortcut("f4"));

		ajudaMenu.addItem(new MenuItem("Sobre"));

		menuBar.addMenu(mercadoMenu);
		menuBar.addMenu(configMenu);
		menuBar.addMenu(ajudaMenu);
	}
}
