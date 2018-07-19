package akshay.recyclerview

import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import java.io.File

/**
 * Created by iphone on 7/19/2018.
 */
class Myadapter: RecyclerView.Adapter<MyHolder> {
    var files : Array<File>? = null
    var activity : MainActivity? = null

    constructor(activity: MainActivity){
        var path = "/storage/sdcard0/WhatsApp/WhatsApp Images/"
        var file = File(path)
        if (!file.exists()){
            path = "/storage/sdcard0/WhatsApp/WhatsApp Images/"
            file = File(path)
        }
        var files= file.listFiles()

        this.files =files
        this.activity = activity


    }
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyHolder {
    var inflater = LayoutInflater.from(activity)
        var v = inflater.inflate(R.layout.indi,p0,false)
        return MyHolder(v)
    }

    override fun getItemCount(): Int {
    return  files!!.size
    }

    override fun onBindViewHolder(p0: MyHolder, p1: Int) {
        p0.iv!!.setImageURI(Uri.fromFile(files!![p1]))
        p0.tv1!!.text = files!![p1].toString()
        p0.tv2!!.text = files!![p1].toString()+"bytes"

    }
}