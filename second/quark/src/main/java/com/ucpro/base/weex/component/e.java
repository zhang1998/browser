package com.ucpro.base.weex.component;

import android.widget.ImageView;
import com.taobao.weex.common.j;
import com.uc.webview.export.extension.UCCore;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
final class e implements j {
    final /* synthetic */ WXQuarkImage a;

    e(WXQuarkImage wXQuarkImage) {
        this.a = wXQuarkImage;
    }

    public final void a(ImageView imageView, boolean z, Map map) {
        if (this.a.getDomObject() != null && this.a.getDomObject().c_().contains(UCCore.OPTION_LOAD_KERNEL_TYPE)) {
            Map hashMap = new HashMap();
            Map hashMap2 = new HashMap(2);
            hashMap2.put("naturalWidth", map.get("naturalWidth"));
            hashMap2.put("naturalHeight", map.get("naturalHeight"));
            if (this.a.getDomObject() != null && this.a.containsEvent(UCCore.OPTION_LOAD_KERNEL_TYPE)) {
                hashMap.put("success", Boolean.valueOf(z));
                hashMap.put("size", hashMap2);
                this.a.fireEvent(UCCore.OPTION_LOAD_KERNEL_TYPE, hashMap);
            }
        }
    }
}
