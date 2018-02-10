package android.support.v7.widget;

import android.view.View;

/* compiled from: ProGuard */
final class cw extends fm {
    final /* synthetic */ ej a;
    final /* synthetic */ AppCompatSpinner b;

    cw(AppCompatSpinner appCompatSpinner, View view, ej ejVar) {
        this.b = appCompatSpinner;
        this.a = ejVar;
        super(view);
    }

    public final ListPopupWindow a() {
        return this.a;
    }

    public final boolean b() {
        if (!this.b.j.a.isShowing()) {
            this.b.j.b();
        }
        return true;
    }
}
