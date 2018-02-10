package com.uc.aerie.loader.stable;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import java.io.File;

/* compiled from: ProGuard */
public class AerieApplication extends Application {
    private static final String TAG = "AerieApplication";
    private Object delegate = null;
    private final String delegateAppClassName;
    private final boolean verifyMd5OnLoad;

    public AerieApplication(String str, boolean z) {
        this.delegateAppClassName = str;
        this.verifyMd5OnLoad = z;
    }

    protected final void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        long uptimeMillis = SystemClock.uptimeMillis();
        Intent intent = new Intent();
        intent.putExtra(ShareIntentUtil.INTENT_START_TIMESTAMP, uptimeMillis);
        intent.putExtra(ShareIntentUtil.INTENT_DEPLOYMENT_BASE_ID, AerieLoaderConfig.getBaseDeploymentId());
        String str = ShareConstants.INVALID_CPU_ABI;
        File file = new File(SharePatchFileUtil.getRootDirectory(this));
        if (file.exists() && file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                if (file2.getName().endsWith(ShareConstants.CPU_ABI_SUFFIX)) {
                    String[] split = file2.getName().split("\\.");
                    if (!TextUtils.isEmpty(split[0])) {
                        str = split[0];
                        break;
                    }
                }
            }
        }
        intent.putExtra(ShareIntentUtil.INTENT_DEPLOYMENT_LIB_ABI_CFG, str);
        new AerieLoader(this, AerieLoaderConfig.getBaseDeploymentId(), str).tryLoad(this.verifyMd5OnLoad, intent);
        try {
            Class.forName("com.uc.aerie.loader.AerieLoaderContext", false, getClassLoader()).getDeclaredMethod("init", new Class[]{Intent.class}).invoke(null, new Object[]{intent});
        } catch (Throwable th) {
            Log.e(TAG, "init AerieLoaderContext fail.", th);
        }
        try {
            this.delegate = Class.forName(this.delegateAppClassName, false, getClassLoader()).getConstructor(new Class[]{Application.class}).newInstance(new Object[]{this});
            ShareReflectUtil.findMethod(this.delegate, "onBaseContextAttached", Context.class).invoke(this.delegate, new Object[]{context});
        } catch (Throwable th2) {
            RuntimeException runtimeException = new RuntimeException("create delegate " + this.delegateAppClassName + " fail.", th2);
        }
    }

    public final void onCreate() {
        super.onCreate();
        try {
            ShareReflectUtil.findMethod(this.delegate, "onCreate", new Class[0]).invoke(this.delegate, new Object[0]);
        } catch (Throwable th) {
            RuntimeException runtimeException = new RuntimeException("onCreate method not found!", th);
        }
    }
}
