/**
 * Designed and developed by Aidan Follestad (@afollestad)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.afollestad.viewpagerdotssample

import android.graphics.Color
import androidx.viewpager.widget.ViewPager

internal fun ViewPager.onPageSelected(selection: (Int) -> Unit) {
  addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
    override fun onPageSelected(position: Int) = selection(position)

    override fun onPageScrollStateChanged(state: Int) = Unit

    override fun onPageScrolled(
      position: Int,
      positionOffset: Float,
      positionOffsetPixels: Int
    ) = Unit
  })
}

internal fun Int.isColorLight(): Boolean {
  if (this == Color.BLACK) {
    return false
  } else if (this == Color.WHITE || this == Color.TRANSPARENT) {
    return true
  }
  val darkness =
    1 - (0.299 * Color.red(this) +
        0.587 * Color.green(this) +
        0.114 * Color.blue(this)) / 255
  return darkness < 0.4
}
