package com.ucpro.feature.setting.view.d;

import android.content.Context;
import android.view.ViewGroup.LayoutParams;
import com.quark.browser.R;
import com.ucpro.business.stat.a.d;
import com.ucpro.feature.setting.a.g;
import com.ucpro.feature.setting.a.h;
import com.ucpro.feature.setting.d.q;
import com.ucpro.feature.setting.d.x;
import com.ucpro.feature.setting.view.c.b;
import com.ucpro.feature.setting.view.c.c;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
public final class n extends ac implements d, q {
    private c f;
    private g g;
    private x h = null;

    public n(Context context, i iVar) {
        super(context, iVar);
        this.g = iVar;
        n();
        this.f = new b(getContext());
        this.f.setSettingViewCallback(this);
        a();
        getContentLayer().addView(this.f.getSettingView(), new LayoutParams(-1, -1));
    }

    public final void setPresenter(com.ucpro.base.d.b bVar) {
        com.ucweb.common.util.c.b(bVar instanceof x);
        this.h = (x) bVar;
    }

    public final void a() {
        if (this.f != null && this.g != null) {
            ((b) this.f).setFontSize(Integer.valueOf(this.g.a(h.H)).intValue());
        }
    }

    public final void setFontSeekChangedListener(com.ucpro.feature.setting.view.a.c cVar) {
        ((b) this.f).setListener(cVar);
    }

    public final void a(int[] iArr, String[] strArr) {
        ((b) this.f).setFontSizeArray(iArr);
        ((b) this.f).setFontSizeTips(strArr);
    }

    public final String getTitleText() {
        return a.d((int) R.string.browse_setting_item_font_size);
    }

    public final void a(com.ucpro.feature.setting.view.item.h hVar, int i, Object obj) {
        i settingWindowCallback = getSettingWindowCallback();
        if (settingWindowCallback != null) {
            settingWindowCallback.a(i, obj);
        }
    }

    public final void l() {
        super.l();
        m();
        this.f.a();
    }

    protected final void a(byte b) {
        super.a(b);
        if ((byte) 13 == b) {
            this.h.c();
        }
    }

    public final String getSpm() {
        return com.ucpro.business.stat.a.a.a("9102241");
    }

    public final String getPageName() {
        return "Page_font_size";
    }
}
