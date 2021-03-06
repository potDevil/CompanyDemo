package example.hulk.com.companydemo.vertical_scrolled;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import example.hulk.com.companydemo.R;

/**
 * @author: hulk
 * Version:  V1.0
 * Date:     2019-08-28
 * Description:
 * Modification History:
 */
public class VerticalScrolledListview extends LinearLayout {
    private Context mContext;
    private List<String> data = new ArrayList<String>();
    private OnItemClickListener itemClickListener;

    public VerticalScrolledListview(Context context) {
        super(context);
        init(context);
    }

    public VerticalScrolledListview(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        mContext = context;
        this.setOrientation(VERTICAL);
    }

    /**
     * 更新文字需要在UI线程
     */
    Handler mHandler = new Handler();
    Runnable mUpdateResults = new Runnable() {
        public void run() {
            traversalView(VerticalScrolledListview.this);
        }
    };

    private void initTextView() {
        if (data != null && data.size() != 0) {
            for (int i = 0; i < data.size(); i++) {
                View view = View.inflate(mContext, R.layout.layout_poll_item, null);
                TextView textView = view.findViewById(R.id.tv1);
//                TextView textView = new TextView(mContext);
                textView.setText(data.get(i));
//                textView.setGravity(Gravity.CENTER);
//                textView.setTextColor(Color.BLACK);
                this.addView(view);
                view.setClickable(true);
                final int index = i;
                view.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        itemClickListener.onItemClick(index);
                    }
                });
            }
            //初始化控件结束调用计时器
            startTimer();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    /**
     * @param data view初始化优先于此方法
     *             so控件需要手动调动填充
     */
    public void setData(List<String> data) {
        this.data = data;
        initTextView();
    }

    public void startTimer() {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                //将数据源重新排序
                mHandler.post(mUpdateResults);
            }
        };
        timer.schedule(task, 2000, 2000);

    }

    /**
     * 遍历view的所有子控件设值，不用在创建
     *
     * @param viewGroup
     */
    public void traversalView(final ViewGroup viewGroup) {
        if (viewGroup.getChildCount() != 0) {
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                if (i == 0) {
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            /**
                             * 此处必须这么处理，先removeview子view，解除与父类关系，再添加进去
                             * 否则会报错java.lang.IllegalStateException
                             */
                            View newView = viewGroup.getChildAt(0);
                            viewGroup.removeView(viewGroup.getChildAt(0));
                            viewGroup.addView(newView);
                        }
                    });

                }
            }
        }
    }

    /**
     * 设置点击事件监听
     *
     * @param itemClickListener
     */
    public void setOnItemClickListener(VerticalScrolledListview.OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    /**
     * 轮播文本点击监听器
     */
    public interface OnItemClickListener {
        /**
         * @param position 当前点击ID
         */
        void onItemClick(int position);
    }
}
