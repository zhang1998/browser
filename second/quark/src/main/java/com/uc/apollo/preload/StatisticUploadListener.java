package com.uc.apollo.preload;

import com.uc.apollo.annotation.KeepForSdk;
import com.uc.apollo.util.ReflectUtil;
import java.lang.reflect.Method;
import java.util.HashMap;

@KeepForSdk
/* compiled from: ProGuard */
public interface StatisticUploadListener {

    @KeepForSdk
    /* compiled from: ProGuard */
    public class AdapterImpl implements StatisticUploadListener {
        private Method mOnUpload;
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
                this.mOnUpload = ReflectUtil.getMethod2(this.mSibling.getClass(), "onUpload", HashMap.class);
            } catch (NoSuchMethodException e) {
            }
        }

        public boolean onUpload(HashMap<String, String> hashMap) {
            return ((Boolean) ReflectUtil.call(Boolean.TYPE, this.mSibling, this.mOnUpload, hashMap)).booleanValue();
        }
    }

    boolean onUpload(HashMap<String, String> hashMap);
}
