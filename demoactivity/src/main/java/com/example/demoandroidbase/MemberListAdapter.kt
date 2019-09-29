package com.example.demoandroidbase

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_member.view.*

class MemberListAdapter(context: Context, onItemClickListener: OnItemClickListener) :
    RecyclerView.Adapter<MemberListHolder>() {
    var mContext: Context = context
    var mOnItemClickListener = onItemClickListener
    var mListMember = arrayListOf<MemberDetail>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemberListHolder {
        var itemView: View = LayoutInflater.from(this.mContext).inflate(R.layout.item_member, parent, false)
        return MemberListHolder(itemView)
    }

    override fun onBindViewHolder(holder: MemberListHolder, position: Int) {
        var member_detail = mListMember.get(position)
        member_detail.mImgProfile?.let { holder.itemView.img_profile.setImageResource(it) }
        holder.itemView.tv_name.setText(member_detail.mName)
        holder.itemView.tv_title.setText(member_detail.mTitle)

        holder.itemView.setOnClickListener {
            mOnItemClickListener.onItemClick(mListMember.get(holder.adapterPosition))
        }
    }

    override fun getItemCount(): Int {
        return mListMember.size
    }

    fun refreshData(list_member: ArrayList<MemberDetail>) {
        mListMember.clear()
        mListMember.addAll(list_member)
        notifyDataSetChanged()
    }
}


class MemberListHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

interface OnItemClickListener {
    fun onItemClick(memberDetail: MemberDetail)
}
