package com.ucpro.ui.widget.ripple;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.util.AttributeSet;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: ProGuard */
public class d extends g implements Callback {
    static final /* synthetic */ boolean b = (!d.class.desiredAssertionStatus());
    c a;
    private int c;
    private int[] d;
    private int[] e;
    private int[] f;
    private int[] g;
    private final Rect h;
    private Rect i;
    private boolean j;

    d() {
        this(null, null);
    }

    d(c cVar, Resources resources) {
        this.c = 0;
        this.h = new Rect();
        this.a = a(cVar, resources);
        if (this.a.a > 0) {
            a();
        }
    }

    c a(c cVar, Resources resources) {
        return new c(cVar, this, resources);
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws XmlPullParserException, IOException {
        super.inflate(resources, xmlPullParser, attributeSet, theme);
        a();
        onStateChange(getState());
    }

    public void applyTheme(Theme theme) {
        super.applyTheme(theme);
        if (this.a != null) {
            a();
            onStateChange(getState());
        }
    }

    public void a(int i) {
        if (this.a.k != i) {
            this.a.k = i;
        }
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    public void draw(Canvas canvas) {
        i[] iVarArr = this.a.b;
        int i = this.a.a;
        for (int i2 = 0; i2 < i; i2++) {
            iVarArr[i2].a.draw(canvas);
        }
    }

    public int getChangingConfigurations() {
        return (super.getChangingConfigurations() | this.a.d) | this.a.e;
    }

    public boolean getPadding(Rect rect) {
        i[] iVarArr;
        int i;
        int i2;
        if (this.a.k == 0) {
            rect.left = 0;
            rect.top = 0;
            rect.right = 0;
            rect.bottom = 0;
            iVarArr = this.a.b;
            i = this.a.a;
            for (i2 = 0; i2 < i; i2++) {
                a(i2, iVarArr[i2]);
                rect.left += this.d[i2];
                rect.top += this.e[i2];
                rect.right += this.f[i2];
                rect.bottom += this.g[i2];
            }
        } else {
            rect.left = 0;
            rect.top = 0;
            rect.right = 0;
            rect.bottom = 0;
            iVarArr = this.a.b;
            i = this.a.a;
            for (i2 = 0; i2 < i; i2++) {
                a(i2, iVarArr[i2]);
                rect.left = Math.max(rect.left, this.d[i2]);
                rect.top = Math.max(rect.top, this.e[i2]);
                rect.right = Math.max(rect.right, this.f[i2]);
                rect.bottom = Math.max(rect.bottom, this.g[i2]);
            }
        }
        if (rect.left == 0 && rect.top == 0 && rect.right == 0 && rect.bottom == 0) {
            return false;
        }
        return true;
    }

    public void setHotspot(float f, float f2) {
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        if (this.i == null) {
            this.i = new Rect(i, i2, i3, i4);
        } else {
            this.i.set(i, i2, i3, i4);
        }
    }

    public void getHotspotBounds(Rect rect) {
        if (this.i != null) {
            rect.set(this.i);
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        i[] iVarArr = this.a.b;
        int i = this.a.a;
        for (int i2 = 0; i2 < i; i2++) {
            iVarArr[i2].a.setVisible(z, z2);
        }
        return visible;
    }

    public void setDither(boolean z) {
        i[] iVarArr = this.a.b;
        int i = this.a.a;
        for (int i2 = 0; i2 < i; i2++) {
            iVarArr[i2].a.setDither(z);
        }
    }

    public void setAlpha(int i) {
        i[] iVarArr = this.a.b;
        int i2 = this.a.a;
        for (int i3 = 0; i3 < i2; i3++) {
            iVarArr[i3].a.setAlpha(i);
        }
    }

    public int getAlpha() {
        return -1;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        i[] iVarArr = this.a.b;
        int i = this.a.a;
        for (int i2 = 0; i2 < i; i2++) {
            iVarArr[i2].a.setColorFilter(colorFilter);
        }
    }

    public int getOpacity() {
        if (this.c != 0) {
            return this.c;
        }
        c cVar = this.a;
        if (cVar.f) {
            return cVar.g;
        }
        i[] iVarArr = cVar.b;
        int i = cVar.a;
        int opacity = i > 0 ? iVarArr[0].a.getOpacity() : -2;
        int i2 = 1;
        while (i2 < i) {
            int resolveOpacity = Drawable.resolveOpacity(opacity, iVarArr[i2].a.getOpacity());
            i2++;
            opacity = resolveOpacity;
        }
        cVar.g = opacity;
        cVar.f = true;
        return opacity;
    }

    public boolean isStateful() {
        boolean z = false;
        c cVar = this.a;
        if (cVar.h) {
            return cVar.i;
        }
        i[] iVarArr = cVar.b;
        int i = cVar.a;
        for (int i2 = 0; i2 < i; i2++) {
            if (iVarArr[i2].a.isStateful()) {
                z = true;
                break;
            }
        }
        cVar.i = z;
        cVar.h = true;
        return z;
    }

    protected boolean onStateChange(int[] iArr) {
        boolean z = false;
        i[] iVarArr = this.a.b;
        int i = this.a.a;
        boolean z2 = false;
        for (int i2 = 0; i2 < i; i2++) {
            i iVar = iVarArr[i2];
            if (iVar.a.isStateful() && iVar.a.setState(iArr)) {
                z = true;
            }
            if (a(i2, iVar)) {
                z2 = true;
            }
        }
        if (z2) {
            onBoundsChange(getBounds());
        }
        return z;
    }

    protected boolean onLevelChange(int i) {
        boolean z = false;
        i[] iVarArr = this.a.b;
        int i2 = this.a.a;
        boolean z2 = false;
        for (int i3 = 0; i3 < i2; i3++) {
            i iVar = iVarArr[i3];
            if (iVar.a.setLevel(i)) {
                z = true;
            }
            if (a(i3, iVar)) {
                z2 = true;
            }
        }
        if (z2) {
            onBoundsChange(getBounds());
        }
        return z;
    }

    protected void onBoundsChange(Rect rect) {
        int i;
        int i2 = 0;
        if (this.a.k == 0) {
            i = 1;
        } else {
            i = 0;
        }
        i[] iVarArr = this.a.b;
        int i3 = this.a.a;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < i3; i7++) {
            i iVar = iVarArr[i7];
            iVar.a.setBounds((rect.left + iVar.c) + i6, (rect.top + iVar.d) + i5, (rect.right - iVar.e) - i4, (rect.bottom - iVar.f) - i2);
            if (i != 0) {
                i6 += this.d[i7];
                i4 += this.f[i7];
                i5 += this.e[i7];
                i2 += this.g[i7];
            }
        }
    }

    public int getIntrinsicWidth() {
        int i;
        int i2 = 0;
        int i3 = -1;
        if (this.a.k == 0) {
            i = 1;
        } else {
            i = 0;
        }
        i[] iVarArr = this.a.b;
        int i4 = this.a.a;
        int i5 = 0;
        int i6 = 0;
        while (i5 < i4) {
            i iVar = iVarArr[i5];
            int intrinsicWidth = ((iVar.e + (iVar.a.getIntrinsicWidth() + iVar.c)) + i6) + i2;
            if (intrinsicWidth <= i3) {
                intrinsicWidth = i3;
            }
            if (i != 0) {
                i6 += this.d[i5];
                i2 += this.f[i5];
            }
            i5++;
            i3 = intrinsicWidth;
        }
        return i3;
    }

    public int getIntrinsicHeight() {
        int i;
        int i2 = 0;
        int i3 = -1;
        if (this.a.k == 0) {
            i = 1;
        } else {
            i = 0;
        }
        i[] iVarArr = this.a.b;
        int i4 = this.a.a;
        int i5 = 0;
        int i6 = 0;
        while (i5 < i4) {
            i iVar = iVarArr[i5];
            int intrinsicHeight = ((iVar.f + (iVar.a.getIntrinsicHeight() + iVar.d)) + i6) + i2;
            if (intrinsicHeight <= i3) {
                intrinsicHeight = i3;
            }
            if (i != 0) {
                i6 += this.e[i5];
                i2 += this.g[i5];
            }
            i5++;
            i3 = intrinsicHeight;
        }
        return i3;
    }

    private boolean a(int i, i iVar) {
        Rect rect = this.h;
        iVar.a.getPadding(rect);
        if (rect.left == this.d[i] && rect.top == this.e[i] && rect.right == this.f[i] && rect.bottom == this.g[i]) {
            return false;
        }
        this.d[i] = rect.left;
        this.e[i] = rect.top;
        this.f[i] = rect.right;
        this.g[i] = rect.bottom;
        return true;
    }

    final void a() {
        int i = this.a.a;
        if (this.d == null || this.d.length < i) {
            this.d = new int[i];
            this.e = new int[i];
            this.f = new int[i];
            this.g = new int[i];
        }
    }

    public ConstantState getConstantState() {
        Object obj = null;
        c cVar = this.a;
        i[] iVarArr = cVar.b;
        int i = cVar.a;
        for (int i2 = 0; i2 < i; i2++) {
            if (iVarArr[i2].a.getConstantState() == null) {
                break;
            }
        }
        obj = 1;
        if (obj == null) {
            return null;
        }
        this.a.d = getChangingConfigurations();
        return this.a;
    }

    public Drawable mutate() {
        if (!this.j && super.mutate() == this) {
            this.a = a(this.a, null);
            i[] iVarArr = this.a.b;
            int i = this.a.a;
            for (int i2 = 0; i2 < i; i2++) {
                iVarArr[i2].a.mutate();
            }
            this.j = true;
        }
        return this;
    }
}
