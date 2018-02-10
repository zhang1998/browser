package com.ucpro.feature.l.b;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.quark.browser.R;
import com.ucpro.business.stat.a.d;
import com.ucpro.ui.c.a;
import com.ucpro.ui.gridview.HeaderGridView;
import com.ucpro.ui.gridview.b;
import com.ucpro.ui.gridview.c;
import java.util.List;

/* compiled from: ProGuard */
public final class g extends FrameLayout implements d, k {
    private p a = null;
    private HeaderGridView b = null;
    private LinearLayout c = null;
    private TextView d = null;
    private TextView e = null;
    private e f = null;
    private int g = 200;
    private int h = 16;

    public g(Context context) {
        super(context);
        int c = a.c((int) R.dimen.dicover_page_padding_left);
        setPadding(c, 0, c, 0);
        this.b = new HeaderGridView(getContext());
        this.b.setVerticalScrollBarEnabled(false);
        this.b.setNumColumns(4);
        this.b.setColumnWidth(a.c((int) R.dimen.dicover_page_gridview_column_width));
        this.b.setStretchMode(1);
        this.b.setSelector(new ColorDrawable(0));
        addView(this.b, new LayoutParams(-1, -1));
        this.c = new LinearLayout(getContext());
        this.c.setOrientation(1);
        this.d = a(a.d((int) R.string.discover_page_plugin_title));
        this.c.addView(this.d);
        this.f = new e(getContext());
        this.f.setHorizontalScrollBarEnabled(false);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = a.c((int) R.dimen.dicover_page_plugin_container_margin_bottom);
        this.c.addView(this.f, layoutParams);
        this.e = a(a.d((int) R.string.discover_page_lightapp_title));
        this.c.addView(this.e);
        HeaderGridView headerGridView = this.b;
        View view = this.c;
        ListAdapter adapter = headerGridView.getAdapter();
        if (adapter == null || (adapter instanceof b)) {
            c cVar = new c();
            ViewGroup aVar = new com.ucpro.ui.gridview.a(headerGridView, headerGridView.getContext());
            aVar.addView(view);
            cVar.a = view;
            cVar.b = aVar;
            cVar.c = null;
            cVar.d = true;
            headerGridView.a.add(cVar);
            if (adapter != null) {
                ((b) adapter).a.notifyChanged();
            }
            c();
            return;
        }
        throw new IllegalStateException("Cannot add header view to grid -- setAdapter has already been called.");
    }

    private TextView a(String str) {
        TextView textView = new TextView(getContext());
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        int c = a.c((int) R.dimen.dicover_page_title_margin_top);
        layoutParams.topMargin = c;
        layoutParams.bottomMargin = c;
        textView.setText(str);
        textView.setSingleLine();
        textView.setEllipsize(TruncateAt.END);
        textView.setTextSize(0, (float) a.c((int) R.dimen.dicover_page_title_textsize));
        textView.setLayoutParams(layoutParams);
        return textView;
    }

    public final void a() {
    }

    public final boolean b() {
        return false;
    }

    public final String getPageTitle() {
        return a.d((int) R.string.discover_page_recommend_page_title);
    }

    public final void c() {
        this.d.setTextColor(a.c("default_maintext_gray"));
        this.e.setTextColor(a.c("default_maintext_gray"));
        if (this.a != null) {
            this.a.a();
        }
    }

    public final void setPresenter(com.ucpro.base.d.b bVar) {
        com.ucweb.common.util.c.b(bVar instanceof p);
        this.a = (p) bVar;
    }

    public final HeaderGridView getGridView() {
        return this.b;
    }

    public final e getPluginContainer() {
        return this.f;
    }

    public final void setPluginData(List<m> list) {
        this.f.a.removeAllViews();
        for (int i = 0; i < list.size(); i++) {
            m mVar = (m) list.get(i);
            if (mVar != null) {
                int i2;
                View hVar = new h(getContext());
                hVar.setImageDrawable(a.a(mVar.c));
                if (mVar.f) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                hVar.setState(i2);
                if (mVar.b.equals("ext:navifunc:more")) {
                    hVar.getPlusBtn().setVisibility(8);
                } else {
                    hVar.getImageView().setTag(mVar);
                    hVar.getImageView().setOnClickListener(this.a);
                    hVar.getPlusBtn().setTag(mVar);
                    hVar.getPlusBtn().setOnClickListener(this.a);
                }
                e eVar = this.f;
                ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(a.c((int) R.dimen.dicover_page_plugin_item_width), a.c((int) R.dimen.dicover_page_plugin_item_height));
                layoutParams.rightMargin = a.c((int) R.dimen.dicover_page_plugin_item_margin_right);
                layoutParams.bottomMargin = a.c((int) R.dimen.dicover_page_plugin_item_margin_bottom);
                eVar.a.addView(hVar, layoutParams);
            }
        }
    }

    public final String getSpm() {
        return com.ucpro.business.stat.a.a.a("8947795");
    }

    public final String getPageName() {
        return "Page_quark_recommend";
    }
}
