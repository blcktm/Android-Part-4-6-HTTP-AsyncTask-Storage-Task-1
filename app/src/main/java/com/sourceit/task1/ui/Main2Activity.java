package com.sourceit.task1.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sourceit.task1.R;
import com.sourceit.task1.utils.L;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    private TextView tv_name;
    private TextView tv_region;
    private TextView tv_subregion;
    private TextView tv_capital;
    private TextView tv_population;
    private TextView tv_area;
    private LinearLayout languagesList;
    private ImageView imageFlag;
    private View progressBar;

    private String name;
    private String region;
    private String subregion;
    private String capital;
    private String population;
    private String area;
    private ArrayList<String> languages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        L.d("start activity");

        init();

        name = getString(R.string.name_string);
        region = getString(R.string.region_string);
        subregion = getString(R.string.subregion_string);
        capital = getString(R.string.capital_string);
        population = getString(R.string.population_string);
        area = getString(R.string.area_string);

        Intent intent = getIntent();
        ObjectType objectType = intent.getParcelableExtra(MainActivity.info);
        tv_name.setText(name + objectType.getName());
        tv_region.setText(region + objectType.getRegion());
        tv_subregion.setText(subregion + objectType.getSubregion());
        tv_capital.setText(capital + objectType.getCapital());
        tv_population.setText(population + objectType.getPopulation());
        tv_area.setText(area + objectType.getArea());

        languages = objectType.getLanguages();
        for (int i = 0; i < languages.size(); i++) {
            TextView lang = new TextView(this);
            lang.setText(languages.get(i));
            languagesList.addView(lang);
        }

        L.d("image: " + String.format("%s.png", objectType.getName()));
        File img = new File(MainActivity.folder, String.format("%s.png", objectType.getName().replace(" ", "-")));
        Picasso.with(this).load(img).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(imageFlag);
        progressBar.setVisibility(View.GONE);
    }

    private void init() {
        imageFlag = (ImageView) findViewById(R.id.flag);
        progressBar = (View) findViewById(R.id.progressBar);
        languagesList = (LinearLayout) findViewById(R.id.languages_list);
        tv_name = (TextView) findViewById(R.id.info_name);
        tv_region = (TextView) findViewById(R.id.info_region);
        tv_subregion = (TextView) findViewById(R.id.info_subregion);
        tv_capital = (TextView) findViewById(R.id.info_capital);
        tv_population = (TextView) findViewById(R.id.info_population);
        tv_area = (TextView) findViewById(R.id.info_area);
    }
}
