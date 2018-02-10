package com.taobao.weex.ui.component;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.taobao.c.a;
import com.taobao.weex.utils.WXLogUtils;

/* compiled from: ProGuard */
public final class ag implements n {
    public final void a(o oVar, String str, String str2) {
        if (TextUtils.equals(str, "wx_network_error") && (oVar instanceof aj)) {
            aj ajVar = (aj) oVar;
            View imageView = new ImageView(ajVar.getContext());
            imageView.setImageResource(a.error);
            LayoutParams layoutParams = new FrameLayout.LayoutParams(aj.c, aj.d);
            layoutParams.gravity = 17;
            imageView.setLayoutParams(layoutParams);
            imageView.setScaleType(ScaleType.FIT_XY);
            imageView.setAdjustViewBounds(true);
            imageView.setOnClickListener(new af(this, imageView, ajVar));
            FrameLayout frameLayout = (FrameLayout) ajVar.getHostView();
            frameLayout.removeAllViews();
            frameLayout.addView(imageView);
            WXLogUtils.e("WXEmbed", "NetWork failure :" + str + ",\n error message :" + str2);
        }
    }

    public final String a(String str) {
        return str;
    }
}
