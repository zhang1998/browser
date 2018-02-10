package com.uc.apollo.media.b;

/* compiled from: ProGuard */
public final class i {
    public boolean a;
    public long b;
    public boolean c;
    public int d;
    public String e;
    public int f;
    public int g;
    public j[] h;
    public int i;
    public String j;

    /* compiled from: ProGuard */
    public enum a {
        M3U8("UTF-8", "application/vnd.apple.mpegurl", "m3u8"),
        M3U("US-ASCII", "audio/mpegurl", "m3u");
        
        public final String c;
        public final String d;
        public final String e;

        private a(String str, String str2, String str3) {
            this.c = str;
            this.d = str2;
            this.e = str3;
        }
    }

    public i(String str) {
        this(0, str);
    }

    public i(int i, String str) {
        this.a = false;
        this.b = -1;
        this.c = false;
        this.d = 0;
        this.e = "";
        this.f = 0;
        this.g = 0;
        this.i = -1;
        this.d = i;
        this.e = str;
    }

    public final boolean a() {
        return !this.c;
    }

    final void b() {
        int i = 0;
        this.i = 0;
        this.b = -1;
        if (this.h != null) {
            while (i < this.h.length) {
                this.i += this.h[i].c;
                i++;
            }
            if (a() && this.h.length > 0) {
                this.b = (System.currentTimeMillis() + ((long) (this.i / 2))) / 1000;
            }
        }
    }

    public final String toString() {
        return a(false);
    }

    public final String a(boolean z) {
        int i;
        int i2 = 0;
        if (this.h == null) {
            i = 0;
        } else {
            i = this.h.length * 64;
        }
        StringBuilder stringBuilder = new StringBuilder(i + 128);
        stringBuilder.append("m3u8 list: ");
        stringBuilder.append("url=").append(this.e).append(", target duration=").append(this.f).append(", start seq no=").append(this.g);
        if (this.d != 0) {
            stringBuilder.append(", band width=").append(this.d);
        }
        if (this.a) {
            if (a()) {
                stringBuilder.append(", is live");
            }
            stringBuilder.append(", list finished=").append(this.c);
            if (this.h == null || this.h.length == 0) {
                stringBuilder.append(", segments is empty");
            } else {
                stringBuilder.append(", duration=").append(m.a(this.i)).append('/').append(m.a(this.h.length * this.f));
                stringBuilder.append(", segment count ").append(this.h.length);
                if (z) {
                    stringBuilder.append('\n');
                    while (i2 < this.h.length) {
                        stringBuilder.append("segment ").append(i2 + 1).append(" [").append(this.h[i2].a(z)).append("]\n");
                        i2++;
                    }
                }
            }
        } else {
            stringBuilder.append(", content no load");
        }
        return stringBuilder.toString();
    }
}
