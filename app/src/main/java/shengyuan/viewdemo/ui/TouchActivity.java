package shengyuan.viewdemo.ui;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import butterknife.Bind;
import shengyuan.viewdemo.R;
import shengyuan.viewdemo.ui.base.BaseActivity;
import shengyuan.viewdemo.ui.view.CustomView;
import shengyuan.viewdemo.ui.view.CustomViewGroup;

/**
 * Created by Marco on 17/4/12.
 */
public class TouchActivity extends BaseActivity {
   
    public final static String TAG = TouchActivity.class.getSimpleName();

    @Bind(R.id.custom_btn)
    CustomView mCustomBtn;
    @Bind(R.id.custom_group)
    CustomViewGroup mCustomGroup;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_touch;
    }

    /**
     * view触控传递 activity.dispatchTouchEvent:MotionEvent -->  CustomViewGroup.dispatchTouchEvent
     * --> CustomViewGroup.onInterceptTouchEvent --> CustomView.dispatchTouchEvent --> mCustomBtn.View.OnTouchListener.onTouch
     * --> CustomView.onTouchEvent --> mCustomGroup.ViewGroup.OnTouchListener.onTouch --> CustomViewGroup.onTouchEvent
     * --> activity.onTouchEvent --> activity.dispatchTouchEvent --> activity.onTouchEvent
     *
     * 1.实际开发中我们可能经常会操作setOnTouchListener，这个会在onTouchEvent之前调用。这个给开发者提供了一个接口来捕获View的事件，如果这个 return false，那么事件还会传到OnTouchEvent。如果不想传到 OnTouchEvent，就return true，相当于拦截了事件。后面的案例中类似，不在做分析。
     * 2.dispatchTouchEvent一般只负责事件的分发，不建议把逻辑放在这里，也就是这里的返回值一半都是 return super.dispatchTouchEvent
     *
     */

    @Override
    protected void initViewsAndEvents() {
        mCustomBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.i(TAG, "View.OnTouchListener.onTouch:" + event.toString());
                return false;
            }
        });

        mCustomGroup.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.i(TAG,"ViewGroup.OnTouchListener.onTouch:"+event.toString());
                return false;
            }
        });
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.i(TAG,"activity.dispatchTouchEvent:"+ev.toString());
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i(TAG, "activity.onTouchEvent:" + event.toString());
        return super.onTouchEvent(event);
    }
}
