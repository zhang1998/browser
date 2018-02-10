package android.support.v7.widget;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.bo;
import android.view.View;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
final class ao extends r {
    final /* synthetic */ bh a;
    final /* synthetic */ bo b;
    final /* synthetic */ ab c;

    ao(ab abVar, bh bhVar, bo boVar) {
        this.c = abVar;
        this.a = bhVar;
        this.b = boVar;
        super();
    }

    public final void a(View view) {
    }

    public final void c(View view) {
        ViewCompat.c(view, (float) IPictureView.DEFAULT_MIN_SCALE);
    }

    public final void b(View view) {
        this.b.a(null);
        this.c.g(this.a);
        this.c.j.remove(this.a);
        this.c.e();
    }
}
