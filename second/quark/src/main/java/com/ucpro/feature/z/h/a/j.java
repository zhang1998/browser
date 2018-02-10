package com.ucpro.feature.z.h.a;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.uc.imagecodec.export.IPictureView;
import com.ucpro.base.a.e;
import com.ucpro.base.a.g;
import com.ucpro.business.stat.a.d;
import com.ucpro.feature.webwindow.bn;
import com.ucpro.feature.y.b;
import com.ucpro.feature.z.a.c;
import com.ucpro.ui.c.a;
import com.ucpro.ui.widget.h;

/* compiled from: ProGuard */
public final class j extends FrameLayout implements d {
    public e a;
    private View b;
    private boolean c;

    public j(Context context) {
        super(context);
        this.b = null;
        this.a = null;
        this.c = false;
        this.b = new View(getContext());
        addView(this.b, c());
        this.a = new e(getContext());
        addView(this.a, c());
        e eVar = this.a;
        eVar.n = new l(eVar);
        eVar.m = new h(eVar);
        a();
    }

    public final void a() {
        this.b.setBackgroundColor(a.c("default_background_white"));
        this.a.a();
    }

    private static LayoutParams c() {
        return new LayoutParams(-1, -1);
    }

    public final boolean dispatchKeyEventPreIme(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            g.a().b(e.as);
            if (this.c) {
                return true;
            }
        }
        return super.dispatchKeyEventPreIme(keyEvent);
    }

    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 67) {
            super.dispatchKeyEvent(keyEvent);
            return true;
        } else if (keyEvent.getKeyCode() != 4) {
            return super.dispatchKeyEvent(keyEvent);
        } else {
            if (keyEvent.getAction() != 1) {
                return true;
            }
            g.a().b(e.ar);
            return true;
        }
    }

    public final c getSearchBar() {
        return this.a.getSearchBar();
    }

    public final h getMirrorAddressBar() {
        return this.a.getMirrorAddressBar();
    }

    public final h getMirrorInputView() {
        return this.a.getMirrorInputView();
    }

    public final com.ucpro.feature.z.d.g getInputHistoryView() {
        return this.a.getInputHistoryView();
    }

    public final com.ucpro.feature.z.b.a getInputEnhanceView() {
        return this.a.getInputEnhanceView();
    }

    public final com.ucpro.feature.z.e.g getAssociateView() {
        return this.a.getAssociateView();
    }

    public final View getBarShadowView() {
        return this.a.getBarShadowView();
    }

    public final h getMirrorLogo() {
        return this.a.getMirrorLogo();
    }

    public final int getSearchBarInitY() {
        return this.a.getSearchBarInitY();
    }

    public final h getMirrorNavigationView() {
        return this.a.getMirrorNavigationView();
    }

    public final e getSearchPage() {
        return this.a;
    }

    public final View getBgView() {
        return this.b;
    }

    public final void setHomePage(b bVar) {
        this.a.setHomePage(bVar);
    }

    public final int getSearchBarLocationBottom() {
        return this.a.getSearchBarLocationBottom();
    }

    public final void setNeedInterceptPreIme(boolean z) {
        this.c = z;
    }

    public final void b() {
        setAlpha(IPictureView.DEFAULT_MIN_SCALE);
        this.b.setAlpha(IPictureView.DEFAULT_MIN_SCALE);
        e eVar = this.a;
        eVar.setAlpha(IPictureView.DEFAULT_MIN_SCALE);
        eVar.a.getUrlEditText().setText((CharSequence) "");
        eVar.a.getUrlEditText().clearFocus();
        com.ucpro.feature.z.d.g gVar = eVar.c;
        if (gVar.a.a) {
            gVar.a.setExpanded(false);
        }
        eVar.c.setVisibility(8);
        eVar.d.setVisibility(8);
        eVar.b.setVisibility(8);
        eVar.a.setVisibility(8);
        if (eVar.f != null) {
            eVar.f.setVisibility(8);
            eVar.f.setY((float) eVar.f.getTop());
        }
        if (eVar.g != null) {
            eVar.g.setVisibility(8);
        }
        if (eVar.h != null) {
            eVar.h.setVisibility(8);
        }
        eVar.e.setVisibility(8);
        if (eVar.d.getLayoutAnimation() == null) {
            eVar.d.setLayoutAnimation(eVar.i);
            return;
        }
        eVar.d.getLayoutAnimation().getAnimation().setDuration(200);
        eVar.d.scheduleLayoutAnimation();
    }

    public final void setHomeToolBar(bn bnVar) {
        this.a.setHomeToolBar(bnVar);
    }

    public final com.ucpro.feature.z.c.d getCopyTipView() {
        return this.a.getCopyTipView();
    }

    public final float getSearchBarInitYWithoutTransY() {
        return (float) this.a.getSearchBarInitYWithoutTransY();
    }

    public final h getMirrorToolBar() {
        return this.a.getMirrorToolBar();
    }

    public final String getSpm() {
        return com.ucpro.business.stat.a.a.a("8995277");
    }

    public final String getPageName() {
        return "Page_home_search";
    }
}
