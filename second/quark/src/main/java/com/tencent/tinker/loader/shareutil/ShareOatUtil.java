package com.tencent.tinker.loader.shareutil;

import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/* compiled from: ProGuard */
public final class ShareOatUtil {
    private static final String TAG = "Tinker.OatUtil";

    /* compiled from: ProGuard */
    enum InstructionSet {
        kNone,
        kArm,
        kArm64,
        kThumb2,
        kX86,
        kX86_64,
        kMips,
        kMips64
    }

    private ShareOatUtil() {
        throw new UnsupportedOperationException();
    }

    public static String getOatFileInstructionSet(File file) throws Throwable {
        ShareElfFile shareElfFile;
        String str;
        Throwable th;
        try {
            shareElfFile = new ShareElfFile(file);
            try {
                SectionHeader sectionHeaderByName = shareElfFile.getSectionHeaderByName(".rodata");
                if (sectionHeaderByName == null) {
                    throw new IOException("Unable to find .rodata section.");
                }
                FileChannel channel = shareElfFile.getChannel();
                channel.position(sectionHeaderByName.shOffset);
                byte[] bArr = new byte[8];
                ShareElfFile.readUntilLimit(channel, ByteBuffer.wrap(bArr), "Failed to read oat magic and version.");
                if (bArr[0] == (byte) 111 && bArr[1] == (byte) 97 && bArr[2] == (byte) 116 && bArr[3] == (byte) 10) {
                    str = new String(bArr, 4, 3, Charset.forName("ASCII"));
                    Integer.parseInt(str);
                    ByteBuffer allocate = ByteBuffer.allocate(128);
                    allocate.order(shareElfFile.getDataOrder());
                    channel.position(sectionHeaderByName.shOffset + 12);
                    allocate.limit(4);
                    ShareElfFile.readUntilLimit(channel, allocate, "Failed to read isa num.");
                    int i = allocate.getInt();
                    if (i < 0 || i >= InstructionSet.values().length) {
                        throw new IOException("Bad isa num: " + i);
                    }
                    String str2;
                    switch (InstructionSet.values()[i]) {
                        case kArm:
                        case kThumb2:
                            str2 = "arm";
                            break;
                        case kArm64:
                            str2 = "arm64";
                            break;
                        case kX86:
                            str2 = "x86";
                            break;
                        case kX86_64:
                            str2 = "x86_64";
                            break;
                        case kMips:
                            str2 = "mips";
                            break;
                        case kMips64:
                            str2 = "mips64";
                            break;
                        case kNone:
                            str2 = "none";
                            break;
                        default:
                            throw new IOException("Should not reach here.");
                    }
                    try {
                        shareElfFile.close();
                    } catch (Exception e) {
                    }
                    return str2;
                }
                throw new IOException(String.format("Bad oat magic: %x %x %x %x", new Object[]{Byte.valueOf(bArr[0]), Byte.valueOf(bArr[1]), Byte.valueOf(bArr[2]), Byte.valueOf(bArr[3])}));
            } catch (NumberFormatException e2) {
                throw new IOException("Bad oat version: " + str);
            } catch (Throwable th2) {
                th = th2;
                if (shareElfFile != null) {
                    try {
                        shareElfFile.close();
                    } catch (Exception e3) {
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            shareElfFile = null;
            if (shareElfFile != null) {
                shareElfFile.close();
            }
            throw th;
        }
    }
}
