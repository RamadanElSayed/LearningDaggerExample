package com.android.learningdaggerexample;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.Subcomponent;

@ActivityScope
@Subcomponent (modules = CoffeModule.class)
public interface CofeeComponent {

    // طالما حاجة ليه constructor وعملت انجكت ليها وهتتعامل الfiled يبقي خلاص مش محتاج هنا
     Coffee getCoffee();
    void injectMainActivity(MainActivity mainActivity);

    // use custom builder
    @Subcomponent.Builder
    interface Builder {

        // بتقوله في dependencies هنا
        // ظهرت هنا مشكلة بسبب انك بتعمل provide لاتنين int  لازم تفرق بينهم وهنا ظهر دور ال qualifiers
//        @BindsInstance
//        Builder sugar(@Named("sugar") int sugar);
//
//        @BindsInstance
//        Builder milk(@Named("milk") int milk);

        // use custom qualifiers
        @BindsInstance
        Builder sugar(@Sugar int sugar);

        @BindsInstance
        Builder milk(@Milk int milk);

        CofeeComponent build();
    }
}
