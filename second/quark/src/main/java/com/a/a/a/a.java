package com.a.a.a;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: ProGuard */
final class a implements Comparator {
    private a() {
    }

    public final int compare(Object obj, Object obj2) {
        if (obj == null && obj2 == null) {
            return 0;
        }
        if (obj == null) {
            return -1;
        }
        if (obj2 == null) {
            return 1;
        }
        if (obj instanceof List) {
            return d.a((List) obj, (List) obj2);
        }
        if (obj instanceof Set) {
            return d.a((Set) obj, (Set) obj2);
        }
        if (obj instanceof Map) {
            return d.a((Map) obj, (Map) obj2);
        }
        if (obj instanceof byte[]) {
            return d.a((byte[]) obj, (byte[]) obj2);
        }
        return d.a((Comparable) obj, (Comparable) obj2);
    }
}
