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

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.dots
import kotlinx.android.synthetic.main.activity_main.frame
import kotlinx.android.synthetic.main.activity_main.pager

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    pager.adapter = MainPagerAdapter()
    pager.offscreenPageLimit = 3
    dots.attachViewPager(pager)

    pager.onPageSelected {
      val colorRes = when (it) {
        0 -> R.color.blue
        1 -> R.color.red
        2 -> R.color.white
        else -> R.color.green
      }
      val color = ContextCompat.getColor(this, colorRes)
      frame.setBackgroundColor(color)
      dots.setDotTintRes(if (color.isColorLight()) R.color.black else R.color.white)
    }
  }
}
