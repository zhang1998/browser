package com.ucpro.feature.i;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;
import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;
import com.ucpro.base.c.b.o;
import com.ucpro.feature.i.a.h;
import com.ucpro.model.a.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
public final class k {
    public ArrayList<WeakReference<View>> a;
    int b;
    public d c;
    public int d;
    public o e;

    private k() {
        this.a = new ArrayList();
        this.b = 0;
        this.d = -1;
        this.e = new i(this);
        this.c = new d();
    }

    public final void a(Activity activity) {
        if ((a.a.a("setting_status_bar_type", 1) > 0 ? 1 : 0) != 0) {
            int a = e.a(activity);
            if (a == 0 || a == 1 || a == 2 || a == 3) {
                this.b = 2;
            } else if (a == 4) {
                this.b = 3;
            } else if (a == 5) {
                this.b = 4;
            } else {
                this.b = 1;
            }
        } else {
            this.b = 0;
        }
        Window window;
        switch (this.b) {
            case 0:
                b(activity);
                break;
            case 1:
                window = activity.getWindow();
                window.clearFlags(1024);
                window.addFlags(2048);
                this.c.c(activity);
                break;
            case 2:
                window = activity.getWindow();
                window.clearFlags(1024);
                window.addFlags(2048);
                if (VERSION.SDK_INT < 21) {
                    window.addFlags(67108864);
                    break;
                }
                window.clearFlags(67108864);
                window.getDecorView().setSystemUiVisibility(1280);
                window.addFlags(SectionHeader.SHT_LOUSER);
                window.setStatusBarColor(0);
                break;
            case 3:
                window = activity.getWindow();
                window.clearFlags(1024);
                window.addFlags(2048);
                a(activity, -3289651);
                break;
            case 4:
                window = activity.getWindow();
                window.clearFlags(1024);
                window.addFlags(2048);
                window.addFlags(67108864);
                break;
        }
        if (a()) {
            e.b(activity);
        }
    }

    public final void a(int i) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference.get() != null) {
                ((View) weakReference.get()).setVisibility(i);
            }
        }
    }

    public final void b(Activity activity) {
        Window window = activity.getWindow();
        window.clearFlags(2048);
        window.addFlags(1024);
        d dVar = this.c;
        dVar.a(activity);
        dVar.b(activity);
    }

    public final void a(Activity activity, int i) {
        if (this.b == 3 && this.d != i) {
            h.a(activity, i);
            this.d = i;
        }
    }

    public final boolean a() {
        return (this.b == 2 || this.b == 3 || this.b == 4) && !e.a();
    }

    public final boolean b() {
        return this.b == 0;
    }
}
