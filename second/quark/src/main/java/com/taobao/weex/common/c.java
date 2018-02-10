package com.taobao.weex.common;

import com.taobao.weex.bridge.WXJSObject;
import com.taobao.weex.bridge.WXParams;

/* compiled from: ProGuard */
public interface c {
    int callAddElement(String str, String str2, String str3, String str4, String str5);

    int callNative(String str, String str2, String str3);

    void callNativeComponent(String str, String str2, String str3, byte[] bArr, byte[] bArr2);

    Object callNativeModule(String str, String str2, String str3, byte[] bArr, byte[] bArr2);

    int execJS(String str, String str2, String str3, WXJSObject[] wXJSObjectArr);

    int execJSService(String str);

    int initFramework(String str, WXParams wXParams);

    void setTimeoutNative(String str, String str2);

    void takeHeapSnapshot(String str);
}
