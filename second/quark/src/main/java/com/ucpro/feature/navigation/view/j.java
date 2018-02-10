package com.ucpro.feature.navigation.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import com.quark.browser.R;
import com.uc.imagecodec.export.IPictureView;
import com.uc.webview.export.extension.UCCore;
import com.ucpro.ui.c.a;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
public abstract class j extends ViewGroup {
    protected static int a;
    protected static int b;
    protected static int c;
    protected static int d;
    protected static int e;
    protected static int f;
    protected static int g;
    protected static int h;
    protected static int i;
    private static int n;
    private static int o;
    private static int p;
    private static int q;
    private static int r;
    private static boolean s;
    private static Rect t = new Rect();
    private static Drawable u;
    private View A;
    private boolean B;
    private boolean C;
    private boolean D;
    private boolean E = true;
    private int F = 3;
    private int G;
    private int H;
    private int I;
    private float J;
    protected al j;
    protected ax k;
    boolean l;
    float m;
    private Drawable v;
    private Rect w = new Rect();
    private Rect x = new Rect();
    private ArrayList<Animator> y;
    private Rect z = new Rect();

    protected abstract boolean a(Rect rect);

    public j(Context context, al alVar) {
        super(context);
        this.j = alVar;
        setOnClickListener(new ad(this));
        setOnLongClickListener(new ae(this));
        if (!s) {
            s = true;
            n = (int) a.a((int) R.dimen.launcher_widget_paddingleft);
            o = (int) a.a((int) R.dimen.launcher_widget_paddingtop);
            p = (int) a.a((int) R.dimen.launcher_widget_paddingright);
            q = (int) a.a((int) R.dimen.launcher_widget_paddingbottom);
            a = (int) a.a((int) R.dimen.launcher_widget_width_portrait);
            b = (int) a.a((int) R.dimen.launcher_widget_height_portrait);
            c = (int) a.a((int) R.dimen.launcher_widget_iconview_width_portrait);
            d = (int) a.a((int) R.dimen.launcher_widget_iconview_height_portrait);
            f = (int) a.a((int) R.dimen.launcher_widget_title_margin_top_portrait);
            e = (int) a.a((int) R.dimen.launcher_widget_icon_margin_top_portrait);
            g = (int) a.a((int) R.dimen.launcher_widget_title_margin_bottom_portrait);
            h = (int) a.a((int) R.dimen.launcher_widget_title_textsize_portrait);
            i = (int) a.a((int) R.dimen.launcher_widget_title_padding_x);
            r = (int) a.a((int) R.dimen.launcher_widget_delete_button_offset);
        }
        setSoundEffectsEnabled(false);
        setPadding(n, o, p, q);
    }

    protected void a() {
        if (this.v != null) {
            b();
            c();
        }
        u = null;
    }

