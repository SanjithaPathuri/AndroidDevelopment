package com.example.bluemax;

import android.app.Activity;
import android.content.Intent;
 
import android.os.Bundle;
import android.text.InputFilter.LengthFilter;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt=(Button)findViewById(R.id.button1);
        bt.setOnClickListener(new OnClickListener() {
        	
        	@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
     Toast.makeText(getApplicationContext(),"Entering into call mode",3000).show();
    
			Intent i=new Intent(
					MainActivity.this,
					MainActivity2.class);
			startActivity(i);
			
					
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
