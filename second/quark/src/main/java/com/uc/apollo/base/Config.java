package com.uc.apollo.base;

import android.app.Activity;
import android.content.Context;
import com.uc.apollo.android.SystemUtils;
import com.uc.apollo.annotation.KeepForRuntime;
import com.uc.apollo.util.f;
import java.lang.ref.WeakReference;

@KeepForRuntime
/* compiled from: ProGuard */
public class Config {
    private static Context sApplicationContext;
    private static WeakReference<Context> sContext = new WeakReference(null);

    public static void setContext(Context context) {
        sContext = new WeakReference(context);
        if (context != null) {
            sApplicationContext = context.getApplicationContext();
            f.g();
            return;
        }
        sApplicationContext = null;
    }

    public static Context getContext() {
        Context context = (Context) sContext.get();
        if (context == null) {
            return sApplicationContext;
        }
        return context;
    }

    public static Activity getActivity() {
        return SystemUtils.a(getContext());
    }
}
