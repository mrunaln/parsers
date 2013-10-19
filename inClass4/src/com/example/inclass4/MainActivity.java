/*
 * Mrunal Nargunde
 * In class assignment 4
 * */
 
package com.example.inclass4;

import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {
	static ProgressDialog	mainProgressdialog;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.d("Mrunal","will execute async task now");
		mainProgressdialog = new ProgressDialog(this);
		
		displaymainProgressDialog();
		new ThisAsyncTask().execute("http://itunes.apple.com/us/rss/toppaidapplications/limit=50/xml");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
public static void displaymainProgressDialog(){
		
		mainProgressdialog.setCancelable(false);
		mainProgressdialog.setMessage("Loading Image");
		mainProgressdialog.setCanceledOnTouchOutside(false);
		mainProgressdialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		mainProgressdialog.show();
	}

}
