package com.airbnb.lottie;

import android.graphics.Path.FillType;
import android.support.annotation.Nullable;

/* compiled from: ProGuard */
final class av {
    final FillType a;
    @Nullable
    final co b;
    @Nullable
    final dt c;
    private final boolean d;

    private av(boolean z, FillType fillType, @Nullable co coVar, @Nullable dt dtVar) {
        this.d = z;
        this.a = fillType;
        this.b = coVar;
        this.c = dtVar;
    }

    public final String toString() {
        String str;
        Object obj;
        StringBuilder stringBuilder = new StringBuilder("ShapeFill{color=");
        if (this.b == null) {
            str = "null";
        } else {
            str = Integer.toHexString(((Integer) this.b.d()).intValue());
        }
        stringBuilder = stringBuilder.append(str).append(", fillEnabled=").append(this.d).append(", opacity=");
        if (this.c == null) {
            obj = "null";
        } else {
            Integer num = (Integer) this.c.b;
        }
        return stringBuilder.append(obj).append('}').toString();
    }
}
