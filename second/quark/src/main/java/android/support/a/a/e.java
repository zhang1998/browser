package android.support.a.a;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Region.Op;
import android.support.v4.d.b;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
final class e {
    static final Matrix a = new Matrix();
    final g b;
    float c;
    float d;
    float e;
    float f;
    int g;
    String h;
    final b<String, Object> i;
    private final Path j;
    private final Path k;
    private final Matrix l;
    private Paint m;
    private Paint n;
    private PathMeasure o;
    private int p;

    public e() {
        this.l = new Matrix();
        this.c = 0.0f;
        this.d = 0.0f;
        this.e = 0.0f;
        this.f = 0.0f;
        this.g = 255;
        this.h = null;
        this.i = new b();
        this.b = new g();
        this.j = new Path();
        this.k = new Path();
    }

    public e(e eVar) {
        this.l = new Matrix();
        this.c = 0.0f;
        this.d = 0.0f;
        this.e = 0.0f;
        this.f = 0.0f;
        this.g = 255;
        this.h = null;
        this.i = new b();
        this.b = new g(eVar.b, this.i);
        this.j = new Path(eVar.j);
        this.k = new Path(eVar.k);
        this.c = eVar.c;
        this.d = eVar.d;
        this.e = eVar.e;
        this.f = eVar.f;
        this.p = eVar.p;
        this.g = eVar.g;
        this.h = eVar.h;
        if (eVar.h != null) {
            this.i.put(eVar.h, this);
        }
    }

    final void a(g gVar, Matrix matrix, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
        gVar.a.set(matrix);
        gVar.a.preConcat(gVar.j);
        for (int i3 = 0; i3 < gVar.b.size(); i3++) {
            Object obj = gVar.b.get(i3);
            if (obj instanceof g) {
                a((g) obj, gVar.a, canvas, i, i2, colorFilter);
            } else if (obj instanceof k) {
                k kVar = (k) obj;
                float f = ((float) i) / this.e;
                float f2 = ((float) i2) / this.f;
                float min = Math.min(f, f2);
                Matrix matrix2 = gVar.a;
                this.l.set(matrix2);
                this.l.postScale(f, f2);
                float[] fArr = new float[]{0.0f, IPictureView.DEFAULT_MIN_SCALE, IPictureView.DEFAULT_MIN_SCALE, 0.0f};
                matrix2.mapVectors(fArr);
                f2 = (float) Math.hypot((double) fArr[0], (double) fArr[1]);
                float hypot = (float) Math.hypot((double) fArr[2], (double) fArr[3]);
                float f3 = (fArr[3] * fArr[0]) - (fArr[1] * fArr[2]);
                f2 = Math.max(f2, hypot);
                f = 0.0f;
                if (f2 > 0.0f) {
                    f = Math.abs(f3) / f2;
                }
                if (f != 0.0f) {
                    kVar.a(this.j);
                    Path path = this.j;
                    this.k.reset();
                    if (kVar.a()) {
                        this.k.addPath(path, this.l);
                        canvas.clipPath(this.k, Op.REPLACE);
                    } else {
                        Paint paint;
                        f fVar = (f) kVar;
                        if (!(fVar.g == 0.0f && fVar.h == IPictureView.DEFAULT_MIN_SCALE)) {
                            hypot = (fVar.g + fVar.i) % IPictureView.DEFAULT_MIN_SCALE;
                            f3 = (fVar.h + fVar.i) % IPictureView.DEFAULT_MIN_SCALE;
                            if (this.o == null) {
                                this.o = new PathMeasure();
                            }
                            this.o.setPath(this.j, false);
                            float length = this.o.getLength();
                            hypot *= length;
                            f3 *= length;
                            path.reset();
                            if (hypot > f3) {
                                this.o.getSegment(hypot, length, path, true);
                                this.o.getSegment(0.0f, f3, path, true);
                            } else {
                                this.o.getSegment(hypot, f3, path, true);
                            }
                            path.rLineTo(0.0f, 0.0f);
                        }
                        this.k.addPath(path, this.l);
                        if (fVar.c != 0) {
                            if (this.n == null) {
                                this.n = new Paint();
                                this.n.setStyle(Style.FILL);
                                this.n.setAntiAlias(true);
                            }
                            paint = this.n;
                            paint.setColor(((((int) (((float) Color.alpha(fVar.c)) * fVar.f)) << 24) | (16777215 & fVar.c)));
                            paint.setColorFilter(colorFilter);
                            canvas.drawPath(this.k, paint);
                        }
                        if (fVar.a != 0) {
                            if (this.m == null) {
                                this.m = new Paint();
                                this.m.setStyle(Style.STROKE);
                                this.m.setAntiAlias(true);
                            }
                            paint = this.m;
                            if (fVar.k != null) {
                                paint.setStrokeJoin(fVar.k);
                            }
                            if (fVar.j != null) {
                                paint.setStrokeCap(fVar.j);
                            }
                            paint.setStrokeMiter(fVar.l);
                            paint.setColor(((((int) (((float) Color.alpha(fVar.a)) * fVar.d)) << 24) | (16777215 & fVar.a)));
                            paint.setColorFilter(colorFilter);
                            paint.setStrokeWidth((f * min) * fVar.b);
                            canvas.drawPath(this.k, paint);
                        }
                    }
                }
            }
        }
    }
}
