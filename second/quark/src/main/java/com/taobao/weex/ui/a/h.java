package com.taobao.weex.ui.a;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.alibaba.fastjson.a;
import com.alibaba.fastjson.e;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.c;
import com.taobao.weex.p;
import com.taobao.weex.utils.WXLogUtils;
import com.uc.apollo.android.GuideDialog;
import java.net.URLDecoder;

/* compiled from: ProGuard */
public class h extends p {
    private Toast a;
    private Dialog d;

    @JSMethod(uiThread = true)
    public void toast(String str) {
        CharSequence h;
        int intValue;
        Throwable th;
        Object obj;
        String str2 = "";
        if (!TextUtils.isEmpty(str)) {
            try {
                e b = a.b(URLDecoder.decode(str, "utf-8"));
                h = b.h(GuideDialog.MESSAGE);
                try {
                    intValue = b.f("duration").intValue();
                } catch (Throwable e) {
                    Throwable th2 = e;
                    CharSequence charSequence = h;
                    th = th2;
                    WXLogUtils.e("[WXModalUIModule] alert param parse error ", th);
                    obj = str2;
                    intValue = 0;
                    if (TextUtils.isEmpty(h)) {
                        WXLogUtils.e("[WXModalUIModule] toast param parse is null ");
                    }
                    if (intValue <= 3) {
                        intValue = 0;
                    } else {
                        intValue = 1;
                    }
                    if (this.a != null) {
                        this.a.setDuration(intValue);
                        this.a.setText(h);
                    } else {
                        this.a = Toast.makeText(this.b.b(), h, intValue);
                    }
                    this.a.setGravity(17, 0, 0);
                    this.a.show();
                    return;
                }
            } catch (Exception e2) {
                th = e2;
                WXLogUtils.e("[WXModalUIModule] alert param parse error ", th);
                obj = str2;
                intValue = 0;
                if (TextUtils.isEmpty(h)) {
                    WXLogUtils.e("[WXModalUIModule] toast param parse is null ");
                }
                if (intValue <= 3) {
                    intValue = 1;
                } else {
                    intValue = 0;
                }
                if (this.a != null) {
                    this.a = Toast.makeText(this.b.b(), h, intValue);
                } else {
                    this.a.setDuration(intValue);
                    this.a.setText(h);
                }
                this.a.setGravity(17, 0, 0);
                this.a.show();
                return;
            }
            if (TextUtils.isEmpty(h)) {
                WXLogUtils.e("[WXModalUIModule] toast param parse is null ");
            }
            if (intValue <= 3) {
                intValue = 1;
            } else {
                intValue = 0;
            }
            if (this.a != null) {
                this.a = Toast.makeText(this.b.b(), h, intValue);
            } else {
                this.a.setDuration(intValue);
                this.a.setText(h);
            }
            this.a.setGravity(17, 0, 0);
            this.a.show();
            return;
        }
        obj = str2;
        intValue = 0;
        if (TextUtils.isEmpty(h)) {
            if (intValue <= 3) {
                intValue = 0;
            } else {
                intValue = 1;
            }
            if (this.a != null) {
                this.a.setDuration(intValue);
                this.a.setText(h);
            } else {
                this.a = Toast.makeText(this.b.b(), h, intValue);
            }
            this.a.setGravity(17, 0, 0);
            this.a.show();
            return;
        }
        WXLogUtils.e("[WXModalUIModule] toast param parse is null ");
    }

