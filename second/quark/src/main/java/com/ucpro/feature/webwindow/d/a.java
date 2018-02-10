package com.ucpro.feature.webwindow.d;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.quark.browser.R;
import com.uc.webview.export.WebView;
import com.ucpro.feature.webwindow.e.r;
import com.ucpro.ui.b.e;
import com.ucweb.common.util.c;
import java.net.URLDecoder;

/* compiled from: ProGuard */
public final class a {
    private Context a;

    public a(Context context) {
        this.a = context;
    }

    public final boolean a(String str) {
        boolean z;
        if (TextUtils.isEmpty(str)) {
            z = false;
        } else {
            z = str.startsWith(WebView.SCHEME_TEL);
        }
        if (!z) {
            z = !TextUtils.isEmpty(str) ? str.startsWith("sms:") || str.startsWith("smsto:") : false;
            if (z) {
                b(str);
                return true;
            }
            if (TextUtils.isEmpty(str)) {
                z = false;
            } else {
                z = str.startsWith("about:blank");
            }
            if (z) {
                return true;
            }
            if (TextUtils.isEmpty(str)) {
                z = false;
            } else {
                z = str.startsWith(WebView.SCHEME_MAILTO);
            }
            if (z) {
                return true;
            }
            return false;
        } else if (TextUtils.isEmpty(str)) {
            return true;
        } else {
            try {
                this.a.startActivity(new Intent("android.intent.action.DIAL", Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(Uri.encode(str.substring(4))).toString())));
                return true;
            } catch (ActivityNotFoundException e) {
                e.a().a(com.ucpro.ui.c.a.d((int) R.string.device_not_support_dial_number), 1);
                r.a(e.getMessage());
                return true;
            } catch (Exception e2) {
                e.a().a(com.ucpro.ui.c.a.d((int) R.string.device_not_support_dial_number), 1);
                r.a(e2.getMessage());
                return true;
            }
        }
    }

    private void b(String str) {
        String str2 = "";
        String str3 = "";
        try {
            Uri parse;
            String[] split = URLDecoder.decode(str.substring(str.indexOf(":") + 1), "UTF-8").split("\\?");
            int i = 0;
            while (i < split.length) {
                if (i == 0) {
                    str3 = split[i];
                } else if (1 == i && split[i].startsWith("body=")) {
                    str2 = split[i].substring(5);
                }
                i++;
            }
            Log.e("SchemeHandler", "before replaceAll strNums=" + str3);
            str3 = str3.replaceAll(",", ";");
            Log.e("SchemeHandler", "strMsg=" + str2);
            Log.e("SchemeHandler", "strNums=" + str3);
            boolean isEmpty = TextUtils.isEmpty(str3);
            new StringBuilder("Enter SendSms::\nmtNumEmptyFlag:").append(isEmpty).append("\nmtNums:").append(str3).append("\nmessage:").append(str2);
            if (isEmpty) {
                parse = Uri.parse("smsto:");
            } else {
                parse = Uri.parse("smsto:" + str3);
            }
            Intent intent = new Intent("android.intent.action.SENDTO", parse);
            str3 = "sms_body";
            if (str2 == null) {
                str2 = "";
            }
            intent.putExtra(str3, str2);
            try {
                this.a.startActivity(intent);
            } catch (Exception e) {
                e.a().a(com.ucpro.ui.c.a.d((int) R.string.device_not_support_send_sms), 0);
            }
        } catch (Throwable th) {
            c.a("fail", th);
        }
    }
}
