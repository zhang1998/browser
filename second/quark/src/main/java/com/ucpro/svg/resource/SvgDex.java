package com.ucpro.svg.resource;

import com.ucpro.svg.resource.a.a;
import com.ucpro.svg.resource.a.b;
import com.ucpro.svg.resource.a.c;
import java.util.HashMap;

/* compiled from: ProGuard */
public final class SvgDex {
    public static HashMap<String, String>[] getSlots(int i) {
        switch (i) {
            case 0:
                return c.a();
            case 1:
                return b.a();
            case 2:
                return a.a();
            default:
                return null;
        }
    }
}
