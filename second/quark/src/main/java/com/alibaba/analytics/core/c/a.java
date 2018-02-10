package com.alibaba.analytics.core.c;

import android.text.TextUtils;
import com.alibaba.analytics.a.af;
import com.alibaba.analytics.core.h.e;
import com.alibaba.analytics.core.h.q;
import com.alibaba.appmonitor.f.h;
import com.alibaba.fastjson.b;
import com.alibaba.mtl.appmonitor.model.Measure;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: ProGuard */
public final class a implements q {
    private static a f = new a();
    public Set<String> a = Collections.synchronizedSet(new HashSet());
    private final String b = "sampling_monitor_ut";
    private final String c = "sampling_monitor_ap";
    private final String d = "abtest_bucket";
    private final String e = "abtest_offline";
    private Set<String> g = Collections.synchronizedSet(new HashSet());
    private Map<String, MeasureSet> h = Collections.synchronizedMap(new HashMap());
    private Set<String> i = Collections.synchronizedSet(new HashSet());

    private a() {
        e.a().a("sampling_monitor_ut", (q) this);
        e.a().a("sampling_monitor_ap", (q) this);
        e.a().a("abtest_bucket", (q) this);
        e.a().a("abtest_offline", (q) this);
        a(this.a, e.a().a("sampling_monitor_ut"));
        a(this.g, e.a().a("sampling_monitor_ap"));
        a(this.i, e.a().a("abtest_offline"));
        a(e.a().a("abtest_bucket"));
        e.a().a("test_config_arrival_rate", new b());
        e.a().a("selfcheck", c.a());
    }

    public static a a() {
        return f;
    }

    public final void b(String str, String str2) {
        Set set = null;
        if ("sampling_monitor_ut".equalsIgnoreCase(str)) {
            set = this.a;
        } else if ("sampling_monitor_ap".equalsIgnoreCase(str)) {
            set = this.g;
        } else if ("abtest_offline".equalsIgnoreCase(str)) {
            set = this.i;
        }
        if (set != null) {
            a(set, str2);
        }
        if ("abtest_bucket".equalsIgnoreCase(str)) {
            a(str2);
        }
    }

    private static void a(Set<String> set, String str) {
        if (set != null) {
            set.clear();
            if (!TextUtils.isEmpty(str)) {
                String[] split = str.split(",");
                if (split != null && split.length > 0) {
                    set.addAll(Arrays.asList(split));
                }
            }
        }
    }

    public final boolean a(h hVar, String str, String str2) {
        if (!"AppMonitor".equalsIgnoreCase(str) && this.g.contains(hVar + ":" + str + ":" + str2)) {
            return true;
        }
        return false;
    }

    public final MeasureSet a(String str, String str2) {
        return (MeasureSet) this.h.get(str + ":" + str2);
    }

    public final boolean b(h hVar, String str, String str2) {
        if (this.i.contains(hVar + ":" + str + ":" + str2)) {
            return true;
        }
        return false;
    }

    private void a(String str) {
        this.h.clear();
        if (!TextUtils.isEmpty(str)) {
            b c = com.alibaba.fastjson.a.c(str);
            if (c != null) {
                for (int i = 0; i < c.size(); i++) {
                    com.alibaba.fastjson.e eVar = (com.alibaba.fastjson.e) c.get(i);
                    if (eVar != null) {
                        String h = eVar.h("module");
                        String h2 = eVar.h("mp");
                        eVar = (com.alibaba.fastjson.e) eVar.get("buckets");
                        if (eVar != null) {
                            Set<String> keySet = eVar.keySet();
                            if (keySet != null) {
                                MeasureSet a = MeasureSet.a();
                                for (String str2 : keySet) {
                                    Object h3 = eVar.h(str2);
                                    if (!TextUtils.isEmpty(h3)) {
                                        String[] split = h3.split(",");
                                        if (split != null) {
                                            List arrayList = new ArrayList();
                                            for (String valueOf : split) {
                                                try {
                                                    arrayList.add(Double.valueOf(valueOf));
                                                } catch (Throwable th) {
                                                }
                                            }
                                            try {
                                                Measure measure = new Measure(str2, Double.valueOf(0.0d), arrayList);
                                                if (!a.a.contains(measure)) {
                                                    a.a.add(measure);
                                                }
                                            } catch (Throwable th2) {
                                                af.a("Parse Monitor Bucket error ", th2, new Object[0]);
                                                return;
                                            }
                                        }
                                        continue;
                                    }
                                }
                                this.h.put(h + ":" + h2, a);
                                com.alibaba.appmonitor.model.b a2 = com.alibaba.appmonitor.model.a.a().a(h, h2);
                                if (a2 != null) {
                                    com.alibaba.appmonitor.model.a.a().a(new com.alibaba.appmonitor.model.b(h + "_abtest", h2, a, a2.c(), false));
                                }
                            } else {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
        }
    }
}
