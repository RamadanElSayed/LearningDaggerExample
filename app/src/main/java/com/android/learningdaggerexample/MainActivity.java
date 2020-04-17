package com.android.learningdaggerexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    @Inject
    Coffee coffee,coffee2;
    @Inject
    Farm farm;
    private static final String TAG = "MainActivity";
    // dagger run constructor injection first then filed then method calling direct
    // problem of field injection is still using coupling
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //manual dependency injection (inversion of control)  and decoupling but still boilerplate code
//        Farm farm=new Farm();
//        River river=new River();
//        Coffee coffee=new Coffee(farm,river);


        // how to convert md to auto di..

       // CofeeComponent cofeeComponent = DaggerCofeeComponent.create();

        // if you want to pass any attributes to module use this

        // use if you want to dagger builder
        //CofeeComponent cofeeComponent = DaggerCofeeComponent.builder().coffeModule(new CoffeModule(2)).build();

        AppComponent appComponent = ((MYAPP) getApplication()).getAppComponent();
        CofeeComponent cofeeComponent=appComponent.getCoffeComponent().sugar(2).milk(3)
                                       .build();
         cofeeComponent.injectMainActivity(this);
       // cofeeComponent.getCoffee();
        Log.v(TAG,farm.getFarm());
        Log.v(TAG,coffee.getCoffeCup());


        // i want to make single instance from river as retrofit and instance from coffee but not the same when re
        // restart activity


        Log.v(TAG,"coffee1"+coffee+"\n"+"coffee2"+coffee2+"\n"+"river for coffee1"+coffee.river
                +"\n"+"river for coffee2"+coffee2.river);


    }
}
