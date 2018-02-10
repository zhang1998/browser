package com.ucpro.feature.video.cache.c;

import android.text.TextUtils;
import com.uc.a.b.e;
import com.uc.a.d.j;
import com.uc.a.d.l;
import com.ucpro.business.d.c;
import com.ucpro.business.d.d;
import com.ucpro.c.b;
import com.ucweb.common.util.h.m;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
public final class a implements j {
    private static ArrayList<String> a;
    private static boolean b = false;

    static {
        ArrayList arrayList = new ArrayList();
        a = arrayList;
        arrayList.add(".sohu.com");
        a.add(".letv.com");
        a.add(".qq.com");
        a.add(".hunantv.com");
        a.add(".mgtv.com");
        a.add(".iqiyi.com");
        a.add(".zzd.sm.cn");
        a.add("uczzd.net");
        a.add("baike.shangyekj.com");
        a.add("uczzd.com.cn");
        a.add("mydisk.uc.cn");
        a.add("uczzd.com");
        a.add(".le.com");
        a.add(".uczzd.cn");
        a.add(".hongshiyun.com");
    }

    public final void a(String str, e eVar) {
        if (!TextUtils.isEmpty(str) && "video_download_black_list".equals(str)) {
            byte[] b = com.ucpro.business.e.f.a.b(eVar);
            if (1 == eVar.a) {
                m.a(0, new b(this, str, b));
            }
            a(b);
            b.b();
        }
    }

    private static void a(byte[] bArr) {
        if (bArr != null) {
            d dVar = new d();
            if (dVar.a(bArr)) {
                int size = dVar.a.size();
                for (int i = 0; i < size; i++) {
                    Object c = ((c) dVar.a.get(i)).c();
                    if (!TextUtils.isEmpty(c)) {
                        String replace = c.replace("*", "");
                        if (!a.contains(replace)) {
                            a.add(replace);
                        }
                    }
                }
            }
        }
    }

    public static boolean a(String str) {
        if (!b) {
            a(l.a("video_download_black_list"));
            b.b();
            b = true;
        }
        b.b();
        if (a == null || TextUtils.isEmpty(str)) {
            return false;
        }
        Iterator it = a.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            if (str.contains(str2)) {
                new StringBuilder("host = ").append(str2).append(", url = ").append(str);
                return true;
            }
        }
        return false;
    }
}
