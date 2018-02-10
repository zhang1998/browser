package android.support.v7.widget;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;

/* compiled from: ProGuard */
final class da implements OnGlobalLayoutListener {
    final /* synthetic */ ActivityChooserView a;

    da(ActivityChooserView activityChooserView) {
        this.a = activityChooserView;
    }

    public final void onGlobalLayout() {
        if (!this.a.getListPopupWindow().a.isShowing()) {
            return;
        }
        if (this.a.isShown()) {
            this.a.getListPopupWindow().b();
            if (this.a.a != null) {
                this.a.a.a(true);
                return;
            }
            return;
        }
        this.a.getListPopupWindow().c();
    }
}
