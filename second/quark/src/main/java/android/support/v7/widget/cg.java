package android.support.v7.widget;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;

/* compiled from: ProGuard */
final class cg implements OnGlobalLayoutListener {
    final /* synthetic */ SearchView a;

    cg(SearchView searchView) {
        this.a = searchView;
    }

    public final void onGlobalLayout() {
        SearchView.d(this.a);
    }
}
