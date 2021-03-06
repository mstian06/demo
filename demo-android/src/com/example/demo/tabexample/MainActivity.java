package com.example.demo.tabexample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.demo.R;
import com.example.demo.tabexample.ViewPagerIndicator.SampleTabsDefault;
import com.example.demo.tabexample.activitygroup.GroupActivity;
import com.example.demo.tabexample.fragment.FragmentTabActivity;
import com.example.demo.tabexample.fragment2.Fragment2MainActivity;
import com.example.demo.tabexample.tabhost.TabHostActivity;
import com.example.demo.tabexample.viewpager.ViewPagerMainActivity;
import com.example.demo.tabexample.viewpagerfragment.ViewPagerFragmentMainActivity;

/**
 * 
 * @author tianmaosheng
 * @since 2015-3-23
 */
public class MainActivity extends Activity implements OnItemClickListener {
    
    private final String items[] = {"Acitivty Group", "Tabhost", "Fragment", "Fragment2", 
            "ViewPager", "ViewPagerFragment", "ViewPagerIndicators"};
    
    public ListView listView;
    
    /* (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
        
        init();
    }
    
    /* (non-Javadoc)
     * @see android.app.Activity#onResume()
     */
    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
    }
    
    public void init() {
        listView = (ListView) findViewById(R.id.list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    /* (non-Javadoc)
     * @see android.widget.AdapterView.OnItemClickListener#onItemClick(android.widget.AdapterView, android.view.View, int, long)
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // TODO Auto-generated method stub
        Intent intent = null;
        switch (position) {
            case 0: {
                intent = new Intent(MainActivity.this, GroupActivity.class);
                break;
            }
            case 1: {
                intent = new Intent(MainActivity.this, TabHostActivity.class);
                break;
            }
            case 2: {
                intent = new Intent(MainActivity.this, FragmentTabActivity.class);
                break;
            }
            case 3: {
                intent = new Intent(MainActivity.this, Fragment2MainActivity.class);
                break;
            }
            case 4: {
                intent = new Intent(MainActivity.this, ViewPagerMainActivity.class);
                break;
            }
            case 5: {
                intent = new Intent(MainActivity.this, ViewPagerFragmentMainActivity.class);
                break;
            }
            case 6: {
                intent = new Intent(MainActivity.this, SampleTabsDefault.class);
                break;
            }
            default:
                return;
        }
        if (intent != null) {
            startActivity(intent);
        }
    }
}
