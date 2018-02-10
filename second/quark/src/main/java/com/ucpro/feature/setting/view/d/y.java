package com.ucpro.feature.setting.view.d;

import android.content.Context;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ListView;
import com.quark.browser.R;
import com.ucpro.base.d.b;
import com.ucpro.feature.setting.d.c;
import com.ucpro.feature.setting.d.f;
import com.ucpro.feature.setting.view.c.a.a;
import com.ucpro.feature.setting.view.item.h;

/* compiled from: ProGuard */
public final class y extends ac implements f {
    private a f = new a(getContext());
    private c g;

    public y(Context context, i iVar) {
        super(context, iVar);
        getTitleBar().a.setBackgroundColor(0);
        com.ucweb.common.util.c.b(getContentLayer().getParent().getParent() instanceof FrameLayout);
        ((FrameLayout) getContentLayer().getParent().getParent()).addView(this.f, 0, new LayoutParams(-1, -1));
        this.f.getFooterView().setOnClickListener(new m(this));
    }

    public final String getTitleText() {
        return com.ucpro.ui.c.a.d((int) R.string.main_setting_item_quark_lab_title);
    }

    public final void a(h hVar, int i, Object obj) {
    }

    public final void setPresenter(b bVar) {
        this.g = (c) bVar;
    }

    public final ListView getListView() {
        return this.f.getListView();
    }

    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.g.a();
    }

    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.g.b();
    }
}
