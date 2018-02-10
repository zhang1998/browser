package com.airbnb.lottie;

import android.graphics.Color;
import org.json.JSONArray;

/* compiled from: ProGuard */
final class al implements ay<af> {
    private static final al a = new al();

    public final /* synthetic */ Object a(Object obj, float f) {
        int i = 0;
        JSONArray jSONArray = (JSONArray) obj;
        int length = jSONArray.length() / 4;
        float[] fArr = new float[length];
        int[] iArr = new int[length];
        af afVar = new af(fArr, iArr);
        length = 0;
        int i2 = 0;
        while (i < jSONArray.length()) {
            int i3 = i / 4;
            double optDouble = jSONArray.optDouble(i);
            switch (i % 4) {
                case 0:
                    fArr[i3] = (float) optDouble;
                    break;
                case 1:
                    i2 = (int) (optDouble * 255.0d);
                    break;
                case 2:
                    length = (int) (optDouble * 255.0d);
                    break;
                case 3:
                    iArr[i3] = Color.argb(255, i2, length, (int) (optDouble * 255.0d));
                    break;
                default:
                    break;
            }
            i++;
        }
        return afVar;
    }

    private al() {
    }
}
