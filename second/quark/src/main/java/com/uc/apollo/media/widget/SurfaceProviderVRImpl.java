package com.uc.apollo.media.widget;

import android.app.Activity;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.View;
import android.widget.FrameLayout;
import com.c.a.a.e;
import com.c.a.ad;
import com.c.a.b.a.l;
import com.c.a.b.c;
import com.c.a.b.c.d;
import com.c.a.b.c.h;
import com.c.a.b.c.k;
import com.c.a.f;
import com.c.a.g;
import com.c.a.m;
import com.c.a.n;
import com.c.a.y;
import com.uc.apollo.Settings;
import com.uc.apollo.annotation.KeepForSdk;
import java.lang.ref.WeakReference;
import java.util.Iterator;

/* compiled from: ProGuard */
final class SurfaceProviderVRImpl extends com.uc.apollo.media.widget.SurfaceProvider.b implements Callback {
    com.uc.apollo.media.widget.SurfaceProvider.a b;
    FrameLayout c;
    Surface d;
    private GLSurfaceView e;
    private f f;
    private Context g;
    private Handler h = new b(this);

    @KeepForSdk
    /* compiled from: ProGuard */
    class CustomProjectionFactory implements k {
        public static final int CUSTOM_PROJECTION_FISH_EYE_RADIUS_VERTICAL = 9611;

        CustomProjectionFactory() {
        }

        public h createStrategy(int i) {
            switch (i) {
                case CUSTOM_PROJECTION_FISH_EYE_RADIUS_VERTICAL /*9611*/:
                    return new d(0.745f, com.c.a.e.a.b);
                default:
                    return null;
            }
        }
    }

    /* compiled from: ProGuard */
    final class a extends FrameLayout {
        SurfaceProviderVRImpl a;

        public a(Context context, SurfaceProviderVRImpl surfaceProviderVRImpl) {
            super(context);
            this.a = surfaceProviderVRImpl;
        }

        protected final void onAttachedToWindow() {
            super.onAttachedToWindow();
            SurfaceProviderVRImpl.a(this.a);
        }

        protected final void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            SurfaceProviderVRImpl.b(this.a);
        }

        public final void setVisibility(int i) {
            super.setVisibility(i);
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                getChildAt(0).setVisibility(i);
            }
        }
    }

    /* compiled from: ProGuard */
    final class b extends Handler {
        WeakReference<SurfaceProviderVRImpl> a;

        b(SurfaceProviderVRImpl surfaceProviderVRImpl) {
            super(Looper.getMainLooper());
            this.a = new WeakReference(surfaceProviderVRImpl);
        }

        public final void handleMessage(Message message) {
            SurfaceProviderVRImpl surfaceProviderVRImpl = (SurfaceProviderVRImpl) this.a.get();
            if (surfaceProviderVRImpl != null) {
                switch (message.what) {
                    case 1:
                        surfaceProviderVRImpl.a((Surface) message.obj);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    static /* synthetic */ void a(SurfaceProviderVRImpl surfaceProviderVRImpl) {
        if (surfaceProviderVRImpl.e == null) {
            surfaceProviderVRImpl.e = new GLSurfaceView(surfaceProviderVRImpl.g);
            surfaceProviderVRImpl.e.getHolder().addCallback(surfaceProviderVRImpl);
            surfaceProviderVRImpl.c.addView(surfaceProviderVRImpl.e, -1, -1);
        }
        ad adVar = new ad((Activity) surfaceProviderVRImpl.g);
        adVar.a = 101;
        adVar.b = 4;
        adVar.c = 201;
        adVar.f = new com.c.a.c.a(new m(surfaceProviderVRImpl));
        adVar.e = 0;
        adVar.g = new l(surfaceProviderVRImpl);
        adVar.i = true;
        n mVar = new m(surfaceProviderVRImpl.e);
        com.c.a.e.f.a(adVar.f, "You must call video/bitmap function before build");
        if (adVar.n == null) {
            adVar.n = new g();
        }
        if (adVar.k == null) {
            adVar.k = new e();
        }
        if (adVar.s == null) {
            adVar.s = new com.c.a.a.b();
        }
        adVar.q = mVar;
        surfaceProviderVRImpl.f = new f(adVar);
    }

    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (this.f != null) {
            this.f.a(this.g);
        }
    }

    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        if (this.f != null) {
            f fVar = this.f;
            Context context = this.g;
            c cVar = fVar.a;
            cVar.a = false;
            if (((l) cVar.e).c((Activity) context)) {
                ((l) cVar.e).b(context);
            }
            if (fVar.e != null) {
                fVar.e.d();
            }
        }
    }

    public final void showMini() {
        if (this.c != null) {
            this.c.setVisibility(4);
        }
    }

    static SurfaceProviderVRImpl c() {
        Context activity = Settings.getActivity();
        if (activity == null) {
            return null;
        }
        return new SurfaceProviderVRImpl(activity);
    }

    private SurfaceProviderVRImpl(Context context) {
        this.g = context;
        this.c = new a(context, this);
    }

    final void a() {
    }

    final void b() {
    }

    public final View asView() {
        return this.c;
    }

    final void a(Surface surface) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                ((SurfaceListener) it.next()).surfaceCreated(surface);
            }
            this.f.a(this.g);
            synchronized (this) {
                notify();
            }
            return;
        }
        this.h.obtainMessage(1, surface).sendToTarget();
        synchronized (this) {
            try {
                wait(2000);
            } catch (Throwable th) {
            }
        }
    }

    public final boolean execCommand(int i, int i2, int i3, Object obj) {
        if (i == 110 && this.f != null) {
            String[] strArr = (String[]) obj;
            f fVar;
            if ("ro.instance.vr_display_mode".equals(strArr[0])) {
                fVar = this.f;
                fVar.b.b((Activity) this.g, Integer.parseInt(strArr[1]));
            } else if ("ro.instance.vr_projection_mode".equals(strArr[0])) {
                fVar = this.f;
                fVar.c.b((Activity) this.g, Integer.parseInt(strArr[1]));
            }
        }
        return false;
    }

    public final void setOnInfoListener(com.uc.apollo.media.widget.SurfaceProvider.a aVar) {
        this.b = aVar;
    }

    static /* synthetic */ void b(SurfaceProviderVRImpl surfaceProviderVRImpl) {
        Iterator it = surfaceProviderVRImpl.a.iterator();
        while (it.hasNext()) {
            ((SurfaceListener) it.next()).surfaceDestroyed(surfaceProviderVRImpl.d);
        }
        f fVar = surfaceProviderVRImpl.f;
        fVar.h.a(new y(fVar));
        fVar.h.a = true;
        surfaceProviderVRImpl.c.removeAllViews();
        surfaceProviderVRImpl.e = null;
    }
}
