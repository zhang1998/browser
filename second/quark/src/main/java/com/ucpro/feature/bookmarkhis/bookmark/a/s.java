package com.ucpro.feature.bookmarkhis.bookmark.a;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.ValueCallback;
import com.raizlabs.android.dbflow.a.b.a.b;
import com.raizlabs.android.dbflow.a.b.d;
import com.raizlabs.android.dbflow.a.b.m;
import com.raizlabs.android.dbflow.a.b.u;
import com.raizlabs.android.dbflow.a.b.z;
import com.raizlabs.android.dbflow.a.d.f;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.config.c;
import com.raizlabs.android.dbflow.structure.a;
import com.uc.apollo.impl.SettingsConst;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: ProGuard */
public class s {
    static final String a = s.class.getSimpleName();
    private static volatile s d;
    public c b = FlowManager.c(e.class);
    public a<m> c = FlowManager.g(m.class);
    private ArrayList<m> e;
    private d[] f;
    private f g;
    private u h = new r();

    public static s a() {
        if (d == null) {
            synchronized (s.class) {
                if (d == null) {
                    d = new s();
                }
            }
        }
        return d;
    }

    private s() {
    }

    public final synchronized f b() {
        if (this.g == null) {
            this.g = new f(this);
        }
        return this.g;
    }

    public final int c() {
        return (int) z.b(new b[0]).a(m.class).a(h()).h();
    }

    @NonNull
    public final List<m> d() {
        u a = z.a(new b[0]).a(m.class).a(h()).a(e());
        a.d = SettingsConst.GLOBAL_SETTINGS;
        return a.c();
    }

    private synchronized d[] h() {
        if (this.f == null) {
            this.f = new d[4];
            this.f[0] = y.t.b(Integer.valueOf(1));
            this.f[1] = y.m.b(Integer.valueOf(5));
            this.f[2] = y.m.b(Integer.valueOf(3));
            this.f[3] = y.m.b(Integer.valueOf(2));
        }
        return this.f;
    }

    public final synchronized ArrayList<m> e() {
        if (this.e == null) {
            this.e = new ArrayList();
            ArrayList arrayList = this.e;
            m a = m.a(y.n);
            a.a = false;
            arrayList.add(a);
            arrayList = this.e;
            a = m.a(y.q);
            a.a = false;
            arrayList.add(a);
            arrayList = this.e;
            a = m.a(y.l);
            a.a = true;
            arrayList.add(a);
            arrayList = this.e;
            a = m.a(y.p);
            a.a = false;
            arrayList.add(a);
            arrayList = this.e;
            a = m.a(y.f);
            a.a = false;
            arrayList.add(a);
        }
        return this.e;
    }

    public final long a(@NonNull String str, @NonNull String str2) {
        com.ucweb.common.util.c.a((Object) str);
        com.ucweb.common.util.c.a((Object) str2);
        return a(m.a(str, str2));
    }

    public final long a(m mVar) {
        if (c() >= SettingsConst.GLOBAL_SETTINGS) {
            Log.e(a, "add bookmark fail, maximum quantity reached");
            return -1;
        }
        if (mVar.g == null) {
            mVar.g = f(mVar);
        }
        if (TextUtils.isEmpty(mVar.s)) {
            mVar.s = m.a(mVar.f, mVar.g, mVar.j, mVar.n);
        }
        mVar.p = 0;
        mVar.q = 0;
        long b = this.c.b(mVar);
        mVar.b = b;
        return b;
    }

    public final void a(m mVar, ValueCallback<Boolean> valueCallback) {
        List arrayList = new ArrayList(1);
        arrayList.add(mVar);
        a(new t(this, arrayList), (ValueCallback) valueCallback);
    }

    private static String f(m mVar) {
        if (mVar.d == 0) {
            return "";
        }
        int i;
        Object a = a(mVar.d);
        com.ucweb.common.util.c.a(a);
        com.ucweb.common.util.c.b(a.g());
        com.ucweb.common.util.c.a(a.g);
        StringBuilder stringBuilder = new StringBuilder();
        if (!TextUtils.isEmpty(a.g)) {
            stringBuilder.append(a.g).append(ac.a);
        }
        stringBuilder.append(a.e);
        String stringBuilder2 = stringBuilder.toString();
        String str = ac.a;
        if (stringBuilder2 == null || str == null) {
            i = 0;
        } else {
            int length = str.length();
            i = (length > stringBuilder2.length() || !str.equalsIgnoreCase(stringBuilder2.substring(0, length))) ? 0 : 1;
        }
        if (i == 0) {
            stringBuilder.insert(0, ac.a);
        }
        return stringBuilder.toString();
    }

    public final void a(long j, @NonNull ValueCallback<m> valueCallback) {
        com.ucweb.common.util.c.a((Object) valueCallback);
        f f = z.a(new b[0]).a(m.class).a(y.f.a(Long.valueOf(j))).f();
        f.b = new ae(this, valueCallback);
        f.a();
    }

    public static m a(long j) {
        return (m) z.a(new b[0]).a(m.class).a(y.f.a(Long.valueOf(j))).d();
    }

    public static m a(String str) {
        return (m) z.a(new b[0]).a(m.class).a(y.g.a((Object) str)).d();
    }

    @NonNull
    public final void b(long j, @NonNull ValueCallback<List<m>> valueCallback) {
        com.ucweb.common.util.c.a((Object) valueCallback);
        f f = z.a(new b[0]).a(m.class).a(y.h.a(Long.valueOf(j)), y.t.b(Integer.valueOf(1)), y.m.b(Integer.valueOf(5)), y.m.b(Integer.valueOf(3)), y.m.b(Integer.valueOf(2))).a(e()).f();
        f.a = new k(this, valueCallback);
        f.a();
    }

