package com.taobao.weex.common;

import android.text.TextUtils;
import com.taobao.weex.ac;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.utils.ah;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ProGuard */
public abstract class o {
    private Map<String, List<String>> a = new HashMap();
    public ac b;
    public String c;
    private Map<String, Boolean> d = new HashMap();

    public void b() {
    }

    public void c() {
    }

    @JSMethod
    public void addEventListener(String str, String str2, Map<String, Object> map) {
        boolean z = false;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (map != null && map.size() > 0 && map.containsKey("once") && ah.a(map.get("once"), Boolean.valueOf(false)).booleanValue()) {
                z = true;
            }
            this.d.put(str2, Boolean.valueOf(z));
            if (this.a.get(str) == null) {
                this.a.put(str, new ArrayList());
            }
            ((List) this.a.get(str)).add(str2);
        }
    }

    @JSMethod
    public void removeAllEventListeners(String str) {
        if (this.a.containsKey(str)) {
            for (String remove : (List) this.a.remove(str)) {
                this.d.remove(remove);
            }
        }
    }
}
