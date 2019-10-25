package com.example.borgerkong;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.content.Intent;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements FoodRecyclerViewAdapter.OnDataListener {

    private static final String TAG = "MainActivity";
    ArrayList<Food> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        data.add(new Food("Big King",  "$6.50", "Our BIG KING Sandwich features two savory flame-grilled beef patties, topped with melted American cheese, fresh cut iceberg lettuce, crisp onions, crunchy pickles, and featuring a sweet thousand island style dressing, all on a warm, toasted, sesame seed bun."));
        data.add(new Food("BK Veggie",  "$6.50", "Not just for vegetarians, our great tasting BK VEGGIE is a flame-grilled soya burger topped with fresh lettuce, juicy tomatoes, slices of white onions and ketchup, all on a toasted sesame seed bun."));
        data.add(new Food("Chicken Fries","$4.20", "Made with white meat chicken, our Chicken Fries are coated in a light crispy breading seasoned with savory spices and herbs. Chicken Fries are shaped like fries and are perfect to dip in any of our delicious dipping sauces."));
        data.add(new Food("Chicken Jr.",  "$6.50", "Our Classic Chicken Jr. is loaded with chopped lettuce, creamy mayonnaise, and served to you freshly prepared on a perfectly toasted sesame seed bun."));
        data.add(new Food("Chicken Royale",  "$6.50", "Our New Chicken Royale is made with 100% white meat chicken filet, seasoned and breaded and carefully layered with fresh lettuce, ripe tomato, and creamy mayonnaise on a potato bun."));
        data.add(new Food("Double Supreme",  "$7.40", "The massive burger, which is now available nationwide, is topped with melted American cheese, sliced onions, zesty pickles, crisp lettuce, and Borger Kong's special sauce on a toasted sesame bun."));
        data.add(new Food("Fish Royale",  "$6.50", "Our crowning glory the Fish Royale is everything a great sandwich should be. Tasty fish wrapped in a special crisp coating, topped with iceberg lettuce, creamy mayonnaise and crowned with a toasted sesame seed bun."));
        data.add(new Food("Long Fish Sandwich",  "$6.99", "Our premium Long Fish Sandwich is 100% White Alaskan Pollock, breaded with crispy panko breading and topped with sweet tartar sauce, tangy pickles, all on top of a toasted brioche-style bun."));
        data.add(new Food("Onion Rings",  "$5.50", "Served hot and crispy, our golden Onion Rings are the perfect treat for plunging into one of our bold or classic sauces."));
        data.add(new Food("Tender Grill",  "$6.50", "A deliciously juicy premium chicken thigh patty that's grilled to perfection, topped with a tomato slice, freshly shredded lettuce and creamy mayo to bring out all the flavours, then served on a soft sesame seed bun."));
        data.add(new Food("Whopper",  "$6.50", "Our WHOPPER  is a ¼ lb* of savory flame-grilled beef topped with juicy tomatoes, fresh lettuce, creamy mayonnaise, ketchup, crunchy pickles, and sliced white onions on a soft sesame seed bun."));
        data.add(new Food("Chocolate Milkshake",  "$4.40", "Borger Kong’s Chocolate Milkshake - sweet & cool in every sip."));
        data.add(new Food("Coca Cola",  "$3.50", "Perfect with any meal, enjoy the genuine taste of Coca Cola."));
        data.add(new Food("Frozen Raspberry",  "$3.99", "Cool down with a Frozen Raspberry any time of the year."));
        data.add(new Food("Lemon Lime & Bitters",  "$4.50", "Made from freshly squeezed lime juice, Lemon, Lime & Bitters is a mixed drink made with (clear) lemonade, fresh lime, and Angostura bitters. "));


//        data.add(new Food("BK Veggie"));
//        data.add(new Food("Chicken Fries"));
//        data.add(new Food("Chicken Jr."));
//        data.add(new Food("Chicken Royale"));
//        data.add(new Food("Double Supreme"));
//        data.add(new Food("Fish Royale"));
//        data.add(new Food("Long Fish Sandwich"));
//        data.add(new Food("Onion Rings"));
//        data.add(new Food("Tender Grill"));
//        data.add(new Food("Whopper"));
//        data.add(new Food("Chocolate Milkshake"));
//        data.add(new Food("Coca Cola"));
//        data.add(new Food("Frozen Raspberry"));
//        data.add(new Food("Lemon Lime & Bitters"));


        RecyclerView recyclerView = findViewById(R.id.rv_main);

        FoodRecyclerViewAdapter adapter = new FoodRecyclerViewAdapter();
        adapter.setData(data, this);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);


    }

    @Override
    public void onDataClick(int position) {
        Log.d(TAG, "onFoodClick: clicked");
        //data.get(position);

        Intent intent = new Intent(this, BigKing.class);
        intent.putExtra("selected_item", data.get(position));
        startActivity(intent);

    }

    public void viewOrder(View view){
        Intent intent = new Intent (this, ViewOrder.class);
        startActivity(intent);
    }








}
