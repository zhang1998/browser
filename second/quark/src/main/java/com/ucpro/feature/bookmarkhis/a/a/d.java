package com.ucpro.feature.bookmarkhis.a.a;

import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.ucweb.common.util.c;
import com.ucweb.common.util.h.m;
import com.ucweb.common.util.i.f;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public final class d {
    private static boolean d = true;
    private static d g;
    public WeakReference<e> a;
    public g b = new g();
    private h c = h.a();
    private List<f> e;
    private boolean f = false;

    private d() {
        Message obtain = Message.obtain();
        obtain.what = 0;
        a(obtain);
    }

    public static synchronized d a() {
        d dVar;
        synchronized (d.class) {
            if (g == null) {
                g = new d();
            }
            dVar = g;
        }
        return dVar;
    }

    public final void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (this.b != null) {
                List a = this.b.a();
                int size = a.size();
                for (int i = 0; i < size; i++) {
                    if (((f) a.get(i)).c.equals(str)) {
                        a.remove(i);
                        break;
                    }
                }
            }
            Message message = new Message();
            message.what = 4;
            message.obj = str;
            a(message);
        }
    }

    public final void a(String str, String str2, String str3) {
        if (f.i(str2) && !TextUtils.isEmpty(str3)) {
            f fVar;
            String h = f.h(str2);
            String h2 = f.h(str3);
            int hashCode = h2.hashCode();
            int hashCode2 = h.hashCode();
            int i = 0;
            while (i < this.b.a().size()) {
                fVar = (f) this.b.a().get(i);
                if (fVar == null || !((fVar.i == hashCode && TextUtils.equals(h2, fVar.c)) || TextUtils.equals(fVar.d, h2) || (fVar.i == hashCode2 && TextUtils.equals(fVar.c, h)))) {
                    i++;
                } else {
                    fVar.b(h);
                    fVar.b = str;
                    fVar.a(h2);
                    a(fVar, i);
                    return;
                }
            }
            fVar = new f();
            fVar.b(h);
            fVar.b = str;
            fVar.a(h2);
            b(fVar);
        }
    }

    private void a(f fVar, int i) {
        if (fVar != null && f.i(fVar.c)) {
            List a = this.b.a();
            a.remove(i);
            a.add(fVar);
            fVar.f++;
            fVar.a = System.currentTimeMillis();
            if (!(this.a == null || this.a.get() == null)) {
                ((e) this.a.get()).u_();
            }
            Message message = new Message();
            message.what = 6;
            message.obj = fVar;
            a(message);
            String str = fVar.c;
            if (b(str)) {
                a(str);
            }
        }
    }

    private boolean b(f fVar) {
        c.b(Looper.myLooper() == Looper.getMainLooper());
        if (!this.f) {
            if (this.e == null) {
                this.e = new ArrayList();
            }
            this.e.add(fVar);
            return false;
        } else if (fVar == null) {
            return false;
        } else {
            String str = fVar.c;
            if (!f.i(str)) {
                return false;
            }
            if (TextUtils.isEmpty(fVar.b)) {
                fVar.b = str;
            }
            fVar.a = System.currentTimeMillis();
            fVar.f = 1;
            this.b.a().add(fVar);
            Message message;
            if (!d || this.b.a().size() <= 200) {
                message = new Message();
                message.what = 3;
                message.obj = fVar;
                a(message);
            } else {
                this.b.a().remove(0);
                message = new Message();
                message.what = 7;
                message.obj = fVar;
                a(message);
            }
            if (!(this.a == null || this.a == null)) {
                ((e) this.a.get()).u_();
            }
            return true;
        }
    }

    public final boolean a(f fVar) {
        int i = 0;
        if (fVar == null) {
            return false;
        }
        if (!f.i(fVar.c)) {
            return false;
        }
        c.b(this.b != null);
        if (this.b == null) {
            this.b = new g();
        }
        if (!this.b.a().isEmpty()) {
            while (i < this.b.a().size()) {
                f fVar2 = (f) this.b.a().get(i);
                if ((fVar2.i != fVar.i || !TextUtils.equals(fVar.c, fVar2.c)) && !TextUtils.equals(fVar.c, fVar2.d) && (TextUtils.isEmpty(fVar2.d) || !TextUtils.equals(fVar.d, fVar2.d))) {
                    i++;
                } else if (fVar.g != 0 || fVar2.g == 0) {
                    fVar2.a = System.currentTimeMillis();
                    a(fVar2, i);
                    return true;
                } else {
                    fVar2.a = System.currentTimeMillis();
                    a(fVar2, i);
                    return true;
                }
            }
        }
        b(fVar);
        return true;
    }

    public final synchronized void a(Message message) {
        m.a(0, new c(this, message));
    }

    public final g b() {
        if (this.b == null) {
            return new g();
        }
        return this.b;
    }

    public final boolean c() {
        return this.b == null || this.b.a().isEmpty();
    }

    private boolean b(String str) {
        boolean z = false;
        for (f fVar : this.b.a()) {
            boolean z2;
            if (!TextUtils.equals(str, fVar.c)) {
                z2 = z;
            } else if (z) {
                return true;
            } else {
                z2 = true;
            }
            z = z2;
        }
        return false;
    }
}
