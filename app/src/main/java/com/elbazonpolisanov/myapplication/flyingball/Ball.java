package com.elbazonpolisanov.myapplication.flyingball;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

import java.util.Random;

public class Ball {
    public int[] direction = new int[]{1, 1};
    public int x, y, size, speed;
    public Paint paint;
    public RectF oval;

    public Ball(int x, int y, int size, int speed, int color) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.size = size;
        this.paint = new Paint();
        this.paint.setColor(color);
        Random rand = new Random();
        if (rand.nextInt() % 2 == 0) changeX();
        if (rand.nextInt() % 2 == 0) changeY();
    }

    protected void changeX() {
        direction[0] = direction[0] * -1;
    }

    protected void changeY() {
        direction[1] = direction[1] * -1;
    }

    protected void changeDirections() {
        changeX();
        changeY();
    }

    protected void moveX() {
        this.x += this.speed * direction[0];
    }

    protected void moveY() {
        this.y += this.speed * direction[1];
    }

    protected void moveXY() {
        moveX();
        moveY();
    }

    public void move(Canvas canvas, Rect rectangle) {
        moveXY();
        this.oval = new RectF(x - size / 2, y - size / 2, x + size / 2, y + size / 2);
        Rect bounds = new Rect();
        this.oval.roundOut(bounds);
        if (!canvas.getClipBounds().contains(bounds)) {
            if (this.x - size < 0 || this.x + size > canvas.getWidth()) changeX();
            if (this.y - size < 0 || this.y + size > canvas.getHeight()) changeY();
        } else if (rectangle.intersects(bounds.left, bounds.top, bounds.right, bounds.bottom))
            changeDirections();
    }
}

