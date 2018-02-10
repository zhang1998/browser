package com.ucpro.feature.downloadpage.e;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.uc.quark.s;

/* compiled from: ProGuard */
final class c implements OnCancelListener {
    final /* synthetic */ s a;
    final /* synthetic */ o b;

    c(o oVar, s sVar) {
        this.b = oVar;
        this.a = sVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.a.m();
    }
}
