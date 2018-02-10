package android.support.v4.widget;

import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable.Callback;
import android.support.annotation.NonNull;

/* compiled from: ProGuard */
final class ag {
    final RectF a = new RectF();
    final Paint b = new Paint();
    final Paint c = new Paint();
    float d = 0.0f;
    float e = 0.0f;
    float f = 0.0f;
    float g = 5.0f;
    float h = 2.5f;
    int[] i;
    int j;
    float k;
    float l;
    float m;
    boolean n;
    Path o;
    float p;
    double q;
    int r;
    int s;
    int t;
    final Paint u = new Paint(1);
    int v;
    int w;
    private final Callback x;

    public ag(Callback callback) {
        this.x = callback;
        this.b.setStrokeCap(Cap.SQUARE);
        this.b.setAntiAlias(true);
        this.b.setStyle(Style.STROKE);
        this.c.setStyle(Style.FILL);
        this.c.setAntiAlias(true);
    }

    public final void a(@NonNull int[] iArr) {
        this.i = iArr;
        a(0);
    }

    public final void a(int i) {
        this.j = i;
        this.w = this.i[this.j];
    }

    final int a() {
        return (this.j + 1) % this.i.length;
    }

    public final void a(float f) {
        this.d = f;
        d();
    }

    public final void b(float f) {
        this.e = f;
        d();
    }

    public final void c(float f) {
        this.f = f;
        d();
    }

    public final void a(boolean z) {
        if (this.n != z) {
            this.n = z;
            d();
        }
    }

    public final void b() {
        this.k = this.d;
        this.l = this.e;
        this.m = this.f;
    }

    public final void c() {
        this.k = 0.0f;
        this.l = 0.0f;
        this.m = 0.0f;
        a(0.0f);
        b(0.0f);
        c(0.0f);
    }

    final void d() {
        this.x.invalidateDrawable(null);
    }
}
