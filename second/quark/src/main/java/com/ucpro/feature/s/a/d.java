package com.ucpro.feature.s.a;

import com.ucpro.model.keepproguard.discnavi.DiscoveryNaviDataParse;
import com.ucpro.model.keepproguard.discnavi.DiscoveryNavigationData;
import com.ucweb.common.util.n.a;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
final class d extends DiscoveryNavigationData {
    d(String str) {
        a(str);
    }

    final void a(String str) {
        boolean z;
        if (a.a(str)) {
            str = "{\n    \"array\": [\n        {\n            \"dataList\": [\n                {\n                    \"description\": \"知识分享社区\", \n                    \"iconName\": \"zhihu.png\", \n                    \"iconUrl\": \"\", \n                    \"title\": \"知乎\", \n                    \"url\": \"www.zhihu.com\"\n                }, \n                {\n                    \"description\": \"互联网创业资讯\", \n                    \"iconName\": \"36kr.png\", \n                    \"iconUrl\": \"\", \n                    \"title\": \"36kr\", \n                    \"url\": \"36kr.com\"\n                }, \n                {\n                    \"description\": \"高质量应用推荐\", \n                    \"iconName\": \"sspai.png\", \n                    \"iconUrl\": \"\", \n                    \"title\": \"少数派\", \n                    \"url\": \"sspai.com\"\n                }, \n                {\n                    \"description\": \"泛科技媒体\", \n                    \"iconName\": \"ifanr.png\", \n                    \"iconUrl\": \"\", \n                    \"title\": \"爱范儿\", \n                    \"url\": \"www.ifanr.com\"\n                }, \n                {\n                    \"description\": \"电子产品测评网站\", \n                    \"iconName\": \"zealer.png\", \n                    \"iconUrl\": \"\", \n                    \"title\": \"ZEALER\", \n                    \"url\": \"www.zealer.com\"\n                }, \n                {\n                    \"description\": \"分享美好数字生活\", \n                    \"iconName\": \"dgtle.png\", \n                    \"iconUrl\": \"\", \n                    \"title\": \"数字尾巴\", \n                    \"url\": \"www.dgtle.com\"\n                }, \n                {\n                    \"description\": \"科技新闻和测评\", \n                    \"iconName\": \"engadget.png\", \n                    \"iconUrl\": \"\", \n                    \"title\": \"瘾科技\", \n                    \"url\": \"cn.engadget.com\"\n                }, \n                {\n                    \"description\": \"科技媒体\", \n                    \"iconName\": \"huxiu.png\", \n                    \"iconUrl\": \"\", \n                    \"title\": \"虎嗅网\", \n                    \"url\": \"m.huxiu.com\"\n                }, \n                {\n                    \"description\": \"有品好玩的科技\", \n                    \"iconName\": \"pingwest.png\", \n                    \"iconUrl\": \"\", \n                    \"title\": \"品玩\", \n                    \"url\": \"www.pingwest.com\"\n                }, \n                {\n                    \"description\": \"优质原创内容社区\", \n                    \"iconName\": \"jianshu.png\", \n                    \"iconUrl\": \"\", \n                    \"title\": \"简书\", \n                    \"url\": \"jianshu.com\"\n                }, \n                {\n                    \"description\": \"关于分享和探索的地方\", \n                    \"iconName\": \"v2ex.png\", \n                    \"iconUrl\": \"\", \n                    \"title\": \"V2EX\", \n                    \"url\": \"https://www.v2ex.com\"\n                }\n            ], \n            \"tabTitle\": \"科技\"\n        }, \n        {\n            \"dataList\": [\n                {\n                    \"description\": \"一个神奇的社区\", \n                    \"iconName\": \"douban.png\", \n                    \"iconUrl\": \"\", \n                    \"title\": \"豆瓣\", \n                    \"url\": \"http://m.douban.com\"\n                }, \n                {\n                    \"description\": \"生活兴趣杂志\", \n                    \"iconName\": \"qingmang.png\", \n                    \"iconUrl\": \"\", \n                    \"title\": \"轻芒杂志\", \n                    \"url\": \"qingmang.me/magazines/\"\n                }, \n                {\n                    \"description\": \"韩寒监制\", \n                    \"iconName\": \"one.png\", \n                    \"iconUrl\": \"\", \n                    \"title\": \"ONE\", \n                    \"url\": \"wufazhuce.com\"\n                }, \n                {\n                    \"description\": \"旅游攻略社区\", \n                    \"iconName\": \"mafengwo.png\", \n                    \"iconUrl\": \"\", \n                    \"title\": \"蚂蜂窝\", \n                    \"url\": \"www.mafengwo.com\"\n                }, \n                {\n                    \"description\": \"可以买到国外的好东西\", \n                    \"iconName\": \"xiaohongshu.png\", \n                    \"iconUrl\": \"\", \n                    \"title\": \"小红书\", \n                    \"url\": \"xiaohongshu.com\"\n                }, \n                {\n                    \"description\": \"应该能省点钱吧\", \n                    \"iconName\": \"smzdm.png\", \n                    \"iconUrl\": \"\", \n                    \"title\": \"什么值得买\", \n                    \"url\": \"m.smzdm.com\"\n                }, \n                {\n                    \"description\": \"不看书，就看几场电影吧\", \n                    \"iconName\": \"taopiaopiao.png\", \n                    \"iconUrl\": \"\", \n                    \"title\": \"淘票票\", \n                    \"url\": \"dianying.taobao.com\"\n                }, \n                {\n                    \"description\": \"是男人就学做几道菜\", \n                    \"iconName\": \"xiachufang.png\", \n                    \"iconUrl\": \"\", \n                    \"title\": \"下厨房\", \n                    \"url\": \"m.xiachufang.com\"\n                }, \n                {\n                    \"description\": \"高端美食团购\", \n                    \"iconName\": \"enjoy.png\", \n                    \"iconUrl\": \"\", \n                    \"title\": \"ENJOY\", \n                    \"url\": \"https://enjoy.ricebook.com/\"\n                }, \n                {\n                    \"description\": \"帮她挑一件性感bra\", \n                    \"iconName\": \"o2bra.png\", \n                    \"iconUrl\": \"\", \n                    \"title\": \"氧气\", \n                    \"url\": \"www.o2bra.com.cn\"\n                }\n            ], \n            \"tabTitle\": \"生活\"\n        }, \n        {\n            \"dataList\": [\n                {\n                    \"description\": \"设计师互动平台\", \n                    \"iconName\": \"zcool.png\", \n                    \"iconUrl\": \"\", \n                    \"title\": \"站酷网\", \n                    \"url\": \"m.zcool.com.cn\"\n                }, \n                {\n                    \"description\": \"摄影爱好者社区\", \n                    \"iconName\": \"lofter.png\", \n                    \"iconUrl\": \"\", \n                    \"title\": \"Lofter\", \n                    \"url\": \"www.lofter.com\"\n                }, \n                {\n                    \"description\": \"Adobe旗下的创意平台\", \n                    \"iconName\": \"behance.png\", \n                    \"iconUrl\": \"\", \n                    \"title\": \"Behance\", \n                    \"url\": \"www.behance.net\"\n                }, \n                {\n                    \"description\": \"好设计都在这\", \n                    \"iconName\": \"dribbble.png\", \n                    \"iconUrl\": \"\", \n                    \"title\": \"Dribbble\", \n                    \"url\": \"https://dribbble.com\"\n                }, \n                {\n                    \"description\": \"设计从业者入门网站\", \n                    \"iconName\": \"uisdc.png\", \n                    \"iconUrl\": \"\", \n                    \"title\": \"优设网\", \n                    \"url\": \"www.uisdc.com\"\n                }, \n                {\n                    \"description\": \"脑洞无限巨大\", \n                    \"iconName\": \"miniature-calendar.png\", \n                    \"iconUrl\": \"\", \n                    \"title\": \"小型日历\", \n                    \"url\": \"http://miniature-calendar.com/\"\n                }, \n                {\n                    \"description\": \"网页界的奥斯卡\", \n                    \"iconName\": \"thefwa.png\", \n                    \"iconUrl\": \"\", \n                    \"title\": \"thefwa\", \n                    \"url\": \"https://thefwa.com\"\n                }, \n                {\n                    \"description\": \"最出色的摄影社区\", \n                    \"iconName\": \"500px.png\", \n                    \"iconUrl\": \"\", \n                    \"title\": \"500px\", \n                    \"url\": \"https://500px.com\"\n                }, \n                {\n                    \"description\": \"娱乐人才平台\", \n                    \"iconName\": \"moko.png\", \n                    \"iconUrl\": \"\", \n                    \"title\": \"MOKO!\", \n                    \"url\": \"www.moko.cc\"\n                }\n            ], \n            \"tabTitle\": \"设计\"\n        }, \n        {\n            \"dataList\": [\n                {\n                    \"description\": \"发现最优美的应用\", \n                    \"iconName\": \"wandoujia.png\", \n                    \"iconUrl\": \"\", \n                    \"title\": \"豌豆荚设计\", \n                    \"url\": \"www.wandoujia.com/award\"\n                }, \n                {\n                    \"description\": \"音频分享平台\", \n                    \"iconName\": \"xmlyfm.png\", \n                    \"iconUrl\": \"\", \n                    \"title\": \"喜马拉雅听\", \n                    \"url\": \"m.ximalaya.com\"\n                }, \n                {\n                    \"description\": \"发现应用的乐趣\", \n                    \"iconName\": \"coolapk.png\", \n                    \"iconUrl\": \"\", \n                    \"title\": \"酷安\", \n                    \"url\": \"www.coolapk.com\"\n                }, \n                {\n                    \"description\": \"学习web开发的最佳实践\", \n                    \"iconName\": \"mozilla.png\", \n                    \"iconUrl\": \"\", \n                    \"title\": \"Mozilla\", \n                    \"url\": \"https://developer.mozilla.org/zh-CN/\"\n                }, \n                {\n                    \"description\": \"人chou就要多学习\", \n                    \"iconName\": \"open163.png\", \n                    \"iconUrl\": \"\", \n                    \"title\": \"网易公开课\", \n                    \"url\": \"m.open.163.com\"\n                }, \n                {\n                    \"description\": \"可多人实时协作的云端文档\", \n                    \"iconName\": \"shimo.png\", \n                    \"iconUrl\": \"\", \n                    \"title\": \"石墨文档\", \n                    \"url\": \"https://shimo.im\"\n                }\n            ], \n            \"tabTitle\": \"工具\"\n        }\n    ]\n}";
            z = true;
        } else {
            z = false;
        }
        ArrayList a = DiscoveryNaviDataParse.a(str);
        if (a != null) {
            this.array = a;
        }
        Iterator it = this.array.iterator();
        while (it.hasNext()) {
            ((DiscoveryNaviDataParse) it.next()).a = z;
        }
    }
}
