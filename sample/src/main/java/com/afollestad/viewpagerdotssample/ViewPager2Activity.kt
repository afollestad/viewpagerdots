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

import android.content.Context
import android.os.Bundle
import androidx.annotation.ColorRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_viewpager2.*

class ViewPager2Activity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_viewpager2)

    val adapter = ViewPager2Adapter(listOf(
      Page(R.color.blue, "Page One", "One"),
      Page(R.color.red, "Page Two", "Two"),
      Page(R.color.white, "Page Three", "Three"),
      Page(R.color.green, "Page Four", "Four")
    ))
    pager.adapter = adapter
    pager.offscreenPageLimit = 3
    dots.attachViewPager2(pager)

    pager.onPageSelected { position ->
      val page = adapter.getItem(position)
      frame.setBackgroundColor(ContextCompat.getColor(this, page.backgroundColorRes))
      dots.setDotTintRes(page.getTintColorRes(this))
    }
  }
}

data class Page(
  @ColorRes val backgroundColorRes: Int,
  val body: String,
  val title: String
) {
  @ColorRes
  fun getTintColorRes(context: Context): Int {
    val backgroundColor = ContextCompat.getColor(context, backgroundColorRes)
    return if (backgroundColor.isColorLight()) R.color.black else R.color.white
  }
}
