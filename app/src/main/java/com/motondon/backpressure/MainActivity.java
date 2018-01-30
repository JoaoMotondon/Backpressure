package com.motondon.backpressure;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.category_list) RecyclerView exampleCategoriesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.app_name);
        }

        exampleCategoriesList.setHasFixedSize(true);
        exampleCategoriesList.setLayoutManager(new LinearLayoutManager(this));
        exampleCategoriesList.setAdapter(new CategoryItemsAdapter(this, getBackpressureCategoryExamples()));
    }


    private List<CategoryItem> getBackpressureCategoryExamples() {
        List<CategoryItem> backpressureExample = new ArrayList<>();

        backpressureExample.add(new CategoryItem(
                BackpressureBasicExampleActivity.class,
                "Backpressure - MissingBackpressureException and throttle()",
                "Show what happens when observable produces items much faster than they are consumed by the observers. It also shows how to deal with backpressure by using throttleLast() operator"));

        backpressureExample.add(new CategoryItem(
                BackpressureSpecificOperatorsExampleActivity.class,
                "Backpressure - Specifc Operators",
                "Show how to use  backpressureBuffer() and backpressureDrop() operators"));

        backpressureExample.add(new CategoryItem(
                BackpressureReactivePullExampleActivity.class,
                "Backpressure - Pull Request",
                "Show how to deal with backpressure by using Subscriber::request() method."));

        backpressureExample.add(new CategoryItem(
                BackpressureManualRequestExampleActivity.class,
                "Backpressure - Manual Request",
                "Show how to use request() operator in order to request manually for emitted items"));

        return backpressureExample;
    }
}
