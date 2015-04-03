package com.example.demo.tabexample.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.demo.R;

/**
 * 
 * @author tianmaosheng
 * @since 2015-3-23
 */
public class Fragment2 extends Fragment {

    /* (non-Javadoc)
     * @see android.app.Fragment#onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle)
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        TextView tv = new TextView(getActivity());
        tv.setText(R.string.tab2);
        return tv;
    }
}
