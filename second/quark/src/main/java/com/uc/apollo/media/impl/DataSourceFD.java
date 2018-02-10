package com.uc.apollo.media.impl;

import com.uc.apollo.annotation.KeepForSdk;
import java.io.FileDescriptor;

@KeepForSdk
/* compiled from: ProGuard */
public class DataSourceFD implements DataSource {
    public FileDescriptor fd;
    public long length;
    public long offset;

    public DataSourceFD(FileDescriptor fileDescriptor, long j, long j2) {
        this.fd = fileDescriptor;
        this.offset = j;
        this.length = j2;
    }

    protected void finalize() throws Throwable {
        super.finalize();
        reset();
    }

    public void reset() {
        this.fd = null;
        this.offset = 0;
        this.length = 0;
    }

    public String toString() {
        return "FileDescriptor/offset/length " + this.fd + "/" + this.offset + "/" + this.length;
    }
}
