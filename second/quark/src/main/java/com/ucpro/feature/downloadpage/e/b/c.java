package com.ucpro.feature.downloadpage.e.b;

import android.graphics.drawable.Drawable;

/* compiled from: ProGuard */
enum c {
    APK("download_file_type_apk.svg"),
    DOC("download_file_type_doc.svg"),
    MUSIC("download_file_type_music.svg"),
    PDF("download_file_type_doc.svg"),
    PICTURE("download_file_type_picture.svg"),
    PPT("download_file_type_doc.svg"),
    RAR("download_file_type_doc.svg"),
    TEXT("download_file_type_doc.svg"),
    VIDEO("download_file_type_video.svg"),
    WEB("download_file_type_doc.svg"),
    XLS("download_file_type_doc.svg"),
    FOLDER("download_file_type_doc.svg"),
    UNKOWNN("download_file_type_unknown.svg");
    
    String n;
    Drawable o;
    boolean p;

    private c(String str) {
        this.p = false;
        this.n = str;
    }
}
