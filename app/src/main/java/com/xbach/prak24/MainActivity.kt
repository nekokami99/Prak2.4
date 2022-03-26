package com.xbach.prak24

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.core.content.res.ResourcesCompat
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);

        val km = findViewById<EditText>(R.id.km);
        val m = findViewById<EditText>(R.id.m);
        val dm = findViewById<EditText>(R.id.dm);
        val sm = findViewById<EditText>(R.id.sm);
        val mm = findViewById<EditText>(R.id.mm);

        val btn = findViewById<Button>(R.id.inspect);

        val img = findViewById<ImageView>(R.id.answer);

        val tv = findViewById<TextView>(R.id.rezult);

        btn.setOnClickListener{
            if(km.text.toString().toFloat() == (m.text.toString().toFloat()/1000).toString().toFloat()
                && m.text.toString().toFloat() == (dm.text.toString().toFloat()/10).toString().toFloat()
                && dm.text.toString().toFloat() == (sm.text.toString().toFloat()/10).toString().toFloat()
                && sm.text.toString().toFloat() == (mm.text.toString().toFloat()/10).toString().toFloat()){
                tv.text=getString(R.string.goodResult)
                tv.setTextColor(resources.getColor(R.color.blue))
                img.setImageResource(R.drawable.cool)
            }
            else{
                tv.text=getString(R.string.badResult)
                tv.setTextColor(resources.getColor(R.color.red))
                img.setImageResource(R.drawable.bad)
            }
        }

        img.setOnClickListener{
            var transparency: Float = img.alpha

            if (transparency.toString() == "0.1")
                img.alpha = 1.0.toFloat()
            else
                img.alpha = (((transparency - 0.1) * 10.0).roundToInt() / 10.0).toFloat()
        }
    }

}