package com.ucpro.feature.l.b;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.ucpro.feature.navigation.b.b;
import com.ucpro.feature.navigation.b.i;
import com.ucweb.common.util.c;

/* compiled from: ProGuard */
public final class o extends BaseAdapter {
    final /* synthetic */ j a;

    public o(j jVar) {
        this.a = jVar;
    }

    public final int getCount() {
        if (this.a.b != null) {
            return this.a.b.size();
        }
        return 0;
    }

    public final Object getItem(int i) {
        if (this.a.b != null) {
            return this.a.b.get(i);
        }
        return null;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        View iVar;
        if (view == null) {
            iVar = new i(viewGroup.getContext());
            iVar.setOnClickListener(this.a);
        } else {
            iVar = view;
        }
        m mVar = (m) this.a.b.get(i);
        if (mVar != null) {
            Object c;
            if (TextUtils.isEmpty(mVar.b)) {
                Drawable drawable = null;
            } else {
                i.a;
                c = b.c(mVar.b);
            }
            c.a(c);
            ((i) iVar).setIcon(c);
            ((i) iVar).setTitle(mVar.a);
            iVar.setTag(mVar);
            ((i) iVar).a();
        }
        return iVar;
    }
}
