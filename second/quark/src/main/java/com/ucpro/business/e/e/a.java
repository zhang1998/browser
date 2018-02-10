package com.ucpro.business.e.e;

import android.text.TextUtils;
import android.util.Log;
import com.uc.a.d.i;
import com.uc.encrypt.f;
import com.uc.webview.browser.interfaces.SettingKeys;
import java.util.HashMap;

/* compiled from: ProGuard */
public final class a implements i {
    private static final String[] a = new String[]{"dn", "bkg_msg_net_req_cycle", "sn", "ucdns2_control_flag", "li_close_flag", "cp_param", "server_time", "st_flag", "dns_control_flag", "ext_param", "enable_bkg_msg", "enable_bkg_process", "statistic_switch", "url_static", SettingKeys.XUASwitch, "fl_close_flag"};

    public final void a(int i, HashMap<String, String> hashMap) {
        if (i == 0) {
            for (String str : a) {
                String str2 = (String) hashMap.get(str);
                new StringBuilder("[us] received base data: ").append(str).append("=").append(str2);
                if (TextUtils.isEmpty(str2)) {
                    Log.w("us", new StringBuilder("[us] base data ").append(str).append(" is ").append(str2).toString() == null ? "null" : "empty");
                } else {
                    b.b().a.edit().putString(f.a(str), f.a(str2)).apply();
                }
            }
        }
    }
}
