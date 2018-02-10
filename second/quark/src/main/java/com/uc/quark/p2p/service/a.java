package com.uc.quark.p2p.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: ProGuard */
public abstract class a<CALLBACK extends Binder, INTERFACE extends IInterface> implements ServiceConnection, c {
    volatile INTERFACE a;
    private final CALLBACK b;
    private final Class<?> c;
    private final HashMap<String, Object> d = new HashMap();
    private final List<Context> e = new ArrayList();
    private final ArrayList<Runnable> f = new ArrayList();

    protected abstract INTERFACE a(IBinder iBinder);

    protected abstract void a(INTERFACE interfaceR, CALLBACK callback) throws RemoteException;

    protected abstract CALLBACK b();

    protected a(Class<?> cls) {
        this.c = cls;
        this.b = b();
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.a = a(iBinder);
        try {
            a(this.a, this.b);
        } catch (RemoteException e) {
        }
        List<Runnable> list = (List) this.f.clone();
        this.f.clear();
        for (Runnable run : list) {
            run.run();
        }
    }

    public final void a(Context context, Runnable runnable) {
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

    public void onServiceDisconnected(ComponentName componentName) {
        this.a = null;
    }

    public final boolean a() {
        return this.a != null;
    }
}
