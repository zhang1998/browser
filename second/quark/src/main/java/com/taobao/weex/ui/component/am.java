package com.taobao.weex.ui.component;

import android.widget.ImageView;
import com.taobao.weex.common.j;
import com.uc.webview.export.extension.UCCore;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
final class am implements j {
    final /* synthetic */ ap a;

    am(ap apVar) {
        this.a = apVar;
    }

    public final void a(ImageView imageView, boolean z, Map map) {
        if (this.a.getDomObject() != null && this.a.getDomObject().c_().contains(UCCore.OPTION_LOAD_KERNEL_TYPE)) {
            Map hashMap = new HashMap();
            Map hashMap2 = new HashMap(2);
            if (imageView == null || !(imageView instanceof ao)) {
                hashMap2.put("naturalWidth", Integer.valueOf(0));
                hashMap2.put("naturalHeight", Integer.valueOf(0));
            } else {
                hashMap2.put("naturalWidth", Integer.valueOf(((ao) imageView).getNaturalWidth()));
                hashMap2.put("naturalHeight", Integer.valueOf(((ao) imageView).getNaturalHeight()));
            }
            if (this.a.getDomObject() != null && this.a.containsEvent(UCCore.OPTION_LOAD_KERNEL_TYPE)) {
                hashMap.put("success", Boolean.valueOf(z));
                hashMap.put("size", hashMap2);
                this.a.fireEvent(UCCore.OPTION_LOAD_KERNEL_TYPE, hashMap);
            }
        }
    }
}
