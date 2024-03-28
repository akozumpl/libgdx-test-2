package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;

	int x = 250;

	@Override
	public void create() {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
	}

	@Override
	public void render() {
		ScreenUtils.clear(1, 2, 0, 1);
		batch.begin();
		// batch.draw(img, 5, 0);
		// batch.setColor(0, 1, 0, 1f);

		Pixmap pixmap = new Pixmap(65, 65, Format.RGBA8888);
		pixmap.setColor(1, 0, 0, 1);
		pixmap.fillCircle(32, 32, 32);
		Texture pixmaptex = new Texture(pixmap);
		pixmap.dispose();

		batch.draw(pixmaptex, x, 350);

		if (Gdx.input.isKeyPressed(Keys.LEFT)) {
			x -= 10 * Gdx.graphics.getDeltaTime();
		} else if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
			x += 10 * Gdx.graphics.getDeltaTime() + 1;
		}

		batch.end();
		System.out.println(Gdx.graphics.getDeltaTime());
	}

	@Override
	public void dispose() {
		batch.dispose();
		img.dispose();
	}
}
