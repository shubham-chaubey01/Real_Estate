package com.example.real_estate.Activity;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ArrayAdapter;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.real_estate.Adapter.ItemsAdapter;
import com.example.real_estate.Domain.PropertyDomain;
import com.example.real_estate.R;
import com.example.real_estate.databinding.ActivityMain2Binding;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMain2Binding binding;
    private RecyclerView.Adapter adapterRecommended,adapterNearby;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMain2Binding.inflate(getLayoutInflater());


        setContentView(binding.getRoot());


        initLocation();
        initList();

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);



    }

    private void initList() {
        ArrayList<PropertyDomain> items=new ArrayList<>();
       items.add(new PropertyDomain("Apartment","Royal Apartment", "LosAngles LA","house_1",1500,2,3,350,true,4.5, "This 2 bed/1 bath home boasts an enormous, open-living\n" +
               "                plan, accented by striking architectural features and\n" +
               "                 high-end finishes. Feel inspired by open sight lines that\n" +
               "                 embance the outdoors, crowned by stunning coffered ceilings."));
        items.add(new PropertyDomain("House","House with great View", "NewYork NY","house_2",800,1,2,400,false,4.9, "This 2 bed/1 bath home boasts an enormous, open-living\n" +
                "                plan, accented by striking architectural features and\n" +
                "                 high-end finishes. Feel inspired by open sight lines that\n" +
                "                 embance the outdoors, crowned by stunning coffered ceilings."));
        items.add(new PropertyDomain("Villa","Royal Villa", "LosAngles LA","house_3",999,2,1,500,true,4.7, "This 2 bed/1 bath home boasts an enormous, open-living\n" +
                "                plan, accented by striking architectural features and\n" +
                "                 high-end finishes. Feel inspired by open sight lines that\n" +
                "                 embance the outdoors, crowned by stunning coffered ceilings."));
        items.add(new PropertyDomain("House","Beauty house", "NewYork NY","house_4",1799,3,2,1100,true,4.4, "This 2 bed/1 bath home boasts an enormous, open-living\n" +
                "                plan, accented by striking architectural features and\n" +
                "              high-end finishes. Feel inspired by open sight lines that\n" +
                "                 embance the outdoors, crowned by stunning coffered ceilings."));

        binding.recommendedView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        binding.recommendedView.setAdapter(new ItemsAdapter(items));

        ArrayList<PropertyDomain> itemsNear=new ArrayList<>();
        itemsNear.add(new PropertyDomain("House","Beauty house", "NewYork NY","house_4",1799,3,2,1100,true,4.4, "This 2 bed/1 bath home boasts an enormous, open-living\n" +
                "                plan, accented by striking architectural features and\n" +
                "                 high-end finishes. Feel inspired by open sight lines that\n" +
                "                 embance the outdoors, crowned by stunning coffered ceilings."));
        itemsNear.add(new PropertyDomain("Villa","Royal Villa", "LosAngles LA","house_3",999,2,1,500,true,4.7, "This 2 bed/1 bath home boasts an enormous, open-living\n" +
                "                plan, accented by striking architectural features and\n" +
                "                 high-end finishes. Feel inspired by open sight lines that\n" +
                "                 embance the outdoors, crowned by stunning coffered ceilings."));
        itemsNear.add(new PropertyDomain("House","House with great View", "NewYork NY","house_2",800,1,2,400,false,4.9, "This 2 bed/1 bath home boasts an enormous, open-living\n" +
                "                plan, accented by striking architectural features and\n" +
                "                 high-end finishes. Feel inspired by open sight lines that\n" +
                "                 embance the outdoors, crowned by stunning coffered ceilings."));
        itemsNear.add(new PropertyDomain("Apartment","Royal Apartment", "LosAngles LA","house_1",1500,2,3,350,true,4.5, "This 2 bed/1 bath home boasts an enormous, open-living\n" +
                "                plan, accented by striking architectural features and\n" +
                "                 high-end finishes. Feel inspired by open sight lines that\n" +
                "                 embance the outdoors, crowned by stunning coffered ceilings."));

        binding.nearView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        binding.nearView.setAdapter(new ItemsAdapter(itemsNear));
    }

    private void initLocation() {
        String[] items=new String[]{"LosAngles,USA","NewYork,USA"};

        ArrayAdapter<String>adapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        binding.locationSpin.setAdapter(adapter);
    }
}