package com.tutorials.dbgridview;

import java.util.ArrayList;



import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

	
	ListView lv;
	EditText nameTxt,posTxt;
	Button savebtn,retrieveBtn;
	ArrayList<String> players=new ArrayList<String>();
	
	ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        nameTxt=(EditText) findViewById(R.id.nameTxt);
        posTxt=(EditText) findViewById(R.id.posTxt);
        
        savebtn=(Button) findViewById(R.id.saveBtn);
        retrieveBtn=(Button) findViewById(R.id.retrievebtn);
       
        lv=(ListView) findViewById(R.id.listView1);
        lv.setBackgroundColor(Color.LTGRAY);
        
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_selectable_list_item,players);
        
        final DBAdapter db=new DBAdapter(this);
        
        //EVENTS
        savebtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				//OPEN
				db.openDB();
				
				//INSERT
				long result=db.add(nameTxt.getText().toString(), posTxt.getText().toString());
				
				if(result > 0)
				{
					nameTxt.setText("");
                    posTxt.setText("");
				}else
				{
					Toast.makeText(getApplicationContext(), "Failure", Toast.LENGTH_SHORT).show();
				}
				
				
				//CLOSE DB
				db.close();
			}
		});
        
        //RETRIEVE
        retrieveBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				players.clear();
				
				//OPEN
				db.openDB();
				
				//RETRIEVE
				Cursor c=db.getAllNames();
				
				while(c.moveToNext())
				{
					String name=c.getString(1);
					players.add(name);
				}
				
				lv.setAdapter(adapter);
				
				db.close();
				
			}
		});
        
        lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int pos,
					long id) {
				// TODO Auto-generated method stub
				
				Toast.makeText(getApplicationContext(), players.get(pos), Toast.LENGTH_SHORT).show();
				
			}
		});
        
    }
}
























