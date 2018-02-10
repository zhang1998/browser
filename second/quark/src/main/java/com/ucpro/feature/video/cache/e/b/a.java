package com.ucpro.feature.video.cache.e.b;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: ProGuard */
final class a {
    private Logger a = Logger.getLogger(getClass().getName());
    private g b;

    public a(g gVar) {
        if (gVar == null) {
            throw new NullPointerException("type");
        }
        this.b = gVar;
    }

    public final e a(Readable readable) throws c {
        Scanner scanner = new Scanner(readable);
        Object obj = 1;
        List arrayList = new ArrayList(10);
        b bVar = new b();
        boolean z = false;
        int i = -1;
        int i2 = -1;
        d dVar = null;
        int i3 = 0;
        while (scanner.hasNextLine()) {
            int i4;
            boolean z2;
            Object obj2;
            int i5;
            String trim = scanner.nextLine().trim();
            if (trim.length() > 0) {
                if (trim.startsWith("#EXT")) {
                    if (obj != null) {
                        a(i3, trim);
                        i4 = i;
                        z2 = z;
                        obj2 = null;
                        i5 = i2;
                    } else if (trim.startsWith("#EXTINF")) {
                        Matcher matcher = l.a.matcher(trim);
                        if (matcher.find() || matcher.matches() || matcher.groupCount() > 0) {
                            String group = matcher.group(1);
                            String group2 = matcher.groupCount() > 1 ? matcher.group(2) : "";
                            try {
                                bVar.a = Double.valueOf(group).doubleValue();
                                bVar.e = group2;
                                i5 = i2;
                                i4 = i;
                                z2 = z;
                                obj2 = obj;
                            } catch (Throwable e) {
                                throw new c(trim, i3, e);
                            }
                        }
                        throw new c(trim, i3, "EXTINF must specify at least the duration");
                    } else if (trim.startsWith("#EXT-X-ENDLIST")) {
                        i4 = i;
                        z2 = true;
                        obj2 = obj;
                        i5 = i2;
                    } else if (trim.startsWith("#EXT-X-TARGETDURATION")) {
                        if (i != -1) {
                            throw new c(trim, i3, "#EXT-X-TARGETDURATION duplicated");
                        }
                        i4 = (int) a(trim, i3, l.c, "#EXT-X-TARGETDURATION");
                        z2 = z;
                        obj2 = obj;
                        i5 = i2;
                    } else if (trim.startsWith("#EXT-X-MEDIA-SEQUENCE")) {
                        if (i2 != -1) {
                            throw new c(trim, i3, "#EXT-X-MEDIA-SEQUENCE duplicated");
                        }
                        i5 = (int) a(trim, i3, l.d, "#EXT-X-MEDIA-SEQUENCE");
                        i4 = i;
                        z2 = z;
                        obj2 = obj;
                    } else if (trim.startsWith("#EXT-X-DISCONTINUITY")) {
                        bVar.g = true;
                        i5 = i2;
                        i4 = i;
                        z2 = z;
                        obj2 = obj;
                    } else if (trim.startsWith("#EXT-X-PROGRAM-DATE-TIME")) {
                        bVar.f = l.a(trim, i3);
                        i5 = i2;
                        i4 = i;
                        z2 = z;
                        obj2 = obj;
                    } else if (trim.startsWith("#EXT-X-KEY")) {
                        Matcher matcher2 = l.b.matcher(trim);
                        if (matcher2.find() && matcher2.matches() && matcher2.groupCount() > 0) {
                            trim = matcher2.group(1);
                            String group3 = matcher2.group(3);
                            if (trim.equalsIgnoreCase("none")) {
                                dVar = null;
                            } else {
                                Object fVar = new f(group3 != null ? a(group3) : null, trim);
                            }
                            i5 = i2;
                            i4 = i;
                            z2 = z;
                            obj2 = obj;
                        } else {
                            throw new c(trim, i3, "illegal input: " + trim);
                        }
                    } else {
                        this.a.log(Level.FINE, "Unknown: '" + trim + "'");
                        i5 = i2;
                        i4 = i;
                        z2 = z;
                        obj2 = obj;
                    }
                } else if (!trim.startsWith("#")) {
                    if (obj != null) {
                        a(i3, trim);
                    }
                    bVar.d = dVar;
                    bVar.b = a(trim);
                    arrayList.add(new k(bVar.c, bVar.d, bVar.a, bVar.b, bVar.e, bVar.f, bVar.g));
                    bVar.a = 0.0d;
                    bVar.b = null;
                    bVar.e = null;
                    bVar.f = -1;
                    bVar.g = false;
                    bVar.d = null;
                    bVar.c = null;
                } else if (this.a.isLoggable(Level.FINEST)) {
                    this.a.log(Level.FINEST, "----- Comment: " + trim);
                    i5 = i2;
                    i4 = i;
                    z2 = z;
                    obj2 = obj;
                }
                i2 = i5;
                i = i4;
                z = z2;
                i3++;
                obj = obj2;
            }
            i5 = i2;
            i4 = i;
            z2 = z;
            obj2 = obj;
            i2 = i5;
            i = i4;
            z = z2;
            i3++;
            obj = obj2;
        }
        return new e(Collections.unmodifiableList(arrayList), z, i, i2);
    }

    private void a(int i, String str) throws c {
        if (this.b == g.M3U8 && !str.startsWith("#EXTM3U")) {
            throw new c(str, i, "Playlist type '" + g.M3U8 + "' must start with #EXTM3U");
        }
    }

    private static URI a(String str) {
        try {
            return URI.create(str);
        } catch (IllegalArgumentException e) {
            return new File(str).toURI();
        }
    }

    private static long a(String str, int i, Pattern pattern, String str2) throws c {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find() || matcher.matches() || matcher.groupCount() > 0) {
            try {
                return Long.valueOf(matcher.group(1)).longValue();
            } catch (Throwable e) {
                throw new c(str, i, e);
            }
        }
        throw new c(str, i, str2 + " must specify duration");
    }
}
