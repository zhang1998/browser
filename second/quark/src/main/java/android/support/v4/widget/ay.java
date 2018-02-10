package android.support.v4.widget;

import android.database.DataSetObserver;

/* compiled from: ProGuard */
final class ay extends DataSetObserver {
    final /* synthetic */ az a;

    private ay(az azVar) {
        this.a = azVar;
    }

    public final void onChanged() {
        this.a.b = true;
        this.a.notifyDataSetChanged();
    }

    public final void onInvalidated() {
        this.a.b = false;
        this.a.notifyDataSetInvalidated();
    }
}
