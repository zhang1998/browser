package com.uc.quark.a;

import android.net.Uri;
import com.uc.crashsdk.export.LogType;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* compiled from: ProGuard */
public final class e {
    private static final Map<String, String> a = new HashMap();
    private static final Map<String, String> b = new HashMap();
    private static final String[] c = new String[]{"/", "\\", "?", "*", ":", "<", ">", "|", "\""};

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

    public static String b(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        return (String) a.get(str.toLowerCase(Locale.US));
    }

    public static final String a(String str, String str2) {
        int indexOf;
        String str3;
        String str4 = null;
        String decode = Uri.decode(str);
        if (decode != null) {
            indexOf = decode.indexOf(63);
            if (indexOf > 0) {
                decode = decode.substring(0, indexOf);
            }
            if (!decode.endsWith("/")) {
                indexOf = decode.lastIndexOf(47) + 1;
                if (indexOf > 0) {
                    decode = decode.substring(indexOf);
                    if (decode == null) {
                        decode = "downloadfile";
                    }
                    indexOf = decode.indexOf(46);
                    if (indexOf >= 0) {
                        if (str2 != null) {
                            str4 = b(str2);
                            if (str4 != null) {
                                str4 = "." + str4;
                            }
                        }
                        if (str4 == null) {
                            str3 = str4;
                            str4 = decode;
                            decode = str3;
                        } else if (str2 != null || !str2.toLowerCase(Locale.ROOT).startsWith("text/")) {
                            str4 = decode;
                            decode = ".bin";
                        } else if (str2.equalsIgnoreCase("text/html")) {
                            str4 = decode;
                            decode = ".html";
                        } else {
                            str4 = decode;
                            decode = ".txt";
                        }
                    } else {
                        str3 = decode.substring(indexOf);
                        str4 = decode.substring(0, indexOf);
                        decode = str3;
                    }
                    return str4 + decode;
                }
            }
        }
        decode = null;
        if (decode == null) {
            decode = "downloadfile";
        }
        indexOf = decode.indexOf(46);
        if (indexOf >= 0) {
            str3 = decode.substring(indexOf);
            str4 = decode.substring(0, indexOf);
            decode = str3;
        } else {
            if (str2 != null) {
                str4 = b(str2);
                if (str4 != null) {
                    str4 = "." + str4;
                }
            }
            if (str4 == null) {
                str3 = str4;
                str4 = decode;
                decode = str3;
            } else {
                if (str2 != null) {
                }
                str4 = decode;
                decode = ".bin";
            }
        }
        return str4 + decode;
    }

    public static boolean a(String str) {
        String str2;
        if (str == null || str.isEmpty()) {
            str2 = null;
        } else {
            str2 = (String) b.get(str.toLowerCase(Locale.US).trim());
        }
        if (str2 != null) {
            return true;
        }
        return false;
    }
}
