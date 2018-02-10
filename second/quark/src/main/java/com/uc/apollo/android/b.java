package com.uc.apollo.android;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.uc.apollo.android.GuideDialog.a;

/* compiled from: ProGuard */
final class b implements OnClickListener {
    final /* synthetic */ Runnable a;
    final /* synthetic */ a b;

    b(a aVar, Runnable runnable) {
        this.b = aVar;
        this.a = runnable;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        if (this.a != null) {
            this.a.run();
        }
    }
}
