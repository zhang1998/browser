package com.ucweb.common.util.l;

import android.net.Uri;
import android.text.TextUtils;
import com.uc.crashsdk.export.LogType;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;

/* compiled from: ProGuard */
public final class d {
    private static final Map<String, String> a = new HashMap();
    private static final Map<String, String> b = new HashMap();

    static {
        b("application/andrew-inset", "ez");
        b("application/dsptype", "tsp");
        b("application/epub+zip", "epub");
        b("application/hta", "hta");
        b("application/mac-binhex40", "hqx");
        b("application/mathematica", "nb");
        b("application/msaccess", "mdb");
        b("application/oda", "oda");
        b("application/ogg", "ogg");
        b("application/ogg", "oga");
        b("application/pdf", "pdf");
        b("application/pgp-keys", "key");
        b("application/pgp-signature", "pgp");
        b("application/pics-rules", "prf");
        b("application/pkix-cert", "cer");
        b("application/rar", "rar");
        b("application/rdf+xml", "rdf");
        b("application/rss+xml", "rss");
        b("application/zip", "zip");
        b("application/vnd.android.package-archive", "apk");
        b("application/vnd.cinderella", "cdy");
        b("application/vnd.ms-pki.stl", "stl");
        b("application/vnd.oasis.opendocument.database", "odb");
        b("application/vnd.oasis.opendocument.formula", "odf");
        b("application/vnd.oasis.opendocument.graphics", "odg");
        b("application/vnd.oasis.opendocument.graphics-template", "otg");
        b("application/vnd.oasis.opendocument.image", "odi");
        b("application/vnd.oasis.opendocument.presentation", "odp");
        b("application/vnd.oasis.opendocument.presentation-template", "otp");
        b("application/vnd.oasis.opendocument.spreadsheet", "ods");
        b("application/vnd.oasis.opendocument.spreadsheet-template", "ots");
        b("application/vnd.oasis.opendocument.text", "odt");
        b("application/vnd.oasis.opendocument.text-master", "odm");
        b("application/vnd.oasis.opendocument.text-template", "ott");
        b("application/vnd.oasis.opendocument.text-web", "oth");
        b("application/vnd.google-earth.kml+xml", "kml");
        b("application/vnd.google-earth.kmz", "kmz");
        b("application/msword", "doc");
        b("application/msword", "dot");
        b("application/vnd.openxmlformats-officedocument.wordprocessingml.document", "docx");
        b("application/vnd.openxmlformats-officedocument.wordprocessingml.template", "dotx");
        b("application/vnd.ms-excel", "xls");
        b("application/vnd.ms-excel", "xlt");
        b("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", "xlsx");
        b("application/vnd.openxmlformats-officedocument.spreadsheetml.template", "xltx");
        b("application/vnd.ms-powerpoint", "ppt");
        b("application/vnd.ms-powerpoint", "pot");
        b("application/vnd.ms-powerpoint", "pps");
        b("application/vnd.openxmlformats-officedocument.presentationml.presentation", "pptx");
        b("application/vnd.openxmlformats-officedocument.presentationml.template", "potx");
        b("application/vnd.openxmlformats-officedocument.presentationml.slideshow", "ppsx");
        b("application/vnd.rim.cod", "cod");
        b("application/vnd.smaf", "mmf");
        b("application/vnd.stardivision.calc", "sdc");
        b("application/vnd.stardivision.draw", "sda");
        b("application/vnd.stardivision.impress", "sdd");
        b("application/vnd.stardivision.impress", "sdp");
        b("application/vnd.stardivision.math", "smf");
        b("application/vnd.stardivision.writer", "sdw");
        b("application/vnd.stardivision.writer", "vor");
        b("application/vnd.stardivision.writer-global", "sgl");
        b("application/vnd.sun.xml.calc", "sxc");
        b("application/vnd.sun.xml.calc.template", "stc");
        b("application/vnd.sun.xml.draw", "sxd");
        b("application/vnd.sun.xml.draw.template", "std");
        b("application/vnd.sun.xml.impress", "sxi");
        b("application/vnd.sun.xml.impress.template", "sti");
        b("application/vnd.sun.xml.math", "sxm");
        b("application/vnd.sun.xml.writer", "sxw");
        b("application/vnd.sun.xml.writer.global", "sxg");
        b("application/vnd.sun.xml.writer.template", "stw");
        b("application/vnd.visio", "vsd");
        b("application/x-abiword", "abw");
        b("application/x-apple-diskimage", "dmg");
        b("application/x-bcpio", "bcpio");
        b("application/x-bittorrent", "torrent");
        b("application/x-cdf", "cdf");
        b("application/x-cdlink", "vcd");
        b("application/x-chess-pgn", "pgn");
        b("application/x-cpio", "cpio");
        b("application/x-debian-package", "deb");
        b("application/x-debian-package", "udeb");
        b("application/x-director", "dcr");
        b("application/x-director", "dir");
        b("application/x-director", "dxr");
        b("application/x-dms", "dms");
        b("application/x-doom", "wad");
        b("application/x-dvi", "dvi");
        b("application/x-font", "pfa");
        b("application/x-font", "pfb");
        b("application/x-font", "gsf");
        b("application/x-font", "pcf");
        b("application/x-font", "pcf.Z");
        b("application/x-freemind", "mm");
        b("application/x-futuresplash", "spl");
        b("application/futuresplash", "spl");
        b("application/x-gnumeric", "gnumeric");
        b("application/x-go-sgf", "sgf");
        b("application/x-graphing-calculator", "gcf");
        b("application/x-gtar", "tgz");
        b("application/x-gtar", "gtar");
        b("application/x-gtar", "taz");
        b("application/x-hdf", "hdf");
        b("application/x-hwp", "hwp");
        b("application/x-ica", "ica");
        b("application/x-internet-signup", "ins");
        b("application/x-internet-signup", "isp");
        b("application/x-iphone", "iii");
        b("application/x-iso9660-image", "iso");
        b("application/x-jmol", "jmz");
        b("application/x-kchart", "chrt");
        b("application/x-killustrator", "kil");
        b("application/x-koan", "skp");
        b("application/x-koan", "skd");
        b("application/x-koan", "skt");
        b("application/x-koan", "skm");
        b("application/x-kpresenter", "kpr");
        b("application/x-kpresenter", "kpt");
        b("application/x-kspread", "ksp");
        b("application/x-kword", "kwd");
        b("application/x-kword", "kwt");
        b("application/x-latex", "latex");
        b("application/x-lha", "lha");
        b("application/x-lzh", "lzh");
        b("application/x-lzx", "lzx");
        b("application/x-maker", "frm");
        b("application/x-maker", "maker");
        b("application/x-maker", "frame");
        b("application/x-maker", "fb");
        b("application/x-maker", "book");
        b("application/x-maker", "fbdoc");
        b("application/x-mif", "mif");
        b("application/x-ms-wmd", "wmd");
        b("application/x-ms-wmz", "wmz");
        b("application/x-msi", "msi");
        b("application/x-ns-proxy-autoconfig", "pac");
        b("application/x-nwc", "nwc");
        b("application/x-object", "o");
        b("application/x-oz-application", "oza");
        b("application/x-pem-file", "pem");
        b("application/x-pkcs12", "p12");
        b("application/x-pkcs12", "pfx");
        b("application/x-pkcs7-certreqresp", "p7r");
        b("application/x-pkcs7-crl", "crl");
        b("application/x-quicktimeplayer", "qtl");
        b("application/x-shar", "shar");
        b("application/x-shockwave-flash", "swf");
        b("application/x-stuffit", "sit");
        b("application/x-sv4cpio", "sv4cpio");
        b("application/x-sv4crc", "sv4crc");
        b("application/x-tar", "tar");
        b("application/x-texinfo", "texinfo");
        b("application/x-texinfo", "texi");
        b("application/x-troff", "t");
        b("application/x-troff", "roff");
        b("application/x-troff-man", "man");
        b("application/x-ustar", "ustar");
        b("application/x-wais-source", "src");
        b("application/x-wingz", "wz");
        b("application/x-webarchive", "webarchive");
        b("application/x-webarchive-xml", "webarchivexml");
        b("application/x-x509-ca-cert", "crt");
        b("application/x-x509-user-cert", "crt");
        b("application/x-x509-server-cert", "crt");
        b("application/x-xcf", "xcf");
        b("application/x-xfig", "fig");
        b("application/xhtml+xml", "xhtml");
        b("application/x-mobipocket-ebook", "mobi");
        b("video/3gpp", "3gpp");
        b("video/3gpp", "3gp");
        b("video/3gpp2", "3gpp2");
        b("video/3gpp2", "3g2");
        b("audio/3gpp", "3gpp");
        b("audio/aac", "aac");
        b("audio/aac-adts", "aac");
        b("audio/amr", "amr");
        b("audio/amr-wb", "awb");
        b("audio/basic", "snd");
        b("audio/flac", "flac");
        b("application/x-flac", "flac");
        b("audio/imelody", "imy");
        b("audio/midi", "mid");
        b("audio/midi", "midi");
        b("audio/midi", "ota");
        b("audio/midi", "kar");
        b("audio/midi", "rtttl");
        b("audio/midi", "xmf");
        b("audio/mobile-xmf", "mxmf");
        b("audio/mpeg", "mp3");
        b("audio/mpeg", "mpga");
        b("audio/mpeg", "mpega");
        b("audio/mpeg", "mp2");
        b("audio/mpeg", "m4a");
        b("audio/mpegurl", "m3u");
        b("audio/prs.sid", "sid");
        b("audio/x-aiff", "aif");
        b("audio/x-aiff", "aiff");
        b("audio/x-aiff", "aifc");
        b("audio/x-gsm", "gsm");
        b("audio/x-matroska", "mka");
        b("audio/x-mpegurl", "m3u");
        b("audio/x-ms-wma", "wma");
        b("audio/x-ms-wax", "wax");
        b("audio/x-pn-realaudio", "ra");
        b("audio/x-pn-realaudio", "rm");
        b("audio/x-pn-realaudio", "ram");
        b("audio/x-realaudio", "ra");
        b("audio/x-scpls", "pls");
        b("audio/x-sd2", "sd2");
        b("audio/x-wav", "wav");
        b("image/x-ms-bmp", "bmp");
        b("image/bmp", "bmp");
        b("image/gif", "gif");
        b("image/x-icon", "ico");
        b("image/ico", "cur");
        b("image/ico", "ico");
        b("image/ief", "ief");
        b("image/jpeg", "jpg");
        b("image/jpeg", "jpeg");
        b("image/jpeg", "jpe");
        b("image/pcx", "pcx");
        b("image/png", "png");
        b("image/svg+xml", "svg");
        b("image/svg+xml", "svgz");
        b("image/tiff", "tiff");
        b("image/tiff", "tif");
        b("image/vnd.djvu", "djvu");
        b("image/vnd.djvu", "djv");
        b("image/vnd.wap.wbmp", "wbmp");
        b("image/webp", "webp");
        b("image/x-adobe-dng", "dng");
        b("image/x-canon-cr2", "cr2");
        b("image/x-cmu-raster", "ras");
        b("image/x-coreldraw", "cdr");
        b("image/x-coreldrawpattern", "pat");
        b("image/x-coreldrawtemplate", "cdt");
        b("image/x-corelphotopaint", "cpt");
        b("image/x-fuji-raf", "raf");
        b("image/x-jg", "art");
        b("image/x-jng", "jng");
        b("image/x-nikon-nef", "nef");
        b("image/x-nikon-nrw", "nrw");
        b("image/x-olympus-orf", "orf");
        b("image/x-panasonic-rw2", "rw2");
        b("image/x-pentax-pef", "pef");
        b("image/x-photoshop", "psd");
        b("image/x-portable-anymap", "pnm");
        b("image/x-portable-bitmap", "pbm");
        b("image/x-portable-graymap", "pgm");
        b("image/x-portable-pixmap", "ppm");
        b("image/x-samsung-srw", "srw");
        b("image/x-sony-arw", "arw");
        b("image/x-rgb", "rgb");
        b("image/x-xbitmap", "xbm");
        b("image/x-xpixmap", "xpm");
        b("image/x-xwindowdump", "xwd");
        b("model/iges", "igs");
        b("model/iges", "iges");
        b("model/mesh", "msh");
        b("model/mesh", "mesh");
        b("model/mesh", "silo");
        b("text/calendar", "ics");
        b("text/calendar", "icz");
        b("text/comma-separated-values", "csv");
        b("text/css", "css");
        b("text/html", "htm");
        b("text/html", "html");
        b("text/h323", "323");
        b("text/iuls", "uls");
        b("text/mathml", "mml");
        b("text/plain", "txt");
        b("text/plain", "asc");
        b("text/plain", "text");
        b("text/plain", "diff");
        b("text/plain", "po");
        b("text/richtext", "rtx");
        b("text/rtf", "rtf");
        b("text/text", "phps");
        b("text/tab-separated-values", "tsv");
        b("text/xml", "xml");
        b("text/x-bibtex", "bib");
        b("text/x-boo", "boo");
        b("text/x-c++hdr", "hpp");
        b("text/x-c++hdr", "h++");
        b("text/x-c++hdr", "hxx");
        b("text/x-c++hdr", "hh");
        b("text/x-c++src", "cpp");
        b("text/x-c++src", "c++");
        b("text/x-c++src", "cc");
        b("text/x-c++src", "cxx");
        b("text/x-chdr", "h");
        b("text/x-component", "htc");
        b("text/x-csh", "csh");
        b("text/x-csrc", "c");
        b("text/x-dsrc", "d");
        b("text/x-haskell", "hs");
        b("text/x-java", LogType.JAVA_TYPE);
        b("text/x-literate-haskell", "lhs");
        b("text/x-moc", "moc");
        b("text/x-pascal", "p");
        b("text/x-pascal", "pas");
        b("text/x-pcs-gcd", "gcd");
        b("text/x-setext", "etx");
        b("text/x-tcl", "tcl");
        b("text/x-tex", "tex");
        b("text/x-tex", "ltx");
        b("text/x-tex", "sty");
        b("text/x-tex", "cls");
        b("text/x-vcalendar", "vcs");
        b("text/x-vcard", "vcf");
        b("video/avi", "avi");
        b("video/dl", "dl");
        b("video/dv", "dif");
        b("video/dv", "dv");
        b("video/fli", "fli");
        b("video/m4v", "m4v");
        b("video/mp2ts", "ts");
        b("video/mpeg", "mpeg");
        b("video/mpeg", "mpg");
        b("video/mpeg", "mpe");
        b("video/mp4", "mp4");
        b("video/mpeg", "VOB");
        b("video/quicktime", "qt");
        b("video/quicktime", "mov");
        b("video/vnd.mpegurl", "mxu");
        b("video/webm", "webm");
        b("video/x-la-asf", "lsf");
        b("video/x-la-asf", "lsx");
        b("video/x-matroska", "mkv");
        b("video/x-mng", "mng");
        b("video/x-ms-asf", "asf");
        b("video/x-ms-asf", "asx");
        b("video/x-ms-wm", "wm");
        b("video/x-ms-wmv", "wmv");
        b("video/x-ms-wmx", "wmx");
        b("video/x-ms-wvx", "wvx");
        b("video/x-sgi-movie", "movie");
        b("video/x-webex", "wrf");
        b("x-conference/x-cooltalk", "ice");
        b("x-epoc/x-sisx-app", "sisx");
    }

