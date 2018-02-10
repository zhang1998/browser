package com.uc.quark.filedownloader;

import android.app.Notification;
import android.os.Binder;
import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.uc.quark.filedownloader.c.b;
import com.uc.quark.filedownloader.e.d;
import com.uc.quark.filedownloader.model.FileDownloadHeader;
import com.uc.quark.filedownloader.services.FileDownloadService.SeparateProcessService;
import com.uc.quark.filedownloader.services.j;

/* compiled from: ProGuard */
final class ag extends j<af, b> {
    protected final /* bridge */ /* synthetic */ void b(IInterface iInterface, Binder binder) throws RemoteException {
        ((b) iInterface).b((af) binder);
    }

    ag() {
        super(SeparateProcessService.class);
    }

    public final boolean a(String str, String str2, boolean z, int i, int i2, int i3, boolean z2, FileDownloadHeader fileDownloadHeader, boolean z3, String str3, int i4, long j, String str4) {
        if (!d()) {
            return d.a(str, str2, z);
        }
        try {
            ((b) this.a).a(str, str2, z, i, i2, i3, z2, fileDownloadHeader, z3, str3, i4, j, str4);
            return true;
        } catch (RemoteException e) {
            return false;
        } catch (NullPointerException e2) {
            return false;
        }
    }

    public final boolean a(int i) {
        if (!d()) {
            return d.a(i);
        }
        try {
            return ((b) this.a).a(i);
        } catch (RemoteException e) {
            return false;
        } catch (NullPointerException e2) {
            return false;
        }
    }

    public final long b(int i) {
        if (!d()) {
            return d.b(i);
        }
        try {
            return ((b) this.a).c(i);
        } catch (RemoteException e) {
            Log.e("vanda", "getSofar RemoteException" + e);
            return 0;
        } catch (NullPointerException e2) {
            return 0;
        }
    }

    public final long c(int i) {
        if (!d()) {
            return d.c(i);
        }
        try {
            return ((b) this.a).d(i);
        } catch (RemoteException e) {
            return 0;
        } catch (NullPointerException e2) {
            return 0;
        }
    }

    public final byte d(int i) {
        if (!d()) {
            return d.d(i);
        }
        try {
            return ((b) this.a).e(i);
        } catch (RemoteException e) {
            return (byte) 0;
        } catch (NullPointerException e2) {
            return (byte) 0;
        }
    }

    public final void b() {
        if (d()) {
            try {
                ((b) this.a).a();
                return;
            } catch (RemoteException e) {
                return;
            } catch (NullPointerException e2) {
                return;
            }
        }
        d.b();
    }

    public final boolean c() {
        if (!d()) {
            return d.c();
        }
        try {
            ((b) this.a).b();
        } catch (RemoteException e) {
        } catch (NullPointerException e2) {
        }
        return true;
    }

    public final void a(int i, Notification notification) {
        if (d()) {
            try {
                ((b) this.a).a(i, notification);
                return;
            } catch (RemoteException e) {
                return;
            } catch (NullPointerException e2) {
                return;
            }
        }
        d.a(i, notification);
    }

    public final void a(boolean z) {
        if (d()) {
            try {
                ((b) this.a).a(z);
                return;
            } catch (RemoteException e) {
                return;
            } catch (NullPointerException e2) {
                return;
            }
        }
        d.a(z);
    }

    public final boolean e(int i) {
        if (!d()) {
            return d.e(i);
        }
        try {
            return ((b) this.a).f(i);
        } catch (RemoteException e) {
            return false;
        } catch (NullPointerException e2) {
            return false;
        }
    }

    public final byte[] e() {
        if (!d()) {
            return new byte[0];
        }
        try {
            return ((b) this.a).e();
        } catch (RemoteException e) {
            return new byte[0];
        } catch (NullPointerException e2) {
            return new byte[0];
        }
    }

    public final void a(Bundle bundle) {
        if (bundle != null) {
            if (!d()) {
                d.d();
            }
            try {
                ((b) this.a).a(bundle);
            } catch (RemoteException e) {
            } catch (NullPointerException e2) {
            }
        }
    }

    public final void a(Bundle bundle, boolean z) {
        if (bundle != null) {
            if (!d()) {
                d.a();
            }
            try {
                ((b) this.a).a(bundle, z);
            } catch (RemoteException e) {
            } catch (NullPointerException e2) {
            }
        }
    }

    public final boolean f(int i) {
        try {
            return ((b) this.a).h(i);
        } catch (RemoteException e) {
            return false;
        } catch (NullPointerException e2) {
            return false;
        }
    }

    protected final /* synthetic */ Binder a() {
        return new af();
    }
}
