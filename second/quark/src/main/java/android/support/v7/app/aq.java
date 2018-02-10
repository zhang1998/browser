package android.support.v7.app;

import org.android.spdy.SpdyProtocol;

/* compiled from: ProGuard */
final class aq implements Runnable {
    final /* synthetic */ AppCompatDelegateImplV7 a;

    aq(AppCompatDelegateImplV7 appCompatDelegateImplV7) {
        this.a = appCompatDelegateImplV7;
    }

    public final void run() {
        if ((this.a.I & 1) != 0) {
            AppCompatDelegateImplV7.a(this.a, 0);
        }
        if ((this.a.I & SpdyProtocol.SLIGHTSSL_0_RTT_MODE) != 0) {
            AppCompatDelegateImplV7.a(this.a, 108);
        }
        this.a.H = false;
        this.a.I = 0;
    }
}
