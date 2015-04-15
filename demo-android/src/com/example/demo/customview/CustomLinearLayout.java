package com.example.demo.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.LinearLayout;

/**
 * 
 * @author tianmaosheng
 * @since 2015-2-15
 */
public class CustomLinearLayout extends LinearLayout {

    /**
     * @param context
     */
    public CustomLinearLayout(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param context
     * @param attrs
     */
    public CustomLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param context
     * @param attrs
     * @param defStyle
     */
    public CustomLinearLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        // TODO Auto-generated constructor stub
    }

    /* (non-Javadoc)
     * @see android.view.View#draw(android.graphics.Canvas)
     */
    
    @Override
    public void draw(Canvas canvas) {
        // TODO Auto-generated method stub
        super.draw(canvas);
    }
    
    /* (non-Javadoc)
     * @see android.widget.LinearLayout#onDraw(android.graphics.Canvas)
     */
    @Override
    protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub
        super.onDraw(canvas);
    }
    
    /* (non-Javadoc)
     * @see android.widget.LinearLayout#onMeasure(int, int)
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // TODO Auto-generated method stub
        Log.e("TMS===", "CustomLinearLayout:widthMeasureSpec=" 
                + Util.getMeasureSpecDec(MeasureSpec.getMode(widthMeasureSpec)) + ", " 
                + (MeasureSpec.getSize(widthMeasureSpec))
                + " heightMeasureSpec=" 
                + Util.getMeasureSpecDec(MeasureSpec.getMode(heightMeasureSpec)) + ", " 
                + (MeasureSpec.getSize(heightMeasureSpec)));
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
    
    /* (non-Javadoc)
     * @see android.widget.LinearLayout#onLayout(boolean, int, int, int, int)
     */
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        // TODO Auto-generated method stub
        Log.e("TMS===", "CustomLinearLayout:onLayout,l="+l+",t="+t+",r="+r+",b="+b); 
//        super.onLayout(changed, l+r/2, t+b/2, r/2, b/2);
        super.onLayout(changed, l, t, r, b);
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
