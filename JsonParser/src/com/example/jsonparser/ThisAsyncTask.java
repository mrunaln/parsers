package com.example.jsonparser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.json.JSONException;
import org.xml.sax.SAXException;
import org.xmlpull.v1.XmlPullParserException;

import android.os.AsyncTask;
import android.util.Log;

public class ThisAsyncTask  extends AsyncTask<String, Void, ArrayList<JsonData>>{
		@Override
		protected ArrayList<JsonData> doInBackground(String... params) {
			try {
				 URL url = new URL(params[0]);
				 HttpURLConnection con = (HttpURLConnection) url.openConnection();
				 con.setRequestMethod("GET");
				 con.connect();
				 int statusCode = con.getResponseCode();
				 Log.d("Mrunal","--" + statusCode);
				 if (statusCode == HttpURLConnection.HTTP_OK) {
					 
					 BufferedReader buffer = new BufferedReader(new InputStreamReader(con.getInputStream()));
					 StringBuilder sb = new StringBuilder();
					 String line = buffer.readLine();
					 
					 while(line != null){
						 sb.append(line);
						 line = buffer.readLine();
					 }
					 ArrayList<JsonData> data = ThisUtils.myJSONParser.parseData(sb.toString());
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
			} catch (JSONException e) {
				e.printStackTrace();
			}
			
			return null;
		}

		@Override
		protected void onPostExecute(ArrayList<JsonData> result) {
			super.onPostExecute(result);
			for (int i = 0 ; i <result.size(); i++)
				Log.d("Mrunal"," Data =  " + result.get(i));
			
		}
}
