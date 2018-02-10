package com.uc.webview.browser.interfaces;

import android.content.Context;
import com.uc.webview.export.annotations.Interface;

@Interface
/* compiled from: ProGuard */
public interface IPermissionManagerInterface {

    @Interface
    /* compiled from: ProGuard */
    public interface IPermissionCallBack {
        void onRequestPermissionsResult(String[] strArr, boolean[] zArr);
    }

    boolean onCheckSelfPermission(Context context, String str);

    void onPermissionsRequest(Context context, String[] strArr, IPermissionCallBack iPermissionCallBack);
}
