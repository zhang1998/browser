package com.ucpro.feature.z.e;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.ucpro.feature.z.f.b.f;
import com.ucpro.feature.z.f.b.m;
import com.ucpro.ui.c.a;
import com.ucweb.common.util.i.g;

/* compiled from: ProGuard */
final class d extends BaseAdapter {
    final /* synthetic */ n a;

    d(n nVar) {
        this.a = nVar;
    }

    public final int getCount() {
        if (this.a.a == null) {
            return 0;
        }
        return this.a.a.size();
    }

    public final Object getItem(int i) {
        if (this.a.a == null) {
            return null;
        }
        return this.a.a.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        e eVar;
        Context context = viewGroup.getContext();
        if (view == null) {
            eVar = new e(context);
            eVar.setCallback(this.a);
        } else {
            View view2 = view;
        }
        m mVar = (m) this.a.a.get(i);
        eVar = eVar;
        if (mVar.f != -1) {
            CharSequence spannableString = new SpannableString(mVar.d);
            spannableString.setSpan(new ForegroundColorSpan(a.c("search_input_associate_hihglight_color")), mVar.f, mVar.f + mVar.g, 33);
            eVar.getAssociateText().setText(spannableString);
        } else {
            eVar.getAssociateText().setText(mVar.d);
        }
        if (mVar.b != f.TITLE_ONLY) {
            eVar.getAssociateUrl().setVisibility(0);
            eVar.setIsSearch(false);
            if (mVar.h != -1) {
                spannableString = new SpannableString(mVar.e);
                spannableString.setSpan(new ForegroundColorSpan(a.c("search_input_associate_hihglight_color")), mVar.h, mVar.i + mVar.h, 33);
                eVar.getAssociateUrl().setText(spannableString);
            } else {
                eVar.getAssociateUrl().setText(mVar.e);
            }
        } else if (com.ucweb.common.util.i.f.j(mVar.d) == g.a) {
            eVar.getAssociateUrl().setVisibility(0);
            eVar.setIsSearch(false);
            if (mVar.h != -1) {
                spannableString = new SpannableString(mVar.d);
                spannableString.setSpan(new ForegroundColorSpan(a.c("search_input_associate_hihglight_color")), mVar.h, mVar.i + mVar.h, 33);
                eVar.getAssociateUrl().setText(spannableString);
            } else {
                eVar.getAssociateUrl().setText(mVar.d);
            }
        } else {
            eVar.getAssociateUrl().setVisibility(8);
            eVar.setIsSearch(true);
        }
        return eVar;
    }
}
