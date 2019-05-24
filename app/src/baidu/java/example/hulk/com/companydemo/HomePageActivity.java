package example.hulk.com.companydemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by fuzhi on 2019-05-24
 */
public class HomePageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page_baidu);
        TextView tv = findViewById(R.id.tv_test1);
        tv.setText(BuildConfig.flavor);
    }


}
