package com.uc.webview.export.internal.setup;

import android.content.Context;
import android.util.Pair;
import android.webkit.ValueCallback;
import com.uc.webview.export.annotations.Reflection;
import com.uc.webview.export.extension.UCCore;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: ProGuard */
public class UCSubSetupTask<RETURN_TYPE extends UCSubSetupTask<RETURN_TYPE, CALLBACK_TYPE>, CALLBACK_TYPE extends UCSubSetupTask<RETURN_TYPE, CALLBACK_TYPE>> extends UCAsyncTask<RETURN_TYPE, CALLBACK_TYPE> {
    protected static final String EVENT_STAT = "stat";
    protected ClassLoader mCL;
    protected ConcurrentHashMap<String, Object> mOptions = new ConcurrentHashMap();
    protected ClassLoader mShellCL;
    protected Pair<String, HashMap<String, String>> mStat;
    protected UCMPackageInfo mUCM;

    /* compiled from: ProGuard */
    public final class a<CB_TYPE extends UCSubSetupTask<CB_TYPE, CB_TYPE>> implements ValueCallback<CB_TYPE> {
        final /* synthetic */ UCSubSetupTask a;

        public a(UCSubSetupTask uCSubSetupTask) {
            this.a = uCSubSetupTask;
        }

        public final /* synthetic */ void onReceiveValue(Object obj) {
            this.a.callbackStat(((UCSubSetupTask) obj).getStat());
        }
    }

    public UCSubSetupTask(UCAsyncTask uCAsyncTask) {
        super(uCAsyncTask);
    }

    public UCSubSetupTask() {
        super(null);
    }

    public final RETURN_TYPE setUCM(UCMPackageInfo uCMPackageInfo) {
        this.mUCM = uCMPackageInfo;
        return this;
    }

    public final RETURN_TYPE setClassLoader(ClassLoader classLoader) {
        this.mCL = classLoader;
        return this;
    }

    public final RETURN_TYPE setup(String str, Object obj) {
        if (obj == null) {
            this.mOptions.remove(str);
        } else {
            this.mOptions.put(str, obj);
        }
        return this;
    }

    @Reflection
    public final Pair<String, HashMap<String, String>> getStat() {
        return this.mStat;
    }

    protected final RETURN_TYPE setOptions(ConcurrentHashMap<String, Object> concurrentHashMap) {
        ConcurrentHashMap concurrentHashMap2;
        try {
            concurrentHashMap2 = (ConcurrentHashMap) super.clone();
        } catch (CloneNotSupportedException e) {
            concurrentHashMap2 = null;
        }
        if (concurrentHashMap2 == null) {
            concurrentHashMap2 = new ConcurrentHashMap();
            concurrentHashMap2.putAll(concurrentHashMap);
        }
        this.mOptions = concurrentHashMap2;
        return this;
    }

    protected final Object getOption(String str) {
        return this.mOptions.get(str);
    }

    protected final Context getContext() {
        return (Context) getOption(UCCore.OPTION_CONTEXT);
    }

    public final void callbackStat(Pair<String, HashMap<String, String>> pair) {
        this.mStat = pair;
        callback(EVENT_STAT);
    }
}
