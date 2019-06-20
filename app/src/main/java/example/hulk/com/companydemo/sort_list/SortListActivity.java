package example.hulk.com.companydemo.sort_list;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import example.hulk.com.companydemo.R;
import example.hulk.com.companydemo.wechat_address_list.model.RegionBean;
import example.hulk.com.companydemo.wechat_address_list.util.CharacterParserUtil;

/**
 * Created by fuzhi on 2019-06-19
 */
public class SortListActivity extends AppCompatActivity {

    List<RegionBean> letterSortList = new ArrayList<>();

    private RecyclerView rv;
    private SortListAdapter sortListAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sort_list);
        rv = findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        sortListAdapter = new SortListAdapter();
        rv.setAdapter(sortListAdapter);
        initData();
    }

    private void initData () {
        List<RegionBean> mData = new ArrayList<>();
        RegionBean bean1 = new RegionBean();
        bean1.setName("吧b11");
        mData.add(bean1);
        RegionBean bean2 = new RegionBean();
        bean2.setName("的d11");
        mData.add(bean2);
        RegionBean bean3 = new RegionBean();
        bean3.setName("想x11");
        mData.add(bean3);
        RegionBean bean4 = new RegionBean();
        bean4.setName("啊a11");
        mData.add(bean4);
        RegionBean bean5 = new RegionBean();
        bean5.setName("拥有者");
        mData.add(bean5);
        RegionBean bean6 = new RegionBean();
        bean6.setName("啊管理者a");
        mData.add(bean6);
        RegionBean bean7 = new RegionBean();
        bean7.setName("吧管理者b");
        mData.add(bean7);

        letterSortList.addAll(mData);
        for (RegionBean bean: letterSortList) {
            bean.setPinyin(CharacterParserUtil
                    .getInstance()
                    .getSelling(bean.name).substring(0, 1).toUpperCase());
        }
        Collections.sort(letterSortList, comparator);

        List<RegionBean> ownerSortList = new ArrayList<>();
        List<RegionBean> managerSortList = new ArrayList<>();

        // 方法1
//        for (RegionBean bean: letterSortList) {
//            if(bean.getName().contains("管理者")) {
//                managerSortList.add(0, bean);
//            } else {
//                managerSortList.add(bean);
//            }
//        }
//
//        for (RegionBean bean: managerSortList) {
//            if(bean.getName().contains("拥有者")) {
//                ownerSortList.add(0, bean);
//            } else {
//                ownerSortList.add(bean);
//            }
//        }
//
//        sortListAdapter.setRegionData(ownerSortList);


//        // 方法2
        for (RegionBean bean : letterSortList) {
            if (bean.getName().contains("拥有者")) {
                ownerSortList.add(bean);
            }
        }

        for (RegionBean bean : letterSortList) {
            if (bean.getName().contains("管理者")) {
                managerSortList.add(bean);
            }
        }

        Collections.sort(managerSortList, comparator);

        Iterator<RegionBean> it = letterSortList.iterator();
        while(it.hasNext()){
            String name = it.next().getName();
            if(name.contains("拥有者") || name.contains("管理者")){
                it.remove();
            }
        }

        letterSortList.addAll(0, managerSortList);

        letterSortList.addAll(0, ownerSortList);

        sortListAdapter.setRegionData(letterSortList);
    }

    /**
     * 根据拼音顺序排序
     **/
    Comparator comparator = new Comparator<RegionBean>() {
        @Override
        public int compare(RegionBean lhs, RegionBean rhs) {
            return lhs.pinyin.compareTo(rhs.pinyin);
        }
    };
}
