package android.support.v7.widget;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.bo;
import android.view.View;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
final class t extends r {
    final /* synthetic */ al a;
    final /* synthetic */ bo b;
    final /* synthetic */ ab c;

    t(ab abVar, al alVar, bo boVar) {
        this.c = abVar;
        this.a = alVar;
        this.b = boVar;
        super();
    }

    public final void a(View view) {
    }

    public final void b(View view) {
        this.b.a(null);
        ViewCompat.c(view, (float) IPictureView.DEFAULT_MIN_SCALE);
        ViewCompat.a(view, 0.0f);
        ViewCompat.b(view, 0.0f);
        this.c.g(this.a.a);
        this.c.m.remove(this.a.a);
        this.c.e();
    }
}
