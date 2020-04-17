package com.android.learningdaggerexample;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Farm {
    @Inject
    public Farm() {
    }

    public String getFarm()
    {
        return "Farm";
    }
}
