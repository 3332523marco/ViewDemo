package shengyuan.viewdemo.ui;

import android.content.Intent;
import android.view.View;

import butterknife.OnClick;
import shengyuan.viewdemo.R;
import shengyuan.viewdemo.ui.base.BaseActivity;


public class MainActivity extends BaseActivity {


    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViewsAndEvents() {

    }

    @OnClick({R.id.listbtn, R.id.viewbtn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.listbtn:
                startActivity(new Intent(mContext, AppBarActivity.class));
                break;
            case R.id.viewbtn:
                startActivity(new Intent(mContext, TouchActivity.class));
                break;
        }
    }
}
