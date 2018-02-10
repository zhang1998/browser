package com.uc.apollo.preload;

import com.uc.apollo.annotation.KeepForSdk;
import com.uc.apollo.util.ReflectUtil;
import java.lang.reflect.Method;

@KeepForSdk
/* compiled from: ProGuard */
public interface PreloadListener {

    @KeepForSdk
    /* compiled from: ProGuard */
    public class AdapterImpl implements PreloadListener {
        private Method mOnInfo;
        private Object mSibling;

        public static AdapterImpl create(Object obj) {
            if (obj == null) {
                return null;
            }
            return new AdapterImpl(obj);
        }

        private AdapterImpl(Object obj) {
            this.mSibling = obj;
            try {
                this.mOnInfo = ReflectUtil.getMethod2(obj.getClass(), "onInfo", String.class, Integer.TYPE, Integer.TYPE);
            } catch (NoSuchMethodException e) {
            }
        }

        public void onInfo(String str, int i, int i2) {
            ReflectUtil.call(Void.TYPE, this.mSibling, this.mOnInfo, str, Integer.valueOf(i), Integer.valueOf(i2));
        }
    }

    void onInfo(String str, int i, int i2);
}
