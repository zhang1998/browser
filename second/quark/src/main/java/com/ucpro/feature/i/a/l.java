package com.ucpro.feature.i.a;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;

/* compiled from: ProGuard */
final class l implements k {
    private View a;

    l() {
    }

    @TargetApi(19)
    public final void a(Window window, int i) {
        window.addFlags(67108864);
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        View findViewWithTag = viewGroup.findViewWithTag("ghStatusBarView");
        if (findViewWithTag == null) {
            View view = new View(window.getContext());
            view.setTag("ghStatusBarView");
            int i2 = 0;
            Resources resources = window.getContext().getResources();
            int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
            if (identifier > 0) {
                i2 = resources.getDimensionPixelSize(identifier);
            }
            LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, i2);
            layoutParams.gravity = 48;
            view.setLayoutParams(layoutParams);
            findViewWithTag = view;
        }
        viewGroup.addView(findViewWithTag);
        findViewWithTag.setBackgroundColor(i);
        this.a = findViewWithTag;
        h.a(window);
    }
}
