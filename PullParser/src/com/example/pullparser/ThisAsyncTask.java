package com.example.pullparser;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.xml.sax.SAXException;
import org.xmlpull.v1.XmlPullParserException;
import android.os.AsyncTask;
import android.util.Log;

public class ThisAsyncTask  extends AsyncTask<String, Void, ArrayList<Data>>{
		@Override
		protected ArrayList<Data> doInBackground(String... params) {
			try {
				 URL url = new URL(params[0]);
				 HttpURLConnection con = (HttpURLConnection) url.openConnection();
				 con.setRequestMethod("GET");
				 con.connect();
		
				 int statusCode = con.getResponseCode();
				 Log.d("Mrunal","--" + statusCode);
				 if (statusCode == HttpURLConnection.HTTP_OK) {
					 InputStream in = con.getInputStream();
					 ArrayList<Data> data = ThisUtils.mySAXParser.parseData(in);
					 Log.d("Mrunal"," data = " + data.toString());
					 con.disconnect();
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
		protected void onPostExecute(ArrayList<Data> result) {
			super.onPostExecute(result);
			Log.d("Mrunal"," something - " + result);
			
		}
}
