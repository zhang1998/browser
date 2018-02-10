package com.ucpro.ui.widget.a;

import android.animation.ObjectAnimator;
import android.view.View;
import java.util.ArrayList;

/* compiled from: ProGuard */
final class w {
    final /* synthetic */ z a;

    public final void a(long j, boolean z, int i, float f) {
        int b = this.a.a(j);
        View a = this.a.b(j);
        ArrayList arrayList = new ArrayList();
        arrayList.add(a);
        long j2 = 0;
        x.a(z.a, "---------->switch group views current mobile view position is " + b);
        int i2 = 1;
        while (i2 <= i) {
            long itemId = !z ? (b + i2) - this.a.l.e() >= 0 ? this.a.d.getItemId((b + i2) - this.a.l.e()) : -1 : (b - i2) - this.a.l.e() >= 0 ? this.a.d.getItemId((b - i2) - this.a.l.e()) : -1;
            if (itemId != -1) {
                arrayList.add(this.a.b(itemId));
                if (i2 + 1 > i) {
                    x.a(z.a, "last switch id is " + itemId);
                } else {
                    itemId = j2;
                }
                i2++;
                j2 = itemId;
            } else {
                x.a(z.a, "switch group view-------->switch view position is invalid");
                return;
            }
        }
        int size = arrayList.size();
        for (int i3 = 1; i3 < size; i3++) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(arrayList.get(i3), "translationY", new float[]{0.0f, -f});
            ofFloat.start();
            if (i3 + 1 >= size) {
                ofFloat.addListener(new aa(this, arrayList));
            }
        }
        this.a.f = j2;
        this.a.o = this.a.b(this.a.f);
    }
}
