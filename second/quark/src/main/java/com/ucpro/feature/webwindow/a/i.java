package com.ucpro.feature.webwindow.a;

import com.quark.browser.R;
import com.uc.imagecodec.export.IPictureView;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
public final class i implements Runnable {
    final /* synthetic */ g a;

    public i(g gVar) {
        this.a = gVar;
    }

    public final void run() {
        if (this.a.g != null) {
            f fVar = this.a.g;
            fVar.setVisibility(0);
            fVar.a.setAlpha(IPictureView.DEFAULT_MIN_SCALE);
            fVar.a.setTranslationY(0.0f);
            fVar.a.setScaleX(IPictureView.DEFAULT_MIN_SCALE);
            fVar.a.setScaleY(IPictureView.DEFAULT_MIN_SCALE);
            fVar.a.animate().scaleX(1.5f).scaleY(1.5f).translationY(-10.0f).alpha(0.0f).setDuration(200).start();
            fVar.b.setPivotX((float) (a.c((int) R.dimen.discover_page_enter_guide_tip_width) / 2));
            fVar.b.setPivotY((float) a.c((int) R.dimen.discover_page_enter_guide_tip_height));
            fVar.b.setScaleX(0.0f);
            fVar.b.setScaleY(0.0f);
            fVar.b.setAlpha(0.0f);
            fVar.b.setRotation(12.0f);
            fVar.b.animate().scaleX(IPictureView.DEFAULT_MIN_SCALE).scaleY(IPictureView.DEFAULT_MIN_SCALE).alpha(IPictureView.DEFAULT_MIN_SCALE).rotation(-2.0f).setStartDelay(200).setDuration(160).start();
            fVar.b.animate().rotation(0.0f).setStartDelay(360).setDuration(100).start();
        }
    }
}
