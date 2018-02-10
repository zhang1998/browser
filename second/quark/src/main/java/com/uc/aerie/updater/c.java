package com.uc.aerie.updater;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.uc.aerie.updater.a.a.f;

/* compiled from: ProGuard */
final class c {
    static b a(String str, String str2) {
        if (!TextUtils.equals(ShareConstants.PATCH_DIRECTORY_NAME, str)) {
            Log.e("MergeAlgorithmFactory", String.format("algorithm:%s, version:%s not exist.", new Object[]{str, str2}));
            return null;
        } else if (TextUtils.equals("1.7.11", str2)) {
            return new f();
        } else {
            return null;
        }
    }
}
