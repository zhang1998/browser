package com.uc.apollo.media.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import com.alibaba.wireless.security.SecExceptionCode;
import com.uc.apollo.util.f;
import com.uc.webview.browser.interfaces.IWebResources;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* compiled from: ProGuard */
final class v extends u {
    private static SimpleDateFormat z = new SimpleDateFormat("HH:mm:ss ", Locale.getDefault());
    private int A;
    private Paint B;
    private Paint C;
    private Paint D;
    private Paint E;
    private Paint F;
    private int[] G;
    private int s;
    private Context t;
    private UCSurface u;
    private int v;
    private com.uc.apollo.media.impl.f.a w;
    private Handler x;
    private List<String> y;

    /* compiled from: ProGuard */
    final class a extends Thread {
        private WeakReference<v> a;

        a(v vVar) {
            this.a = new WeakReference(vVar);
        }

        public final void run() {
            v vVar = (v) this.a.get();
            if (vVar != null) {
                MediaPlayer mediaPlayer = new MediaPlayer();
                try {
                    if (vVar.f instanceof DataSourceURI) {
                        DataSourceURI dataSourceURI = (DataSourceURI) vVar.f;
                        if (dataSourceURI.headers != null) {
                            mediaPlayer.setDataSource(vVar.t, dataSourceURI.uri, dataSourceURI.headers);
                        } else {
                            mediaPlayer.setDataSource(vVar.t, dataSourceURI.uri);
                        }
                    } else {
                        DataSourceFD dataSourceFD = (DataSourceFD) vVar.f;
                        mediaPlayer.setDataSource(dataSourceFD.fd, dataSourceFD.offset, dataSourceFD.length);
                    }
                    mediaPlayer.setOnPreparedListener(new y(this));
                    mediaPlayer.setOnErrorListener(new z(this));
                    mediaPlayer.prepareAsync();
                } catch (Exception e) {
                }
            }
        }
    }

    /* compiled from: ProGuard */
    final class b {
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;
        public static final int d = 4;
        private static final /* synthetic */ int[] e = new int[]{a, b, c, d};
    }

    public final boolean b(String str, String str2) {
        super.b(str, str2);
        return false;
    }

    public final String a(String str) {
        return null;
    }

    public final int d() {
        return 3;
    }

    protected final void A() {
        b("start");
        if (this.q >= this.l) {
            this.q = 0;
        }
        if (!this.x.hasMessages(10)) {
            this.x.sendEmptyMessageDelayed(10, 600);
        }
        this.s = b.c;
        super.A();
    }

    public final boolean i() {
        return this.s == b.c;
    }

    protected final boolean D() {
        return this.s == b.c;
    }

    public final boolean j() {
        if (!super.j()) {
            return false;
        }
        b("pause");
        B();
        this.s = b.d;
        return true;
    }

    protected final void B() {
        if (this.x.hasMessages(10)) {
            this.x.removeMessages(10);
        }
    }

    public final boolean k() {
        if (!super.k()) {
            return false;
        }
        b("stop");
        j();
        this.s = b.a;
        return true;
    }

    public final void a(Context context, DataSource dataSource) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException {
        super.a(context, dataSource);
        if (dataSource instanceof DataSourceURI) {
            b("setDataSource(Context context, Uri uri, Map<String, String> headers)");
            this.t = context;
            if (this.f instanceof DataSourceURI) {
                String uri = ((DataSourceURI) this.f).uri.toString();
                if (uri.length() > 40) {
                    new StringBuilder("...").append(uri.substring(uri.length() - 40));
                }
            }
            new a(this).start();
            DataSourceURI dataSourceURI = (DataSourceURI) this.f;
            this.v = f.a(dataSourceURI.uri.toString(), dataSourceURI.headers, this.w, true);
        } else if (dataSource != null) {
            throw new AssertionError("unsupport dataSource " + dataSource);
        }
    }

