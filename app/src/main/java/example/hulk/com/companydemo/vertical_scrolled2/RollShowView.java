package example.hulk.com.companydemo.vertical_scrolled2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import android.widget.TextView;

import example.hulk.com.companydemo.R;

/**
 * @author: hulk
 * Version:  V1.0
 * Date:     2019-08-28
 * Description:
 * Modification History:
 */
public class RollShowView extends RelativeLayout {

    private TextView tv_roll_show1;
    private TextView tv_roll_show2;
    private TextView tv_roll_show3;
    private Context context;

    public RollShowView(Context context) {
        this(context, null);
    }

    public RollShowView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RollShowView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        initView();
        initAnimation();
    }

    private void initView() {
        View view = LayoutInflater.from(context).inflate(R.layout.view_roll_show, this);
        tv_roll_show1 = view.findViewById(R.id.tv_roll_show1);
        tv_roll_show2 = view.findViewById(R.id.tv_roll_show2);
        tv_roll_show3 = view.findViewById(R.id.tv_roll_show3);
    }

    private void initAnimation() {
        // 起始x轴，最终x轴，起始y轴，最终y轴
        TranslateAnimation taShow = new TranslateAnimation(0, 0, 0, 0);
        taShow.setDuration(2000);

        TranslateAnimation taStart = new TranslateAnimation(0, 0, 120, 600);
        taStart.setDuration(3000);

        TranslateAnimation taEnd = new TranslateAnimation(0, 0, 60, 120);
        taEnd.setDuration(3000);
    }
}
