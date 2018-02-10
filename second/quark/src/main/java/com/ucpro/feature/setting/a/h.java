package com.ucpro.feature.setting.a;

import com.uc.webview.browser.interfaces.SettingKeys;

/* compiled from: ProGuard */
public final class h {
    public static final int A = a();
    public static final int B = a();
    public static final int C = a();
    public static final int D = a();
    public static final int E = a();
    public static final int F = a();
    public static final int G = a();
    public static final int H = a();
    public static final int I = a();
    public static final int J = a();
    public static final int K = a();
    public static final int L = a();
    public static final int M = a();
    public static final int N = a();
    public static final int O = a();
    public static final int P = a();
    public static final int Q = a();
    public static final int R = a();
    public static final int S = a();
    public static final int T = a();
    public static final int U = a();
    public static final int V = a();
    public static final int W = a();
    private static int X = 1;
    public static final int a = a();
    public static final int b = a();
    public static final int c = a();
    public static final int d = a();
    public static final int e = a();
    public static final int f = a();
    public static final int g = a();
    public static final int h = a();
    public static final int i = a();
    public static final int j = a();
    public static final int k = a();
    public static final int l = a();
    public static final int m = a();
    public static final int n = a();
    public static final int o = a();
    public static final int p = a();
    public static final int q = a();
    public static final int r = a();
    public static final int s = a();
    public static final int t = a();
    public static final int u = a();
    public static final int v = a();
    public static final int w = a();
    public static final int x = a();
    public static final int y = a();
    public static final int z = a();

    private static int a() {
        int i = X;
        X = i + 1;
        return i;
    }

    public static String a(int i) {
        String str = null;
        if (w == i) {
            str = "show_status_bar";
        } else if (x == i) {
            str = "crash_recovery";
        } else if (b == i) {
            str = "default_browser";
        } else if (c == i) {
            str = "clear_cache";
        } else if (d == i) {
            str = "about_browser";
        } else if (e == i) {
            str = "quark_lab";
        } else if (g == i) {
            str = "feedback";
        } else if (h == i) {
            str = "wipe_input_and_history";
        } else if (i == i) {
            str = "wipe_username_and_password";
        } else if (j == i) {
            str = "wipe_cookies";
        } else if (k == i) {
            str = "wipe_history_record";
        } else if (l == i) {
            str = "wipe_cached_file";
        } else if (m == i) {
            str = "version_name_refresh";
        } else if (p == i) {
            str = "user_agreement";
        } else if (q == i) {
            str = "privacy_agreement";
        } else if (r == i) {
            str = "official_forum";
        } else if (t == i) {
            str = "about_logo";
        } else if (y == i) {
            str = "setting_common";
        } else if (z == i) {
            str = "search_engine";
        } else if (u == i) {
            str = "product_name";
        } else if (A == i) {
            str = "select_ua";
        } else if (B == i) {
            str = "develop_option";
        } else if (v == i) {
            str = "night_mode";
        } else if (C == i) {
            str = "force_fetch_us";
        } else if (D == i) {
            str = "show_cd_param";
        } else if (s == i) {
            str = "webcore_info";
        } else if (E == i) {
            str = "network_proxy";
        } else if (F == i) {
            str = "setting_browse";
        } else if (G == i) {
            str = "smart_no_image";
        } else if (H == i) {
            str = "font_size";
        } else if (I == i) {
            str = "smart_reader";
        } else if (K == i) {
            str = "cloud_sync";
        } else if (L == i) {
            str = "download";
        } else if (M == i) {
            str = SettingKeys.NetworkAdblockUpdateRule;
        } else if (N == i) {
            str = "adblock_rule_switcher";
        } else if (O == i) {
            str = "adblock_rule_list_title";
        } else if (n == i) {
            str = "about_share";
        } else if (J == i) {
            str = "adapt_screen";
        } else if (Q == i) {
            str = "toolbar_style";
        } else if (R == i) {
            str = "quest_survey";
        } else if (S == i) {
            str = "enable_wallpaper";
        } else if (T == i) {
            str = "enable_logo";
        } else if (U == i) {
            str = "select_from_album";
        } else if (V == i) {
            str = "official_wallpaper";
        } else if (W == i) {
            str = "share_wallpaper";
        }
        new StringBuilder("getSettingItemKeyString\nsettingItemKey: ").append(String.valueOf(i)).append("\nkeyString: ").append(str);
        return str;
    }
}
