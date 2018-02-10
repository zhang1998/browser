package com.airbnb.lottie;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.uc.imagecodec.export.IPictureView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
final class y implements bq, cx {
    private final Path a = new Path();
    private final Paint b = new Paint(1);
    private final List<bo> c = new ArrayList();
    private final cb<Integer> d;
    private final cb<Integer> e;
    private final cu f;

    y(cu cuVar, cz czVar, av avVar) {
        this.f = cuVar;
        if (avVar.b == null || avVar.c == null) {
            this.d = null;
            this.e = null;
            return;
        }
        this.a.setFillType(avVar.a);
        this.d = avVar.b.b();
        this.d.a((bq) this);
        czVar.a(this.d);
        this.e = avVar.c.b();
        this.e.a((bq) this);
        czVar.a(this.e);
    }

    public final void a() {
        this.f.invalidateSelf();
    }

    public final void a(List<de> list, List<de> list2) {
        for (int i = 0; i < list2.size(); i++) {
            de deVar = (de) list2.get(i);
            if (deVar instanceof bo) {
                this.c.add((bo) deVar);
            }
        }
    }

    public final void a(Canvas canvas, Matrix matrix, int i) {
        this.b.setColor(((Integer) this.d.a()).intValue());
        this.b.setAlpha((int) (((((float) ((Integer) this.e.a()).intValue()) * (((float) i) / 255.0f)) / 100.0f) * 255.0f));
        this.a.reset();
        for (int i2 = 0; i2 < this.c.size(); i2++) {
            this.a.addPath(((bo) this.c.get(i2)).b(), matrix);
        }
        canvas.drawPath(this.a, this.b);
    }

    public final void a(RectF rectF, Matrix matrix) {
        this.a.reset();
        for (int i = 0; i < this.c.size(); i++) {
            this.a.addPath(((bo) this.c.get(i)).b(), matrix);
        }
        this.a.computeBounds(rectF, false);
        rectF.set(rectF.left - IPictureView.DEFAULT_MIN_SCALE, rectF.top - IPictureView.DEFAULT_MIN_SCALE, rectF.right + IPictureView.DEFAULT_MIN_SCALE, rectF.bottom + IPictureView.DEFAULT_MIN_SCALE);
    }
}
