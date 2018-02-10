package com.ucpro.feature.webwindow;

import android.os.Bundle;
import com.uc.quark.n;
import com.uc.quark.x;
import com.ucweb.common.util.l.d;
import java.io.File;

/* compiled from: ProGuard */
final class b implements Runnable {
    final /* synthetic */ Bundle a;
    final /* synthetic */ g b;

    b(g gVar, Bundle bundle) {
        this.b = gVar;
        this.a = bundle;
    }

    public final void run() {
        String string = this.a.getString("saved_file_name");
        n nVar = new n();
        nVar.a = this.b.b.a;
        nVar.d = string;
        nVar.e = this.b.a + File.separator + string;
        nVar.c = d.a(".jpg");
        x.a().a(nVar.a(), new File(this.b.a + File.separator + string).length());
    }
}
