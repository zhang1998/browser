package com.uc.base.net.natives;

/* compiled from: ProGuard */
class NativeHttpEventListener {
    public native void nativeOnBodyReceived(byte[] bArr, int i);

    public native void nativeOnError(int i, String str);

    public native void nativeOnHeaderReceived(b bVar);

    public native void nativeOnMetrics(a aVar);

    public native boolean nativeOnRedirect(String str);

    public native void nativeOnRequestCancel();

    public native void nativeOnStatusMessage(String str, int i, String str2);
}
