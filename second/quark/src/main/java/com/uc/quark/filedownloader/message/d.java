package com.uc.quark.filedownloader.message;

import com.uc.quark.filedownloader.aa;
import com.uc.quark.filedownloader.e.b;
import com.uc.quark.filedownloader.e.j;
import com.uc.quark.filedownloader.message.BlockCompleteMessage.BlockCompleteMessageImpl;
import com.uc.quark.filedownloader.message.LargeMessageSnapshot.CompletedFlowDirectlySnapshot;
import com.uc.quark.filedownloader.message.LargeMessageSnapshot.CompletedSnapshot;
import com.uc.quark.filedownloader.message.LargeMessageSnapshot.ErrorMessageSnapshot;
import com.uc.quark.filedownloader.message.LargeMessageSnapshot.PausedSnapshot;
import com.uc.quark.filedownloader.message.LargeMessageSnapshot.WarnFlowDirectlySnapshot;
import com.uc.quark.filedownloader.message.LargeMessageSnapshot.WarnMessageSnapshot;
import com.uc.quark.filedownloader.message.SmallMessageSnapshot.ConnectedMessageSnapshot;
import com.uc.quark.filedownloader.message.SmallMessageSnapshot.NetworkSwitchMessageSnapshot;
import com.uc.quark.filedownloader.message.SmallMessageSnapshot.PendingMessageSnapshot;
import com.uc.quark.filedownloader.message.SmallMessageSnapshot.PreCreateMessageSnapshot;
import com.uc.quark.filedownloader.message.SmallMessageSnapshot.ProgressMessageSnapshot;
import com.uc.quark.filedownloader.message.SmallMessageSnapshot.RetryMessageSnapshot;
import java.io.File;

/* compiled from: ProGuard */
public class d {
    public static MessageSnapshot a(int i, File file, boolean z, boolean z2) {
        long length = file.length();
        if (length > 2147483647L) {
            if (z) {
                return new CompletedFlowDirectlySnapshot(i, length, z2);
            }
            return new CompletedSnapshot(i, (byte) -3, true, length, z2);
        } else if (z) {
            return new SmallMessageSnapshot.CompletedFlowDirectlySnapshot(i, (int) length, z2);
        } else {
            return new SmallMessageSnapshot.CompletedSnapshot(i, (byte) -3, true, (int) length, z2);
        }
    }

    public static MessageSnapshot a(int i, long j, long j2, boolean z, boolean z2) {
        if (j2 > 2147483647L) {
            if (z) {
                return new WarnFlowDirectlySnapshot(i, j, j2, z2);
            }
            return new WarnMessageSnapshot(i, j, j2, z2);
        } else if (z) {
            return new SmallMessageSnapshot.WarnFlowDirectlySnapshot(i, (int) j, (int) j2, z2);
        } else {
            return new SmallMessageSnapshot.WarnMessageSnapshot(i, (int) j, (int) j2, z2);
        }
    }

    public static MessageSnapshot a(aa aaVar) {
        if (aaVar.A()) {
            return new ErrorMessageSnapshot(aaVar.e(), (byte) -1, aaVar.o(), aaVar.q(), aaVar.u(), aaVar.v());
        }
        return new SmallMessageSnapshot.ErrorMessageSnapshot(aaVar.e(), (byte) -1, aaVar.n(), aaVar.p(), aaVar.u(), aaVar.v());
    }

    public static MessageSnapshot b(aa aaVar) {
        if (aaVar.A()) {
            return new PausedSnapshot(aaVar.e(), (byte) -2, aaVar.o(), aaVar.q(), aaVar.v());
        }
        return new SmallMessageSnapshot.PausedSnapshot(aaVar.e(), (byte) -2, aaVar.n(), aaVar.p(), aaVar.v());
    }

    public static MessageSnapshot a(MessageSnapshot messageSnapshot) {
        if (messageSnapshot.i() == (byte) -3) {
            return new BlockCompleteMessageImpl(messageSnapshot);
        }
        throw new IllegalStateException(b.a("take block completed snapshot, must has already be completed. %d %d", Integer.valueOf(messageSnapshot.a), Byte.valueOf(messageSnapshot.i())));
    }

