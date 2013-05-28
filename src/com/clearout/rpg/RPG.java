package com.clearout.rpg;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL10;
import com.clearout.rpg.screen.SplashScreen;

public class RPG extends Game {
	public static final String VERSION = "0.01", LOG = "RPG";
	public static final boolean DEBUG = true;
	FPSLogger log;
	
	@Override
	public void create() {
		log = new FPSLogger();
		setScreen(new SplashScreen(this));
	}

	@Override
	public void dispose() {
		super.dispose();
		log.log();
	}

	@Override
	public void render() {		
		super.render();
		log.log();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void pause() {
		super.pause();
	}

	@Override
	public void resume() {
		super.resume();
	}
	public static void clearScreen() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
	}
}
