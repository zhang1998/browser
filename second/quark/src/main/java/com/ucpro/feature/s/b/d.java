package com.ucpro.feature.s.b;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LayoutAnimationController;
import android.view.animation.ScaleAnimation;
import android.widget.Adapter;
import android.widget.GridView;
import com.uc.imagecodec.export.IPictureView;
import com.ucpro.feature.s.b.a.c;
import com.ucpro.model.keepproguard.discnavi.DiscoveryNaviDataParse.SiteItem;
import java.util.ArrayList;

/* compiled from: ProGuard */
public final class d extends GridView implements c {
    final j a;
    ArrayList<SiteItem> b;
    boolean c = false;

    public d(Context context, j jVar) {
        super(context);
        this.a = jVar;
        setStretchMode(2);
        setCacheColorHint(0);
        setSelector(new ColorDrawable(0));
        setFadingEdgeLength(0);
        setVerticalScrollBarEnabled(false);
        setGravity(17);
        Animation scaleAnimation = new ScaleAnimation(0.6f, IPictureView.DEFAULT_MIN_SCALE, 0.6f, IPictureView.DEFAULT_MIN_SCALE, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(300);
        scaleAnimation.setInterpolator(new DecelerateInterpolator());
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(scaleAnimation);
        layoutAnimationController.setOrder(0);
        layoutAnimationController.setDelay(0.2f);
        setLayoutAnimation(layoutAnimationController);
        setClipToPadding(false);
    }

    public final boolean a() {
        Adapter adapter = getAdapter();
        if (adapter == null || adapter.isEmpty()) {
            return true;
        }
        if (getFirstVisiblePosition() <= 0) {
            View childAt = getChildAt(0);
            if (childAt != null) {
                return childAt.getTop() >= 0;
            }
        }
        return false;
    }
}
