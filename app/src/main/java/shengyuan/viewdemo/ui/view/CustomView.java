package shengyuan.viewdemo.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import shengyuan.viewdemo.ui.TouchActivity;

/**
 * Created by Marco on 17/4/12.
 */
public class CustomView extends View {

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomView(Context context) {
        super(context);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i(TouchActivity.TAG, "customView.onTouchEvent:" + event.toString());

        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.i(TouchActivity.TAG, "customView.dispatchTouchEvent:"+event.toString());

        return super.dispatchTouchEvent(event);
    }
}