    private static void b(String str, String str2) {
        if (!a.containsKey(str)) {
            a.put(str, str2);
        }
        if (!b.containsKey(str2)) {
            b.put(str2, str);
        }
    }

    public static String a(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        return (String) b.get(str.toLowerCase(Locale.US));
    }

    public static String b(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        return (String) a.get(str.toLowerCase(Locale.US));
    }

    public static final String a(String str, String str2) {
        return a(str, str2, "", true);
    }

    public static String a(String str, String str2, String str3, boolean z) {
        String a;
        String decode;
        int indexOf;
        String str4;
        String str5 = null;
        if (str2 != null) {
            a = a(str2, z);
            if (!TextUtils.isEmpty(a) && a.contains("attachment")) {
                a = a.substring(a.lastIndexOf("attachment") + 10, a.length());
            }
            if (a != null) {
                int lastIndexOf = a.lastIndexOf(47) + 1;
                if (lastIndexOf > 0) {
                    a = a.substring(lastIndexOf);
                }
            }
        } else {
            a = null;
        }
        if (a == null) {
            decode = Uri.decode(str);
            if (decode != null) {
                int indexOf2 = decode.indexOf(63);
                if (indexOf2 > 0) {
                    decode = decode.substring(0, indexOf2);
                }
                if (!decode.endsWith("/")) {
                    indexOf2 = decode.lastIndexOf(47) + 1;
                    if (indexOf2 > 0) {
                        decode = decode.substring(indexOf2);
                        if (decode == null) {
                            decode = "downloadfile";
                        }
                        indexOf = decode.indexOf(46);
                        if (indexOf >= 0) {
                            if (str3 != null) {
                                str5 = b(str3);
                                if (str5 != null) {
                                    str5 = "." + str5;
                                }
                            }
                            if (str5 == null) {
                                str4 = str5;
                                str5 = decode;
                                decode = str4;
                            } else if (str3 != null || !str3.toLowerCase(Locale.ROOT).startsWith("text/")) {
                                str5 = decode;
                                decode = ".bin";
                            } else if (str3.equalsIgnoreCase("text/html")) {
                                str5 = decode;
                                decode = ".html";
                            } else {
                                str5 = decode;
                                decode = ".txt";
                            }
                        } else {
                            str4 = decode.substring(indexOf);
                            str5 = decode.substring(0, indexOf);
                            decode = str4;
                        }
                        return str5 + decode;
                    }
                }
            }
        }
        decode = a;
        if (decode == null) {
            decode = "downloadfile";
        }
        indexOf = decode.indexOf(46);
        if (indexOf >= 0) {
            str4 = decode.substring(indexOf);
            str5 = decode.substring(0, indexOf);
            decode = str4;
        } else {
            if (str3 != null) {
                str5 = b(str3);
                if (str5 != null) {
                    str5 = "." + str5;
                }
            }
            if (str5 == null) {
                str4 = str5;
                str5 = decode;
                decode = str4;
            } else {
                if (str3 != null) {
                }
                str5 = decode;
                decode = ".bin";
            }
        }
        return str5 + decode;
    }

