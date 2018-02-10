package com.taobao.weex.ui;

import com.taobao.weex.utils.WXLogUtils;
import java.util.Iterator;
import java.util.Map;

/* compiled from: ProGuard */
final class h implements Runnable {
    h() {
    }

    public final void run() {
        try {
            Iterator it = i.b.iterator();
            while (it.hasNext()) {
                i.a((Map) it.next());
            }
        } catch (Throwable e) {
            WXLogUtils.e("", e);
        }
    }
}
