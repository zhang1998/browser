package com.alibaba.fastjson.b;

import com.alibaba.fastjson.a;
import com.alibaba.fastjson.a.a.e;
import com.alibaba.fastjson.a.c;
import com.alibaba.fastjson.a.i;
import com.alibaba.fastjson.d;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* compiled from: ProGuard */
public final class h implements e, u {
    public static final h a = new h();

    private h() {
    }

    public final void a(o oVar, Object obj, Object obj2, Type type) throws IOException {
        aa aaVar = oVar.b;
        if (obj == null) {
            aaVar.write("null");
        } else if ((aaVar.c & z.WriteClassName.x) == 0 || obj.getClass() == type) {
            if (obj instanceof Calendar) {
                obj = ((Calendar) obj).getTime();
            } else {
                Date date = (Date) obj;
            }
            if ((aaVar.c & z.WriteDateUseDateFormat.x) != 0) {
                DateFormat a = oVar.a();
                if (a == null) {
                    a = new SimpleDateFormat(a.d, oVar.l);
                    a.setTimeZone(oVar.k);
                }
                aaVar.a(a.format(obj));
                return;
            }
            long time = obj.getTime();
            if ((aaVar.c & z.UseISO8601DateFormat.x) != 0) {
                char[] toCharArray;
                if ((aaVar.c & z.UseSingleQuotes.x) != 0) {
                    aaVar.write(39);
                } else {
                    aaVar.write(34);
                }
                Calendar instance = Calendar.getInstance(oVar.k, oVar.l);
                instance.setTimeInMillis(time);
                int i = instance.get(1);
                int i2 = instance.get(2) + 1;
                int i3 = instance.get(5);
                int i4 = instance.get(11);
                int i5 = instance.get(12);
                int i6 = instance.get(13);
                int i7 = instance.get(14);
                if (i7 != 0) {
                    toCharArray = "0000-00-00T00:00:00.000".toCharArray();
                    aa.a((long) i7, 23, toCharArray);
                    aa.a((long) i6, 19, toCharArray);
                    aa.a((long) i5, 16, toCharArray);
                    aa.a((long) i4, 13, toCharArray);
                    aa.a((long) i3, 10, toCharArray);
                    aa.a((long) i2, 7, toCharArray);
                    aa.a((long) i, 4, toCharArray);
                } else if (i6 == 0 && i5 == 0 && i4 == 0) {
                    toCharArray = "0000-00-00".toCharArray();
                    aa.a((long) i3, 10, toCharArray);
                    aa.a((long) i2, 7, toCharArray);
                    aa.a((long) i, 4, toCharArray);
                } else {
                    toCharArray = "0000-00-00T00:00:00".toCharArray();
                    aa.a((long) i6, 19, toCharArray);
                    aa.a((long) i5, 16, toCharArray);
                    aa.a((long) i4, 13, toCharArray);
                    aa.a((long) i3, 10, toCharArray);
                    aa.a((long) i2, 7, toCharArray);
                    aa.a((long) i, 4, toCharArray);
                }
                aaVar.write(toCharArray);
                if ((aaVar.c & z.UseSingleQuotes.x) != 0) {
                    aaVar.write(39);
                    return;
                } else {
                    aaVar.write(34);
                    return;
                }
            }
            aaVar.a(time);
        } else if (obj.getClass() == Date.class) {
            aaVar.write("new Date(");
            aaVar.a(((Date) obj).getTime());
            aaVar.write(41);
        } else {
            aaVar.write(123);
            aaVar.a("@type", false);
            oVar.a(obj.getClass().getName());
            aaVar.write(44);
            aaVar.a("val", false);
            aaVar.a(((Date) obj).getTime());
            aaVar.write(125);
        }
    }

    public final <T> T a(c cVar, Type type, Object obj) {
        return a(cVar, type, null);
    }

    public static <T> T a(c cVar, Type type, String str) {
        Object valueOf;
        T m;
        i iVar = cVar.e;
        int a = iVar.a();
        if (a == 2) {
            valueOf = Long.valueOf(iVar.w());
            iVar.a(16);
        } else if (a == 4) {
            valueOf = iVar.p();
            iVar.a(16);
            if ((iVar.c & com.alibaba.fastjson.a.e.AllowISO8601DateFormat.q) != 0) {
                i iVar2 = new i(valueOf);
                if (iVar2.b(true)) {
                    m = iVar2.m();
                    if (type == Calendar.class) {
                        iVar2.b();
                        return m;
                    }
                    valueOf = m.getTime();
                }
                iVar2.b();
            }
        } else if (a == 8) {
            iVar.g();
            valueOf = null;
        } else if (a == 12) {
            iVar.g();
            if (iVar.a() == 4) {
                if ("@type".equals(iVar.p())) {
                    iVar.g();
                    cVar.a(17);
                    Class a2 = com.alibaba.fastjson.c.e.a(iVar.p(), cVar.b.c);
                    if (a2 != null) {
                        type = a2;
                    }
                    cVar.a(4);
                    cVar.a(16);
                }
                iVar.d();
                if (iVar.a() == 2) {
                    long w = iVar.w();
                    iVar.g();
                    valueOf = Long.valueOf(w);
                    cVar.a(13);
                } else {
                    throw new d("syntax error : " + iVar.h());
                }
            }
            throw new d("syntax error");
        } else if (cVar.g == 2) {
            cVar.g = 0;
            cVar.a(16);
            if (iVar.a() != 4) {
                throw new d("syntax error");
            } else if ("val".equals(iVar.p())) {
                iVar.g();
                cVar.a(17);
                valueOf = cVar.a(null);
                cVar.a(13);
            } else {
                throw new d("syntax error");
            }
        } else {
            valueOf = cVar.a(null);
        }
        m = a(cVar, type, valueOf, str);
        if (type != Calendar.class || (m instanceof Calendar)) {
            return m;
        }
        Date date = (Date) m;
        if (date == null) {
            return null;
        }
        T instance = Calendar.getInstance(iVar.k, iVar.l);
        instance.setTime(date);
        return instance;
    }

    private static <T> T a(c cVar, Type type, Object obj, String str) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Date) {
            return obj;
        }
        if (obj instanceof Number) {
            return new Date(((Number) obj).longValue());
        }
        if (obj instanceof String) {
            obj = (String) obj;
            if (obj.length() == 0) {
                return null;
            }
            i iVar = new i(obj);
            try {
                if (iVar.b(false)) {
                    obj = iVar.m();
                    if (type == Calendar.class) {
                        return obj;
                    }
                    obj = obj.getTime();
                    iVar.b();
                    return obj;
                }
                DateFormat simpleDateFormat;
                iVar.b();
                if (str != null) {
                    simpleDateFormat = new SimpleDateFormat(str);
                } else {
                    if (cVar.d == null) {
                        cVar.d = new SimpleDateFormat(cVar.c, cVar.e.l);
                        cVar.d.setTimeZone(cVar.e.k);
                    }
                    simpleDateFormat = cVar.d;
                }
                try {
                    return simpleDateFormat.parse(obj);
                } catch (ParseException e) {
                    return new Date(Long.parseLong(obj));
                }
            } finally {
                iVar.b();
            }
        } else {
            throw new d("parse error");
        }
    }
}