    @JSMethod(uiThread = true)
    public void alert(String str, c cVar) {
        if (this.b.b() instanceof Activity) {
            CharSequence charSequence = "";
            CharSequence charSequence2 = "OK";
            if (!TextUtils.isEmpty(str)) {
                try {
                    e b = a.b(URLDecoder.decode(str, "utf-8"));
                    charSequence = b.h(GuideDialog.MESSAGE);
                    charSequence2 = b.h("okTitle");
                } catch (Throwable e) {
                    WXLogUtils.e("[WXModalUIModule] alert param parse error ", e);
                }
            }
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = "";
            }
            Builder builder = new Builder(this.b.b());
            builder.setMessage(charSequence);
            if (TextUtils.isEmpty(charSequence2)) {
                charSequence2 = "OK";
            }
            builder.setPositiveButton(charSequence2, new b(this, cVar, charSequence2));
            Dialog create = builder.create();
            create.setCanceledOnTouchOutside(false);
            create.show();
            a(create);
            return;
        }
        WXLogUtils.e("[WXModalUIModule] when call alert mWXSDKInstance.getContext() must instanceof Activity");
    }

    @JSMethod(uiThread = true)
    public void confirm(String str, c cVar) {
        if (this.b.b() instanceof Activity) {
            CharSequence charSequence = "";
            CharSequence charSequence2 = "OK";
            CharSequence charSequence3 = "Cancel";
            if (!TextUtils.isEmpty(str)) {
                try {
                    e b = a.b(URLDecoder.decode(str, "utf-8"));
                    charSequence = b.h(GuideDialog.MESSAGE);
                    charSequence2 = b.h("okTitle");
                    charSequence3 = b.h("cancelTitle");
                } catch (Throwable e) {
                    WXLogUtils.e("[WXModalUIModule] confirm param parse error ", e);
                }
            }
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = "";
            }
            Builder builder = new Builder(this.b.b());
            builder.setMessage(charSequence);
            if (TextUtils.isEmpty(charSequence2)) {
                charSequence2 = "OK";
            }
            if (TextUtils.isEmpty(charSequence3)) {
                charSequence3 = "Cancel";
            }
            builder.setPositiveButton(charSequence2, new c(this, cVar, charSequence2));
            builder.setNegativeButton(charSequence3, new d(this, cVar, charSequence3));
            Dialog create = builder.create();
            create.setCanceledOnTouchOutside(false);
            create.show();
            a(create);
            return;
        }
        WXLogUtils.e("[WXModalUIModule] when call confirm mWXSDKInstance.getContext() must instanceof Activity");
    }

    @JSMethod(uiThread = true)
    public void prompt(String str, c cVar) {
        if (this.b.b() instanceof Activity) {
            CharSequence charSequence = "";
            CharSequence charSequence2 = "";
            CharSequence charSequence3 = "OK";
            CharSequence charSequence4 = "Cancel";
            if (!TextUtils.isEmpty(str)) {
                try {
                    e b = a.b(URLDecoder.decode(str, "utf-8"));
                    charSequence = b.h(GuideDialog.MESSAGE);
                    charSequence3 = b.h("okTitle");
                    charSequence4 = b.h("cancelTitle");
                    charSequence2 = b.h("default");
                } catch (Throwable e) {
                    WXLogUtils.e("[WXModalUIModule] confirm param parse error ", e);
                }
            }
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = "";
            }
            Builder builder = new Builder(this.b.b());
            builder.setMessage(charSequence);
            View editText = new EditText(this.b.b());
            editText.setText(charSequence2);
            builder.setView(editText);
            if (TextUtils.isEmpty(charSequence3)) {
                charSequence3 = "OK";
            }
            if (TextUtils.isEmpty(charSequence4)) {
                charSequence4 = "Cancel";
            }
            builder.setPositiveButton(charSequence3, new f(this, cVar, charSequence3, editText)).setNegativeButton(charSequence4, new e(this, cVar, charSequence4, editText));
            Dialog create = builder.create();
            create.setCanceledOnTouchOutside(false);
            create.show();
            a(create);
            return;
        }
        WXLogUtils.e("when call prompt mWXSDKInstance.getContext() must instanceof Activity");
    }

    private void a(Dialog dialog) {
        this.d = dialog;
        dialog.setOnDismissListener(new g(this));
    }

    public final void a() {
        if (this.d != null && this.d.isShowing()) {
            WXLogUtils.w("Dismiss the active dialog");
            this.d.dismiss();
        }
    }
}
