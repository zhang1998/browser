package com.ucpro.business.a.b.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.bc;
import com.uc.imagecodec.export.IPictureView;
import com.uc.webview.export.extension.UCCore;
import com.ucweb.common.util.d;
import com.ucweb.common.util.h.m;
import com.ucweb.common.util.k.a;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: ProGuard */
public final class h extends FrameLayout implements c {
    public LottieAnimationView a;
    public int b;
    public int c;
    public int d;
    private String e;
    private String f;
    private String g;
    private int h = 160;
    private int i = 0;
    private int j = 0;
    private int k = 0;
    private int l = 0;
    private boolean m = true;
    private final Map<String, Bitmap> n = new HashMap();
    private final Map<String, Bitmap> o = new HashMap();
    private boolean p = true;
    private float q = 0.0f;
    private long r = 0;

    public h(Context context) {
        super(context);
        c();
    }

    private void c() {
        this.a = new a(this, getContext());
        this.a.setImageAssetDelegate(new d(this));
        addView(this.a, new LayoutParams(-1, -1));
        a(this.g, this.h);
    }

    public final void a() {
        float progress = this.a.getProgress();
        removeAllViews();
        c();
        this.n.clear();
        this.o.clear();
        a(progress, 1000);
    }

    private Bitmap a(bc bcVar, boolean z) {
        Bitmap bitmap;
        String str;
        if (z) {
            bitmap = (Bitmap) this.o.get(bcVar.a);
            str = this.f;
        } else {
            bitmap = (Bitmap) this.n.get(bcVar.a);
            str = this.e;
        }
        if (bitmap != null) {
            return bitmap;
        }
        try {
            Options options = new Options();
            options.inScaled = true;
            options.inDensity = this.h;
            bitmap = BitmapFactory.decodeFile(str + "/" + bcVar.b, options);
            if (z) {
                this.o.put(bcVar.a, bitmap);
                return bitmap;
            }
            this.n.put(bcVar.a, bitmap);
            return bitmap;
        } catch (Throwable th) {
            return null;
        }
    }

    public final boolean b() {
        boolean z = true;
        if (TextUtils.isEmpty(this.g)) {
            this.p = false;
        } else {
            boolean z2 = this.p && a.h(this.g);
            this.p = z2;
        }
        if (!TextUtils.isEmpty(this.e)) {
            if (!(this.p && a.h(this.e))) {
                z = false;
            }
            this.p = z;
        }
        return this.p;
    }

    public final void setImagePath(String str) {
        this.e = str;
    }

    public final void setImageNightPath(String str) {
        this.f = str;
    }

    public final void setDataPath(String str) {
        this.g = str;
    }

    public final void a(String str, int i) {
        this.g = str;
        this.h = i;
        try {
            this.a.a(new JSONObject(a.g(new File(str))), i);
        } catch (Throwable th) {
        }
        if (!TextUtils.isEmpty(this.g)) {
            int hashCode = this.g.hashCode();
            if (com.ucweb.common.util.j.a.b(d.a(), "CCB980D06D447B10", "E8BE1E105DB23118", 0) != hashCode) {
                com.ucweb.common.util.j.a.a(d.a(), "CCB980D06D447B10", "E8BE1E105DB23118", hashCode);
                com.ucweb.common.util.j.a.a(d.a(), "CCB980D06D447B10", "552C5455B01FAF53", 0);
                return;
            }
            this.l = com.ucweb.common.util.j.a.b(d.a(), "CCB980D06D447B10", "552C5455B01FAF53", 0);
        }
    }

    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.n.clear();
        this.o.clear();
    }

    protected final void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            if (this.j == 1) {
                if (!this.m) {
                    this.a.d();
                    this.a.setProgress(IPictureView.DEFAULT_MIN_SCALE);
                }
            } else if (this.j == 2 && !this.a.a()) {
                this.a.setProgress(this.q);
                this.a.c();
            }
            this.m = false;
        } else if (this.a.a()) {
            this.q = this.a.getProgress();
            this.a.d();
        }
    }

    public final void a(int i, int i2) {
        this.b = com.ucweb.common.util.h.a(i);
        this.c = com.ucweb.common.util.h.a(i2);
    }

    public final void setInsetBottom(int i) {
        if (i != -1) {
            i = com.ucweb.common.util.h.a(i);
        }
        this.d = i;
    }

    public final int getInsetBottom() {
        return this.d;
    }

    protected final void onMeasure(int i, int i2) {
        if (!(this.b == 0 || this.c == 0)) {
            i = MeasureSpec.makeMeasureSpec(this.b, UCCore.VERIFY_POLICY_QUICK);
            i2 = MeasureSpec.makeMeasureSpec(this.c, UCCore.VERIFY_POLICY_QUICK);
        }
        super.onMeasure(i, i2);
    }

    public final void setLoopTimes(int i) {
        this.i = i;
    }

    public final void setTriggrType(int i) {
        this.j = i;
    }

    public final void setPlayTimes(int i) {
        this.k = i;
    }

    public final void a(float f, long j) {
        this.a.a(true);
        this.a.setProgress(f);
        if (j <= 0) {
            this.a.b();
        } else {
            m.a(2, new f(this), j);
        }
    }

    static /* synthetic */ boolean a(h hVar) {
        long currentTimeMillis = System.currentTimeMillis();
        if (hVar.r == 0 || currentTimeMillis - hVar.r > 500) {
            hVar.l++;
            hVar.r = currentTimeMillis;
        }
        if (hVar.k <= 0) {
            return false;
        }
        if (hVar.l > hVar.k) {
            return true;
        }
        m.a(0, new e(hVar));
        return false;
    }

    static /* synthetic */ Bitmap a(h hVar, bc bcVar) {
        if (com.ucpro.ui.c.a.b()) {
            if (!TextUtils.isEmpty(hVar.f)) {
                return hVar.a(bcVar, true);
            }
            if (TextUtils.isEmpty(hVar.e)) {
                return null;
            }
            return hVar.a(bcVar, false);
        } else if (TextUtils.isEmpty(hVar.e)) {
            return null;
        } else {
            return hVar.a(bcVar, false);
        }
    }
}
