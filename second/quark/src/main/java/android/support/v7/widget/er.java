package android.support.v7.widget;

import android.support.v7.view.h;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: ProGuard */
final class er implements OnClickListener {
    final /* synthetic */ h a;
    final /* synthetic */ ActionBarContextView b;

    er(ActionBarContextView actionBarContextView, h hVar) {
        this.b = actionBarContextView;
        this.a = hVar;
    }

    public final void onClick(View view) {
        this.a.c();
    }
}
