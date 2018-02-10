package com.ucpro.feature.l.c;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.quark.browser.R;
import com.ucpro.ui.c.a;
import com.ucpro.ui.widget.tablayout.ProTabLayout;
import com.ucpro.ui.widget.viewpager.ProViewPager;
import com.ucpro.ui.widget.viewpager.n;

/* compiled from: ProGuard */
public final class h extends LinearLayout implements n {
    private ProViewPager a;
    private ProTabLayout b = new ProTabLayout(getContext());

    public h(Context context) {
        super(context);
        setOrientation(1);
        setGravity(1);
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, a.c((int) R.dimen.dicover_page_tab_height));
        this.b.setTabGravity(1);
        addView(this.b, layoutParams);
        this.a = new ProViewPager(getContext());
        addView(this.a, new FrameLayout.LayoutParams(-1, -1));
        this.a.setOffscreenPageLimit(1);
        this.a.a((n) this);
        a();
    }

    public final void a(int i, float f) {
    }

    public final void a(int i) {
        int childCount = getViewPager().getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = getViewPager().getChildAt(i2);
            if ((childAt instanceof m) && i2 == i) {
                ((m) childAt).a();
            }
            i2++;
        }
    }

    public final void b(int i) {
    }

    public final void a() {
        if (this.a != null) {
            this.a.setBackgroundColor(a.c("default_background_white"));
        }
        if (this.b != null) {
            this.b.setSelectedTabIndicatorColor(a.c("default_maintext_gray"));
            this.b.a(a.c("title_bar_tab_normal_color"), a.c("default_maintext_gray"));
            this.b.setBackgroundColor(a.c("default_background_white"));
        }
        int childCount = getViewPager().getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getViewPager().getChildAt(i);
            if (childAt instanceof m) {
                ((m) childAt).c();
            }
        }
    }

    public final ProViewPager getViewPager() {
        return this.a;
    }

    public final ProTabLayout getTabLayout() {
        return this.b;
    }
}
