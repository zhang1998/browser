package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ListAdapter;
import android.widget.SpinnerAdapter;

/* compiled from: ProGuard */
final class ej extends ListPopupWindow {
    CharSequence l;
    final /* synthetic */ AppCompatSpinner m;
    private ListAdapter n;
    private final Rect o = new Rect();

    public ej(AppCompatSpinner appCompatSpinner, Context context, AttributeSet attributeSet, int i) {
        this.m = appCompatSpinner;
        super(context, attributeSet, i);
        this.j = appCompatSpinner;
        a();
        this.i = 0;
        this.k = new fz(this, appCompatSpinner);
    }

    public final void a(ListAdapter listAdapter) {
        super.a(listAdapter);
        this.n = listAdapter;
    }

    final void g() {
        int i;
        int i2;
        Drawable background = this.a.getBackground();
        if (background != null) {
            background.getPadding(this.m.l);
            i = co.a(this.m) ? this.m.l.right : -this.m.l.left;
        } else {
            Rect b = this.m.l;
            this.m.l.right = 0;
            b.left = 0;
            i = 0;
        }
        int paddingLeft = this.m.getPaddingLeft();
        int paddingRight = this.m.getPaddingRight();
        int width = this.m.getWidth();
        if (this.m.k == -2) {
            int a = this.m.a((SpinnerAdapter) this.n, this.a.getBackground());
            i2 = (this.m.getContext().getResources().getDisplayMetrics().widthPixels - this.m.l.left) - this.m.l.right;
            if (a <= i2) {
                i2 = a;
            }
            a(Math.max(i2, (width - paddingLeft) - paddingRight));
        } else if (this.m.k == -1) {
            a((width - paddingLeft) - paddingRight);
        } else {
            a(this.m.k);
        }
        if (co.a(this.m)) {
            i2 = ((width - paddingRight) - this.c) + i;
        } else {
            i2 = i + paddingLeft;
        }
        this.d = i2;
    }

    public final void b() {
        boolean isShowing = this.a.isShowing();
        g();
        d();
        super.b();
        this.b.setChoiceMode(1);
        int selectedItemPosition = this.m.getSelectedItemPosition();
        dk dkVar = this.b;
        if (this.a.isShowing() && dkVar != null) {
            dkVar.h = false;
            dkVar.setSelection(selectedItemPosition);
            if (VERSION.SDK_INT >= 11 && dkVar.getChoiceMode() != 0) {
                dkVar.setItemChecked(selectedItemPosition, true);
            }
        }
        if (!isShowing) {
            ViewTreeObserver viewTreeObserver = this.m.getViewTreeObserver();
            if (viewTreeObserver != null) {
                OnGlobalLayoutListener ceVar = new ce(this);
                viewTreeObserver.addOnGlobalLayoutListener(ceVar);
                a(new cy(this, ceVar));
            }
        }
    }

    static /* synthetic */ boolean a(ej ejVar, View view) {
        return ViewCompat.E(view) && view.getGlobalVisibleRect(ejVar.o);
    }
}
