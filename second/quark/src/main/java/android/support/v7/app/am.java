package android.support.v7.app;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.cy;
import android.view.View;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
final class am extends cy {
    final /* synthetic */ AppCompatDelegateImplV7 a;

    am(AppCompatDelegateImplV7 appCompatDelegateImplV7) {
        this.a = appCompatDelegateImplV7;
    }

    public final void b(View view) {
        ViewCompat.c(this.a.b, (float) IPictureView.DEFAULT_MIN_SCALE);
        this.a.e.a(null);
        this.a.e = null;
    }

    public final void a(View view) {
        this.a.b.setVisibility(0);
        this.a.b.sendAccessibilityEvent(32);
        if (this.a.b.getParent() != null) {
            ViewCompat.u((View) this.a.b.getParent());
        }
    }
}
