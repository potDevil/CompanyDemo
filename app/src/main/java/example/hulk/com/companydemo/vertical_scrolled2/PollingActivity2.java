package example.hulk.com.companydemo.vertical_scrolled2;

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
public class PollingActivity2 extends AppCompatActivity {
    RollTextView roll_text_view;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_polling2);
        roll_text_view = findViewById(R.id.roll_text_view);
        List<String> list = new ArrayList<>();
        list.add("悯农");
        list.add("锄禾日当午");
        list.add("汗滴禾下土");
        list.add("谁知盘中餐");
        list.add("粒粒皆辛苦");
        roll_text_view.setData(list);
        roll_text_view.start();
    }
}
