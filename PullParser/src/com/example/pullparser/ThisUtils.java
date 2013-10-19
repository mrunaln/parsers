package com.example.pullparser;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;



import android.util.Log;


public class ThisUtils {
static class mySAXParser extends DefaultHandler{
		static ArrayList<Data> thisData;
		static Data onedata;
		static ArrayList<Data> parseData(InputStream xml) throws IOException, SAXException, XmlPullParserException{
			
			XmlPullParser parser = XmlPullParserFactory.newInstance().newPullParser();
			parser.setInput(xml,"UTF-8");
			thisData = new ArrayList<Data>();
		    int event = parser.getEventType();
		    while (event != XmlPullParser.END_DOCUMENT){
		    	
		    	switch(event){
		    	case XmlPullParser.START_TAG:
		    		if(parser.getName().equals("person")){
		    			onedata = new Data();
		    			onedata.setId(parser.getAttributeValue(null, "id"));
		    		}else if(parser.getName().equals("name")){
		    			onedata.setName(parser.nextText().trim());
		    		}else if(parser.getName().equals("age")){
		    			onedata.setAge(parser.nextText().trim());
		    		}else if(parser.getName().equals("department")){
		    			onedata.setDepartment(parser.nextText().trim());
		    		}
		    		break;
		    	case XmlPullParser.END_TAG:
		    		Log.d("Mrunal", "adding in the arraylist");
		    		thisData.add(onedata);
		    		break;
		    	default:
		    		break;
		    	}	
		    	event = parser.next();
		}
			return thisData;
}
}
}
