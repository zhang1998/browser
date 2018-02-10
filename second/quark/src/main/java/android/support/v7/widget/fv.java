package android.support.v7.widget;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

/* compiled from: ProGuard */
final class fv implements OnItemSelectedListener {
    final /* synthetic */ SearchView a;

    fv(SearchView searchView) {
        this.a = searchView;
    }

    public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        SearchView.b(this.a, i);
    }

    public final void onNothingSelected(AdapterView<?> adapterView) {
    }
}
