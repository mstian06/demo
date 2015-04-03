package com.example.demo.custom.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View.MeasureSpec;
import android.widget.TextView;

/**
 * 
 * @author tianmaosheng
 * @since 2015-2-15
 */
public class CustomTextView extends TextView {

    /**
     * @param context
     * @param attrs
     * @param defStyle
     */
    public CustomTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param context
     * @param attrs
     */
    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param context
     */
    public CustomTextView(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
    }

    /* (non-Javadoc)
     * @see android.widget.TextView#onDraw(android.graphics.Canvas)
     */
    @Override
    protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub
        super.onDraw(canvas);
    }
    
    /* (non-Javadoc)
     * @see android.widget.TextView#onLayout(boolean, int, int, int, int)
     */
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        // TODO Auto-generated method stub
        super.onLayout(changed, left, top, right, bottom);
    }
    
    /* (non-Javadoc)
     * @see android.widget.TextView#onMeasure(int, int)
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // TODO Auto-generated method stub
        Log.e("TMS===", "CustomTextView:widthMeasureSpec=" 
                + Util.getMeasureSpecDec(MeasureSpec.getMode(widthMeasureSpec)) + ", " 
                + (MeasureSpec.getSize(widthMeasureSpec))
                + " heightMeasureSpec=" 
                + Util.getMeasureSpecDec(MeasureSpec.getMode(heightMeasureSpec)) + ", " 
                + (MeasureSpec.getSize(heightMeasureSpec)));
        
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        // 下面是view中的默认处理方法，textview的onMeasur对Mode=AT_MOST时有做处理，所以效果不同，可以对比一下。
        setMeasuredDimension(MeasureSpec.getSize(widthMeasureSpec), MeasureSpec.getSize(heightMeasureSpec));
//        setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);//错误的使用方法，set的时候应该不含有mode。
    }
    
    /* (non-Javadoc)
     * @see android.view.View#requestLayout()
     */
    @Override
    public void requestLayout() {
        // TODO Auto-generated method stub
        super.requestLayout();
    }
    
    
}
