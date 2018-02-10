package android.support.v7.widget;

import android.database.DataSetObserver;

/* compiled from: ProGuard */
final class dz extends DataSetObserver {
    final /* synthetic */ ActivityChooserView a;

    dz(ActivityChooserView activityChooserView) {
        this.a = activityChooserView;
    }

    public final void onChanged() {
        super.onChanged();
        this.a.b.notifyDataSetChanged();
    }

    public final void onInvalidated() {
        super.onInvalidated();
        this.a.b.notifyDataSetInvalidated();
    }
}
