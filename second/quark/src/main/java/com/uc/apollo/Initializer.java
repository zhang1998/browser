package com.uc.apollo;

import android.content.Context;
import com.UCMobile.Apollo.Apollo;
import com.uc.apollo.annotation.KeepForSdk;

@KeepForSdk
/* compiled from: ProGuard */
public class Initializer {
    private static boolean sInited;

    public static void init(Context context) {
        if (!sInited) {
            sInited = true;
            Settings.init(context);
        }
    }

    public static void init(Context context, boolean z) {
        if (!sInited) {
            sInited = true;
            Settings.init(context, z);
        }
    }

    public static boolean isApolloLibInitialized() {
        Context context = Settings.getContext();
        if (context == null) {
            return false;
        }
        return Apollo.isInitialized(context);
    }

    public static boolean isInitSoLoaded() {
        return Apollo.isInitSoLoaded();
    }
}