    public static final String a(String str, String str2, String str3) {
        return a(str, str2, str3, true);
    }

    public static boolean b(String str, String str2, String str3) {
        String a;
        String substring;
        CharSequence charSequence;
        if (str2 != null) {
            a = a(str2, true);
            if (a != null) {
                if (!TextUtils.isEmpty(a) && a.contains("attachment")) {
                    a = a.substring(a.lastIndexOf("attachment") + 10, a.length());
                }
                int lastIndexOf = a.lastIndexOf(47) + 1;
                if (lastIndexOf > 0) {
                    substring = a.substring(lastIndexOf);
                }
            }
            substring = a;
        } else {
            substring = null;
        }
        if (substring == null) {
            a = Uri.decode(str);
            if (a != null) {
                int indexOf = a.indexOf(63);
                if (indexOf > 0) {
                    a = a.substring(0, indexOf);
                }
                if (!a.endsWith("/")) {
                    indexOf = a.lastIndexOf(47) + 1;
                    if (indexOf > 0) {
                        a = a.substring(indexOf);
                        if (a == null) {
                            a = "downloadfile";
                        }
                        if (a.lastIndexOf(46) < 0 || str3 == null) {
                            charSequence = null;
                        } else {
                            charSequence = b(str3);
                            if (charSequence != null) {
                                charSequence = "." + charSequence;
                            }
                        }
                        return TextUtils.isEmpty(charSequence);
                    }
                }
            }
        }
        a = substring;
        if (a == null) {
            a = "downloadfile";
        }
        if (a.lastIndexOf(46) < 0) {
        }
        charSequence = null;
        if (TextUtils.isEmpty(charSequence)) {
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String a(java.lang.String r10, boolean r11) {
        /*
        if (r10 == 0) goto L_0x0008;
    L_0x0002:
        r0 = r10.length();
        if (r0 != 0) goto L_0x000a;
    L_0x0008:
        r0 = 0;
    L_0x0009:
        return r0;
    L_0x000a:
        r0 = new com.ucweb.common.util.l.c;
        r0.<init>();
        r5 = "filename";
        r0 = com.ucweb.common.util.n.a.a(r5);
        r1 = com.ucweb.common.util.n.a.a(r10);
        if (r0 != 0) goto L_0x001d;
    L_0x001b:
        if (r1 == 0) goto L_0x004c;
    L_0x001d:
        r0 = 0;
    L_0x001e:
        r1 = com.ucweb.common.util.n.a.b(r0);
        if (r1 == 0) goto L_0x0009;
    L_0x0024:
        r0 = r0.trim();
        r1 = "&amp;";
        r2 = "&";
        r0 = r0.replaceAll(r1, r2);
        r1 = "&lt;";
        r2 = "<";
        r0 = r0.replaceAll(r1, r2);
        r1 = "&quot;";
        r2 = "\"";
        r0 = r0.replaceAll(r1, r2);
        r1 = "&nbsp;";
        r2 = " ";
        r0 = r0.replaceAll(r1, r2);
        com.ucweb.common.util.k.a.f(r0);
        goto L_0x0009;
    L_0x004c:
        r6 = com.ucweb.common.util.n.a.e(r10);
        r0 = com.ucweb.common.util.n.a.a(r6);
        if (r0 == 0) goto L_0x0061;
    L_0x0056:
        r0 = 0;
    L_0x0057:
        if (r0 == 0) goto L_0x005f;
    L_0x0059:
        r1 = r0.size();
        if (r1 != 0) goto L_0x00b6;
    L_0x005f:
        r0 = 0;
        goto L_0x001e;
    L_0x0061:
        r1 = 0;
        r2 = 0;
        r4 = new java.util.ArrayList;
        r4.<init>();
        r0 = 0;
    L_0x0069:
        r3 = r6.length();
        if (r0 >= r3) goto L_0x009d;
    L_0x006f:
        r3 = r6.charAt(r0);
        r7 = 39;
        if (r3 == r7) goto L_0x007b;
    L_0x0077:
        r7 = 34;
        if (r3 != r7) goto L_0x0083;
    L_0x007b:
        if (r2 != r3) goto L_0x0081;
    L_0x007d:
        r2 = 0;
    L_0x007e:
        r0 = r0 + 1;
        goto L_0x0069;
    L_0x0081:
        r2 = r3;
        goto L_0x007e;
    L_0x0083:
        r7 = 59;
        if (r3 != r7) goto L_0x007e;
    L_0x0087:
        if (r2 != 0) goto L_0x007e;
    L_0x0089:
        r1 = r6.substring(r1, r0);
        r3 = com.ucweb.common.util.n.a.e(r1);
        r1 = r0 + 1;
        r7 = com.ucweb.common.util.n.a.b(r3);
        if (r7 == 0) goto L_0x007e;
    L_0x0099:
        r4.add(r3);
        goto L_0x007e;
    L_0x009d:
        r0 = r6.length();
        if (r1 >= r0) goto L_0x00b4;
    L_0x00a3:
        r0 = r6.substring(r1);
        r0 = com.ucweb.common.util.n.a.e(r0);
        r1 = com.ucweb.common.util.n.a.b(r0);
        if (r1 == 0) goto L_0x00b4;
    L_0x00b1:
        r4.add(r0);
    L_0x00b4:
        r0 = r4;
        goto L_0x0057;
    L_0x00b6:
        r6 = new java.util.ArrayList;
        r6.<init>();
        r3 = r0.iterator();
    L_0x00bf:
        r0 = r3.hasNext();
        if (r0 == 0) goto L_0x0270;
    L_0x00c5:
        r0 = r3.next();
        r0 = (java.lang.String) r0;
        r1 = com.ucweb.common.util.n.a.a(r0);
        if (r1 != 0) goto L_0x026d;
    L_0x00d1:
        r1 = 61;
        r4 = r0.indexOf(r1);
        r1 = -1;
        if (r4 == r1) goto L_0x026d;
    L_0x00da:
        r1 = 0;
        r1 = r0.substring(r1, r4);
        r1 = com.ucweb.common.util.n.a.e(r1);
        r2 = com.ucweb.common.util.n.a.a(r1);
        if (r2 != 0) goto L_0x026d;
    L_0x00e9:
        r2 = com.ucweb.common.util.n.a.a(r1);
        if (r2 != 0) goto L_0x01b0;
    L_0x00ef:
        r2 = new com.ucweb.common.util.l.b;
        r7 = 0;
        r2.<init>();
        r7 = 42;
        r7 = r1.indexOf(r7);
        r8 = -1;
        if (r7 != r8) goto L_0x0160;
    L_0x00fe:
        r1 = r5.equalsIgnoreCase(r1);
        if (r1 == 0) goto L_0x01b0;
    L_0x0104:
        r1 = 1;
        r2.a = r1;
        r1 = 0;
        r2.b = r1;
    L_0x010a:
        if (r2 == 0) goto L_0x026d;
    L_0x010c:
        r1 = 0;
        r7 = r4 + 1;
        r8 = r0.length();
        if (r7 >= r8) goto L_0x0305;
    L_0x0115:
        r1 = r4 + 1;
        r0 = r0.substring(r1);
        r0 = com.ucweb.common.util.n.a.e(r0);
    L_0x011f:
        r1 = com.ucweb.common.util.n.a.b(r0);
        if (r1 == 0) goto L_0x0152;
    L_0x0125:
        r1 = 0;
        r1 = r0.charAt(r1);
        r4 = 34;
        if (r1 != r4) goto L_0x0152;
    L_0x012e:
        r1 = r0.length();
        r1 = r1 + -1;
        r1 = r0.charAt(r1);
        r4 = 34;
        if (r1 != r4) goto L_0x0152;
    L_0x013c:
        r1 = r0.length();
        r4 = 2;
        if (r1 <= r4) goto L_0x026d;
    L_0x0143:
        r1 = 1;
        r4 = r0.length();
        r4 = r4 + -1;
        r0 = r0.substring(r1, r4);
        r0 = com.ucweb.common.util.n.a.e(r0);
    L_0x0152:
        r1 = com.ucweb.common.util.n.a.a(r0);
        if (r1 == 0) goto L_0x01c1;
    L_0x0158:
        r0 = r2;
    L_0x0159:
        if (r0 == 0) goto L_0x00bf;
    L_0x015b:
        r6.add(r0);
        goto L_0x00bf;
    L_0x0160:
        r8 = 0;
        r8 = r1.substring(r8, r7);
        r8 = com.ucweb.common.util.n.a.e(r8);
        r8 = r5.equalsIgnoreCase(r8);
        if (r8 == 0) goto L_0x01b0;
    L_0x016f:
        r8 = r1.length();
        r8 = r8 + -1;
        if (r7 != r8) goto L_0x017e;
    L_0x0177:
        r1 = 1;
        r2.a = r1;
        r1 = 1;
        r2.b = r1;
        goto L_0x010a;
    L_0x017e:
        r8 = r1.length();
        r8 = r8 + -1;
        r8 = r1.charAt(r8);
        r9 = 42;
        if (r8 != r9) goto L_0x01b3;
    L_0x018c:
        r7 = r7 + 1;
        r8 = r1.length();
        r8 = r8 + -1;
        r1 = r1.substring(r7, r8);
        r1 = com.ucweb.common.util.n.a.e(r1);
        r7 = 1;
        r2.b = r7;
    L_0x019f:
        r7 = com.ucweb.common.util.n.a.a(r1);
        if (r7 != 0) goto L_0x01b0;
    L_0x01a5:
        r7 = -1;
        r1 = com.ucweb.common.util.n.a.a(r1, r7);
        r2.a = r1;
        r1 = r2.a;
        if (r1 >= 0) goto L_0x010a;
    L_0x01b0:
        r2 = 0;
        goto L_0x010a;
    L_0x01b3:
        r7 = r7 + 1;
        r1 = r1.substring(r7);
        r1 = com.ucweb.common.util.n.a.e(r1);
        r7 = 0;
        r2.b = r7;
        goto L_0x019f;
    L_0x01c1:
        if (r2 != 0) goto L_0x01c8;
    L_0x01c3:
        r0 = 0;
    L_0x01c4:
        if (r0 == 0) goto L_0x026d;
    L_0x01c6:
        r0 = r2;
        goto L_0x0159;
    L_0x01c8:
        r1 = new com.ucweb.common.util.l.a;
        r4 = 0;
        r1.<init>();
        r4 = r2.a;
        r7 = 1;
        if (r4 > r7) goto L_0x01d9;
    L_0x01d3:
        r4 = com.ucweb.common.util.n.a.a(r0);
        if (r4 == 0) goto L_0x01e0;
    L_0x01d9:
        r1.c = r0;
        r2.a(r1);
        r0 = 1;
        goto L_0x01c4;
    L_0x01e0:
        r4 = "=?";
        r4 = r0.startsWith(r4);
        if (r4 == 0) goto L_0x0201;
    L_0x01e8:
        r4 = "?=";
        r4 = r0.endsWith(r4);
        if (r4 == 0) goto L_0x0201;
    L_0x01f0:
        r1 = r0.length();
        r4 = 4;
        if (r1 >= r4) goto L_0x01f9;
    L_0x01f7:
        r0 = 0;
        goto L_0x01c4;
    L_0x01f9:
        r1 = 1;
        r2.b = r1;
        r0 = com.ucweb.common.util.l.c.a(r2, r0);
        goto L_0x01c4;
    L_0x0201:
        r4 = r2.b;
        if (r4 == 0) goto L_0x0265;
    L_0x0205:
        r4 = 39;
        r4 = r0.indexOf(r4);
        r7 = -1;
        if (r4 == r7) goto L_0x0265;
    L_0x020e:
        r7 = r0.length();
        r7 = r7 + -1;
        if (r4 != r7) goto L_0x0218;
    L_0x0216:
        r0 = 0;
        goto L_0x01c4;
    L_0x0218:
        r7 = 0;
        r7 = r0.substring(r7, r4);
        r7 = com.ucweb.common.util.n.a.e(r7);
        r1.a = r7;
        r4 = r4 + 1;
        r0 = r0.substring(r4);
        r0 = com.ucweb.common.util.n.a.e(r0);
        r4 = com.ucweb.common.util.n.a.a(r0);
        if (r4 == 0) goto L_0x0235;
    L_0x0233:
        r0 = 0;
        goto L_0x01c4;
    L_0x0235:
        r4 = 39;
        r4 = r0.indexOf(r4);
        r7 = -1;
        if (r4 != r7) goto L_0x0240;
    L_0x023e:
        r0 = 0;
        goto L_0x01c4;
    L_0x0240:
        r7 = 0;
        r7 = r0.substring(r7, r4);
        r7 = com.ucweb.common.util.n.a.e(r7);
        r1.b = r7;
        r7 = r0.length();
        r7 = r7 + -1;
        if (r4 >= r7) goto L_0x0262;
    L_0x0253:
        r4 = r4 + 1;
        r0 = r0.substring(r4);
        r0 = com.ucweb.common.util.n.a.e(r0);
        r1.c = r0;
        r2.a(r1);
    L_0x0262:
        r0 = 1;
        goto L_0x01c4;
    L_0x0265:
        r1.c = r0;
        r2.a(r1);
        r0 = 1;
        goto L_0x01c4;
    L_0x026d:
        r0 = 0;
        goto L_0x0159;
    L_0x0270:
        r0 = r6.size();
        if (r0 != 0) goto L_0x0279;
    L_0x0276:
        r0 = 0;
        goto L_0x001e;
    L_0x0279:
        java.util.Collections.sort(r6);
        r4 = 0;
        r3 = 0;
        r2 = 0;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = r6.iterator();
    L_0x0288:
        r0 = r6.hasNext();
        if (r0 == 0) goto L_0x02ff;
    L_0x028e:
        r0 = r6.next();
        r1 = r0;
        r1 = (com.ucweb.common.util.l.b) r1;
        if (r1 == 0) goto L_0x0288;
    L_0x0297:
        r0 = r1.d;
        if (r0 == 0) goto L_0x0288;
    L_0x029b:
        r7 = r0.size();
        if (r7 == 0) goto L_0x0288;
    L_0x02a1:
        r7 = r0.iterator();
    L_0x02a5:
        r0 = r7.hasNext();
        if (r0 == 0) goto L_0x0288;
    L_0x02ab:
        r0 = r7.next();
        r0 = (com.ucweb.common.util.l.a) r0;
        if (r0 == 0) goto L_0x02a5;
    L_0x02b3:
        if (r4 != 0) goto L_0x02ba;
    L_0x02b5:
        r4 = 1;
        r3 = r0.a;
        r2 = r0.b;
    L_0x02ba:
        r8 = r0.c;
        r8 = com.ucweb.common.util.n.a.a(r8);
        if (r8 != 0) goto L_0x02a5;
    L_0x02c2:
        r8 = r1.c;
        if (r8 == 0) goto L_0x02d9;
    L_0x02c6:
        if (r11 == 0) goto L_0x02d6;
    L_0x02c8:
        r8 = r0.c;
        r9 = r0.a;
        r0 = r0.b;
        r0 = com.ucweb.common.util.l.c.a(r8, r9, r0);
    L_0x02d2:
        r5.append(r0);
        goto L_0x02a5;
    L_0x02d6:
        r0 = r0.c;
        goto L_0x02d2;
    L_0x02d9:
        r8 = r1.b;
        if (r8 == 0) goto L_0x02ec;
    L_0x02dd:
        if (r11 == 0) goto L_0x02e9;
    L_0x02df:
        r0 = r0.c;
        r0 = com.ucweb.common.util.l.c.a(r0, r3, r2);
    L_0x02e5:
        r5.append(r0);
        goto L_0x02a5;
    L_0x02e9:
        r0 = r0.c;
        goto L_0x02e5;
    L_0x02ec:
        if (r11 == 0) goto L_0x02fc;
    L_0x02ee:
        r0 = r0.c;
        r8 = "";
        r9 = "";
        r0 = com.ucweb.common.util.l.c.a(r0, r8, r9);
    L_0x02f8:
        r5.append(r0);
        goto L_0x02a5;
    L_0x02fc:
        r0 = r0.c;
        goto L_0x02f8;
    L_0x02ff:
        r0 = r5.toString();
        goto L_0x001e;
    L_0x0305:
        r0 = r1;
        goto L_0x011f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ucweb.common.util.l.d.a(java.lang.String, boolean):java.lang.String");
    }

    public static String c(String str) {
        if (!TextUtils.isEmpty(str)) {
            int lastIndexOf = str.lastIndexOf(35);
            if (lastIndexOf > 0) {
                str = str.substring(0, lastIndexOf);
            }
            lastIndexOf = str.lastIndexOf(63);
            if (lastIndexOf > 0) {
                str = str.substring(0, lastIndexOf);
            }
            lastIndexOf = str.lastIndexOf(47);
            if (lastIndexOf >= 0) {
                str = str.substring(lastIndexOf + 1);
            }
            if (!str.isEmpty() && Pattern.matches("[a-zA-Z_0-9\\.\\-\\(\\)\\%]+", str)) {
                lastIndexOf = str.lastIndexOf(46);
                if (lastIndexOf >= 0) {
                    return str.substring(lastIndexOf + 1);
                }
            }
        }
        return "";
    }

    public static String d(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str.substring(str.lastIndexOf(".") + 1, str.length());
    }
}
