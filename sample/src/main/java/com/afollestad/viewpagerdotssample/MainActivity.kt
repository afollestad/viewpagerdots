/*
 * Licensed under Apache-2.0
 *
 * Designed and developed by Aidan Follestad (@afollestad)
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
