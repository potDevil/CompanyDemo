package example.hulk.com.companydemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import example.hulk.com.companydemo.flicker_animation.FlickerAnimationActivity;
import example.hulk.com.companydemo.sort_list.SortListActivity;
import example.hulk.com.companydemo.wechat_address_list.SelectRegionActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.tv_homepage).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HomePageActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.tv_address_list).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SelectRegionActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.tv_sort_list).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SortListActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.tv_flicker_animation).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FlickerAnimationActivity.class);
                startActivity(intent);
            }
        });
    }
}
