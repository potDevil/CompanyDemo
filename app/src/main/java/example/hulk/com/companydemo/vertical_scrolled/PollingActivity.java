package example.hulk.com.companydemo.vertical_scrolled;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import example.hulk.com.companydemo.R;

/**
 * @author: hulk
 * Version:  V1.0
 * Date:     2019-08-28
 * Description:  向上跑马灯
 * Modification History:
 */
public class PollingActivity extends AppCompatActivity {
    VerticalScrolledListview vertical_scrolled;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_polling);
        vertical_scrolled = findViewById(R.id.vertical_scrolled);
        List<String> list = new ArrayList<>();
        list.add("view初始化优先于此方法");
        list.add("so控件需要手动调动填充");
        list.add("将数据源重新排序");
        list.add("遍历view的所有子控件设值，不用在创建");
        list.add("此处必须这么处理，先remov");
        vertical_scrolled.setData(list);
    }
}
