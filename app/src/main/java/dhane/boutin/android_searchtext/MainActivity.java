package dhane.boutin.android_searchtext;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Type Scroll 1"));
        tabLayout.addTab(tabLayout.newTab().setText("Type Scroll 2"));
        tabLayout.addTab(tabLayout.newTab().setText("Type Scroll 3"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final CustomViewPager viewPager = (CustomViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            private boolean isTooLarge (TextView text, String newText) {
                float textWidth = text.getPaint().measureText(newText);
                return (textWidth >= text.getMeasuredWidth ());
            }
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(viewPager.getCurrentItem() == 2){
                    //String longText = getString(R.string.lorem_ipsum);
                    //String test = longText.substring(0, 30);
                    //int lengthText = longText.length();
                    //View view = findViewById(R.id.view3);
                    //int lengthView = view.getHeight();
                    //TextView textView = (TextView) findViewById(R.id.textView3);
                    //float textWidth = textView.getPaint().measureText(longText);
                    //TabFrag3 tab3 = new TabFrag3();
                    //int viewHeight = textView.getMeasuredHeight();
                    //int viewWidth = textView.getMeasuredWidth();
                    //1080 * 219
                    //int nbCharPage = viewHeight * viewWidth;
                    //boolean tooBig = isTooLarge(textView, test);
                    //int totalCharstoFit = textView.getPaint().breakText(longText, 0, lengthText,
                    //        true, textView.getWidth(), null);
                    //String subString = longText.substring(0,totalCharstoFit);
                    //textView.setText(subString);

                    //textView.setText("Longueur Texte : " + lengthText + ",too big ? : " + tooBig + ", longueur : " + textWidth);
                    //textView.setText(test);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
