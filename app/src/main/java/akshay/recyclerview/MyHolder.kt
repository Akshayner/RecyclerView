package akshay.recyclerview

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.indi.view.*

/**
 * Created by iphone on 7/19/2018.
 */
class MyHolder:RecyclerView.ViewHolder {

    var iv :ImageView?= null
    var tv1 :TextView?= null
    var tv2 :TextView?= null

    constructor(v:View) : super(v) {
        iv = v.iv
        tv1 = v.tv1
        tv2 = v.tv2

    }
}