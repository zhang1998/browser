package com.uc.quark.filedownloader;

import com.uc.quark.filedownloader.e.b;
import com.uc.quark.filedownloader.e.e;
import com.uc.quark.filedownloader.e.j;
import com.uc.quark.filedownloader.message.MessageSnapshot;
import com.uc.quark.filedownloader.message.k;
import com.uc.quark.filedownloader.model.d;
import java.io.File;
import java.security.InvalidParameterException;
import java.util.ArrayList;

/* compiled from: ProGuard */
public final class o implements ae, an, q, u {
    final x a;
    volatile boolean b = false;
    private final h c;
    private byte d = (byte) 0;
    private Throwable e = null;
    private final w f;
    private final g g;
    private long h;
    private long i;
    private int j;
    private boolean k;
    private boolean l;
    private String m;
    private boolean n = false;

    public final boolean a(MessageSnapshot messageSnapshot) {
        boolean z;
        byte b = this.d;
        byte i = messageSnapshot.i();
        if (b == (byte) 3 || b == (byte) 5 || b != i) {
            int i2;
            if (b < (byte) 0) {
                i2 = 1;
            } else {
                z = false;
            }
            if (i2 == 0) {
                switch (b) {
                    case (byte) 1:
                        switch (i) {
                            case (byte) 0:
                                z = false;
                                break;
                            default:
                                z = true;
                                break;
                        }
                    case (byte) 2:
                        switch (i) {
                            case (byte) 0:
                            case (byte) 1:
                            case (byte) 6:
                                z = false;
                                break;
                            default:
                                z = true;
                                break;
                        }
                    case (byte) 3:
                        switch (i) {
                            case (byte) 0:
                            case (byte) 1:
                            case (byte) 2:
                            case (byte) 6:
                                z = false;
                                break;
                            default:
                                z = true;
                                break;
                        }
                    case (byte) 5:
                        switch (i) {
                            case (byte) 1:
                            case (byte) 6:
                                z = false;
                                break;
                            default:
                                z = true;
                                break;
                        }
                    case (byte) 6:
                        switch (i) {
                            case (byte) 0:
                            case (byte) 1:
                                z = false;
                                break;
                            default:
                                z = true;
                                break;
                        }
                    default:
                        z = true;
                        break;
                }
            }
            z = false;
        } else {
            z = false;
        }
        if (z) {
            e(messageSnapshot);
            return true;
        } else if (!j.a) {
            return false;
        } else {
            j.d(this, "can't update mStatus change by keep ahead, %d, but the current mStatus is %d, %d", Byte.valueOf(this.d), Byte.valueOf(this.d), Integer.valueOf(o()));
            return false;
        }
    }

    public final boolean b(MessageSnapshot messageSnapshot) {
        byte b = this.d;
        byte i = messageSnapshot.i();
        if ((byte) -2 != b || !d.a(i)) {
            boolean z;
            if (b == (byte) 7) {
                z = true;
            } else {
                if (b == (byte) 3 || b == (byte) 5 || b != i) {
                    if (b < (byte) 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        if (i != (byte) -2) {
                            if (i != (byte) -1) {
                                switch (b) {
                                    case (byte) 0:
                                        switch (i) {
                                            case (byte) -4:
                                            case (byte) -3:
                                            case (byte) 1:
                                                z = true;
                                                break;
                                            default:
                                                z = false;
                                                break;
                                        }
                                    case (byte) 1:
                                        switch (i) {
                                            case (byte) 6:
                                                z = true;
                                                break;
                                            default:
                                                z = false;
                                                break;
                                        }
                                    case (byte) 2:
                                    case (byte) 3:
                                        switch (i) {
                                            case (byte) -3:
                                            case (byte) 3:
                                            case (byte) 5:
                                                z = true;
                                                break;
                                            default:
                                                z = false;
                                                break;
                                        }
                                    case (byte) 5:
                                    case (byte) 6:
                                        switch (i) {
                                            case (byte) 2:
                                            case (byte) 5:
                                                z = true;
                                                break;
                                            default:
                                                z = false;
                                                break;
                                        }
                                }
                            }
                            z = true;
                        } else {
                            z = true;
                        }
                    }
                }
                z = false;
            }
            if (z) {
                e(messageSnapshot);
                return true;
            }
            if (j.a) {
                j.d(this, "can't update mStatus change by keep flow, %d, but the current mStatus is %d, %d", Byte.valueOf(this.d), Byte.valueOf(this.d), Integer.valueOf(o()));
            }
            return false;
        } else if (!j.a) {
            return true;
        } else {
            j.d(this, "High concurrent cause, callback pending, but has already be paused %d", Integer.valueOf(o()));
            return true;
        }
    }

