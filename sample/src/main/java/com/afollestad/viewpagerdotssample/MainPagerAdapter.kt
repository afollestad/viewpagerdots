/*
 * Licensed under Apache-2.0
 *
 * Designed and developed by Aidan Follestad (@afollestad)
 */
package com.afollestad.viewpagerdotssample

import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter

/** @author Aidan Follestad (afollestad) */
class MainPagerAdapter : PagerAdapter() {

  override fun instantiateItem(
    collection: ViewGroup,
    position: Int
  ): Any {
    var resId = 0
    when (position) {
      0 -> resId = R.id.pageOne
      1 -> resId = R.id.pageTwo
      2 -> resId = R.id.pageThree
      3 -> resId = R.id.pageFour
    }
    return collection.findViewById(resId)
  }

  override fun isViewFromObject(
    arg0: View,
    arg1: Any
  ) = arg0 === arg1 as View

  override fun getCount() = 4

  override fun getPageTitle(position: Int) = when (position) {
    0 -> "One"
    1 -> "Two"
    2 -> "Three"
    3 -> "Four"
    else -> null
  }

  override fun destroyItem(
    container: ViewGroup,
    position: Int,
    arg1: Any
  ) = Unit
}
