package com.ucpro.services.b;

import com.uc.webview.browser.interfaces.IPermissionManagerInterface.IPermissionCallBack;

/* compiled from: ProGuard */
public final class b implements IPermissionCallBack, d {
    a a;
    IPermissionCallBack b;

    public b(a aVar) {
        this.a = aVar;
    }

    static boolean[] a(String[] strArr, boolean z) {
        int i = 0;
        if (strArr == null) {
            return new boolean[0];
        }
        boolean[] zArr = new boolean[strArr.length];
        while (i < zArr.length) {
            zArr[i] = z;
            i++;
        }
        return zArr;
    }

    public final a a() {
        return this.a;
    }

    public final void onRequestPermissionsResult(String[] strArr, boolean[] zArr) {
        if (this.b != null) {
            this.b.onRequestPermissionsResult(strArr, zArr);
        }
    }
}
