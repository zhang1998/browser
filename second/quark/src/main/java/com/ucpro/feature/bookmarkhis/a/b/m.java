package com.ucpro.feature.bookmarkhis.a.b;

import android.view.View;
import android.view.View.OnLongClickListener;

/* compiled from: ProGuard */
final class m implements OnLongClickListener {
    final /* synthetic */ g a;
    final /* synthetic */ d b;
    final /* synthetic */ c c;

    m(c cVar, g gVar, d dVar) {
        this.c = cVar;
        this.a = gVar;
        this.b = dVar;
    }

    public final boolean onLongClick(View view) {
        if (this.a != null) {
            this.a.a(this.c, this.b);
        }
        return true;
    }
}