    public final synchronized void a(Surface surface) {
        super.a(surface);
        if (this.u != null) {
            this.u.b();
            this.u = null;
        }
        if (surface != null) {
            try {
                this.u = new UCSurface(surface, this.o, this.p);
            } catch (Throwable th) {
            }
        }
        H();
        b("setSurface(Surface surface) " + surface);
    }

    public final void m() throws IllegalStateException {
        super.m();
        b("prepareAsync");
        this.x.sendEmptyMessage(2);
    }

    public final void n() {
        super.n();
        b("release");
    }

    public final boolean g(int i) throws IllegalStateException {
        if (!super.g(i)) {
            return false;
        }
        b("seekTo " + f.b(i));
        G();
        this.x.obtainMessage(3, i, 0).sendToTarget();
        return true;
    }

    protected final int C() {
        return this.q;
    }

    public final boolean v() {
        if (!super.v()) {
            return false;
        }
        b(IWebResources.TEXT_BTN_DEFAULT_RESET);
        return true;
    }

    public static v i(int i) {
        return new v(i);
    }

    @SuppressLint({"HandlerLeak"})
    private v(int i) {
        super(i, e.a, "MediaPlayerEmulator");
        this.s = b.a;
        this.w = new w(this);
        this.y = new ArrayList();
        this.A = 19;
        this.o = SecExceptionCode.SEC_ERROR_STA_KEY_ENC_INVALID_ENCRYPTED_DATA;
        this.p = 576;
        this.x = new x(this, Looper.getMainLooper());
        this.B = new Paint();
        this.B.setColor(-16776961);
        this.B.setStyle(Style.STROKE);
        this.B.setStrokeWidth(6.0f);
        this.C = new Paint();
        this.C.setColor(-65536);
        this.C.setStyle(Style.STROKE);
        this.C.setStrokeWidth(6.0f);
        this.D = new Paint();
        this.D.setColor(-6229776);
        this.D.setStyle(Style.STROKE);
        this.D.setStrokeWidth(2.0f);
        this.D.setPathEffect(new DashPathEffect(new float[]{5.0f, 5.0f}, 0.0f));
        this.E = new Paint();
        this.E.setAntiAlias(true);
        this.E.setColor(-16776961);
        this.E.setTextSize(32.0f);
        this.E.setTypeface(Typeface.create(Typeface.SANS_SERIF, 1));
        this.F = new Paint();
        this.F.setAntiAlias(true);
        this.F.setColor(-1);
        this.F.setTextSize(24.0f);
    }

    private synchronized void b(String str) {
        this.y.add(z.format(new Date()) + str);
        while (this.y.size() > this.A) {
            this.y.remove(0);
        }
        L();
    }

    private void a(Canvas canvas) {
        int i = 42;
        for (int i2 = 0; i2 < this.y.size(); i2++) {
            canvas.drawText((String) this.y.get(i2), 18.0f, (float) i, this.F);
            i += 24;
        }
    }

