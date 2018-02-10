package com.alibaba.analytics.core.f;

import com.alibaba.analytics.a.af;
import com.alibaba.analytics.core.model.b;
import java.io.File;
import java.util.List;

/* compiled from: ProGuard */
final class a implements h {
    String a = "SELECT * FROM %s ORDER BY %s ASC LIMIT %d";
    String b = "SELECT count(*) FROM %s";
    String c = "DELETE FROM  %s where _id in ( select _id from %s  ORDER BY priority ASC ,  _id ASC LIMIT %d )";

    a() {
    }

    public final synchronized boolean a(List<b> list) {
        com.alibaba.analytics.core.b.a().n.a((List) list);
        return true;
    }

    public final synchronized int b(List<b> list) {
        return com.alibaba.analytics.core.b.a().n.b((List) list);
    }

    public final synchronized List<b> a(int i) {
        return com.alibaba.analytics.core.b.a().n.a(b.class, null, "priority DESC , time DESC ", i);
    }

    public final synchronized int a() {
        return com.alibaba.analytics.core.b.a().n.b(b.class);
    }

    public final synchronized int a(String str, String str2) {
        af.b();
        return com.alibaba.analytics.core.b.a().n.a(b.class, str + "< ?", new String[]{str2});
    }

    public final int b() {
        af.b();
        return com.alibaba.analytics.core.b.a().n.a(b.class, " _id in ( select _id from " + com.alibaba.analytics.core.b.a().n.a(b.class) + "  ORDER BY priority ASC , _id ASC LIMIT 1000 )", null);
    }

    public final double c() {
        com.alibaba.analytics.core.db.a aVar = com.alibaba.analytics.core.b.a().n;
        File databasePath = com.alibaba.analytics.core.b.a().b.getDatabasePath("ut.db");
        if (databasePath != null) {
            return (((double) databasePath.length()) / 1024.0d) / 1024.0d;
        }
        return 0.0d;
    }

    public final synchronized void c(List<b> list) {
        com.alibaba.analytics.core.b.a().n.d((List) list);
    }
}
