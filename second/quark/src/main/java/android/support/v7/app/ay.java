package android.support.v7.app;

import android.support.v4.view.ViewCompat;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
final class ay implements Runnable {
    final /* synthetic */ AppCompatDelegateImplV7 a;

    ay(AppCompatDelegateImplV7 appCompatDelegateImplV7) {
        this.a = appCompatDelegateImplV7;
    }

    public final void run() {
        this.a.c.showAtLocation(this.a.b, 55, 0, 0);
        this.a.g();
        ViewCompat.c(this.a.b, 0.0f);
        this.a.e = ViewCompat.q(this.a.b).a((float) IPictureView.DEFAULT_MIN_SCALE);
        this.a.e.a(new i(this));
    }
}
