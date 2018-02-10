package com.ucpro.feature.setting.view.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.quark.browser.R;
import com.ucpro.business.stat.a.d;
import com.ucpro.feature.setting.a.b;
import com.ucpro.feature.setting.a.f;
import com.ucpro.feature.setting.a.g;
import com.ucpro.feature.setting.view.c.c;
import com.ucpro.feature.setting.view.c.e;
import com.ucpro.feature.setting.view.item.h;
import com.ucpro.ui.widget.w;

/* compiled from: ProGuard */
public final class a extends ac implements d {
    private c f = new e(getContext());
    private g g;
    private b h;
    private q i;

    public a(Context context, i iVar) {
        super(context, iVar);
        this.g = iVar;
        n();
        this.f.setSettingViewCallback(this);
        a();
        getContentLayer().addView(this.f.getSettingView(), new LayoutParams(-1, -1));
    }

    public final void a() {
        if (this.f != null) {
            if (this.h == null) {
                this.h = new b(getContext(), this.g);
                b bVar = this.h;
                com.ucpro.feature.setting.a.e a = f.a;
                getContext();
                bVar.a(a.a((byte) 2));
                this.f.setAdapter(this.h);
            }
            this.h.b();
        }
    }

    public final String getTitleText() {
        return com.ucpro.ui.c.a.d((int) R.string.wipe_cache_setting_window_title);
    }

    public final String getTitleBarRightImageName() {
        return "wipe_cache_delete.svg";
    }

    public final void a(h hVar, int i, Object obj) {
        i settingWindowCallback = getSettingWindowCallback();
        if (settingWindowCallback != null) {
            settingWindowCallback.a(i, obj);
        }
    }

    public final void a(com.ucpro.ui.widget.f fVar, View view, w wVar) {
        if (this.i == null) {
            return;
        }
        if (this.i.c()) {
            com.ucpro.ui.b.e.a().a(com.ucpro.ui.c.a.d((int) R.string.wipe_cache_setting_window_delete_button_tip), 0);
            this.i.b();
            return;
        }
        com.ucpro.ui.b.e.a().a(com.ucpro.ui.c.a.d((int) R.string.wipe_cache_setting_window_delete_button_tip_none), 0);
    }

    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        i settingWindowCallback = getSettingWindowCallback();
        if (settingWindowCallback != null) {
            settingWindowCallback.a(this);
        }
    }

    public final void setWipeCacheWindowPresenter(q qVar) {
        this.i = qVar;
    }

    public final String getSpm() {
        return com.ucpro.business.stat.a.a.a("9102121");
    }

    public final String getPageName() {
        return "Page_clear_cache";
    }

    public final void l() {
        super.l();
        m();
        if (this.h != null) {
            this.h.c();
        }
    }
}
