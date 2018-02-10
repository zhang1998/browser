package com.ucpro.feature.navigation.view;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.widget.GridView;
import com.quark.browser.R;
import com.ucpro.b.a.a;
import com.ucpro.c.d;

/* compiled from: ProGuard */
public final class s extends GridView {
    public v a;
    private Parcelable b;
    private ai c;
    private int d = 1;
    private int e = 0;

    public s(Context context) {
        super(context);
        setStretchMode(2);
        setCacheColorHint(0);
        setSelector(new ColorDrawable(0));
        setFadingEdgeLength(0);
        setVerticalScrollBarEnabled(false);
        setGravity(17);
        setClipToPadding(false);
        if (a.a() && d.a()) {
            setClipChildren(false);
        }
        this.a = new v(this);
        this.c = new ai(this);
    }

    private void d() {
        setNumColumns(this.d);
        setVerticalSpacing(this.e);
    }

    public final void setPortraitColumnNum(int i) {
        this.d = i;
        d();
    }

    public final void setVerticalSpacings(int i) {
        this.e = i;
        d();
    }

    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.b != null) {
            onRestoreInstanceState(this.b);
        }
    }

    protected final void onDetachedFromWindow() {
        this.b = onSaveInstanceState();
        super.onDetachedFromWindow();
    }

    public final void a(int i, int i2, int i3, Runnable runnable) {
        v vVar = this.a;
        if (vVar.a.getChildCount() > 0 && i >= 0 && i2 >= 0 && i != i2) {
            int i4 = 0;
            int i5;
            if (i < i2) {
                for (i5 = i + 1; i5 <= i2; i5++) {
                    vVar.a(vVar.a.getChildAt(i5), vVar.a.getChildAt(i5 - 1), (long) i4, runnable);
                    i4 += 20;
                }
                return;
            }
            if (i == i3) {
                vVar.a(vVar.a.getChildAt(i - 1), vVar.a.getRectAfterLastChild(), 0, runnable);
                i4 = 20;
                i--;
            }
            for (i5 = i - 1; i5 >= i2; i5--) {
                vVar.a(vVar.a.getChildAt(i5), vVar.a.getChildAt(i5 + 1), (long) i4, runnable);
                i4 += 20;
            }
        }
    }

    public final void a() {
        for (int i = 0; i < getChildCount(); i++) {
            getChildAt(i).setAnimation(null);
        }
        this.a.b.clear();
    }

    public final boolean b() {
        return this.a.b.size() > 0;
    }

    public final int getMeasuredHorizontalSpacing() {
        int width = ((getWidth() - getPaddingLeft()) - getPaddingRight()) - (com.ucpro.ui.c.a.c((int) R.dimen.launcher_widget_width_portrait) * getNumColumns());
        if (getNumColumns() > 1) {
            return (width / getNumColumns()) - 1;
        }
        return 0;
    }

    public final Rect getRectAfterLastChild() {
        Rect a = t.a(getChildAt(getChildCount() - 1));
        if (getChildCount() < getNumColumns() || getChildCount() % getNumColumns() != 0) {
            a.offset(getMeasuredHorizontalSpacing() + com.ucpro.ui.c.a.c((int) R.dimen.launcher_widget_width_portrait), 0);
            return a;
        }
        a = t.a(getChildAt(getChildCount() - getNumColumns()));
        a.offset(0, getGridVerticalSpacing() + com.ucpro.ui.c.a.c((int) R.dimen.launcher_widget_height_portrait));
        return a;
    }

    private int getGridVerticalSpacing() {
        if (VERSION.SDK_INT >= 19) {
            return getVerticalSpacing();
        }
        Object b = com.ucweb.common.util.b.a.b(this, "mVerticalSpacing");
        if (b instanceof Integer) {
            return ((Integer) b).intValue();
        }
        return 0;
    }

    public final int getNumColumns() {
        return this.d;
    }

    public final void c() {
        ai aiVar = this.c;
        if (aiVar.d) {
            aiVar.d = false;
            aiVar.e.removeCallbacks(aiVar.c);
        }
    }

    public final void a(int i) {
        ai aiVar = this.c;
        if (!aiVar.d) {
            aiVar.d = true;
            aiVar.c.a = i;
            aiVar.e.post(aiVar.c);
        }
    }
}
