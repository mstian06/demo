package com.example.demo.tabexample.fragment;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.demo.R;

/**
 * [Android Fragment应用实战，使用碎片向ActivityGroup说再见](http://blog.csdn.net/guolin_blog/article/details/13171191)
 * 
 * transaction.replace(R.id.content, fragment3);
 * transaction.add(R.id.content, fragment3);
 * transaction.show(fragment3);
 * transaction.hide(fragment3);
 * 这里注意一个细节，我们添加Fragment的时候并没有使用replace()方法，而是会先判断一下该Fragment是否为空，
 * 如果是空的则调用add()方法添加一个进来，如果不是空的则直接调用show()方法显示出来即可。
 * 那么为什么没有使用replace()方法呢？这是因为replace()方法会将被替换掉的那个Fragment彻底地移除掉，
 * 该Fragment的生命周期就结束了。当再次点击刚才那个Tab项的时候，就会让该Fragment的生命周期重新开始，
 * onCreate()、onCreateView()等方法都会重新执行一遍。这显然不是我们想要的，也和ActivityGroup的工作原理不符，
 * 因此最好的解决方案就是使用hide()和show()方法来隐藏和显示Fragment，这就不会让Fragment的生命周期重走一遍了。
 * 
 * [说明] 这里继承自Activity和FragmentActivity的区别。。。。。
 * 1. FragmentActivity  是android-support-v4.jar,jar包里面的类.为了兼容低版本.是activiity的子类.
 *      操作fragment的一些方法，其功能跟3.0及以后的版本的Activity的功能一样
 *      fragmentactivity 继承自activity，用来解决android3.0 之前没有fragment的api
 * 2. 当然3.0之后你就可以直接继承自Activity，并且在其中嵌入使用fragment了。 
 * 3. 获得Manager的方式也不同 
 *      3.0以下：getSupportFragmentManager() 
 *      3.0以上：getFragmentManager() 
 * 如果不考虑兼容,不考虑fragment的话,就直接用activity.
 * 
 * @author tianmaosheng
 * @since 2015-3-23
 */
public class FragmentTabActivity extends Activity implements OnClickListener {
    
    FrameLayout content;
    View buttom_tab_layout;
    View tab_boutique_layout;
    View tab_game_layout;
    View tab_software_layout;
    ImageView tab_icon1;
    ImageView tab_icon2;
    ImageView tab_icon3;
    
    Fragment1 fragment1;
    Fragment2 fragment2;
    Fragment3 fragment3;
    FragmentManager fragmentManager;

    /* (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_fragment_activity);
        
        initViews();
        fragmentManager = getFragmentManager();
        setTabSelection(0);
    }

    public void initViews() {
        content = (FrameLayout) findViewById(R.id.content);
        buttom_tab_layout = (View) findViewById(R.id.buttom_tab_layout);
        tab_boutique_layout = (View) findViewById(R.id.tab_boutique_layout);
        tab_game_layout = (View) findViewById(R.id.tab_game_layout);
        tab_software_layout = (View) findViewById(R.id.tab_software_layout);
        tab_icon1 = (ImageView) findViewById(R.id.tab_icon1);
        tab_icon2 = (ImageView) findViewById(R.id.tab_icon2);
        tab_icon3 = (ImageView) findViewById(R.id.tab_icon3);
        
        tab_boutique_layout.setOnClickListener(this);
        tab_game_layout.setOnClickListener(this);
        tab_software_layout.setOnClickListener(this);
    }

    /* (non-Javadoc)
     * @see android.view.View.OnClickListener#onClick(android.view.View)
     */
    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.tab_boutique_layout:
                setTabSelection(0);
                break;
            case R.id.tab_game_layout:
                setTabSelection(1);
                break;
            case R.id.tab_software_layout:
                setTabSelection(2);
                break;
            default:
                break;
        }
    }
    
    public void setTabSelection(int index) {
        clearSelection();  
        FragmentTransaction transaction = fragmentManager.beginTransaction();  
        hideFragments(transaction);
        switch (index) {
            case 0: {
                tab_icon1.setImageResource(R.drawable.icon1_1);
                if (fragment1 == null) {
                    fragment1 = new Fragment1();
                    transaction.add(R.id.content, fragment1);
                } else {
                    transaction.show(fragment1);
                }
                break;
            }
            case 1: {
                tab_icon2.setImageResource(R.drawable.icon2_1);
                if (fragment2 == null) {
                    fragment2 = new Fragment2();
                    transaction.add(R.id.content, fragment2);
                } else {
                    transaction.show(fragment2);
                }
                break;
            }
            case 2: {
                tab_icon3.setImageResource(R.drawable.icon3_1);
                if (fragment3 == null) {
                    fragment3 = new Fragment3();
                    transaction.add(R.id.content, fragment3);
                } else {
                    transaction.show(fragment3);
                }
                break;
            }
            default:
                break;
        }
        transaction.commit();
    }
    
    public void clearSelection() {
        tab_icon1.setImageResource(R.drawable.icon1_0);
        tab_icon2.setImageResource(R.drawable.icon2_0);
        tab_icon3.setImageResource(R.drawable.icon3_0);
    }
    
    private void hideFragments(FragmentTransaction transaction) {  
        if (fragment1 != null) {
            transaction.hide(fragment1);
        }
        if (fragment2 != null) {
            transaction.hide(fragment2);
        }
        if (fragment3 != null) {
            transaction.hide(fragment3);
        }
    }
}
