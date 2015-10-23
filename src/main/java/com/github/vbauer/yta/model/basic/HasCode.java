/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Vladislav Bauer
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.github.vbauer.yta.model.basic;

import com.google.common.collect.ImmutableList;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import java.util.Optional;

/**
 * Interface which indicates that class should have code.
 *
 * @author Vladislav Bauer
 */

public interface HasCode<T> extends Serializable {

    T code();


    /**
     * @author Vladislav Bauer
     */
    final class HasCodeUtils {

        private HasCodeUtils() {
            throw new UnsupportedOperationException();
        }


        public static <T, E extends HasCode<T>> Optional<E> findByCode(final T code, final Collection<E> collection) {
            return Optional.ofNullable(collection)
                .orElseGet(ImmutableList::of)
                .stream()
                    .filter(item -> Objects.equals(code, item.code()))
                    .findFirst();
        }

    }

}
