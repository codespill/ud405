package com.udacity.gamedev.sierpinskitriangle;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.sun.org.apache.regexp.internal.RE;

/**
 * TODO: Start here
 * <p>
 * Your challenge, should you choose to accept it, is to draw a Serpinski Triangle. I offer no hints
 * beyond the fact that ShapeRenderer has a very convenient triangle() function, and that using a
 * FitViewport can simplify matters considerably. Good luck!
 */


public class SierpinskiTriangle extends ApplicationAdapter {

    static final float SIZE = 10;
    private static final int RECURSIONS = 7;

    private ShapeRenderer shapeRenderer;
    private Viewport fitViewport;

    @Override
    public void create() {
        shapeRenderer = new ShapeRenderer();
        fitViewport = new FitViewport(SIZE * 2, SIZE * 2);
    }

    @Override
    public void dispose() {
        shapeRenderer.dispose();
    }

    @Override
    public void resize(int width, int height) {
        fitViewport.update(width, height);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        fitViewport.apply();

        shapeRenderer.setProjectionMatrix(fitViewport.getCamera().combined);

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.triangle(-SIZE / 2f, 0, 0, -calculateHeight(SIZE), SIZE / 2f, 0);
        drawTriangles(0, 0, SIZE / 2, RECURSIONS);
        shapeRenderer.end();

    }

    public void drawTriangles(float x, float y, float size, int recursion) {
        if (recursion == 1) {
            return;
        }

        float height = calculateHeight(size);

        shapeRenderer.translate(x, y, 0);
        shapeRenderer.triangle(-size / 2f, height, 0, 0, size / 2f, height);
        shapeRenderer.identity();
        shapeRenderer.translate(-size + x, y - 2f * height, 0);
        shapeRenderer.triangle(-size / 2f, height, 0, 0, size / 2f, height);
        shapeRenderer.identity();
        shapeRenderer.translate(size + x, y - 2f * height, 0);
        shapeRenderer.triangle(-size / 2f, height, 0, 0, size / 2f, height);
        shapeRenderer.identity();

        drawTriangles(x, y + height, size / 2f, recursion - 1);
        drawTriangles(x - size, y - height, size / 2f, recursion - 1);
        drawTriangles(x + size, y - height, size / 2f, recursion - 1);

    }

    private float calculateHeight(float size) {
        return size / 2f * (float) Math.sqrt(3);
    }
}
