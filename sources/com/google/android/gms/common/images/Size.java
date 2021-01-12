package com.google.android.gms.common.images;

public final class Size {
    private final int zzpi;
    private final int zzpj;

    public Size(int i, int i2) {
        this.zzpi = i;
        this.zzpj = i2;
    }

    public static Size parseSize(String str) throws NumberFormatException {
        if (str == null) {
            throw new IllegalArgumentException("string must not be null");
        }
        int indexOf = str.indexOf(42);
        if (indexOf < 0) {
            indexOf = str.indexOf(120);
        }
        if (indexOf < 0) {
            throw zzdb(str);
        }
        try {
            return new Size(Integer.parseInt(str.substring(0, indexOf)), Integer.parseInt(str.substring(indexOf + 1)));
        } catch (NumberFormatException e) {
            throw zzdb(str);
        }
    }

    private static NumberFormatException zzdb(String str) {
        throw new NumberFormatException(new StringBuilder(String.valueOf(str).length() + 16).append("Invalid Size: \"").append(str).append("\"").toString());
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Size)) {
            return false;
        }
        Size size = (Size) obj;
        if (!(this.zzpi == size.zzpi && this.zzpj == size.zzpj)) {
            z = false;
        }
        return z;
    }

    public int getHeight() {
        return this.zzpj;
    }

    public int getWidth() {
        return this.zzpi;
    }

    public int hashCode() {
        return this.zzpj ^ ((this.zzpi << 16) | (this.zzpi >>> 16));
    }

    public String toString() {
        int i = this.zzpi;
        return new StringBuilder(23).append(i).append("x").append(this.zzpj).toString();
    }
}
