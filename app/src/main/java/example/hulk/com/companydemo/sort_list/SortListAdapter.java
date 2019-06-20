package example.hulk.com.companydemo.sort_list;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import example.hulk.com.companydemo.R;
import example.hulk.com.companydemo.wechat_address_list.RegionAdapter;
import example.hulk.com.companydemo.wechat_address_list.model.RegionBean;

/**
 * Created by fuzhi on 2019-06-19
 */
public class SortListAdapter extends RecyclerView.Adapter<SortListAdapter.ViewHolder> {

    List<RegionBean> mData = new ArrayList<>();

    public void setRegionData(List<RegionBean> mData) {
        synchronized (RegionAdapter.class) {
            this.mData.clear();
            this.mData.addAll(mData);
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_region_data, parent, false);
        SortListAdapter.ViewHolder holder = new SortListAdapter.ViewHolder(inflate);
        holder.tvPinyin = (TextView) inflate.findViewById(R.id.tv_pinyin);
        holder.tvName = (TextView) inflate.findViewById(R.id.tv_name);
        holder.tvNum = (TextView) inflate.findViewById(R.id.tv_num);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.tvName.setText(mData.get(i).name);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class ViewHolder extends  RecyclerView.ViewHolder {
        TextView tvPinyin;
        TextView tvName;
        TextView tvNum;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
