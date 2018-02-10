package android.support.v7.graphics;

import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
public final class g {
    public static final g a;
    public static final g b;
    public static final g c;
    public static final g d;
    public static final g e;
    public static final g f;
    final float[] g = new float[3];
    final float[] h = new float[3];
    final float[] i = new float[3];
    boolean j = true;

    static {
        g gVar = new g();
        a = gVar;
        c(gVar);
        d(a);
        gVar = new g();
        b = gVar;
        b(gVar);
        d(b);
        gVar = new g();
        c = gVar;
        a(gVar);
        d(c);
        gVar = new g();
        d = gVar;
        c(gVar);
        e(d);
        gVar = new g();
        e = gVar;
        b(gVar);
        e(e);
        gVar = new g();
        f = gVar;
        a(gVar);
        e(f);
    }

    private g() {
        a(this.g);
        a(this.h);
        this.i[0] = 0.24f;
        this.i[1] = 0.52f;
        this.i[2] = 0.24f;
    }

    private static void a(float[] fArr) {
        fArr[0] = 0.0f;
        fArr[1] = 0.5f;
        fArr[2] = IPictureView.DEFAULT_MIN_SCALE;
    }

    private static void a(g gVar) {
        gVar.h[1] = 0.26f;
        gVar.h[2] = 0.45f;
    }

    private static void b(g gVar) {
        gVar.h[0] = 0.3f;
        gVar.h[1] = 0.5f;
        gVar.h[2] = 0.7f;
    }

    private static void c(g gVar) {
        gVar.h[0] = 0.55f;
        gVar.h[1] = 0.74f;
    }

    private static void d(g gVar) {
        gVar.g[0] = 0.35f;
        gVar.g[1] = IPictureView.DEFAULT_MIN_SCALE;
    }

    private static void e(g gVar) {
        gVar.g[1] = 0.3f;
        gVar.g[2] = 0.4f;
    }
}
