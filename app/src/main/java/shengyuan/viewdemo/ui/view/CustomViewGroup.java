package shengyuan.viewdemo.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

import shengyuan.viewdemo.ui.TouchActivity;

/**
 * Created by Marco on 17/4/12.
 */
public class CustomViewGroup extends RelativeLayout {

    public CustomViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomViewGroup(Context context) {
        super(context);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i(TouchActivity.TAG, "CustomViewGroup.onTouchEvent:" + event.toString());
        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.i(TouchActivity.TAG, "CustomViewGroup.dispatchTouchEvent:" + ev.toString());
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.i(TouchActivity.TAG, "CustomViewGroup.onInterceptTouchEvent:" + ev.toString());
        return super.onInterceptTouchEvent(ev);
    }
}