package android.support.v7.widget;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

/* compiled from: ProGuard */
final class fa implements OnEditorActionListener {
    final /* synthetic */ SearchView a;

    fa(SearchView searchView) {
        this.a = searchView;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        SearchView.j(this.a);
        return true;
    }
}
