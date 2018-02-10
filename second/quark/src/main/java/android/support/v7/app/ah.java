package android.support.v7.app;

import android.graphics.Rect;
import android.support.v7.widget.br;

/* compiled from: ProGuard */
final class ah implements br {
    final /* synthetic */ AppCompatDelegateImplV7 a;

    ah(AppCompatDelegateImplV7 appCompatDelegateImplV7) {
        this.a = appCompatDelegateImplV7;
    }

    public final void a(Rect rect) {
        rect.top = AppCompatDelegateImplV7.b(this.a, rect.top);
    }
}
