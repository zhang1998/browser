package android.support.v7.widget;

import android.database.DataSetObserver;

/* compiled from: ProGuard */
final class eb extends DataSetObserver {
    final /* synthetic */ ActivityChooserView a;

    eb(ActivityChooserView activityChooserView) {
        this.a = activityChooserView;
    }

    public final void onChanged() {
        super.onChanged();
        ActivityChooserView.c(this.a);
    }
}
