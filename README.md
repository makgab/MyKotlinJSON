# MyKotlinJSON Android App

Sample Android application to handle JSON communication with a django-rest-api service.

It is a very simple solution!

Recommended in production environment: okhttp3 https://square.github.io/okhttp/




## Features

- Development Environment:
  - Android Studio


- App elements:
  - TextView
  - Button (Exit)
  - Button (JSON...)


- AndroidManifest.xml:
  - Permission to Internet:
  ```
  <uses-permission android:name="android.permission.INTERNET" />
  ```
  - HTTP protocol (not recommended yet): in <application> section:
  ```
  android:usesCleartextTraffic="true"
  ```


- Components (classes, packages):
  - import androidx.appcompat.app.AppCompatActivity
  - import android.os.Bundle
  - import android.util.Log
  - import android.widget.Button
  - import android.widget.TextView
  - import org.json.JSONArray
  - import org.json.JSONTokener
  - import java.net.URL
  - import kotlin.system.exitProcess
  - import kotlin.concurrent.thread


- JSON communication with these fields:
  - country_name, local_currency


