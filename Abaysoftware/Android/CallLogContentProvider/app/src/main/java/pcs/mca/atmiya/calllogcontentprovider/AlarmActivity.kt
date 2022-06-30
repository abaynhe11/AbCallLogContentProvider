package pcs.mca.atmiya.calllogcontentprovider

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_alarm.*

class AlarmActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm)

        button.setOnClickListener {
            var seconds = editText.text.toString().toInt()
            var i = Intent(applicationContext,MyBroadcastReceiver::class.java)
            var pi = PendingIntent.getBroadcast(applicationContext,111,i,0)
            var am:AlarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
            am.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis() + (seconds*1000),pi)
            Toast.makeText(applicationContext,"Alarm set for $seconds",Toast.LENGTH_LONG).show()
        }
    }
}
