package com.uc.apollo.media.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.util.SparseArray;
import android.view.Surface;
import com.UCMobile.Apollo.MediaPlayer;
import com.alibaba.wireless.security.SecExceptionCode;
import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;
import com.uc.apollo.util.f;
import com.uc.imagecodec.export.IPictureView;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: ProGuard */
public abstract class u implements g {
    protected static int a = 2;
    private static int s = 0;
    private static final int t;
    private Set<E> A = new HashSet();
    private HashMap<String, String> B = new HashMap();
    private float C = IPictureView.DEFAULT_MIN_SCALE;
    private float D = IPictureView.DEFAULT_MIN_SCALE;
    private boolean E = false;
    private boolean F = false;
    private int G = -1;
    private String H;
    public String b;
    public com.uc.apollo.media.impl.g.a c;
    public SparseArray<com.uc.apollo.media.impl.g.a> d = new SparseArray(3);
    protected Context e;
    public DataSource f;
    public boolean g;
    public boolean h;
    public int i;
    public int j;
    public O k = O.UNPARSE;
    public int l = SectionHeader.SHT_LOUSER;
    protected int m = SectionHeader.SHT_LOUSER;
    protected int n = SectionHeader.SHT_LOUSER;
    public int o;
    public int p;
    public int q;
    public E r;
    private String u;
    private F v = F.IDLE;
    private boolean w;
    private int x;
    private boolean y;
    private long z;

    /* compiled from: ProGuard */
    final class a implements E {
        final /* synthetic */ u a;

        private a(u uVar) {
            this.a = uVar;
        }

        public final void a(int i, int i2, int i3) {
            this.a.o = i2;
            this.a.p = i3;
            for (E a : this.a.A) {
                a.a(i, i2, i3);
            }
        }

        public final void a(int i, int i2, int i3, int i4) {
            this.a.a(F.PREPARED);
            if (i2 <= 0 && i2 != -1) {
                String str = this.a.b;
                new StringBuilder("onPrepared, duration(").append(i2).append(") <= 0, it may be a live media, modify to -1 by standard");
                i2 = -1;
            }
            this.a.l = i2;
            this.a.o = i3;
            this.a.p = i4;
            for (E a : this.a.A) {
                a.a(i, i2, i3, i4);
            }
            if (this.a.q != 0) {
                if (this.a.q < 1000 || this.a.q >= i2) {
                    this.a.q = 0;
                } else {
                    this.a.g(this.a.q);
                }
            }
            if (this.a.v == F.PREPARED && !(this.a.w && this.a.h())) {
                this.a.a(F.PAUSED);
            }
            if (this.a.v != F.STARTED && !this.a.E()) {
                this.a.b(false);
            }
        }

        public final void a(int i, int i2) {
            this.a.l = i2;
            for (E a : this.a.A) {
                a.a(i, i2);
            }
        }

        public final void a(int i) {
            this.a.y = false;
            for (E a : this.a.A) {
                a.a(i);
            }
        }

        public final void b(int i) {
            this.a.y = false;
            this.a.q = this.a.l > 0 ? this.a.l : this.a.C();
            this.a.a(F.COMPLETED);
            for (E b : this.a.A) {
                b.b(i);
            }
        }

        public final void a(int i, int i2, int i3, Object obj) {
            for (E a : this.a.A) {
                a.a(this.a.j, i2, i3, obj);
            }
        }

        public final boolean b(int i, int i2, int i3) {
            this.a.a(F.ERROR);
            this.a.y = false;
            boolean z = false;
            for (E b : this.a.A) {
                boolean z2;
                if (b.b(i, i2, i3)) {
                    z2 = true;
                } else {
                    z2 = z;
                }
                z = z2;
            }
            if (this.a.f != null && (this.a.f instanceof DataSourceURI)) {
                ((DataSourceURI) this.a.f).addReferer();
            }
            return z;
        }

        public final void a(int i, F f, F f2) {
        }

