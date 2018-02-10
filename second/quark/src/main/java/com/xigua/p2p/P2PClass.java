package com.xigua.p2p;

import com.uc.c.g;
import com.uc.m;
import java.io.File;

/* compiled from: ProGuard */
public class P2PClass {
    private final native int dosetupload(int i);

    private final native int doxadd(byte[] bArr);

    private final native int doxcheck(byte[] bArr);

    private final native int doxdownload(byte[] bArr);

    private final native int doxendhttpd();

    private final native int doxsave();

    private final native int doxsetduration(int i);

    private final native int doxstarthttpd(byte[] bArr);

    private final native int doxterminate();

    private final native long getdownsize(int i);

    private final native long getfilesize(int i);

    private final native long getlocalfilesize(byte[] bArr);

    private final native int getpercent();

    private final native long getspeed(int i);

    public final native int doxdel(byte[] bArr);

    public final native int doxpause(byte[] bArr);

    public final native int doxstart(byte[] bArr);

    public P2PClass() {
        new StringBuilder("XiGuaUtil.isHasLoadSo 1 = ").append(g.a);
        try {
            File file = new File(g.a(), "p2p_so");
            if (!file.exists()) {
                file.mkdir();
            }
            String d = g.d();
            if (new File(d).exists()) {
                System.load(d);
                g.a = true;
                new StringBuilder("XiGuaUtil.isHasLoadSo 2 = ").append(g.a).append("  filePath = ").append(d);
            }
        } catch (Exception e) {
            g.a = false;
            new StringBuilder("XiGuaUtil.isHasLoadSo e = ").append(g.a).append("   e = ").append(e);
        }
        doxstarthttpd(m.b.getBytes());
    }
}
