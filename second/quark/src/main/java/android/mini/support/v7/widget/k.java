package android.mini.support.v7.widget;

import android.mini.support.v4.view.ViewCompat;
import android.mini.support.v4.view.cs;
import android.view.View;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
final class k extends q {
    final /* synthetic */ bf a;
    final /* synthetic */ cs b;
    final /* synthetic */ r c;

    k(r rVar, bf bfVar, cs csVar) {
        this.c = rVar;
        this.a = bfVar;
        this.b = csVar;
        super();
    }

    public final void a(View view) {
    }

    public final void c(View view) {
        ViewCompat.c(view, (float) IPictureView.DEFAULT_MIN_SCALE);
    }

    public final void b(View view) {
        this.b.a(null);
        this.c.f(this.a);
        this.c.d.remove(this.a);
        this.c.c();
    }
}
