package com.uc.apollo.a;

import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.Log;
import android.view.View;
import com.uc.apollo.base.Config;
import java.lang.ref.WeakReference;

/* compiled from: ProGuard */
public final class a {
    private static int a = 0;
    private boolean b = false;
    private a c;

    /* compiled from: ProGuard */
    interface a {
        void a();

        void b();
    }

    /* compiled from: ProGuard */
    final class b implements a {
        private final a[] a;

        private b(a... aVarArr) {
            this.a = aVarArr;
        }

        public final void a() {
            int length = this.a.length;
            for (int i = 0; i != length; i++) {
                this.a[i].a();
            }
        }

        public final void b() {
            int length = this.a.length;
            for (int i = 0; i != length; i++) {
                this.a[i].b();
            }
        }
    }

    /* compiled from: ProGuard */
    final class c implements a {
        WakeLock a;

        private c() {
        }

        public final void a() {
            try {
                if (this.a == null) {
                    PowerManager powerManager = (PowerManager) Config.getContext().getSystemService("power");
                    if (powerManager != null) {
                        this.a = powerManager.newWakeLock(536870922, "apollo.PowerSaveBlocker");
                    }
                }
                if (this.a != null && !this.a.isHeld()) {
                    this.a.acquire();
                    a.c();
                    Log.e("apollo.PowerSaveBlocker", "lock - PowerManager.WakeLock.acquire() - locker acquired count = " + a.a);
                }
            } catch (Throwable th) {
                Log.e("apollo.PowerSaveBlocker", "lock failure: " + th);
            }
        }

        public final void b() {
            try {
                if (this.a != null && this.a.isHeld()) {
                    this.a.release();
                    a.e();
                    Log.e("apollo.PowerSaveBlocker", "unlock - PowerManager.WakeLock.release() - locker acquired count = " + a.a);
                }
            } catch (Throwable th) {
                Log.e("apollo.PowerSaveBlocker", "unlock failure: " + th);
            }
        }
    }

    /* compiled from: ProGuard */
    final class d implements a {
        private WeakReference<View> a;

        d(View view) {
            this.a = new WeakReference(view);
        }

        public final void a() {
            View view = (View) this.a.get();
            if (view != null) {
                view.setKeepScreenOn(true);
                a.c();
                Log.e("apollo.PowerSaveBlocker", "lock - View.setKeepScreenOn(true) - locker acquired count = " + a.a);
            }
        }

        public final void b() {
            View view = (View) this.a.get();
            if (view != null) {
                view.setKeepScreenOn(false);
                a.e();
                Log.e("apollo.PowerSaveBlocker", "unlock - View.setKeepScreenOn(false) - locker acquired count = " + a.a);
            }
        }
    }

    static /* synthetic */ int c() {
        int i = a + 1;
        a = i;
        return i;
    }

    static /* synthetic */ int e() {
        int i = a - 1;
        a = i;
        return i;
    }

    public a(View view) {
        this.c = new b(new a[]{new c(), new d(view)});
    }

    public final void a() {
        if (!this.b) {
            this.b = true;
            this.c.a();
        }
    }

    public final void b() {
        if (this.b) {
            this.b = false;
            this.c.b();
        }
    }
}
