package com.uc.webview.export.cyclone.service;

import android.content.Context;
import android.os.Build.VERSION;
import com.taobao.weex.ui.component.ab;
import com.uc.webview.export.cyclone.Constant;
import com.uc.webview.export.cyclone.UCCyclone;
import com.uc.webview.export.cyclone.UCKnownException;
import com.uc.webview.export.cyclone.UCLibrary;
import com.uc.webview.export.cyclone.UCLogger;
import com.uc.webview.export.cyclone.UCService;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Constant
/* compiled from: ProGuard */
public class UCVmsizeImpl implements UCVmsize {
    private static final String LOG_TAG = "UCVmsizeImpl";
    private static boolean mSoIsLoaded = false;
    private static UCKnownException mSoIsLoadedException = null;

    private static native int nativeSaveChromiumReservedSpace(long j);

    static {
        try {
            UCService.registerImpl(UCVmsize.class, new UCVmsizeImpl());
        } catch (Throwable th) {
            UCLogger create = UCLogger.create(ab.PROP_FS_WRAP_CONTENT, LOG_TAG);
            if (create != null) {
                create.print("UCVmsizeImpl register exception:" + th, new Throwable[0]);
            }
        }
    }

    public long saveChromiumReservedSpace(Context context) throws Exception {
        long j = 0;
        if (VERSION.SDK_INT >= 21) {
            Class cls = Class.forName("android.webkit.WebViewFactory");
            if (cls != null) {
                Field declaredField = cls.getDeclaredField("sAddressSpaceReserved");
                if (declaredField != null) {
                    if (!declaredField.isAccessible()) {
                        declaredField.setAccessible(true);
                    }
                    if (declaredField.getBoolean(null)) {
                        try {
                            Field declaredField2 = cls.getDeclaredField("sProviderLock");
                            if (declaredField2 != null) {
                                if (!declaredField2.isAccessible()) {
                                    declaredField2.setAccessible(true);
                                }
                                this = declaredField2.get(null);
                            }
                        } catch (Throwable th) {
                        }
                        if (!mSoIsLoaded) {
                            loadSo(context);
                        }
                        synchronized (r8) {
                            declaredField.set(null, Boolean.valueOf(false));
                            try {
                                Class cls2 = Class.forName("android.os.SystemProperties");
                                if (cls2 == null) {
                                    throw new RuntimeException("SystemProperties not found.");
                                }
                                Method declaredMethod = cls2.getDeclaredMethod("getLong", new Class[]{String.class, Long.TYPE});
                                if (declaredMethod == null) {
                                    throw new RuntimeException("SystemProperties.getLong not found.");
                                }
                                if (!declaredMethod.isAccessible()) {
                                    declaredMethod.setAccessible(true);
                                }
                                Long l = (Long) declaredMethod.invoke(null, new Object[]{"persist.sys.webview.vmsize", Long.valueOf(104857600)});
                                if (l == null) {
                                    throw new RuntimeException("SystemProperties.getLong invoke return null.");
                                }
                                int nativeSaveChromiumReservedSpace = nativeSaveChromiumReservedSpace(l.longValue());
                                if (nativeSaveChromiumReservedSpace == 0) {
                                    j = l.longValue();
                                } else {
                                    throw new RuntimeException("Error:" + nativeSaveChromiumReservedSpace + " on nativeSaveChromiumReservedSpace");
                                }
                            } catch (Exception e) {
                                declaredField.set(null, Boolean.valueOf(true));
                                throw e;
                            }
                        }
                    }
                }
            }
        }
        return j;
    }

    private static synchronized void loadSo(Context context) {
        synchronized (UCVmsizeImpl.class) {
            if (!mSoIsLoaded) {
                if (mSoIsLoadedException != null) {
                    throw mSoIsLoadedException;
                }
                try {
                    UCLibrary.load(context, UCCyclone.genFile(context, null, "libvmsize", ".so", 24713491, "e3d7b7107d5f402c1dde1a3930f7d7da", UCVmsizeImplConstant.genCodes(), new Object[0]).getAbsolutePath(), null);
                    mSoIsLoaded = true;
                } catch (Throwable th) {
                    mSoIsLoadedException = new UCKnownException(th);
                }
            }
        }
    }

    public String toString() {
        return "UCVmsizeImpl." + getServiceVersion();
    }

    public int getServiceVersion() {
        return 0;
    }
}
