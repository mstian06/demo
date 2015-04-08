package com.example.demo.butterknife;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

import com.example.demo.R;

/**
 * 
 * @author tianmaosheng
 * @since 2015-4-7
 */
public class ButterknifeActivity extends Activity {
    
    @InjectView(R.id.text) TextView tv;
    @InjectView(R.id.image) ImageView iv;
    
    /* (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_butterknife_test);
        ButterKnife.setDebug(true);
        ButterKnife.inject(this);
        
        tv.setText("hello, butterknife");
        iv.setImageResource(R.drawable.ic_launcher);
    }
    
    @OnClick(R.id.button1)
//    @OnClick(R.id.button2)
    public void onClickButton(Button button) {
        if (button.getId() == R.id.button1) {
            Toast.makeText(this, "test...", Toast.LENGTH_SHORT).show();
        }
        
    }

}
