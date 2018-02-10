package com.uc.apollo.media.service;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alibaba.wireless.security.SecExceptionCode;
import com.uc.apollo.media.LittleWindowConfig;
import com.uc.apollo.media.LittleWindowController;
import com.uc.apollo.media.LittleWindowToolbar;
import com.uc.apollo.media.base.Resources;
import com.uc.apollo.media.impl.u;
import com.uc.apollo.media.service.LittleWindowActionStatistic.Factory;
import com.uc.apollo.util.f;
import com.uc.imagecodec.export.IPictureView;
import java.lang.ref.WeakReference;

/* compiled from: ProGuard */
final class s extends FrameLayout implements LittleWindowToolbar {
    private static final int P = (o.f / 3);
    private static final int Q = (o.f / 3);
    private static final String a = (t.a + "LittleWindowToolbar");
    private static final int b = f.c(3);
    private static final int c = f.c(2);
    private static final int d = f.c(24);
    private static final int e = f.c(26);
    private static final int f = (d + f.c(6));
    private static final int g = e;
    private static final int h = f.c(14);
    private static final int i = ((e + (d * 2)) + (h * 4));
    private static final int j = (e + (h * 2));
    private static final int k = f.c(4);
    private com.uc.apollo.media.widget.b A;
    private TextView B;
    private View C;
    private LayoutParams D;
    private boolean E;
    private boolean F;
    private boolean G;
    private int H;
    private int I;
    private int J = 0;
    private int K = 0;
    private int L;
    private int M = 0;
    private long N;
    private long O;
    private d l = new d(this);
    private int m;
    private float n;
    private float o;
    private float p;
    private boolean q;
    private LittleWindowActionStatistic r = Factory.getInstance();
    private b s = new b();
    private int t = c.a;
    private LittleWindowController u;
    private VelocityTracker v;
    private ImageView w;
    private ImageView x;
    private ImageView y;
    private a z;

    /* compiled from: ProGuard */
    final class a {
        LinearLayout a;
        ImageView b;
        ImageView c;
        ImageView d;
        final /* synthetic */ s e;
        private int f;
        private int g;
        private int h;
        private int i;

        a(s sVar, Context context) {
            this.e = sVar;
            this.a = new LinearLayout(context);
            this.b = new ImageView(context);
            this.b.setImageDrawable(Resources.BACKWARD);
            this.c = new ImageView(context);
            this.c.setImageDrawable(Resources.PLAY);
            this.d = new ImageView(context);
            this.d.setImageDrawable(Resources.FORWARD);
            ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(s.d, s.d);
            layoutParams.topMargin = (s.e - s.d) / 2;
            layoutParams.rightMargin = s.h;
            this.a.addView(this.b, layoutParams);
            this.a.addView(this.c, new LinearLayout.LayoutParams(s.e, s.e));
            layoutParams = new LinearLayout.LayoutParams(s.d, s.d);
            layoutParams.topMargin = (s.e - s.d) / 2;
            layoutParams.leftMargin = s.h;
            this.a.addView(this.d, layoutParams);
        }

        final boolean a() {
            return this.a.getVisibility() == 0;
        }

        final void a(int i) {
            this.d.setVisibility(i);
            this.b.setVisibility(i);
        }

