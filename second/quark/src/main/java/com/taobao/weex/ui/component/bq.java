package com.taobao.weex.ui.component;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
final class bq implements OnCheckedChangeListener {
    final /* synthetic */ br a;

    bq(br brVar) {
        this.a = brVar;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        Map hashMap = new HashMap(2);
        hashMap.put("value", Boolean.valueOf(z));
        Map hashMap2 = new HashMap();
        Map hashMap3 = new HashMap();
        hashMap3.put("checked", Boolean.toString(z));
        hashMap2.put("attrs", hashMap3);
        this.a.fireEvent("change", hashMap, hashMap2);
    }
}
