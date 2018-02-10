package com.ucpro.feature.a;

import android.view.View;
import com.uc.webview.export.internal.setup.UCAsyncTask;
import com.ucpro.feature.video.player.a.b;
import com.ucpro.feature.video.player.a.g;

/* compiled from: ProGuard */
final class t implements g {
    final /* synthetic */ j a;

    t(j jVar) {
        this.a = jVar;
    }

    public final boolean a(int i, b bVar, b bVar2) {
        j a;
        switch (i) {
            case 10009:
                a = j.a();
                if (a.a != null) {
                    a.a.a();
                    break;
                }
                break;
            case 10010:
                a = j.a();
                if (a.a != null) {
                    try {
                        a.a.b();
                        break;
                    } catch (Exception e) {
                        break;
                    }
                }
                break;
            case 10011:
                j.a().b();
                break;
            case UCAsyncTask.getPriority /*10013*/:
                a = j.a();
                if (a.a != null) {
                    a.a.d();
                    break;
                }
                break;
            case UCAsyncTask.getTaskCount /*10014*/:
                a = j.a();
                if (a.a != null) {
                    try {
                        a.a.e();
                        break;
                    } catch (Exception e2) {
                        break;
                    }
                }
                break;
            case UCAsyncTask.isPaused /*10018*/:
                View view;
                j a2 = j.a();
                a = this.a;
                if (a.b != null) {
                    view = (View) a.b.get();
                } else {
                    view = null;
                }
                if (a2.a != null) {
                    a2.a.a(view);
                    break;
                }
                break;
        }
        return false;
    }
}
