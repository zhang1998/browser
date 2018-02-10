package com.loc;

import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;

/* compiled from: ProGuard */
final class cl extends PhoneStateListener {
    final /* synthetic */ cn a;

    cl(cn cnVar) {
        this.a = cnVar;
    }

    public final void onCellLocationChanged(CellLocation cellLocation) {
        try {
            if (this.a.a(cellLocation)) {
                this.a.i = cellLocation;
                if (this.a.n != null) {
                    this.a.n.onCellLocationChanged(cellLocation);
                }
            }
        } catch (Throwable th) {
            cq.a(th, "CgiManager", "initPhoneStateListener7");
        }
    }

    public final void onServiceStateChanged(ServiceState serviceState) {
        try {
            switch (serviceState.getState()) {
                case 0:
                    this.a.c();
                    break;
                case 1:
                    this.a.d();
                    break;
            }
            if (this.a.n != null) {
                this.a.n.onServiceStateChanged(serviceState);
            }
        } catch (Throwable th) {
            cq.a(th, "CgiManager", "initPhoneStateListener4");
        }
    }

    public final void onSignalStrengthChanged(int i) {
        int i2 = -113;
        try {
            switch (this.a.b) {
                case 1:
                    i2 = dm.a(i);
                    break;
                case 2:
                    i2 = dm.a(i);
                    break;
            }
            cn.a(this.a, i2);
            if (this.a.n != null) {
                this.a.n.onSignalStrengthChanged(i);
            }
        } catch (Throwable th) {
            cq.a(th, "CgiManager", "initPhoneStateListener6");
        }
    }

    public final void onSignalStrengthsChanged(SignalStrength signalStrength) {
        if (signalStrength != null) {
            int i = -113;
            try {
                switch (this.a.b) {
                    case 1:
                        i = dm.a(signalStrength.getGsmSignalStrength());
                        break;
                    case 2:
                        i = signalStrength.getCdmaDbm();
                        break;
                }
                cn.a(this.a, i);
                if (this.a.n != null) {
                    this.a.n.onSignalStrengthsChanged(signalStrength);
                }
            } catch (Throwable th) {
                cq.a(th, "CgiManager", "initPhoneStateListener5");
            }
        }
    }
}
