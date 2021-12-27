package com.example.pingponglite;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.*;
import android.media.MediaPlayer;
import android.view.Display;
import android.view.View;

import java.util.Random;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class GameView extends View {
    Context context;
    float ballX,ballY;
    Velocity velocity = new Velocity(25,32);
    Handler handler;
    final long UPDATE_MILLIS = 30;
    Runnable runnable;
    Paint textPaint = new Paint();
    Paint healthPaint = new Paint();
    float TEXT_SIZE = 120;
    float paddleX, paddleY;
    float oldX, oldY;
    int points = 0;
    int life = 3;
    Bitmap ball, paddle;
    int dWidth, dHeight;
    MediaPlayer mpHit, mpMiss;
    Random random;
    SharedPreferences sharedPreferences;
    Boolean audioState;



    public GameView(Context context) {
        super(context);
        this.context =context;
        ball = BitmapFactory.decodeResource(getResources(),R.drawable.ball);
        paddle = BitmapFactory.decodeResource(getResources(),R.drawable.paddle);
        handler = new Handler() {
            @Override
            public void publish(LogRecord logRecord) {

            }

            @Override
            public void flush() {

            }

            @Override
            public void close() throws SecurityException {

            }
        };
        runnable = new Runnable() {
            @Override
            public void run() {
                invalidate();

            }
        };
        mpHit = MediaPlayer.create(context, R.raw.hit);
        mpMiss = MediaPlayer.create(context,R.raw.miss);
        textPaint.setColor(Color.RED);
        textPaint.setTextSize(TEXT_SIZE);
        textPaint.setTextAlign(Paint.Align.LEFT);
        healthPaint.setColor(Color.GREEN);
        Display display = ((Activity)getContext()).getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        dWidth  = size.x;
        dHeight = size.y;
        random = new Random();
        ballX = random.nextInt(dWidth);
        paddleY = (dHeight*4)/5;
        paddleX = dWidth/2 - paddle.getWidth()/2;
        sharedPreferences = context.getSharedPreferences("mu_pref",0);
        audioState = sharedPreferences.getBoolean("audioState",true);



    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
