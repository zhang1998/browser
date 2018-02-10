package com.ucpro.feature.setting.view.c;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import com.ucpro.feature.setting.a.b;
import com.ucpro.feature.setting.view.item.c;
import com.ucpro.feature.setting.view.item.h;
import java.util.List;

/* compiled from: ProGuard */
public abstract class d extends ScrollView implements c {
    private LinearLayout a = new LinearLayout(getContext());
    private b b;
    private a c;

    public abstract int getItemHeight();

    public d(Context context) {
        super(context);
        this.a.setOrientation(1);
        this.a.setLayoutParams(new LayoutParams(-1, -1));
        addView(this.a);
        a();
    }

    public b getAdapter() {
        return this.b;
    }

    public void setAdapter(b bVar) {
        if (bVar != null) {
            this.b = bVar;
            this.a.removeAllViews();
            for (h hVar : bVar.a) {
                if (getSettingItemViewCallbakc() != null) {
                    hVar.setSettingItemViewCallback(getSettingItemViewCallbakc());
                }
                this.a.addView(hVar.getSettingItemView(), new LayoutParams(-1, getItemHeight()));
            }
        }
    }

    public final void a() {
        if (this.b != null) {
            this.b.c();
        }
    }

    public void setSettingViewCallback(a aVar) {
        this.c = aVar;
    }

    public View getSettingView() {
        return this;
    }

    private c getSettingItemViewCallbakc() {
        if (this.c instanceof c) {
            return this.c;
        }
        return null;
    }

    public final h a(int i) {
        if (this.b != null) {
            List list = this.b.a;
            for (int i2 = 0; i2 < list.size(); i2++) {
                h hVar = (h) list.get(i2);
                if (hVar != null && hVar.getSettingItemData().c == i) {
                    return hVar;
                }
            }
        }
        return null;
    }
}
