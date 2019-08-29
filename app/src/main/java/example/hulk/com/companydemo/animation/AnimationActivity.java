package example.hulk.com.companydemo.animation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import example.hulk.com.companydemo.R;

/**
 * @author: hulk
 * Version:  V1.0
 * Date:     2019-08-29
 * Description:
 * Modification History:
 */
public class AnimationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        TextView tv_polling = findViewById(R.id.tv_polling);
        ObjectAnimator translationX = new ObjectAnimator().ofFloat(tv_polling, "translationX", 0, 600f);
        ObjectAnimator translationY = new ObjectAnimator().ofFloat(tv_polling, "translationY", 0, 0);

        AnimatorSet animatorSet = new AnimatorSet();  //组合动画
        animatorSet.playTogether(translationX, translationY); //设置动画
        animatorSet.setDuration(3000);  //设置动画时间
        animatorSet.start(); //启动

        tv_polling.setOnClickListener(v -> Toast.makeText(AnimationActivity.this, "111", Toast.LENGTH_SHORT).show());
    }
}
