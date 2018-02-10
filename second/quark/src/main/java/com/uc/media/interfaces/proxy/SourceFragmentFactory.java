package com.uc.media.interfaces.proxy;

import com.uc.webview.export.annotations.Reflection;

@Reflection
/* compiled from: ProGuard */
public interface SourceFragmentFactory {

    @Reflection
    /* compiled from: ProGuard */
    public class Factory {
        private static SourceFragmentFactory mCoreFactory;
        private static SourceFragmentFactory mShellFactory;

        public static void setShellFacory(SourceFragmentFactory sourceFragmentFactory) {
            mShellFactory = sourceFragmentFactory;
        }

        public static SourceFragmentFactory getShellFactory() {
            return mShellFactory;
        }

        public static void setCoreFacory(SourceFragmentFactory sourceFragmentFactory) {
            mCoreFactory = sourceFragmentFactory;
        }

        public static SourceFragmentFactory getCoreFactory() {
            return mCoreFactory;
        }

        public static void check() {
            if (mShellFactory != null) {
                mShellFactory.check();
            }
            if (mCoreFactory != null) {
                mCoreFactory.check();
            }
        }
    }

    void check();

    SourceFragment get(SourceInfo sourceInfo, Range range);

    void put(SourceFragment sourceFragment);

    SourceInfo query(String str);
}
