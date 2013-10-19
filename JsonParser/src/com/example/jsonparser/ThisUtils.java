package com.example.jsonparser;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;






import android.util.Log;


public class ThisUtils {
static class myJSONParser extends DefaultHandler{
		static ArrayList<JsonData> thisData;
		static JsonData onedata;
		static ArrayList<JsonData> parseData(String json) throws IOException, SAXException, XmlPullParserException, JSONException{
			
			thisData = new ArrayList<JsonData>();
			JSONObject jsonObject = new JSONObject(json);
			JSONArray jsonArray = jsonObject.getJSONArray("persons");
			//jsonObject.getJSONObject("photos").getJSONObject("photo").getJSONArray("");
			for(int i= 0 ; i < jsonArray.length() ; i++){
				JSONObject jsonPerson = jsonArray.getJSONObject(i);
				onedata = new JsonData();
				onedata.setName(jsonPerson.getString("name"));
				onedata.setAge(jsonPerson.getInt("age"));
				onedata.setDepartment(jsonPerson.getString("department"));
				onedata.setId(jsonPerson.getInt("id"));
				
				thisData.add(onedata);
			}
			return thisData;
}
}
}
