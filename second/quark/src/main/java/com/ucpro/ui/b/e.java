package com.ucpro.ui.b;

import android.content.Context;
import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.quark.browser.R;
import com.uc.apollo.impl.SettingsConst;
import com.ucpro.business.stat.m;
import com.ucweb.common.util.c;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Queue;

/* compiled from: ProGuard */
public final class e {
    private static WeakReference<Context> c;
    private static e l = null;
    public d a;
    private Queue<b> b;
    private WindowManager d;
    private LayoutParams e;
    private Handler f;
    private b g;
    private Runnable h;
    private boolean i = false;
    private int j = -1;
    private int k;

    public static e a() {
        if (l == null) {
            l = new e();
        }
        return l;
    }

    public static void b() {
        if (l != null) {
            if (l.b != null) {
                l.b.clear();
                l.b = null;
            }
            if (l.f != null) {
                l.d();
                l.f.removeMessages(2);
                l.f.removeMessages(1);
                l.f.removeMessages(0);
                l.f.removeMessages(3);
            }
            l = null;
            c = null;
        }
    }

    public static void a(Context context) {
        c.a((Object) context);
        c = new WeakReference(context);
    }

    private e() {
        if (f() != null) {
            this.d = (WindowManager) f().getSystemService("window");
            this.e = new LayoutParams();
            this.e.height = -2;
            this.e.width = -2;
            this.e.format = -3;
            this.e.gravity = 83;
            int dimension = (int) f().getResources().getDimension(R.dimen.toast_y_offset_new);
            this.e.y = dimension;
            this.e.windowAnimations = R.style.new_toast_anim;
            this.b = new LinkedList();
            this.f = new a(f().getMainLooper(), this);
            this.k = dimension;
        }
    }

    public static boolean c() {
        return l != null;
    }

    private static Context f() {
        Object obj = null;
        if (c != null) {
            obj = (Context) c.get();
        }
        c.a(obj);
        return obj;
    }

    public final void a(int i, int i2) {
        if (f() != null) {
            a(f().getResources().getString(i), i2);
        }
    }

    public final void a(String str, int i) {
        a((byte) 1, "toast_icon.svg", str, "", "", i, null);
    }

    public final void a(String str, String str2, OnClickListener onClickListener) {
        a("toast_icon.svg", str, str2, onClickListener);
    }

    public final void a(String str, String str2, String str3, OnClickListener onClickListener) {
        a((byte) 3, str, str2, "", str3, SettingsConst.GLOBAL_SETTINGS, onClickListener);
    }

    public final void d() {
        if (f() != null) {
            g();
        }
    }

    private boolean g() {
        if (f() == null || this.f == null) {
            return false;
        }
        this.f.removeCallbacks(this.h);
        if (this.g == null) {
            return false;
        }
        if (this.a != null) {
            try {
                this.d.removeView(this.a);
            } catch (Exception e) {
            }
        }
        this.g = null;
        this.f.removeMessages(2);
        return true;
    }

    public final void a(byte b, String str, String str2, String str3, String str4, int i, OnClickListener onClickListener) {
        b bVar = new b();
        bVar.g = b;
        bVar.a = str2;
        bVar.b = str3;
        bVar.d = str;
        bVar.h = i;
        bVar.e = str4;
        bVar.f = onClickListener;
        if (f() != null && this.f != null) {
            this.h = new c(this, bVar);
            this.f.post(this.h);
        }
    }

    static /* synthetic */ void a(e eVar, b bVar) {
        if (f() != null && eVar.f != null) {
            int i;
            eVar.g = bVar;
            int myTid = Process.myTid();
            if ((myTid != eVar.j ? 1 : 0) != 0 && eVar.a == null) {
                eVar.a = new d(f());
            }
            eVar.a.setType(bVar.g);
            if (!TextUtils.isEmpty(bVar.a)) {
                eVar.a.setTitle(bVar.a);
            }
            if (!TextUtils.isEmpty(bVar.b)) {
                eVar.a.setSubTitle(bVar.b);
            }
            if (bVar.c != null) {
                eVar.a.setIconDrawable(bVar.c);
            }
            if (!TextUtils.isEmpty(bVar.d)) {
                eVar.a.setIconName(bVar.d);
            }
            if (!TextUtils.isEmpty(bVar.e)) {
                eVar.a.setActionText(bVar.e);
            }
            if (bVar.f != null) {
                eVar.a.setActionListener(bVar.f);
            }
            eVar.e.type = 2;
            eVar.e.flags = 168;
            eVar.e.y = (int) f().getResources().getDimension(R.dimen.toast_y_offset_new);
            eVar.e.token = null;
            try {
                eVar.d.addView(eVar.a, eVar.e);
            } catch (Exception e) {
                m.a("crash", "ToastManager_doShow", new String[0]);
            }
            if (bVar.h == 1) {
                i = 3500;
            } else if (bVar.h == 0) {
                i = SettingsConst.GLOBAL_SETTINGS;
            } else {
                i = bVar.h;
            }
            if (i > 0) {
                eVar.f.sendMessageDelayed(eVar.f.obtainMessage(2), (long) i);
            }
            eVar.j = myTid;
        }
    }

    static /* synthetic */ void d(e eVar) {
        if (f() != null) {
            View view = new View(f());
            eVar.e.flags = 24;
            eVar.e.type = 1002;
            eVar.d.addView(view, eVar.e);
            eVar.d.removeView(view);
        }
    }
}
