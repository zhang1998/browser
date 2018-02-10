package com.ucpro.feature.j;

import android.content.Context;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.quark.browser.R;
import com.ucpro.base.d.b;
import com.ucpro.ui.c.a;
import com.ucpro.ui.widget.ad;
import com.ucpro.ui.widget.f;
import com.ucpro.ui.widget.j;
import com.ucpro.ui.widget.w;
import java.util.List;

/* compiled from: ProGuard */
public final class l extends j implements OnClickListener, OnCheckedChangeListener, k {
    private e g;
    private View h = LayoutInflater.from(getContext()).inflate(R.layout.shorcut_menu_window, this.e, false);
    private TextView i;
    private TextView j;
    private SwitchCompat k;
    private View l;
    private View m;
    private TextView n;
    private LinearLayout o;

    public l(Context context) {
        super(context);
        this.f.a(a.d((int) R.string.shortcut_menu_setting_title));
        this.f.a(a.a("back.svg"));
        this.e.addView(this.h, new LayoutParams(-1, -1));
        this.i = (TextView) this.h.findViewById(R.id.shortcut_menu_switch_title);
        this.j = (TextView) this.h.findViewById(R.id.shortcut_menu_switch_subtitle);
        this.k = (SwitchCompat) this.h.findViewById(R.id.shortcut_menu_switch_compat);
        this.k.setThumbDrawable(a.a("setting_item_switch_off.svg"));
        this.k.setTrackDrawable(a.a("switch_compat_track.xml"));
        this.k.setOnCheckedChangeListener(this);
        this.l = this.h.findViewById(R.id.shortcut_menu_switch_container);
        this.l.setOnClickListener(this);
        this.m = this.h.findViewById(R.id.shortcut_menu_tip_container);
        this.n = (TextView) this.h.findViewById(R.id.shortcut_menu_tip_text);
        this.o = (LinearLayout) this.h.findViewById(R.id.shortcut_menu_items_container);
        l();
    }

    public final void l() {
        this.h.setBackgroundColor(a.c("default_background_white"));
        this.i.setTextColor(a.c("default_maintext_gray"));
        this.j.setTextColor(a.c("default_commentstext_gray"));
        this.m.setBackgroundColor(a.c("common_desc_item_bg"));
        this.n.setTextColor(a.c("default_commentstext_gray"));
    }

    public final void setPresenter(b bVar) {
        this.g = (e) bVar;
    }

    public final void a(f fVar, View view, ad adVar) {
        getUICallbacks().a(true);
    }

    public final void a(f fVar, View view, w wVar) {
    }

    public final void a(boolean z, List<com.ucpro.feature.j.a.a> list) {
        this.o.removeAllViews();
        for (com.ucpro.feature.j.a.a aVar : list) {
            if (aVar != null) {
                View hVar = new h(this, getContext(), aVar);
                hVar.setOnClickListener(this);
                ((h) hVar).a.setOnCheckedChangeListener(this);
                this.o.addView(hVar);
            }
        }
        this.k.setChecked(z);
        setItemsEnable(z);
    }

    public final void onClick(View view) {
        if (view == this.l) {
            this.k.toggle();
        } else if (view instanceof h) {
            ((h) view).a.toggle();
        }
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (this.g != null) {
            if (this.k == compoundButton) {
                this.g.a(z);
                setItemsEnable(z);
                return;
            }
            this.g.a(compoundButton.getId(), z);
        }
    }

    public final void setItemsEnable(boolean z) {
        int childCount = this.o.getChildCount();
        for (int i = 0; i < childCount; i++) {
            this.o.getChildAt(i).setEnabled(z);
        }
    }

    public final void a() {
        int childCount = this.o.getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (this.o.getChildAt(i) instanceof h) {
                h hVar = (h) this.o.getChildAt(i);
                if (!hVar.a.isChecked()) {
                    hVar.setEnabled(false);
                }
            }
        }
    }
}