    public static MessageSnapshot a(byte b, com.uc.quark.filedownloader.model.b bVar, g gVar) {
        int i = bVar.a;
        if (b == (byte) -4) {
            throw new IllegalStateException(b.a("please use #catchWarn instead %d", Integer.valueOf(i)));
        }
        MessageSnapshot networkSwitchMessageSnapshot;
        switch (b) {
            case (byte) -5:
                if (!bVar.p) {
                    networkSwitchMessageSnapshot = new NetworkSwitchMessageSnapshot(i, b, (int) bVar.g, (int) bVar.h, gVar.e());
                    break;
                }
                networkSwitchMessageSnapshot = new LargeMessageSnapshot.NetworkSwitchMessageSnapshot(i, b, bVar.g, bVar.h, gVar.e());
                break;
            case (byte) -3:
                if (!bVar.p) {
                    networkSwitchMessageSnapshot = new SmallMessageSnapshot.CompletedSnapshot(i, b, false, (int) bVar.h, gVar.e());
                    break;
                }
                networkSwitchMessageSnapshot = new CompletedSnapshot(i, b, false, bVar.h, gVar.e());
                break;
            case (byte) -2:
                if (gVar != null) {
                    if (!bVar.p) {
                        networkSwitchMessageSnapshot = new SmallMessageSnapshot.PausedSnapshot(i, b, (int) bVar.g, (int) bVar.h, gVar.e());
                        break;
                    }
                    networkSwitchMessageSnapshot = new PausedSnapshot(i, b, bVar.g, bVar.h, gVar.e());
                    break;
                }
                throw new AssertionError("runnable == null");
            case (byte) -1:
                if (!bVar.p) {
                    networkSwitchMessageSnapshot = new SmallMessageSnapshot.ErrorMessageSnapshot(i, b, (int) bVar.g, (int) bVar.h, gVar.c(), gVar.e());
                    break;
                }
                networkSwitchMessageSnapshot = new ErrorMessageSnapshot(i, b, bVar.g, bVar.h, gVar.c(), gVar.e());
                break;
            case (byte) 1:
                if (!bVar.p) {
                    networkSwitchMessageSnapshot = new PendingMessageSnapshot(i, b, (int) bVar.g, (int) bVar.h, gVar.e());
                    break;
                }
                networkSwitchMessageSnapshot = new LargeMessageSnapshot.PendingMessageSnapshot(i, b, bVar.g, bVar.h, gVar.e());
                break;
            case (byte) 2:
                String str;
                if (bVar.d) {
                    str = bVar.e;
                } else {
                    str = null;
                }
                if (!bVar.p) {
                    networkSwitchMessageSnapshot = new ConnectedMessageSnapshot(i, b, gVar.b(), (int) bVar.h, bVar.j, str, gVar.e());
                    break;
                }
                networkSwitchMessageSnapshot = new LargeMessageSnapshot.ConnectedMessageSnapshot(i, b, gVar.b(), bVar.h, bVar.j, str, gVar.e());
                break;
            case (byte) 3:
                if (!bVar.p) {
                    networkSwitchMessageSnapshot = new ProgressMessageSnapshot(i, b, (int) bVar.g, (int) bVar.h, gVar.e(), bVar.o);
                    break;
                }
                networkSwitchMessageSnapshot = new LargeMessageSnapshot.ProgressMessageSnapshot(i, b, bVar.g, bVar.h, gVar.e(), bVar.o);
                break;
            case (byte) 5:
                if (!bVar.p) {
                    networkSwitchMessageSnapshot = new RetryMessageSnapshot(i, b, (int) bVar.g, (int) bVar.h, gVar.c(), gVar.d(), gVar.e());
                    break;
                }
                networkSwitchMessageSnapshot = new LargeMessageSnapshot.RetryMessageSnapshot(i, b, bVar.g, bVar.h, gVar.c(), gVar.d(), gVar.e());
                break;
            case (byte) 6:
                if (!bVar.p) {
                    networkSwitchMessageSnapshot = new PendingMessageSnapshot(i, b, (int) bVar.g, (int) bVar.h, gVar.e());
                    break;
                }
                networkSwitchMessageSnapshot = new LargeMessageSnapshot.PendingMessageSnapshot(i, b, bVar.g, bVar.h, gVar.e());
                break;
            case (byte) 7:
                if (!bVar.p) {
                    networkSwitchMessageSnapshot = new PreCreateMessageSnapshot(i, b, gVar.f(), gVar.e());
                    break;
                }
                networkSwitchMessageSnapshot = new LargeMessageSnapshot.PreCreateMessageSnapshot(i, b, gVar.f(), gVar.e());
                break;
            default:
                Throwable illegalStateException;
                String a = b.a("it can't takes a snapshot for the task(%s) when its status is %d,", bVar, Byte.valueOf(b));
                j.e(d.class, a, new Object[0]);
                if (gVar.c() != null) {
                    illegalStateException = new IllegalStateException(a, gVar.c());
                } else {
                    illegalStateException = new IllegalStateException(a);
                }
                if (!bVar.p) {
                    networkSwitchMessageSnapshot = new SmallMessageSnapshot.ErrorMessageSnapshot(i, b, (int) bVar.g, (int) bVar.h, illegalStateException, gVar.e());
                    break;
                }
                networkSwitchMessageSnapshot = new ErrorMessageSnapshot(i, b, bVar.g, bVar.h, illegalStateException, gVar.e());
                break;
        }
        if (j.a && b == (byte) -5) {
            new StringBuilder("MessageSnapshot status = ").append(b).append("  sofar = ").append(networkSwitchMessageSnapshot.b()).append("  total = ").append(networkSwitchMessageSnapshot.a());
        }
        return networkSwitchMessageSnapshot;
    }
}
