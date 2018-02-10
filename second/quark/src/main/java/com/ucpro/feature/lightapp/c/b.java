package com.ucpro.feature.lightapp.c;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.quark.browser.R;
import com.uc.apollo.impl.SettingsConst;
import com.ucpro.feature.webwindow.ar;
import com.ucpro.ui.widget.a;
import com.ucweb.common.util.c;

/* compiled from: ProGuard */
public final class b extends FrameLayout implements OnClickListener, OnLongClickListener, c {
    private a a = new a(getContext());
    private ar b;
    private ar c;
    private ar d;
    private View e = null;
    private f f;
    private a g = null;

    public b(Context context) {
        super(context);
        this.a.setMaxItemCount(3);
        View arVar = new ar(getContext(), "home_toolbar_multiwindow.svg", "home_toolbar_multiwindow.svg");
        arVar.setId(R.id.home_toolbar_multi);
        arVar.setItemId(30039);
        arVar.a(SettingsConst.TRUE, "home_toolbar_item_text_color", "home_toolbar_item_text_color", com.ucpro.ui.c.a.c((int) R.dimen.home_toolbar_item_text_size));
        arVar.setOnClickListener(this);
        arVar.setOnLongClickListener(this);
        this.a.a(arVar, 0);
        this.b = arVar;
        arVar = new ar(getContext(), "toolbar_add_nav.svg", "toolbar_add_nav.svg");
        arVar.setId(R.id.toolbar_add_navigation);
        arVar.setItemId(30040);
        arVar.setOnClickListener(this);
        arVar.setOnLongClickListener(this);
        this.a.a(arVar, 1);
        this.c = arVar;
        String str = "home_toolbar_menu.svg";
        String str2 = "home_toolbar_menu.svg";
        if (com.ucpro.feature.e.b.a.a) {
            str = "home_toolbar_menu_traceless.svg";
            str2 = "home_toolbar_menu_traceless.svg";
        }
        View arVar2 = new ar(getContext(), str, str2);
        arVar2.setId(R.id.home_toolbar_menu);
        arVar2.setItemId(30029);
        arVar2.setOnClickListener(this);
        arVar2.setOnLongClickListener(this);
        arVar2.setTag(R.id.ui_auto, com.ucweb.common.util.p.b.A);
        this.a.a(arVar2, 2);
        this.d = arVar2;
        addView(this.a, new LayoutParams(-1, -1));
        this.e = new View(getContext());
        addView(this.e, new LayoutParams(-1, 1));
        a();
    }

    public final void a() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof ar) {
                ((ar) childAt).a();
            }
        }
        this.e.setBackgroundColor(com.ucpro.ui.c.a.c("default_cutting_line"));
        setBackgroundColor(com.ucpro.ui.c.a.c("background_color"));
    }

    public final void setPresenter(com.ucpro.base.d.b bVar) {
        c.b(bVar instanceof a);
        this.g = (a) bVar;
        c.b(bVar instanceof f);
        this.f = (f) bVar;
    }

    public final void onClick(View view) {
        if (view instanceof ar) {
            ar arVar = (ar) view;
            if (this.f != null) {
                this.f.b(arVar.getItemID());
            }
        }
    }

    public final boolean onLongClick(View view) {
        if (!(view instanceof ar)) {
            return false;
        }
        ar arVar = (ar) view;
        if (this.f != null) {
            this.f.c(arVar.getItemID());
        }
        return true;
    }

    public final void setMultiWindowNum(int i) {
        this.b.setText(String.valueOf(i));
    }

    public final void a(boolean z) {
        if (z) {
            this.d.setIconName("home_toolbar_menu_traceless.svg");
            this.d.setDarkIconName("home_toolbar_menu_traceless.svg");
        } else {
            this.d.setIconName("home_toolbar_menu.svg");
            this.d.setDarkIconName("home_toolbar_menu.svg");
        }
        this.d.a();
    }

    public final void setAddNavBtnVisibility(boolean z) {
        this.c.setVisibility(z ? 0 : 8);
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
