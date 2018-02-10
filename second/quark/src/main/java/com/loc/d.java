package com.loc;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: ProGuard */
final class d implements OnClickListener {
    final /* synthetic */ j a;

    d(j jVar) {
        this.a = jVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
