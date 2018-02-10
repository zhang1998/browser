package com.ucweb.a;

/* compiled from: ProGuard */
final class k {
    public static void a(String str, boolean z) {
        if (z) {
            new StringBuilder("[").append(str).append("]有新版本.");
        } else {
            new StringBuilder("[").append(str).append("]没有新版本.");
        }
    }

    public static void b(String str, boolean z) {
        if (z) {
            new StringBuilder("[").append(str).append("]显示红点");
        } else {
            new StringBuilder("[").append(str).append("]不显示红点");
        }
    }
}
