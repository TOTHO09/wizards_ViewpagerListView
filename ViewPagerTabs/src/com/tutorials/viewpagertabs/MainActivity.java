package com.tutorials.viewpagertabs;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.ActionBar.TabListener;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.app.ActionBar.Tab;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import android.view.Menu;

public class MainActivity extends FragmentActivity {

	ActionBar ab;
	ViewPager vp;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
      //ACTIONBAR
        ab=getActionBar();
        ab.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        ab.setDisplayShowTitleEnabled(true);
        
        vp=(ViewPager) findViewById(R.id.pager);
        
        FragmentManager fm=getSupportFragmentManager();
        
        //CREATE LISTENER
       ViewPager.SimpleOnPageChangeListener listener=new SimpleOnPageChangeListener()
       {
    	   @Override
    	public void onPageSelected(int position) {
    		// TODO Auto-generated method stub
    		super.onPageSelected(position);
    		
    		ab.setSelectedNavigationItem(position);
    	}
    	   
       };
       
     //ASSIGN LISTENET
       vp.setOnPageChangeListener(listener);
       
     //ADAPTER
       MyAdapter adapter=new MyAdapter(fm);
       vp.setAdapter(adapter);
       
     //TAB LSITENER
       ActionBar.TabListener tabListener=new TabListener() {
		
		@Override
		public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onTabSelected(Tab tab, FragmentTransaction ft) {
			// TODO Auto-generated method stub
			
			vp.setCurrentItem(tab.getPosition());
			
		}
		
		@Override
		public void onTabReselected(Tab arg0, FragmentTransaction arg1) {
			// TODO Auto-generated method stub
			
		}
	};
	
	//CRETAE TABS AND SET LISTENER
	Tab t=ab.newTab().setText("ASIA").setIcon(R.drawable.alert).setTabListener(tabListener);
	ab.addTab(t);
	
	t=ab.newTab().setText("AFRICA").setIcon(R.drawable.chart).setTabListener(tabListener);
	ab.addTab(t);
	
	t=ab.newTab().setText("EUROPE").setIcon(R.drawable.interact).setTabListener(tabListener);
	ab.addTab(t);
       
    }


    
}
