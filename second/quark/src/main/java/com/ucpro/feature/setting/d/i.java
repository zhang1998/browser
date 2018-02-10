package com.ucpro.feature.setting.d;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import com.quark.browser.R;
import com.ucpro.base.system.b;
import com.ucpro.feature.setting.a.a.a;

/* compiled from: ProGuard */
final class i extends BaseAdapter {
    final /* synthetic */ j a;

    private i(j jVar) {
        this.a = jVar;
    }

    public final int getCount() {
        return this.a.b.size();
    }

    public final Object getItem(int i) {
        return this.a.b.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        View lVar;
        if (view == null) {
            lVar = new l(this.a, viewGroup.getContext());
            lVar.setOnClickListener(this.a);
        } else {
            lVar = view;
        }
        a aVar = (a) this.a.b.get(i);
        l lVar2 = (l) lVar;
        lVar2.setTag(aVar);
        if (aVar != null) {
            Drawable a = com.ucpro.ui.c.a.a(aVar.d);
            try {
                if (a instanceof BitmapDrawable) {
                    Bitmap bitmap = ((BitmapDrawable) a).getBitmap();
                    int f = b.a.f() - (com.ucpro.ui.c.a.c((int) R.dimen.quark_lab_listview_padding_left) * 2);
                    int width = (int) ((((float) f) / ((float) bitmap.getWidth())) * ((float) bitmap.getHeight()));
                    LayoutParams layoutParams = lVar2.a.getLayoutParams();
                    layoutParams.width = f;
                    layoutParams.height = width;
                    lVar2.a.setLayoutParams(layoutParams);
                    lVar2.a.setSrcBitmap(bitmap);
                    int c = com.ucpro.ui.c.a.c((int) R.dimen.multi_window_cardview2_corner_radius);
                    lVar2.a.setBorderRadius(new float[]{(float) c, (float) c, (float) c, (float) c, 0.0f, 0.0f, 0.0f, 0.0f});
                    if (com.ucpro.ui.c.a.b()) {
                        lVar2.a.setColorMask(-2013265920);
                    }
                }
            } catch (Exception e) {
            }
            lVar2.b.setText(aVar.b);
            lVar2.c.setText(aVar.c);
        }
        return lVar2;
    }
}
