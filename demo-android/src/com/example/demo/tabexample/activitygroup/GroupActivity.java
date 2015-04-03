package com.example.demo.tabexample.activitygroup;

import android.app.ActivityGroup;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.demo.R;

/**
 * 
 * @author tianmaosheng
 * @since 2015-3-23
 */
public class GroupActivity extends ActivityGroup implements OnClickListener {
    
    RelativeLayout container;
    RelativeLayout tab_boutique_layout;
    RelativeLayout tab_game_layout;
    RelativeLayout tab_software_layout;
    
    View decorView_tab1;
    View decorView_tab2;
    View decorView_tab3;
    View currentTab;
    
    ImageView tab_icon1;
    ImageView tab_icon2;
    ImageView tab_icon3;

    /* (non-Javadoc)
     * @see android.app.ActivityGroup#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_group_activity);
        
        initView();
    }
    
    public void initView() {
        container = (RelativeLayout) findViewById(R.id.Container);
        tab_boutique_layout = (RelativeLayout) findViewById(R.id.tab_boutique_layout);
        tab_game_layout = (RelativeLayout) findViewById(R.id.tab_game_layout);
        tab_software_layout = (RelativeLayout) findViewById(R.id.tab_software_layout);
        
        tab_boutique_layout.setOnClickListener(this);
        tab_game_layout.setOnClickListener(this);
        tab_software_layout.setOnClickListener(this);
        
        tab_icon1 = (ImageView) findViewById(R.id.tab_icon1);
        tab_icon2 = (ImageView) findViewById(R.id.tab_icon2);
        tab_icon3 = (ImageView) findViewById(R.id.tab_icon3);
       
        switchSubActivity(tab_boutique_layout);
    }

    /* (non-Javadoc)
     * @see android.view.View.OnClickListener#onClick(android.view.View)
     */
    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.tab_boutique_layout:
            case R.id.tab_game_layout:
            case R.id.tab_software_layout:
                switchSubActivity(v);
                break;
            default:
                break;
        }
    }
    
    public void switchSubActivity(View v) {
        Intent intent = null;
        View view = null;
        currentTab = v;
        switch (v.getId()) {
        case R.id.tab_boutique_layout:// 精品
            if (decorView_tab1 == null) {
                intent = new Intent(this, GroupActivitySub1.class);
                Window win = getLocalActivityManager().startActivity("subActivity", intent);
                decorView_tab1 = win.getDecorView();
            }
            view = decorView_tab1;
            break;
        case R.id.tab_game_layout:// 游戏
            if (decorView_tab2 == null) {
                intent = new Intent(this, GroupActivitySub2.class);
                Window win = getLocalActivityManager().startActivity("subActivity", intent);
                decorView_tab2 = win.getDecorView();
            }
            view = decorView_tab2;
            break;
        case R.id.tab_software_layout:// 软件
            if (decorView_tab3 == null) {
                intent = new Intent(this, GroupActivitySub3.class);
                Window win = getLocalActivityManager().startActivity("subActivity", intent);
                decorView_tab3 = win.getDecorView();
            }
            view = decorView_tab3;
            break;
        default:
            break;
        }
        container.removeAllViews();// 必须先清除容器中所有的View
        container.addView(view, LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        updateViewSelecter(v);
    }
    
    public void updateViewSelecter(View v) {
        clearSelection();
        if (tab_boutique_layout == currentTab) {
//            tab_boutique_layout.setBackgroundResource(R.drawable.background_dark);
//            tab_game_layout.setBackgroundResource(R.drawable.background_light);
//            tab_software_layout.setBackgroundResource(R.drawable.background_light);
            tab_icon1.setImageResource(R.drawable.icon1_1);
        } else if (tab_game_layout == currentTab) {
//            tab_boutique_layout.setBackgroundResource(R.drawable.background_light);
//            tab_game_layout.setBackgroundResource(R.drawable.background_dark);
//            tab_software_layout.setBackgroundResource(R.drawable.background_light);
            tab_icon2.setImageResource(R.drawable.icon2_1);
        } else if (tab_software_layout == currentTab) {
//            tab_boutique_layout.setBackgroundResource(R.drawable.background_light);
//            tab_game_layout.setBackgroundResource(R.drawable.background_light);
//            tab_software_layout.setBackgroundResource(R.drawable.background_dark);
            tab_icon3.setImageResource(R.drawable.icon3_1);
        }
    }
    
    public void clearSelection() {
        tab_icon1.setImageResource(R.drawable.icon1_0);
        tab_icon2.setImageResource(R.drawable.icon2_0);
        tab_icon3.setImageResource(R.drawable.icon3_0);
    }
    
}