    private void b() {
        this.v = a.b("home_nav_edit_delete.png");
    }

    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.C && !this.l) {
            Drawable maskDrawable = getMaskDrawable();
            if (maskDrawable.getBounds() == null || maskDrawable.getBounds().width() == 0) {
                Rect rect = new Rect();
                a(rect);
                maskDrawable.setBounds(rect);
            }
            maskDrawable.draw(canvas);
        }
        if (this.B && d() && this.v != null) {
            this.v.setBounds(this.w);
            canvas.save();
            canvas.rotate(this.J, (float) this.w.centerX(), (float) this.w.centerY());
            canvas.scale(this.m, this.m, (float) this.w.centerX(), (float) this.w.centerY());
            this.v.draw(canvas);
            canvas.restore();
        }
    }

    private Drawable getMaskDrawable() {
        if (u == null) {
            u = a.a("home_nav_click.svg");
        }
        return u;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchTouchEvent(android.view.MotionEvent r7) {
        /*
        r6 = this;
        r5 = 10;
        r0 = 1;
        r1 = 0;
        r2 = r7.getX();
        r2 = (int) r2;
        r3 = r7.getY();
        r3 = (int) r3;
        r4 = r7.getAction();
        switch(r4) {
            case 0: goto L_0x001d;
            case 1: goto L_0x0077;
            case 2: goto L_0x004d;
            case 3: goto L_0x006e;
            case 4: goto L_0x006e;
            default: goto L_0x0015;
        };
    L_0x0015:
        r0 = r1;
    L_0x0016:
        if (r0 != 0) goto L_0x001c;
    L_0x0018:
        r0 = super.dispatchTouchEvent(r7);
    L_0x001c:
        return r0;
    L_0x001d:
        r4 = r6.d();
        if (r4 == 0) goto L_0x0036;
    L_0x0023:
        r4 = r6.B;
        if (r4 == 0) goto L_0x0036;
    L_0x0027:
        r4 = r6.x;
        r4 = r4.contains(r2, r3);
        if (r4 == 0) goto L_0x0036;
    L_0x002f:
        r6.G = r2;
        r6.H = r3;
        r6.D = r0;
        goto L_0x0016;
    L_0x0036:
        r6.D = r1;
        r2 = r6.E;
        if (r2 == 0) goto L_0x0015;
    L_0x003c:
        r2 = r6.j;
        if (r2 == 0) goto L_0x0046;
    L_0x0040:
        r2 = r6.j;
        r3 = 5;
        r2.a(r6, r3);
    L_0x0046:
        r6.C = r0;
        r6.invalidate();
        r0 = r1;
        goto L_0x0016;
    L_0x004d:
        r0 = r6.G;
        r0 = r2 - r0;
        r2 = r6.H;
        r2 = r3 - r2;
        r0 = java.lang.Math.abs(r0);
        if (r0 > r5) goto L_0x0061;
    L_0x005b:
        r0 = java.lang.Math.abs(r2);
        if (r0 <= r5) goto L_0x0015;
    L_0x0061:
        r6.D = r1;
        r0 = r6.C;
        if (r0 == 0) goto L_0x006a;
    L_0x0067:
        r6.invalidate();
    L_0x006a:
        r6.C = r1;
        r0 = r1;
        goto L_0x0016;
    L_0x006e:
        r6.D = r1;
        r6.C = r1;
        r6.invalidate();
        r0 = r1;
        goto L_0x0016;
    L_0x0077:
        r2 = r6.D;
        if (r2 == 0) goto L_0x008a;
    L_0x007b:
        r2 = r6.d();
        if (r2 == 0) goto L_0x008a;
    L_0x0081:
        r2 = r6.j;
        if (r2 == 0) goto L_0x008a;
    L_0x0085:
        r2 = r6.j;
        r2.a(r6, r0);
    L_0x008a:
        r6.C = r1;
        r6.D = r1;
        r6.invalidate();
        goto L_0x0015;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ucpro.feature.navigation.view.j.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setTouchable(boolean z) {
        this.E = z;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        c();
    }

    private void c() {
        if (getWidth() > 0 && this.v != null) {
            int intrinsicWidth = this.v.getIntrinsicWidth();
            int intrinsicHeight = this.v.getIntrinsicHeight();
            a(this.z);
            int centerX = this.z.centerX();
            int centerY = this.z.centerY() - intrinsicHeight;
            a(t);
            this.F = (int) (((float) t.width()) * 0.15f);
            this.I = (int) (((float) t.height()) * 0.15f);
            this.w.set(centerX, centerY, intrinsicWidth + centerX, intrinsicHeight + centerY);
            this.x.set(this.w.left - this.F, this.w.top - (this.I * 2), (this.w.right + this.F) + this.F, this.w.bottom + this.I);
        }
    }

    public void setAnimationView(View view) {
        f();
        this.A = view;
        addView(this.A);
        this.A.measure(MeasureSpec.makeMeasureSpec(getWidth(), UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(getHeight(), UCCore.VERIFY_POLICY_QUICK));
        this.A.layout(0, 0, getWidth(), getHeight());
        this.A.invalidate();
        invalidate();
    }

    public final void f() {
        if (this.A != null) {
            removeView(this.A);
            this.A = null;
        }
    }

    public final void a(boolean z) {
        if (z && this.v == null) {
            b();
            c();
        }
        this.B = z;
        if (z && d()) {
            Object obj;
            if (getAnimatorList().size() > 0) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj == null) {
                this.m = IPictureView.DEFAULT_MIN_SCALE;
            }
        }
        invalidate();
    }

    private boolean d() {
        if (this.k != null) {
            return this.k.c;
        }
        return false;
    }

    private ArrayList<Animator> getAnimatorList() {
        if (this.y == null) {
            this.y = new ArrayList();
        }
        return this.y;
    }

    final void g() {
        if (this.y != null) {
            Iterator it = this.y.iterator();
            while (it.hasNext()) {
                ((Animator) it.next()).end();
            }
            this.y.clear();
        }
    }

    final void a(float f, float f2) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{f, f2});
        ofFloat.setDuration(160);
        ofFloat.setStartDelay(0);
        ofFloat.addUpdateListener(new an(this));
        ofFloat.addListener(new ag(this));
        getAnimatorList().add(ofFloat);
        ofFloat.start();
    }

    public final void h() {
        if (this.m != 0.0f) {
            g();
            a(this.m, 0.0f);
        }
    }

    public void setWidgetInfo(ax axVar) {
        this.k = axVar;
    }

    public ax getWidgetInfo() {
        return this.k;
    }

    public void a(ax axVar) {
        setWidgetInfo(axVar);
        invalidate();
    }

    public void setIsEditStyle(boolean z) {
        this.l = z;
    }
}
