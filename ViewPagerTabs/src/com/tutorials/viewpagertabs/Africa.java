package com.tutorials.viewpagertabs;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Africa extends ListFragment {

	String[] countries={"Kenya","Nigeria","Rwanda","South Africa","Egypt","Uganda"};
	ArrayAdapter<String> adapter;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		adapter=new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_multiple_choice, countries);
		setListAdapter(adapter);
		
		return super.onCreateView(inflater, container, savedInstanceState);
	}
	
	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		
		getListView().setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
		
		getListView().setBackgroundColor(new Color().parseColor("#f36e4b"));
	}
}
