package pcs.mca.atmiya.calllogcontentprovider

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_alarm_on.*

class AlarmOnActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm_on)

        var mp = MediaPlayer.create(applicationContext,R.raw.alarm_tone)
        mp.start()

        button2.setOnClickListener {
            mp.stop()
        }
    }
}
