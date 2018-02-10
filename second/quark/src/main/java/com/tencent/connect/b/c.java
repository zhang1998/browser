package com.tencent.connect.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.tauth.b;

/* compiled from: ProGuard */
final class c implements OnCancelListener {
    final /* synthetic */ e a;
    private final /* synthetic */ b b;
    private final /* synthetic */ Object c;

    c(e eVar, b bVar, Object obj) {
        this.a = eVar;
        this.b = bVar;
        this.c = obj;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (this.b != null) {
            this.b.a(this.c);
        }
    }
}
