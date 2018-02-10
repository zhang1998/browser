package com.ucpro.feature.setting.b.f;

import com.ucpro.a.g;
import com.ucpro.c.a;
import com.ucpro.feature.setting.b.b.a.h;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: ProGuard */
public final class j implements h {
    public final /* bridge */ /* synthetic */ void a(Object obj) {
    }

    public final /* synthetic */ Object a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("VERSION NAME: 2.4.1.985\nSUB VERSION: release\nVERSION CODE: 50").append("\nBUILD SEQ: 180123054500\nBTYPE: ").append(a.d()).append("\nBMODE: ").append(a.e()).append("\nBID: ").append(a.a()).append("\nCH: ").append(a.b()).append("\nCID: ").append(a.c()).append("\nSID: ").append(com.ucpro.model.a.a.a.a("setting_sid", "")).append("\nBUILD REQUEST_TYPE: release\nFLAVOR: standard\nSIGN TYPE: ").append(com.ucpro.b.d.a.a() ? "release" : "debug").append("\n");
        if (g.a().b != null) {
            Map map = g.a().b.a;
            if (!(map == null || map.isEmpty())) {
                stringBuilder.append("WebCore Information\n");
                for (Entry entry : map.entrySet()) {
                    String str = (String) entry.getKey();
                    String str2 = (String) entry.getValue();
                    if (!(str == null || str2 == null)) {
                        if (str2.equals("否")) {
                            str2 = "no";
                        } else if (str2.equals("是")) {
                            str2 = "yes";
                        }
                        stringBuilder.append("      ").append(str2).append("\n");
                    }
                }
            }
        }
        return stringBuilder.toString();
    }
}
