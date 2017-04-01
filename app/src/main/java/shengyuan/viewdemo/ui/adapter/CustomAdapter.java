package shengyuan.viewdemo.ui.adapter;

/**
 * Created by marco on 16/9/22.
 */

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

import shengyuan.viewdemo.R;

/**
 *
 */
public class CustomAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int ONCLICK_TAG = R.id.action0;

    private onAdapterCallBack mCallBack;
    private List<T> mList;
    public CustomAdapter(List<T> list){
        this.mList = list;
    }

    public void setAdapterListener(onAdapterCallBack callBack){
        mCallBack = callBack;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return mCallBack.onCreateViewHolder(parent,viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder,int position) {
        mCallBack.onBindViewHolder(viewHolder,position);
    }

    @Override
    public int getItemCount() {
        int size = mList == null?0:mList.size();
        return size;
    }

    public interface onAdapterCallBack{
        void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position);
        RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType);
    }


}
