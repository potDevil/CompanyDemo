package example.hulk.com.companydemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import example.hulk.com.companydemo.animation.AnimationActivity;
import example.hulk.com.companydemo.flicker_animation.FlickerAnimationActivity;
import example.hulk.com.companydemo.get_apk_info.GetApkInfoActivity;
import example.hulk.com.companydemo.sort_list.SortListActivity;
import example.hulk.com.companydemo.vertical_scrolled.PollingActivity;
import example.hulk.com.companydemo.vertical_scrolled2.PollingActivity2;
import example.hulk.com.companydemo.wechat_address_list.SelectRegionActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.tv_homepage).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, HomePageActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.tv_address_list).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SelectRegionActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.tv_sort_list).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SortListActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.tv_flicker_animation).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, FlickerAnimationActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.tv_get_apk_info).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, GetApkInfoActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.tv_polling).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, PollingActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.tv_polling2).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, PollingActivity2.class);
            startActivity(intent);
        });

        findViewById(R.id.tv_animation).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AnimationActivity.class);
            startActivity(intent);
        });
    }
}
