package com.ucpro.feature.downloadpage.a;

import android.text.TextUtils;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import com.quark.browser.R;
import com.uc.quark.a.c;
import com.ucpro.ui.c.a;
import java.net.URLDecoder;

/* compiled from: ProGuard */
final class b implements ValueCallback<String[]> {
    final /* synthetic */ String a;
    final /* synthetic */ l b;

    b(l lVar, String str) {
        this.b = lVar;
        this.a = str;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        String[] strArr = (String[]) obj;
        if (strArr != null) {
            CharSequence guessFileName = URLUtil.guessFileName(this.a, TextUtils.isEmpty(strArr[0]) ? "" : URLDecoder.decode(strArr[0]), strArr[1]);
            if (!TextUtils.isEmpty(strArr[2])) {
                this.b.A = Long.valueOf(strArr[2]).longValue();
            }
            String str = (TextUtils.isEmpty(strArr[2]) ? a.d((int) R.string.download_no_kown_size) : c.a(Long.valueOf(strArr[2]).longValue())) + "/" + (com.ucweb.common.util.n.a.b(strArr[3]) ? c.a(Long.valueOf(strArr[3]).longValue()) : "");
            this.b.v.setFloatingLabelText(String.format(a.d((int) R.string.download_setting_file_desc_size_format), new Object[]{str}));
            this.b.v.setText(guessFileName);
        }
    }
}
