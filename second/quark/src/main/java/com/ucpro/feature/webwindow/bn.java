package com.ucpro.feature.webwindow;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import com.quark.browser.R;
import com.uc.apollo.impl.SettingsConst;
import com.ucpro.ui.widget.a;
import com.ucweb.common.util.p.b;

/* compiled from: ProGuard */
public final class bn extends a implements OnClickListener, OnLongClickListener {
    ar a;
    private ao b;
    private ar c;
    private ar d;

    public bn(Context context) {
        super(context);
        setMaxItemCount(3);
        View arVar = new ar(getContext(), "home_toolbar_multiwindow.svg", "home_toolbar_multiwindow_dark.svg");
        arVar.setId(R.id.home_toolbar_multi);
        arVar.setItemId(30039);
        arVar.setTag(R.id.ui_auto, b.B);
        arVar.a(SettingsConst.TRUE, "home_toolbar_item_text_color", "home_toolbar_item_text_color_dark", com.ucpro.ui.c.a.c((int) R.dimen.home_toolbar_item_text_size));
        arVar.setOnClickListener(this);
        arVar.setOnLongClickListener(this);
        a(arVar, 0);
        this.c = arVar;
        View arVar2 = new ar(getContext(), "home_toolbar_discovery.svg", "home_toolbar_discovery_dark.svg");
        arVar2.setItemId(30030);
        arVar2.setOnClickListener(this);
        arVar2.setOnLongClickListener(this);
        arVar2.setTag(R.id.ui_auto, b.z);
        a(arVar2, 1);
        this.d = arVar2;
        String str = "home_toolbar_menu.svg";
        String str2 = "home_toolbar_menu_dark.svg";
        if (com.ucpro.feature.e.b.a.a) {
            str = "home_toolbar_menu_traceless.svg";
            str2 = "home_toolbar_menu_traceless_dark.svg";
        }
        arVar2 = new ar(getContext(), str, str2);
        arVar2.setId(R.id.home_toolbar_menu);
        arVar2.setItemId(30029);
        arVar2.setOnClickListener(this);
        arVar2.setOnLongClickListener(this);
        arVar2.setTag(R.id.ui_auto, b.A);
        a(arVar2, 2);
        this.a = arVar2;
        a();
    }

    public final void setMultiWindowNum(int i) {
        this.c.setText(String.valueOf(i));
    }

    public final void onClick(View view) {
        if (view instanceof ar) {
            ar arVar = (ar) view;
            if (this.b != null) {
                this.b.d(arVar.getItemID());
            }
        }
    }

    public final boolean onLongClick(View view) {
        if (!(view instanceof ar)) {
            return false;
        }
        ar arVar = (ar) view;
        if (this.b != null) {
            this.b.e(arVar.getItemID());
        }
        return true;
    }

    public final void setCallback(ao aoVar) {
        this.b = aoVar;
    }

    public final void a() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof ar) {
                ((ar) childAt).a();
            }
        }
    }
}
