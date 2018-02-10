package com.uc.apollo.media.impl;

import com.UCMobile.Apollo.MediaPlayer;
import com.uc.apollo.util.f;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: ProGuard */
final class b {
    public int a;
    public int b;
    public int c;
    public int d;
    private String e = MediaPlayer.getVersionString();

    final boolean a() {
        return f.b(this.e) && ((this.a >= 2 && this.b >= 10) || this.d >= 156);
    }

    b() {
        if (!f.a(this.e)) {
            try {
                Matcher matcher = Pattern.compile("\\A(\\d+)\\.(\\d+)\\.(\\d+)\\.(\\d+)").matcher(this.e);
                if (matcher.find()) {
                    this.a = Integer.parseInt(matcher.group(1));
                    this.b = Integer.parseInt(matcher.group(2));
                    this.c = Integer.parseInt(matcher.group(3));
                    this.d = Integer.parseInt(matcher.group(4));
                }
            } catch (Throwable th) {
                this.d = -1;
            }
        }
    }

    public final String toString() {
        return this.e;
    }
}
