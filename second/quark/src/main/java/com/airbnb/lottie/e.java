package com.airbnb.lottie;

import android.graphics.Color;
import com.uc.imagecodec.export.IPictureView;
import org.json.JSONArray;

/* compiled from: ProGuard */
final class e implements ay<Integer> {
    static final e a = new e();

    e() {
    }

    public final /* synthetic */ Object a(Object obj, float f) {
        JSONArray jSONArray = (JSONArray) obj;
        if (jSONArray.length() != 4) {
            return Integer.valueOf(-16777216);
        }
        int i = 1;
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            if (jSONArray.optDouble(i2) > 1.0d) {
                i = 0;
            }
        }
        float f2 = i != 0 ? 255.0f : IPictureView.DEFAULT_MIN_SCALE;
        return Integer.valueOf(Color.argb((int) (jSONArray.optDouble(3) * ((double) f2)), (int) (jSONArray.optDouble(0) * ((double) f2)), (int) (jSONArray.optDouble(1) * ((double) f2)), (int) (jSONArray.optDouble(2) * ((double) f2))));
    }
}
