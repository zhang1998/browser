package com.ucpro.feature.g.c.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.quark.browser.R;
import com.ucpro.ui.widget.auto.theme.ATTextView;
import java.util.ArrayList;

/* compiled from: ProGuard */
public final class a extends LinearLayout implements l {
    public c a;
    public f b;
    private LinearLayout c = ((LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.cloud_sync_line, null));
    private View d = this.c.findViewById(R.id.cloud_view_left_line);
    private View e = this.c.findViewById(R.id.cloud_view_right_line);
    private ATTextView f = ((ATTextView) this.c.findViewById(R.id.cloud_tv_content));
    private o g;

    public a(Context context) {
        super(context);
        setOrientation(1);
        setLayoutParams(new LayoutParams(-1, -2));
        this.f.setTextColor(com.ucpro.ui.c.a.c("default_assisttext_gray"));
        this.f.setText(com.ucpro.ui.c.a.d((int) R.string.cloud_sync_other_login_ways));
        this.a = new c(context);
        this.a.setBackgroundDrawable(null);
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, -2);
        layoutParams.topMargin = com.ucpro.ui.c.a.c((int) R.dimen.clound_sync_other_way_text_margin_top);
        this.a.setLayoutParams(layoutParams);
        this.a.setIProItemView(this);
        this.a.setOrientation(0);
        this.b = new f(com.ucpro.ui.c.a.c((int) R.dimen.clound_sync_other_way_margin));
        this.a.a(this.b);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.ucpro.feature.g.c.a.a(b.PHONE, "cloud_phone.svg"));
        if (!com.ucpro.b.d.a.d()) {
            arrayList.add(new com.ucpro.feature.g.c.a.a(b.WEIBO, "cloud_weibo.svg"));
        }
        this.a.setData(arrayList);
        layoutParams = new LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.topMargin = com.ucpro.ui.c.a.c((int) R.dimen.clound_sync_other_way_text_margin_top);
        layoutParams.bottomMargin = com.ucpro.ui.c.a.c((int) R.dimen.clound_sync_other_way_text_margin_bottom);
        addView(this.c, new LayoutParams(-1, -2));
        addView(this.a, layoutParams);
    }

    public final View a() {
        View imageView = new ImageView(getContext());
        imageView.setBackgroundDrawable(com.ucpro.ui.c.a.c());
        return imageView;
    }

    public final void a(View view, Object obj) {
        if ((view instanceof ImageView) && (obj instanceof com.ucpro.feature.g.c.a.a)) {
            ((ImageView) view).setImageDrawable(com.ucpro.ui.c.a.a(((com.ucpro.feature.g.c.a.a) obj).b));
        }
    }

    public final void a(Object obj) {
        if (obj instanceof com.ucpro.feature.g.c.a.a) {
            com.ucpro.feature.g.c.a.a aVar = (com.ucpro.feature.g.c.a.a) obj;
            if ((aVar.a instanceof b) && this.g != null) {
                this.g.a((b) aVar.a);
            }
        }
    }

    public final void setIOtherLogin(o oVar) {
        this.g = oVar;
    }
}
