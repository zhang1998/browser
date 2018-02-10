package com.tencent.tinker.loader;

import android.content.Context;
import android.util.Log;
import com.tencent.tinker.loader.shareutil.ShareLoadPatchResult;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareResPatchInfo;
import java.io.File;

/* compiled from: ProGuard */
public class TinkerResourceLoader {
    protected static final String RESOURCE_FILE = "resources.apk";
    protected static final String RESOURCE_META_FILE = "assets/res_meta.txt";
    protected static final String RESOURCE_PATH = "res";
    private static final String TAG = "Tinker.ResourceLoader";
    private ShareResPatchInfo resPatchInfo = new ShareResPatchInfo();
    private String resPath = null;

    public String getResourcePath() {
        return this.resPath;
    }

    public boolean loadTinkerResources(Context context, boolean z, String str, ShareLoadPatchResult shareLoadPatchResult) {
        if (this.resPatchInfo == null || this.resPatchInfo.resArscMd5 == null) {
            return true;
        }
        String str2 = str + "/res/resources.apk";
        File file = new File(str2);
        long currentTimeMillis = System.currentTimeMillis();
        if (z) {
            if (SharePatchFileUtil.checkResourceArscMd5(file, this.resPatchInfo.resArscMd5)) {
                new StringBuilder("verify resource file:").append(file.getPath()).append(" md5, use time: ").append(System.currentTimeMillis() - currentTimeMillis);
            } else {
                Log.e(TAG, "Failed to load resource file, path: " + file.getPath() + ", expect md5: " + this.resPatchInfo.resArscMd5);
                shareLoadPatchResult.errorCode = -22;
                return false;
            }
        }
        try {
            TinkerResourcePatcher.monkeyPatchExistingResources(context, str2);
            new StringBuilder("monkeyPatchExistingResources resource file:").append(str2).append(", use time: ").append(System.currentTimeMillis() - currentTimeMillis);
            this.resPath = str2;
            return true;
        } catch (Throwable th) {
            Log.e(TAG, "install resources failed");
            shareLoadPatchResult.throwable = th;
            shareLoadPatchResult.errorCode = -21;
            return false;
        }
    }

    public boolean checkComplete(Context context, File file, String str, ShareLoadPatchResult shareLoadPatchResult) {
        ShareResPatchInfo.parseResPatchInfoFirstLine(str, this.resPatchInfo);
        if (this.resPatchInfo.resArscMd5 == null) {
            return true;
        }
        if (ShareResPatchInfo.checkResPatchInfo(this.resPatchInfo)) {
            File file2 = new File(file, "res");
            if (!file2.exists() || !file2.isDirectory()) {
                shareLoadPatchResult.errorCode = -19;
                return false;
            } else if (SharePatchFileUtil.isLegalFile(new File(file2, "resources.apk"))) {
                try {
                    TinkerResourcePatcher.isResourceCanPatch(context);
                    return true;
                } catch (Throwable th) {
                    Log.e(TAG, "resource hook check failed.", th);
                    shareLoadPatchResult.throwable = th;
                    shareLoadPatchResult.errorCode = -21;
                    return false;
                }
            } else {
                shareLoadPatchResult.errorCode = -20;
                return false;
            }
        }
        shareLoadPatchResult.errorCode = -8;
        return false;
    }
}
