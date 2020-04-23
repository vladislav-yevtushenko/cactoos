/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2017-2020 Yegor Bugayenko
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package org.cactoos.set;

import java.util.Comparator;
import java.util.SortedSet;

/**
 * SortedSet envelope.
 * <p>There is no thread-safety guarantee.</p>
 *
 * @param <T> Element type
 * @checkstyle AbstractClassNameCheck (500 lines)
 * @since 0.45
 */
@SuppressWarnings(
    {
        "PMD.TooManyMethods",
        "PMD.AbstractNaming"
    }
)
public abstract class SortedSetEnvelope<T> extends SetEnvelope<T> implements
    SortedSet<T> {

    /**
     * The original Set this object delegates to.
     */
    private final SortedSet<T> origin;

    /**
     * Primary ctor.
     * @param origin The original SortedSet to delegate to.
     */
    protected SortedSetEnvelope(final SortedSet<T> origin) {
        super(origin);
        this.origin = origin;
    }

    @Override
    public final Comparator<? super T> comparator() {
        return this.origin.comparator();
    }

    @Override
    public final SortedSet<T> subSet(final T begin, final T end) {
        return this.origin.subSet(begin, end);
    }

    @Override
    public final SortedSet<T> headSet(final T end) {
        return this.origin.headSet(end);
    }

    @Override
    public final SortedSet<T> tailSet(final T from) {
        return this.origin.tailSet(from);
    }

    @Override
    public final T first() {
        return this.origin.first();
    }

    @Override
    public final T last() {
        return this.origin.last();
    }

}