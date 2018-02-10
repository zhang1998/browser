package android.support.multidex;

import android.app.Application;
import android.content.Context;

/* compiled from: ProGuard */
public class MultiDexApplication extends Application {
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        b.a((Context) this);
    }
}
