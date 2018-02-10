package com.uc.webview.browser.interfaces;

import com.uc.webview.export.annotations.Interface;
import java.util.Vector;

@Interface
/* compiled from: ProGuard */
public interface IUserAgent {
    public static final String MOBILE_UA_CHROME = "mobileuachrome";
    public static final String MOBILE_UA_DEFAULT = "mobileuadefault";
    public static final String MOBILE_UA_IPHONE = "mobileuaiphone";
    public static final String MOBILE_UA_NONE = "mobileuanone";
    public static final int UATNone = 0;
    public static final int UATOtherBrowserA = 2;
    public static final int UATOtherBrowserB = 3;
    public static final int UATOtherBrowserC = 4;
    public static final int UATStandard = 1;

    @Deprecated
    String getHUCStringValue(String str);

    String getUserAgent(String str);

    void setHUCList(String str, String str2);

    void setUserAgent(String str, String str2);

    void setUserAgentControlList(String str, Vector<String> vector);

    void setUserAgentHost(String str, String str2);
}
