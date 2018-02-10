package com.bumptech.glide.c;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.FragmentManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.be;
import android.support.v4.d.b;
import android.util.Log;
import android.view.View;
import com.bumptech.glide.c;
import com.bumptech.glide.u;
import com.bumptech.glide.util.l;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public final class q implements Callback {
    private static final p i = new o();
    final Map<FragmentManager, n> a = new HashMap();
    final Map<be, u> b = new HashMap();
    private volatile u c;
    private final Handler d;
    private final p e;
    private final b<View, Fragment> f = new b();
    private final b<View, android.app.Fragment> g = new b();
    private final Bundle h = new Bundle();

    public q(@Nullable p pVar) {
        if (pVar == null) {
            pVar = i;
        }
        this.e = pVar;
        this.d = new Handler(Looper.getMainLooper(), this);
    }

    private u b(Context context) {
        if (this.c == null) {
            synchronized (this) {
                if (this.c == null) {
                    this.c = this.e.a(c.a(context), new b(), new i());
                }
            }
        }
        return this.c;
    }

    public final u a(Context context) {
        Context context2 = context;
        while (context2 != null) {
            if (l.c() && !(context2 instanceof Application)) {
                if (context2 instanceof FragmentActivity) {
                    context2 = (FragmentActivity) context2;
                    if (l.d()) {
                        context2 = context2.getApplicationContext();
                    } else {
                        b((Activity) context2);
                        u a = a(context2.b.a.e);
                        u uVar = a.c;
                        if (uVar != null) {
                            return uVar;
                        }
                        u a2 = this.e.a(c.a(context2), a.a, a.b);
                        a.c = a2;
                        return a2;
                    }
                } else if (context2 instanceof Activity) {
                    return a((Activity) context2);
                } else {
                    if (context2 instanceof ContextWrapper) {
                        context2 = ((ContextWrapper) context2).getBaseContext();
                    }
                }
            }
            return b(context2);
        }
        throw new IllegalArgumentException("You cannot start a load on a null Context");
    }

    public final u a(Activity activity) {
        if (l.d()) {
            return a(activity.getApplicationContext());
        }
        b(activity);
        n a = a(activity.getFragmentManager());
        u uVar = a.c;
        if (uVar != null) {
            return uVar;
        }
        uVar = this.e.a(c.a((Context) activity), a.a, a.b);
        a.c = uVar;
        return uVar;
    }

    @TargetApi(17)
    private static void b(Activity activity) {
        if (VERSION.SDK_INT >= 17 && activity.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    @TargetApi(17)
    final n a(FragmentManager fragmentManager) {
        n nVar = (n) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (nVar != null) {
            return nVar;
        }
        nVar = (n) this.a.get(fragmentManager);
        if (nVar != null) {
            return nVar;
        }
        android.app.Fragment nVar2 = new n();
        nVar2.d = null;
        this.a.put(fragmentManager, nVar2);
        fragmentManager.beginTransaction().add(nVar2, "com.bumptech.glide.manager").commitAllowingStateLoss();
        this.d.obtainMessage(1, fragmentManager).sendToTarget();
        return nVar2;
    }

    final u a(be beVar) {
        u uVar = (u) beVar.a("com.bumptech.glide.manager");
        if (uVar != null) {
            return uVar;
        }
        uVar = (u) this.b.get(beVar);
        if (uVar != null) {
            return uVar;
        }
        Fragment uVar2 = new u();
        uVar2.d = null;
        this.b.put(beVar, uVar2);
        beVar.a().a(uVar2, "com.bumptech.glide.manager").b();
        this.d.obtainMessage(2, beVar).sendToTarget();
        return uVar2;
    }

    public final boolean handleMessage(Message message) {
        Object obj = null;
        boolean z = true;
        Object remove;
        switch (message.what) {
            case 1:
                FragmentManager fragmentManager = (FragmentManager) message.obj;
                remove = this.a.remove(fragmentManager);
                break;
            case 2:
                be beVar = (be) message.obj;
                remove = this.b.remove(beVar);
                break;
            default:
                z = false;
                remove = null;
                break;
        }
        if (z && r1 == null && Log.isLoggable("RMRetriever", 5)) {
            Log.w("RMRetriever", "Failed to remove expected request manager fragment, manager: " + obj);
        }
        return z;
    }
}
