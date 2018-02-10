package com.ucpro.ui.widget.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/* compiled from: ProGuard */
public abstract class v extends BaseAdapter {
    private static final String b = v.class.getSimpleName();
    int a = -1;
    private int c = -1;

    public abstract View a(int i, View view, Object obj);

    public final void b(int i) {
        if (i < 0 || i >= getCount()) {
            this.c = -1;
        } else {
            this.c = i;
        }
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        int i2 = 0;
        if (view != null) {
            if (view.getAnimation() != null) {
                view.getAnimation().cancel();
                view.clearAnimation();
            }
            if (view.getVisibility() != 0) {
                view.setVisibility(0);
            }
        }
        Object obj = null;
        if (this.c != -1 && ((i >= this.c && this.a == 1) || (i <= this.c && this.a == 0))) {
            x.a(b, "change item count-----> moving upward is " + this.a + " and position is " + i + " and drag position is " + this.c);
            i2 = 1;
        }
        if (i2 != 0) {
            if (this.a == 1) {
                if (i + 1 < getCount()) {
                    obj = getItem(i + 1);
                }
            } else if (this.a == 0 && i - 1 >= 0) {
                obj = getItem(i - 1);
            }
        } else if (i >= 0 && i < getCount()) {
            obj = getItem(i);
        }
        return a(i, view, obj);
    }
}
