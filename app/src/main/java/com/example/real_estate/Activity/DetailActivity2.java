package com.example.real_estate.Activity;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.example.real_estate.Domain.PropertyDomain;
import com.example.real_estate.R;
import com.example.real_estate.databinding.ActivityDetail2Binding;

public class DetailActivity2 extends AppCompatActivity {
    ActivityDetail2Binding binding;
    private PropertyDomain object;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDetail2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        getBundles();
        setVariable();
    }

    private void setVariable() {
        binding.backBtn.setOnClickListener(v -> finish());
        int drawableResourceID=getResources().getIdentifier(object.getPickPath(),"drawable",DetailActivity2.this.getPackageName());
        Glide.with(DetailActivity2.this)
                .load(drawableResourceID)
                .into(binding.picDetail);

        binding.titleAddressTxt.setText(object.getTitle()+"in"+object.getAddress());
        binding.typeTxt.setText(object.getType());
        binding.descriptionTxt.setText(object.getDescription());
        binding.priceTxt.setText("$"+object.getPrice());
        binding.bedTxt.setText(object.getBed()+"Bedroom");
        binding.bathTxt.setText(object.getBath()+"Bathroom");
        binding.sizeTxt.setText(object.getSize()+"m2");


        if(object.isGarage()){
           binding.garageTxt.setText("Car Garage");

        }else
            binding.garageTxt.setText(" no-Car Garage");
    }

    private void getBundles() {
        object= (PropertyDomain) getIntent().getSerializableExtra("object");

    }
}