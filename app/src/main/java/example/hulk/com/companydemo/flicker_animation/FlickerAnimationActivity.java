package example.hulk.com.companydemo.flicker_animation;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import example.hulk.com.companydemo.R;

/**
 * @author: hulk
 * Version:  V1.0
 * Date:     2019-08-08
 * Description: 闪烁动画
 * Modification History:
 */
public class FlickerAnimationActivity extends AppCompatActivity {

    private TextView tv_flicker;
    private int tag = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flicker_animation);
        tv_flicker = findViewById(R.id.tv_flicker);
        tv_flicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tag % 2 == 0) {
                    startRedAnimation(tv_flicker);
                } else {
                    startGreenAnimation(tv_flicker);
                }
                tag++;
            }
        });
    }

    public void startRedAnimation(final View view) {
        ValueAnimator valueAnimator = ValueAnimator.ofObject(new ArgbEvaluator(), 0X88F53E31, 0X00F53E31);
        valueAnimator.setDuration(500);
        valueAnimator.start();
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                view.setBackgroundColor((Integer) animation.getAnimatedValue());
            }
        });
    }

    public void startGreenAnimation(final View view) {
        ValueAnimator valueAnimator = ValueAnimator.ofObject(new ArgbEvaluator(), 0X8825DF82, 0X0025DF82);
        valueAnimator.setDuration(500);
        valueAnimator.start();
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                view.setBackgroundColor((Integer) animation.getAnimatedValue());
            }
        });
    }
}
