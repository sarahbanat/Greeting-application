package com.example.assignment1

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private lateinit var languageSpinner: Spinner
    private lateinit var greetButton: Button
    private lateinit var farewellButton: Button
    private lateinit var greetingText: TextView

    private val languages = arrayOf(
        "English",
        "Spanish",
        "French",
        "German",
        "Russian",
        "Italian",
        "Japanese",
        "Arabic",
        "Turkish"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        languageSpinner = findViewById(R.id.language_spinner)
        greetButton = findViewById(R.id.greet_button)
        farewellButton = findViewById(R.id.farewell_button)
        greetingText = findViewById(R.id.greeting_text)

        // Create an ArrayAdapter using the languages array and a default spinner layout
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, languages)
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Apply the adapter to the spinner
        languageSpinner.adapter = adapter

        // Set the listener for the spinner
        languageSpinner.onItemSelectedListener = this

        // Set the listener for the greet button
        greetButton.setOnClickListener {
            // Get the selected language from the spinner
            val selectedLanguage = languageSpinner.selectedItem as String
            // Show a greeting message in the selected language
            val greetingMessage = "${greetingText.text}, user!"
            when (selectedLanguage) {
                "English" -> greetingText.text = greetingMessage
                "Spanish" -> greetingText.text = "$greetingMessage en español"
                "French" -> greetingText.text = "$greetingMessage en français"
                "German" -> greetingText.text = "$greetingMessage auf Deutsch"
                "Russian" -> greetingText.text = "$greetingMessage na russkom"
                "Italian" -> greetingText.text = "$greetingMessage in italiano"
                "Japanese" -> greetingText.text = "$greetingMessage Nihongode"
                "Arabic" -> greetingText.text = "$greetingMessage بالعربية "
                "Turkish" -> greetingText.text = "$greetingMessage Türkçe olarak"
            }
            // Show a toast message with the selected language
            val toast =
                Toast.makeText(this, "Selected language: $selectedLanguage", Toast.LENGTH_SHORT)
            toast.show()
        }


        // Set the listener for the farewell button
        farewellButton.setOnClickListener {
            // Get the selected language from the spinner
            val selectedLanguage = languageSpinner.selectedItem as String
            // Show a farewell message in the selected language
            val farewellMessage = ", user!"
            when (selectedLanguage) {
                "English" -> greetingText.text = "Goodbye, $farewellMessage"
                "Spanish" -> greetingText.text = " Adiós $farewellMessage "
                "French" -> greetingText.text = " Au revoir $farewellMessage"
                "German" -> greetingText.text = " Auf Wiedersehen $farewellMessage"
                "Russian" -> greetingText.text = " Do svidaniya $farewellMessage"
                "Italian" -> greetingText.text = " Arrivederci $farewellMessage"
                "Japanese" -> greetingText.text = " Sayonara $farewellMessage"
                "Arabic" -> greetingText.text = " Ma'a al-salama $farewellMessage"
                "Turkish" -> greetingText.text = " Güle güle $farewellMessage"
            }
        }
    }
    override fun onItemSelected(
            parent: AdapterView<*>?,
            view: View?,
            position: Int,
            id: Long
        ) {
            val selectedLanguage = parent?.getItemAtPosition(position) as String
            // Update the greeting text with the selected language
            greetingText.text = when (selectedLanguage) {
                "English" -> "Hello"
                "Spanish" -> "Hola"
                "French" -> "Bonjour"
                "German" -> "Guten Tag"
                "Russian" -> "Zdravstvuyte"
                "Italian" -> "Salve"
                "Japanese" -> "Konnichiwa"
                "Arabic" -> " Asalaam alaikum "
                "Turkish" -> "Merhaba"
                else -> ""
            }
        }

    override fun onNothingSelected(parent: AdapterView<*>?) {
            // Do nothing
        }
    }


