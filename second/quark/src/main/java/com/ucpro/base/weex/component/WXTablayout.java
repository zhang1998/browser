package com.ucpro.base.weex.component;

import android.content.Context;
import android.support.annotation.Keep;
import android.support.annotation.NonNull;
import android.view.ViewGroup;
import com.quark.browser.R;
import com.taobao.weex.ac;
import com.taobao.weex.c.ae;
import com.taobao.weex.c.ai;
import com.taobao.weex.ui.component.WXComponentProp;
import com.taobao.weex.ui.component.ab;
import com.taobao.weex.ui.component.bv;
import com.ucpro.ui.c.a;
import com.ucpro.ui.widget.tablayout.ProTabLayout;
import com.ucpro.ui.widget.tablayout.c;
import com.ucpro.ui.widget.tablayout.d;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Keep
/* compiled from: ProGuard */
public class WXTablayout extends ab<ViewGroup> implements d {
    private static final String EVENT_TAB_SELECTED = "tabselected";
    private int mIconMainColor = a.c("default_maintext_gray");
    private ProTabLayout mProTabLayout = null;
    private f mTabContainer = null;

    public WXTablayout(ac acVar, ae aeVar, bv bvVar) {
        super(acVar, aeVar, bvVar);
    }

    protected ViewGroup initComponentHostView(@NonNull Context context) {
        this.mTabContainer = new f(this, context);
        this.mProTabLayout = new ProTabLayout(context);
        this.mProTabLayout.setTabMode(0);
        this.mProTabLayout.setUseBoldTabStyle(false);
        this.mProTabLayout.setTabTextSize((float) a.c((int) R.dimen.wxtablayout_textsize));
        this.mProTabLayout.setScrollableTabMinWidth(a.c((int) R.dimen.discovery_navi_view_tab_min_width));
        this.mProTabLayout.setOnTabSelectedListener(this);
        f fVar = this.mTabContainer;
        fVar.a = this.mProTabLayout;
        fVar.addView(fVar.a);
        onThemeChanged();
        return this.mTabContainer;
    }

    private void onThemeChanged() {
        this.mProTabLayout.setSelectedTabIndicatorColor(this.mIconMainColor);
        this.mProTabLayout.a(a.c("title_bar_tab_normal_color"), a.c("default_maintext_gray"));
    }

    @WXComponentProp(name = "select")
    public void select(int i) {
        if (this.mTabContainer != null && this.mTabContainer.getChildCount() > 0 && (this.mTabContainer.getChildAt(0) instanceof ProTabLayout)) {
            ProTabLayout proTabLayout = (ProTabLayout) this.mTabContainer.getChildAt(0);
            if (proTabLayout != null && i != proTabLayout.getSelectedTabPosition() && i >= 0 && i < proTabLayout.getTabCount()) {
                proTabLayout.b(proTabLayout.a(i), true);
            }
        }
    }

    @WXComponentProp(name = "themeType")
    public void themeType(String str) {
        onThemeChanged();
    }

    @WXComponentProp(name = "iconMainColor")
    public void iconMainColor(String str) {
        try {
            this.mIconMainColor = Integer.valueOf(str).intValue();
            onThemeChanged();
        } catch (Exception e) {
        }
    }

    @WXComponentProp(name = "setData")
    public void setData(List list) {
        if (this.mTabContainer != null && this.mTabContainer.getChildCount() > 0 && (this.mTabContainer.getChildAt(0) instanceof ProTabLayout)) {
            ProTabLayout proTabLayout = (ProTabLayout) this.mTabContainer.getChildAt(0);
            if (proTabLayout != null && list != null) {
                proTabLayout.b();
                for (int i = 0; i < list.size(); i++) {
                    boolean z;
                    c a = proTabLayout.a();
                    a.a(list.get(i).toString());
                    if (i == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    proTabLayout.a(a, z);
                }
            }
        }
    }

    public void onTabSelected(c cVar) {
        if (this.mTabContainer != null && this.mTabContainer.getChildCount() > 0 && (this.mTabContainer.getChildAt(0) instanceof ProTabLayout)) {
            ProTabLayout proTabLayout = (ProTabLayout) this.mTabContainer.getChildAt(0);
            if (proTabLayout != null && getDomObject().c_() != null && getDomObject().c_().size() != 0) {
                int selectedTabPosition = proTabLayout.getSelectedTabPosition();
                ai c_ = getDomObject().c_();
                String b_ = getDomObject().b_();
                Map hashMap = new HashMap();
                hashMap.put("index", Integer.valueOf(selectedTabPosition));
                if (c_.contains(EVENT_TAB_SELECTED)) {
                    getInstance().a(b_, EVENT_TAB_SELECTED, hashMap);
                }
            }
        }
    }

    public void onTabUnselected(c cVar) {
    }

    public void onTabReselected(c cVar) {
    }
}
