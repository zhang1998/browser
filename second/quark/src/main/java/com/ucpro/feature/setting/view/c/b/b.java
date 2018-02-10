package com.ucpro.feature.setting.view.c.b;

import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import com.uc.webview.export.extension.UCCore;
import com.ucpro.feature.setting.a.d;
import com.ucpro.feature.setting.a.g;
import com.ucpro.feature.setting.a.h;
import com.ucpro.feature.setting.view.c.c;
import com.ucpro.ui.e.a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public final class b extends ViewGroup implements c, com.ucpro.ui.e.a.c {
    public a a = new a(getContext(), this);
    private com.ucpro.feature.setting.view.c.a b;
    private g c;
    private List<d> d;

    public b(Context context, g gVar) {
        super(context);
        this.c = gVar;
        addView(this.a);
    }

    protected final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.a.measure(MeasureSpec.makeMeasureSpec(getMeasuredWidth(), UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(getMeasuredHeight(), UCCore.VERIFY_POLICY_QUICK));
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.a.layout(0, 0, getWidth(), getHeight());
    }

    public final void setData(List<d> list) {
        this.d = list;
    }

    public final ArrayList getConfig() {
        ArrayList arrayList = new ArrayList();
        for (d aVar : this.d) {
            arrayList.add(new a(this, aVar));
        }
        return arrayList;
    }

    public final void setAdapter(com.ucpro.feature.setting.a.b bVar) {
    }

    public final com.ucpro.feature.setting.a.b getAdapter() {
        return null;
    }

    public final void a() {
    }

    public final void setSettingViewCallback(com.ucpro.feature.setting.view.c.a aVar) {
        this.b = aVar;
    }

    public final View getSettingView() {
        return this;
    }

    static /* synthetic */ void a(b bVar, String str) {
        int intValue = Integer.valueOf(str).intValue();
        if (bVar.b != null && intValue != h.a) {
            bVar.b.a(null, intValue, Integer.valueOf(intValue));
        }
    }
}
