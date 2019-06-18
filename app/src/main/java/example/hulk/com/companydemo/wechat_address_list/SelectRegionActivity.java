package example.hulk.com.companydemo.wechat_address_list;

import android.content.Context;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import example.hulk.com.companydemo.R;
import example.hulk.com.companydemo.wechat_address_list.model.RegionBean;
import example.hulk.com.companydemo.wechat_address_list.util.CharacterParserUtil;
import example.hulk.com.companydemo.wechat_address_list.view.LetterView;

/**
 * Created by wang on 2019/1/28.
 */

public class SelectRegionActivity extends AppCompatActivity implements TextWatcher {

    private final int ownerNum = 1;
    private int managerNum = 0;

    private List<RegionBean> mDataList;
    private String[] b = {"#", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K",
            "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X",
            "Y", "Z", "$"};
    private RecyclerView mRecyclerList;
    private TextView tvLocationOverlay;
    private EditText mEdSearch;
    private RegionAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_selectregion);
        initView();
    }

    private void initView() {
        initRegionData();
        initOverlay();
        mEdSearch = (EditText) findViewById(R.id.et_search_input);
        // TODO 为了调试先GONE
        mEdSearch.setVisibility(View.GONE);
        mEdSearch.addTextChangedListener(this);
        LetterView lvLetter = (LetterView) findViewById(R.id.lv_letter);
        lvLetter.setB(b);
        mRecyclerList = (RecyclerView) findViewById(R.id.recycler);
        mRecyclerList.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RegionAdapter();
        adapter.setRegionData(mDataList);
        mRecyclerList.setAdapter(adapter);
        lvLetter.setOnTouchingLetterChangedListener(new LetterListViewListener());
    }

    /**
     * 初始化地区数据，获取地区的名称 号码以及拼音，排序
     **/
    private void initRegionData() {
        List<String> mRegionDataList = Arrays.asList(getResources().getStringArray(R.array.country_code_list_ch));
        mDataList = new ArrayList<>();
        for (String mData : mRegionDataList) {
            String s = mData.replaceAll("\\s*", "");
            String[] split = s.split("\\*");
            RegionBean bean = new RegionBean();
            bean.name = split[0];
            bean.num = split[1];
            bean.pinyin = CharacterParserUtil.getInstance().getSelling(bean.name).substring(0, 1).toUpperCase();
            mDataList.add(bean);
            Collections.sort(mDataList, comparator);

        }
    }

    /**
     * 初始化屏幕中间选中的文字
     * 默认隐藏，滑动右侧文字时显示
     **/
    private void initOverlay() {
        LayoutInflater inflater = LayoutInflater.from(this);
        tvLocationOverlay = (TextView) inflater.inflate(R.layout.city_overlay, null);
        tvLocationOverlay.setVisibility(View.INVISIBLE);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_APPLICATION,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                PixelFormat.TRANSLUCENT);
        WindowManager windowManager = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        windowManager.addView(tvLocationOverlay, lp);
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

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    /**
     * 输入框监听，输入文字或者拼音时候搜索集合里面的指定数据
     **/
    List<RegionBean> mSearchList = new ArrayList<>();

    @Override
    public void afterTextChanged(Editable s) {
        String search = mEdSearch.getText().toString();
        if (search.equals("")) {
            adapter.setRegionData(mDataList);
        } else {
            mSearchList.clear();
            for (RegionBean bean : mDataList) {
                if (bean.name.contains(search) || bean.pinyin.contains(search)) {
                    mSearchList.add(bean);
                }
            }
            adapter.setRegionData(mSearchList);
        }
    }

    /**
     * 右侧滑动监听
     **/
    private class LetterListViewListener implements LetterView.OnTouchLetterChangedListener {

        @Override
        public void touchLetterChanged(final String s) {
            for (int i = 0; i < mDataList.size(); i++) {
                if (mDataList.get(i).pinyin.equals(s)) {
                    ((LinearLayoutManager) mRecyclerList.getLayoutManager()).scrollToPositionWithOffset(i, 0);
                    tvLocationOverlay.setText(s);
                    tvLocationOverlay.setVisibility(View.VISIBLE);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            tvLocationOverlay.setVisibility(View.GONE);
                        }
                    }, 1000);
                    return;
                }
            }

        }
    }
}
