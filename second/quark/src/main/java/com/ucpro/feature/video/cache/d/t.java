package com.ucpro.feature.video.cache.d;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: ProGuard */
public final class t implements Iterable<String> {
    final /* synthetic */ c a;
    private HashMap<String, String> b = new HashMap();
    private ArrayList<e> c = new ArrayList();

    public t(c cVar, Map<String, String> map) {
        this.a = cVar;
        String str = (String) map.get("cookie");
        if (str != null) {
            for (String trim : str.split(";")) {
                String[] split = trim.trim().split("=");
                if (split.length == 2) {
                    this.b.put(split[0], split[1]);
                }
            }
        }
    }

    public final Iterator<String> iterator() {
        return this.b.keySet().iterator();
    }

    public final void a(d dVar) {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            e eVar = (e) it.next();
            dVar.a("Set-Cookie", String.format("%s=%s; expires=%s", new Object[]{eVar.a, eVar.b, eVar.c}));
        }
    }
}
