package android.support.v7.widget;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.bo;
import android.view.View;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
final class i extends r {
    final /* synthetic */ al a;
    final /* synthetic */ bo b;
    final /* synthetic */ View c;
    final /* synthetic */ ab d;

    i(ab abVar, al alVar, bo boVar, View view) {
        this.d = abVar;
        this.a = alVar;
        this.b = boVar;
        this.c = view;
        super();
    }

    public final void a(View view) {
    }

    public final void b(View view) {
        this.b.a(null);
        ViewCompat.c(this.c, (float) IPictureView.DEFAULT_MIN_SCALE);
        ViewCompat.a(this.c, 0.0f);
        ViewCompat.b(this.c, 0.0f);
        this.d.g(this.a.b);
        this.d.m.remove(this.a.b);
        this.d.e();
    }
}
