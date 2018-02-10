package android.support.a.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

/* compiled from: ProGuard */
final class d extends ConstantState {
    int a;
    e b;
    ColorStateList c;
    Mode d;
    boolean e;
    Bitmap f;
    ColorStateList g;
    Mode h;
    int i;
    boolean j;
    boolean k;
    Paint l;

    public d(d dVar) {
        this.c = null;
        this.d = c.a;
        if (dVar != null) {
            this.a = dVar.a;
            this.b = new e(dVar.b);
            if (dVar.b.n != null) {
                this.b.n = new Paint(dVar.b.n);
            }
            if (dVar.b.m != null) {
                this.b.m = new Paint(dVar.b.m);
            }
            this.c = dVar.c;
            this.d = dVar.d;
            this.e = dVar.e;
        }
    }

    public final void a(int i, int i2) {
        this.f.eraseColor(0);
        Canvas canvas = new Canvas(this.f);
        e eVar = this.b;
        eVar.a(eVar.b, e.a, canvas, i, i2, null);
    }

    public d() {
        this.c = null;
        this.d = c.a;
        this.b = new e();
    }

    public final Drawable newDrawable() {
        return new c();
    }

    public final Drawable newDrawable(Resources resources) {
        return new c();
    }

    public final int getChangingConfigurations() {
        return this.a;
    }
}
