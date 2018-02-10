package com.bumptech.glide.b.b.a;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.support.annotation.Nullable;
import com.bumptech.glide.util.l;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.TreeMap;

@TargetApi(19)
/* compiled from: ProGuard */
public final class w implements r {
    private static final Config[] a = new Config[]{Config.ARGB_8888, null};
    private static final Config[] b = new Config[]{Config.RGB_565};
    private static final Config[] c = new Config[]{Config.ARGB_4444};
    private static final Config[] d = new Config[]{Config.ALPHA_8};
    private final v e = new v();
    private final j<u, Bitmap> f = new j();
    private final Map<Config, NavigableMap<Integer, Integer>> g = new HashMap();

    public final void a(Bitmap bitmap) {
        u a = this.e.a(l.a(bitmap), bitmap.getConfig());
        this.f.a(a, bitmap);
        NavigableMap a2 = a(bitmap.getConfig());
        Integer num = (Integer) a2.get(Integer.valueOf(a.a));
        a2.put(Integer.valueOf(a.a), Integer.valueOf(num == null ? 1 : num.intValue() + 1));
    }

    @Nullable
    public final Bitmap a(int i, int i2, Config config) {
        Config[] configArr;
        s a;
        Bitmap bitmap;
        int i3 = 0;
        int a2 = l.a(i, i2, config);
        s a3 = this.e.a(a2, config);
        switch (t.a[config.ordinal()]) {
            case 1:
                configArr = a;
                break;
            case 2:
                configArr = b;
                break;
            case 3:
                configArr = c;
                break;
            case 4:
                configArr = d;
                break;
            default:
                configArr = new Config[]{config};
                break;
        }
        int length = configArr.length;
        while (i3 < length) {
            Config config2 = configArr[i3];
            Integer num = (Integer) a(config2).ceilingKey(Integer.valueOf(a2));
            if (num == null || num.intValue() > a2 * 8) {
                i3++;
            } else {
                if (num.intValue() != a2 || (config2 != null ? !config2.equals(config) : config != null)) {
                    this.e.a(a3);
                    a = this.e.a(num.intValue(), config2);
                    bitmap = (Bitmap) this.f.a(a);
                    if (bitmap != null) {
                        a(Integer.valueOf(a.a), bitmap);
                        bitmap.reconfigure(i, i2, bitmap.getConfig() != null ? bitmap.getConfig() : Config.ARGB_8888);
                    }
                    return bitmap;
                }
                a = a3;
                bitmap = (Bitmap) this.f.a(a);
                if (bitmap != null) {
                    a(Integer.valueOf(a.a), bitmap);
                    if (bitmap.getConfig() != null) {
                    }
                    bitmap.reconfigure(i, i2, bitmap.getConfig() != null ? bitmap.getConfig() : Config.ARGB_8888);
                }
                return bitmap;
            }
        }
        a = a3;
        bitmap = (Bitmap) this.f.a(a);
        if (bitmap != null) {
            a(Integer.valueOf(a.a), bitmap);
            if (bitmap.getConfig() != null) {
            }
            bitmap.reconfigure(i, i2, bitmap.getConfig() != null ? bitmap.getConfig() : Config.ARGB_8888);
        }
        return bitmap;
    }

    @Nullable
    public final Bitmap a() {
        Bitmap bitmap = (Bitmap) this.f.a();
        if (bitmap != null) {
            a(Integer.valueOf(l.a(bitmap)), bitmap);
        }
        return bitmap;
    }

    private void a(Integer num, Bitmap bitmap) {
        NavigableMap a = a(bitmap.getConfig());
        Integer num2 = (Integer) a.get(num);
        if (num2 == null) {
            throw new NullPointerException("Tried to decrement empty size, size: " + num + ", removed: " + b(bitmap) + ", this: " + this);
        } else if (num2.intValue() == 1) {
            a.remove(num);
        } else {
            a.put(num, Integer.valueOf(num2.intValue() - 1));
        }
    }

    private NavigableMap<Integer, Integer> a(Config config) {
        NavigableMap<Integer, Integer> navigableMap = (NavigableMap) this.g.get(config);
        if (navigableMap != null) {
            return navigableMap;
        }
        NavigableMap treeMap = new TreeMap();
        this.g.put(config, treeMap);
        return treeMap;
    }

    public final String b(Bitmap bitmap) {
        return a(l.a(bitmap), bitmap.getConfig());
    }

    public final String b(int i, int i2, Config config) {
        return a(l.a(i, i2, config), config);
    }

    public final int c(Bitmap bitmap) {
        return l.a(bitmap);
    }

    public final String toString() {
        StringBuilder append = new StringBuilder("SizeConfigStrategy{groupedMap=").append(this.f).append(", sortedSizes=(");
        for (Entry entry : this.g.entrySet()) {
            append.append(entry.getKey()).append('[').append(entry.getValue()).append("], ");
        }
        if (!this.g.isEmpty()) {
            append.replace(append.length() - 2, append.length(), "");
        }
        return append.append(")}").toString();
    }

    static String a(int i, Config config) {
        return "[" + i + "](" + config + ")";
    }
}
