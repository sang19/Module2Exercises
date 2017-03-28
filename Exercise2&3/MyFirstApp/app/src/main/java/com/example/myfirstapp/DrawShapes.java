package com.example.myfirstapp;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RectShape;
import android.view.SurfaceHolder;

/**
 * Created by macuser on 2017-03-12.
 */

public class DrawShapes {


    Canvas canvas;
    Thread thread = null;
    boolean canDraw = false;


    Paint red_paintbrush_fill, blue_paintbrush_fill, green_paintbrush_fill;
    Paint red_paintfrush_stroke, blue_paintbrush_stroke, green_paintbrush_stroke;
    Path square;



    int width = 1000;
    int height = 1000;
    SurfaceHolder surfaceHolder;

    Bitmap queen;
    int queen_x, queen_y;


    int mid_point_x = 500;
    int mid_point_y = 500;

    public DrawShapes(Canvas canvas) {
        this.canvas = canvas;
    }

    public void drawDefault(){
        canvas.drawColor(Color.BLACK);

        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(1);
        paint.setAlpha(255);
        paint.setTextSize(50.0f);
        canvas.drawText("CPEN 391 is the best", 50, 50, paint );
    }

    public void drawCircle() {
        int width = 300;
        int height = 300;

        ShapeDrawable mDrawable;
        mDrawable = new ShapeDrawable(new OvalShape());
        mDrawable.getPaint().setColor(Color.BLACK);
        mDrawable.setBounds(mid_point_x - 150, mid_point_y - 150, (mid_point_x - 150 )+ width, (mid_point_y - 150) + height);
        mDrawable.draw(canvas);
    }

    public void drawTriangle() {

        int width = 400;

        int halfwidth = width/2;

        Paint paint = new Paint();
        paint.setColor(Color.MAGENTA);
        paint.setStrokeWidth(2);

        Path path = new Path();
        path.moveTo(mid_point_x, mid_point_y - halfwidth);
        path.lineTo(mid_point_x - halfwidth, mid_point_y + halfwidth);
        path.lineTo(mid_point_x + halfwidth, mid_point_y + halfwidth);
        path.lineTo(mid_point_x, mid_point_y - halfwidth);
        path.close();

        canvas.drawPath(path, paint);

    }

    public void drawRectangle() {

        int width = 300;
        int height = 200;

        ShapeDrawable mDrawable;
        mDrawable = new ShapeDrawable(new RectShape());
        mDrawable.getPaint().setColor(Color.RED);
        mDrawable.setBounds(mid_point_x - 150, mid_point_y - 100, (mid_point_x - 150) + width, (mid_point_y -100) + height);
        mDrawable.draw(canvas);

    }

    public void drawSquare() {

        int width = 300;
        int height = 300;

        ShapeDrawable mDrawable;
        mDrawable = new ShapeDrawable(new RectShape());
        mDrawable.getPaint().setColor(Color.GREEN);
        mDrawable.setBounds(mid_point_x - 150 , mid_point_y- 150, (mid_point_x - 150) + width, (mid_point_y - 150) + height);
        mDrawable.draw(canvas);
    }

    public void drawPentagon() {

        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(2);

        int numOfPt = 5;

        double section = 2.0*(Math.PI)/numOfPt;

        int radius = 200;

        Path path = new Path();
        path.moveTo((float) (mid_point_x + radius*Math.cos(0)), (float) (mid_point_y + radius*Math.sin(0)));


        for(int i = 1; i < numOfPt; i++) {
            path.lineTo((float) (mid_point_x + radius*Math.cos(section*i)), (float) (mid_point_y + radius*Math.sin(section*i)));
        }

        path.close();
        canvas.drawPath(path, paint);

    }

    public void drawStar() {
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(2);

        int numOfPt = 5;

        double section = 2.0*(Math.PI)/numOfPt;


        int innerRadius = 100;
        int radius = 200;

        Path path = new Path();
        path.moveTo((float) (mid_point_x + radius*Math.cos(0)), (float) (mid_point_y + radius*Math.sin(0)));
        path.lineTo((float) (mid_point_x + innerRadius*Math.cos(0 + section/2.0)), (float) (mid_point_y + innerRadius*Math.sin(0 + section/2.0)));


        for(int i = 1; i < numOfPt; i++) {
            path.lineTo((float) (mid_point_x + radius*Math.cos(section*i)), (float) (mid_point_y + radius*Math.sin(section*i)));
            path.lineTo((float) (mid_point_x + innerRadius*Math.cos(section*i + section/2.0)), (float) (mid_point_y + innerRadius*Math.sin(section*i + section/2.0)));
        }


        path.close();
        canvas.drawPath(path, paint);
    }

    public void drawHexagon() {

        Paint paint = new Paint();
        paint.setColor(Color.MAGENTA);
        paint.setStrokeWidth(2);

        int numOfPt = 6;

        double section = 2.0*(Math.PI)/numOfPt;

        int radius = 200;

        Path path = new Path();
        path.moveTo((float) (mid_point_x + radius*Math.cos(0)), (float) (mid_point_y + radius*Math.sin(0)));

        for(int i = 1; i < numOfPt; i++) {
            path.lineTo((float) (mid_point_x + radius*Math.cos(section*i)), (float) (mid_point_y + radius*Math.sin(section*i)));
        }

        path.close();
        canvas.drawPath(path, paint);


    }

    public void drawOval() {
        int width = 300;
        int height = 400;

        ShapeDrawable mDrawable;
        mDrawable = new ShapeDrawable(new OvalShape());
        mDrawable.getPaint().setColor(Color.CYAN);
        mDrawable.setBounds(mid_point_x - 150, mid_point_y - 200, (mid_point_x - 150) + width, (mid_point_y - 200) + height);
        mDrawable.draw(canvas);
    }

    public void drawOctagon() {

        Paint paint = new Paint();
        paint.setColor(Color.MAGENTA);
        paint.setStrokeWidth(2);

        int numOfPt = 8;

        double section = 2.0*(Math.PI)/numOfPt;

        int radius = 200;

        Path path = new Path();
        path.moveTo((float) (mid_point_x + radius*Math.cos(0)), (float) (mid_point_y + radius*Math.sin(0)));



        for(int i = 1; i < numOfPt; i++) {
            path.lineTo((float) (mid_point_x + radius*Math.cos(section*i)), (float) (mid_point_y + radius*Math.sin(section*i)));
        }

        path.close();
        canvas.drawPath(path, paint);

    }

    public void drawRhombus() {
        int halfWidth = 400 / 2;

        Paint paint = new Paint();
        paint.setColor(Color.YELLOW);
        paint.setStrokeWidth(2);

        Path path = new Path();
        path.moveTo(mid_point_x, mid_point_y + halfWidth); // Top
        path.lineTo(mid_point_x - halfWidth, mid_point_y); // Left
        path.lineTo(mid_point_x, mid_point_y - halfWidth); // Bottom
        path.lineTo(mid_point_x + halfWidth, mid_point_y); // Right
        path.lineTo(mid_point_x, mid_point_y + halfWidth); // Back to Top
        path.close();

        canvas.drawPath(path, paint);
    }








}


