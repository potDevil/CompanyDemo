package example.hulk.com.companydemo.vertical_scrolled2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import example.hulk.com.companydemo.R;

/**
 * 文字上线轮播组件
 * author：bigbear
 * <p>
 * 实现思路：
 * 1、单个动画顺序：显示动画-> 开始动画-> 结束动画 循环
 * 2、前一个组件执行完显示动画后；在开始动画监听中，开始时调用下一个组件的显示动画，开始动画执行完完调用自身结束动画，并调用下一个组件的开始动画
 * 一次成为一个闭环循环。
 */
public class RollTextView extends RelativeLayout implements View.OnClickListener {

    private Context mContext;
    private AnimationSet showAnim, startAnimOne, startAnimTwo, startAnimThree, startAnimFour, startAnimFive, endAnim;
    private RelativeLayout view_roll_rl1, view_roll_rl2, view_roll_rl3, view_roll_rl4, view_roll_rl5;
    private TextView view_roll_content_tv1, view_roll_content_tv2, view_roll_content_tv3;
    private List<String> mData = null;
    private int index = 0;

    public RollTextView(Context context) {
        super(context);
        this.mContext = context;
        initView();
        initData();
    }

    public RollTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        initView();
        initData();
    }

    public RollTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        initView();
        initData();
    }

    /**
     * 初始化视图
     */
    private void initView() {
        View view = LayoutInflater.from(mContext).inflate(R.layout.widget_roll_text_view, this);
        view_roll_rl1 = view.findViewById(R.id.view_roll_rl1);
        view_roll_rl2 = view.findViewById(R.id.view_roll_rl2);
        view_roll_rl3 = view.findViewById(R.id.view_roll_rl3);
        view_roll_content_tv1 = view.findViewById(R.id.view_roll_content_tv1);
        view_roll_content_tv2 = view.findViewById(R.id.view_roll_content_tv2);
        view_roll_content_tv3 = view.findViewById(R.id.view_roll_content_tv3);
        view_roll_rl1.setOnClickListener(this);
        view_roll_rl1.setOnClickListener(this);
        view_roll_rl1.setOnClickListener(this);
//        view_roll_rl4 = view.findViewById(R.id.view_roll_rl4);
//        view_roll_rl5 = view.findViewById(R.id.view_roll_rl5);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.view_roll_rl1:
                Toast.makeText(mContext, mData.get(index), Toast.LENGTH_SHORT).show();
                break;
            case R.id.view_roll_rl2:
                Toast.makeText(mContext, mData.get(index), Toast.LENGTH_SHORT).show();
                break;
            case R.id.view_roll_rl3:
                Toast.makeText(mContext, mData.get(index), Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void setData(List<String> data) {
        this.mData = data;
    }

//    private void setShowAnim(int view) {
//        ObjectAnimator translationX1 = new ObjectAnimator().ofFloat(view, "translationX", 15, 15);
//        ObjectAnimator translationY1 = new ObjectAnimator().ofFloat(view, "translationY", 120, 120);
//        ObjectAnimator alpha = ObjectAnimator.ofFloat(view, "alpha", 0, 0.4f);
//        ObjectAnimator scaleX = ObjectAnimator.ofFloat(view, "scaleX", 0.9f, 0.9f);
//        ObjectAnimator scaleY = ObjectAnimator.ofFloat(view, "scaleY", 0.9f, 0.9f);
//        AnimatorSet animatorSet = new AnimatorSet();  //组合动画
//        animatorSet.playTogether(translationX1, translationY1, alpha, scaleX, scaleY); //设置动画
//        animatorSet.setDuration(3000);  //设置动画时间
//        animatorSet.start();
//    }
//
//    private void setEndAnim(int view) {
//        ObjectAnimator translationX1 = new ObjectAnimator().ofFloat(view, "translationX", 0, 15);
//        ObjectAnimator translationY1 = new ObjectAnimator().ofFloat(view, "translationY", 60, 0);
//        ObjectAnimator alpha = ObjectAnimator.ofFloat(view, "alpha", 1, 0.4f);
//        ObjectAnimator scaleX = ObjectAnimator.ofFloat(view, "scaleX", 1, 0.9f);
//        ObjectAnimator scaleY = ObjectAnimator.ofFloat(view, "scaleY", 1, 0.9f);
//        AnimatorSet animatorSet = new AnimatorSet();  //组合动画
//        animatorSet.playTogether(translationX1, translationY1, alpha, scaleX, scaleY); //设置动画
//        animatorSet.setDuration(3000);  //设置动画时间
//        animatorSet.start();
//        animatorSet.addListener(new Animator.AnimatorListener() {
//            @Override
//            public void onAnimationStart(Animator animator) {
//            }
//
//            @Override
//            public void onAnimationEnd(Animator animator) {
//                findViewById(view).setVisibility(View.VISIBLE);
//            }
//
//            @Override
//            public void onAnimationCancel(Animator animator) {
//            }
//
//            @Override
//            public void onAnimationRepeat(Animator animator) {
//            }
//        });
//    }
//
//    public void startAnim1() {
//        ObjectAnimator translationX = new ObjectAnimator().ofFloat(view_roll_rl1, "translationX", 15, 0, 0, 15);
//        ObjectAnimator translationY = new ObjectAnimator().ofFloat(view_roll_rl1, "translationY", 120, 60, 60, 0);
//        ObjectAnimator alpha = ObjectAnimator.ofFloat(view_roll_rl1, "alpha", 0.4f, 1);
//        ObjectAnimator scaleX = ObjectAnimator.ofFloat(view_roll_rl1, "scaleX", 0.9f, 1);
//        ObjectAnimator scaleY = ObjectAnimator.ofFloat(view_roll_rl1, "scaleY", 0.9f, 1);
//        AnimatorSet animatorSet = new AnimatorSet();  //组合动画
//        animatorSet.playTogether(translationX, translationY, alpha, scaleX, scaleY); //设置动画
//        animatorSet.setDuration(3000);  //设置动画时间
//        animatorSet.start();
//        view_roll_rl1.setVisibility(View.VISIBLE);
//        //动画的监听
//        animatorSet.addListener(new Animator.AnimatorListener() {
//            @Override
//            public void onAnimationStart(Animator animator) {
//                view_roll_content_tv2.setText(mData.get(index));
//                setIndex();
//                setShowAnim(R.id.view_roll_rl2);
//            }
//
//            @Override
//            public void onAnimationEnd(Animator animator) {
//                setEndAnim(R.id.view_roll_rl1);
//                startAnim2();
//            }
//
//            @Override
//            public void onAnimationCancel(Animator animator) {
//            }
//
//            @Override
//            public void onAnimationRepeat(Animator animator) {
//            }
//        });
//    }
//
//    private void startAnim2() {
//        ObjectAnimator translationX = new ObjectAnimator().ofFloat(view_roll_rl2, "translationX", 15, 0);
//        ObjectAnimator translationY = new ObjectAnimator().ofFloat(view_roll_rl2, "translationY", 120, 60);
//        ObjectAnimator alpha = ObjectAnimator.ofFloat(view_roll_rl2, "alpha", 0.4f, 1);
//        ObjectAnimator scaleX = ObjectAnimator.ofFloat(view_roll_rl2, "scaleX", 0.9f, 1);
//        ObjectAnimator scaleY = ObjectAnimator.ofFloat(view_roll_rl2, "scaleY", 0.9f, 1);
//        AnimatorSet animatorSet = new AnimatorSet();  //组合动画
//        animatorSet.playTogether(translationX, translationY, alpha, scaleX, scaleY); //设置动画
//        animatorSet.setDuration(3000);  //设置动画时间
//        animatorSet.start();
//        view_roll_rl2.setVisibility(View.VISIBLE);
//        //动画的监听
//        animatorSet.addListener(new Animator.AnimatorListener() {
//            @Override
//            public void onAnimationStart(Animator animator) {
//                view_roll_content_tv3.setText(mData.get(index));
//                setIndex();
//                setShowAnim(R.id.view_roll_rl3);
//            }
//
//            @Override
//            public void onAnimationEnd(Animator animator) {
//                setEndAnim(R.id.view_roll_rl2);
//                startAnim3();
//            }
//
//            @Override
//            public void onAnimationCancel(Animator animator) {
//            }
//
//            @Override
//            public void onAnimationRepeat(Animator animator) {
//            }
//        });
//    }
//
//    private void startAnim3() {
//        ObjectAnimator translationX = new ObjectAnimator().ofFloat(view_roll_rl3, "translationX", 15, 0);
//        ObjectAnimator translationY = new ObjectAnimator().ofFloat(view_roll_rl3, "translationY", 120, 60);
//        ObjectAnimator alpha = ObjectAnimator.ofFloat(view_roll_rl3, "alpha", 0.4f, 1);
//        ObjectAnimator scaleX = ObjectAnimator.ofFloat(view_roll_rl3, "scaleX", 0.9f, 1);
//        ObjectAnimator scaleY = ObjectAnimator.ofFloat(view_roll_rl3, "scaleY", 0.9f, 1);
//        AnimatorSet animatorSet = new AnimatorSet();  //组合动画
//        animatorSet.playTogether(translationX, translationY, alpha, scaleX, scaleY); //设置动画
//        animatorSet.setDuration(3000);  //设置动画时间
//        animatorSet.start();
//        view_roll_rl3.setVisibility(View.VISIBLE);
//        //动画的监听
//        animatorSet.addListener(new Animator.AnimatorListener() {
//            @Override
//            public void onAnimationStart(Animator animator) {
//                view_roll_content_tv1.setText(mData.get(index));
//                setIndex();
//                setShowAnim(R.id.view_roll_rl1);
//            }
//
//            @Override
//            public void onAnimationEnd(Animator animator) {
//                setEndAnim(R.id.view_roll_rl3);
//                startAnim1();
//            }
//
//            @Override
//            public void onAnimationCancel(Animator animator) {
//            }
//
//            @Override
//            public void onAnimationRepeat(Animator animator) {
//            }
//        });
//    }

    /**
     * 初始化数据
     * AlphaAnimation 透明度动画效果
     * ScaleAnimation 缩放动画效果
     * TranslateAnimation 位移动画效果
     * RotateAnimation 旋转动画效果
     */
    private void initData() {

        AlphaAnimation aaShow = new AlphaAnimation(0, 0.4f);
        aaShow.setDuration(3000);

        // 起始x轴，最终x轴，起始y轴，最终y轴
        TranslateAnimation taShow = new TranslateAnimation(15, 15, 120, 120);
        taShow.setDuration(3000);

        ScaleAnimation saShow = new ScaleAnimation(0.9f, 0.9f, 0.9f, 0.9f);
        saShow.setDuration(3000);

        AlphaAnimation aaStart = new AlphaAnimation(0.4f, 1);
        aaStart.setDuration(3000);

        AlphaAnimation aaEnd = new AlphaAnimation(1, 0.4f);
        aaEnd.setDuration(3000);

        TranslateAnimation taStart = new TranslateAnimation(15, 0, 120, 60);
        taStart.setDuration(3000);

        TranslateAnimation taEnd = new TranslateAnimation(0, 15, 60, 0);
        taEnd.setDuration(3000);

        ScaleAnimation saStart = new ScaleAnimation(0.9f, 1, 0.9f, 1);
        saStart.setDuration(3000);

        ScaleAnimation saEnd = new ScaleAnimation(1, 0.9f, 1, 0.9f);
        saEnd.setDuration(3000);

        // 显示动画
        showAnim = new AnimationSet(true);
        showAnim.setDuration(3000);
        showAnim.setStartOffset(1000);
        showAnim.setFillAfter(true);
        showAnim.addAnimation(aaShow);
        showAnim.addAnimation(taShow);
        showAnim.addAnimation(saShow);

        // 结束动画
        endAnim = new AnimationSet(true);
        endAnim.setDuration(3000);
        endAnim.addAnimation(aaEnd);
        endAnim.addAnimation(taEnd);
        endAnim.addAnimation(saEnd);

        // 第一个组件开始动画
        startAnimOne = new AnimationSet(true);
        startAnimOne.setDuration(3000);
        startAnimOne.addAnimation(aaStart);
        startAnimOne.addAnimation(taStart);
        startAnimOne.addAnimation(saStart);
        startAnimOne.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                view_roll_content_tv2.setText(mData.get(index));
                setIndex();
                view_roll_rl2.startAnimation(showAnim);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                view_roll_rl1.startAnimation(endAnim);
                view_roll_rl2.startAnimation(startAnimTwo);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        // 第二个组件开始动画
        startAnimTwo = new AnimationSet(true);
        startAnimTwo.setDuration(3000);
        startAnimTwo.addAnimation(aaStart);
        startAnimTwo.addAnimation(taStart);
        startAnimTwo.addAnimation(saStart);
        startAnimTwo.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                view_roll_content_tv3.setText(mData.get(index));
                setIndex();
                view_roll_rl3.startAnimation(showAnim);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                view_roll_rl2.startAnimation(endAnim);
                view_roll_rl3.startAnimation(startAnimThree);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        // 第三个组件开始动画
        startAnimThree = new AnimationSet(true);
        startAnimThree.setDuration(3000);
        startAnimThree.addAnimation(aaStart);
        startAnimThree.addAnimation(taStart);
        startAnimThree.addAnimation(saStart);
        startAnimThree.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                view_roll_content_tv1.setText(mData.get(index));
                setIndex();
                view_roll_rl1.startAnimation(showAnim);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                view_roll_rl3.startAnimation(endAnim);
                view_roll_rl1.startAnimation(startAnimOne);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    /**
     * 启动
     */
    public void start() {
        view_roll_content_tv1.setText(mData.get(index));
        setIndex();
        view_roll_rl1.startAnimation(startAnimOne);
    }

    private void setIndex() {
        index++;
        if (index == mData.size()) {
            index = 0;
        }
    }
}