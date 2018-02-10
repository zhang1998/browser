package com.bumptech.glide.b.c;

import android.content.res.Resources;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.util.Log;
import com.bumptech.glide.b.m;

/* compiled from: ProGuard */
public final class bd<Data> implements aq<Integer, Data> {
    private final aq<Uri, Data> a;
    private final Resources b;

    public final /* bridge */ /* synthetic */ ap a(Object obj, int i, int i2, m mVar) {
        Uri a = a((Integer) obj);
        return a == null ? null : this.a.a(a, i, i2, mVar);
    }

    public bd(Resources resources, aq<Uri, Data> aqVar) {
        this.b = resources;
        this.a = aqVar;
    }

    @Nullable
    private Uri a(Integer num) {
        try {
            return Uri.parse("android.resource://" + this.b.getResourcePackageName(num.intValue()) + '/' + this.b.getResourceTypeName(num.intValue()) + '/' + this.b.getResourceEntryName(num.intValue()));
        } catch (Throwable e) {
            if (Log.isLoggable("ResourceLoader", 5)) {
                Log.w("ResourceLoader", "Received invalid resource id: " + num, e);
            }
            return null;
        }
    }
}
