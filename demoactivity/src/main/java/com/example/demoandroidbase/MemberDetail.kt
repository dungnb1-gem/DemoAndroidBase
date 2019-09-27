package com.example.demoandroidbase

class MemberDetail(private var img_profile: Int?, private var name: String, private var title: String) {
    private var favorite: String = "Football, travel ..."

    constructor(img_profile: Int?, name: String, title: String, favorite: String)
            : this(img_profile, name, title) {
        this.favorite = favorite
    }

    var mImgProfile: Int?
        get() {
            return img_profile
        }
        set(value) {
            img_profile = value
        }
    var mName: String
        get() {
            return name
        }
        set(value) {
            this.name = value
        }

    var mTitle: String
        get() {
            return title
        }
        set(value) {
            this.title = value
        }

    var mFavorite: String
        get() {
            return favorite
        }
        set(value) {
            this.favorite = value
        }
}