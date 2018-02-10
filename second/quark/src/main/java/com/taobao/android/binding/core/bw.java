package com.taobao.android.binding.core;

import com.taobao.weex.utils.WXViewUtils;
import java.util.ArrayList;
import org.json.JSONException;

/* compiled from: ProGuard */
final class bw implements bg {
    final /* synthetic */ int a;

    bw(int i) {
        this.a = i;
    }

    public final Object a(ArrayList<Object> arrayList) throws NumberFormatException, JSONException {
        return Double.valueOf(WXViewUtils.a(((Double) arrayList.get(0)).doubleValue(), this.a));
    }
}
