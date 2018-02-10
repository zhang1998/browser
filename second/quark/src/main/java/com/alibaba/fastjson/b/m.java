package com.alibaba.fastjson.b;

import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.c.a;
import com.alibaba.fastjson.c.e;
import com.alibaba.fastjson.d;
import com.alibaba.fastjson.h;
import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: ProGuard */
public final class m implements u {
    private static final char[] d = new char[]{'t', 'r', 'u', 'e'};
    private static final char[] e = new char[]{'f', 'a', 'l', 's', 'e'};
    public final k[] a;
    protected int b;
    protected String c;
    private final k[] f;

    public m(Class<?> cls, h hVar) {
        this(cls, cls.getModifiers(), hVar);
    }

    private m(Class<?> cls, int i, h hVar) {
        String[] orders;
        this.b = 0;
        JSONType jSONType = (JSONType) cls.getAnnotation(JSONType.class);
        if (jSONType != null) {
            this.b = z.a(jSONType.serialzeFeatures());
            this.c = jSONType.typeName();
            if (this.c.length() == 0) {
                this.c = null;
            }
        }
        List<a> a = e.a(cls, i, jSONType, false, hVar);
        List arrayList = new ArrayList();
        for (a kVar : a) {
            arrayList.add(new k(kVar));
        }
        this.f = (k[]) arrayList.toArray(new k[arrayList.size()]);
        if (jSONType != null) {
            orders = jSONType.orders();
        } else {
            orders = null;
        }
        if (orders == null || orders.length == 0) {
            Object obj = new k[this.f.length];
            System.arraycopy(this.f, 0, obj, 0, this.f.length);
            Arrays.sort(obj);
            if (Arrays.equals(obj, this.f)) {
                this.a = this.f;
                return;
            } else {
                this.a = obj;
                return;
            }
        }
        List<a> a2 = e.a(cls, i, jSONType, true, hVar);
        List arrayList2 = new ArrayList();
        for (a kVar2 : a2) {
            arrayList2.add(new k(kVar2));
        }
        this.a = (k[]) arrayList2.toArray(new k[arrayList2.size()]);
    }

