package com.uc.translate;

import com.uc.translate.a.a;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public final class l extends HashMap<String, String> {
    public final /* synthetic */ Object put(Object obj, Object obj2) {
        return a((String) obj, (String) obj2);
    }

    public l(Map<? extends String, ? extends String> map) {
        super(map);
    }

    public final String a(String str, String str2) {
        if (a.a(str, str2)) {
            return (String) super.put(str, str2);
        }
        return null;
    }
}
