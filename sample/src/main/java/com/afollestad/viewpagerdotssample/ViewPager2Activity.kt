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
