package com.clearout.rpg.screen;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenAccessor;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenEquations;
import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.clearout.rpg.RPG;

public class SplashScreen implements Screen {
	private Texture splashTexture;
	private Sprite splashSprite;
	private SpriteBatch batch;
	RPG game;
	TweenManager manager;

	public SplashScreen(RPG game) {
		this.game = game;
	}

	@Override
	public void render(float delta) {
		RPG.clearScreen();

		manager.update(delta);

		batch.begin();
		splashSprite.draw(batch);
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
		splashTexture = new Texture("data/image/SplashScreen.png");
		splashTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		splashSprite = new Sprite(splashTexture);
		splashSprite.setColor(1, 1, 1, 0);
		splashSprite.setX(Gdx.graphics.getWidth() / 2 - splashSprite.getWidth()
				/ 2);
		splashSprite.setY(Gdx.graphics.getHeight() / 2
				- splashSprite.getHeight() / 2);

		batch = new SpriteBatch();

		Tween.registerAccessor(Sprite.class, new SpriteTween());

		manager = new TweenManager();

		TweenCallback cb = new TweenCallback() {
			@Override
			public void onEvent(int type, BaseTween<?> source) {
				tweenCompleted();
			}
		};
		Tween.to(splashSprite, SpriteTween.ALPHA, 1f).target(1)
				.ease(TweenEquations.easeInSine).repeatYoyo(1, 1f)
				.setCallback(cb).setCallbackTriggers(TweenCallback.COMPLETE)
				.start(manager);
	}

	private void tweenCompleted() {
		Gdx.app.log(RPG.LOG, "Tween complete");
		// MAINMENUSCREEN
	}

	@Override
	public void hide() {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
	}

	private class SpriteTween implements TweenAccessor<Sprite> {
		public static final int ALPHA = 1;

		@Override
		public int getValues(Sprite target, int tweenType, float[] returnValues) {
			switch (tweenType) {
			case ALPHA:
				returnValues[0] = target.getColor().a;
				return ALPHA;
			default:
				return 0;
			}
		}

		@Override
		public void setValues(Sprite target, int tweenType, float[] newValues) {
			switch (tweenType) {
			case ALPHA:
				target.setColor(1, 1, 1, newValues[0]);
				break;
			}
		}

	}
}
