package com.apps.cerelium.kee;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.apps.cerelium.kee.Common.PagerAdapter;
import com.viewpagerindicator.CirclePageIndicator;


public class MainActivity extends ActionBarActivity implements View.OnTouchListener, ViewTreeObserver.OnScrollChangedListener{

    ListView listViewMain;
    ViewPager viewPager;

    ActionBar actionBar;
    public GestureDetector gestureDetector1;
    public float x,y;
    public static final String TAG = "MyTag";
    private ActionBar mActionBar;
    public float mActionBarHeight;
    public float yValue;
    int exitvalue=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Adding the View pager for swipe views
        viewPager = (ViewPager) findViewById(R.id.pager_mainActivity);
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(),this);
        viewPager.setAdapter(pagerAdapter);

        //Setting Page Indicator
        CirclePageIndicator circlePageIndicator = (CirclePageIndicator) findViewById(R.id.indicator);
        circlePageIndicator.setViewPager(viewPager);
        circlePageIndicator.setStrokeColor(Color.parseColor("#FF4D2AC2")); //Outer circle color >> Dark Black
        circlePageIndicator.setFillColor(Color.parseColor("#FF040405"));  //Current Page color
        circlePageIndicator.setPageColor(Color.TRANSPARENT); //Un-selected page fill color
        circlePageIndicator.setCentered(true);
        circlePageIndicator.setRadius(10);
        circlePageIndicator.setCentered(true);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
       /* if (id == R.id.action_settings) {
            return true;
        }
*/
        return super.onOptionsItemSelected(item);
    }


    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        return super.onCreateView(parent, name, context, attrs);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        //FileManager fileManager = new FileManager();
        //fileManager.writeBackGroundsForJsonFile();
        //Context context = getApplicationContext();
        //fileManager.getSections(context);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Nullable
    @Override
    public View onCreateView(String name, @NonNull Context context, @NonNull AttributeSet attrs) {
        return super.onCreateView(name, context, attrs);

    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }

    @Override
    public void onScrollChanged() {



    }

    public void ShowHide() {
        float y = yValue;
        if (y >= mActionBarHeight && mActionBar.isShowing()) {
            mActionBar.hide();
        } else if ( y==0 && !mActionBar.isShowing()) {
            mActionBar.show();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && exitvalue==0) {
            exitvalue=1;
            Toast.makeText(getApplicationContext(),"Press again to exit",Toast.LENGTH_SHORT).show();
            return false;
        }
        else {
            exitvalue=0;
            Toast.makeText(getApplicationContext(),"Exiting",Toast.LENGTH_SHORT).show();
            Intent homeIntent = new Intent(Intent.ACTION_MAIN);
            homeIntent.addCategory(Intent.CATEGORY_HOME);
            homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(homeIntent);
            return true;
        }

    }

    public void showMainPopup(View v)
    {
        PopupMenu popup = new PopupMenu(this, v);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_main, popup.getMenu());
        popup.show();
    }

    public void onClick(View v) {

        int id = v.getId();


    }
}
