package com.uc.base.net.a;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: ProGuard */
public final class a {
    public static final Pattern c = Pattern.compile(String.format("^((?:(?!-)[%1$s-]++(?<!-)|[%1$s]++)\\.)++%2$s$", new Object[]{"a-zA-Z0-9 -퟿豈-﷏ﷰ-￯", "(([a-zA-Z]{2,}+)|(дети|мон|москва|онлайн|орг|рф|сайт|срб|укр|қаз|الاردن|الجزائر|السعودية|المغرب|امارات|ایران|بازار|بھارت|تونس|سورية|شبكة|عمان|فلسطين|قطر|مصر|مليسيا|موقع|भारत|संगठन|ভারত|ਭਾਰਤ|ભારત|இந்தியா|இலங்கை|சிங்கப்பூர்|భారత్|ලංකා|ไทย|みんな|世界|中信|中国|中國|中文网|企业|佛山|公司|公益|台湾|台灣|商城|商标|在线|广东|我爱你|手机|政务|新加坡|机构|游戏|移动|组织机构|网址|网络|集团|香港|삼성|한국|xn\\-\\-1qqw23a|xn\\-\\-3bst00m|xn\\-\\-3ds443g|xn\\-\\-3e0b707e|xn\\-\\-45brj9c|xn\\-\\-4gbrim|xn\\-\\-55qw42g|xn\\-\\-55qx5d|xn\\-\\-6frz82g|xn\\-\\-6qq986b3xl|xn\\-\\-80adxhks|xn\\-\\-80ao21a|xn\\-\\-80asehdb|xn\\-\\-80aswg|xn\\-\\-90a3ac|xn\\-\\-c1avg|xn\\-\\-cg4bki|xn\\-\\-clchc0ea0b2g2a9gcd|xn\\-\\-czr694b|xn\\-\\-czru2d|xn\\-\\-d1acj3b|xn\\-\\-fiq228c5hs|xn\\-\\-fiq64b|xn\\-\\-fiqs8s|xn\\-\\-fiqz9s|xn\\-\\-fpcrj9c3d|xn\\-\\-fzc2c9e2c|xn\\-\\-gecrj9c|xn\\-\\-h2brj9c|xn\\-\\-i1b6b1a6a2e|xn\\-\\-io0a7i|xn\\-\\-j1amh|xn\\-\\-j6w193g|xn\\-\\-kprw13d|xn\\-\\-kpry57d|xn\\-\\-kput3i|xn\\-\\-l1acc|xn\\-\\-lgbbat1ad8j|xn\\-\\-mgb9awbf|xn\\-\\-mgba3a4f16a|xn\\-\\-mgbaam7a8h|xn\\-\\-mgbab2bd|xn\\-\\-mgbayh7gpa|xn\\-\\-mgbbh1a71e|xn\\-\\-mgbc0a9azcg|xn\\-\\-mgberp4a5d4ar|xn\\-\\-mgbx4cd0ab|xn\\-\\-ngbc5azd|xn\\-\\-nqv7f|xn\\-\\-nqv7fs00ema|xn\\-\\-o3cw4h|xn\\-\\-ogbpf8fl|xn\\-\\-p1ai|xn\\-\\-pgbs0dh|xn\\-\\-q9jyb4c|xn\\-\\-rhqv96g|xn\\-\\-s9brj9c|xn\\-\\-ses554g|xn\\-\\-unup4y|xn\\-\\-vhquv|xn\\-\\-wgbh1c|xn\\-\\-wgbl6a|xn\\-\\-xhq521b|xn\\-\\-xkc2al3hye2a|xn\\-\\-xkc2dl3a5ee0h|xn\\-\\-yfro4i67o|xn\\-\\-ygbi2ammx|xn\\-\\-zfr164b))"}));
    public static final Pattern d = Pattern.compile("^((25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9]))$");
    public static final Pattern e = Pattern.compile("^((http|https|ftp|file|content|data|wtai|ed2k|flashget|thunder|market|uc)\\:\\/\\/)", 2);
    public static final Pattern f = Pattern.compile("^((sms|smsto|mms|mmsto|tel|about|ucd|ext)\\:)", 2);
    public static final Pattern g = Pattern.compile("(?:(http|https|file|.*)\\:\\/\\/)?(?:([-A-Za-z0-9$_.+!*'(),;?&=]+(?:\\:[-A-Za-z0-9$_.+!*'(),;?&=]+)?)@)?([a-zA-Z0-9 -퟿豈-﷏ﷰ-￯%_-][a-zA-Z0-9 -퟿豈-﷏ﷰ-￯%_\\.-]*|\\[[0-9a-fA-F:\\.]+\\])?(?:\\:([0-9]*))?(\\/?[^#]*)?.*", 2);
    public boolean a;
    public String b;
    private String h;
    private String i;
    private int j;
    private String k;
    private String l;

    public a(String str) throws IllegalArgumentException {
        if (str == null) {
            throw new NullPointerException();
        }
        CharSequence replaceAll = str.replace('。', '.').replaceAll("\\.{2,}", "\\.");
        this.i = "";
        this.b = "";
        this.j = -1;
        this.k = "/";
        this.l = "";
        if (c(replaceAll)) {
            this.a = true;
            this.h = replaceAll;
        }
        Matcher matcher = g.matcher(replaceAll);
        if (matcher.matches()) {
            String group = matcher.group(1);
            if (group != null) {
                this.i = group.toLowerCase();
            }
            group = matcher.group(2);
            if (group != null) {
                this.l = group;
            }
            group = matcher.group(3);
            if (group != null) {
                this.b = group;
            }
            group = matcher.group(4);
            if (group != null && group.length() > 0) {
                try {
                    this.j = Integer.parseInt(group);
                    if (this.j < 0) {
                        throw new IllegalArgumentException("Bad port");
                    }
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Bad port");
                }
            }
            String group2 = matcher.group(5);
            if (group2 != null && group2.length() > 0) {
                if (group2.charAt(0) == '/') {
                    this.k = group2;
                } else {
                    this.k = "/" + group2;
                }
            }
            if (this.j == 443 && this.i.equals("")) {
                this.i = "https";
            } else if (this.j == -1) {
                if (this.i.equals("https")) {
                    this.j = 443;
                } else {
                    this.j = 80;
                }
            }
            if (this.i.equals("")) {
                this.i = "http";
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Bad address");
    }

    public static boolean a(String str) {
        try {
            if (d.matcher(str).find()) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public static boolean b(String str) {
        try {
            if (c.matcher(str).find()) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    private static boolean c(String str) {
        try {
            if (e.matcher(str).find() || f.matcher(str).find()) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public final String toString() {
        if (this.a) {
            return this.h;
        }
        String str = this.i;
        String str2 = this.l;
        String str3 = this.b;
        int i = this.j;
        String str4 = this.k;
        String str5 = "";
        if ((i != 443 && str.equals("https")) || (i != 80 && str.equals("http"))) {
            str5 = ":" + Integer.toString(i);
        }
        if (str2.length() > 0) {
            str2 = str2 + "@";
        }
        return str + "://" + str2 + str3 + str5 + str4;
    }
}
