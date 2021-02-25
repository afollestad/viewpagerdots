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
