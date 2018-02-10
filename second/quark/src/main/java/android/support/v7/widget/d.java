package android.support.v7.widget;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.bo;
import android.view.View;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
final class d extends r {
    final /* synthetic */ bh a;
    final /* synthetic */ bo b;
    final /* synthetic */ ab c;

    d(ab abVar, bh bhVar, bo boVar) {
        this.c = abVar;
        this.a = bhVar;
        this.b = boVar;
        super();
    }

    public final void a(View view) {
    }

    public final void b(View view) {
        this.b.a(null);
        ViewCompat.c(view, (float) IPictureView.DEFAULT_MIN_SCALE);
        this.c.g(this.a);
        this.c.l.remove(this.a);
        this.c.e();
    }
}
