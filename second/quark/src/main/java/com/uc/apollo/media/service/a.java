package com.uc.apollo.media.service;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.RemoteException;
import android.view.Surface;
import com.uc.apollo.Settings;
import com.uc.apollo.media.base.e;
import com.uc.apollo.media.d;
import com.uc.apollo.media.impl.DataSource;
import com.uc.apollo.media.impl.F;
import com.uc.apollo.media.impl.O;
import com.uc.apollo.media.impl.g;
import com.uc.apollo.media.impl.u;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

/* compiled from: ProGuard */
final class a extends u {
    private a s = a.IDLE;
    private h t;
    private int u = 0;
    private HashMap<String, String> v;

    /* compiled from: ProGuard */
    enum a {
        ERROR,
        END,
        STOP,
        IDLE,
        INITIALIZED,
        PREPARE_ASYNC,
        START,
        PAUSE,
        COMPLETE
    }

    a(int i) {
        super(i, t.a, "BpMediaPlayer");
        Settings.mediaPlayerServiceInit();
        this.h = true;
        this.v = new HashMap();
    }

    final void a(h hVar) {
        try {
            new StringBuilder("service connected - try to create MediaPlayer, type/id ").append(e.a()).append("/").append(this.j);
            this.t = hVar;
            this.t.a(this.j, this.i, e.a());
            if (this.d.size() > 0) {
                int i;
                com.uc.apollo.media.impl.g.a aVar;
                synchronized (this.v) {
                    for (Entry entry : this.v.entrySet()) {
                        this.t.b(this.j, (String) entry.getKey(), (String) entry.getValue());
                    }
                }
                this.t.a(this.j, this.g);
                for (i = 0; i < this.d.size(); i++) {
                    aVar = (com.uc.apollo.media.impl.g.a) this.d.get(this.d.keyAt(i));
                    new StringBuilder("addClient mpID/clientID ").append(this.j).append("/").append(aVar.a());
                    this.t.c(this.j, aVar.a());
                }
                this.t.e(this.j, this.c.a());
                for (i = 0; i < this.d.size(); i++) {
                    aVar = (com.uc.apollo.media.impl.g.a) this.d.get(this.d.keyAt(i));
                    this.t.a(this.j, aVar.a(), aVar.c());
                    Surface b = aVar.b();
                    if (b != null) {
                        this.t.a(this.j, aVar.a(), new y(b));
                    }
                }
                if (this.s.ordinal() >= a.INITIALIZED.ordinal()) {
                    try {
                        this.t.a(this.j, new u(this.f));
                    } catch (RemoteException e) {
                        d.b(this);
                        return;
                    }
                }
                if (this.s.ordinal() >= a.PREPARE_ASYNC.ordinal()) {
                    this.t.f(this.j);
                }
            }
            if (K()) {
                try {
                    this.t.a(this.j, I(), J());
                } catch (RemoteException e2) {
                    d.b(this);
                }
            }
        } catch (RemoteException e3) {
            d.b(this);
        }
    }

    final void L() {
        this.t = null;
        if (w()) {
            a(F.PAUSED);
        }
    }

    public final int d() {
        return 4;
    }

    public final int e() {
        return this.u;
    }

    public final void a(int i) {
        super.a(i);
        if (this.t != null) {
            try {
                this.t.a(this.j, i);
            } catch (RemoteException e) {
                d.b(this);
            }
        }
    }

    protected final void A() {
        this.s = a.START;
        if (this.t != null) {
            try {
                this.t.c(this.j);
            } catch (RemoteException e) {
                d.b(this);
            }
        }
    }

    public final boolean j() {
        if (!super.j()) {
            return false;
        }
        this.s = a.PAUSE;
        if (this.t != null) {
            try {
                this.t.d(this.j);
            } catch (RemoteException e) {
                d.b(this);
            }
        }
        return true;
    }

    public final boolean k() {
        if (!super.j()) {
            return false;
        }
        this.s = a.STOP;
        if (this.t != null) {
            try {
                this.t.e(this.j);
            } catch (RemoteException e) {
                d.b(this);
            }
        }
        return true;
    }

    public final void a(Context context, DataSource dataSource) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException {
        super.a(context, dataSource);
        this.s = a.INITIALIZED;
        if (this.t != null) {
            try {
                new StringBuilder("setDataSourceImpl - ").append(this.f);
                this.t.a(this.j, new u(this.f));
            } catch (RemoteException e) {
                d.b(this);
            }
        }
    }

    public final void m() throws IllegalStateException {
        if (this.s == a.IDLE || this.s == a.INITIALIZED || this.s == a.STOP) {
            super.m();
            this.s = a.PREPARE_ASYNC;
            if (this.t != null) {
                try {
                    new StringBuilder("prepareAsyncImpl - ").append(this.f);
                    this.t.f(this.j);
                    return;
                } catch (RemoteException e) {
                    d.b(this);
                    return;
                }
            }
            return;
        }
        throw new IllegalStateException("invalid states, current state is " + this.s);
    }

    public final void n() {
        super.n();
        this.s = a.END;
        if (this.t != null) {
            try {
                this.t.g(this.j);
            } catch (RemoteException e) {
                d.b(this);
            }
        }
    }

    public final void o() {
        if (this.t != null) {
            try {
                this.t.b(this.j);
            } catch (RemoteException e) {
            }
        }
        d.a(this);
    }

    public final boolean g(int i) throws IllegalStateException {
        if (super.g(i) && this.t != null) {
            try {
                this.t.b(this.j, i);
                G();
                return true;
            } catch (RemoteException e) {
                d.b(this);
            }
        }
        return false;
    }

