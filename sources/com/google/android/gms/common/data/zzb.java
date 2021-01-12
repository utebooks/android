package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.zzaa;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class zzb<T> implements Iterator<T> {
    protected final DataBuffer<T> zzaoX;
    protected int zzaoY = -1;

    public zzb(DataBuffer<T> dataBuffer) {
        this.zzaoX = (DataBuffer) zzaa.zzz(dataBuffer);
    }

    public boolean hasNext() {
        return this.zzaoY < this.zzaoX.getCount() + -1;
    }

    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException(new StringBuilder(46).append("Cannot advance the iterator beyond ").append(this.zzaoY).toString());
        }
        DataBuffer<T> dataBuffer = this.zzaoX;
        int i = this.zzaoY + 1;
        this.zzaoY = i;
        return dataBuffer.get(i);
    }

    public void remove() {
        throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
    }
}