    private synchronized void L() {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Exception block dominator not found, method:com.uc.apollo.media.impl.v.L():void. bs: [B:15:0x001b, B:57:0x00aa]
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:86)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r8 = this;
        monitor-enter(r8);
        r0 = r8.u;	 Catch:{ all -> 0x0083 }
        if (r0 == 0) goto L_0x0091;	 Catch:{ all -> 0x0083 }
    L_0x0005:
        r0 = r8.u;	 Catch:{ all -> 0x0083 }
        if (r0 == 0) goto L_0x0011;	 Catch:{ all -> 0x0083 }
    L_0x0009:
        r0 = r8.u;	 Catch:{ all -> 0x0083 }
        r0 = r0.a();	 Catch:{ all -> 0x0083 }
        if (r0 != 0) goto L_0x0013;
    L_0x0011:
        monitor-exit(r8);
        return;
    L_0x0013:
        r0 = r8.u;	 Catch:{ all -> 0x0083 }
        r0 = r0.e();	 Catch:{ all -> 0x0083 }
        if (r0 == 0) goto L_0x0011;
    L_0x001b:
        r0 = r8.u;	 Catch:{ all -> 0x0086 }
        r0 = r0.c();	 Catch:{ all -> 0x0086 }
        if (r0 == 0) goto L_0x0079;	 Catch:{ all -> 0x0086 }
    L_0x0023:
        r0 = r8.u;	 Catch:{ all -> 0x0086 }
        r0 = r0.d();	 Catch:{ all -> 0x0086 }
        if (r0 == 0) goto L_0x0079;	 Catch:{ all -> 0x0086 }
    L_0x002b:
        r0 = r8.u;	 Catch:{ all -> 0x0086 }
        r0 = r0.c();	 Catch:{ all -> 0x0086 }
        r1 = r8.u;	 Catch:{ all -> 0x0086 }
        r1 = r1.d();	 Catch:{ all -> 0x0086 }
        r2 = android.graphics.Bitmap.Config.ARGB_8888;	 Catch:{ all -> 0x0086 }
        r0 = android.graphics.Bitmap.createBitmap(r0, r1, r2);	 Catch:{ all -> 0x0086 }
        r1 = new android.graphics.Canvas;	 Catch:{ all -> 0x0086 }
        r1.<init>(r0);	 Catch:{ all -> 0x0086 }
        r8.b(r1);	 Catch:{ all -> 0x0086 }
        r1 = r8.u;	 Catch:{ all -> 0x0086 }
        if (r1 == 0) goto L_0x0079;	 Catch:{ all -> 0x0086 }
    L_0x0049:
        r3 = r0.getWidth();	 Catch:{ all -> 0x0086 }
        r7 = r0.getHeight();	 Catch:{ all -> 0x0086 }
        r1 = r8.G;	 Catch:{ all -> 0x0086 }
        if (r1 == 0) goto L_0x005f;	 Catch:{ all -> 0x0086 }
    L_0x0055:
        r1 = r8.G;	 Catch:{ all -> 0x0086 }
        r1 = r1.length;	 Catch:{ all -> 0x0086 }
        r2 = r3 * r7;	 Catch:{ all -> 0x0086 }
        if (r1 == r2) goto L_0x005f;	 Catch:{ all -> 0x0086 }
    L_0x005c:
        r1 = 0;	 Catch:{ all -> 0x0086 }
        r8.G = r1;	 Catch:{ all -> 0x0086 }
    L_0x005f:
        r1 = r8.G;	 Catch:{ all -> 0x0086 }
        if (r1 != 0) goto L_0x0069;	 Catch:{ all -> 0x0086 }
    L_0x0063:
        r1 = r3 * r7;	 Catch:{ all -> 0x0086 }
        r1 = new int[r1];	 Catch:{ all -> 0x0086 }
        r8.G = r1;	 Catch:{ all -> 0x0086 }
    L_0x0069:
        r1 = r8.G;	 Catch:{ all -> 0x0086 }
        r2 = 0;	 Catch:{ all -> 0x0086 }
        r4 = 0;	 Catch:{ all -> 0x0086 }
        r5 = 0;	 Catch:{ all -> 0x0086 }
        r6 = r3;	 Catch:{ all -> 0x0086 }
        r0.getPixels(r1, r2, r3, r4, r5, r6, r7);	 Catch:{ all -> 0x0086 }
        r0 = r8.u;	 Catch:{ all -> 0x0086 }
        r1 = r8.G;	 Catch:{ all -> 0x0086 }
        r0.a(r1);	 Catch:{ all -> 0x0086 }
    L_0x0079:
        r0 = r8.u;	 Catch:{ all -> 0x0083 }
        if (r0 == 0) goto L_0x0011;	 Catch:{ all -> 0x0083 }
    L_0x007d:
        r0 = r8.u;	 Catch:{ all -> 0x0083 }
        r0.f();	 Catch:{ all -> 0x0083 }
        goto L_0x0011;
    L_0x0083:
        r0 = move-exception;
        monitor-exit(r8);
        throw r0;
    L_0x0086:
        r0 = move-exception;
        r1 = r8.u;	 Catch:{ all -> 0x0083 }
        if (r1 == 0) goto L_0x0090;	 Catch:{ all -> 0x0083 }
    L_0x008b:
        r1 = r8.u;	 Catch:{ all -> 0x0083 }
        r1.f();	 Catch:{ all -> 0x0083 }
    L_0x0090:
        throw r0;	 Catch:{ all -> 0x0083 }
    L_0x0091:
        r0 = r8.F();	 Catch:{ all -> 0x0083 }
        if (r0 == 0) goto L_0x0011;	 Catch:{ all -> 0x0083 }
    L_0x0097:
        r1 = r8.s();	 Catch:{ all -> 0x0083 }
        if (r1 == 0) goto L_0x0011;	 Catch:{ all -> 0x0083 }
    L_0x009d:
        r1 = r8.t();	 Catch:{ all -> 0x0083 }
        if (r1 == 0) goto L_0x0011;
    L_0x00a3:
        r1 = 0;
        r1 = r0.lockCanvas(r1);	 Catch:{ Exception -> 0x00b7 }
        if (r1 == 0) goto L_0x0011;
    L_0x00aa:
        r8.b(r1);	 Catch:{ all -> 0x00b2 }
        r0.unlockCanvasAndPost(r1);	 Catch:{ all -> 0x0083 }
        goto L_0x0011;	 Catch:{ all -> 0x0083 }
    L_0x00b2:
        r2 = move-exception;	 Catch:{ all -> 0x0083 }
        r0.unlockCanvasAndPost(r1);	 Catch:{ all -> 0x0083 }
        throw r2;	 Catch:{ all -> 0x0083 }
    L_0x00b7:
        r0 = move-exception;
        goto L_0x0011;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.apollo.media.impl.v.L():void");
    }

    private void b(Canvas canvas) {
        String lastPathSegment;
        int i;
        String str;
        if (this.f instanceof DataSourceURI) {
            lastPathSegment = ((DataSourceURI) this.f).uri.getLastPathSegment();
        } else {
            lastPathSegment = null;
        }
        canvas.drawColor(-16777216);
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        int i2 = (height - 12) / 8;
        int i3 = (width - 12) / 8;
        int i4 = width - 12;
        int i5 = i2 + 6;
        for (i = 1; i < 8; i++) {
            canvas.drawLine(6.0f, (float) i5, (float) i4, (float) i5, this.D);
            i5 += i2;
        }
        i2 = height - 12;
        i5 = 1;
        i = i3 + 6;
        while (i5 < 8) {
            canvas.drawLine((float) i, 6.0f, (float) i, (float) i2, this.D);
            i5++;
            i += i3;
        }
        int i6 = width - 6;
        int i7 = height - 6;
        canvas.drawRect(new Rect(6, 6, i6, i7), this.B);
        canvas.drawRect(new Rect(12, 12, i6 - 6, i7 - 6), this.C);
        a(canvas);
        i7 = (canvas.getHeight() - ((lastPathSegment != null ? 2 : 1) * 32)) - 16;
        if (this.u != null) {
            str = f.b(this.q) + "/" + f.b(this.l) + " N";
        } else {
            str = f.b(this.q) + "/" + f.b(this.l);
        }
        canvas.drawText(str, 18.0f, (float) i7, this.E);
        i6 = i7 + 32;
        if (lastPathSegment != null) {
            if (lastPathSegment.length() > 20) {
                lastPathSegment = "..." + lastPathSegment.substring(lastPathSegment.length() - 20);
            }
            canvas.drawText(lastPathSegment, 18.0f, (float) i6, this.E);
        }
    }
}
