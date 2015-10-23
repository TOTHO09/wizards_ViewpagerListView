package com.tutorials.viewpagertabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MyAdapter extends FragmentPagerAdapter {

	final int pageCount=3;
	Bundle info;
	
	public MyAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Fragment getItem(int pos) {
		// TODO Auto-generated method stub
		
		info=new Bundle();
		
		//CHECK SELECTED TAB
		
		switch (pos) {
		case 0:
			Asia asia=new Asia();
			info.putInt("currentPage", pos++);
			asia.setArguments(info);
			return asia;
		case 1:
			Africa africa=new Africa();
			info.putInt("currentPage", pos++);
			africa.setArguments(info);
			return africa;
		case 2:
			Europe eu=new Europe();
			info.putInt("currentPage", pos++);
			eu.setArguments(info);
			return eu;
			

	
		}
		
		return null;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return pageCount;
	}

	
}
