package com.ucpro.feature.downloadpage.thirdinvoke;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

/* compiled from: ProGuard */
final class b implements OnDismissListener {
    final /* synthetic */ QuarkDownloadForThirdParty a;

    b(QuarkDownloadForThirdParty quarkDownloadForThirdParty) {
        this.a = quarkDownloadForThirdParty;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        this.a.finish();
    }
}
