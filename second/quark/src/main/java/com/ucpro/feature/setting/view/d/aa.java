package com.ucpro.feature.setting.view.d;

import android.content.Context;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.quark.browser.R;
import com.ucpro.base.a.g;
import com.ucpro.business.stat.a.d;
import com.ucpro.feature.setting.b.c.b;
import com.ucpro.feature.setting.view.c.c;
import com.ucpro.feature.setting.view.c.c.a;
import com.ucpro.feature.setting.view.item.h;
import com.ucpro.ui.b.e;
import com.ucweb.common.util.h.m;

/* compiled from: ProGuard */
public final class aa extends ac implements d {
    private static int f = 0;
    private c g;
    private Runnable h = new b(this);

    public aa(Context context, i iVar) {
        super(context, iVar);
        getTitleBar().a("");
        getTitleBar().a.setBackgroundColor(0);
        this.g = new a(getContext());
        this.g.setSettingViewCallback(this);
        com.ucweb.common.util.c.b(getContentLayer().getParent().getParent() instanceof FrameLayout);
        ((FrameLayout) getContentLayer().getParent().getParent()).addView(this.g.getSettingView(), 0, new LayoutParams(-1, -1));
    }

    public final String getTitleText() {
        return com.ucpro.ui.c.a.d((int) R.string.about_setting_window_title);
    }

    public final void a(h hVar, int i, Object obj) {
        i settingWindowCallback = getSettingWindowCallback();
        if (settingWindowCallback == null) {
            return;
        }
        if (com.ucpro.feature.setting.a.h.t != i) {
            settingWindowCallback.a(i, obj);
        } else if (!b.a.a()) {
            m.c(this.h);
            f++;
            m.a(2, this.h, 300);
            int i2 = f;
            if (i2 == 8) {
                b.a.a("76C1F34B9171FBB7", true);
                e.a().a(com.ucpro.ui.c.a.d((int) R.string.dev_model_open_tip), 0);
                g.a().a(com.ucpro.base.a.e.be);
                com.ucpro.business.stat.m.a("setting", "dev_open", new String[0]);
            } else if (i2 >= 5) {
                e.a().a(String.format(com.ucpro.ui.c.a.d((int) R.string.dev_model_open_contiune_tip), new Object[]{(8 - i2)}), 0);
            }
        }
    }

    public final void l() {
        super.l();
        if (this.g != null) {
            this.g.a();
        }
    }

    public final String getSpm() {
        return com.ucpro.business.stat.a.a.a("9102313");
    }

    public final String getPageName() {
        return "Page_about_browser";
    }
}
