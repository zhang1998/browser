package com.UCMobile.Apollo.text;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.UCMobile.Apollo.MediaFormat;
import com.UCMobile.Apollo.d;
import com.UCMobile.Apollo.util.e;
import java.io.IOException;

/* compiled from: ProGuard */
public final class g implements Callback {
    private final f a;
    private final Handler b;
    private d c;
    private boolean d;
    private d e;
    private IOException f;
    private RuntimeException g;
    private boolean h;
    private long i;

    public g(Looper looper, f fVar) {
        this.b = new Handler(looper, this);
        this.a = fVar;
        a();
    }

    public final synchronized void a() {
        this.c = new d();
        this.d = false;
        this.e = null;
        this.f = null;
        this.g = null;
    }

    public final synchronized void b() {
        Object obj = 1;
        synchronized (this) {
            if (this.d) {
                obj = null;
            }
            if (obj == null) {
                throw new IllegalStateException();
            }
            this.d = true;
            this.e = null;
            this.f = null;
            this.g = null;
            this.b.obtainMessage(1, e.a(this.c.d), e.b(this.c.d), this.c).sendToTarget();
        }
    }

    public final boolean handleMessage(Message message) {
        boolean z = false;
        e eVar = null;
        switch (message.what) {
            case 0:
                MediaFormat mediaFormat = (MediaFormat) message.obj;
                if (mediaFormat.t == Long.MAX_VALUE) {
                    z = true;
                }
                this.h = z;
                this.i = this.h ? 0 : mediaFormat.t;
                break;
            case 1:
                RuntimeException runtimeException;
                IOException iOException;
                long a = e.a(message.arg1, message.arg2);
                d dVar = (d) message.obj;
                try {
                    runtimeException = null;
                    iOException = null;
                    eVar = this.a.a(dVar.b.array(), dVar.c);
                } catch (IOException e) {
                    runtimeException = null;
                    iOException = e;
                } catch (RuntimeException e2) {
                    runtimeException = e2;
                    iOException = null;
                }
                synchronized (this) {
                    if (this.c == dVar) {
                        this.e = new d(eVar, this.h, a, this.i);
                        this.f = iOException;
                        this.g = runtimeException;
                        this.d = false;
                    }
                }
                break;
        }
        return true;
    }
}
