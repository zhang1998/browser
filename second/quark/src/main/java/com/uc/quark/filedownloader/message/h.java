package com.uc.quark.filedownloader.message;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.uc.quark.filedownloader.message.SmallMessageSnapshot.CompletedSnapshot;
import com.uc.quark.filedownloader.message.SmallMessageSnapshot.ConnectedMessageSnapshot;
import com.uc.quark.filedownloader.message.SmallMessageSnapshot.ErrorMessageSnapshot;
import com.uc.quark.filedownloader.message.SmallMessageSnapshot.NetworkSwitchMessageSnapshot;
import com.uc.quark.filedownloader.message.SmallMessageSnapshot.PendingMessageSnapshot;
import com.uc.quark.filedownloader.message.SmallMessageSnapshot.PreCreateMessageSnapshot;
import com.uc.quark.filedownloader.message.SmallMessageSnapshot.ProgressMessageSnapshot;
import com.uc.quark.filedownloader.message.SmallMessageSnapshot.RetryMessageSnapshot;
import com.uc.quark.filedownloader.message.SmallMessageSnapshot.WarnMessageSnapshot;

/* compiled from: ProGuard */
final class h implements Creator<MessageSnapshot> {
    h() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        MessageSnapshot networkSwitchMessageSnapshot;
        boolean z = true;
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        byte readByte = parcel.readByte();
        switch (readByte) {
            case (byte) -5:
                if (!z) {
                    networkSwitchMessageSnapshot = new NetworkSwitchMessageSnapshot(parcel);
                    break;
                }
                networkSwitchMessageSnapshot = new LargeMessageSnapshot.NetworkSwitchMessageSnapshot(parcel);
                break;
            case (byte) -4:
                if (!z) {
                    networkSwitchMessageSnapshot = new WarnMessageSnapshot(parcel);
                    break;
                }
                networkSwitchMessageSnapshot = new LargeMessageSnapshot.WarnMessageSnapshot(parcel);
                break;
            case (byte) -3:
                if (!z) {
                    networkSwitchMessageSnapshot = new CompletedSnapshot(parcel);
                    break;
                }
                networkSwitchMessageSnapshot = new LargeMessageSnapshot.CompletedSnapshot(parcel);
                break;
            case (byte) -1:
                if (!z) {
                    networkSwitchMessageSnapshot = new ErrorMessageSnapshot(parcel);
                    break;
                }
                networkSwitchMessageSnapshot = new LargeMessageSnapshot.ErrorMessageSnapshot(parcel);
                break;
            case (byte) 1:
                if (!z) {
                    networkSwitchMessageSnapshot = new PendingMessageSnapshot(parcel);
                    break;
                }
                networkSwitchMessageSnapshot = new LargeMessageSnapshot.PendingMessageSnapshot(parcel);
                break;
            case (byte) 2:
                if (!z) {
                    networkSwitchMessageSnapshot = new ConnectedMessageSnapshot(parcel);
                    break;
                }
                networkSwitchMessageSnapshot = new LargeMessageSnapshot.ConnectedMessageSnapshot(parcel);
                break;
            case (byte) 3:
                if (!z) {
                    networkSwitchMessageSnapshot = new ProgressMessageSnapshot(parcel);
                    break;
                }
                networkSwitchMessageSnapshot = new LargeMessageSnapshot.ProgressMessageSnapshot(parcel);
                break;
            case (byte) 5:
                if (!z) {
                    networkSwitchMessageSnapshot = new RetryMessageSnapshot(parcel);
                    break;
                }
                networkSwitchMessageSnapshot = new LargeMessageSnapshot.RetryMessageSnapshot(parcel);
                break;
            case (byte) 6:
                if (!z) {
                    networkSwitchMessageSnapshot = new PendingMessageSnapshot(parcel);
                    break;
                }
                networkSwitchMessageSnapshot = new LargeMessageSnapshot.PendingMessageSnapshot(parcel);
                break;
            case (byte) 7:
                if (!z) {
                    networkSwitchMessageSnapshot = new PreCreateMessageSnapshot(parcel);
                    break;
                }
                networkSwitchMessageSnapshot = new LargeMessageSnapshot.PreCreateMessageSnapshot(parcel);
                break;
            default:
                networkSwitchMessageSnapshot = new MessageSnapshot(parcel);
                break;
        }
        networkSwitchMessageSnapshot.c = z;
        networkSwitchMessageSnapshot.b = readByte;
        return networkSwitchMessageSnapshot;
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new MessageSnapshot[i];
    }
}
