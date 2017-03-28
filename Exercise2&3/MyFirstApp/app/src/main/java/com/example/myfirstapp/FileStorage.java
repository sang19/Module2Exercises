package com.example.myfirstapp;


import android.content.Context;
import android.content.SharedPreferences;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileStorage {

    FileOutputStream fos;
    DataOutputStream dos;

    Context context;

    private final static String storage = "storage.json";

    private SharedPreferences settings;

    public FileStorage(Context context){
        this.context = context;
        this.settings = context.getSharedPreferences("prefs", 0);
    }

    public List<String> getRestaurantList() {
        String[] restaurants = context.getResources().getStringArray(R.array.top25_restaurants);
        return new ArrayList<String>(Arrays.asList(restaurants));
    }


    public void setUp() {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput(storage, Context.MODE_PRIVATE));
            write(outputStreamWriter, makeRoot().toString());
        } catch (FileNotFoundException e) {}
    }


    private JSONObject makeRoot() {
        JSONObject root =  new JSONObject();
        List<String> restaurants = getRestaurantList();
        try{
            for(int i = 0; i < restaurants.size(); i++){
                root.put(restaurants.get(i), new JSONArray());
            }
        } catch (JSONException e) {}

        return root;
    }

    public void writeToStorage(String restaurantname,
                               double totalAmount,
                               double totaltip,
                               int split_bill,
                               int rating,
                               String date){

        JSONObject element = create(restaurantname, totalAmount, totaltip, split_bill, rating, date);

        String jsonRoot = readFile();

        try {
            write(new OutputStreamWriter(context.openFileOutput(storage, Context.MODE_PRIVATE)), add_to_root(element, jsonRoot, restaurantname));
        } catch (FileNotFoundException e) {}

    }

    private JSONObject create(String restaurantname, double totalAmount,
                              double totaltip, int split_bill, int rating, String date) {
        JSONObject element = new JSONObject();
        try {
            element.put("total", totalAmount);
            element.put("tip", totaltip);
            element.put("split_bill", split_bill);
            element.put("rating", rating);
            element.put("date", date);
        } catch (JSONException e) {}
        return element;

    }


    private String readFile(){
        InputStreamReader isr;
        try{
            isr = new InputStreamReader(context.openFileInput(storage));
            return read(isr);
        } catch (FileNotFoundException e){

        }

        return "";
    }

    private String read(InputStreamReader isr){
        assert(isr != null);

        String root = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(isr);
            String receiveString = "";
            StringBuilder stringBuilder  = new StringBuilder();

            while((receiveString = bufferedReader.readLine()) != null){
                stringBuilder.append(receiveString);
            }
            isr.close();
            root = stringBuilder.toString();
        }catch (IOException e) {}

        return root;
    }

    private String add_to_root(JSONObject element, String root, String location) {
        assert(element != null);
        try {
            JSONObject jsonRootObject;
            JSONArray jsonArray;
            // If root object exists
            if (root != "") {
                // Make a JSON Object from root String
                jsonRootObject = new JSONObject(root);
                // Get the JSON Array containing "Foods"
                jsonArray = jsonRootObject.optJSONArray(location);
                if (jsonArray != null) {
                    // Append the new element
                    jsonArray.put(element);
                }
                else {
                    jsonArray = new JSONArray();
                    // Put the new element into the array
                    jsonArray.put(element);
                    // Add the JSON Array to JSON Root Object
                    jsonRootObject.put(location, jsonArray);
                }
            }
            // If root does not exist
            else {
                // Make a new JSON Root Object
                jsonRootObject = new JSONObject();
                // Make a new JSON Array
                jsonArray = new JSONArray();
                // Put the new element into the array
                jsonArray.put(element);
                // Add the JSON Array to JSON Root Object
                jsonRootObject.put(location, jsonArray);
            }

            return jsonRootObject.toString();

        } catch (JSONException e) {}

        return null;
    }

    private void write(OutputStreamWriter osw, String word) {
        try {
            osw.write(word);
            osw.close();
        } catch (IOException e){}
    }

    public JSONArray getArray(String restaurant) {
        String root = readFile();
        return extractArray(root, restaurant);
    }

    private JSONArray extractArray(String root, String attribute) {
        try {
            JSONObject  jsonRootObject = new JSONObject(root);

            // Get the food array from root object
            JSONArray jsonArray = jsonRootObject.optJSONArray(attribute);

            return jsonArray;
        } catch (JSONException e) {}

        return null;
    }



}
