package com.uc.quark.filedownloader.e;

import android.app.Notification;

/* compiled from: ProGuard */
public class d {
    public static boolean a(String str, String str2, boolean z) {
        j.e(d.class, "request start the task([%s], [%s], [%B]) in the download service, but the download service isn't connected yet.", str, str2, Boolean.valueOf(z));
        return false;
    }

    public static boolean a(int i) {
        j.e(d.class, "request pause the task[%d] in the download service, but the download service isn't connected yet.", Integer.valueOf(i));
        return false;
    }

    public static boolean a() {
        j.e(d.class, "request pause the task bundle in the download service, but the download service isn't connected yet.", new Object[0]);
        return false;
    }

    public static long b(int i) {
        j.e(d.class, "request get the downloaded so far byte for the task[%d] in the download service, but the download service isn't connected yet.", Integer.valueOf(i));
        return 0;
    }

    public static long c(int i) {
        j.e(d.class, "request get the total byte for the task[%d] in the download service, but the download service isn't connected yet.", Integer.valueOf(i));
        return 0;
    }

    public static byte d(int i) {
        j.e(d.class, "request get the status for the task[%d] in the download service, but the download service isn't connected yet.", Integer.valueOf(i));
        return (byte) 0;
    }

    public static void b() {
        j.e(d.class, "request pause all tasks in the download service, but the download service isn't connected yet.", new Object[0]);
    }

    public static boolean c() {
        j.e(d.class, "request check the download service is idle, but the download service isn't connected yet.", new Object[0]);
        return true;
    }

    public static void a(int i, Notification notification) {
        j.e(d.class, "request set the download service as the foreground service([%d],[%s]), but the download service isn't connected yet.", Integer.valueOf(i), notification);
    }

    public static void a(boolean z) {
        j.e(d.class, "request cancel the foreground status[%B] for the download service, but the download service isn't connected yet.", Boolean.valueOf(z));
    }

    public static boolean e(int i) {
        j.e(d.class, "request clear the task[%d] data in the database, but the download service isn't connected yet.", Integer.valueOf(i));
        return false;
    }

    public static void d() {
        j.e(d.class, "invoke startList", new Object[0]);
    }
}
