package com.uc.apollo.media.impl;

import com.alibaba.wireless.security.SecExceptionCode;
import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;
import com.uc.apollo.media.MediaPlayer;
import com.uc.apollo.util.f;
import org.android.spdy.TnetStatusCode;

/* compiled from: ProGuard */
public final class d {
    private static String a(int i) {
        switch (i) {
            case -38:
                return "WRONG STATE";
            case 100:
                return "SERVER DIED";
            case 200:
                return "NOT VALID FOR PROGRESSIVE PLAYBACK";
            default:
                if (i <= 0) {
                    return null;
                }
                if (i <= 99) {
                    return "Unknown error";
                }
                if (i <= SecExceptionCode.SEC_ERROR_INIT_UNKNOWN_ERROR) {
                    return "Player errors";
                }
                if (i <= SecExceptionCode.SEC_ERROR_STA_STORE_UNKNOWN_ERROR) {
                    return "Media errors";
                }
                if (i <= SecExceptionCode.SEC_ERROR_STA_UNKNOWN_ERROR) {
                    return "Runtime errors";
                }
                return null;
        }
    }

    private static String b(int i) {
        switch (i) {
            case TnetStatusCode.EASY_REASON_HANDSHAKE_ERROR /*-3000*/:
                return "HEARTBEAT TERMINATE REQUESTED";
            case TnetStatusCode.EASY_SPDY_INVALID_STREAM /*-2011*/:
                return "DRM INSUFFICIENT OUTPUT PROTECTION";
            case TnetStatusCode.EASY_SPDY_PROTOCOL_ERROR /*-2010*/:
                return "DRM RESOURCE BUSY";
            case -2009:
                return "DRM DEVICE REVOKED";
            case -2008:
                return "DRM NOT PROVISIONED";
            case -2007:
                return "DRM TAMPER DETECTED";
            case -2006:
                return "DRM CANNOT HANDLE";
            case TnetStatusCode.EASY_REASON_CANCEL /*-2005*/:
                return "DRM DECRYPT";
            case TnetStatusCode.EASY_REASON_SESSION_TIMEOUT /*-2004*/:
                return "DRM DECRYPT UNIT NOT INITIALIZED";
            case TnetStatusCode.EASY_REASON_CONN_TIMEOUT /*-2003*/:
                return "DRM SESSION NOT OPENED";
            case TnetStatusCode.EASY_REASON_DISCONNECT /*-2002*/:
                return "DRM LICENSE EXPIRED";
            case TnetStatusCode.EASY_REASON_CONN_NOT_EXISTS /*-2001*/:
                return "DRM NO LICENSE";
            case -2000:
                return "DRM UNKNOWN";
            case -1014:
                return "INFO OUTPUT BUFFERS CHANGED";
            case -1013:
                return "INFO DISCONTINUITY";
            case -1012:
                return "INFO FORMAT CHANGED";
            case -1011:
                return "END OF STREAM";
            case MediaPlayer.MEDIA_ERROR_UNSUPPORTED /*-1010*/:
                return "UNSUPPORTED";
            case -1009:
                return "BUFFER TOO SMALL";
            case -1008:
                return "OUT OF RANGE";
            case MediaPlayer.MEDIA_ERROR_MALFORMED /*-1007*/:
                return "MALFORMED";
            case -1005:
                return "CONNECTION LOST";
            case MediaPlayer.MEDIA_ERROR_IO /*-1004*/:
                return "IO ERROR";
            case -1003:
                return "CANNOT CONNECT";
            case -1002:
                return "UNKNOWN HOST";
            case -1001:
                return "NOT CONNECTED";
            case MediaPlayer.MEDIA_ERROR_TIMED_OUT /*-110*/:
                return "TIMED OUT";
            case -38:
                return "WRONG STATE";
            default:
                if ((i >= -10004 && i <= -10000) || (i >= -20009 && i <= -20000)) {
                    return "NDK Error";
                }
                if (i >= -2147479552 && i <= -1878982657) {
                    return "Codec Error";
                }
                if (i < SectionHeader.SHT_LOUSER || i > -2147483641) {
                    return null;
                }
                return "System Error";
        }
    }

    private static String a(String str, String str2, int i, int i2) {
        StringBuilder stringBuilder = new StringBuilder(32);
        if (!(str == null && str2 == null)) {
            if (str != null) {
                stringBuilder.append(str);
                if (str2 != null) {
                    stringBuilder.append(", ");
                }
            }
            if (str2 != null) {
                stringBuilder.append(str2);
            }
        }
        if (stringBuilder.length() != 0) {
            stringBuilder.append(' ');
        }
        stringBuilder.append("what/extra ").append(i).append("/").append(i2);
        return stringBuilder.toString();
    }

    public static String a(int i, int i2) {
        return a(a(i), b(i2), i, i2);
    }

    public static String a(int i, int i2, int i3) {
        String a = a(i2);
        String b = b(i3);
        if (f.a(b) && i == 5) {
            switch (i3) {
                case -101:
                    b = "CANNOT CONNECT";
                    break;
            }
        }
        return a(a, b, i2, i3);
    }
}
