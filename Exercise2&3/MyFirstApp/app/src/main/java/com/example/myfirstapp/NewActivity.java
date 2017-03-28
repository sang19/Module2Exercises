package com.example.myfirstapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class NewActivity extends AppCompatActivity {

    FileStorage fileStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        List<Data> data = fill_with_data();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        Recycler_View_Adapter adapter = new Recycler_View_Adapter(data, getApplication());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
        itemAnimator.setAddDuration(1000);
        itemAnimator.setRemoveDuration(1000);
        recyclerView.setItemAnimator(itemAnimator);

        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

        recyclerView.addOnItemTouchListener(new CustomRVItemTouchListener(this, recyclerView, new RecyclerViewItemClickListener() {
            @Override
            public void onClick(View view, int position) {

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }

    public List<Data> fill_with_data() {

        fileStorage = new FileStorage(getApplicationContext());
        List<String> restaurantList = fileStorage.getRestaurantList();
        int[] imageIds = { R.drawable.annalena,
                R.drawable.fivesails,
                R.drawable.bluewatercafe,
                R.drawable.salmonnbannock,
                R.drawable.lecrocodile,
                R.drawable.trafalgarsbistro,
                R.drawable.absinthebistro, R.drawable.cafemedina, R.drawable.fable, R.drawable.oakwoodcanadianbistro, R.drawable.luporestaurant, R.drawable.meatandbread, R.drawable.miku, R.drawable.forage, R.drawable.cincin, R.drawable.trattoria, R.drawable.cactusclubcafe, R.drawable.joefortes, R.drawable.hawksworth, R.drawable.gothamsteakhouse, R.drawable.labattoir, R.drawable.italian, R.drawable.carderos, R.drawable.bacchus, R.drawable.teahouseinstanleypark};


        List<Data> data = new ArrayList<>();

        int i = 0;
        int length = restaurantList.size();
        for(i = 0; i < length; i++){
            data.add(new Data(restaurantList.get(i),  formatRestaurant(fileStorage.getArray(restaurantList.get(i))), imageIds[i]));
        }

        return data;
    }


    public String formatRestaurant(JSONArray array) {

        String result = "";
        int j = 0;

        if(array == null){
            return result;
        }

        for(j = 0; j < array.length(); j++){
            result = String.valueOf(j + 1) + ". ";
            try {
                JSONObject element = array.getJSONObject(j);
                Double totalAmount = element.optDouble("total");
                Double totaltip = element.optDouble("tip");
                int split_bill = element.getInt("split_bill");
                int rating = element.optInt("rating");
                String date = element.optString("date");

                result = result + "Date: " + date + "\n";
                result = result + "Total bill: $" + totalAmount + "\n";
                result = result + "Total tip: $" + totaltip + "\n";
                result = result + "Bill split amongst : " + split_bill + "\n";
                result = result + "Rating (out of 5) : " + rating + "\n";

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

        return result;

    }

}
