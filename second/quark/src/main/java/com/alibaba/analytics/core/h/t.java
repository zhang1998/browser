package com.alibaba.analytics.core.h;

import com.alibaba.analytics.core.model.LogField;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public final class t extends m {
    private static t b = null;
    private Map<String, l> a = new HashMap();

    public static t a() {
        if (b == null) {
            b = new t();
        }
        return b;
    }

    private t() {
    }

    public final synchronized boolean a(Map<String, String> map) {
        boolean z;
        int i = -1;
        synchronized (this) {
            if (this.a.size() == 0) {
                z = true;
            } else {
                if (map.containsKey(LogField.EVENTID.toString())) {
                    try {
                        i = Integer.parseInt((String) map.get(LogField.EVENTID.toString()));
                    } catch (Exception e) {
                    }
                }
                String str = null;
                if (map.containsKey(LogField.ARG1.toString())) {
                    str = (String) map.get(LogField.ARG1.toString());
                }
                d a = a(i, str);
                if (a.a) {
                    z = true;
                } else if (a.b) {
                    z = false;
                } else {
                    a = a(i - (i % 10), str);
                    if (a.a) {
                        z = true;
                    } else if (a.b) {
                        z = false;
                    } else {
                        a = a(i - (i % 100), str);
                        if (a.a) {
                            z = true;
                        } else if (a.b) {
                            z = false;
                        } else {
                            d a2 = a(i - (i % 1000), str);
                            if (a2.a) {
                                z = true;
                            } else if (a2.b) {
                                z = false;
                            } else {
                                d a3 = a(-1, str);
                                if (a3.a) {
                                    z = true;
                                } else if (a3.b) {
                                    z = false;
                                } else {
                                    z = false;
                                }
                            }
                        }
                    }
                }
            }
        }
        return z;
    }

    private d a(int i, String str) {
        String valueOf = String.valueOf(i);
        d dVar = new d();
        if (this.a.containsKey(valueOf)) {
            l lVar = (l) this.a.get(valueOf);
            dVar.b = true;
            dVar.a = lVar.a(str);
            return dVar;
        }
        dVar.a = false;
        return dVar;
    }

    public final synchronized void a(String str, Map<String, String> map) {
        this.a.clear();
        for (String str2 : map.keySet()) {
            String str3 = (String) map.get(str2);
            if (str3 != null) {
                l b = l.b(str3);
                if (b != null) {
                    this.a.put(str2, b);
                }
            }
        }
    }

    public final String[] c() {
        return new String[]{"ut_sample"};
    }
}