    public final boolean c(MessageSnapshot messageSnapshot) {
        boolean z;
        aa M = this.a.K().M();
        if (M.s() == (byte) 0 || M.s() == (byte) 3) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return false;
        }
        e(messageSnapshot);
        return true;
    }

    public final boolean d(MessageSnapshot messageSnapshot) {
        if (!this.a.K().M().j() || messageSnapshot.i() != (byte) -4 || this.d != (byte) 2) {
            return false;
        }
        e(messageSnapshot);
        return true;
    }

    public final h b() {
        return this.c;
    }

    public final MessageSnapshot a(Throwable th) {
        a((byte) -1);
        this.e = th;
        return com.uc.quark.filedownloader.message.d.a(this.a.K().M());
    }

    private void e(MessageSnapshot messageSnapshot) {
        aa M = this.a.K().M();
        a(messageSnapshot.i());
        this.k = messageSnapshot.n();
        switch (messageSnapshot.i()) {
            case (byte) -5:
                this.h = messageSnapshot.b();
                this.i = messageSnapshot.a();
                ak.a.a(this.a.K(), messageSnapshot);
                return;
            case (byte) -4:
                int i;
                this.f.b();
                int a = ak.a.a(M.e());
                if (a > 1 || !M.j()) {
                    i = 0;
                } else {
                    i = ak.a.a(b.a(M.f(), M.l()));
                }
                if (i + a <= 1) {
                    j.e(this, "warn, but no mListener to receive, switch to pending %d %d", Integer.valueOf(M.e()), Integer.valueOf(n.a.d(M.e())));
                    if (d.a(n.a.d(M.e()))) {
                        a((byte) 1);
                        this.i = messageSnapshot.a();
                        this.h = messageSnapshot.b();
                        ((k) messageSnapshot).p();
                        this.c.a(messageSnapshot);
                        return;
                    }
                }
                ak.a.a(this.a.K(), messageSnapshot);
                return;
            case (byte) -3:
                this.n = messageSnapshot.c();
                this.h = messageSnapshot.a();
                this.i = messageSnapshot.a();
                ak.a.a(this.a.K(), messageSnapshot);
                return;
            case (byte) -1:
                this.e = messageSnapshot.f();
                this.h = messageSnapshot.b();
                this.i = messageSnapshot.a();
                ak.a.a(this.a.K(), messageSnapshot);
                return;
            case (byte) 1:
                this.h = messageSnapshot.b();
                this.i = messageSnapshot.a();
                this.c.a(messageSnapshot);
                return;
            case (byte) 2:
                this.i = messageSnapshot.a();
                this.l = messageSnapshot.k();
                this.m = messageSnapshot.l();
                String m = messageSnapshot.m();
                if (m != null) {
                    if (M.k() != null) {
                        j.e(this, "already has mFilename[%s], but assign mFilename[%s] again", M.k(), m);
                    }
                    this.a.d(m);
                }
                this.c.c(messageSnapshot);
                return;
            case (byte) 3:
                this.h = messageSnapshot.b();
                this.i = messageSnapshot.a();
                this.f.a(messageSnapshot.o());
                this.c.d(messageSnapshot);
                return;
            case (byte) 5:
                this.h = messageSnapshot.b();
                this.e = messageSnapshot.f();
                this.j = messageSnapshot.h();
                this.f.b();
                this.c.f(messageSnapshot);
                return;
            case (byte) 6:
                this.c.b(messageSnapshot);
                return;
            case (byte) 7:
                this.c.b(messageSnapshot);
                return;
            default:
                return;
        }
    }

    public final void c() {
        if (j.a) {
            j.f(this, "filedownloader:lifecycle:start %s by %d ", toString(), Byte.valueOf(this.d));
        }
    }

    public final void d() {
        int i = 0;
        if (j.a) {
            j.f(this, "filedownloader:lifecycle:over %s by %d ", toString(), Byte.valueOf(this.d));
        }
        if (this.a.L() != null) {
            ArrayList arrayList = (ArrayList) this.a.L().clone();
            int size = arrayList.size();
            while (i < size) {
                arrayList.get(i);
                i++;
            }
        }
        as.a().i().b(this.a.K());
    }

    o(x xVar) {
        this.a = xVar;
        Object arVar = new ar();
        this.f = arVar;
        this.g = arVar;
        this.c = new v(xVar.K(), this);
    }

    public final void e() {
        boolean z = true;
        at K = this.a.K();
        aa M = K.M();
        this.b = true;
        if (j.a) {
            j.f(this, "call start Url[%s], Path[%s] Listener[%s], Tag[%s]", M.f(), M.i(), M.m(), M.w());
        }
        try {
            File file;
            aa M2 = this.a.K().M();
            if (M2.i() == null) {
                M2.a(b.a(M2.f()));
                if (j.a) {
                    j.d(this, "save Path is null to %s", M2.i());
                }
            }
            if (M2.j()) {
                file = new File(M2.i());
            } else {
                String i = b.i(M2.i());
                if (i == null) {
                    throw new InvalidParameterException(b.a("the provided mPath[%s] is invalid, can't find its directory", M2.i()));
                }
                file = new File(i);
            }
            if (!file.exists()) {
                file.mkdirs();
            }
        } catch (Throwable th) {
            ak.a.b(K);
            ak.a.a(K, a(th));
            z = false;
        }
        if (z) {
            z.a.a(this);
        }
    }

    public final boolean f() {
        at K = this.a.K();
        aa M = K.M();
        if (this.d < (byte) 0) {
            int i = 1;
        } else {
            boolean z = false;
        }
        if (i == 0) {
            z.a.a((an) this);
            a((byte) -2);
            as.a();
            if (as.f()) {
                n.a.a(M.e());
            } else if (j.a) {
                j.d(this, "request pause the task[%d] to the download service, but the download service isn't connected yet.", Integer.valueOf(M.e()));
            }
            ak.a.b(K);
            ak.a.a(K, com.uc.quark.filedownloader.message.d.b(M));
            as.a().i().b(K);
            return true;
        } else if (!j.a) {
            return false;
        } else {
            j.d(this, "High concurrent cause, Already is over, can't pause again, %d %d", Byte.valueOf(this.d), Integer.valueOf(M.e()));
            return false;
        }
    }

    public final byte g() {
        return this.d;
    }

    public final long a() {
        return this.g.a();
    }

    public final long h() {
        return this.h;
    }

    public final long i() {
        return this.i;
    }

    public final Throwable j() {
        return this.e;
    }

    public final int k() {
        return this.j;
    }

    public final boolean l() {
        return this.k;
    }

    public final boolean m() {
        return this.b;
    }

    private void a(byte b) {
        if (b > (byte) 7 || b < (byte) -5) {
            throw new RuntimeException(b.a("mStatus undefined, %d", Byte.valueOf(b)));
        } else {
            this.d = b;
        }
    }

    private int o() {
        return this.a.K().M().e();
    }

    public final void n() {
        at K = this.a.K();
        aa M = K.M();
        c i = as.a().i();
        try {
            ak.a.b(K);
            if (e.a(M.e(), M.l(), M.t(), true, M.v(), false)) {
                as.a();
                as.e();
            } else if (n.a.a(M.f(), M.i(), M.j(), M.g(), M.h(), M.x(), M.t(), this.a.H(), M.B(), M.C(), M.D(), M.F(), M.G())) {
                i.b(K);
            } else {
                MessageSnapshot a = a(new RuntimeException("Occur Unknow Error, when request to start maybe some problem in binder, maybe the process was killed in unexpected."));
                if (!ak.a.a(K)) {
                    i.b(K);
                    ak.a.b(K);
                }
                ak.a.a(K, a);
            }
        } catch (Throwable th) {
            ak.a.a(K, a(th));
        }
    }
}
