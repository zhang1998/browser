package com.ucpro.feature.downloadpage.e.c;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.quark.browser.R;
import com.ucpro.ui.c.a;
import com.ucpro.ui.widget.auto.theme.ATTextView;

/* compiled from: ProGuard */
public final class d extends LinearLayout {
    private View a = new View(getContext());
    private ImageView b;
    private ImageView c;
    private ATTextView d;
    private LinearLayout e;
    private LinearLayout f;
    private l g;

    public d(Context context) {
        super(context);
        setOrientation(1);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 1);
        this.a.setBackgroundColor(a.c("popmenu_divider_color"));
        addView(this.a, layoutParams);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.download_store_bar, null);
        this.e = (LinearLayout) inflate.findViewById(R.id.add_task);
        this.f = (LinearLayout) inflate.findViewById(R.id.set);
        this.b = (ImageView) inflate.findViewById(R.id.add_task_iv);
        this.c = (ImageView) inflate.findViewById(R.id.set_iv);
        this.d = (ATTextView) inflate.findViewById(R.id.store);
        this.b.setImageDrawable(a.a("bookmark_add.svg"));
        this.c.setImageDrawable(a.a("download_setting.svg"));
        this.e.setBackgroundDrawable(a.c());
        this.f.setBackgroundDrawable(a.c());
        OnClickListener iVar = new i(this);
        OnClickListener bVar = new b(this);
        this.e.setOnClickListener(iVar);
        this.b.setOnClickListener(iVar);
        this.f.setOnClickListener(bVar);
        this.c.setOnClickListener(bVar);
        addView(inflate, new LinearLayout.LayoutParams(-1, a.c((int) R.dimen.common_bottom_titlebar_height)));
    }

    public final void setText(String str) {
        this.d.setText(str);
    }

    public final void setOnBarClickListener(l lVar) {
        this.g = lVar;
    }
}
