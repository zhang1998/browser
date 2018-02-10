package com.taobao.weex.c;

import android.mini.support.annotation.NonNull;
import android.mini.support.annotation.Nullable;
import android.mini.support.v4.d.b;
import android.text.Layout.Alignment;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import com.taobao.weex.ui.animation.WXAnimationBean.Style;
import com.taobao.weex.ui.component.bu;
import com.taobao.weex.utils.WXViewUtils;
import com.taobao.weex.utils.ah;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: ProGuard */
public final class ao implements Cloneable, Map<String, Object> {
    public Map<String, Map<String, Object>> a = new b();
    public Map<String, Object> b = new b();
    @NonNull
    private final Map<String, Object> c = new b();

    protected final /* synthetic */ Object clone() throws CloneNotSupportedException {
        return c();
    }

    public final /* synthetic */ Object put(Object obj, Object obj2) {
        return a((String) obj, obj2);
    }

    @Nullable
    public final String a() {
        if (get("filter") == null) {
            return null;
        }
        return get("filter").toString().trim();
    }

    public static int a(Map<String, Object> map) {
        if (map != null) {
            Object obj = map.get("textDecoration");
            if (obj != null) {
                String obj2 = obj.toString();
                obj = -1;
                switch (obj2.hashCode()) {
                    case -1171789332:
                        if (obj2.equals("line-through")) {
                            obj = 1;
                            break;
                        }
                        break;
                    case -1026963764:
                        if (obj2.equals("underline")) {
                            obj = null;
                            break;
                        }
                        break;
                    case 3387192:
                        if (obj2.equals("none")) {
                            obj = 2;
                            break;
                        }
                        break;
                }
                switch (obj) {
                    case null:
                        return bu.c;
                    case 1:
                        return bu.d;
                    case 2:
                        return bu.b;
                    default:
                        return bu.a;
                }
            }
        }
        return bu.b;
    }

    public static String b(Map<String, Object> map) {
        if (map == null) {
            return "";
        }
        Object obj = map.get("color");
        return obj == null ? "" : obj.toString();
    }

    public static int c(Map<String, Object> map) {
        if (map != null) {
            Object obj = map.get("fontWeight");
            if (obj != null) {
                String obj2 = obj.toString();
                int i = -1;
                switch (obj2.hashCode()) {
                    case 53430:
                        if (obj2.equals("600")) {
                            i = 0;
                            break;
                        }
                        break;
                    case 54391:
                        if (obj2.equals("700")) {
                            i = 1;
                            break;
                        }
                        break;
                    case 55352:
                        if (obj2.equals("800")) {
                            i = 2;
                            break;
                        }
                        break;
                    case 56313:
                        if (obj2.equals("900")) {
                            i = 3;
                            break;
                        }
                        break;
                    case 3029637:
                        if (obj2.equals("bold")) {
                            i = 4;
                            break;
                        }
                        break;
                }
                switch (i) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        return 1;
                }
            }
        }
        return 0;
    }

    public static int d(Map<String, Object> map) {
        if (map == null) {
            return 0;
        }
        Object obj = map.get("fontStyle");
        if (obj == null || !obj.toString().equals("italic")) {
            return 0;
        }
        return 2;
    }

    public static int a(Map<String, Object> map, int i) {
        if (map == null) {
            return (int) WXViewUtils.a(32.0f, i);
        }
        int b = ah.b(map.get("fontSize"));
        if (b <= 0) {
            b = 32;
        }
        return (int) WXViewUtils.a((float) b, i);
    }

    public static String e(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        Object obj = map.get("fontFamily");
        if (obj != null) {
            return obj.toString();
        }
        return null;
    }

    public static Alignment f(Map<String, Object> map) {
        Alignment alignment = Alignment.ALIGN_NORMAL;
        String str = (String) map.get("textAlign");
        if (TextUtils.equals(Style.LEFT, str)) {
            return Alignment.ALIGN_NORMAL;
        }
        if (TextUtils.equals(Style.CENTER, str)) {
            return Alignment.ALIGN_CENTER;
        }
        return TextUtils.equals(Style.RIGHT, str) ? Alignment.ALIGN_OPPOSITE : alignment;
    }

    public static TruncateAt g(Map<String, Object> map) {
        if (TextUtils.equals("ellipsis", (String) map.get("textOverflow"))) {
            return TruncateAt.END;
        }
        return null;
    }

    public static int h(Map<String, Object> map) {
        return ah.b(map.get("lines"));
    }

    public static int b(Map<String, Object> map, int i) {
        if (map == null) {
            return -1;
        }
        int b = ah.b(map.get("lineHeight"));
        if (b > 0) {
            return (int) WXViewUtils.a((float) b, i);
        }
        return -1;
    }

    final float a(String str, int i) {
        float a = ah.a(get(str), i);
        if (Float.isNaN(a)) {
            return a(i);
        }
        return a;
    }

    public final float a(int i) {
        return ah.a(get("borderWidth"), i);
    }

    public final boolean b() {
        Object obj = get("position");
        if (obj == null) {
            return false;
        }
        return obj.toString().equals("fixed");
    }

    public final boolean equals(Object obj) {
        return this.c.equals(obj);
    }

    public final int hashCode() {
        return this.c.hashCode();
    }

    public final void clear() {
        this.c.clear();
    }

    public final boolean containsKey(Object obj) {
        return this.c.containsKey(obj);
    }

    public final boolean containsValue(Object obj) {
        return this.c.containsValue(obj);
    }

    @NonNull
    public final Set<Entry<String, Object>> entrySet() {
        return this.c.entrySet();
    }

    public final Object get(Object obj) {
        return this.c.get(obj);
    }

    public final boolean isEmpty() {
        return this.c.isEmpty();
    }

    @NonNull
    public final Set<String> keySet() {
        return this.c.keySet();
    }

    public final Object a(String str, Object obj) {
        return this.c.put(str, obj);
    }

    public final void putAll(Map<? extends String, ?> map) {
        this.c.putAll(map);
    }

    public final void a(Map<? extends String, ?> map, boolean z) {
        this.c.putAll(map);
        if (!z) {
            this.b.putAll(map);
            Map map2 = this.a;
            for (Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                int indexOf = str.indexOf(":");
                if (indexOf > 0) {
                    String substring = str.substring(indexOf);
                    if (substring.equals(":enabled")) {
                        str = str.substring(0, indexOf);
                        this.c.put(str, entry.getValue());
                        this.b.put(str, entry.getValue());
                    } else {
                        String replace = substring.replace(":enabled", "");
                        Map map3 = (Map) map2.get(replace);
                        if (map3 == null) {
                            map3 = new b();
                            map2.put(replace, map3);
                        }
                        map3.put(str.substring(0, indexOf), entry.getValue());
                    }
                }
            }
        }
    }

    public final Object remove(Object obj) {
        return this.c.remove(obj);
    }

    public final int size() {
        return this.c.size();
    }

    @NonNull
    public final Collection<Object> values() {
        return this.c.values();
    }

    protected final ao c() {
        ao aoVar = new ao();
        aoVar.c.putAll(this.c);
        for (Entry entry : this.a.entrySet()) {
            Map bVar = new b();
            bVar.putAll((Map) entry.getValue());
            aoVar.a.put(entry.getKey(), bVar);
        }
        aoVar.b.putAll(this.b);
        return aoVar;
    }
}
