package com.example.pinbasket;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.os.Handler;
import android.support.v7.widget.AppCompatImageView;
import android.hardware.SensorEventListener;
import android.util.AttributeSet;
import android.view.Display;
import android.view.Gravity;
import android.view.View;

import java.security.KeyStore;

public class levelOne extends AppCompatImageView implements SensorEventListener {

    Context context;
    private android.os.Handler h;
    int x=400,y=50;
    SensorManager sm;
    Sensor gravity;
    private int velocityX,velocityY;
    public  static int score=0;
    public String sc="";
    private boolean status=false;



    public levelOne(Context context, AttributeSet attributeSet)
    {
        super(context,attributeSet);
        this.context=context;
        h=new Handler();
        sm=(SensorManager)context.getSystemService(context.SENSOR_SERVICE);
        gravity=sm.getDefaultSensor(Sensor.TYPE_GRAVITY);
        sm.registerListener(this, gravity, gravity.getMinDelay());
    }

    private Runnable r=new Runnable() {
        @Override
        public void run() {
            invalidate();
        }
    };

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint=new Paint();
        paint.setColor(Color.rgb(255, 0, 0));
        Paint paint2=new Paint();
        paint2.setColor(Color.rgb(0, 0, 0));

        Paint paintSuccess=new Paint();
        paintSuccess.setColor(Color.rgb(0, 250, 0));

        int max=950,min=20;


        canvas.drawLine(20, 20, 950, 20,paint2);
        canvas.drawLine(950, 20, 950, 950,paint2);
        canvas.drawLine(20, 950, 950, 950,paint2);
        canvas.drawLine(20, 20, 20, 950,paint2);

        canvas.drawCircle(300, 300, 20, paint2);
        canvas.drawCircle(500, 500, 20, paint2);



        Paint paintShado=new Paint();
        if (x<255 && x>0)
            paintShado.setColor(Color.rgb(0, x, 0));
        else
            paintShado.setColor(Color.rgb(0, 22, 0));
        canvas.drawCircle(800, 800, 60, paintShado);

        canvas.drawCircle(800, 800, 50, paintSuccess);


//        canvas.drawCircle(x, y, 20, paint);
//        canvas.drawCircle(x, y, 20, paint);

        canvas.drawCircle(x, y, 20, paint);



        if ((x<950 && y<950) && (x>20 && y>20)) {
            x++;
            y++;

            x+=velocityX;
            y+=velocityY;


            if (((x < 320 && x > 280) && (y < 320 && y > 280) || (x < 520 && x > 480) && (y < 520 && y > 480))
            ) {
                x = 400;
                y = 50;
//                score = 0;
            } else {
                if ((x < 850 && x > 750) && (y < 850 && y > 750)) {
//                    score = 100;
                    status=true;
                }
            }
//            sc = "Score : " + score;

        }
        else
        {
            x=400;y=50;
        }

        if (status==true)
        {
            MainActivity mainActivity=new MainActivity();
            mainActivity.playLevel2();
        }
        else {
            h.postDelayed(r, 30);
        }


    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        if (event.sensor.getType()==Sensor.TYPE_GRAVITY)
        {
            velocityX=(int)event.values[0];
            velocityY=(int)event.values[1];

        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
