package com.ucpro.feature.z.a;

import android.text.TextUtils;
import com.quark.browser.R;
import com.uc.webview.browser.interfaces.IWebResources;
import com.uc.webview.export.extension.UCCore;
import com.ucpro.base.a.e;
import com.ucpro.base.a.g;
import com.ucpro.business.stat.m;
import com.ucpro.business.stat.o;
import com.ucpro.feature.z.f.a;
import com.ucpro.feature.z.h.k;
import com.ucweb.common.util.i.f;

/* compiled from: ProGuard */
public final class i implements j {
    public e a = null;
    a b;
    boolean c;
    private int d = 0;
    private String e = null;
    private String f = null;
    private String g = null;

    public i(e eVar) {
        this.a = eVar;
        this.a.setPresenter(this);
        this.a.getUrlEditText().a(new f(this));
        this.a.getUrlEditText().setOnEditorActionListener(new b(this));
        this.a.getUrlEditText().setPasteAndGoListener(new h(this));
        this.b = new a();
        this.e = com.ucpro.ui.c.a.d((int) R.string.search_address_bar_text_enter);
        this.f = com.ucpro.ui.c.a.d((int) R.string.search_address_bar_text_search);
        this.g = com.ucpro.ui.c.a.d((int) R.string.search_address_bar_text_cancel);
        this.d = d.c;
        a(this.d);
    }

    public final void a() {
        this.a.getUrlEditText().setText((CharSequence) "");
        m.a(com.ucpro.feature.z.h.a.k);
    }

    public final void a(CharSequence charSequence) {
        a(charSequence.toString());
    }

    public final void a(String str) {
        switch (a.a[this.d - 1]) {
            case 1:
                m.a("searchpage", "cli_sea_b", new String[0]);
                Object k = f.k(str);
                k.a(UCCore.OPTION_LOAD_KERNEL_TYPE, null, k);
                g.a().b(e.ao, k);
                break;
            case 2:
                m.a("searchpage", "cli_sea_b", new String[0]);
                k.a(IWebResources.TEXT_SEARCH, str, null);
                g.a().b(e.an, (Object) str);
                break;
            case 3:
                m.a("searchpage", "cli_can_b", new String[0]);
                o.a(com.ucpro.feature.z.h.a.a.c);
                m.a(com.ucpro.feature.z.h.a.a);
                g.a().b(e.al);
                break;
        }
        if (this.a.getUrlEditText() != null) {
            this.a.getUrlEditText().setFillWordByPaste(false);
        }
    }

    final void a(int i) {
        if (i == 0) {
            return;
        }
        if (i != this.d || i == d.c) {
            this.d = i;
            switch (a.a[this.d - 1]) {
                case 1:
                    this.a.getClearUrlButton().setVisibility(0);
                    this.a.getUrlActionButton().setText(this.e);
                    this.a.getUrlEditText().setImeOptions(2);
                    return;
                case 2:
                    this.a.getClearUrlButton().setVisibility(0);
                    this.a.getUrlActionButton().setText(this.f);
                    this.a.getUrlEditText().setImeOptions(3);
                    return;
                case 3:
                    this.a.getClearUrlButton().setVisibility(8);
                    this.a.getUrlActionButton().setText(this.g);
                    this.a.getUrlEditText().setImeOptions(2);
                    return;
                default:
                    return;
            }
        }
    }

    public final void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.c = true;
            this.a.getUrlEditText().setText((CharSequence) str);
            this.c = false;
            this.a.getUrlEditText().setSelection(str.length());
            new StringBuilder("setText text.length() : ").append(str.length());
        }
    }
}
