package com.ucpro.feature.downloadpage.dirselect;

import com.quark.browser.R;
import com.ucpro.feature.downloadpage.dirselect.a.b;
import com.ucpro.feature.downloadpage.dirselect.a.d;
import com.ucpro.ui.c.a;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

/* compiled from: ProGuard */
final class e implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ m b;

    e(m mVar, String str) {
        this.b = mVar;
        this.a = str;
    }

    public final void run() {
        int i = 0;
        m mVar = this.b;
        String str = this.a;
        if (mVar.a == null) {
            mVar.a = new ArrayList();
        } else {
            mVar.a.clear();
        }
        mVar.c += str;
        str = mVar.c.replace(mVar.b(0), a.d((int) R.string.download_path_inner_desc));
        mVar.b.clear();
        String[] split = str.trim().split("/");
        int length = split.length - 1;
        for (int i2 = 0; i2 < split.length; i2++) {
            d dVar = new d();
            dVar.b = split[i2];
            dVar.a = b.a;
            mVar.b.add(dVar);
            if (i2 < length) {
                dVar = new d();
                dVar.b = " > ";
                dVar.a = b.b;
                mVar.b.add(dVar);
            }
        }
        File[] listFiles = new File(mVar.c).listFiles(new q());
        if (listFiles != null) {
            int length2 = listFiles.length;
            while (i < length2) {
                File file = listFiles[i];
                if (!file.getName().startsWith(".")) {
                    mVar.a.add(file.getName());
                }
                i++;
            }
            Collections.sort(mVar.a, new i(mVar));
            return;
        }
        mVar.a.clear();
    }
}
