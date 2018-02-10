package com.ucpro.feature.downloadpage.e.b;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
public enum b {
    APK("apk", c.APK),
    DOC("doc", c.DOC),
    XLS("xls", c.XLS),
    PPT("ppt", c.PPT),
    RAR("rar", c.RAR),
    ZIP("zip", c.RAR),
    _7Z("7z", c.RAR),
    TEXT("txt", c.TEXT),
    WEB("html", c.WEB),
    WAV("wav", c.MUSIC),
    AIFF("AIFF", c.MUSIC),
    AU("AU", c.MUSIC),
    PCM("PCM", c.MUSIC),
    FLAC("FLAC", c.MUSIC),
    APE("APE", c.MUSIC),
    WMA("WMA", c.MUSIC),
    MP3("mp3", c.MUSIC),
    WV("WV", c.MUSIC),
    TTA("TTA", c.MUSIC),
    ATRAC("ATRAC", c.MUSIC),
    m4a("m4a", c.MUSIC),
    AAC("AAC", c.MUSIC),
    PDF("pdf", c.PDF),
    bmp("bmp", c.PICTURE),
    JPG("jpg", c.PICTURE),
    tiff("tiff", c.PICTURE),
    gif("gif", c.PICTURE),
    pcx("pcx", c.PICTURE),
    tga("tga", c.PICTURE),
    exif("exif", c.PICTURE),
    fpx("fpx", c.PICTURE),
    svg("svg", c.PICTURE),
    psd("psd", c.PICTURE),
    cdr("cdr", c.PICTURE),
    pcd("pcd", c.PICTURE),
    dxf("dxf", c.PICTURE),
    ufo("ufo", c.PICTURE),
    eps("eps", c.PICTURE),
    ai("ai", c.PICTURE),
    raw(ShareConstants.DEXMODE_RAW, c.PICTURE),
    png("png", c.PICTURE),
    RMVB("RMVB", c.VIDEO),
    MP4("MP4", c.VIDEO),
    MPEG("MPEG", c.VIDEO),
    MPG("MPG", c.VIDEO),
    DAT("DAT", c.VIDEO),
    AVI("AVI", c.VIDEO),
    MOV("MOV", c.VIDEO),
    ASF("ASF", c.VIDEO),
    MWV("MWV", c.VIDEO),
    NAVI("NAVI", c.VIDEO),
    _3GP("3GP", c.VIDEO),
    REAL("REAL", c.VIDEO),
    MKV("MKV", c.VIDEO),
    FLV("FLV", c.VIDEO),
    F4V("F4V", c.VIDEO),
    FOLDER("", c.FOLDER),
    UNKOWNN("", c.UNKOWNN);
    
    private static boolean ag;
    private String ah;
    private c f0ai;
    private Drawable aj;

    static {
        ag = false;
    }

    private b(String str, c cVar) {
        this.ah = str;
        this.f0ai = cVar;
    }

    public static Drawable a(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (b bVar : values()) {
                if (str.equalsIgnoreCase(bVar.ah)) {
                    return bVar.b();
                }
            }
        }
        return UNKOWNN.b();
    }

    private Drawable b() {
        if (this.aj == null) {
            c cVar = this.f0ai;
            if (cVar.o == null || cVar.p != ag) {
                cVar.o = a.a(cVar.n);
                if (cVar.p != ag) {
                    cVar.p = ag;
                }
            }
            this.aj = cVar.o;
        }
        return this.aj;
    }

    public static void a() {
        ag = !ag;
    }
}
