package com.app.touchpull;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;

import com.app.touchpull.widget.TouchPullView;

public class MainActivity extends AppCompatActivity {

    private static final float TOUCH_MOVE_MAX_Y = 600;
    private float mTouchMoveStartY = 0;
    private TouchPullView touchPullView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TouchPullView pullView = findViewById(R.id.touchpull);

        findViewById(R.id.root).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // 得到意图
                int action = event.getActionMasked();
                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        mTouchMoveStartY = event.getY();
                        return true;
                    case MotionEvent.ACTION_MOVE:
                        float y = event.getY();
                        if (y >= mTouchMoveStartY) {
                            float moveSize = y - mTouchMoveStartY;
                            float progress = moveSize >= TOUCH_MOVE_MAX_Y ? 1 : moveSize / TOUCH_MOVE_MAX_Y;
                            touchPullView.setProgress(progress);
                        }
                        return true;
                    default:
                        break;
                }
                return false;
            }
        });
    }
}