package com.clearout.rpg.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.clearout.rpg.RPG;
import com.clearout.rpg.ui.MenuButton;

public class MainMenuScreen implements Screen {
	private RPG game;
	private Stage stage;
	SpriteBatch batch;
	Label label;
	private MenuButton play, settings, exit;
	private Texture buttonUpTexture, buttonDownTexture, backgroundRightTexture;
	private Sprite buttonUp, buttonDown;
	private Image backgroundRight;
	private SpriteDrawable buttonUpDrawable, buttonDownDrawable;

	public MainMenuScreen(RPG game) {
		this.game = game;

		stage = new Stage(RPG.SIZE.width, RPG.SIZE.height, true);
		stage.clear();

		batch = new SpriteBatch();

		buttonUpTexture = new Texture("data/image/PlankButtonUp.png");
		buttonDownTexture = new Texture("data/image/PlankButtonDown.png");
		backgroundRightTexture = new Texture("data/image/PlankBackground.png");
		buttonUpTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		buttonDownTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		backgroundRightTexture.setFilter(TextureFilter.Linear,
				TextureFilter.Linear);

		buttonUp = new Sprite(buttonUpTexture);
		buttonDown = new Sprite(buttonDownTexture);
		backgroundRight = new Image(backgroundRightTexture);
		
		backgroundRight.setX(RPG.SIZE.width - backgroundRight.getWidth());
		backgroundRight.setY(0);
		backgroundRight.setWidth(backgroundRightTexture.getWidth());
		backgroundRight.setHeight(backgroundRightTexture.getHeight());
		
		buttonUpDrawable = new SpriteDrawable(buttonUp);
		buttonDownDrawable = new SpriteDrawable(buttonDown);

		Gdx.input.setInputProcessor(stage);

		play = new MenuButton("Play", RPG.SIZE.width - 400,
				RPG.SIZE.height - 250, buttonUpDrawable, buttonDownDrawable);
		settings = new MenuButton("Settings", RPG.SIZE.width - 400,
				RPG.SIZE.height - 400, buttonUpDrawable, buttonDownDrawable);
		exit = new MenuButton("Exit", RPG.SIZE.width - 400,
				RPG.SIZE.height - 550, buttonUpDrawable, buttonDownDrawable);
		addListeners();		
	}

	@Override
	public void render(float delta) {
		RPG.clearScreen();
		stage.act(delta);

		batch.begin();
		stage.draw();
		batch.end();
	}

	private void addListeners() {
		play.addListener(new InputListener() {
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				return true;
			}

			public void touchUp(InputEvent event, float x, float y,
					int pointer, int button) {
				// MAKE PLAYOPTIONSSCREEN
			}
		});
		settings.addListener(new InputListener() {
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				return true;
			}

			public void touchUp(InputEvent event, float x, float y,
					int pointer, int button) {
				// MAKE SETTIGNSMENU
			}
		});
		exit.addListener(new InputListener() {
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				return true;
			}

			public void touchUp(InputEvent event, float x, float y,
					int pointer, int button) {
				RPG.exit();
			}
		});
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
		stage.addActor(backgroundRight);
		stage.addActor(play.b());
		stage.addActor(settings.b());
		stage.addActor(exit.b());
	}

	@Override
	public void hide() {
		dispose();
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
		batch.dispose();
		stage.dispose();
	}

}
