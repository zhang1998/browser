package android.support.v7.widget;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: ProGuard */
final class cz implements OnClickListener {
    final /* synthetic */ SearchView a;

    cz(SearchView searchView) {
        this.a = searchView;
    }

    public final void onClick(View view) {
        if (view == this.a.h) {
            this.a.k();
        } else if (view == this.a.j) {
            this.a.j();
        } else if (view == this.a.i) {
            SearchView.j(this.a);
        } else if (view == this.a.k) {
            SearchView.l(this.a);
        } else if (view == this.a.d) {
            this.a.l();
        }
    }
}
