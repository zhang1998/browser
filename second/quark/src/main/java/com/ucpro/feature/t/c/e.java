package com.ucpro.feature.t.c;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.quark.browser.R;
import com.ucpro.feature.webwindow.ar;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
public final class e extends ar {
    d b = null;

    public e(Context context) {
        super(context);
        setWillNotDraw(false);
        this.b = new d(this, getContext(), "multiwindow_remove_all.svg", "multi_window_remove_text_color", a.d((int) R.string.multi_window_remove_all_tip));
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        addView(this.b, layoutParams);
        a();
    }

    public final void a() {
        this.b.a();
        setBackgroundDrawable(a.c());
    }

    public final void c() {
        d dVar = this.b;
        if (dVar.e != null) {
            dVar.e.cancel();
        }
        dVar.e = ValueAnimator.ofInt(new int[]{dVar.d, dVar.b});
        dVar.e.addUpdateListener(new k(dVar));
        dVar.e.setDuration(300);
        dVar.e.start();
        dVar.a = false;
    }
}
