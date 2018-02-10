package com.bumptech.glide.d;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public final class e {
    private final Context a;

    public e(Context context) {
        this.a = context;
    }

    public final List<c> a() {
        Log.isLoggable("ManifestParser", 3);
        List<c> arrayList = new ArrayList();
        try {
            ApplicationInfo applicationInfo = this.a.getPackageManager().getApplicationInfo(this.a.getPackageName(), 128);
            if (applicationInfo.metaData == null) {
                Log.isLoggable("ManifestParser", 3);
                return arrayList;
            }
            if (Log.isLoggable("ManifestParser", 2)) {
                new StringBuilder("Got app info metadata: ").append(applicationInfo.metaData);
            }
            for (String str : applicationInfo.metaData.keySet()) {
                if ("GlideModule".equals(applicationInfo.metaData.get(str))) {
                    arrayList.add(a(str));
                    Log.isLoggable("ManifestParser", 3);
                }
            }
            Log.isLoggable("ManifestParser", 3);
            return arrayList;
        } catch (Throwable e) {
            throw new RuntimeException("Unable to find metadata to parse GlideModules", e);
        }
    }

    private static c a(String str) {
        Object newInstance;
        try {
            try {
                newInstance = Class.forName(str).newInstance();
                if (newInstance instanceof c) {
                    return (c) newInstance;
                }
                throw new RuntimeException("Expected instanceof GlideModule, but found: " + newInstance);
            } catch (Throwable e) {
                throw new RuntimeException("Unable to instantiate GlideModule implementation for " + newInstance, e);
            } catch (Throwable e2) {
                throw new RuntimeException("Unable to instantiate GlideModule implementation for " + newInstance, e2);
            }
        } catch (Throwable e3) {
            throw new IllegalArgumentException("Unable to find GlideModule implementation", e3);
        }
    }
}
