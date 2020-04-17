package com.android.learningdaggerexample;
import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {


    // there is more than one method in component and you want to use custom scope
    // first method is dependence where if you want to use dependence in parent component
    // يعني لو انت عايز تستخدم اوجكت اللي هو dependence في البيرنت كمبوننت يبقي لازم تعملها provide  في الmodule
    // لو كانت مقفولة ذي retrofit  كدا وكمان تعملها اوبكت بينده عليها في الapp component
    // طبعا وتستخدملها @singleton
//    River provideRiver();
//    Farm  provideFarm();


    // في طريقة تانية اسمها subcomponent  ودي هنتعرف عليها لسة ...

    CofeeComponent.Builder getCoffeComponent();
}
