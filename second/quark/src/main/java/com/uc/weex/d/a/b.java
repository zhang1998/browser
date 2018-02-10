package com.uc.weex.d.a;

import android.net.Uri;
import android.text.TextUtils;
import com.UCMobile.Apollo.Global;
import com.uc.apollo.impl.SettingsConst;
import com.uc.weex.h.h;
import com.uc.weex.h.i;
import com.uc.weex.h.j;
import com.uc.weex.h.k;

/* compiled from: ProGuard */
public final class b {
    public static k a(String str) {
        h hVar = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String str2;
        Uri parse = Uri.parse(str);
        String a = a(parse, "uc_wx_page_name");
        String a2 = a(parse, "uc_wx_tpl");
        c cVar = d.a;
        CharSequence b = a.b(a2);
        if (TextUtils.isEmpty(b) || cVar == null || !cVar.a()) {
            str2 = a2;
        } else {
            str2 = null;
        }
        if (a.a(a) && a.a(str2)) {
            return null;
        }
        TextUtils.isEmpty(b);
        String a3 = a(parse, "uc_wx_hot_reload");
        if (!(a.a(a) || a.a(str2))) {
            h iVar;
            a2 = a(parse, "uc_wx_open_type");
            String a4 = a(parse, "uc_wx_is_update");
            if (!a.a(a2)) {
                if (SettingsConst.FALSE.equals(a2)) {
                    iVar = new i(a);
                } else if (SettingsConst.TRUE.equals(a2)) {
                    iVar = new j(str2);
                }
                if (!(a.a(a4) || SettingsConst.FALSE.equals(a4) || (!SettingsConst.TRUE.equals(a4) && !Global.APOLLO_SERIES.equals(a4)))) {
                    if (iVar instanceof i) {
                        ((i) iVar).a(str2);
                    } else if (iVar instanceof j) {
                        ((j) iVar).a(a);
                    }
                    if (Global.APOLLO_SERIES.equals(a4)) {
                        iVar.a();
                    }
                }
                hVar = iVar;
            }
            iVar = null;
            if (iVar instanceof i) {
                ((i) iVar).a(str2);
            } else if (iVar instanceof j) {
                ((j) iVar).a(a);
            }
            if (Global.APOLLO_SERIES.equals(a4)) {
                iVar.a();
            }
            hVar = iVar;
        }
        if (hVar == null) {
            hVar = new i(a).a(str2).a();
        }
        hVar.a("true".equals(a3)).a("urloptions", e.a(parse));
        return hVar.b();
    }

    private static String a(Uri uri, String str) {
        try {
            return uri.getQueryParameter(str);
        } catch (Exception e) {
            return null;
        }
    }
}
