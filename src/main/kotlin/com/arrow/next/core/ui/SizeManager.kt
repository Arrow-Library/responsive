package com.arrow.next.core.ui

import android.content.Context
import android.graphics.Point
import android.view.Display
import android.view.WindowManager
import kotlin.math.roundToInt

class SizeManager(context: Context) {

    private val APP_BASE_WIDTH = 640f
    private var mDisplayWidth = 0
    private var mDisplayHeight = 0
    private var mScale = 0f

    init {
        val size = Point()
        val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display = wm.defaultDisplay
        getSize(display, size)
        mDisplayWidth = size.x
        mDisplayHeight = size.y
        mScale = mDisplayWidth / APP_BASE_WIDTH
    }


    fun scale(value: Float): Int {
        return (mScale * value).roundToInt()
    }

    fun scale(value: Int): Int {
        return (mScale * value.toFloat()).roundToInt()
    }

    fun scaleInt(value: Int): Int {
        return (mScale * value).roundToInt()
    }

    fun getScale(): Float {
        return mScale
    }

    fun getDisplayWidth(): Int {
        return mDisplayWidth
    }

    fun getDisplayHeight(): Int {
        return mDisplayHeight
    }



    private fun getSize(display: Display, outSize: Point) {
        display.getSize(outSize)
    }

}