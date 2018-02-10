package com.ucpro.ui.widget;

import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;
import com.uc.webview.export.extension.UCCore;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
public class a extends ah {
    private ArrayList<y> a = new ArrayList();
    private int b;

    public a(Context context) {
        super(context);
    }

    public final void a(View view, int i) {
        y yVar = new y(this);
        yVar.a = view;
        yVar.b = i;
        this.a.add(yVar);
        addView(view);
    }

    public void setMaxItemCount(int i) {
        this.b = i;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            y yVar = (y) it.next();
            if (yVar.a != null) {
                yVar.a.measure(MeasureSpec.makeMeasureSpec(getMeasuredWidth() / this.b, UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(getMeasuredHeight(), UCCore.VERIFY_POLICY_QUICK));
            }
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width = getWidth() / this.b;
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            y yVar = (y) it.next();
            if (yVar.a != null) {
                int i5 = yVar.b * width;
                yVar.a.layout(i5, 0, i5 + width, getHeight());
            }
        }
    }
}
