package com.ucpro.feature.z.a;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import com.ucpro.business.stat.m;
import com.ucpro.feature.z.f.a;
import com.ucweb.common.util.d;
import com.ucweb.common.util.i.g;

/* compiled from: ProGuard */
public final class f implements TextWatcher {
    final /* synthetic */ i a;

    public f(i iVar) {
        this.a = iVar;
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        int i4;
        boolean z;
        if (TextUtils.isEmpty(charSequence)) {
            i4 = d.c;
            z = false;
        } else {
            int j = com.ucweb.common.util.i.f.j(charSequence.toString());
            if (j == g.b) {
                i4 = d.b;
                if (!this.a.c) {
                    a aVar = this.a.b;
                    if (aVar.b) {
                        z = aVar.c;
                    } else {
                        aVar.b = true;
                        if (com.ucweb.common.util.j.a.b(d.a(), "B9EA7885A214A69A", "10C2E008B4F9EF73", false)) {
                            z = false;
                        } else {
                            z = true;
                        }
                        aVar.c = z;
                        z = aVar.c;
                    }
                    if (z && a.a(charSequence.toString())) {
                        m.a("searchpage", "isearch_cont", "content", charSequence.toString());
                        z = true;
                    }
                }
                z = false;
            } else if (j == g.a) {
                i4 = d.a;
                z = false;
            } else {
                z = false;
                i4 = 0;
            }
        }
        this.a.a(i4);
        if (z) {
            a aVar2 = this.a.b;
            if (!aVar2.a) {
                aVar2.a = true;
                com.ucweb.common.util.j.a.a(d.a(), "B9EA7885A214A69A", "10C2E008B4F9EF73", true);
                aVar2.c = false;
            }
            if (!TextUtils.isEmpty(this.a.a.getUrlEditText().getText())) {
                this.a.a(this.a.a.getUrlEditText().getText().toString());
            }
        }
    }

    public final void afterTextChanged(Editable editable) {
    }
}
