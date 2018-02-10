package android.support.v7.widget;

import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;

/* compiled from: ProGuard */
final class du {
    int a = 0;
    int b = 0;
    int c = SectionHeader.SHT_LOUSER;
    int d = SectionHeader.SHT_LOUSER;
    int e = 0;
    int f = 0;
    boolean g = false;
    boolean h = false;

    du() {
    }

    public final void a(int i, int i2) {
        this.c = i;
        this.d = i2;
        this.h = true;
        if (this.g) {
            if (i2 != SectionHeader.SHT_LOUSER) {
                this.a = i2;
            }
            if (i != SectionHeader.SHT_LOUSER) {
                this.b = i;
                return;
            }
            return;
        }
        if (i != SectionHeader.SHT_LOUSER) {
            this.a = i;
        }
        if (i2 != SectionHeader.SHT_LOUSER) {
            this.b = i2;
        }
    }
}
