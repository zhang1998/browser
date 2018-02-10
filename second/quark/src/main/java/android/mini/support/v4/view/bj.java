package android.mini.support.v4.view;

import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.WindowInsets;

/* compiled from: ProGuard */
final class bj implements OnApplyWindowInsetsListener {
    final /* synthetic */ an a;

    bj(an anVar) {
        this.a = anVar;
    }

    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        return ((cz) this.a.a(view, new cz(windowInsets))).a;
    }
}
