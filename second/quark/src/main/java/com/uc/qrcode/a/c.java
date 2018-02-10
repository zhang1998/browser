package com.uc.qrcode.a;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Build.VERSION;
import android.os.Handler;
import com.google.zxing.PlanarYUVLuminanceSource;
import com.google.zxing.client.android.camera.CameraConfigurationUtils;
import com.uc.qrcode.a.a.b;
import com.uc.qrcode.b.a;

/* compiled from: ProGuard */
public final class c {
    public static final String a = c.class.getSimpleName();
    static final int q;
    public final Object b = new Object();
    public final b c;
    public b d;
    public Rect e;
    public Rect f;
    public boolean g;
    public boolean h;
    public int i = -1;
    public int j;
    public int k;
    public int l;
    public int m;
    public final boolean n;
    public final d o;
    public final a p;
    private final Context r;
    private int s;
    private int t;
    private byte[] u;
    private byte[] v;

    static {
        int parseInt;
        try {
            parseInt = Integer.parseInt(VERSION.SDK);
        } catch (NumberFormatException e) {
            parseInt = 10000;
        }
        q = parseInt;
    }

    public c(Context context) {
        this.r = context;
        this.s = (int) (((double) context.getResources().getDisplayMetrics().widthPixels) * 0.6d);
        this.t = (int) (((double) context.getResources().getDisplayMetrics().widthPixels) * 0.6d);
        this.c = new b(context);
        this.n = Integer.parseInt(VERSION.SDK) > 3;
        this.o = new d(this.c, this.n);
        this.p = new a();
    }

    public final boolean a() {
        boolean z;
        synchronized (this.b) {
            z = this.d != null;
        }
        return z;
    }

    public final void b() {
        synchronized (this.b) {
            if (this.d != null && this.h) {
                this.d.a.stopPreview();
                this.o.a(null, 0);
                this.p.a(null, 0);
                this.h = false;
            }
        }
    }

    public final void a(boolean z) {
        boolean z2 = false;
        synchronized (this.b) {
            b bVar = this.d;
            if (bVar != null) {
                Camera camera = bVar.a;
                if (camera != null) {
                    Parameters parameters = camera.getParameters();
                    if (parameters != null) {
                        String flashMode = parameters.getFlashMode();
                        if (flashMode != null && ("on".equals(flashMode) || "torch".equals(flashMode))) {
                            z2 = true;
                        }
                    }
                }
                if (z != z2) {
                    Camera camera2 = bVar.a;
                    Parameters parameters2 = camera2.getParameters();
                    CameraConfigurationUtils.setTorch(parameters2, z);
                    if (!a.KEY_DISABLE_EXPOSURE.r) {
                        CameraConfigurationUtils.setBestExposure(parameters2, z);
                    }
                    camera2.setParameters(parameters2);
                }
            }
        }
    }

    public final void a(Handler handler) {
        synchronized (this.b) {
            b bVar = this.d;
            if (bVar != null && this.h) {
                this.o.a(handler, 21);
                if (this.n) {
                    bVar.a.setOneShotPreviewCallback(this.o);
                } else {
                    bVar.a.setPreviewCallback(this.o);
                }
            }
        }
    }

    public final void b(Handler handler) {
        synchronized (this.b) {
            if (this.d != null && this.h) {
                this.p.a(handler, 23);
                this.d.a.autoFocus(this.p);
            }
        }
    }

    public final Rect c() {
        Rect rect = null;
        synchronized (this.b) {
            if (this.e == null) {
                if (this.d == null) {
                } else {
                    Point point = this.c.d;
                    if (point == null) {
                    } else {
                        int i = this.s;
                        int i2 = this.t;
                        int i3 = (point.x - i) / 2;
                        int i4 = (point.y - i2) / 2;
                        this.e = new Rect(i3 - this.m, i4 - this.l, (i + i3) - this.m, (i4 + i2) - this.l);
                        new StringBuilder("Calculated framing rect: ").append(this.e);
                    }
                }
            }
            rect = this.e;
        }
        return rect;
    }

    public final Rect d() {
        Rect rect = null;
        synchronized (this.b) {
            if (this.f == null) {
                Rect c = c();
                if (c == null) {
                } else {
                    Rect rect2 = new Rect(c);
                    Point point = this.c.e;
                    Point point2 = this.c.d;
                    if (point == null || point2 == null) {
                    } else {
                        int i = (rect2.top * point.x) / point2.y;
                        int i2 = (rect2.left * point.y) / point2.x;
                        int height = ((rect2.height() * point.x) / point2.y) + i;
                        int width = ((rect2.width() * point.y) / point2.x) + i2;
                        if (this.c.b == 270) {
                            height -= i;
                            i = (point.x - i) - height;
                            height += i;
                        }
                        rect2.left = i;
                        rect2.top = i2;
                        rect2.right = height;
                        rect2.bottom = width;
                        this.f = rect2;
                    }
                }
            }
            rect = this.f;
        }
        return rect;
    }

    public final PlanarYUVLuminanceSource a(byte[] bArr, int i) {
        PlanarYUVLuminanceSource planarYUVLuminanceSource;
        synchronized (this.b) {
            Rect d = d();
            if (d == null) {
                planarYUVLuminanceSource = null;
            } else {
                int height = d.height();
                int width = d.width();
                int i2 = height * width;
                if (this.u == null) {
                    this.u = new byte[i2];
                    this.v = new byte[i2];
                } else if (this.u.length < i2) {
                    this.u = new byte[i2];
                    this.v = new byte[i2];
                }
                int i3 = d.left + (d.top * i);
                if (i == width) {
                    System.arraycopy(bArr, i3, this.u, 0, i2);
                }
                i2 = i3;
                for (i3 = 0; i3 < height; i3++) {
                    System.arraycopy(bArr, i2, this.u, i3 * width, width);
                    i2 += i;
                }
                for (i2 = 0; i2 < height; i2++) {
                    for (i3 = 0; i3 < width; i3++) {
                        if ((i2 * width) + i3 >= this.u.length) {
                            break;
                        }
                        this.v[(((i3 * height) + height) - i2) - 1] = this.u[(i2 * width) + i3];
                    }
                }
                planarYUVLuminanceSource = new PlanarYUVLuminanceSource(this.v, height, width, 0, 0, height, width, false);
            }
        }
        return planarYUVLuminanceSource;
    }
}