        public final void a(int i, int i2, HashMap<String, String> hashMap) {
            for (E a : this.a.A) {
                a.a(i, i2, (HashMap) hashMap);
            }
        }

        public final void c(int i, int i2, int i3) {
            for (E c : this.a.A) {
                c.c(i, i2, i3);
            }
        }
    }

    public abstract int C();

    static {
        int i = SecExceptionCode.SEC_ERROR_SIGNATRUE;
        while (i < 3100) {
            i += SecExceptionCode.SEC_ERROR_SIGNATRUE;
        }
        t = i;
    }

    public u(int i, String str, String str2) {
        this.i = i;
        do {
            int i2 = a;
            a = i2 + 1;
            this.j = i2;
        } while (this.j == 0);
        this.u = str2 + this.j;
        this.b = str + str2 + this.j;
        s++;
        new StringBuilder("construct - instance count ").append(s);
        this.r = new a();
    }

    public void a(int i) {
        new StringBuilder("changeDomID - old/new ").append(this.i).append("/").append(i);
        this.i = i;
        this.u += "/" + this.i;
        this.b += "/" + this.i;
    }

    public static boolean j(int i) {
        return i >= 10;
    }

    protected void finalize() throws Throwable {
        super.finalize();
        s--;
        new StringBuilder("finalize - instance count ").append(s);
    }

    public final void a(F f) {
        if (this.v != f) {
            new StringBuilder("setState: from ").append(this.v).append(" to ").append(f);
            F f2 = this.v;
            this.v = f;
            for (E a : this.A) {
                a.a(this.j, f2, f);
            }
        }
    }

    public final F a() {
        return this.v;
    }

    public int e() {
        return d();
    }

    public final O b() {
        return this.k;
    }

    public void a(int i, g gVar, int i2) {
        Surface b = ((com.uc.apollo.media.impl.g.a) this.d.get(i)).b();
        a(i, null, false);
        gVar.a(i2, b);
    }

    public void b(int i) {
        this.d.put(i, new com.uc.apollo.media.impl.g.a(i));
        new StringBuilder("addClient ").append(i).append(", now client count ").append(this.d.size());
    }

    public void c(int i) {
        this.d.remove(i);
        new StringBuilder("removeClient - ").append(i).append(", now client count ").append(this.d.size());
        if (this.c.a() == i) {
            this.c = null;
            a(null);
        }
    }

    public void d(int i) {
        if (this.c == null || this.c.a() != i) {
            this.c = (com.uc.apollo.media.impl.g.a) this.d.get(i);
            a(this.c.b());
        }
    }

    public final int c() {
        return this.c == null ? -1 : this.c.a();
    }

    public final com.uc.apollo.media.impl.g.a e(int i) {
        return (com.uc.apollo.media.impl.g.a) this.d.get(i);
    }

    public final boolean E() {
        int size = this.d.size();
        for (int i = 0; i != size; i++) {
            if (((com.uc.apollo.media.impl.g.a) this.d.valueAt(i)).c()) {
                return true;
            }
        }
        return false;
    }

    public void a(int i, boolean z) {
        boolean E = E();
        com.uc.apollo.media.impl.g.a aVar = (com.uc.apollo.media.impl.g.a) this.d.get(i);
        if (z != aVar.c()) {
            new StringBuilder("setVisibility - client(").append(i).append(") visibility to ").append(z);
        }
        aVar.a(z);
        boolean E2 = E();
        if (E2 == E) {
            return;
        }
        if (E2) {
            b(true);
        } else if (w()) {
            b(false);
        }
    }

    public void b(boolean z) {
    }

    public void a(int i, Surface surface, boolean z) {
        com.uc.apollo.media.impl.g.a aVar = (com.uc.apollo.media.impl.g.a) this.d.get(i);
        Surface b = aVar.b();
        if (b == null || !b.equals(surface)) {
            new StringBuilder("setSurface - clientID = ").append(i).append(", surface = ").append(surface);
            aVar.a(surface);
            if (this.c.a() == i) {
                a(this.c.b());
            }
            if (z && b != null) {
                b.release();
            }
        }
    }

