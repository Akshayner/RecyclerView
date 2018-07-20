package akshay.recyclerview

import android.Manifest
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val lm= LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        rv.layoutManager = lm

        var a = ContextCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE)
        if (a==PackageManager.PERMISSION_GRANTED){
            read()
        }
        else{
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),123)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (grantResults[0]==PackageManager.PERMISSION_GRANTED){
            read()
        }
        else{
            Toast.makeText(this@MainActivity,"Give Permission",Toast.LENGTH_LONG).show()
        }
    }

    fun read(){

        rv.adapter = MyAdapter(this)
    }
}
