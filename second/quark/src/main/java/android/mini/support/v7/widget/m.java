package android.mini.support.v7.widget;

import android.mini.support.v4.view.ViewCompat;
import android.mini.support.v4.view.cs;
import android.view.View;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
final class m extends q {
    final /* synthetic */ o a;
    final /* synthetic */ cs b;
    final /* synthetic */ r c;

    m(r rVar, o oVar, cs csVar) {
        this.c = rVar;
        this.a = oVar;
        this.b = csVar;
        super();
    }

    public final void a(View view) {
    }

    public final void b(View view) {
        this.b.a(null);
        ViewCompat.c(view, (float) IPictureView.DEFAULT_MIN_SCALE);
        ViewCompat.a(view, 0.0f);
        ViewCompat.b(view, 0.0f);
        this.c.f(this.a.a);
        this.c.g.remove(this.a.a);
        this.c.c();
    }
}
