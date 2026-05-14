package com.example.nammaplatform

import android.content.Context
import android.graphics.Color
import android.media.AudioManager
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.view.Gravity
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private lateinit var spinnerStation: Spinner
    private lateinit var txtPlatform: TextView
    private lateinit var txtTrainName: TextView
    private lateinit var txtTime: TextView
    private lateinit var btnSpeaker: ImageButton
    private lateinit var btnHelpSpeaker: ImageButton

    // Coach Layout
    private lateinit var coachLayout: LinearLayout

    private lateinit var textToSpeech: TextToSpeech

    private lateinit var audioManager: AudioManager

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Views

        spinnerStation = findViewById(R.id.spinnerStation)
        txtPlatform = findViewById(R.id.txtPlatform)
        txtTrainName = findViewById(R.id.txtTrainName)
        txtTime = findViewById(R.id.txtTime)
        btnSpeaker = findViewById(R.id.btnSpeaker)
        btnHelpSpeaker = findViewById(R.id.btnHelpSpeaker)

        // Coach Layout View

        coachLayout = findViewById(R.id.coachLayout)

        // Audio Manager

        audioManager =
            getSystemService(Context.AUDIO_SERVICE) as AudioManager

        // Set Max Volume

        val maxVolume =
            audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC)

        audioManager.setStreamVolume(
            AudioManager.STREAM_MUSIC,
            maxVolume,
            0
        )

        // Station List

        val stations = arrayOf(
            "Bangalore",
            "Mysore",
            "Tumkur",
            "Hubli",
            "Belagavi"
        )

        // Spinner Adapter

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            stations
        )

        spinnerStation.adapter = adapter

        // Text To Speech

        textToSpeech = TextToSpeech(this) {

            if (it == TextToSpeech.SUCCESS) {

                textToSpeech.language = Locale("kn", "IN")

                textToSpeech.setSpeechRate(0.9f)
                textToSpeech.setPitch(1.0f)
            }
        }

        // Load Coach Layout

        loadCoachLayout()

        // Spinner Selection

        spinnerStation.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {

                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: android.view.View?,
                    position: Int,
                    id: Long
                ) {

                    when (stations[position]) {

                        "Bangalore" -> {

                            txtPlatform.text = "Platform 2"
                            txtTrainName.text = "Rajya Rani Express"
                            txtTime.text = "14:30"
                        }

                        "Mysore" -> {

                            txtPlatform.text = "Platform 1"
                            txtTrainName.text = "Mysore Express"
                            txtTime.text = "12:10"
                        }

                        "Tumkur" -> {

                            txtPlatform.text = "Platform 3"
                            txtTrainName.text = "Tumkur Passenger"
                            txtTime.text = "16:45"
                        }

                        "Hubli" -> {

                            txtPlatform.text = "Platform 4"
                            txtTrainName.text = "Hubli Superfast"
                            txtTime.text = "18:20"
                        }

                        "Belagavi" -> {

                            txtPlatform.text = "Platform 5"
                            txtTrainName.text = "Belagavi Express"
                            txtTime.text = "21:00"
                        }
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {

                }
            }

        // Speaker Button

        btnSpeaker.setOnClickListener {

            speakAnnouncement()
        }

        // Help Speaker Button

        btnHelpSpeaker.setOnClickListener {

            speakAnnouncement()
        }
    }

    // Announcement Function

    private fun speakAnnouncement() {

        val announcement =

            "ಗಮನಿಸಿ. " +
                    txtTrainName.text.toString() +
                    " ರೈಲು " +
                    txtPlatform.text.toString() +
                    " ಗೆ ಬರುತ್ತಿದೆ. " +
                    "ಜನರಲ್ ಕೋಚ್ ಮುಂದೆ ಇದೆ. " +
                    "ಮಹಿಳೆಯರ ಕೋಚ್ ಮಧ್ಯಭಾಗದಲ್ಲಿ ಇದೆ."

        textToSpeech.speak(
            announcement,
            TextToSpeech.QUEUE_FLUSH,
            null,
            null
        )
    }

    // Coach Layout Function

    private fun loadCoachLayout() {

        coachLayout.removeAllViews()

        val coachNames = arrayOf(
            "GEN",
            "LADIES",
            "RES",
            "SL",
            "GEN"
        )

        for (coach in coachNames) {

            val coachView = TextView(this)

            val params = LinearLayout.LayoutParams(
                220,
                220
            )

            params.setMargins(20, 0, 20, 0)

            coachView.layoutParams = params

            coachView.text = coach

            coachView.textSize = 18f

            coachView.setTextColor(Color.WHITE)

            coachView.gravity = Gravity.CENTER

            coachView.setPadding(20, 20, 20, 20)

            when (coach) {

                "GEN" -> {
                    coachView.setBackgroundColor(
                        Color.parseColor("#4CAF50")
                    )
                }

                "LADIES" -> {
                    coachView.setBackgroundColor(
                        Color.MAGENTA
                    )
                }

                "RES" -> {
                    coachView.setBackgroundColor(
                        Color.parseColor("#2196F3")
                    )
                }

                "SL" -> {
                    coachView.setBackgroundColor(
                        Color.parseColor("#FF9800")
                    )
                }
            }

            coachLayout.addView(coachView)
        }
    }

    override fun onDestroy() {

        super.onDestroy()

        textToSpeech.stop()
        textToSpeech.shutdown()
    }
}