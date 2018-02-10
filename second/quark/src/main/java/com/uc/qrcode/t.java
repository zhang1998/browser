package com.uc.qrcode;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.hardware.Camera.Parameters;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.PlanarYUVLuminanceSource;
import com.google.zxing.R;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.uc.qrcode.a.c;
import com.uc.qrcode.c.a;
import com.ucweb.common.util.h.m;
import java.util.Collection;
import java.util.Map;

/* compiled from: ProGuard */
public class t extends FrameLayout implements Callback, a {
    private static final String f = t.class.getSimpleName();
    public boolean a = false;
    public SurfaceView b;
    public ViewfinderView c;
    public Activity d;
    public s e;
    private c g;
    private f h;
    private Result i;
    private b j;
    private a k = new a(this.d);
    private int l;
    private Collection<BarcodeFormat> m;
    private Map<DecodeHintType, ?> n;
    private String o;

    static /* synthetic */ void e() {
    }

    static /* synthetic */ void h(t tVar) {
        if (tVar.h == null) {
            tVar.i = null;
            return;
        }
        if (tVar.i != null) {
            tVar.h.sendMessage(Message.obtain(tVar.h, 18, tVar.i));
        }
        tVar.i = null;
    }

    public t(Activity activity) {
        super(activity, null);
        this.d = activity;
        this.d.getWindow().addFlags(128);
        if (getResources().getConfiguration().orientation == 1) {
            this.d.setRequestedOrientation(1);
        } else {
            this.d.setRequestedOrientation(0);
        }
        this.g = new c(this.d);
        this.c = new ViewfinderView(getContext(), null);
        this.c.b = this.g;
        this.h = null;
        this.l = j.d;
        this.b = new SurfaceView(this.d, null);
        addView(this.b, new LayoutParams(-1, -1));
        addView(this.c, new LayoutParams(-1, -1));
        b();
    }

    public final void b() {
        SurfaceHolder holder = this.b.getHolder();
        if (this.a) {
            a(holder);
            return;
        }
        holder.addCallback(this);
        holder.setType(3);
    }

    public void setText(String str) {
        ViewfinderView viewfinderView = this.c;
        viewfinderView.a = str;
        if (!TextUtils.isEmpty(str)) {
            viewfinderView.c.setTextSize((float) viewfinderView.f);
            viewfinderView.h = ((int) viewfinderView.c.measureText(str)) + 1;
        }
    }

    public void setTextSize(int i) {
        ViewfinderView viewfinderView = this.c;
        viewfinderView.f = i;
        if (!TextUtils.isEmpty(viewfinderView.a)) {
            viewfinderView.c.setTextSize((float) viewfinderView.f);
            viewfinderView.h = ((int) viewfinderView.c.measureText(viewfinderView.a)) + 1;
        }
    }

    public void setTextColor(int i) {
        this.c.e = i;
    }

    public void setTextMarginScanTop(int i) {
        this.c.g = i;
    }

    public void setLineHeight(int i) {
        this.c.d = i;
    }

    public void setInnerCornerLenght(int i) {
        this.c.j = i;
    }

    public void setInnerCornerWidth(int i) {
        this.c.k = i;
    }

    public void setInnerCornerColor(int i) {
        this.c.i = i;
    }

    public void setRawBeep(int i) {
        if (this.j == null) {
            this.j = new b(this.d);
        }
        this.j.a = i;
    }

    public final void c() {
        m.a(0, new o(this));
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                a(0);
                return true;
            case 24:
                this.g.a(true);
                return true;
            case 25:
                this.g.a(false);
                return true;
            case 27:
            case 80:
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (surfaceHolder == null) {
            Log.e(f, "*** WARNING *** surfaceCreated() gave us a null surface!");
        }
        if (!this.a) {
            this.a = true;
            a(surfaceHolder);
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.a = false;
        c();
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    public final void a(Result result, Bitmap bitmap, float f) {
        int i = 0;
        int i2 = bitmap != null ? 1 : 0;
        if (i2 != 0) {
            this.j.a();
            ResultPoint[] resultPoints = result.getResultPoints();
            if (resultPoints != null && resultPoints.length > 0) {
                Canvas canvas = new Canvas(bitmap);
                Paint paint = new Paint();
                paint.setColor(getResources().getColor(R.color.result_points));
                if (resultPoints.length == 2) {
                    paint.setStrokeWidth(4.0f);
                    a(canvas, paint, resultPoints[0], resultPoints[1], f);
                } else if (resultPoints.length == 4 && (result.getBarcodeFormat() == BarcodeFormat.UPC_A || result.getBarcodeFormat() == BarcodeFormat.EAN_13)) {
                    a(canvas, paint, resultPoints[0], resultPoints[1], f);
                    a(canvas, paint, resultPoints[2], resultPoints[3], f);
                } else {
                    paint.setStrokeWidth(10.0f);
                    int length = resultPoints.length;
                    while (i < length) {
                        ResultPoint resultPoint = resultPoints[i];
                        if (resultPoint != null) {
                            canvas.drawPoint(resultPoint.getX() * f, resultPoint.getY() * f, paint);
                        }
                        i++;
                    }
                }
            }
        }
        switch (r.a[this.l - 1]) {
            case 1:
            case 2:
                if (i2 != 0 && com.uc.qrcode.b.a.KEY_BULK_MODE.r) {
                    a(1000);
                }
                if (this.e != null) {
                    this.e.a(result);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final PlanarYUVLuminanceSource a(byte[] bArr, int i) {
        return this.g.a(bArr, i);
    }

    public int getCWNeededRotation() {
        return this.g.c.b;
    }

    public Parameters getCameraParamters() {
        return this.g.d.a.getParameters();
    }

    public Handler getScanHandler() {
        return this.h;
    }

    public ViewfinderView getViewfinderView() {
        return this.c;
    }

    private static void a(Canvas canvas, Paint paint, ResultPoint resultPoint, ResultPoint resultPoint2, float f) {
        if (resultPoint != null && resultPoint2 != null) {
            canvas.drawLine(f * resultPoint.getX(), f * resultPoint.getY(), f * resultPoint2.getX(), f * resultPoint2.getY(), paint);
        }
    }

    private void a(SurfaceHolder surfaceHolder) {
        if (surfaceHolder == null) {
            throw new IllegalStateException("No SurfaceHolder provided");
        } else if (this.g.a()) {
            Log.w(f, "initCamera() while already open -- late SurfaceView callback?");
        } else {
            m.a(0, new p(this, surfaceHolder), new q(this));
        }
    }

    private void a(long j) {
        if (this.h != null) {
            this.h.sendEmptyMessageDelayed(17, j);
        }
        this.c.setVisibility(0);
    }

    public final void a() {
        this.c.invalidate();
    }
}
