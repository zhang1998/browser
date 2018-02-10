package com.uc.webview.browser.interfaces;

import android.os.Bundle;
import com.uc.webview.export.annotations.Interface;

@Interface
/* compiled from: ProGuard */
public interface IStatisticListener {
    public static final String ADV_FILTER_KEY = "core_2_shell_ad_filter_result";
    public static final String AJAX_PV_KEY = "Ajax_Pv_Key";
    public static final String BACKFORWARD_INFO_KEY = "backforward_info_statistics";

    void notifyStatics(String str, Bundle bundle);

    void notifyStatics(String str, String str2);

    void notifyStatics(String str, Object[] objArr);
}
