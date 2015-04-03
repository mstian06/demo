
package com.example.demo;

import android.content.Intent;

public class MainActivity extends BaseListActivity {

    /* (non-Javadoc)
     * @see com.example.demo.BaseListActivity#getQueryIntent()
     */
    @Override
    public Intent getQueryIntent() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(TEST_CAGEGORY);
        return intent;
    }
}
