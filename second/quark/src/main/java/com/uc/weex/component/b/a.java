package com.uc.weex.component.b;

import android.widget.ImageView;
import com.uc.weex.component.b;
import com.uc.weex.component.c;

/* compiled from: ProGuard */
final class a implements c {
    final /* synthetic */ ImageView a;
    final /* synthetic */ b b;

    a(b bVar, ImageView imageView) {
        this.b = bVar;
        this.a = imageView;
    }

    public final void a() {
        if (this.b.d > 0) {
            this.b.e = this.b.e + 1;
            if (this.b.d == this.b.e) {
                b.d(this.b);
                b.a().b().a(this.a.getDrawable());
            }
        }
    }
}
