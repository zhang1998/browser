package com.ucpro.a.d;

import com.uc.webview.browser.interfaces.ICoreStat.CustomStat;
import com.uc.webview.browser.interfaces.ICoreStat.CustomStat.WALogType;
import com.uc.webview.browser.interfaces.ICoreStat.WaData;
import com.ucpro.a.g;
import java.util.HashMap;

/* compiled from: ProGuard */
public final class b extends CustomStat {
    public static b a() {
        return a.a;
    }

    public final void stat(String str) {
    }

    public final void uploadCoreVideoStatByWA(WALogType wALogType, String str, HashMap<String, String> hashMap) {
    }

    public final void WaStat(WaData waData) {
        if (waData != null) {
            e eVar = g.a().h;
            eVar.a.a(waData.eventCategory, waData.eventAction, waData.values);
        }
    }
}
