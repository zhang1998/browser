package android.support.v7.widget;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.PopupWindow.OnDismissListener;

/* compiled from: ProGuard */
final class cy implements OnDismissListener {
    final /* synthetic */ OnGlobalLayoutListener a;
    final /* synthetic */ ej b;

    cy(ej ejVar, OnGlobalLayoutListener onGlobalLayoutListener) {
        this.b = ejVar;
        this.a = onGlobalLayoutListener;
    }

    public final void onDismiss() {
        ViewTreeObserver viewTreeObserver = this.b.m.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.a);
        }
    }
}