    public final void a(List<Long> list, ValueCallback<Boolean> valueCallback) {
        com.raizlabs.android.dbflow.structure.database.transaction.f a = this.b.a(new l(this, list));
        a.d = new d(this, valueCallback);
        a.c = new ag(this, valueCallback);
        a.a().b();
    }

    public final boolean b(@NonNull m mVar) {
        m a = a(mVar.b);
        if (a == null) {
            return false;
        }
        if (mVar.g()) {
            mVar.f = mVar.e;
        }
        mVar.a(a);
        return a(mVar, a);
    }

    public final void b(@NonNull m mVar, ValueCallback<Boolean> valueCallback) {
        List arrayList = new ArrayList(1);
        arrayList.add(mVar);
        b(arrayList, (ValueCallback) valueCallback);
    }

    public final void b(@NonNull List<m> list, ValueCallback<Boolean> valueCallback) {
        com.ucweb.common.util.c.a((Object) list);
        a(new ab(this, list), (ValueCallback) valueCallback);
    }

    public final void a(@NonNull ValueCallback<List<m>> valueCallback) {
        com.ucweb.common.util.c.a((Object) valueCallback);
        f f = z.a(new b[0]).a(m.class).a(y.n.a(Integer.valueOf(1))).a(h()).a(e()).f();
        f.a = new aj(this, valueCallback);
        f.a();
    }

    public final boolean a(@NonNull m mVar, @Nullable m mVar2) {
        com.ucweb.common.util.c.a((Object) mVar);
        if (mVar2 == null) {
            mVar2 = a(mVar.b);
        }
        if (mVar2 == null) {
            Log.w(a, "update fail for item with id : " + mVar.b + " not found");
            return false;
        }
        if (mVar.d != mVar2.d) {
            mVar.g = f(mVar);
            int i = 1;
        } else {
            boolean z = false;
        }
        if (!(mVar.f == null || mVar.f.equalsIgnoreCase(mVar2.f))) {
            i = 1;
        }
        if (!(mVar.n == null || mVar.n.equalsIgnoreCase(mVar2.n))) {
            i = 1;
        }
        if (i != 0 || TextUtils.isEmpty(mVar.s)) {
            mVar.s = m.a(mVar.f, mVar.g, mVar.j, mVar.n);
        }
        if (mVar.g() && !mVar.e.equals(mVar2.e)) {
            String str = ac.a + mVar.e;
            for (m mVar3 : z.a(new b[0]).a(m.class).a(y.h.a(Long.valueOf(mVar.b)), y.t.b(Integer.valueOf(1)), y.m.b(Integer.valueOf(5))).c()) {
                m j = mVar3.j();
                mVar3.g = str;
                mVar3.a(j);
                mVar3.s = m.a(mVar3.f, mVar3.g, mVar3.j, mVar3.n);
                this.c.c(mVar3);
            }
        }
        return this.c.c(mVar);
    }

    public final boolean c(@NonNull m mVar) {
        return a(mVar, null);
    }

    public static boolean b(@NonNull String str) {
        com.ucweb.common.util.c.a((Object) str);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (z.b(new b[0]).a(m.class).a(y.t.b(Integer.valueOf(1)), y.n.a(Integer.valueOf(0)), y.m.b(Integer.valueOf(5)), y.j.a(str)).h() > 0) {
            return true;
        }
        return false;
    }

    public final List<m> f() {
        return z.a(new b[0]).a(m.class).a(y.m.a(Integer.valueOf(5)), y.t.b(Integer.valueOf(1))).a(e()).c();
    }

    public final boolean d(@NonNull m mVar) {
        com.ucweb.common.util.c.a((Object) mVar);
        return e(mVar);
    }

    final boolean e(m mVar) {
        if ((!this.h.a() ? 1 : 0) != 0 || TextUtils.isEmpty(mVar.c)) {
            boolean d = this.c.d(mVar);
            com.ucweb.common.util.c.b(d);
            new StringBuilder("hard delete bk whose luid is ").append(mVar.b).append(" for it's guid is empty");
            return d;
        }
        mVar.p = 1;
        mVar.q = 0;
        d = FlowManager.g(m.class).c(mVar);
        com.ucweb.common.util.c.b(d);
        new StringBuilder("soft delete bk whose luid is ").append(mVar.b).append(" and it's guid is ").append(mVar.c);
        return d;
    }

    public static void g() {
        z.a(m.class).e();
    }

    public static boolean b(long j) {
        if (z.a(m.class).a(y.f.a(Long.valueOf(j))).e() > 0) {
            return true;
        }
        return false;
    }

    public final m c(@NonNull String str) {
        m mVar = (m) z.a(new b[0]).a(m.class).a(y.n.a(Integer.valueOf(1)), y.i.a((Object) str)).d();
        if (mVar != null) {
            return mVar;
        }
        mVar = m.a(str);
        if (a(mVar) < 0) {
            return null;
        }
        return mVar;
    }

    public final void a(i iVar, ValueCallback<Boolean> valueCallback) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        com.raizlabs.android.dbflow.structure.database.transaction.f a = this.b.a(new aa(this, atomicBoolean, iVar));
        a.d = new v(this, valueCallback, atomicBoolean);
        a.c = new j(this, valueCallback);
        a.a().b();
    }
}
