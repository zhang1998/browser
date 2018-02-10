package com.uc.base.wa.d;

import android.os.Looper;
import android.util.Log;
import com.uc.base.wa.config.b;
import com.uc.base.wa.f.e;
import com.uc.base.wa.n;
import com.uc.base.wa.u;
import java.io.File;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/* compiled from: ProGuard */
public final class l {
    private static long a = 0;
    private static int b = 0;
    private static Comparator<File> c = new a();
    private static final char[] d = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static HashMap<String, u> e = new HashMap();

    static /* synthetic */ int f() {
        int i = b;
        b = i + 1;
        return i;
    }

    public static void a(long j) {
        a = j;
    }

    public static long a() {
        return a;
    }

    public static void a(String str, u uVar) {
        if (e.containsKey(str)) {
            Log.e("gzm_WaCache", "only support one listener, category = " + str, new Throwable());
        } else {
            e.put(str, uVar);
        }
    }

    public static boolean a(boolean z, boolean z2, long j, boolean z3, String str, List<String> list, boolean z4, n<File> nVar) {
        return new k(z, z2, z3, j, nVar, File.class).a(str, (List) list, z4);
    }

    public static boolean a(byte[] bArr, n<Object> nVar, boolean z) {
        k kVar = new k(nVar);
        if (b.a()) {
            if (kVar.a == null) {
                return true;
            }
            kVar.a.a(-1, 0, 0.0f, null);
            return true;
        } else if (!kVar.k && !kVar.l) {
            if (kVar.a != null) {
                kVar.a.a(-1, 0, 0.0f, null);
            }
            return false;
        } else if (bArr == null) {
            if (kVar.a != null) {
                kVar.a.a(-1, 0, 0.0f, null);
            }
            return false;
        } else {
            Runnable jVar = new j(kVar, new d(kVar, bArr), z);
            if (Looper.myLooper() == e.a()) {
                jVar.run();
                return true;
            }
            e.a(3, jVar);
            return true;
        }
    }
}
