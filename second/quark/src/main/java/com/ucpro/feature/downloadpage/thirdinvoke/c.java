package com.ucpro.feature.downloadpage.thirdinvoke;

import android.content.Context;
import com.ucpro.feature.downloadpage.a.d;
import com.ucpro.feature.downloadpage.a.l;
import com.ucpro.ui.g.h;

/* compiled from: ProGuard */
final class c extends l {
    final /* synthetic */ QuarkDownloadForThirdParty b;

    c(QuarkDownloadForThirdParty quarkDownloadForThirdParty, Context context, d dVar, boolean z, int i) {
        this.b = quarkDownloadForThirdParty;
        super(context, dVar, z, i);
    }

    public final boolean a(h hVar, int i, Object obj) {
        boolean a = super.a(hVar, i, obj);
        if (!a) {
            this.b.finish();
        }
        return a;
    }
}
