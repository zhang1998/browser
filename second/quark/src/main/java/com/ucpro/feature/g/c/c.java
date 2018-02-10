package com.ucpro.feature.g.c;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.quark.browser.R;
import com.uc.imagecodec.export.IPictureView;
import com.ucpro.base.c.b.g;
import com.ucpro.feature.g.c.b.a;
import com.ucpro.feature.g.c.b.b;
import com.ucpro.feature.g.c.b.e;
import com.ucpro.feature.g.c.b.i;
import com.ucpro.feature.g.c.b.o;
import com.ucpro.ui.widget.ad;
import com.ucpro.ui.widget.f;
import com.ucpro.ui.widget.j;
import com.ucpro.ui.widget.w;
import hugo.weaving.DebugLog;
import java.util.ArrayList;

/* compiled from: ProGuard */
public final class c extends j implements com.ucpro.base.c.b.c, o, k {
    private b g;
    private a h;
    private i i;

    public c(Context context) {
        super(context);
        this.f.a(com.ucpro.ui.c.a.d((int) R.string.cloud_sync));
        this.f.a(com.ucpro.ui.c.a.a("back.svg"));
        View imageView = new ImageView(context);
        imageView.setBackgroundDrawable(com.ucpro.ui.c.a.a("cloud_logo.svg"));
        LayoutParams layoutParams = new LinearLayout.LayoutParams(com.ucpro.ui.c.a.c((int) R.dimen.clound_sync_logo_width), com.ucpro.ui.c.a.c((int) R.dimen.clound_sync_logo_height));
        layoutParams.gravity = 17;
        layoutParams.topMargin = com.ucpro.ui.c.a.c((int) R.dimen.clound_sync_logo_margin_top);
        this.e.addView(imageView, layoutParams);
        this.i = new i(getContext());
        this.i.setIOtherLogin(this);
        LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        layoutParams2.topMargin = com.ucpro.ui.c.a.c((int) R.dimen.clound_sync_margin_logo_top);
        layoutParams2.leftMargin = com.ucpro.ui.c.a.c((int) R.dimen.clound_sync_phone_number_margin_left);
        layoutParams2.rightMargin = com.ucpro.ui.c.a.c((int) R.dimen.clound_sync_phone_number_margin_right);
        this.h = new a(context);
        this.h.setIOtherLogin(this);
        this.e.addView(this.i, layoutParams2);
        layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 81;
        a(this.h, layoutParams2);
        setWindowCallBacks(this);
        this.e.setBackgroundColor(com.ucpro.ui.c.a.c("default_background_white"));
    }

    public final void a(f fVar, View view, ad adVar) {
        this.g.a();
    }

    public final void a(f fVar, View view, w wVar) {
    }

    @DebugLog
    public final void a(boolean z) {
        this.g.a(z);
    }

    @DebugLog
    public final void a(g gVar, byte b) {
    }

    @DebugLog
    public final boolean a(g gVar, int i, KeyEvent keyEvent) {
        if (!(gVar instanceof c) || i != 4 || keyEvent.getAction() != 1) {
            return false;
        }
        this.g.a();
        return true;
    }

    @DebugLog
    public final View a(View view) {
        if (view instanceof g) {
            return this.g.a((g) view);
        }
        return null;
    }

    public final void a(b bVar) {
        e.a(bVar);
        if (bVar == b.PHONE) {
            a aVar = this.h;
            ArrayList arrayList = new ArrayList();
            if (!com.ucpro.b.d.a.d()) {
                arrayList.add(new com.ucpro.feature.g.c.a.a(b.WECHAT, "cloud_weixin.svg"));
                arrayList.add(new com.ucpro.feature.g.c.a.a(b.WEIBO, "cloud_weibo.svg"));
            }
            arrayList.add(new com.ucpro.feature.g.c.a.a(b.QQ, "cloud_qq.svg"));
            aVar.b.a = com.ucpro.ui.c.a.c((int) R.dimen.clound_sync_other_way_phone_margin);
            aVar.a.setData(arrayList);
            i iVar = this.i;
            if (iVar.getLayoutParams() instanceof MarginLayoutParams) {
                ((MarginLayoutParams) iVar.getLayoutParams()).topMargin = com.ucpro.ui.c.a.c((int) R.dimen.clound_sync_margin_logo_top_min);
            }
            iVar.a.setVisibility(8);
            iVar.b.a.setVisibility(0);
            float f = (float) iVar.b.a.getLayoutParams().width;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, IPictureView.DEFAULT_MIN_SCALE});
            ofFloat.setDuration(700);
            ofFloat.addUpdateListener(new e(iVar, f));
            ofFloat.addListener(new com.ucpro.feature.g.c.b.j(iVar));
            ofFloat.start();
            return;
        }
        this.g.a(bVar);
    }

    public final void setPresenter(com.ucpro.base.d.b bVar) {
        this.g = (b) bVar;
    }

    public final void a(String str, String str2) {
        this.g.a(str, str2);
    }

    public final void a(String str) {
        this.g.a(str);
    }
}
