package android.support.v7.view.menu;

import android.support.v7.view.c;
import android.view.CollapsibleActionView;
import android.view.View;
import android.widget.FrameLayout;

/* compiled from: ProGuard */
final class aa extends FrameLayout implements c {
    final CollapsibleActionView a;

    aa(View view) {
        super(view.getContext());
        this.a = (CollapsibleActionView) view;
        addView(view);
    }

    public final void a() {
        this.a.onActionViewExpanded();
    }

    public final void b() {
        this.a.onActionViewCollapsed();
    }
}
