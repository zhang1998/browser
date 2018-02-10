package com.uc.weex.g;

import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.taobao.weex.ac;
import com.taobao.weex.ad;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.common.o;
import com.taobao.weex.ui.component.ab;
import com.uc.weex.component.c.b;
import java.util.List;
import java.util.Map;

/* compiled from: ProGuard */
public class e extends o {
    private InputMethodManager a;

    @JSMethod
    public void addEventListener(String str, String str2, Map<String, Object> map) {
        this.b.c(str, str2);
    }

    @JSMethod
    public void removeEventListener(String str, String str2) {
        ac acVar = this.b;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            List list = (List) acVar.z.get(str);
            if (list != null) {
                list.remove(str2);
            }
        }
    }

    @JSMethod
    public void dismissKeyboard() {
        if (this.a == null) {
            this.a = (InputMethodManager) this.b.b().getSystemService("input_method");
        }
        View realView = this.b.g.getRealView();
        if (realView != null) {
            this.a.hideSoftInputFromWindow(realView.getWindowToken(), 0);
        }
    }

    @JSMethod(uiThread = false)
    public void scrollToBottom(String str, String str2) {
        ab a = ad.a().c.a(this.b.e, str);
        if (a instanceof b) {
            ad.a().a.a(this.b.e, new d(this, (b) a, str2), false);
        }
    }

    @JSMethod
    @Deprecated
    public static void emit(String str, String str2) {
        com.uc.weex.o.a.a(str, str2);
    }
}
