package akshay.recyclerview

import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import java.io.File

/**
 * Created by iphone on 7/19/2018.
 */
class MyAdapter: RecyclerView.Adapter<MyHolder> {
    var files : Array<File>? = null
    var activity : MainActivity? = null
    var file:File? = null

    constructor(activity: MainActivity){
        var path = "/storage/sdcard0/WhatsApp/Media/WhatsApp Images/"
        file = File(path)
        if (!file!!.exists()){
            path = "/storage/emulated/0/WhatsApp/Media/WhatsApp Images/"
            file = File(path)
        }
        val files= file!!.listFiles()

        this.files =files
        this.activity = activity


    }
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyHolder {
    val inflater = LayoutInflater.from(activity)
        val v = inflater.inflate(R.layout.indi,p0,false)
        return MyHolder(v)
    }

    override fun getItemCount(): Int {
    return  files!!.size
    }

    override fun onBindViewHolder(p0: MyHolder, p1: Int) {
        var f = files!![p1]
        p0.iv!!.setImageURI(Uri.fromFile(f))
        p0.tv1!!.text = f.name.toString()
        p0.tv2!!.text = "${f.length()/1024} kb"
        p0.b1!!.setOnClickListener{
            f.delete()
            files =file!!.listFiles()
            this@MyAdapter.notifyDataSetChanged()
        }

    }
}