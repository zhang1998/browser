package com.taobao.weex.b.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

/* compiled from: ProGuard */
public final class b implements OnCancelListener {
    final /* synthetic */ e a;

    public b(e eVar) {
        this.a = eVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.a.a(false, null);
    }
}
