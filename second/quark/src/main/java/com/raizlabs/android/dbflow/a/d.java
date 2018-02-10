package com.raizlabs.android.dbflow.a;

import android.net.Uri;
import android.net.Uri.Builder;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.raizlabs.android.dbflow.a.b.h;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.structure.database.a;
import com.raizlabs.android.dbflow.structure.database.b;
import com.raizlabs.android.dbflow.structure.e;

/* compiled from: ProGuard */
public final class d {
    private static final char[] a = "0123456789ABCDEF".toCharArray();

    public static Uri a(@NonNull Class<?> cls, @Nullable e eVar, @Nullable Iterable<com.raizlabs.android.dbflow.a.b.d> iterable) {
        Builder authority = new Builder().scheme("dbflow").authority(FlowManager.a((Class) cls));
        if (eVar != null) {
            authority.fragment(eVar.name());
        }
        if (iterable != null) {
            for (com.raizlabs.android.dbflow.a.b.d dVar : iterable) {
                authority.appendQueryParameter(Uri.encode(dVar.c()), Uri.encode(String.valueOf(dVar.b())));
            }
        }
        return authority.build();
    }

    public static Uri a(@NonNull Class<?> cls, @NonNull e eVar, @Nullable com.raizlabs.android.dbflow.a.b.d[] dVarArr) {
        Builder authority = new Builder().scheme("dbflow").authority(FlowManager.a((Class) cls));
        if (eVar != null) {
            authority.fragment(eVar.name());
        }
        if (dVarArr != null && dVarArr.length > 0) {
            for (com.raizlabs.android.dbflow.a.b.d dVar : dVarArr) {
                if (dVar != null) {
                    authority.appendQueryParameter(Uri.encode(dVar.c()), Uri.encode(String.valueOf(dVar.b())));
                }
            }
        }
        return authority.build();
    }

    public static long a(@NonNull b bVar, @NonNull String str) {
        a b = bVar.b(str);
        try {
            long c = b.c();
            return c;
        } finally {
            b.b();
        }
    }

    @NonNull
    public static String a(byte[] bArr) {
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            cArr[i * 2] = a[i2 >>> 4];
            cArr[(i * 2) + 1] = a[i2 & 15];
        }
        return new String(cArr);
    }

    public static Uri a(@NonNull Class<?> cls, @NonNull e eVar) {
        String str = null;
        if (com.raizlabs.android.dbflow.a.a(null)) {
            str = com.raizlabs.android.dbflow.a.b.b.a(new h(null).a()).c(null);
        }
        return a((Class) cls, eVar, new com.raizlabs.android.dbflow.a.b.d[]{str});
    }
}
