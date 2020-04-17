package com.android.learningdaggerexample;
import android.util.Log;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

@ActivityScope
public class Coffee {
    // filed injection used if we want to inject filed and in activity or fragment where
    // we can not get direct constructor
    @Inject
    Farm farm;

    River river;
    int sugar;
    int milk;
    private static final String TAG = "Coffee";

    //Constructor  injection
//    @Inject
//    public Coffee(Farm farm, River river) {
//        this.farm = farm;
//        this.river = river;
//    }


//    @Inject
//    public Coffee(River river, @Named("sugar") int sugar, @Named("milk") int milk) {
//     this.river=river;
//     this.sugar=sugar;
//     this.milk=milk;
//    }

    // use custom qualifiers

    @Inject
    public Coffee(River river, @Sugar int sugar, @Milk int milk) {
        this.river=river;
        this.sugar=sugar;
        this.milk=milk;
    }

    @Inject
    public void runElectricity()
    {
        Log.d(TAG, "runElectricity: ");
    }

    public String getCoffeCup() {
        return farm.getFarm() + river.getRiver()+"sugar"+" "+sugar+"milk"+milk;
    }


}
