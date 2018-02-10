package android.support.v7.widget;

import android.view.View;
import android.view.View.OnFocusChangeListener;

/* compiled from: ProGuard */
final class el implements OnFocusChangeListener {
    final /* synthetic */ SearchView a;

    el(SearchView searchView) {
        this.a = searchView;
    }

    public final void onFocusChange(View view, boolean z) {
        if (this.a.v != null) {
            this.a.v.onFocusChange(this.a, z);
        }
    }
}