        final boolean a(int i, int i2) {
            int i3 = 0;
            int width = this.e.getWidth();
            int height = this.e.getHeight();
            if (u.j(this.e.H)) {
                this.f = (width / 2) - (s.i / 2);
                this.g = (height / 2) - (s.j / 2);
                this.h = this.f + s.i;
                this.i = this.g + s.j;
            } else {
                this.f = ((width / 2) - (s.e / 2)) - s.h;
                this.g = ((height / 2) - (s.e / 2)) - s.h;
                this.h = (this.f + s.e) + s.h;
                this.i = (this.g + s.e) + s.h;
            }
            if (i < this.f || i >= this.h || i2 < this.g || i2 >= this.i) {
                return false;
            }
            if (u.j(this.e.H)) {
                width = (this.f + s.d) + ((s.h * 3) / 2);
                height = this.h - (s.d + ((s.h * 3) / 2));
                if (i < width || i >= height) {
                    height = j.a(this.e.H);
                    int f = this.e.I;
                    if (i < width) {
                        width = f - height;
                        if (width >= 0) {
                            i3 = width;
                        }
                        this.e.r.onAction(5);
                    } else {
                        i3 = f + height;
                        if (i3 > this.e.H) {
                            i3 = this.e.H;
                        }
                        this.e.r.onAction(4);
                    }
                    if (i3 != this.e.I) {
                        this.e.u.seekTo(i3);
                        this.e.onPositionChanged(i3);
                        this.e.a();
                    }
                } else if (this.e.F) {
                    this.e.r.onAction(1);
                    this.e.u.pause();
                } else {
                    this.e.r.onAction(0);
                    this.e.u.play();
                }
            } else if (this.e.F) {
                this.e.r.onAction(1);
                this.e.u.pause();
            } else {
                this.e.r.onAction(0);
                this.e.u.play();
            }
            return true;
        }
    }

    /* compiled from: ProGuard */
    final class b {
        public boolean a;
        public boolean b;
        public boolean c;
        public boolean d;
        public boolean e;
        final /* synthetic */ s f;

        private b(s sVar) {
            this.f = sVar;
        }
    }

    /* compiled from: ProGuard */
    final class c {
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;
        private static final /* synthetic */ int[] d = new int[]{a, b, c};
    }

    /* compiled from: ProGuard */
    final class d extends Handler {
        WeakReference<s> a;

        d(s sVar) {
            this.a = new WeakReference(sVar);
        }

        public final void handleMessage(Message message) {
            s sVar = (s) this.a.get();
            if (sVar != null) {
                switch (message.what) {
                    case 1:
                        s.g(sVar);
                        return;
                    case 2:
                        sVar.i();
                        return;
                    case 3:
                        if (!sVar.G) {
                            sVar.G = true;
                            if (!sVar.g()) {
                                sVar.a(true);
                                return;
                            }
                            return;
                        }
                        return;
                    case 5:
                        o.d();
                        o.e();
                        return;
                    default:
                        return;
                }
            }
        }
    }

    static /* synthetic */ void g(s sVar) {
        sVar.l.removeMessages(2);
        sVar.l.removeMessages(1);
        sVar.z.a.setVisibility(0);
        sVar.h();
        if (sVar.F) {
            sVar.a();
        }
        sVar.a(false);
    }

    public final View asView() {
        return this;
    }

    public final void reset() {
        this.F = false;
        this.E = false;
        this.H = 0;
        this.I = 0;
        this.J = 0;
        this.K = 0;
        this.D.width = 0;
        this.C.requestLayout();
    }

