package com.ucpro.feature.s.b;

import android.content.Context;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.quark.browser.R;
import com.uc.imagecodec.export.IPictureView;
import com.ucpro.feature.s.b.a.c;
import com.ucpro.ui.c.a;
import com.ucpro.ui.widget.tablayout.ProTabLayout;
import com.ucpro.ui.widget.viewpager.ProViewPager;
import com.ucpro.ui.widget.viewpager.n;

/* compiled from: ProGuard */
public final class b extends LinearLayout implements c, n {
    private ProViewPager a;
    private ProTabLayout b = new ProTabLayout(getContext());
    private g c;
    private c d;

    public b(Context context) {
        super(context);
        setOrientation(1);
        this.b.setUseBoldTabStyle(false);
        this.b.setScrollableTabMinWidth(a.c((int) R.dimen.discovery_navi_view_tab_min_width));
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.leftMargin = a.c((int) R.dimen.discovery_navi_view_tablayout_margin_left);
        layoutParams.rightMargin = a.c((int) R.dimen.discovery_navi_view_tablayout_margin_right);
        layoutParams.topMargin = a.c((int) R.dimen.discovery_navi_view_tablayout_margin_top);
        layoutParams.bottomMargin = a.c((int) R.dimen.discovery_navi_view_tablayout_margin_bottom);
        layoutParams.gravity = 1;
        addView(this.b, layoutParams);
        this.a = new ProViewPager(getContext());
        this.a.setOffscreenPageLimit(2);
        this.a.a((n) this);
        layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.weight = IPictureView.DEFAULT_MIN_SCALE;
        int c = a.c((int) R.dimen.discovery_navi_view_group_margin_x);
        layoutParams.rightMargin = c;
        layoutParams.leftMargin = c;
        addView(this.a, layoutParams);
        if (this.b != null) {
            this.b.setSelectedTabIndicatorColor(a.c("default_maintext_gray"));
            this.b.a(a.c("title_bar_tab_normal_color"), a.c("default_maintext_gray"));
        }
    }

    public final void setListener(c cVar) {
        this.d = cVar;
    }

    public final boolean a() {
        if (this.c.b instanceof c) {
            return ((c) this.c.b).a();
        }
        return true;
    }

    public final void a(int i, float f) {
    }

    public final void a(int i) {
        if (this.d != null) {
            this.d.a(getCurrentTabName());
        }
    }

    public final void b(int i) {
    }

    public final String getCurrentTabName() {
        String str = "";
        int selectedTabPosition = this.b.getSelectedTabPosition();
        if (selectedTabPosition < 0 || selectedTabPosition >= this.b.getTabCount()) {
            return str;
        }
        com.ucpro.ui.widget.tablayout.c a = this.b.a(selectedTabPosition);
        if (a == null || a.c == null) {
            return str;
        }
        return a.c.toString();
    }

    public final void setAdapter(g gVar) {
        this.c = gVar;
        this.a.setAdapter(gVar);
        this.b.setupWithViewPager(this.a);
    }
}
