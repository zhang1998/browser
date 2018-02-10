package android.support.multidex;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.zip.CRC32;
import java.util.zip.ZipException;

/* compiled from: ProGuard */
final class f {
    static long a(File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        try {
            long a = a(randomAccessFile, a(randomAccessFile));
            return a;
        } finally {
            randomAccessFile.close();
        }
    }

    private static e a(RandomAccessFile randomAccessFile) throws IOException, ZipException {
        long j = 0;
        long length = randomAccessFile.length() - 22;
        if (length < 0) {
            throw new ZipException("File too short to be a zip file: " + randomAccessFile.length());
        }
        long j2 = length - 65536;
        if (j2 >= 0) {
            j = j2;
        }
        int reverseBytes = Integer.reverseBytes(101010256);
        j2 = length;
        do {
            randomAccessFile.seek(j2);
            if (randomAccessFile.readInt() != reverseBytes) {
                j2--;
            } else {
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                e eVar = new e();
                eVar.b = ((long) Integer.reverseBytes(randomAccessFile.readInt())) & 4294967295L;
                eVar.a = ((long) Integer.reverseBytes(randomAccessFile.readInt())) & 4294967295L;
                return eVar;
            }
        } while (j2 >= j);
        throw new ZipException("End Of Central Directory signature not found");
    }

    private static long a(RandomAccessFile randomAccessFile, e eVar) throws IOException {
        CRC32 crc32 = new CRC32();
        long j = eVar.b;
        randomAccessFile.seek(eVar.a);
        byte[] bArr = new byte[16384];
        int read = randomAccessFile.read(bArr, 0, (int) Math.min(16384, j));
        while (read != -1) {
            crc32.update(bArr, 0, read);
            j -= (long) read;
            if (j == 0) {
                break;
            }
            read = randomAccessFile.read(bArr, 0, (int) Math.min(16384, j));
        }
        return crc32.getValue();
    }
}
