package com.bumptech.glide.b.c;

import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.b.m;
import java.io.File;

/* compiled from: ProGuard */
public final class bh<Data> implements aq<String, Data> {
    private final aq<Uri, Data> a;

    public final /* synthetic */ ap a(Object obj, int i, int i2, m mVar) {
        Object obj2;
        String str = (String) obj;
        if (TextUtils.isEmpty(str)) {
            obj2 = null;
        } else if (str.startsWith("/")) {
            obj2 = a(str);
        } else {
            obj2 = Uri.parse(str);
            if (obj2.getScheme() == null) {
                obj2 = a(str);
            }
        }
        if (obj2 == null) {
            return null;
        }
        return this.a.a(obj2, i, i2, mVar);
    }

    public bh(aq<Uri, Data> aqVar) {
        this.a = aqVar;
    }

    private static Uri a(String str) {
        return Uri.fromFile(new File(str));
    }
}
