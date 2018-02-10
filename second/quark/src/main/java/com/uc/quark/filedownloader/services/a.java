package com.uc.quark.filedownloader.services;

/* compiled from: ProGuard */
final class a implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ v b;

    a(v vVar, int i) {
        this.b = vVar;
        this.a = i;
    }

    public final void run() {
        try {
            this.b.b.delete("filedownloader", "_id = ?", new String[]{String.valueOf(this.a)});
            this.b.b.delete("threadids", "downloadfile_id = ?", new String[]{String.valueOf(this.a)});
        } catch (Exception e) {
        }
    }
}
