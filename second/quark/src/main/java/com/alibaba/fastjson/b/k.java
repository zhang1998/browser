package com.alibaba.fastjson.b;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.c.a;
import com.alibaba.fastjson.d;
import java.io.IOException;
import java.lang.reflect.Member;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

/* compiled from: ProGuard */
public final class k implements Comparable<k> {
    public final a a;
    protected final boolean b;
    protected final int c;
    protected final String d;
    private j e;

    public final /* synthetic */ int compareTo(Object obj) {
        return this.a.a(((k) obj).a);
    }

    public k(a aVar) {
        String str = null;
        boolean z = false;
        this.a = aVar;
        JSONField a = aVar.a();
        if (a != null) {
            for (z zVar : a.serialzeFeatures()) {
                if (zVar == z.WriteMapNullValue) {
                    z = true;
                }
            }
            String trim = a.format().trim();
            if (trim.length() != 0) {
                str = trim;
            }
            this.c = z.a(a.serialzeFeatures());
        } else {
            this.c = 0;
        }
        this.b = z;
        this.d = str;
    }

    public final void a(o oVar) throws IOException {
        aa aaVar = oVar.b;
        int i = aaVar.c;
        if ((z.QuoteFieldNames.x & i) == 0 || (i & z.UseSingleQuotes.x) != 0) {
            aaVar.a(this.a.a, true);
        } else {
            aaVar.write(this.a.j, 0, this.a.j.length);
        }
    }

    public final Object a(Object obj) throws Exception {
        try {
            a aVar = this.a;
            if (aVar.d) {
                return aVar.c.get(obj);
            }
            return aVar.b.invoke(obj, new Object[0]);
        } catch (Throwable e) {
            Throwable th = e;
            Member member = this.a.b != null ? this.a.b : this.a.c;
            throw new d("get property error。 " + (member.getDeclaringClass().getName() + "." + member.getName()), th);
        }
    }

    public final void a(o oVar, Object obj) throws Exception {
        if (this.d != null) {
            String str = this.d;
            if (obj instanceof Date) {
                DateFormat a = oVar.a();
                if (a == null) {
                    a = new SimpleDateFormat(str, oVar.l);
                    a.setTimeZone(oVar.k);
                }
                oVar.b.a(a.format((Date) obj));
                return;
            }
            oVar.b(obj);
            return;
        }
        if (this.e == null) {
            Class cls;
            if (obj == null) {
                cls = this.a.f;
            } else {
                cls = obj.getClass();
            }
            this.e = new j(oVar.a.a(cls), cls);
        }
        j jVar = this.e;
        if (obj != null) {
            Class cls2 = obj.getClass();
            if (cls2 == jVar.b) {
                jVar.a.a(oVar, obj, this.a.a, this.a.g);
            } else {
                oVar.a.a(cls2).a(oVar, obj, this.a.a, this.a.g);
            }
        } else if ((this.c & z.WriteNullNumberAsZero.x) != 0 && Number.class.isAssignableFrom(jVar.b)) {
            oVar.b.write(48);
        } else if ((this.c & z.WriteNullBooleanAsFalse.x) != 0 && Boolean.class == jVar.b) {
            oVar.b.write("false");
        } else if ((this.c & z.WriteNullListAsEmpty.x) == 0 || !Collection.class.isAssignableFrom(jVar.b)) {
            jVar.a.a(oVar, null, this.a.a, jVar.b);
        } else {
            oVar.b.write("[]");
        }
    }
}
