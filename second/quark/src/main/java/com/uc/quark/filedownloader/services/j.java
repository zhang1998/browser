package com.uc.quark.filedownloader.services;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.uc.quark.filedownloader.a;
import com.uc.quark.filedownloader.am;
import com.uc.quark.filedownloader.b.b;
import com.uc.quark.filedownloader.b.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: ProGuard */
public abstract class j<CALLBACK extends Binder, INTERFACE extends IInterface> implements ServiceConnection, am {
    public volatile INTERFACE a;
    private final CALLBACK b;
    private final Class<?> c;
    private final HashMap<String, Object> d = new HashMap();
    private final List<Context> e = new ArrayList();
    private final ArrayList<Runnable> f = new ArrayList();

    public abstract CALLBACK a();

    public abstract INTERFACE a(IBinder iBinder);

    public abstract void a(INTERFACE interfaceR, CALLBACK callback) throws RemoteException;

    public abstract void b(INTERFACE interfaceR, CALLBACK callback) throws RemoteException;

    public j(Class<?> cls) {
        this.c = cls;
        this.b = a();
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.a = a(iBinder);
        if (com.uc.quark.filedownloader.e.j.a) {
            com.uc.quark.filedownloader.e.j.d(this, "onServiceConnected %s %s", componentName, this.a);
        }
        try {
            a(this.a, this.b);
        } catch (RemoteException e) {
        }
        List<Runnable> list = (List) this.f.clone();
        this.f.clear();
        for (Runnable run : list) {
            run.run();
        }
        a.a().b(new b(e.a, this.c));
    }

    public void onServiceDisconnected(ComponentName componentName) {
        if (com.uc.quark.filedownloader.e.j.a) {
            com.uc.quark.filedownloader.e.j.d(this, "onServiceDisconnected %s %s", componentName, this.a);
        }
        b(true);
    }

    private void b(boolean z) {
        if (!(z || this.a == null)) {
            try {
                b(this.a, this.b);
            } catch (RemoteException e) {
            }
        }
        if (com.uc.quark.filedownloader.e.j.a) {
            com.uc.quark.filedownloader.e.j.d(this, "release connect resources %s", this.a);
        }
        this.a = null;
        a.a().b(new b(e.b, this.c));
    }

    public final void a(Context context) {
        a(context, null);
    }

    public final void a(Context context, Runnable runnable) {
        if (com.uc.quark.filedownloader.e.b.a(context)) {
            throw new IllegalStateException("Fatal-Exception: You can't bind the FileDownloadService in :filedownloader process.\n It's the invalid operation, and is likely to cause unexpected problems.\n Maybe you want to use non-separate process mode for FileDownloader.");
        }
        if (com.uc.quark.filedownloader.e.j.a) {
            com.uc.quark.filedownloader.e.j.d(this, "bindStartByContext %s", context.getClass().getSimpleName());
        }
        Intent intent = new Intent(context, this.c);
        if (!(runnable == null || this.f.contains(runnable))) {
            this.f.add(runnable);
        }
        if (!this.e.contains(context)) {
            this.e.add(context);
        }
        try {
            context.bindService(intent, this, 1);
            context.startService(intent);
        } catch (Exception e) {
        }
    }

    public final void b(Context context) {
        if (this.e.contains(context)) {
            if (com.uc.quark.filedownloader.e.j.a) {
                com.uc.quark.filedownloader.e.j.d(this, "unbindByContext %s", context);
            }
            this.e.remove(context);
            if (this.e.isEmpty()) {
                b(false);
            }
            try {
                Intent intent = new Intent(context, this.c);
                context.unbindService(this);
                context.stopService(intent);
            } catch (Exception e) {
            }
        }
    }

    public final boolean d() {
        return this.a != null;
    }
}
