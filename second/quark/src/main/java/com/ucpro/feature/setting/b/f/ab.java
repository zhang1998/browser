package com.ucpro.feature.setting.b.f;

import com.uc.quark.x;
import com.ucpro.feature.setting.b.b.a;
import com.ucpro.feature.setting.b.b.b;
import com.ucpro.feature.video.cache.b.d;

/* compiled from: ProGuard */
public final class ab {
    private static bl a = new bl();

    public static a a() {
        a aVar = new a("M3U8测试", com.ucpro.feature.setting.b.a.a.b);
        x.a(d.a());
        aVar.a(new b("M3U8展示当前Model层数据全清除", com.ucpro.feature.setting.b.a.a.a, new bm()));
        aVar.a(new b("M3U8展示当前Model层数据", com.ucpro.feature.setting.b.a.a.a, new l()));
        aVar.a(new b("普通视频文件缓存：优酷", com.ucpro.feature.setting.b.a.a.a, new bs()));
        a(aVar, "爱奇艺", "http://cache.m.iqiyi.com/dc/dt/mobile/20161012/e4/fc/9b659ed96bd0a3be03d21e7cda66fb53.m3u8?qypid=550346000_22&qd_src=5be6a2fdfe4f4a1a8c7b08ee46a18887&qd_tm=1476254629000&qd_ip=123.125.122.205&qd_sc=3e613381a381cd618a8c65fd52d64eb7&mbd=f0f6c3ee5709615310c0f053dc9c65f2_5.9_1");
        a(aVar, "搜狐", "http://hot.vrs.sohu.com/ipad3268171_4687672398251_6479492.m3u8?plat=17&ca=3&pg=1&pt=5&sver=5.0.2&cv=5.0.2&qd=282&prod=app&uid=1476351266165&vid=3268171&cateCode=101101");
        aVar.a(new b("播放爱奇艺", com.ucpro.feature.setting.b.a.a.a, new ap()));
        aVar.a(new b("播放搜狐", com.ucpro.feature.setting.b.a.a.a, new cd()));
        aVar.a(new b("视频下载目录整体删除", com.ucpro.feature.setting.b.a.a.a, new bx()));
        aVar.a(new b("进入M3U8下载页面UI", com.ucpro.feature.setting.b.a.a.a, new q()));
        return aVar;
    }

    private static void a(a aVar, String str, String str2) {
        aVar.a(new b("M3U8下载-" + str, com.ucpro.feature.setting.b.a.a.a, new ak(str2, str)));
    }
}
