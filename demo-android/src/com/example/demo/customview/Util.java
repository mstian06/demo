package com.example.demo.customview;

import android.view.View.MeasureSpec;

/**
 * 
 * @author tianmaosheng
 * @since 2015-4-2
 */
public class Util {

    public static String getMeasureSpecDec(int value) {
        String ret = "";
        switch (value) {
            case MeasureSpec.UNSPECIFIED:
                ret = "UNSPECIFIED";
                break;
            case MeasureSpec.AT_MOST:
                ret = "AT_MOST";
                break;
            case MeasureSpec.EXACTLY:
                ret = "EXACTLY";
                break;
            default:
                break;
        }
        return ret;
    }
}
