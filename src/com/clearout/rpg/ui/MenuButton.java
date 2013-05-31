package com.clearout.rpg.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

public class MenuButton {
	private InputListener listener;
	private TextButtonStyle style;
	private int x, y, width, height;
	private BitmapFont font;
	private TextButton button;

	public MenuButton(String text, int x, int y, Drawable up, Drawable down) {
		this.x = x;
		this.y = y;
		width = 300;
		height = 100;
		

		font = new BitmapFont(Gdx.files.internal("data/font/whiteFont.fnt"), false);
		style = new TextButtonStyle();
		style.up = up;
		style.down = down;
		style.font = font;

		button = new TextButton(text, style);
		button.setWidth(width);
		button.setHeight(height);
		button.setX(x);
		button.setY(y);
	}

	public TextButton b() {
		return button;
	}

	public boolean addListener(InputListener listener) {
		if (listener == null)
			return false;
		this.listener = listener;
		button.addListener(listener);
		return true;
	}

	public InputListener getListener() {
		return listener;
	}

	public void dispose() {
		font.dispose();
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}
