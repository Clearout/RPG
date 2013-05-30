package com.clearout.rpg;

import java.awt.Dimension;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL10;
import com.clearout.rpg.screen.SplashScreen;

public class RPG extends Game {
	private static final String LOG = "RPG";
	public static final String VERSION = "0.01";
	public static final boolean DEBUG = true;
	private FPSLogger log;
	public static final Dimension SIZE = new Dimension(1280, 720);
	
	@Override
	public void create() {
		log = new FPSLogger();
		setScreen(new SplashScreen(this));
	}

	@Override
	public void dispose() {
		super.dispose();
		log("Disposing");
	}

	@Override
	public void render() {		
		super.render();
		log.log();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
		log("Resizing");
	}

	@Override
	public void pause() {
		super.pause();
		log("Pausing");
	}

	@Override
	public void resume() {
		super.resume();
		log("Resuming");
	}
	public static void clearScreen() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
	}
	public static void exit() {
		Gdx.app.exit();
	}
	
	public static void log(String text) {
		Gdx.app.log(LOG, text);
	}
}
