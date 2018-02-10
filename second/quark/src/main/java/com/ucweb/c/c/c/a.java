package com.ucweb.c.c.c;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import com.UCMobile.Apollo.MediaPlayer;
import com.tencent.mm.sdk.constants.ConstantsAPI;
import com.tencent.mm.sdk.constants.ConstantsAPI.WXApp;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.sdk.modelmsg.WXImageObject;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.sdk.modelmsg.WXTextObject;
import com.tencent.mm.sdk.modelmsg.WXVideoObject;
import com.tencent.mm.sdk.modelmsg.WXWebpageObject;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import com.ucweb.c.a.c;
import com.ucweb.c.b.b;

/* compiled from: ProGuard */
public final class a implements com.ucweb.c.a.a {
    private b a = new b();
    private boolean b;

    public a(boolean z) {
        this.b = z;
    }

    public final void a(b bVar) {
        if (b.a()) {
            boolean z = this.b;
            if (bVar != null) {
                Object obj;
                IWXAPI createWXAPI;
                Bundle bundle;
                String str;
                Intent intent;
                StringBuffer stringBuffer;
                String str2 = bVar.a;
                String str3 = bVar.b;
                String str4 = bVar.c;
                String str5 = bVar.e;
                int i = bVar.d;
                WXMediaMessage wXMediaMessage = new WXMediaMessage();
                wXMediaMessage.description = str4;
                if (z) {
                    str3 = str4;
                }
                wXMediaMessage.title = str3;
                BaseReq req = new Req();
                req.transaction = (z ? "timeline" : "friends") + System.currentTimeMillis();
                req.message = wXMediaMessage;
                req.scene = z ? 1 : 0;
                IMediaObject iMediaObject = null;
                if (str2 != null) {
                    if (i == c.b || i == c.c) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        iMediaObject = new WXWebpageObject();
                        iMediaObject.webpageUrl = str2;
                        if (b.a(str5)) {
                            wXMediaMessage.thumbData = b.b(str5);
                        }
                        if (iMediaObject == null) {
                            iMediaObject = new WXTextObject();
                            iMediaObject.text = str4;
                        }
                        wXMediaMessage.mediaObject = iMediaObject;
                        createWXAPI = WXAPIFactory.createWXAPI(com.ucweb.c.c.b.a(), null);
                        if (createWXAPI == null) {
                            createWXAPI.registerApp(com.ucweb.c.a.b.WECHAT_FRIENDS.i);
                            if (com.ucweb.c.a.a.booleanValue()) {
                                createWXAPI.sendReq(req);
                                return;
                            }
                            bundle = new Bundle();
                            req.toBundle(bundle);
                            str4 = "weixin://sendresp?appid=" + com.ucweb.c.a.b.WECHAT_FRIENDS.i;
                            str = WXApp.WXAPP_PACKAGE_NAME;
                            str2 = WXApp.WXAPP_MSG_ENTRY_CLASSNAME;
                            intent = new Intent();
                            intent.setClassName(str, str2);
                            intent.putExtras(bundle);
                            str3 = com.ucweb.c.c.b.a().getPackageName();
                            intent.putExtra(ConstantsAPI.SDK_VERSION, 587268097);
                            intent.putExtra(ConstantsAPI.APP_PACKAGE, str3);
                            intent.putExtra(ConstantsAPI.CONTENT, str4);
                            str = ConstantsAPI.CHECK_SUM;
                            stringBuffer = new StringBuffer();
                            if (str4 != null) {
                                stringBuffer.append(str4);
                            }
                            stringBuffer.append(587268097);
                            stringBuffer.append(str3);
                            stringBuffer.append("mMcShCsTr");
                            intent.putExtra(str, b.a(stringBuffer.toString().substring(1, 9).getBytes()).getBytes());
                            intent.addFlags(MediaPlayer.MEDIA_ERROR_UNKNOWN).addFlags(134217728);
                            try {
                                com.ucweb.c.c.b.a().startActivity(intent);
                                return;
                            } catch (Exception e) {
                                Log.e("vanda", "send fail, ex = %s" + e);
                                return;
                            }
                        }
                        return;
                    }
                }
                if (b.a(str5)) {
                    if (i == c.d) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        iMediaObject = new WXImageObject();
                        if (b.a(str5)) {
                            wXMediaMessage.thumbData = b.b(str5);
                        }
                        if (!bVar.f || str2 == null) {
                            iMediaObject.imagePath = str5;
                        } else {
                            iMediaObject.imagePath = str2;
                        }
                        if (iMediaObject == null) {
                            iMediaObject = new WXTextObject();
                            iMediaObject.text = str4;
                        }
                        wXMediaMessage.mediaObject = iMediaObject;
                        createWXAPI = WXAPIFactory.createWXAPI(com.ucweb.c.c.b.a(), null);
                        if (createWXAPI == null) {
                            createWXAPI.registerApp(com.ucweb.c.a.b.WECHAT_FRIENDS.i);
                            if (com.ucweb.c.a.a.booleanValue()) {
                                createWXAPI.sendReq(req);
                                return;
                            }
                            bundle = new Bundle();
                            req.toBundle(bundle);
                            str4 = "weixin://sendresp?appid=" + com.ucweb.c.a.b.WECHAT_FRIENDS.i;
                            str = WXApp.WXAPP_PACKAGE_NAME;
                            str2 = WXApp.WXAPP_MSG_ENTRY_CLASSNAME;
                            intent = new Intent();
                            intent.setClassName(str, str2);
                            intent.putExtras(bundle);
                            str3 = com.ucweb.c.c.b.a().getPackageName();
                            intent.putExtra(ConstantsAPI.SDK_VERSION, 587268097);
                            intent.putExtra(ConstantsAPI.APP_PACKAGE, str3);
                            intent.putExtra(ConstantsAPI.CONTENT, str4);
                            str = ConstantsAPI.CHECK_SUM;
                            stringBuffer = new StringBuffer();
                            if (str4 != null) {
                                stringBuffer.append(str4);
                            }
                            stringBuffer.append(587268097);
                            stringBuffer.append(str3);
                            stringBuffer.append("mMcShCsTr");
                            intent.putExtra(str, b.a(stringBuffer.toString().substring(1, 9).getBytes()).getBytes());
                            intent.addFlags(MediaPlayer.MEDIA_ERROR_UNKNOWN).addFlags(134217728);
                            com.ucweb.c.c.b.a().startActivity(intent);
                            return;
                        }
                        return;
                    }
                }
                if (str2 != null) {
                    if (i == c.f) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        iMediaObject = new WXVideoObject();
                        iMediaObject.videoUrl = str2;
                        if (b.a(str5)) {
                            wXMediaMessage.thumbData = b.b(str5);
                        }
                        if (iMediaObject == null) {
                            iMediaObject = new WXTextObject();
                            iMediaObject.text = str4;
                        }
                        wXMediaMessage.mediaObject = iMediaObject;
                        createWXAPI = WXAPIFactory.createWXAPI(com.ucweb.c.c.b.a(), null);
                        if (createWXAPI == null) {
                            createWXAPI.registerApp(com.ucweb.c.a.b.WECHAT_FRIENDS.i);
                            if (com.ucweb.c.a.a.booleanValue()) {
                                bundle = new Bundle();
                                req.toBundle(bundle);
                                str4 = "weixin://sendresp?appid=" + com.ucweb.c.a.b.WECHAT_FRIENDS.i;
                                str = WXApp.WXAPP_PACKAGE_NAME;
                                str2 = WXApp.WXAPP_MSG_ENTRY_CLASSNAME;
                                intent = new Intent();
                                intent.setClassName(str, str2);
                                intent.putExtras(bundle);
                                str3 = com.ucweb.c.c.b.a().getPackageName();
                                intent.putExtra(ConstantsAPI.SDK_VERSION, 587268097);
                                intent.putExtra(ConstantsAPI.APP_PACKAGE, str3);
                                intent.putExtra(ConstantsAPI.CONTENT, str4);
                                str = ConstantsAPI.CHECK_SUM;
                                stringBuffer = new StringBuffer();
                                if (str4 != null) {
                                    stringBuffer.append(str4);
                                }
                                stringBuffer.append(587268097);
                                stringBuffer.append(str3);
                                stringBuffer.append("mMcShCsTr");
                                intent.putExtra(str, b.a(stringBuffer.toString().substring(1, 9).getBytes()).getBytes());
                                intent.addFlags(MediaPlayer.MEDIA_ERROR_UNKNOWN).addFlags(134217728);
                                com.ucweb.c.c.b.a().startActivity(intent);
                                return;
                            }
                            createWXAPI.sendReq(req);
                            return;
                        }
                        return;
                    }
                }
                if (i == c.e) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    iMediaObject = new WXTextObject();
                    iMediaObject.text = str4;
                }
                if (iMediaObject == null) {
                    iMediaObject = new WXTextObject();
                    iMediaObject.text = str4;
                }
                wXMediaMessage.mediaObject = iMediaObject;
                createWXAPI = WXAPIFactory.createWXAPI(com.ucweb.c.c.b.a(), null);
                if (createWXAPI == null) {
                    createWXAPI.registerApp(com.ucweb.c.a.b.WECHAT_FRIENDS.i);
                    if (com.ucweb.c.a.a.booleanValue()) {
                        createWXAPI.sendReq(req);
                        return;
                    }
                    bundle = new Bundle();
                    req.toBundle(bundle);
                    str4 = "weixin://sendresp?appid=" + com.ucweb.c.a.b.WECHAT_FRIENDS.i;
                    str = WXApp.WXAPP_PACKAGE_NAME;
                    str2 = WXApp.WXAPP_MSG_ENTRY_CLASSNAME;
                    intent = new Intent();
                    intent.setClassName(str, str2);
                    intent.putExtras(bundle);
                    str3 = com.ucweb.c.c.b.a().getPackageName();
                    intent.putExtra(ConstantsAPI.SDK_VERSION, 587268097);
                    intent.putExtra(ConstantsAPI.APP_PACKAGE, str3);
                    intent.putExtra(ConstantsAPI.CONTENT, str4);
                    str = ConstantsAPI.CHECK_SUM;
                    stringBuffer = new StringBuffer();
                    if (str4 != null) {
                        stringBuffer.append(str4);
                    }
                    stringBuffer.append(587268097);
                    stringBuffer.append(str3);
                    stringBuffer.append("mMcShCsTr");
                    intent.putExtra(str, b.a(stringBuffer.toString().substring(1, 9).getBytes()).getBytes());
                    intent.addFlags(MediaPlayer.MEDIA_ERROR_UNKNOWN).addFlags(134217728);
                    com.ucweb.c.c.b.a().startActivity(intent);
                    return;
                }
                return;
            }
            return;
        }
        Toast.makeText(com.ucweb.c.c.b.a(), com.ucweb.c.b.not_install_app, 0).show();
    }
}
