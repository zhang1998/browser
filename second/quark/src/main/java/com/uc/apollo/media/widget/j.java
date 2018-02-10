package com.uc.apollo.media.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import com.uc.apollo.base.ConfigFile;
import com.uc.apollo.media.MediaDefines;
import com.uc.apollo.media.widget.SurfaceProvider.c;
import com.uc.apollo.media.widget.SurfaceProvider.d;
import com.uc.imagecodec.export.IPictureView;
import com.uc.webview.export.extension.UCCore;
import java.lang.ref.WeakReference;
import java.util.Iterator;

/* compiled from: ProGuard */
public class j extends FrameLayout implements SurfaceProvider {
    protected int a;
    protected int b;
    protected boolean c;
    protected boolean d = true;
    protected boolean e = false;
    protected i f = new i();
    protected SurfaceProvider g;
    protected com.uc.apollo.media.widget.SurfaceProvider.a h;
    protected Handler i = new a(this);
    protected boolean j = true;

    /* compiled from: ProGuard */
    final class a extends Handler {
        WeakReference<j> a;

        a(j jVar) {
            super(Looper.getMainLooper());
            this.a = new WeakReference(jVar);
        }

        public final void handleMessage(Message message) {
            j jVar = (j) this.a.get();
            if (jVar != null) {
                switch (message.what) {
                    case 1:
                        if (jVar.h != null) {
                            jVar.h.onSurfaceInfo(message.arg1, message.arg2);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public static j a(Context context, boolean z) {
        j kVar;
        if (n.a()) {
            kVar = new k(context, z);
            if (ConfigFile.getVRType() != 1) {
                return kVar;
            }
            kVar.setVideoSize(0, 0);
            return kVar;
        }
        kVar = new j(context, z);
        kVar.setVideoSize(0, 0);
        return kVar;
    }

    protected j(Context context, boolean z) {
        super(context);
        this.c = z;
    }

    protected final void a() {
        if (this.g != null) {
            this.g.setOnInfoListener(null);
            this.g.asView().setVisibility(4);
            removeView(this.g.asView());
            this.g = null;
        }
    }

    public void setVideoSize(int i, int i2) {
        this.a = i;
        this.b = i2;
        if (getWindowToken() != null) {
            b();
            requestLayout();
        }
    }

    protected void b() {
        if (this.g == null) {
            SurfaceProvider dVar = (this.c && isHardwareAccelerated()) ? new d(getContext()) : new c(getContext());
            this.g = dVar;
            c();
        }
    }

    protected final void c() {
        if (this.g != null) {
            int i;
            addView(this.g.asView());
            Iterator it = this.f.iterator();
            while (it.hasNext()) {
                this.g.addListener((SurfaceListener) it.next());
            }
            if (!this.d) {
                this.g.hide();
            } else if (this.e) {
                this.g.showMini();
            } else {
                this.g.showNormal();
            }
            Handler handler = this.i;
            if (this.g instanceof SurfaceProviderVRImpl) {
                i = 1;
            } else {
                i = 0;
            }
            handler.obtainMessage(1, MediaDefines.MSG_ENABLE_VR_MODE, i).sendToTarget();
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.a != 0 && this.b != 0 && this.g == null) {
            b();
        }
    }

    public boolean execCommand(int i, int i2, int i3, Object obj) {
        if (i == 110 && obj != null) {
            String[] strArr = (String[]) obj;
            if (strArr[0].equals("ro.instance.vr_enable")) {
                this.j = Integer.parseInt(strArr[1]) != 0;
            }
        }
        if (this.g == null) {
            return false;
        }
        return this.g.execCommand(i, i2, i3, obj);
    }

    public View asView() {
        return this;
    }

    public void addListener(SurfaceListener surfaceListener) {
        this.f.add(surfaceListener);
        if (this.g != null) {
            this.g.addListener(surfaceListener);
        }
    }

    public void removeListener(SurfaceListener surfaceListener) {
        this.f.remove(surfaceListener);
        if (this.g != null) {
            this.g.removeListener(surfaceListener);
        }
    }

    public void addSurfaceListener(Object obj) {
        this.f.a(obj);
        if (this.g != null) {
            this.g.addSurfaceListener(obj);
        }
    }

    public void removeSurfaceListener(Object obj) {
        this.f.b(obj);
        if (this.g != null) {
            this.g.removeSurfaceListener(obj);
        }
    }

    public void show() {
        this.d = true;
        if (this.g != null) {
            this.g.show();
        }
    }

    public void hide() {
        this.d = false;
        if (this.g != null) {
            this.g.hide();
        }
    }

    public void showMini() {
        this.e = true;
        if (this.g != null) {
            this.g.showMini();
        }
    }

    public void showNormal() {
        this.e = false;
        if (this.g != null) {
            this.g.showNormal();
        }
    }

    public void clear() {
        a();
        b();
    }

    public void setOnInfoListener(com.uc.apollo.media.widget.SurfaceProvider.a aVar) {
        this.h = aVar;
    }

    protected void onMeasure(int i, int i2) {
        if (this.b <= 0 || this.a <= 0) {
            super.onMeasure(i, i2);
            return;
        }
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        int round = Math.round((((float) (this.b * size)) * IPictureView.DEFAULT_MIN_SCALE) / ((float) this.a));
        if (round > size2) {
            size = Math.round((((float) (this.a * size2)) * IPictureView.DEFAULT_MIN_SCALE) / ((float) this.b));
        } else {
            size2 = round;
        }
        super.onMeasure(MeasureSpec.makeMeasureSpec(size, UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(size2, UCCore.VERIFY_POLICY_QUICK));
    }
}
