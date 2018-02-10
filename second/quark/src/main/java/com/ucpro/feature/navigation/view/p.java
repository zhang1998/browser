package com.ucpro.feature.navigation.view;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.uc.imagecodec.export.IPictureView;
import com.ucpro.ui.animation.a.b;
import com.ucpro.ui.widget.aj;
import com.ucpro.ui.widget.d;
import com.ucpro.ui.widget.l;
import com.ucpro.ui.widget.v;
import com.ucpro.ui.widget.x;

/* compiled from: ProGuard */
public final class p {
    public static void a(u uVar, Drawable drawable) {
        Context context = uVar.getContext();
        d nVar = new n(uVar);
        View view = new View(context);
        view.setBackgroundDrawable(drawable);
        int width = uVar.getIconView().getWidth();
        int height = uVar.getIconView().getHeight();
        View vVar = new v(context, nVar, width, height);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(width, height);
        layoutParams.leftMargin = uVar.getIconView().getLeft();
        layoutParams.topMargin = uVar.getIconView().getTop();
        vVar.addView(view, layoutParams);
        uVar.setAnimationView(vVar);
        int width2 = vVar.getWidth() / 2;
        int i = layoutParams.topMargin + (height / 2);
        TimeInterpolator bVar = new b();
        Runnable lVar = new l(vVar);
        if (vVar.a == null) {
            vVar.d = 1;
            vVar.c = new Path();
            if (vVar.d == 1) {
                if (vVar.getWidth() == 0) {
                    vVar.i = true;
                } else {
                    vVar.a();
                    vVar.i = false;
                }
            }
            vVar.e = width2;
            vVar.f = i;
            if (width2 <= vVar.g / 2) {
                width2 = vVar.g - width2;
            }
            if (i <= vVar.h / 2) {
                i = vVar.h - i;
            }
            float sqrt = (float) Math.sqrt((double) ((width2 * width2) + (i * i)));
            float f = IPictureView.DEFAULT_MIN_SCALE * sqrt;
            sqrt *= 0.0f;
            vVar.a = ValueAnimator.ofFloat(new float[]{f, sqrt});
            vVar.a.setDuration(500);
            vVar.a.setInterpolator(bVar);
            vVar.a.addUpdateListener(new aj(vVar));
            vVar.a.addListener(new x(vVar, lVar));
            vVar.a.start();
        }
    }
}
