package com.loc;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: ProGuard */
final class c implements OnClickListener {
    final /* synthetic */ j a;

    c(j jVar) {
        this.a = jVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.a.g();
        dialogInterface.cancel();
    }
}
