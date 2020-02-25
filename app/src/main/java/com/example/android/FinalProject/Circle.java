package com.example.android.FinalProject;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.Random;

public class Circle {
    public float x;
    public float y;
    public int radius = 100;
    public int pointId;
    int red;
    int green;
    int blue;
    Random random = new Random();
    int color = 0;

    public Circle(float x, float y, int pointId){
        this.x = x;
        this.y = y;
        this.pointId = pointId;
        red=random.nextInt(255);
        green=random.nextInt(255);
        blue=random.nextInt(255);
    }

    public  void drawIt(Canvas canvas, Paint paint){

        paint.setColor(Color.rgb(red,green,blue));
        color = paint.getColor();
        canvas.drawCircle(x,y,radius,paint);
    }
}
