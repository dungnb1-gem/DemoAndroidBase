package com.example.demoandroidbase

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import android.text.method.PasswordTransformationMethod
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.dialog_detail.*


class MemberListActivity : AppCompatActivity(), OnItemClickListener {


    lateinit var mRcvListMember: RecyclerView
    lateinit var listMemberAdapter: MemberListAdapter
    var listMember = arrayListOf<MemberDetail>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_member)
        initView()
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onRestart() {
        super.onRestart()
    }

    override fun onResume() {
        super.onResume()
    }

    private fun initView() {
        mRcvListMember = findViewById(R.id.rcvListMember)
        listMemberAdapter = MemberListAdapter(this, this)
        listMember.add(
            MemberDetail(
                R.drawable.profile_of_nguyen_tien_hoang,
                "Nguyễn Tiến Hoàng",
                "Project Manager",
                "Rủ team đi retro"
            )
        )
        listMember.add(MemberDetail(R.drawable.profile_of_tam_nguyen, "Nguyễn Thị Tâm", "Quality Assurance", "Ăn uống"))
        listMember.add(
            MemberDetail(
                R.drawable.profile_of_tai_handsome,
                "Nguyễn Đình Tài",
                "Android Developer",
                "Đi sapa"
            )
        )
        listMember.add(
            MemberDetail(
                R.drawable.profile_of_vu_tien_dat,
                "Vũ Tiến Đạt",
                "Android Developer",
                "Đổi người yêu"
            )
        )
        listMember.add(MemberDetail(R.drawable.profile_of_gabriel, "Nguyễn Bá Dũng", "Android Developer", "Nghe nhạc"))
        mRcvListMember.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        mRcvListMember.adapter = listMemberAdapter
        listMemberAdapter.refreshData(listMember)
    }

    override fun onItemClick(memberDetail: MemberDetail) {
        val inflater = layoutInflater
        val alertLayout = inflater.inflate(R.layout.dialog_detail, null)
        val imgProfile = alertLayout.findViewById(R.id.img_profile) as ImageView
        val tvName = alertLayout.findViewById(R.id.tv_name) as TextView
        val tvTitle = alertLayout.findViewById(R.id.tv_title) as TextView
        val tvFavorite = alertLayout.findViewById(R.id.tv_favorite) as TextView

        memberDetail.mImgProfile?.let { imgProfile.setImageResource(it) }
        tvName.setText(memberDetail.mName)
        tvTitle.setText(memberDetail.mTitle)
        tvFavorite.setText(memberDetail.mFavorite)

        val alert = AlertDialog.Builder(this)
        alert.setTitle("Detail")
        alert.setView(alertLayout)
        alert.setCancelable(false)

        val dialog = alert.create()
        dialog.setCanceledOnTouchOutside(true)
        dialog.show()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
