package android.support.v4.widget;

import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.WindowInsets;

/* compiled from: ProGuard */
final class h implements OnApplyWindowInsetsListener {
    h() {
    }

    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        ((e) view).a(windowInsets, windowInsets.getSystemWindowInsetTop() > 0);
        return windowInsets.consumeSystemWindowInsets();
    }
}
