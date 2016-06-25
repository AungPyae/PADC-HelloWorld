package xyz.aungpyaephyo.padc_helloworld;

import android.app.Application;
import android.content.Context;

/**
 * Created by aung on 6/11/16.
 */
public class HelloWorldApp extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        context = null;
    }

    public static Context getContext() {
        return context;
    }
}
