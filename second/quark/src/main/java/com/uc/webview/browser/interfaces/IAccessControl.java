package com.uc.webview.browser.interfaces;

import com.uc.webview.export.annotations.Interface;

@Interface
/* compiled from: ProGuard */
public interface IAccessControl {

    @Interface
    /* compiled from: ProGuard */
    public abstract class ShellAccessControl {
        private static ShellAccessControl a = null;

        public abstract int isPluginAccessible(String str, String str2);

        public abstract int isResourceAccessible(String str, String str2);

        public static void setInstance(ShellAccessControl shellAccessControl) {
            a = shellAccessControl;
        }

        public static ShellAccessControl getInstance() {
            return a;
        }
    }

    @Deprecated
    boolean appendAccessiblePolicy(String str, String str2, int i);

    @Deprecated
    void clearAccessControlCache(String str);

    @Deprecated
    boolean removeAccessiblePolicy(String str, String str2);
}
