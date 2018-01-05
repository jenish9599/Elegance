package com.jenish9599.android.eleganceapp;

import android.os.AsyncTask;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Blog_Feed extends AppCompatActivity {


    ViewPager viewPager;
    PageViewerAdeptor pageViewerAdeptor;


    List<blogs> data_local = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog__feed);


        final dataloader mydataloader = new dataloader();

        try{
            mydataloader.execute(new URL("https://newsfeed-d3d2c.firebaseio.com/.json?print=pretty&format=export&download=newsfeed-d3d2c-export.json"));
        }catch (Exception e){
            e.printStackTrace();
        }


        viewPager = (ViewPager)findViewById(R.id.viewPager);


    }


    private void parseJSon(String data) throws JSONException {
        if (data == null)
            return;
        data_local=new ArrayList<>();
        JSONArray jsonArray=new JSONArray(data);
        for(int i=1;i<jsonArray.length();i++){
            if(jsonArray.get(i)==null)continue;;
            JSONObject json_temp=jsonArray.getJSONObject(i);


            data_local.add(new blogs(json_temp.getString("title"),json_temp.getString("description"),json_temp.getString("imgsrc")));


        }

        pageViewerAdeptor= new PageViewerAdeptor(data_local,this);
        viewPager.setAdapter(pageViewerAdeptor);



    }



    public class dataloader extends AsyncTask<URL,Void,String>{

        @Override
        protected String doInBackground(URL... urls) {
            URL url = null;
            try {
                url = urls[0];
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }



            try{
                InputStream in = url.openConnection().getInputStream();
                StringBuffer sb = new StringBuffer();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));


                String line;
                while ((line = reader.readLine()) != null) {
                    sb.append(line + "\n");
                }
                return sb.toString();

            } catch (IOException e) {
                e.printStackTrace();
            }


            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            super.onPostExecute(s);
            try {
                Log.i("check",s);
                parseJSon(s);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
