package com.example.demo.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * 
 * @author tianmaosheng
 * @since 2015-4-2
 */
public class CustomView extends View {

    /**
     * @param context
     * @param attrs
     */
    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    /* (non-Javadoc)
     * @see android.view.View#onMeasure(int, int)
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // TODO Auto-generated method stub
        Log.e("TMS===", "CustomView:widthMeasureSpec=" 
                + Util.getMeasureSpecDec(MeasureSpec.getMode(widthMeasureSpec)) + ", " 
                + (MeasureSpec.getSize(widthMeasureSpec))
                + " heightMeasureSpec=" 
                + Util.getMeasureSpecDec(MeasureSpec.getMode(heightMeasureSpec)) + ", " 
                + (MeasureSpec.getSize(heightMeasureSpec)));
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
    
    /* (non-Javadoc)
     * @see android.view.View#onLayout(boolean, int, int, int, int)
     */
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        // TODO Auto-generated method stub
        Log.e("TMS===", "CustomLayout:onLayout,l="+left+",t="+top+",r="+right+",b="+bottom); 
        super.onLayout(changed, left, top, right, bottom);
    }
    
    /* (non-Javadoc)
     * @see android.view.View#draw(android.graphics.Canvas)
     */
    @Override
    public void draw(Canvas canvas) {
        // TODO Auto-generated method stub
//        super.draw(canvas);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.GREEN);
//        String text = "test...";  
//        canvas.drawText(text, 0, getHeight() / 2, paint);  
        canvas.drawRect(0, 0, getWidth(), getHeight(), paint);  
        paint.setColor(Color.BLUE);  
        paint.setTextSize(20);  
        String text = "Hello View";  
        canvas.drawText(text, 0, getHeight() / 2, paint);  
    }
    
}