    public void a(int i, Surface surface) {
        a(i, surface, true);
    }

    protected final Surface F() {
        return this.c != null ? this.c.b() : null;
    }

    public final Surface h(int i) {
        com.uc.apollo.media.impl.g.a aVar = (com.uc.apollo.media.impl.g.a) this.d.get(i);
        return aVar == null ? null : aVar.b();
    }

    public final int f() {
        return this.i;
    }

    public final void f(int i) {
        if (this.j != i) {
            this.j = i;
            this.u += "/" + i;
            this.b += "/" + i;
        }
    }

    public final int g() {
        return this.j;
    }

    public final void a(E e) {
        f.a(e != null, "listener is null");
        this.A.add(e);
    }

    public final void b(E e) {
        if (e != null) {
            this.A.remove(e);
        } else {
            this.A.clear();
        }
    }

    public void o() {
    }

    public final boolean h() {
        this.w = false;
        if (this.v != F.IDLE || this.f == null) {
            boolean z;
            if (this.v == F.PREPARED || this.v == F.PAUSED || this.v == F.COMPLETED) {
                if (this.v == F.COMPLETED && j(this.l) && Math.abs(p() - this.l) <= SecExceptionCode.SEC_ERROR_DYN_STORE) {
                    g(0);
                }
                a(F.STARTED);
                z = true;
            } else {
                new StringBuilder("ignore start command, current state ").append(this.v);
                z = false;
            }
            if (!z) {
                return false;
            }
            if (!this.h && this.g && F() == null) {
                return true;
            }
            A();
            return true;
        }
        m();
        this.w = true;
        return true;
    }

    public void A() {
        this.r.a(this.j, 75, 0, null);
        b(true);
    }

    public boolean j() {
        this.w = false;
        if (this.v == F.STARTED) {
            a(F.PAUSED);
            return true;
        } else if (this.v == F.PREPARED) {
            a(F.PAUSED);
            return false;
        } else {
            new StringBuilder("ignore pause command, current state ").append(this.v);
            return false;
        }
    }

    public boolean k() {
        this.w = false;
        if (this.v.l <= F.STOPPED.l) {
            new StringBuilder("ignore stop command, current state ").append(this.v);
            return false;
        }
        a(F.STOPPED);
        return true;
    }

    public void n() {
        this.w = false;
        a(F.END);
    }

    public void m() {
        if (this.v == F.IDLE) {
            if (this.f == null) {
                throw new IllegalStateException("invalid states, current state is idle");
            }
            try {
                a(this.e, this.f);
            } catch (Exception e) {
                Log.w(this.b, "setDataSource in prepareAsync failure: " + e);
                return;
            }
        }
        a(F.PREPARING);
    }

    public boolean v() {
        this.w = false;
        if (this.v == F.IDLE) {
            return false;
        }
        a(F.IDLE);
        this.l = SectionHeader.SHT_LOUSER;
        this.m = SectionHeader.SHT_LOUSER;
        this.n = SectionHeader.SHT_LOUSER;
        this.o = 0;
        this.p = 0;
        this.q = 0;
        this.x = 0;
        this.y = false;
        return true;
    }

    public final DataSource l() {
        return this.f;
    }

    public void a(Context context, DataSource dataSource) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException {
        if (this.v != F.IDLE) {
            throw new IllegalStateException("current state is " + this.v);
        }
        if (dataSource instanceof DataSourceURI) {
            if (((DataSourceURI) dataSource).uri != null) {
                a(F.INITIALIZED);
            } else {
                a(F.IDLE);
            }
        } else if (dataSource instanceof DataSourceFD) {
            if (((DataSourceFD) dataSource).fd != null) {
                a(F.INITIALIZED);
            } else {
                a(F.IDLE);
            }
        } else if (dataSource != null) {
            throw new IllegalArgumentException("unknown dataSource " + dataSource);
        }
        this.e = context;
        this.f = dataSource;
        this.k = O.UNPARSE;
    }

