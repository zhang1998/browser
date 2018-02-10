package com.uc.media.interfaces.proxy;

import com.uc.webview.export.annotations.Reflection;

@Reflection
/* compiled from: ProGuard */
public interface Manager {

    @Reflection
    /* compiled from: ProGuard */
    public final class Factory {
        private static Manager sManager;

        private Factory() {
        }

        public static Manager getManager() {
            return sManager;
        }

        public static void setManager(Manager manager) {
            sManager = manager;
        }
    }

    boolean add(String str, String str2);

    void remove(String str);
}
