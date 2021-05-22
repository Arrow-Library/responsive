package com.arrow.next.core.ui

import android.util.TypedValue
import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject


object Binding : KoinComponent {

    private val sizeManager: SizeManager by inject()

    @BindingAdapter("textSize")
    @JvmStatic
    fun setTextSize(view: TextView, size: Float) {
        view.setTextSize(TypedValue.COMPLEX_UNIT_PX, sizeManager.scale(size).toFloat())
    }

    @BindingAdapter("width")
    @JvmStatic
    fun setWidth(view: View, size: Float) {
        val params = view.layoutParams
        params.width = sizeManager.scale(size).toInt()
        view.layoutParams = params
        view.invalidate()
    }

    @BindingAdapter("height")
    @JvmStatic
    fun setHeight(view: View, size: Float) {
        val params = view.layoutParams
        params.height = sizeManager.scale(size).toInt()
        view.layoutParams = params
    }

    @BindingAdapter("padding")
    @JvmStatic
    fun setPadding(view: View, padding: String) {
        val paddings = padding.split(",")
        var left: Int = 0
        var top: Int = 0
        var right: Int = 0
        var bottom: Int = 0
        when (paddings.size) {
            1 -> {
                paddings[0].trim().toIntOrNull()?.let {
                    left = it
                }
            }
            2 -> {
                paddings[0].trim().toIntOrNull()?.let {
                    left = it
                }
                paddings[1].trim().toIntOrNull()?.let {
                    top = it
                }
            }
            3 -> {
                paddings[0].trim().toIntOrNull()?.let {
                    left = it
                }
                paddings[1].trim().toIntOrNull()?.let {
                    top = it
                }
                paddings[2].trim().toIntOrNull()?.let {
                    right = it
                }
            }
            4 -> {
                paddings[0].trim().toIntOrNull()?.let {
                    left = it
                }
                paddings[1].trim().toIntOrNull()?.let {
                    top = it
                }
                paddings[2].trim().toIntOrNull()?.let {
                    right = it
                }
                paddings[3].trim().toIntOrNull()?.let {
                    bottom = it
                }
            }
        }
        view.setPadding(
            sizeManager.scaleInt(left),
            sizeManager.scaleInt(top),
            sizeManager.scaleInt(right),
            sizeManager.scaleInt(bottom)
        )
    }

    @BindingAdapter("margin")
    @JvmStatic
    fun setMargin(view: View, margin: String) {
        val margins = margin.split(",")
        var left: Int = 0
        var top: Int = 0
        var right: Int = 0
        var bottom: Int = 0
        when (margins.size) {
            1 -> {
                margins[0].trim().toIntOrNull()?.let {
                    left = it
                }
            }
            2 -> {
                margins[0].trim().toIntOrNull()?.let {
                    left = it
                }
                margins[1].trim().toIntOrNull()?.let {
                    top = it
                }
            }
            3 -> {
                margins[0].trim().toIntOrNull()?.let {
                    left = it
                }
                margins[1].trim().toIntOrNull()?.let {
                    top = it
                }
                margins[2].trim().toIntOrNull()?.let {
                    right = it
                }
            }
            4 -> {
                margins[0].trim().toIntOrNull()?.let {
                    left = it
                }
                margins[1].trim().toIntOrNull()?.let {
                    top = it
                }
                margins[2].trim().toIntOrNull()?.let {
                    right = it
                }
                margins[3].trim().toIntOrNull()?.let {
                    bottom = it
                }
            }
        }
        view.margin(
            sizeManager.scaleInt(left),
            sizeManager.scaleInt(top),
            sizeManager.scaleInt(right),
            sizeManager.scaleInt(bottom)
        )
    }
}