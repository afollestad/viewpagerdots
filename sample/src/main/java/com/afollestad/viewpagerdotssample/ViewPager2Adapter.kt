package com.afollestad.viewpagerdotssample

import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.TextView
import androidx.appcompat.view.ContextThemeWrapper
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class ViewPager2Adapter(
  private val pages: List<Page>
) : RecyclerView.Adapter<ViewPager2Adapter.Holder>() {

  class Holder(val textView: TextView) : RecyclerView.ViewHolder(textView)

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
    val tv = AppCompatTextView(ContextThemeWrapper(parent.context, R.style.PageText))
    tv.layoutParams = ViewGroup.LayoutParams(MATCH_PARENT, MATCH_PARENT)
    return Holder(tv)
  }

  override fun onBindViewHolder(holder: Holder, position: Int) {
    val context = holder.itemView.context
    val page = pages[position]
    val tintColor = ContextCompat.getColor(context, page.getTintColorRes(context))
    holder.textView.setTextColor(tintColor)
    holder.textView.text = page.body
  }

  override fun getItemCount() = pages.size

  fun getItem(position: Int): Page = pages[position]
}

