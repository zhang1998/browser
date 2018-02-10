package com.ucpro.feature.video.cache.db.a;

import android.support.annotation.NonNull;
import com.ucpro.feature.video.cache.db.bean.b;
import java.util.Date;

/* compiled from: ProGuard */
public final class a {
    public static b a(@NonNull String str, @NonNull String str2, @NonNull String str3, String str4, long j) {
        b bVar = new b();
        bVar.e = 1;
        bVar.b = str;
        bVar.c = str2;
        bVar.h = str3;
        bVar.a = Long.valueOf(j);
        bVar.d = str4;
        bVar.s = new Date();
        bVar.f = "init";
        return bVar;
    }
}
