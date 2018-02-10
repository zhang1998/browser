package android.support.v4.view;

import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.WindowInsets;

/* compiled from: ProGuard */
final class ac implements OnApplyWindowInsetsListener {
    final /* synthetic */ b a;

    ac(b bVar) {
        this.a = bVar;
    }

    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        return ((ae) this.a.a(view, new ae(windowInsets))).a;
    }
}
