package com.ucpro.feature.g.e.a;

import com.raizlabs.android.dbflow.a.b.a.b;
import com.raizlabs.android.dbflow.a.b.g;
import com.raizlabs.android.dbflow.a.b.z;
import com.raizlabs.android.dbflow.structure.database.c;
import com.uc.apollo.android.GuideDialog;

/* compiled from: ProGuard */
public final class a extends com.raizlabs.android.dbflow.structure.a<c> {
    public static final com.raizlabs.android.dbflow.a.b.a.a<Long> f = new com.raizlabs.android.dbflow.a.b.a.a(c.class, "luid");
    public static final com.raizlabs.android.dbflow.a.b.a.a<Long> g = new com.raizlabs.android.dbflow.a.b.a.a(c.class, "widgetId");
    public static final com.raizlabs.android.dbflow.a.b.a.a<String> h = new com.raizlabs.android.dbflow.a.b.a.a(c.class, "guid");
    public static final com.raizlabs.android.dbflow.a.b.a.a<String> i = new com.raizlabs.android.dbflow.a.b.a.a(c.class, GuideDialog.TITLE);
    public static final com.raizlabs.android.dbflow.a.b.a.a<String> j = new com.raizlabs.android.dbflow.a.b.a.a(c.class, "url");
    public static final com.raizlabs.android.dbflow.a.b.a.a<String> k = new com.raizlabs.android.dbflow.a.b.a.a(c.class, "fingerPrint");
    public static final com.raizlabs.android.dbflow.a.b.a.a<Integer> l = new com.raizlabs.android.dbflow.a.b.a.a(c.class, "type");
    public static final com.raizlabs.android.dbflow.a.b.a.a<Integer> m = new com.raizlabs.android.dbflow.a.b.a.a(c.class, "index");
    public static final com.raizlabs.android.dbflow.a.b.a.a<Long> n = new com.raizlabs.android.dbflow.a.b.a.a(c.class, "createTime");
    public static final com.raizlabs.android.dbflow.a.b.a.a<String> o = new com.raizlabs.android.dbflow.a.b.a.a(c.class, "iconName");
    public static final com.raizlabs.android.dbflow.a.b.a.a<String> p = new com.raizlabs.android.dbflow.a.b.a.a(c.class, "backupIconName");
    public static final com.raizlabs.android.dbflow.a.b.a.a<String> q = new com.raizlabs.android.dbflow.a.b.a.a(c.class, "displayTitle");
    public static final com.raizlabs.android.dbflow.a.b.a.a<Integer> r = new com.raizlabs.android.dbflow.a.b.a.a(c.class, "source");
    public static final com.raizlabs.android.dbflow.a.b.a.a<Boolean> s = new com.raizlabs.android.dbflow.a.b.a.a(c.class, "deletable");
    public static final com.raizlabs.android.dbflow.a.b.a.a<Integer> t = new com.raizlabs.android.dbflow.a.b.a.a(c.class, "syncState");
    public static final b[] u = new b[]{f, g, h, i, j, k, l, m, n, o, p, q, r, s, t};

    public final /* synthetic */ void a(com.raizlabs.android.dbflow.structure.database.a aVar, Object obj) {
        c cVar = (c) obj;
        aVar.a(1, cVar.b);
        aVar.b(2, cVar.c);
        aVar.b(3, cVar.d);
        aVar.b(4, cVar.e);
        aVar.b(5, cVar.f);
        aVar.a(6, (long) cVar.g);
        aVar.a(7, (long) cVar.h);
        aVar.a(8, cVar.i);
        aVar.b(9, cVar.j);
        aVar.b(10, cVar.k);
        aVar.b(11, cVar.l);
        aVar.a(12, (long) cVar.m);
        aVar.a(13, cVar.n ? 1 : 0);
        aVar.a(14, (long) cVar.o);
    }

