package com.elbazonpolisanov.myapplication.flyingball;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FlyingBallInside extends View {
    private List<com.elbazonpolisanov.myapplication.flyingball.Ball> balls = new ArrayList<>();
    private Rect rectangle = new Rect();
    private Paint paint= new Paint();
    private boolean isMoving = false;
    public FlyingBallInside(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    public FlyingBallInside(Context context) {
        super(context);
        init();
    }
    protected void init(){
        paint = new Paint();
        paint.setColor(Color.BLUE);
        rectangle.set(0,0,350,200);
    }
    protected void addBall(int x,int y){
        if (balls.size()==10) balls.remove(0);
        Random rand = new Random();
        int sizeBall = rand.nextInt(150) + 50;
        int speed = rand.nextInt(30) + 1;

        balls.add(new com.elbazonpolisanov.myapplication.flyingball.Ball(x,y,sizeBall,speed,Color.argb(255, rand.nextInt(256), rand.nextInt(256), rand.nextInt(256))));
    }
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                if(rectangle.contains((int) ev.getX(),(int) ev.getY())){ //If we are clicking the rectangle
                    isMoving = true;
                }
                else { //If its not in rectangle add new ball
                    addBall((int) ev.getX(), (int) ev.getY());
                }
                invalidate();
                break;
            }
            case MotionEvent.ACTION_MOVE: {
                if (isMoving){
                    int diffX = (int) ev.getX()-rectangle.left;
                    int diffY = (int) ev.getY()-rectangle.top;
                    rectangle.set(rectangle.left+diffX,rectangle.top+diffY,rectangle.right+diffX,rectangle.bottom+diffY);
                }
                invalidate();
                break;
            }
            case MotionEvent.ACTION_UP:
                if (isMoving) isMoving = false;
                break;
        }
        return true;

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //rectangle.set(canvas.getWidth()/3,canvas.getHeight()-500,canvas.getWidth()-canvas.getWidth()/2,canvas.getHeight());
        //
        for(com.elbazonpolisanov.myapplication.flyingball.Ball ball : balls){
            ball.move(canvas,rectangle);
            canvas.drawOval(ball.oval,ball.paint);
        }
        canvas.drawRect(rectangle, paint);
        invalidate(); // See note
    }
}