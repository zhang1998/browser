package com.ucpro.feature.navigation.b;

import com.uc.apollo.android.GuideDialog;
import com.uc.base.b.c.a;
import com.uc.base.b.c.i;
import com.uc.base.b.c.m;

/* compiled from: ProGuard */
public class g extends a {
    protected static final int a = a.a(502197250, g.class);
    private static g i = new g();
    public String b;
    public String c;
    String d;
    String e;
    public long f;
    public int g;
    int h;

    public final byte k_() {
        return (byte) 2;
    }

    public static g c() {
        return i;
    }

    protected final m a() {
        return new m(i.w ? "WidgetInfoBean" : "", a);
    }

    protected final boolean a(m mVar) {
        if (this.b != null) {
            mVar.a(1, i.w ? GuideDialog.TITLE : "", this.b);
        }
        if (this.c != null) {
            mVar.a(2, i.w ? "url" : "", this.c);
        }
        if (this.d != null) {
            mVar.a(3, i.w ? "iconName" : "", this.d);
        }
        if (this.e != null) {
            mVar.a(4, i.w ? "backupIconName" : "", this.e);
        }
        mVar.a(5, i.w ? "widgetId" : "", this.f);
        mVar.a(6, i.w ? "type" : "", this.g);
        mVar.a(7, i.w ? "source" : "", this.h);
        return true;
    }

    protected final boolean b(m mVar) {
        if (mVar == null) {
            return true;
        }
        if (mVar.b > a) {
            do {
                mVar = mVar.g;
                if (mVar == null) {
                    return false;
                }
            } while (mVar.b != a);
        }
        this.b = mVar.b(1);
        this.c = mVar.b(2);
        this.d = mVar.b(3);
        this.e = mVar.b(4);
        this.f = mVar.d(5);
        this.g = mVar.c(6);
        this.h = mVar.c(7);
        return true;
    }

    protected final i a(int i) {
        switch (a.b(i)) {
            case 1:
                if (i == a) {
                    return new g();
                }
                break;
        }
        return null;
    }
}