    public final /* synthetic */ void a(c cVar, Object obj) {
        boolean z = true;
        c cVar2 = (c) obj;
        cVar2.a = cVar.c("luid");
        cVar2.b = cVar.c("widgetId");
        cVar2.c = cVar.a("guid");
        cVar2.d = cVar.a(GuideDialog.TITLE);
        cVar2.e = cVar.a("url");
        cVar2.f = cVar.a("fingerPrint");
        cVar2.g = cVar.b("type");
        cVar2.h = cVar.b("index");
        cVar2.i = cVar.c("createTime");
        cVar2.j = cVar.a("iconName");
        cVar2.k = cVar.a("backupIconName");
        cVar2.l = cVar.a("displayTitle");
        cVar2.m = cVar.b("source");
        int columnIndex = cVar.getColumnIndex("deletable");
        if (columnIndex == -1 || cVar.isNull(columnIndex)) {
            cVar2.n = false;
        } else {
            if (cVar.a.getInt(columnIndex) != 1) {
                z = false;
            }
            cVar2.n = z;
        }
        cVar2.o = cVar.b("syncState");
    }

    public final /* synthetic */ void a(Object obj, Number number) {
        ((c) obj).a = number.longValue();
    }

    public final /* synthetic */ boolean a(Object obj, com.raizlabs.android.dbflow.structure.database.b bVar) {
        if (((c) obj).a > 0) {
            if (z.b(new b[0]).a(c.class).a(a(r7)).c(bVar)) {
                return true;
            }
        }
        return false;
    }

    public final /* synthetic */ void b(com.raizlabs.android.dbflow.structure.database.a aVar, Object obj) {
        c cVar = (c) obj;
        aVar.a(1, cVar.a);
        aVar.a(2, cVar.b);
        aVar.b(3, cVar.c);
        aVar.b(4, cVar.d);
        aVar.b(5, cVar.e);
        aVar.b(6, cVar.f);
        aVar.a(7, (long) cVar.g);
        aVar.a(8, (long) cVar.h);
        aVar.a(9, cVar.i);
        aVar.b(10, cVar.j);
        aVar.b(11, cVar.k);
        aVar.b(12, cVar.l);
        aVar.a(13, (long) cVar.m);
        aVar.a(14, cVar.n ? 1 : 0);
        aVar.a(15, (long) cVar.o);
        aVar.a(16, cVar.a);
    }

    public final /* synthetic */ void c(com.raizlabs.android.dbflow.structure.database.a aVar, Object obj) {
        aVar.a(1, ((c) obj).a);
    }

    public final /* synthetic */ g e(Object obj) {
        return a((c) obj);
    }

    public a(com.raizlabs.android.dbflow.config.c cVar) {
        super(cVar);
    }

    public final Class<c> i() {
        return c.class;
    }

    public final String j_() {
        return "`Navigation`";
    }

    public final String d() {
        return "INSERT INTO `Navigation`(`widgetId`,`guid`,`title`,`url`,`fingerPrint`,`type`,`index`,`createTime`,`iconName`,`backupIconName`,`displayTitle`,`source`,`deletable`,`syncState`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }

    public final String e() {
        return "INSERT INTO `Navigation`(`luid`,`widgetId`,`guid`,`title`,`url`,`fingerPrint`,`type`,`index`,`createTime`,`iconName`,`backupIconName`,`displayTitle`,`source`,`deletable`,`syncState`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }

    public final String f() {
        return "UPDATE `Navigation` SET `luid`=?,`widgetId`=?,`guid`=?,`title`=?,`url`=?,`fingerPrint`=?,`type`=?,`index`=?,`createTime`=?,`iconName`=?,`backupIconName`=?,`displayTitle`=?,`source`=?,`deletable`=?,`syncState`=? WHERE `luid`=?";
    }

    public final String g() {
        return "DELETE FROM `Navigation` WHERE `luid`=?";
    }

    public final String c() {
        return "CREATE TABLE IF NOT EXISTS `Navigation`(`luid` INTEGER PRIMARY KEY AUTOINCREMENT, `widgetId` INTEGER UNIQUE ON CONFLICT FAIL, `guid` TEXT, `title` TEXT, `url` TEXT, `fingerPrint` TEXT, `type` INTEGER, `index` INTEGER, `createTime` INTEGER, `iconName` TEXT, `backupIconName` TEXT, `displayTitle` TEXT, `source` INTEGER, `deletable` INTEGER, `syncState` INTEGER)";
    }

    private static g a(c cVar) {
        g i = g.i();
        i.a("AND", f.a(Long.valueOf(cVar.a)));
        return i;
    }

    public final /* synthetic */ Object h() {
        return new c();
    }
}
