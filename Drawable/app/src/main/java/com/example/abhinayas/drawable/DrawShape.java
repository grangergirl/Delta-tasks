package com.example.abhinayas.drawable;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

import com.example.abhinayas.drawable.R;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by ABHINAYA  S on 12-06-2016.
 */
public class DrawShape extends View {
    Bitmap shape;
   public int d,c;
    MainActivity m;
   static public int x,y;
    //Rect shape=new Rect();
   /* private static final ScheduledExecutorService worker =
            Executors.newSingleThreadScheduledExecutor();*/
    public DrawShape(Context context){
        super(context);
        shape= BitmapFactory.decodeResource(getResources(), R.drawable.square);
        x=500;
        y=800;
           }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p=new Paint();

        canvas.drawBitmap(shape,x,y,p);


        if(d==0) {
            if(c>0) {



    if (x+shape.getWidth()<= canvas.getWidth()) {
        x += 10;
    }


            }
            else {


    if (x >= 0) {
        x -= 10;
    }

            }
            canvas.drawBitmap(shape,x,y,p);
           // shape.set(x,y,height,width);
           // canvas.drawRect(shape,p);

        }
        else {
            if(d>0) {



                    if (y+shape.getHeight()<= canvas.getHeight()) {
                        y += 10;
                    }

            }
            else {


                    if (y >= 0) {
                        y -= 10;
                    }


            }
            canvas.drawBitmap(shape,x,y,p);
           // shape.set(x,y,height,width);
           // canvas.drawRect(shape,p);
        }




        invalidate();

    }
    public void allocXY(int a,int b){
        c=a;
        d=b;
    }
}
