package com.ucpro.a;

import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.uc.webview.browser.interfaces.SettingKeys;
import com.ucpro.a.c.j;
import com.ucpro.a.c.k;
import com.ucpro.a.c.p;
import com.ucpro.a.d.e;
import com.ucpro.business.stat.f;
import com.ucpro.feature.e.b;
import com.ucpro.model.a.a;
import com.ucweb.common.util.c;
import com.ucweb.common.util.d;
import com.ucweb.common.util.h.m;

/* compiled from: ProGuard */
public final class ac {
    private static boolean b = false;
    private static boolean c = false;
    public String a;

    private ac() {
    }

    public static void a() {
        if (!b) {
            g.a(d.a());
            b = true;
        }
    }

    public static ac b() {
        c.a(b, "be sure to call init() first");
        return ad.a;
    }

    public final synchronized void c() {
        if (!c) {
            String str;
            c = true;
            k.a;
            p.a(SettingKeys.EnableHUC, true);
            k.a;
            p.a(SettingKeys.PageEnableAdBlock, true);
            k.a;
            p.a(SettingKeys.AdvancedEnableJavaScript, true);
            k.a;
            p.a(SettingKeys.PageIsTouchScrollMode, false);
            k.a;
            p.a(SettingKeys.PageEnableSmartReader, a.a.a("setting_smart_reader", false));
            k.a;
            p.a(SettingKeys.NetworkUcproxyWifi, a.a.a("setting_webcore_network_proxy", true));
            k.a;
            p.a(SettingKeys.NetworkUcproxyMobileNetwork, a.a.a("setting_webcore_network_proxy", true));
            k.a;
            p.a(SettingKeys.RecordIsNoFootmark, b.a.a);
            k.a;
            p.a(SettingKeys.UIIsNightMode, a.a.a("setting_night_mode", false));
            k.a;
            p.a(SettingKeys.NetworkUseUcproxySecurity, true);
            k.a;
            p.a(SettingKeys.UIFullScreenMode, false);
            k.a;
            p.a(SettingKeys.XUASwitch, true);
            k.a;
            p.a(SettingKeys.PageEnableIntelligentLayout, true);
            k.a;
            p.a(SettingKeys.NetworkEnableTZip, true);
            k.a;
            p.a(SettingKeys.OFFNET_ON, false);
            k.a;
            p.a(SettingKeys.BGTimer, false);
            k.a;
            p.a(SettingKeys.UseWideViewport, true);
            k.a;
            p.a(SettingKeys.DisplayZoomControls, false);
            k.a;
            p.a(SettingKeys.SupportZoom, true);
            k.a;
            p.a(SettingKeys.BuiltInZoomControls, true);
            k.a;
            p.a(SettingKeys.LoadWithOverviewMode, true);
            k.a;
            p.a(SettingKeys.WideViewportQuirk, false);
            k.a;
            p.a(SettingKeys.JavaScriptCanOpenWindowsAutomatically, true);
            k.a;
            p.a(SettingKeys.SupportMultipleWindows, true);
            k.a;
            p.a("SDKUCParam", false);
            k.a;
            j.a(a.a.a("setting_enable_smart_no_image", false));
            k.a;
            p.a("enable_smart_pre_read", true);
            j.a(j.d(true));
            k.a;
            j.b(a.a.a("setting_enable_adapt_screen", false));
            k.a;
            p.a(SettingKeys.UBIMiScreenHeight, com.ucpro.base.system.b.a.d());
            k.a;
            p.a(SettingKeys.UBIMiScreenWidth, com.ucpro.base.system.b.a.c());
            k.a;
            p.a(SettingKeys.PageColorTheme, 0);
            k.a;
            p.a(SettingKeys.PageLinkOpenPolicy, 0);
            k.a;
            p.a(SettingKeys.KernelType, 4);
            k.a;
            p.a(SettingKeys.PageDefaultEncoding, 1);
            k.a;
            p.a(SettingKeys.PageFormSave, 0);
            k.a;
            p.a(SettingKeys.NetworkUserAgentType, a.a.a("setting_select_ua_type", 1));
            k.a;
            p.a(SettingKeys.PageUcCustomFontSize, a.a.a("setting_font_size", 100));
            k.a;
            p.a("NetworkProxyRules", 1);
            k.a;
            p.a(SettingKeys.UBIMiExStorageDir, com.ucpro.c.c.c().getPath());
            k.a;
            p.a(SettingKeys.UBISiPrd, "ucpro");
            k.a;
            p.a(SettingKeys.PrereadLanguage, "#regex#^\\s?下\\s?一?\\s?页\\s?>{0,2}$#key#页#len#9#regex#^\\s?下\\s?一?\\s?张\\s?>{0,2}$#key#张#len#9#regex#^\\s?下\\s?一?\\s?图\\s?>{0,2}$#key#图#len#9#regex#^\\s?下\\s?一?\\s?章\\s?>{0,2}$#key#章#len#9#regex#^\\s?下\\s?一?\\s?节\\s?>{0,2}$#key#节#len#9#regex#^\\s?下\\s?一?\\s?回\\s?>{0,2}$#key#回#len#9#regex#^\\s?下\\s?一?\\s?条\\s?>{0,2}$#key#条#len#9#regex#^\\[?>{1,2}\\]?$#key#>#len#4#regex#^»$#key#»#len#1");
            k.a;
            p.a(SettingKeys.UBISiPlatform, "android");
            k.a;
            p.a(SettingKeys.UBIMiMac, com.ucpro.base.system.b.a.j());
            k.a;
            p.a(SettingKeys.UBISiBuildSeq, "180123054500");
            k.a;
            p.a(SettingKeys.UBISiPver, "3.1");
            k.a;
            p.a(SettingKeys.NetworkUploadAddr, com.ucpro.business.e.g.d.a().a.a("upload_srv_url", "http://up1.tj.u2.ucweb.com:8011/upload.php"));
            k.a;
            p.a(SettingKeys.UBISiBrandId, com.ucpro.c.a.a());
            k.a;
            p.a(SettingKeys.UBIMiImei, com.ucpro.base.system.b.a.e());
            k.a;
            p.a(SettingKeys.UBISiProfileId, "3300");
            k.a;
            p.a(SettingKeys.UBISiLang, com.ucpro.c.d.c());
            k.a;
            p.a(SettingKeys.UBIMiModel, Build.MODEL);
            k.a;
            p.a(SettingKeys.NetworkUcproxyAddr, "uc9.ucweb.com");
            k.a;
            p.a(SettingKeys.NetworkWifiFoxyServerAddr, com.ucpro.business.e.g.d.a().d());
            k.a;
            p.a(SettingKeys.UBISiVersion, "2.4.1.985");
            k.a;
            p.a(SettingKeys.UBIUtdId, f.b());
            k.a;
            p.a(SettingKeys.PageOnSDcardPath, com.ucpro.c.c.d().getAbsolutePath());
            k.a;
            p.a(SettingKeys.PageOnROMPath, d.a().getApplicationInfo().dataDir);
            k.a;
            p.a(SettingKeys.UBIMiCPUArchInfo, com.ucpro.base.system.b.a.q());
            k.a;
            p.a(SettingKeys.UBIMiAndroidOS, com.ucpro.base.system.b.a.r());
            k.a;
            p.a(SettingKeys.UBISn, com.ucpro.business.e.e.b.b().d());
            k.a;
            p.a(SettingKeys.UBICpParam, com.ucpro.business.e.e.b.b().a());
            k.a;
            p.a(SettingKeys.UBIDn, com.ucpro.business.e.e.b.b().c());
            k.a;
            if (TextUtils.isEmpty(com.ucpro.c.a.e())) {
                str = "WWW";
            } else {
                str = com.ucpro.c.a.e();
            }
            p.a(SettingKeys.UBISiBmode, str);
            k.a;
            if (TextUtils.isEmpty(com.ucpro.c.a.d())) {
                str = "UC";
            } else {
                str = com.ucpro.c.a.d();
            }
            p.a(SettingKeys.UBISiBtype, str);
            k.a;
            p.a(SettingKeys.UBIEnUtdId, f.c());
            k.a;
            p.a(SettingKeys.UBIMiAeUt, f.c());
            g a = g.a();
            com.ucpro.a.a.b a2 = com.ucpro.feature.h.b.a;
            if (a2 != null) {
                a.d = a2;
            }
            a.e = new com.ucpro.services.location.f();
            k.a.c = new ae();
            a.g = new x();
            a.f = new ax();
            a.h = new e(new y());
            a.b().c = com.ucpro.b.d.a.c();
            if (a.a != null) {
                f fVar = a.a;
                switch (f.a) {
                    case 1:
                        fVar.a();
                        break;
                    case 2:
                        if (fVar.c != null) {
                            fVar.c.d();
                            break;
                        }
                        break;
                    case 4:
                        if (fVar.c != null) {
                            m.a(2, new i(fVar));
                            break;
                        }
                        break;
                    case 8:
                        if (fVar.c != null) {
                            fVar.c.a(f.b);
                            break;
                        }
                        break;
                }
            }
            a.h.a("start_load", new String[0]);
            a.b().a = SystemClock.uptimeMillis();
            a.a().a(k.a.d);
        }
    }
}
