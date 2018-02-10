package com.uc.quark.filedownloader.message;

import com.uc.quark.filedownloader.e.b;
import junit.framework.Assert;

/* compiled from: ProGuard */
public interface BlockCompleteMessage {

    /* compiled from: ProGuard */
    public class BlockCompleteMessageImpl extends MessageSnapshot implements BlockCompleteMessage {
        private final MessageSnapshot g;

        public BlockCompleteMessageImpl(MessageSnapshot messageSnapshot) {
            boolean z = true;
            super(messageSnapshot.a, (byte) 4, messageSnapshot.j());
            String a = b.a("can't create the block complete message for id[%d], status[%d]", Integer.valueOf(messageSnapshot.a), Byte.valueOf(messageSnapshot.i()));
            if (messageSnapshot.i() != (byte) -3) {
                z = false;
            }
            Assert.assertTrue(a, z);
            this.g = messageSnapshot;
        }

        public final MessageSnapshot o_() {
            return this.g;
        }
    }

    MessageSnapshot o_();
}