    s(Context context, LittleWindowController littleWindowController) {
        super(context);
        this.u = littleWindowController;
        Drawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius((float) o.b);
        gradientDrawable.setColor(0);
        gradientDrawable.setStroke(o.b, 1075912975);
        setBackgroundDrawable(gradientDrawable);
        this.x = new ImageView(context);
        this.x.setImageDrawable(Resources.CLOSE);
        addView(this.x, new LayoutParams(d, d, 8388659));
        if (LittleWindowConfig.supportFullScreen()) {
            this.w = new ImageView(context);
            this.w.setImageDrawable(Resources.MAXIMIZE);
            addView(this.w, new LayoutParams(d, d, 8388661));
        }
        this.y = new ImageView(context);
        this.y.setImageDrawable(Resources.RESIZE);
        addView(this.y, new LayoutParams(d, d, 8388693));
        this.z = new a(this, context);
        addView(this.z.a, new LayoutParams(-2, -2, 17));
        this.A = new com.uc.apollo.media.widget.b(context);
        this.A.setImageDrawable(Resources.LOADING);
        this.A.setVisibility(8);
        addView(this.A, new LayoutParams(e, e, 17));
        this.B = new TextView(context);
        this.B.setBackgroundColor(1082163586);
        this.B.setTextColor(-1);
        this.B.setText("00:00/00:00");
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-2, -2, 8388691);
        layoutParams.leftMargin = o.a;
        layoutParams.bottomMargin = o.a;
        this.B.setPadding(b, 0, b, 0);
        addView(this.B, layoutParams);
        this.C = new View(context);
        this.C.setBackgroundColor(-1325457344);
        this.D = new LayoutParams(-2, -2);
        this.D.leftMargin = o.a - 1;
        addView(this.C, this.D);
        i();
    }

    protected final void finalize() throws Throwable {
        super.finalize();
        if (this.v != null) {
            this.v.recycle();
        }
    }

    private boolean g() {
        return this.z.a.getVisibility() == 0;
    }

    private void h() {
        if (g() && this.E) {
            if (this.M == 0 && u.j(this.H) && this.L > (e + (d * 2)) + (h * 2)) {
                this.z.b.setVisibility(0);
                this.z.d.setVisibility(0);
            } else {
                this.z.b.setVisibility(8);
                this.z.d.setVisibility(8);
            }
            this.B.setVisibility(0);
            this.C.setVisibility(0);
            j();
            k();
            this.C.requestLayout();
            return;
        }
        this.z.b.setVisibility(8);
        this.z.d.setVisibility(8);
        this.B.setVisibility(4);
        this.C.setVisibility(8);
    }

    private void a(boolean z) {
        if (z) {
            this.A.setVisibility(0);
            this.A.a();
            return;
        }
        com.uc.apollo.media.widget.b bVar = this.A;
        if (bVar.getAnimation() != null) {
            bVar.clearAnimation();
        }
        this.A.setVisibility(4);
    }

    private void i() {
        this.l.removeMessages(2);
        this.l.removeMessages(1);
        this.z.a.setVisibility(4);
        h();
        a(this.G);
    }

    public final void onDurationChanged(int i) {
        if (this.H != i) {
            this.H = i;
            j();
        }
    }

    private void j() {
        if (!u.j(this.H) || this.L <= (e + (d * 2)) + (h * 2)) {
            this.B.setText(f.a(this.I, true));
        } else {
            this.B.setText(f.a(this.I, true) + "/" + f.a(this.H, true));
        }
    }

    public final void onPositionChanged(int i) {
        if (this.I != i) {
            if (this.G) {
                this.G = false;
                a(false);
            }
            this.I = i;
            if (g()) {
                j();
                k();
                this.C.requestLayout();
            }
        } else if (!this.G) {
            this.G = true;
            if (!g()) {
                a(true);
            }
        }
    }

    private void k() {
        if (this.L <= 0 || this.I <= 0 || this.I > this.H) {
            this.D.width = 0;
            return;
        }
        this.D.width = (int) (((float) (this.L - (o.a * 2))) * ((IPictureView.DEFAULT_MIN_SCALE * ((float) this.I)) / ((float) this.H)));
    }

    protected final void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i != 0) {
            a(false);
        }
    }

    protected final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.L = i;
        this.D.topMargin = (i2 - o.a) - c;
        this.D.height = c;
        k();
        j();
        h();
    }

    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        o.d();
        o.e();
        setVisibility(0);
        this.t = c.a;
    }

    public final void onVideoSizeChanged(int i, int i2) {
        if (i == 0 || i2 == 0) {
            i = o.d;
            i2 = o.e;
        }
        if (this.J != i || this.K != i2) {
            if (this.K == 0 || this.J == 0 || Math.abs(((((float) this.J) * IPictureView.DEFAULT_MIN_SCALE) / ((float) this.K)) - ((((float) i) * IPictureView.DEFAULT_MIN_SCALE) / ((float) i2))) >= 0.1f) {
                this.J = i;
                this.K = i2;
                this.l.sendEmptyMessageDelayed(5, 600);
            }
        }
    }

    private static float a(float f, float f2, float f3, float f4) {
        float f5 = f - f3;
        float f6 = f2 - f4;
        return (float) Math.sqrt((double) ((f5 * f5) + (f6 * f6)));
    }

    private void a(MotionEvent motionEvent) {
        o.d();
        this.m = motionEvent.getPointerCount();
        this.n = motionEvent.getRawX();
        this.o = motionEvent.getRawY();
        if (this.m > 1) {
            this.p = a(motionEvent.getX(0), motionEvent.getY(0), motionEvent.getX(1), motionEvent.getY(1));
        }
    }

    private void l() {
        if (this.v == null) {
            this.v = VelocityTracker.obtain();
        } else {
            this.v.clear();
        }
    }

    private void m() {
        b bVar = this.s;
        if (bVar.a) {
            bVar.f.r.onAction(7);
        }
        if (bVar.b) {
            bVar.f.r.onAction(8);
        }
        if (bVar.c) {
            bVar.f.r.onAction(9);
        }
        if (bVar.d) {
            bVar.f.r.onAction(10);
        }
        if (bVar.e) {
            bVar.f.r.onAction(11);
        }
        if (this.v != null) {
            this.v.clear();
        }
        this.t = c.a;
        this.m = 0;
        this.q = false;
        setVisibility(0);
        requestLayout();
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        float x = motionEvent.getX(0);
        float y = motionEvent.getY(0);
        int actionMasked2;
        if (this.M == 1) {
            actionMasked2 = motionEvent.getActionMasked();
            float x2 = motionEvent.getX(0);
            float y2 = motionEvent.getY(0);
            if (actionMasked2 == 1) {
                if (x2 <= ((float) f) && y2 <= ((float) f)) {
                    this.u.close();
                } else if (x2 >= ((float) (getWidth() - f)) && y2 <= ((float) f)) {
                    this.r.onAction(6);
                    this.u.maximize();
                } else if (!(this.z.a() && this.z.a((int) motionEvent.getX(), (int) motionEvent.getY()))) {
                    if (this.z.a()) {
                        i();
                    } else {
                        a(350);
                    }
                }
            }
            return true;
        }
        MotionEvent obtain;
        if (actionMasked == 0) {
            b bVar = this.s;
            bVar.a = false;
            bVar.b = false;
            bVar.c = false;
            bVar.d = false;
            bVar.e = false;
            this.N = motionEvent.getEventTime();
            o.f();
            a(motionEvent);
            this.q = this.m != 1;
            if (x < ((float) (getWidth() - g)) || y < ((float) (getHeight() - g))) {
                this.t = c.c;
            } else {
                this.t = c.b;
                setVisibility(4);
            }
            if (this.t == c.c) {
                l();
                obtain = MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime(), actionMasked, motionEvent.getRawX(), motionEvent.getRawY(), 0);
                this.v.addMovement(obtain);
                obtain.recycle();
            }
        } else {
            if (motionEvent.getPointerCount() != this.m) {
                a(motionEvent);
                boolean z = this.q || this.m != 1;
                this.q = z;
                if (this.m > 1) {
                    setVisibility(4);
                } else if (this.t == c.c) {
                    setVisibility(0);
                    requestLayout();
                }
                l();
            }
            if (actionMasked == 2 && this.v != null) {
                obtain = MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime(), actionMasked, motionEvent.getRawX(), motionEvent.getRawY(), 0);
                this.v.addMovement(obtain);
                obtain.recycle();
            }
            int rawX = (int) (motionEvent.getRawX() - this.n);
            int rawY = (int) (motionEvent.getRawY() - this.o);
            if (actionMasked == 1) {
                Object obj = motionEvent.getEventTime() - this.N < 200 ? 1 : null;
                if (this.t == c.c || this.t == c.b) {
                    int i = 0;
                    int i2 = 0;
                    if (this.t == c.c && this.v != null) {
                        this.v.computeCurrentVelocity(400);
                        i = (int) this.v.getXVelocity();
                        i2 = (int) this.v.getYVelocity();
                        this.v.clear();
                        if (Math.abs(i) < P && Math.abs(i2) < Q) {
                            i = 0;
                            i2 = 0;
                        }
                    }
                    if (i != 0 || i2 != 0 || this.q || (obj == null && (Math.abs(rawX) >= k || Math.abs(rawY) >= k))) {
                        o.c(i, i2);
                    } else {
                        long eventTime = motionEvent.getEventTime();
                        obj = eventTime - this.O < 350 ? 1 : null;
                        this.O = eventTime;
                        if (obj != null) {
                            this.l.removeMessages(1);
                            if (!(this.z.a() && this.z.a((int) motionEvent.getX(), (int) motionEvent.getY()))) {
                                if (this.F) {
                                    this.r.onAction(3);
                                    this.u.pause();
                                } else {
                                    this.r.onAction(2);
                                    this.u.play();
                                }
                            }
                        } else if (x <= ((float) f) && y <= ((float) f)) {
                            this.u.close();
                        } else if (x >= ((float) (getWidth() - f)) && y <= ((float) f)) {
                            this.r.onAction(6);
                            this.u.maximize();
                        } else if (!(this.z.a() && this.z.a((int) motionEvent.getX(), (int) motionEvent.getY()))) {
                            if (this.z.a()) {
                                i();
                            } else {
                                a(350);
                            }
                        }
                    }
                }
                m();
            } else if (actionMasked == 2) {
                if (this.m > 1) {
                    actionMasked2 = (int) (a(x, y, motionEvent.getX(1), motionEvent.getY(1)) - this.p);
                    if (Math.abs(actionMasked2) >= k) {
                        if (actionMasked2 > 0) {
                            this.s.d = true;
                        } else {
                            this.s.e = true;
                        }
                    }
                    o.a(actionMasked2);
                } else if (this.t == c.c) {
                    if (Math.abs(rawX) >= k || Math.abs(rawY) >= k) {
                        this.s.a = true;
                    }
                    o.b(rawX, rawY);
                } else if (this.t == c.b) {
                    actionMasked2 = o.a(rawX, rawY);
                    if (Math.abs(actionMasked2) >= k) {
                        if (actionMasked2 > 0) {
                            this.s.b = true;
                        } else {
                            this.s.c = true;
                        }
                    }
                }
            } else if (actionMasked == 3) {
                m();
                o.f();
            }
        }
        return true;
    }

    public final void onPrepared(int i, int i2, int i3) {
        this.E = true;
        onDurationChanged(i);
        onVideoSizeChanged(i2, i3);
        h();
        j();
    }

    public final void onCompletion() {
        if (u.j(this.H)) {
            com.uc.apollo.media.service.r.b.a().a(this.H);
        }
        onPositionChanged(this.H);
        a((int) SecExceptionCode.SEC_ERROR_SIGNATRUE);
    }

    public final void onPreparing() {
        this.l.sendEmptyMessageDelayed(3, 600);
        n();
    }

    public final void onPlay() {
        if (this.l.hasMessages(3)) {
            this.l.removeMessages(3);
        }
        n();
    }

    private void n() {
        this.F = true;
        this.z.c.setImageDrawable(Resources.PAUSE);
        i();
    }

    public final void onPause() {
        if (this.l.hasMessages(3)) {
            this.l.removeMessages(3);
        }
        this.F = false;
        this.G = false;
        this.z.c.setImageDrawable(Resources.PLAY);
        a((int) SecExceptionCode.SEC_ERROR_SIGNATRUE);
    }

    final void a() {
        this.l.removeMessages(2);
        this.l.removeMessages(1);
        this.l.sendEmptyMessageDelayed(2, 3000);
    }

    private void a(int i) {
        this.l.removeMessages(2);
        this.l.removeMessages(1);
        this.l.sendEmptyMessageDelayed(1, (long) i);
    }

    public final void onNormal() {
        b(0);
    }

    public final void onFloating() {
        b(1);
    }

    public final void onSourceChanged(String str, String str2, String str3) {
    }

    public final void setVisibility(int i) {
        super.setVisibility(i);
    }

    private void b(int i) {
        this.M = i;
        if (this.M == 1) {
            this.z.a(8);
            if (this.w != null) {
                this.w.setVisibility(8);
            }
            this.y.setVisibility(8);
            return;
        }
        this.z.a(0);
        if (this.w != null) {
            this.w.setVisibility(0);
        }
        this.y.setVisibility(0);
    }
}
