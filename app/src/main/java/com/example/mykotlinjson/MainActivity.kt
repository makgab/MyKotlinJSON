package com.example.mykotlinjson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import org.json.JSONArray
import org.json.JSONTokener
import java.net.URL
import kotlin.system.exitProcess
import kotlin.concurrent.thread


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // button Exit
        val btnExit = findViewById<Button>(R.id.buttonExit)
        btnExit.setOnClickListener {
            exitProcess(0)
        }

        // button JSON
        val btnJSON = findViewById<Button>(R.id.buttonJSON)
        val txtView = findViewById<TextView>(R.id.textView)
        btnJSON.setOnClickListener {
            val url = "http://m-info.hu:8070/country/"
            thread {
                val json = try {
                    URL(url).readText()
                } catch (e: Exception) {
                    return@thread
                }
                runOnUiThread {
                    // txtView.text = json
                    // https://johncodeos.com/how-to-parse-json-in-android-using-kotlin/
                    var str = ""
                    val jsonArray = JSONTokener(json).nextValue() as JSONArray
                    for (i in 0 until jsonArray.length()) {
                        // country field
                        val country = jsonArray.getJSONObject(i).getString("country_name")
                        Log.i("Country: ", country)

                        // currency field
                        val currency = jsonArray.getJSONObject(i).getString("local_currency")
                        Log.i("Currency: ", currency)

                        // str
                        str += "$country ($currency) \n"
                    }
                    // text
                    txtView.text = str
                }
            }

        }
    }
}
