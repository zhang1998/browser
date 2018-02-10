package com.uc.apollo.android;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: ProGuard */
final class a implements OnClickListener {
    final /* synthetic */ com.uc.apollo.android.GuideDialog.a a;

    a(com.uc.apollo.android.GuideDialog.a aVar) {
        this.a = aVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }
}
