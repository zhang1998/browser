package android.support.v7.widget;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

/* compiled from: ProGuard */
final class ek implements OnItemClickListener {
    final /* synthetic */ SearchView a;

    ek(SearchView searchView) {
        this.a = searchView;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.a.a(i);
    }
}
