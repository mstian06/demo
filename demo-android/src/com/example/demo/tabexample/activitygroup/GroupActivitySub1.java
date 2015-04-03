package com.example.demo.tabexample.activitygroup;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.demo.R;

/**
 * 
 * @author tianmaosheng
 * @since 2015-3-23
 */
public class GroupActivitySub1 extends Activity{

    /* (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        TextView tv = new TextView(this);
        tv.setText(R.string.page1);
        setContentView(tv);
    }
}
