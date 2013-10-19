package com.example.inclass4;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.xml.sax.SAXException;
import org.xmlpull.v1.XmlPullParserException;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.webkit.WebView.FindListener;
import android.widget.TextView;

public class ThisAsyncTask  extends AsyncTask<String, Void, Data>{
		@Override
		protected Data doInBackground(String... params) {
			try {
				
				 URL url = new URL(params[0]);
				 HttpURLConnection con = (HttpURLConnection) url.openConnection();
				 con.setRequestMethod("GET");
				 con.connect();
		
				 int statusCode = con.getResponseCode();
				 if (statusCode == HttpURLConnection.HTTP_OK) {
					 InputStream in = con.getInputStream();
					 Data data = ThisUtils.mySAXParser.parseData(in);
					 Log.d("Mrunal"," data = " + data.toString());
					 con.disconnect();
					 
					 
					 /* to download get url
					  *  
					 URL myurl = new URL(data.getImageUrl());
					 Bitmap image = BitmapFactory.decodeStream(myurl.openStream());
					 */
					 
					 return data;
				 }
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (SAXException e) {
				e.printStackTrace();
			} catch (XmlPullParserException e) {
				e.printStackTrace();
			}
			
			return null;
		}

		@Override
		protected void onPostExecute(Data result) {
			super.onPostExecute(result);
			Log.d("Mrunal"," something - " + result);
			/*TextView appname = (TextView) findViewById(R.id.name);
			TextView appprice = (TextView) findViewById(R.id.price);
			
			appname.setText(result.getName());
			appprice.setText(result.getPrice());
			*/
		}
}
