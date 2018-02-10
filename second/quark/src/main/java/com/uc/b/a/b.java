package com.uc.b.a;

import android.graphics.Matrix;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public final class b {
    Matrix a = new Matrix();
    private final List<Matrix> b = new ArrayList();

    public final void a() {
        this.b.add(new Matrix(this.a));
    }

    public final void b() {
        int size = this.b.size();
        if (size > 0) {
            this.a = (Matrix) this.b.get(size - 1);
            this.b.remove(size - 1);
        }
    }

    public final void a(Matrix matrix) {
        if (matrix != null) {
            this.a.preConcat(matrix);
        }
    }

    public final void a(float f, float f2) {
        this.a.preScale(f, f2);
    }
}
