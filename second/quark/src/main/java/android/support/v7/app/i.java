package android.support.v7.app;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.cy;
import android.view.View;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
final class i extends cy {
    final /* synthetic */ ay a;

    i(ay ayVar) {
        this.a = ayVar;
    }

    public final void b(View view) {
        ViewCompat.c(this.a.a.b, (float) IPictureView.DEFAULT_MIN_SCALE);
        this.a.a.e.a(null);
        this.a.a.e = null;
    }

    public final void a(View view) {
        this.a.a.b.setVisibility(0);
    }
}