    public final void a(o oVar, Object obj, Object obj2, Type type) throws IOException {
        aa aaVar = oVar.b;
        if (obj == null) {
            aaVar.write("null");
        } else if ((oVar.j == null || (oVar.j.d & z.DisableCircularReferenceDetect.x) == 0) && oVar.i != null && oVar.i.containsKey(obj)) {
            oVar.a(obj);
        } else {
            k[] kVarArr;
            if ((aaVar.c & z.SortField.x) != 0) {
                kVarArr = this.a;
            } else {
                kVarArr = this.f;
            }
            x xVar = oVar.j;
            if ((aaVar.c & z.DisableCircularReferenceDetect.x) == 0) {
                oVar.j = new x(xVar, obj, obj2, this.b);
                if (oVar.i == null) {
                    oVar.i = new IdentityHashMap();
                }
                oVar.i.put(obj, oVar.j);
            }
            Object obj3 = ((this.b & z.BeanToArray.x) == 0 && (aaVar.c & z.BeanToArray.x) == 0) ? null : 1;
            char c = obj3 != null ? '[' : '{';
            char c2 = obj3 != null ? ']' : '}';
            String str;
            try {
                String str2;
                Iterator it;
                int i = aaVar.b + 1;
                if (i > aaVar.a.length) {
                    if (aaVar.d == null) {
                        aaVar.a(i);
                    } else {
                        aaVar.flush();
                        i = 1;
                    }
                }
                aaVar.a[aaVar.b] = c;
                aaVar.b = i;
                if (kVarArr.length > 0 && (aaVar.c & z.PrettyFormat.x) != 0) {
                    oVar.b();
                    oVar.d();
                }
                Object obj4 = null;
                Object obj5 = ((this.b & z.WriteClassName.x) == 0 && ((aaVar.c & z.WriteClassName.x) == 0 || (type == null && (aaVar.c & z.NotWriteRootClassName.x) != 0 && oVar.j.a == null))) ? null : 1;
                if (!(obj5 == null || obj.getClass() == type)) {
                    aaVar.a(oVar.a.b, false);
                    str2 = this.c;
                    if (str2 == null) {
                        str2 = obj.getClass().getName();
                    }
                    oVar.a(str2);
                    obj4 = 1;
                }
                char c3 = obj4 != null ? ',' : '\u0000';
                if (oVar.c != null) {
                    it = oVar.c.iterator();
                    while (it.hasNext()) {
                        it.next();
                        d.a.set(oVar);
                        d.b.set(Character.valueOf(c3));
                        d.a.set(null);
                        c3 = ((Character) d.b.get()).charValue();
                    }
                }
                Object obj6 = c3 == ',' ? 1 : null;
                Object obj7 = ((aaVar.c & z.QuoteFieldNames.x) == 0 || (aaVar.c & z.UseSingleQuotes.x) != 0) ? null : 1;
                Object obj8 = (aaVar.c & z.UseSingleQuotes.x) != 0 ? 1 : null;
                Object obj9;
                if ((aaVar.c & z.NotWriteDefaultValue.x) != 0) {
                    obj9 = 1;
                } else {
                    obj9 = null;
                }
                List<v> list = oVar.e;
                List<s> list2 = oVar.g;
                List<ac> list3 = oVar.f;
                List<w> list4 = oVar.h;
                int i2 = 0;
                while (i2 < kVarArr.length) {
                    k kVar = kVarArr[i2];
                    a aVar = kVar.a;
                    Class cls = aVar.f;
                    String str3 = aVar.a;
                    if ((aaVar.c & z.SkipTransientField.x) == 0 || aVar.c == null || !aVar.e) {
                        if (list4 != null) {
                            for (w a : list4) {
                                if (!a.a()) {
                                    obj4 = null;
                                    break;
                                }
                            }
                        }
                        i = 1;
                        if (obj4 != null) {
                            Object obj10;
                            boolean z;
                            int i3;
                            long j;
                            Integer a2;
                            Object obj11;
                            int i4;
                            Object valueOf;
                            Integer num;
                            if (!aVar.d) {
                                obj10 = null;
                                z = false;
                                i3 = 0;
                                j = 0;
                                i = 1;
                                a2 = kVar.a(obj);
                            } else if (cls == Integer.TYPE) {
                                obj10 = 1;
                                z = false;
                                i3 = aVar.c.getInt(obj);
                                j = 0;
                                obj4 = null;
                                a2 = null;
                            } else if (cls == Long.TYPE) {
                                r16 = 1;
                                z = false;
                                i3 = 0;
                                j = aVar.c.getLong(obj);
                                obj4 = null;
                                a2 = null;
                            } else if (cls == Boolean.TYPE) {
                                r16 = 1;
                                z = aVar.c.getBoolean(obj);
                                i3 = 0;
                                j = 0;
                                obj4 = null;
                                a2 = null;
                            } else {
                                obj10 = null;
                                z = false;
                                i3 = 0;
                                j = 0;
                                i = 1;
                                a2 = aVar.c.get(obj);
                            }
                            if (list != null) {
                                Integer valueOf2;
                                Object obj12;
                                if (obj10 != null) {
                                    if (cls == Integer.TYPE) {
                                        valueOf2 = Integer.valueOf(i3);
                                        obj11 = 1;
                                    } else if (cls == Long.TYPE) {
                                        Number valueOf3 = Long.valueOf(j);
                                        i4 = 1;
                                    } else if (cls == Boolean.TYPE) {
                                        valueOf = Boolean.valueOf(z);
                                        i4 = 1;
                                    }
                                    for (v a3 : list) {
                                        if (!a3.a()) {
                                            obj5 = obj11;
                                            obj11 = null;
                                            num = valueOf2;
                                            break;
                                        }
                                    }
                                    num = valueOf2;
                                    obj12 = obj11;
                                    i4 = 1;
                                    obj5 = obj12;
                                }
                                valueOf2 = a2;
                                obj11 = obj4;
                                while (r12.hasNext()) {
                                    if (a3.a()) {
                                        obj5 = obj11;
                                        obj11 = null;
                                        num = valueOf2;
                                        break;
                                    }
                                }
                                num = valueOf2;
                                obj12 = obj11;
                                i4 = 1;
                                obj5 = obj12;
                            } else {
                                obj5 = obj4;
                                num = a2;
                                i4 = 1;
                            }
                            if (obj11 != null) {
                                String str4;
                                Integer num2;
                                if (list2 != null) {
                                    if (obj10 != null && r5 == null) {
                                        if (cls == Integer.TYPE) {
                                            obj5 = 1;
                                            a2 = Integer.valueOf(i3);
                                        } else if (cls == Long.TYPE) {
                                            obj5 = 1;
                                            Number valueOf4 = Long.valueOf(j);
                                        } else if (cls == Boolean.TYPE) {
                                            obj5 = 1;
                                            obj11 = Boolean.valueOf(z);
                                        }
                                        str2 = str3;
                                        for (s a4 : list2) {
                                            str2 = a4.a();
                                        }
                                        str4 = str2;
                                        num = a2;
                                    }
                                    a2 = num;
                                    str2 = str3;
                                    while (r11.hasNext()) {
                                        str2 = a4.a();
                                    }
                                    str4 = str2;
                                    num = a2;
                                } else {
                                    str4 = str3;
                                }
                                if (list3 != null) {
                                    if (obj10 != null && obj5 == null) {
                                        if (cls == Integer.TYPE) {
                                            num = Integer.valueOf(i3);
                                            obj11 = 1;
                                            num2 = num;
                                        } else if (cls == Long.TYPE) {
                                            num = Long.valueOf(j);
                                            i4 = 1;
                                            num2 = num;
                                        } else if (cls == Boolean.TYPE) {
                                            num = Boolean.valueOf(z);
                                            i4 = 1;
                                            num2 = num;
                                        }
                                        for (ac a5 : list3) {
                                            num = a5.a();
                                        }
                                        valueOf = obj11;
                                        a2 = num2;
                                        num2 = num;
                                    }
                                    obj11 = obj5;
                                    num2 = num;
                                    while (r11.hasNext()) {
                                        num = a5.a();
                                    }
                                    valueOf = obj11;
                                    a2 = num2;
                                    num2 = num;
                                } else {
                                    a2 = num;
                                    valueOf = obj5;
                                    num2 = num;
                                }
                                if (!(valueOf != null && num2 == null && obj3 == null && !kVar.b && (aaVar.c & z.WriteMapNullValue.x) == 0) && (valueOf == null || num2 == null || r19 == null || !(((cls == Byte.TYPE || cls == Short.TYPE || cls == Integer.TYPE || cls == Long.TYPE || cls == Float.TYPE || cls == Double.TYPE) && (num2 instanceof Number) && num2.byteValue() == (byte) 0) || (cls == Boolean.TYPE && (num2 instanceof Boolean) && !((Boolean) num2).booleanValue())))) {
                                    if (obj6 != null) {
                                        i = aaVar.b + 1;
                                        if (i > aaVar.a.length) {
                                            if (aaVar.d == null) {
                                                aaVar.a(i);
                                            } else {
                                                aaVar.flush();
                                                i = 1;
                                            }
                                        }
                                        aaVar.a[aaVar.b] = ',';
                                        aaVar.b = i;
                                        if ((aaVar.c & z.PrettyFormat.x) != 0) {
                                            oVar.d();
                                        }
                                    }
                                    if (str4 != str3) {
                                        if (obj3 == null) {
                                            aaVar.a(str4, true);
                                        }
                                        oVar.b(num2);
                                    } else if (a2 != num2) {
                                        if (obj3 == null) {
                                            kVar.a(oVar);
                                        }
                                        oVar.b(num2);
                                    } else {
                                        int i5;
                                        if (obj3 == null) {
                                            if (obj7 != null) {
                                                Object obj13 = aVar.j;
                                                i = 0;
                                                i4 = obj13.length;
                                                i5 = aaVar.b + i4;
                                                if (i5 > aaVar.a.length) {
                                                    if (aaVar.d == null) {
                                                        aaVar.a(i5);
                                                    } else {
                                                        while (true) {
                                                            int length = aaVar.a.length - aaVar.b;
                                                            System.arraycopy(obj13, i, aaVar.a, aaVar.b, length);
                                                            aaVar.b = aaVar.a.length;
                                                            aaVar.flush();
                                                            i5 = i4 - length;
                                                            i += length;
                                                            if (i5 <= aaVar.a.length) {
                                                                break;
                                                            }
                                                            i4 = i5;
                                                        }
                                                        i4 = i5;
                                                    }
                                                }
                                                System.arraycopy(obj13, i, aaVar.a, aaVar.b, i4);
                                                aaVar.b = i5;
                                            } else {
                                                kVar.a(oVar);
                                            }
                                        }
                                        if (obj10 == null || valueOf != null) {
                                            if (obj3 != null) {
                                                kVar.a(oVar, num2);
                                            } else if (cls == String.class) {
                                                if (num2 != null) {
                                                    str = (String) num2;
                                                    if (obj8 != null) {
                                                        aaVar.b(str);
                                                    } else {
                                                        aaVar.a(str, '\u0000', true);
                                                    }
                                                } else if ((aaVar.c & z.WriteNullStringAsEmpty.x) == 0 && (kVar.c & z.WriteNullStringAsEmpty.x) == 0) {
                                                    aaVar.write("null");
                                                } else {
                                                    aaVar.a("");
                                                }
                                            } else if (!aVar.k) {
                                                kVar.a(oVar, num2);
                                            } else if (num2 == null) {
                                                aaVar.write("null");
                                            } else if ((aaVar.c & z.WriteEnumUsingToString.x) != 0) {
                                                str = ((Enum) num2).toString();
                                                if (((aaVar.c & z.UseSingleQuotes.x) != 0 ? 1 : null) != null) {
                                                    aaVar.b(str);
                                                } else {
                                                    aaVar.a(str, '\u0000', false);
                                                }
                                            } else {
                                                aaVar.b(((Enum) num2).ordinal());
                                            }
                                        } else if (cls == Integer.TYPE) {
                                            if (i3 == SectionHeader.SHT_LOUSER) {
                                                aaVar.write("-2147483648");
                                            } else {
                                                int i6 = 0;
                                                while ((i3 < 0 ? -i3 : i3) > aa.e[i6]) {
                                                    i6++;
                                                }
                                                i = i6 + 1;
                                                if (i3 < 0) {
                                                    i6 = i + 1;
                                                } else {
                                                    i6 = i;
                                                }
                                                obj4 = null;
                                                i5 = aaVar.b + i6;
                                                if (i5 > aaVar.a.length) {
                                                    if (aaVar.d == null) {
                                                        aaVar.a(i5);
                                                    } else {
                                                        char[] cArr = new char[i6];
                                                        aa.a((long) i3, i6, cArr);
                                                        aaVar.write(cArr, 0, cArr.length);
                                                        obj4 = 1;
                                                    }
                                                }
                                                if (obj4 == null) {
                                                    aa.a((long) i3, i5, aaVar.a);
                                                    aaVar.b = i5;
                                                }
                                            }
                                        } else if (cls == Long.TYPE) {
                                            oVar.b.a(j);
                                        } else if (cls == Boolean.TYPE) {
                                            if (z) {
                                                oVar.b.write(d, 0, d.length);
                                            } else {
                                                oVar.b.write(e, 0, e.length);
                                            }
                                        }
                                    }
                                    obj4 = 1;
                                    i2++;
                                    obj6 = obj4;
                                }
                            }
                        }
                    }
                    obj4 = obj6;
                    i2++;
                    obj6 = obj4;
                }
                if (oVar.d != null) {
                    c3 = obj6 != null ? ',' : '\u0000';
                    it = oVar.d.iterator();
                    while (it.hasNext()) {
                        it.next();
                        a.a.set(oVar);
                        a.b.set(Character.valueOf(c3));
                        a.a.set(null);
                        c3 = ((Character) a.b.get()).charValue();
                    }
                }
                if (kVarArr.length > 0 && (aaVar.c & z.PrettyFormat.x) != 0) {
                    oVar.c();
                    oVar.d();
                }
                i = aaVar.b + 1;
                if (i > aaVar.a.length) {
                    if (aaVar.d == null) {
                        aaVar.a(i);
                    } else {
                        aaVar.flush();
                        i = 1;
                    }
                }
                aaVar.a[aaVar.b] = c2;
                aaVar.b = i;
                oVar.j = xVar;
            } catch (Throwable e) {
                str = "write javaBean error";
                if (obj2 != null) {
                    str = str + ", fieldName : " + obj2;
                }
                throw new d(str, e);
            } catch (Throwable th) {
                oVar.j = xVar;
            }
        }
    }
}
