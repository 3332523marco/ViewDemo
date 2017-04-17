package shengyuan.viewdemo.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

import shengyuan.viewdemo.ui.TouchActivity;

/**
 * Created by Marco on 17/4/12.
 */
public class CustomViewGroup extends RelativeLayout  implements GestureDetector.OnGestureListener {

    private GestureDetector detector;

    public CustomViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        detector = new GestureDetector(context,this);
    }

    public CustomViewGroup(Context context) {
        super(context);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i(TouchActivity.TAG, "CustomViewGroup.onTouchEvent:" + event.toString());
        detector.onTouchEvent(event);
        return true;
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

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        float minMove = 120;         //最小滑动距离
        float minVelocity = 0;      //最小滑动速度
        float beginX = e1.getX();
        float endX = e2.getX();
        float beginY = e1.getY();
        float endY = e2.getY();

        if(beginX-endX>minMove&&Math.abs(velocityX)>minVelocity){   //左滑
            Log.i(TouchActivity.TAG, "onFling 左滑");
        }else if(endX-beginX>minMove&&Math.abs(velocityX)>minVelocity){   //右滑
            Log.i(TouchActivity.TAG, "onFling 右滑");
        }else if(beginY-endY>minMove&&Math.abs(velocityY)>minVelocity){   //上滑
            Log.i(TouchActivity.TAG, "onFling 上滑");
        }else if(endY-beginY>minMove&&Math.abs(velocityY)>minVelocity){   //下滑
            Log.i(TouchActivity.TAG, "onFling 下滑");
        }
        return false;
    }
}