    protected final int C() {
        if (this.t != null) {
            try {
                return this.t.i(this.j);
            } catch (RemoteException e) {
                d.b(this);
            }
        }
        return -1;
    }

    public final Bitmap r() {
        if (this.t != null) {
            try {
                return this.t.k(this.j);
            } catch (RemoteException e) {
                d.b(this);
            }
        }
        return null;
    }

    public final void q() {
        if (this.t != null) {
            try {
                this.t.j(this.j);
            } catch (RemoteException e) {
                d.b(this);
            }
        }
    }

    public final void b(int i) {
        super.b(i);
        if (this.t != null) {
            try {
                this.t.c(this.j, i);
            } catch (RemoteException e) {
                d.b(this);
            }
        }
    }

    public final void c(int i) {
        super.c(i);
        if (this.t != null) {
            try {
                this.t.d(this.j, i);
            } catch (RemoteException e) {
                d.b(this);
            }
        }
    }

    public final void d(int i) {
        super.d(i);
        if (this.t != null) {
            try {
                this.t.e(this.j, i);
            } catch (RemoteException e) {
                d.b(this);
            }
        }
    }

    public final void a(int i, boolean z) {
        super.a(i, z);
        if (this.t != null) {
            try {
                this.t.a(this.j, i, z);
            } catch (RemoteException e) {
                d.b(this);
            }
        }
    }

    protected final void a(int i, Surface surface, boolean z) {
        super.a(i, surface, false);
    }

    public final void a(int i, Surface surface) {
        super.a(i, surface);
        if (this.t != null) {
            try {
                ((com.uc.apollo.media.impl.g.a) this.d.get(i)).a(this.t.a(this.j, i, new y(surface)).a());
            } catch (RemoteException e) {
                d.b(this);
            }
        }
    }

    public final void a(int i, g gVar, int i2) {
        com.uc.apollo.media.impl.g.a aVar = (com.uc.apollo.media.impl.g.a) this.d.get(i);
        gVar.e(i2).a(aVar.b());
        aVar.a(null);
        if (this.t != null) {
            try {
                this.t.a(this.j, i, gVar.g(), i2);
            } catch (RemoteException e) {
                d.b(this);
            }
        }
    }

    protected final void a(Surface surface) {
    }

    public final void a(boolean z) {
        super.a(z);
        if (this.t != null) {
            try {
                this.t.a(this.j, z);
            } catch (RemoteException e) {
                d.b(this);
            }
        }
    }

    public final boolean i() {
        return this.s == a.START || this.s == a.PREPARE_ASYNC;
    }

    public final boolean v() {
        if (!super.v()) {
            return false;
        }
        this.s = a.IDLE;
        if (this.t != null) {
            try {
                this.t.h(this.j);
            } catch (RemoteException e) {
            }
        }
        return true;
    }

    public final void a(String str, String str2) {
        super.a(str, str2);
        if (this.t != null) {
            try {
                this.t.a(this.j, str, str2);
            } catch (RemoteException e) {
                d.b(this);
            }
        }
    }

    public final boolean b(String str, String str2) {
        boolean z = false;
        super.b(str, str2);
        synchronized (this.v) {
            this.v.put(str, str2);
        }
        if (this.t != null) {
            try {
                z = this.t.b(this.j, str, str2);
            } catch (RemoteException e) {
                d.b(this);
            }
        }
        return z;
    }

    public final String a(String str) {
        String str2 = null;
        if (this.t != null) {
            try {
                str2 = this.t.a(this.j, str);
            } catch (RemoteException e) {
                d.b(this);
            }
        }
        return str2;
    }

    final void M() {
        this.s = a.COMPLETE;
        this.r.b(this.j);
    }

    final void a(int i, int i2) {
        if (this.o != i && this.p != i2) {
            this.r.a(this.j, i, i2);
        }
    }

    final void a(int i, int i2, int i3) {
        if (i != this.l || i2 != this.o || i3 != this.p) {
            this.r.a(this.j, i, i2, i3);
        } else if (this.q != 0) {
            if (this.q < 1000 || this.q >= i) {
                this.q = 0;
            } else {
                try {
                    this.t.b(this.j, this.q);
                } catch (RemoteException e) {
                    d.b(this);
                }
            }
        }
        if (this.s == a.START) {
            h();
        }
    }

    final void i(int i) {
        this.r.a(this.j, i);
    }

    final void b(int i, int i2) {
        this.s = a.ERROR;
        this.r.b(this.j, i, i2);
    }

    final void a(int i, int i2, Object obj) {
        if (i == 71) {
            this.u = d.a(i2);
            new StringBuilder("onMediaPlayerImplCreate - ").append(this.u);
            try {
                HashMap hashMap = (HashMap) obj;
                a(Integer.valueOf((String) hashMap.get("reasonCode")).intValue(), (String) hashMap.get("reasonDesc"));
            } catch (NumberFormatException e) {
            }
        } else if (i == 72) {
            this.k = O.a(i2);
            new StringBuilder("onGotMediaType - ").append(this.k);
        }
        this.r.a(this.j, i, i2, obj);
    }

    final void N() {
        this.r.a(this.j);
    }

    final void a(int i, HashMap<String, String> hashMap) {
        this.r.a(this.j, i, (HashMap) hashMap);
    }

    final void c(int i, int i2) {
        this.r.c(this.j, i, i2);
    }

    public final void a(float f, float f2) {
        super.a(f, f2);
        if (this.t != null) {
            try {
                this.t.a(this.j, I(), J());
            } catch (RemoteException e) {
                d.b(this);
            }
        }
    }
}
