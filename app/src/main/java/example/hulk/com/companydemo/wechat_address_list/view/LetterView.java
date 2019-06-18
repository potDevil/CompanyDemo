package example.hulk.com.companydemo.wechat_address_list.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * className: MyLetterListView
 * description: 字母定位列表
 * author: hong
 * datetime: 2016/4/15 0015 下午 5:37
 */
public class LetterView extends View {

    OnTouchLetterChangedListener onTouchingLetterChangedListener;

   /* private String[] b = {"定位", "热门", "全部", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K",
            "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X",
            "Y", "Z"};*/

    private String[] b ;


    public String[] getB() {
        return b;
    }

    public void setB(String[] b) {
        this.b = b;
    }

    private int choose = -1;
    private Paint paint = new Paint();
    private boolean showBkg = false;

    public LetterView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public LetterView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LetterView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (showBkg) {
//            canvas.drawColor(Color.parseColor("#40000000"));
            canvas.drawColor(Color.parseColor("#00000000"));
        }
        int height = getHeight();
        int width = getWidth();
        int singleHeight = height / getB().length;
        for (int i = 0; i < getB().length; i++) {
            paint.setColor(Color.parseColor("#007AFF"));
            paint.setTextSize(19);
            // paint.setTypeface(Typeface.DEFAULT_BOLD);
            paint.setAntiAlias(true);
            /*if (i == choose) {
				paint.setColor(Color.parseColor("#3399ff"));
				paint.setFakeBoldText(true);
			}*/
            float xPos = width / 2 - paint.measureText(getB()[i]) / 2;
            float yPos = singleHeight * i + singleHeight;
            canvas.drawText(getB()[i], xPos, yPos, paint);
            paint.reset();
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        final int action = event.getAction();
        final float y = event.getY();
        final int oldChoose = choose;
        final OnTouchLetterChangedListener listener = onTouchingLetterChangedListener;
        final int c = (int) (y / getHeight() * getB().length);
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                showBkg = true;
                if (oldChoose != c && listener != null) {
                    if (c >= 0 && c < b.length) {
                        listener.touchLetterChanged(getB()[c]);
                        choose = c;
                        invalidate();
                    }
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if (oldChoose != c && listener != null) {
                    if (c >= 0 && c < b.length) {
                        listener.touchLetterChanged(getB()[c]);
                        choose = c;
                        invalidate();
                    }
                }
                break;
            case MotionEvent.ACTION_UP:
                showBkg = false;
                choose = -1;
                invalidate();
                break;
        }
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    public void setOnTouchingLetterChangedListener(
            OnTouchLetterChangedListener onTouchLetterChangedListener) {
        this.onTouchingLetterChangedListener = onTouchLetterChangedListener;
    }

    public interface OnTouchLetterChangedListener {
          void touchLetterChanged(String s);
    }
}
