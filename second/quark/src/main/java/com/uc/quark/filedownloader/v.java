package com.uc.quark.filedownloader;

import com.uc.quark.filedownloader.e.b;
import com.uc.quark.filedownloader.e.j;
import com.uc.quark.filedownloader.message.BlockCompleteMessage;
import com.uc.quark.filedownloader.message.MessageSnapshot;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import junit.framework.Assert;

/* compiled from: ProGuard */
final class v implements h {
    private at a;
    private q b;
    private Queue<MessageSnapshot> c = new LinkedBlockingQueue();

    v(at atVar, q qVar) {
        this.a = atVar;
        this.b = qVar;
    }

    public final boolean a() {
        if (j.a) {
            j.d(this, "notify begin %s", this.a);
        }
        if (this.a == null) {
            j.e(this, "can't begin the task, the holder fo the messenger is nil, %d", Integer.valueOf(this.c.size()));
            return false;
        }
        this.b.c();
        return true;
    }

    public final void a(MessageSnapshot messageSnapshot) {
        if (j.a) {
            j.d(this, "notify pending %s", this.a);
        }
        k(messageSnapshot);
    }

    public final void b(MessageSnapshot messageSnapshot) {
        if (j.a) {
            j.d(this, "notify started %s", this.a);
        }
        k(messageSnapshot);
    }

    public final void c(MessageSnapshot messageSnapshot) {
        if (j.a) {
            j.d(this, "notify connected %s", this.a);
        }
        k(messageSnapshot);
    }

    public final void d(MessageSnapshot messageSnapshot) {
        aa M = this.a.M();
        if (j.a) {
            j.d(this, "notify progress %s %d %d", M, Long.valueOf(M.o()), Long.valueOf(M.q()));
        }
        if (M.g() > 0) {
            k(messageSnapshot);
        } else if (j.a) {
            j.d(this, "notify progress but client not request notify %s", this.a);
        }
    }

    public final void e(MessageSnapshot messageSnapshot) {
        if (j.a) {
            j.d(this, "notify block completed %s %s", this.a, Thread.currentThread().getName());
        }
        k(messageSnapshot);
    }

    public final void f(MessageSnapshot messageSnapshot) {
        if (j.a) {
            aa M = this.a.M();
            j.d(this, "notify retry %s %d %d %s", this.a, Integer.valueOf(M.x()), Integer.valueOf(M.y()), M.u());
        }
        k(messageSnapshot);
    }

    public final void g(MessageSnapshot messageSnapshot) {
        if (j.a) {
            j.d(this, "notify warn %s", this.a);
        }
        this.b.d();
        k(messageSnapshot);
    }

    public final void h(MessageSnapshot messageSnapshot) {
        if (j.a) {
            j.d(this, "notify error %s %s", this.a, this.a.M().u());
        }
        this.b.d();
        k(messageSnapshot);
    }

    public final void i(MessageSnapshot messageSnapshot) {
        if (j.a) {
            j.d(this, "notify paused %s", this.a);
        }
        this.b.d();
        k(messageSnapshot);
    }

    public final void j(MessageSnapshot messageSnapshot) {
        if (j.a) {
            j.d(this, "notify network switch %s", this.a);
        }
        this.b.d();
        k(messageSnapshot);
    }

    private void k(MessageSnapshot messageSnapshot) {
        Assert.assertTrue(b.a("request process message %d, but has already over %d", Byte.valueOf(messageSnapshot.i()), Integer.valueOf(this.c.size())), this.a != null);
        messageSnapshot.f = this.a.M();
        this.c.offer(messageSnapshot);
        ao a = ao.a();
        if (d()) {
            if (c()) {
                b();
            } else if (e()) {
                a.a.execute(new au(a, this));
            } else {
                if (!(ao.c() || a.b.isEmpty())) {
                    synchronized (a.c) {
                        if (!a.b.isEmpty()) {
                            Iterator it = a.b.iterator();
                            while (it.hasNext()) {
                                a.a((h) it.next());
                            }
                        }
                        a.b.clear();
                    }
                }
                if (ao.c()) {
                    synchronized (a.c) {
                        a.b.offer(this);
                    }
                    a.b();
                    return;
                }
                a.a((h) this);
            }
        } else if (j.a) {
            j.d(a, "can't handover the message[%s], no listener be found in task to receive.", this);
        }
    }

    public final void b() {
        MessageSnapshot messageSnapshot = (MessageSnapshot) this.c.poll();
        if (messageSnapshot != null) {
            int i;
            byte i2 = messageSnapshot.i();
            Assert.assertTrue(b.a("can't handover the message, no master to receive this message(status[%d]) size[%d]", Integer.valueOf(i2), Integer.valueOf(this.c.size())), this.a != null);
            m m = this.a.M().m();
            u N = this.a.N();
            if (i2 < (byte) 0) {
                i = 1;
            } else {
                i = 0;
            }
            if (i != 0) {
                this.c.isEmpty();
                this.a = null;
            }
            if (m == null) {
                j.e(this, "The task[%d] can't receive the message(status: [%d]), its download listener might be removed when it is running in FileDownloader", Integer.valueOf(r5.e()), Integer.valueOf(i2));
            } else if (i2 == (byte) 4) {
                try {
                    m.a(messageSnapshot);
                    messageSnapshot = ((BlockCompleteMessage) messageSnapshot).o_();
                    if (j.a) {
                        j.d(this, "notify completed %s", this.a);
                    }
                    this.b.d();
                    k(messageSnapshot);
                } catch (Throwable th) {
                    h(N.a(th));
                }
            } else {
                m.a(messageSnapshot);
            }
        }
    }

    public final boolean c() {
        return this.a.M().z();
    }

    public final boolean d() {
        return this.a.M().m() != null;
    }

    public final boolean e() {
        MessageSnapshot messageSnapshot = (MessageSnapshot) this.c.peek();
        return messageSnapshot != null && messageSnapshot.i() == (byte) 4;
    }

    public final String toString() {
        return b.a("%d:%s", Integer.valueOf(this.a.M().e()), super.toString());
    }
}
