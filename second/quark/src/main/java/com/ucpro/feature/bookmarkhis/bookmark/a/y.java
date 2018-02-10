package com.ucpro.feature.bookmarkhis.bookmark.a;

import com.raizlabs.android.dbflow.a.b.a.b;
import com.raizlabs.android.dbflow.a.b.g;
import com.raizlabs.android.dbflow.a.b.z;
import com.raizlabs.android.dbflow.structure.a;
import com.raizlabs.android.dbflow.structure.database.c;
import com.uc.apollo.android.GuideDialog;

/* compiled from: ProGuard */
public final class y extends a<m> {
    public static final b[] A = new b[]{f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z};
    public static final com.raizlabs.android.dbflow.a.b.a.a<Long> f = new com.raizlabs.android.dbflow.a.b.a.a(m.class, "luid");
    public static final com.raizlabs.android.dbflow.a.b.a.a<String> g = new com.raizlabs.android.dbflow.a.b.a.a(m.class, "guid");
    public static final com.raizlabs.android.dbflow.a.b.a.a<Long> h = new com.raizlabs.android.dbflow.a.b.a.a(m.class, "parent_id");
    public static final com.raizlabs.android.dbflow.a.b.a.a<String> i = new com.raizlabs.android.dbflow.a.b.a.a(m.class, GuideDialog.TITLE);
    public static final com.raizlabs.android.dbflow.a.b.a.a<String> j = new com.raizlabs.android.dbflow.a.b.a.a(m.class, "url");
    public static final com.raizlabs.android.dbflow.a.b.a.a<String> k = new com.raizlabs.android.dbflow.a.b.a.a(m.class, "path");
    public static final com.raizlabs.android.dbflow.a.b.a.a<Integer> l = new com.raizlabs.android.dbflow.a.b.a.a(m.class, "order_index");
    public static final com.raizlabs.android.dbflow.a.b.a.a<Integer> m = new com.raizlabs.android.dbflow.a.b.a.a(m.class, "property");
    public static final com.raizlabs.android.dbflow.a.b.a.a<Integer> n = new com.raizlabs.android.dbflow.a.b.a.a(m.class, "folder");
    public static final com.raizlabs.android.dbflow.a.b.a.a<Long> o = new com.raizlabs.android.dbflow.a.b.a.a(m.class, "last_modify_time");
    public static final com.raizlabs.android.dbflow.a.b.a.a<Long> p = new com.raizlabs.android.dbflow.a.b.a.a(m.class, "create_time");
    public static final com.raizlabs.android.dbflow.a.b.a.a<Long> q = new com.raizlabs.android.dbflow.a.b.a.a(m.class, "pin_time");
    public static final com.raizlabs.android.dbflow.a.b.a.a<String> r = new com.raizlabs.android.dbflow.a.b.a.a(m.class, "device_type");
    public static final com.raizlabs.android.dbflow.a.b.a.a<String> s = new com.raizlabs.android.dbflow.a.b.a.a(m.class, "platform");
    public static final com.raizlabs.android.dbflow.a.b.a.a<Integer> t = new com.raizlabs.android.dbflow.a.b.a.a(m.class, "opt_state");
    public static final com.raizlabs.android.dbflow.a.b.a.a<Integer> u = new com.raizlabs.android.dbflow.a.b.a.a(m.class, "sync_state");
    public static final com.raizlabs.android.dbflow.a.b.a.a<Integer> v = new com.raizlabs.android.dbflow.a.b.a.a(m.class, "modify_flag");
    public static final com.raizlabs.android.dbflow.a.b.a.a<String> w = new com.raizlabs.android.dbflow.a.b.a.a(m.class, "fingerprint");
    public static final com.raizlabs.android.dbflow.a.b.a.a<Integer> x = new com.raizlabs.android.dbflow.a.b.a.a(m.class, "ext_int1");
    public static final com.raizlabs.android.dbflow.a.b.a.a<Integer> y = new com.raizlabs.android.dbflow.a.b.a.a(m.class, "ext_int2");
    public static final com.raizlabs.android.dbflow.a.b.a.a<String> z = new com.raizlabs.android.dbflow.a.b.a.a(m.class, "ext_string1");

    public final /* synthetic */ void a(com.raizlabs.android.dbflow.structure.database.a aVar, Object obj) {
        m mVar = (m) obj;
        aVar.b(1, mVar.c);
        aVar.a(2, mVar.d);
        aVar.b(3, mVar.e);
        aVar.b(4, mVar.f);
        aVar.b(5, mVar.g);
        aVar.a(6, (long) mVar.h);
        aVar.a(7, (long) mVar.i);
        aVar.a(8, (long) mVar.j);
        aVar.a(9, mVar.k);
        aVar.a(10, mVar.l);
        aVar.a(11, mVar.m);
        aVar.b(12, mVar.n);
        aVar.b(13, mVar.o);
        aVar.a(14, (long) mVar.p);
        aVar.a(15, (long) mVar.q);
        aVar.a(16, (long) mVar.r);
        aVar.b(17, mVar.s);
        aVar.a(18, (long) mVar.t);
        aVar.a(19, (long) mVar.u);
        aVar.b(20, mVar.v);
    }

