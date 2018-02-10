package com.ucpro.ui.widget.a;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import com.uc.util.b;

/* compiled from: ProGuard */
public class ac extends BitmapDrawable {
    private static final String d = ac.class.getSimpleName();
    float a;
    float b;
    float c;

    ac(View view, float f) {
        Resources resources = view.getResources();
        Bitmap a = b.a(view.getMeasuredWidth(), view.getMeasuredHeight(), Config.ARGB_8888);
        if (a != null) {
            view.draw(new Canvas(a));
        }
        super(resources, a);
        this.a = (float) view.getTop();
        this.b = f;
        setBounds(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }

    final boolean a() {
        return this.a > ((float) getBounds().top);
    }

    final void a(int i) {
        setBounds(getBounds().left, i, getBounds().left + getIntrinsicWidth(), getIntrinsicHeight() + i);
    }

    final void b(int i) {
        if (a()) {
            i = -i;
        }
        this.a += (float) i;
        this.b += (float) i;
    }
}
