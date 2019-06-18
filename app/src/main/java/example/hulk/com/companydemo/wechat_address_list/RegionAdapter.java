package example.hulk.com.companydemo.wechat_address_list;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import example.hulk.com.companydemo.R;
import example.hulk.com.companydemo.wechat_address_list.model.RegionBean;

/**
 * Created by wang on 2019/1/28.
 */

public class RegionAdapter extends RecyclerView.Adapter<RegionAdapter.ViewHolder> {

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_region_data, parent, false);
         ViewHolder holder = new ViewHolder(inflate);
         holder.tvPinyin = (TextView) inflate.findViewById(R.id.tv_pinyin);
         holder.tvName = (TextView) inflate.findViewById(R.id.tv_name);
         holder.tvNum = (TextView) inflate.findViewById(R.id.tv_num);
        return holder;
     }
    List<RegionBean> mData = new ArrayList<>();
     public void setRegionData(List<RegionBean> mData){
        synchronized (RegionAdapter.class){
            this.mData.clear();
            this.mData.addAll(mData);
        }
        notifyDataSetChanged();
     }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String pinyin = mData.get(position).pinyin;
        holder.tvPinyin.setText(pinyin);
        if (position !=0) {
            String lastPinyin = mData.get(position - 1).pinyin;
            if(lastPinyin.equals(pinyin)){
                holder.tvPinyin.setVisibility(View.GONE);
            }else {
                holder.tvPinyin.setVisibility(View.VISIBLE);
            }
        }else {
            holder.tvPinyin.setVisibility(View.VISIBLE);
        }
        holder.tvName.setText(mData.get(position).name);
        holder.tvNum.setText(mData.get(position).num);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(View itemView) {
            super(itemView);
        }
        TextView tvPinyin;
        TextView tvName;
        TextView tvNum;
    }
}
