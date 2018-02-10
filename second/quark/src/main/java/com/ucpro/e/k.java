package com.ucpro.e;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.ucpro.base.a;
import com.ucpro.base.e.b;
import com.ucpro.base.e.f;
import com.ucweb.common.util.c;
import hugo.weaving.DebugLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public final class k {
    public Activity a;
    public List<WeakReference<a>> b = new ArrayList();
    public h c;
    public b d;
    public f e;
    public com.ucpro.base.c.b f;
    public o g;
    public BroadcastReceiver h;
    public boolean i;
    boolean j = true;
    public OnPreDrawListener k = new m(this);
    public Runnable l = new b(this);

    public k(Activity activity) {
        this.a = activity;
    }

    @DebugLog
    public final void a(Intent intent, boolean z) {
        Object obj = 1;
        c.a((Object) intent);
        if (intent != null) {
            if (this.g == null) {
                this.g = new o(this);
            }
            o oVar = this.g;
            c.a((Object) intent);
            if (intent != null) {
                if (o.a(intent)) {
                    Log.w("Intent", "block intent attack :" + intent);
                } else {
                    c.a((Object) intent);
                    if (!"android.intent.action.MAIN".equalsIgnoreCase(intent.getAction())) {
                        Object obj2;
                        c.a((Object) intent);
                        Uri data = intent.getData();
                        if ("android.intent.action.VIEW".equalsIgnoreCase(intent.getAction()) && data != null && data.toString().equalsIgnoreCase("http://wap.ucweb.com?flag=set_default_browser")) {
                            obj2 = 1;
                        } else {
                            obj2 = null;
                        }
                        if (obj2 == null) {
                            obj = null;
                        }
                    }
                    if (obj != null) {
                        new StringBuilder("intent: ").append(intent).append(" intercepted");
                    } else {
                        oVar.a = intent;
                    }
                }
            }
            if (z) {
                this.g.a();
            }
        }
    }

    public final void a(int i) {
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            WeakReference weakReference = (WeakReference) this.b.get(i2);
            if (weakReference.get() != null) {
                switch (i) {
                    case 1:
                        weakReference.get();
                        break;
                    case 2:
                        ((a) weakReference.get()).b();
                        break;
                    case 3:
                        ((a) weakReference.get()).a();
                        break;
                    case 4:
                        weakReference.get();
                        break;
                    case 5:
                        ((a) weakReference.get()).c();
                        break;
                    default:
                        c.a();
                        break;
                }
            }
        }
    }
}
