package com.example.demo;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.ActionBar;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public abstract class BaseListActivity extends ListActivity {
    public static final String TEST_CAGEGORY = "com.example.demo.intent.category.ITEM";

    public static final String KEY_LABEL = "lable";
    public static final String KEY_INTENT = "intent";
    public static final String EXTRA_TITLE = "com.example.demo.extra.TITLE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SimpleAdapter adapter = new SimpleAdapter(this, getListViewData(this), android.R.layout.simple_list_item_1,
                new String[] { KEY_LABEL }, new int[] { android.R.id.text1 });

        this.setListAdapter(adapter);
        this.getListView().setTextFilterEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }

    private List<Map<String, Object>> getListViewData(Context context) {
        List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();

        Intent intent = getQueryIntent();
        if (null == intent) {
            return data;
        }

        PackageManager packageMgr = context.getPackageManager();
        List<ResolveInfo> resolveInfos = packageMgr.queryIntentActivities(intent, 0);

        for (ResolveInfo resolveInfo : resolveInfos) {
            CharSequence labelSeq = resolveInfo.loadLabel(packageMgr);
            String label = (null != labelSeq) ? labelSeq.toString() : resolveInfo.activityInfo.name;
            addDataItem(data, label, resolveInfo);
        }

        // Sort the collection.
        Collections.sort(data, new Comparator<Map<String, Object>>() {
            private Collator m_collator = Collator.getInstance();

            @Override
            public int compare(Map<String, Object> object1, Map<String, Object> object2) {
                return m_collator.compare(object1.get(KEY_LABEL), object2.get(KEY_LABEL));
            }
        });

        return data;
    }

    public abstract Intent getQueryIntent();

    protected void addDataItem(List<Map<String, Object>> list, String label, ResolveInfo info) {
        Intent intent = new Intent();
        intent.setClassName(info.activityInfo.applicationInfo.packageName, info.activityInfo.name);
        Map<String, Object> temp = new HashMap<String, Object>();
        temp.put(KEY_LABEL, label);
        temp.put(KEY_INTENT, intent);

        list.add(temp);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Map<String, Object> map = (Map<String, Object>) l.getItemAtPosition(position);
        Intent intent = (Intent) map.get(KEY_INTENT);
        intent.putExtra(EXTRA_TITLE, this.getTitle());
        this.startActivity(intent);
    }
}
