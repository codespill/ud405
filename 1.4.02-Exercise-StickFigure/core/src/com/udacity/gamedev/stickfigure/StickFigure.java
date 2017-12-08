package com.udacity.gamedev.stickfigure;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * TODO: Start here
 * <p>
 * In this exercise you'll set up a ShapeRenderer, and use it to draw a stick figure. At minimum,
 * you'll need a circle for the head, and five lines for the torso, arms, and legs.
 * <p>
 * Remember to set up a ShapeRenderer you'll need to declare it, initialize it, and dispose of it.
 * Then to actually use the ShapeRenderer you'll need to start a batch of the appropriate type, draw
 * your shapes, and end the batch.
 * <p>
 * We don't have step-by-step TODOs for this one, since the aim is for you to remember the steps for
 * setting up a ShapeRenderer and be able to set one up on your own. Of course, the solution is
 * available if you run into anything confusing.
 */
public class StickFigure extends ApplicationAdapter {

    private ShapeRenderer shapeRenderer;
    private int screenWidth, screenHeight;

    @Override
    public void create() {
        shapeRenderer = new ShapeRenderer();
        screenHeight = Gdx.graphics.getHeight();
        screenWidth = Gdx.graphics.getWidth();
    }

    @Override
    public void dispose() {
        shapeRenderer.dispose();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        shapeRenderer.setColor(Color.WHITE);

        // draw Skinny

        // head
        shapeRenderer.translate(screenWidth / 2, 2 * screenHeight / 3, 0);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.circle(0, 0, 45, 30);
        shapeRenderer.end();
        shapeRenderer.identity();

        // body
        shapeRenderer.translate(screenWidth / 2, 2 * screenHeight / 3, 0);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.line(0, 0, 0, -200);
        shapeRenderer.end();
        shapeRenderer.identity();

        // arms
        shapeRenderer.translate(screenWidth / 2, 2 * screenHeight / 3 - 70, 0);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        // left
        shapeRenderer.line(0, 0, -65, -35);
        // right
        shapeRenderer.line(0, 0, 65, -35);
        shapeRenderer.end();
        shapeRenderer.identity();

        // legs
        shapeRenderer.translate(screenWidth / 2, 2 * screenHeight / 3 - 200, 0);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        // left
        shapeRenderer.line(0, 0, -65, -35);
        // right
        shapeRenderer.line(0, 0, 65, -35);
        shapeRenderer.end();
        shapeRenderer.identity();
    }
}
