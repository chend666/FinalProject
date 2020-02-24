package com.example.android.FinalProject;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.List;

public class MultiTouch extends View {

    List<Circle> circles=new ArrayList<>();


    public MultiTouch(Context context) {
        super(context);
    }

    public MultiTouch(Context context, @Nullable AttributeSet attrs) {
        super(context);
    }

    public MultiTouch(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MultiTouch(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    @Override
    protected void  onDraw(Canvas canvas){
        super.onDraw(canvas);
        Paint paint = new Paint();

        for(Circle circle : circles){
            circle.drawIt(canvas, paint);
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event){

        int action=event.getAction();
        int action_code=action&0xff;

        int pointIndex=action>>8;

        float x=event.getX(pointIndex);
        float y=event.getY(pointIndex);

        int pointId=event.getPointerId(pointIndex);

        if (action_code>=5){
            action_code-=5;
        }

        switch (action_code){
            case MotionEvent.ACTION_DOWN://press

                Circle circle=new Circle(x,y,pointId);
                circles.add(circle);
                break;
            case MotionEvent.ACTION_UP:
                circles.remove(get(pointId));
                break;
            case MotionEvent.ACTION_MOVE:
                for (int i = 0; i < event.getPointerCount(); i++) {
                    int id=event.getPointerId(i);
                    get(id).x=event.getX(i);
                    get(id).y=event.getY(i);
                }
                break;
        }

        invalidate();
        return true;
    }



    public Circle get(int pointId){
        for (Circle circle : circles) {
            if (circle.pointId == pointId){
                return circle;
            }
        }
        return null;
    }

}
