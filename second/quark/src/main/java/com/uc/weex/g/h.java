package com.uc.weex.g;

import android.text.TextUtils;
import android.widget.Toast;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.utils.WXLogUtils;
import com.uc.apollo.android.GuideDialog;
import java.net.URLDecoder;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class h extends com.taobao.weex.ui.a.h {
    @JSMethod
    public void toast(String str) {
        CharSequence optString;
        int optInt;
        Throwable th;
        Object obj;
        Toast makeText;
        int i = 0;
        String str2 = "";
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(URLDecoder.decode(str, "utf-8"));
                optString = jSONObject.optString(GuideDialog.MESSAGE);
                try {
                    optInt = jSONObject.optInt("duration");
                } catch (Throwable e) {
                    Throwable th2 = e;
                    CharSequence charSequence = optString;
                    th = th2;
                    WXLogUtils.e("[ModalModule] alert param parse error ", th);
                    obj = str2;
                    optInt = 0;
                    if (TextUtils.isEmpty(optString)) {
                        if (optInt > 3) {
                            i = 1;
                        }
                        makeText = Toast.makeText(this.b.b(), optString, i);
                        makeText.setDuration(i);
                        makeText.setText(optString);
                        makeText.show();
                        return;
                    }
                    WXLogUtils.e("[ModalModule] toast param parse is null ");
                }
            } catch (Exception e2) {
                th = e2;
                WXLogUtils.e("[ModalModule] alert param parse error ", th);
                obj = str2;
                optInt = 0;
                if (TextUtils.isEmpty(optString)) {
                    if (optInt > 3) {
                        i = 1;
                    }
                    makeText = Toast.makeText(this.b.b(), optString, i);
                    makeText.setDuration(i);
                    makeText.setText(optString);
                    makeText.show();
                    return;
                }
                WXLogUtils.e("[ModalModule] toast param parse is null ");
            }
            if (TextUtils.isEmpty(optString)) {
                WXLogUtils.e("[ModalModule] toast param parse is null ");
            }
            if (optInt > 3) {
                i = 1;
            }
            makeText = Toast.makeText(this.b.b(), optString, i);
            makeText.setDuration(i);
            makeText.setText(optString);
            makeText.show();
            return;
        }
        obj = str2;
        optInt = 0;
        if (TextUtils.isEmpty(optString)) {
            if (optInt > 3) {
                i = 1;
            }
            makeText = Toast.makeText(this.b.b(), optString, i);
            makeText.setDuration(i);
            makeText.setText(optString);
            makeText.show();
            return;
        }
        WXLogUtils.e("[ModalModule] toast param parse is null ");
    }
}
