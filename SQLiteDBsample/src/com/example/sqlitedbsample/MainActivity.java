package com.example.sqlitedbsample;

import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	SQLiteDatabase db;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText et=(EditText)findViewById(R.id.editText1);
        final Button insert=(Button)findViewById(R.id.button1);
        final Button retrieve=(Button)findViewById(R.id.button2);
        insert.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String value=et.getText().toString();
				db=openOrCreateDatabase("GNITS",MODE_PRIVATE,null);
				db.execSQL("create table if not exists student(name varchar(20))");
				db.execSQL("insert into student values('"+value+"')");
				Toast.makeText(getApplicationContext(),"inserted",Toast.LENGTH_LONG).show();
				et.setText("");
				
			}
		});
  
        retrieve.setOnClickListener(new OnClickListener(){
        @Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
        		db=openOrCreateDatabase("GNITS",MODE_PRIVATE,null);
        		Cursor c=db.rawQuery("select * from student",null);
        		c.moveToFirst();
        		if(c!=null){
        			do{
        				int c1=c.getColumnIndex("name");
        						String value=c.getString(c1);
        			Toast.makeText(getApplicationContext(),"value",Toast.LENGTH_LONG).show();
        			}while(c.moveToNext());
        		}
             }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
  } 