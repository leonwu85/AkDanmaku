/*
 * The MIT License (MIT)
 *
 * Copyright 2021 Kwai, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.kuaishou.akdanmaku.utils

import java.util.*

/**
 * 自定义的 clamp 函数，用于替代 androidx.core.math.MathUtils.clamp
 */
fun <T : Comparable<T>> clamp(value: T, min: T, max: T): T {
    return when {
        value < min -> min
        value > max -> max
        else -> value
    }
}

/**
 * 简单的对象池实现，用于替代 com.badlogic.gdx.utils.Pools.SimplePool
 * 以解决兼容性问题
 */
class SimplePool<T>(private val maxPoolSize: Int = 100) {
    private val pool = Stack<T>()
    private var newObjectCallback: (() -> T)? = null

    constructor(maxPoolSize: Int, factory: () -> T) : this(maxPoolSize) {
        this.newObjectCallback = factory
    }

    constructor(factory: () -> T) : this(100) {
        this.newObjectCallback = factory
    }

    fun acquire(): T? {
        return if (pool.isNotEmpty()) {
            pool.pop()
        } else {
            newObjectCallback?.invoke()
        }
    }

    fun release(obj: T): Boolean {
        if (pool.size < maxPoolSize) {
            pool.push(obj)
            return true
        }
        return false
    }

    fun fill(count: Int) {
        repeat(count) {
            newObjectCallback?.invoke()?.let { pool.push(it) }
        }
    }
}
