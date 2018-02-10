package android.support.v7.widget;

import android.view.View;

/* compiled from: ProGuard */
final class bu extends fm {
    final /* synthetic */ ActivityChooserView a;

    bu(ActivityChooserView activityChooserView, View view) {
        this.a = activityChooserView;
        super(view);
    }

    public final ListPopupWindow a() {
        return this.a.getListPopupWindow();
    }

    protected final boolean b() {
        this.a.a();
        return true;
    }

    protected final boolean c() {
        this.a.b();
        return true;
    }
}
