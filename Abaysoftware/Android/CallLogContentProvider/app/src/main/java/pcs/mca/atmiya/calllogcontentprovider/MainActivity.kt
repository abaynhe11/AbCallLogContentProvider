package pcs.mca.atmiya.calllogcontentprovider

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CallLog
import android.widget.SimpleCursorAdapter
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var cols= arrayOf(CallLog.Calls._ID,
                         CallLog.Calls.NUMBER,
                         CallLog.Calls.TYPE,
                         CallLog.Calls.DURATION)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(ActivityCompat.checkSelfPermission(this,
                Manifest.permission.READ_CALL_LOG) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,
                arrayOf(Manifest.permission.READ_CALL_LOG),101)
        }
        else
            displayLog()
    }

    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<out String>,
                                            grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode==101 && grantResults[0]==PackageManager.PERMISSION_GRANTED)
            displayLog()
    }

    @SuppressLint("MissingPermission")
    private fun displayLog() {
        var from = arrayOf(CallLog.Calls.NUMBER,
                CallLog.Calls.DURATION,
                CallLog.Calls.TYPE)
        var to = intArrayOf(R.id.textView1,R.id.textView2,R.id.textView3)
        var rs =  contentResolver.query(CallLog.Calls.CONTENT_URI,
                            cols,null,null,
                    "${CallLog.Calls.LAST_MODIFIED} DESC")
        var adapter = SimpleCursorAdapter(applicationContext,
                                          R.layout.mylayout,
                                            rs,
                                           from,
                                            to,0)
        listview.adapter = adapter
    }
}




