    public final /* synthetic */ void a(c cVar, Object obj) {
        m mVar = (m) obj;
        mVar.b = cVar.c("luid");
        mVar.c = cVar.a("guid");
        mVar.d = cVar.c("parent_id");
        mVar.e = cVar.a(GuideDialog.TITLE);
        mVar.f = cVar.a("url");
        mVar.g = cVar.a("path");
        mVar.h = cVar.b("order_index");
        mVar.i = cVar.b("property");
        mVar.j = cVar.b("folder");
        mVar.k = cVar.c("last_modify_time");
        mVar.l = cVar.c("create_time");
        mVar.m = cVar.c("pin_time");
        mVar.n = cVar.a("device_type");
        mVar.o = cVar.a("platform");
        mVar.p = cVar.b("opt_state");
        mVar.q = cVar.b("sync_state");
        mVar.r = cVar.b("modify_flag");
        mVar.s = cVar.a("fingerprint");
        mVar.t = cVar.b("ext_int1");
        mVar.u = cVar.b("ext_int2");
        mVar.v = cVar.a("ext_string1");
    }

    public final /* synthetic */ void a(Object obj, Number number) {
        ((m) obj).b = number.longValue();
    }

    public final /* synthetic */ boolean a(Object obj, com.raizlabs.android.dbflow.structure.database.b bVar) {
        if (((m) obj).b > 0) {
            if (z.b(new b[0]).a(m.class).a(a(r7)).c(bVar)) {
                return true;
            }
        }
        return false;
    }

    public final /* synthetic */ void b(com.raizlabs.android.dbflow.structure.database.a aVar, Object obj) {
        m mVar = (m) obj;
        aVar.a(1, mVar.b);
        aVar.b(2, mVar.c);
        aVar.a(3, mVar.d);
        aVar.b(4, mVar.e);
        aVar.b(5, mVar.f);
        aVar.b(6, mVar.g);
        aVar.a(7, (long) mVar.h);
        aVar.a(8, (long) mVar.i);
        aVar.a(9, (long) mVar.j);
        aVar.a(10, mVar.k);
        aVar.a(11, mVar.l);
        aVar.a(12, mVar.m);
        aVar.b(13, mVar.n);
        aVar.b(14, mVar.o);
        aVar.a(15, (long) mVar.p);
        aVar.a(16, (long) mVar.q);
        aVar.a(17, (long) mVar.r);
        aVar.b(18, mVar.s);
        aVar.a(19, (long) mVar.t);
        aVar.a(20, (long) mVar.u);
        aVar.b(21, mVar.v);
        aVar.a(22, mVar.b);
    }

    public final /* synthetic */ void c(com.raizlabs.android.dbflow.structure.database.a aVar, Object obj) {
        aVar.a(1, ((m) obj).b);
    }

    public final /* synthetic */ g e(Object obj) {
        return a((m) obj);
    }

    public y(com.raizlabs.android.dbflow.config.c cVar) {
        super(cVar);
    }

    public final Class<m> i() {
        return m.class;
    }

    public final String j_() {
        return "`bookmark`";
    }

    public final String d() {
        return "INSERT INTO `bookmark`(`guid`,`parent_id`,`title`,`url`,`path`,`order_index`,`property`,`folder`,`last_modify_time`,`create_time`,`pin_time`,`device_type`,`platform`,`opt_state`,`sync_state`,`modify_flag`,`fingerprint`,`ext_int1`,`ext_int2`,`ext_string1`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }

    public final String e() {
        return "INSERT INTO `bookmark`(`luid`,`guid`,`parent_id`,`title`,`url`,`path`,`order_index`,`property`,`folder`,`last_modify_time`,`create_time`,`pin_time`,`device_type`,`platform`,`opt_state`,`sync_state`,`modify_flag`,`fingerprint`,`ext_int1`,`ext_int2`,`ext_string1`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }

    public final String f() {
        return "UPDATE `bookmark` SET `luid`=?,`guid`=?,`parent_id`=?,`title`=?,`url`=?,`path`=?,`order_index`=?,`property`=?,`folder`=?,`last_modify_time`=?,`create_time`=?,`pin_time`=?,`device_type`=?,`platform`=?,`opt_state`=?,`sync_state`=?,`modify_flag`=?,`fingerprint`=?,`ext_int1`=?,`ext_int2`=?,`ext_string1`=? WHERE `luid`=?";
    }

    public final String g() {
        return "DELETE FROM `bookmark` WHERE `luid`=?";
    }

    public final String c() {
        return "CREATE TABLE IF NOT EXISTS `bookmark`(`luid` INTEGER PRIMARY KEY AUTOINCREMENT, `guid` TEXT, `parent_id` INTEGER, `title` TEXT, `url` TEXT, `path` TEXT, `order_index` INTEGER, `property` INTEGER, `folder` INTEGER, `last_modify_time` INTEGER, `create_time` INTEGER, `pin_time` INTEGER, `device_type` TEXT, `platform` TEXT, `opt_state` INTEGER, `sync_state` INTEGER, `modify_flag` INTEGER, `fingerprint` TEXT, `ext_int1` INTEGER, `ext_int2` INTEGER, `ext_string1` TEXT)";
    }

    private static g a(m mVar) {
        g i = g.i();
        i.a("AND", f.a(Long.valueOf(mVar.b)));
        return i;
    }

    public final /* synthetic */ Object h() {
        return new m();
    }
}
