package com.loc;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import com.uc.apollo.impl.SettingsConst;

/* compiled from: ProGuard */
final class as extends Handler {
    au a = null;
    final /* synthetic */ au b;
    private boolean c = true;
    private boolean d = true;

    public as(au auVar, au auVar2) {
        this.b = auVar;
        this.a = auVar2;
    }

    public final void handleMessage(Message message) {
        try {
            switch (message.what) {
                case 1:
                    try {
                        synchronized (this.b.m) {
                            Bundle data = message.getData();
                            Messenger messenger = message.replyTo;
                            long b = dm.b();
                            boolean z = data.getBoolean("isNeedAddress", true);
                            boolean z2 = data.getBoolean("isOffset", true);
                            boolean z3 = data.getBoolean("isLocationCacheEnable", true);
                            if (!(z == this.c && z2 == this.d)) {
                                this.a.o = 0;
                            }
                            this.c = z;
                            this.d = z2;
                            if (this.b.n == null || this.b.n.g != 0 || b - this.a.o >= 600) {
                                if (!this.b.h.contains(messenger)) {
                                    this.b.h.add(messenger);
                                }
                                this.b.l = true;
                                this.a.m.notify();
                            } else {
                                Message obtain = Message.obtain();
                                Bundle bundle = new Bundle();
                                bundle.putParcelable("location", this.b.n);
                                obtain.setData(bundle);
                                obtain.what = 1;
                                messenger.send(obtain);
                            }
                            boolean z4 = data.getBoolean("wifiactivescan");
                            this.b.b = data.getBoolean("isKillProcess");
                            b = data.getLong("httptimeout");
                            if (this.b.r != null) {
                                this.b.r.put("reversegeo", z);
                                this.b.r.put("isOffset", z2);
                                this.b.r.put("wifiactivescan", z4 ? SettingsConst.TRUE : SettingsConst.FALSE);
                                this.b.r.put("httptimeout", b);
                                this.b.r.put("isLocationCacheEnable", z3);
                            }
                            au.a(this.a, this.b.r);
                        }
                        break;
                    } catch (Throwable th) {
                        cq.a(th, "APSServiceCore", "handleMessage LOCATION");
                        break;
                    }
                    break;
                case 2:
                    this.b.a();
                    break;
                case 3:
                    this.b.b();
                    break;
                case 4:
                    synchronized (this.b.m) {
                        if (this.b.z < de.b()) {
                            this.b.E = true;
                            this.b.z = this.b.z + 1;
                        } else {
                            this.b.E = false;
                        }
                        this.a.m.notify();
                        this.b.f.sendEmptyMessageDelayed(4, 2000);
                    }
                    break;
                case 5:
                    synchronized (this.b.m) {
                        if (de.e()) {
                            this.b.F = true;
                        } else if (!dm.d(this.b.a)) {
                            this.b.F = true;
                        }
                        this.a.m.notify();
                        this.b.f.sendEmptyMessageDelayed(5, (long) (de.d() * 1000));
                    }
                    break;
                case 7:
                    synchronized (this.b.m) {
                        if (!this.b.h.contains(message.replyTo)) {
                            this.b.h.add(message.replyTo);
                        }
                        this.b.G = true;
                        this.a.m.notify();
                    }
                    break;
                case 9:
                    synchronized (this.b.m) {
                        this.a.m.notify();
                    }
                    break;
            }
            super.handleMessage(message);
        } catch (Throwable th2) {
            cq.a(th2, "APSServiceCore", "handleMessage STARTCOLL");
        }
    }
}
