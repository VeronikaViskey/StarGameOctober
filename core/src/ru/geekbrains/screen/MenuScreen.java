package ru.geekbrains.screen;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.BaseScreen;
import ru.geekbrains.math.Rect;
import ru.geekbrains.sprite.Background;
import ru.geekbrains.sprite.Logo;

public class MenuScreen extends BaseScreen {

    private Texture bg;
    private Texture img;
    private Background background;
    private Logo logo;

    @Override
    public void show() {
        super.show();
        bg = new Texture("bg.jpg");
        background = new Background(bg);
        img = new Texture("badlogic.jpg");
        logo = new Logo(img);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update(delta);
        draw();
    }

    @Override
    public void resize(Rect worldBounds) {
        background.resize(worldBounds);
        logo.resize(worldBounds);
    }

    @Override
    public void dispose() {
        bg.dispose();
        img.dispose();
        super.dispose();
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        logo.touchDown(touch, pointer, button);
        return false;
    }
    private void update(float delta) {
        logo.update(delta);
    }

    private void draw() {
        batch.begin();
        background.draw(batch);
        logo.draw(batch);
        batch.end();
    }
}
