package android.support.v4.view.b;

import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.uc.crashsdk.export.LogType;
import org.android.spdy.SpdyProtocol;

/* compiled from: ProGuard */
public final class h {
    public static final h a = new h(1);
    public static final h b = new h(2);
    public static final h c = new h(4);
    public static final h d = new h(8);
    public static final h e = new h(16);
    public static final h f = new h(32);
    public static final h g = new h(64);
    public static final h h = new h(128);
    public static final h i = new h((int) LogType.UNEXP);
    public static final h j = new h(512);
    public static final h k = new h(1024);
    public static final h l = new h(2048);
    public static final h m = new h((int) SpdyProtocol.SLIGHTSSL_0_RTT_MODE);
    public static final h n = new h((int) SpdyProtocol.SLIGHTSSL_1_RTT_MODE);
    public static final h o = new h(16384);
    public static final h p = new h((int) WXMediaMessage.THUMB_LENGTH_LIMIT);
    public static final h q = new h(65536);
    public static final h r = new h(131072);
    public static final h s = new h(262144);
    public static final h t = new h(524288);
    public static final h u = new h(1048576);
    public static final h v = new h(2097152);
    private final Object w;

    private h(int i) {
        this(s.a.a(i));
    }

    private h(Object obj) {
        this.w = obj;
    }
}
