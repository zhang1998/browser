package com.ucpro.services.b;

import android.content.Context;
import android.util.SparseArray;
import com.uc.webview.browser.interfaces.IPermissionManagerInterface;
import com.uc.webview.browser.interfaces.IPermissionManagerInterface.IPermissionCallBack;
import java.util.List;

/* compiled from: ProGuard */
public final class e implements IPermissionManagerInterface {
    private static int c = 0;
    SparseArray<d> a;
    SparseArray<Long> b;

    public static synchronized int a() {
        int i;
        synchronized (e.class) {
            i = c;
            c = i + 1;
            i %= 65535;
        }
        return i;
    }

    private e() {
        this.a = new SparseArray();
        this.b = new SparseArray();
    }

    public static e b() {
        return f.a;
    }

    final void a(int i) {
        d dVar = (d) this.a.get(i);
        if (dVar == null) {
            return;
        }
        if (dVar instanceof g) {
            List<Integer> list = ((g) dVar).a;
            for (Integer intValue : list) {
                this.a.remove(intValue.intValue());
            }
            list.clear();
            return;
        }
        this.a.remove(i);
    }

    public final void a(int i, d dVar) {
        this.a.put(i, dVar);
    }

    public final boolean onCheckSelfPermission(Context context, String str) {
        return a.a(context, str) == 0;
    }

    public final void onPermissionsRequest(Context context, String[] strArr, IPermissionCallBack iPermissionCallBack) {
        int a = a();
        b bVar = new b(new a(context, a, strArr));
        bVar.b = iPermissionCallBack;
        a(a, bVar);
        if (bVar.a == null) {
            return;
        }
        String[] strArr2;
        if (bVar.a.a()) {
            strArr2 = bVar.a.a;
            bVar.onRequestPermissionsResult(strArr2, b.a(strArr2, true));
        } else if (bVar.a.c()) {
            strArr2 = bVar.a.a;
            bVar.onRequestPermissionsResult(strArr2, b.a(strArr2, false));
        } else {
            bVar.a.d();
        }
    }
}
