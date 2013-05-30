package com.clearout.rpg.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.clearout.rpg.RPG;
import com.clearout.rpg.ui.MenuButton;

public class MainMenuScreen implements Screen {
	private RPG game;
	private Stage stage;
	Skin skin;
	SpriteBatch batch;
	Label label;
	private TextureAtlas atlas;
	private MenuButton play, settings, exit;

	public MainMenuScreen(RPG game) {
		this.game = game;

		stage = new Stage(RPG.SIZE.width, RPG.SIZE.height, true);
		stage.clear();

		batch = new SpriteBatch();
		atlas = new TextureAtlas("data/image/button.pack");
		skin = new Skin();
		skin.addRegions(atlas);

		Gdx.input.setInputProcessor(stage);

		play = new MenuButton("Play", RPG.SIZE.width - 400,
				RPG.SIZE.height - 200, skin.getDrawable("button"),
				skin.getDrawable("buttonPressed"));
		settings = new MenuButton("Settings", RPG.SIZE.width - 400,
				RPG.SIZE.height - 400, skin.getDrawable("button"),
				skin.getDrawable("buttonPressed"));
		exit = new MenuButton("Exit", RPG.SIZE.width - 400,
				RPG.SIZE.height - 600, skin.getDrawable("button"),
				skin.getDrawable("buttonPressed"));
		addListeners();

		stage.addActor(play.b());
		stage.addActor(settings.b());
		stage.addActor(exit.b());
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
		skin.dispose();
		atlas.dispose();
		stage.dispose();
	}

}
