package android.mini.support.v7.widget;

import android.mini.support.v4.view.ViewCompat;
import android.mini.support.v4.view.cs;
import android.view.View;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
final class n extends q {
    final /* synthetic */ o a;
    final /* synthetic */ cs b;
    final /* synthetic */ View c;
    final /* synthetic */ r d;

    n(r rVar, o oVar, cs csVar, View view) {
        this.d = rVar;
        this.a = oVar;
        this.b = csVar;
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
        this.d.f(this.a.b);
        this.d.g.remove(this.a.b);
        this.d.c();
    }
}
