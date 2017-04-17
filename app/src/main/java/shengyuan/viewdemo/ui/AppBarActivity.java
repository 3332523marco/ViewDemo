package shengyuan.viewdemo.ui;

import android.support.design.widget.AppBarLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import shengyuan.viewdemo.R;
import shengyuan.viewdemo.ui.adapter.CustomAdapter;
import shengyuan.viewdemo.ui.base.BaseActivity;

/**
 * Created by Marco on 17/4/1.
 */
public class AppBarActivity extends BaseActivity implements CustomAdapter.onAdapterCallBack,AppBarLayout.OnOffsetChangedListener,SwipeRefreshLayout.OnRefreshListener {

    @Bind(R.id.feed_list2)
    RecyclerView mHorizonRecyclerView;
    @Bind(R.id.applayout)
    AppBarLayout mApplayout;
    @Bind(R.id.feed_list)
    RecyclerView mVerticalRecyclerView;
    @Bind(R.id.swipe)
    SwipeRefreshLayout mSwipe;

    private List<String> mList;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_appbar;
    }

    @Override
    protected void initViewsAndEvents() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        CustomAdapter mAdapter = new CustomAdapter(getData());
        mVerticalRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mAdapter.setAdapterListener(this);
        mHorizonRecyclerView.setLayoutManager(linearLayoutManager);
        mHorizonRecyclerView.setAdapter(mAdapter);
        mVerticalRecyclerView.setAdapter(mAdapter);
        mApplayout.addOnOffsetChangedListener(this);
        mSwipe.setOnRefreshListener(this);
        mSwipe.setColorSchemeResources(android.R.color.holo_blue_light);
    }

    protected List<String> getData() {
        mList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            mList.add("test " + i);
        }
        return mList;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        ItemViewHolder holder = ((ItemViewHolder) viewHolder);
        holder.titleTxt.setText(mList.get(position));
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(mContext).inflate(R.layout.activity_appbar_list_item, parent, false));
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
        /**
         * 解决swipe和appBarLayout滑动冲突
         */
        mSwipe.setEnabled(false);
    }

    @Override
    public void onRefresh() {
        mSwipe.setRefreshing(false);
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.title)
        TextView titleTxt;

        public ItemViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