    public boolean i() {
        return this.v == F.PREPARING || this.v == F.STARTED;
    }

    public final boolean w() {
        return this.v.l >= F.PREPARED.l;
    }

    public final int u() {
        return this.l;
    }

    public final int t() {
        return this.p;
    }

    public final int s() {
        return this.o;
    }

    public final int p() {
        if (this.y) {
            if (System.currentTimeMillis() - this.z >= ((long) t)) {
                this.y = false;
            }
            this.q = this.x;
        } else if (w() && this.v != F.COMPLETED) {
            this.q = C();
        }
        return this.q;
    }

    public boolean g(int i) {
        if (!j(this.l)) {
            return false;
        }
        new StringBuilder("want to seekTo ").append(f.b(i)).append("/").append(f.b(this.l));
        this.x = i;
        return true;
    }

    public final void G() {
        this.y = true;
        this.z = System.currentTimeMillis();
    }

    protected void B() {
    }

    protected boolean D() {
        return false;
    }

    public void a(Surface surface) {
        if (D()) {
            B();
        }
    }

    protected final void H() {
        if (!this.h && this.g && F() != null && this.v == F.STARTED) {
            A();
        }
    }

    public void a(boolean z) {
        this.g = z;
    }

    public void a(String str, String str2) {
        if (this.f instanceof DataSourceURI) {
            DataSourceURI dataSourceURI = (DataSourceURI) this.f;
            dataSourceURI.title = str;
            dataSourceURI.pageUri = str2;
        }
    }

    public String toString() {
        return this.u;
    }

    public Bitmap r() {
        return null;
    }

    public void q() {
    }

    public void a(float f, float f2) {
        this.C = f;
        this.D = f2;
        this.F = true;
    }

    public final float I() {
        if (this.E) {
            return 0.0f;
        }
        return this.C;
    }

    public final float J() {
        if (this.E) {
            return 0.0f;
        }
        return this.D;
    }

    public final boolean K() {
        return this.F;
    }

    protected final void c(boolean z) {
        this.E = z;
        this.F = true;
    }

    public boolean b(String str, String str2) {
        this.B.put(str, str2);
        return true;
    }

    public final void a(g gVar) {
        u uVar = (u) gVar;
        a(uVar.g);
        for (int i = 0; i < uVar.d.size(); i++) {
            int keyAt = uVar.d.keyAt(i);
            b(keyAt);
            if (uVar.c != null && keyAt == uVar.c.a()) {
                d(keyAt);
            }
            com.uc.apollo.media.impl.g.a aVar = (com.uc.apollo.media.impl.g.a) uVar.d.get(keyAt);
            if (aVar != null) {
                a(keyAt, aVar.b());
            }
        }
        if (uVar.f instanceof DataSourceURI) {
            DataSourceURI dataSourceURI = (DataSourceURI) uVar.f;
            a(dataSourceURI.title, dataSourceURI.pageUri);
        }
        for (Entry entry : uVar.B.entrySet()) {
            b((String) entry.getKey(), (String) entry.getValue());
        }
        if (uVar.C > 0.0f || uVar.D > 0.0f) {
            a(uVar.C, uVar.D);
        }
        for (E a : uVar.A) {
            a(a);
        }
    }

    public final void a(int i, String str) {
        this.G = i;
        this.H = str;
    }

    public final int x() {
        return this.G;
    }

    public final String y() {
        return this.H;
    }

    public final Map<String, String> z() {
        Object obj = "";
        if (e() == 5) {
            obj = MediaPlayer.getVersionString();
        }
        Map hashMap = new HashMap();
        hashMap.put("version", obj);
        hashMap.put("reasonCode", String.valueOf(this.G));
        hashMap.put("reasonDesc", this.H);
        return hashMap;
    }
}
