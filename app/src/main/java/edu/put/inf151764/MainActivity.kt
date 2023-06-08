package edu.put.inf151764

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import org.w3c.dom.Text
import java.io.File

private lateinit var userName: String
private lateinit var viewModel: MainViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        logIn()

        val buttonGames = findViewById<ImageButton>(R.id.gamesButton)
        val buttonAddons = findViewById<ImageButton>(R.id.addonsButton)

        buttonGames.setOnClickListener {
            startActivity(Intent(this, GamesActivity::class.java))
        }

        buttonAddons.setOnClickListener {
            startActivity(Intent(this, GamesActivity::class.java))
        }

    }

    fun logIn() {
        val popupView: View = layoutInflater.inflate(R.layout.log, null)
        val userNameField: EditText = popupView.findViewById(R.id.editUsername)
        val accept: Button = popupView.findViewById(R.id.okButton)
        val dialogBuilder = AlertDialog.Builder(this).setView(popupView)
        val dialog: AlertDialog = dialogBuilder.create()
        dialog.show()
        accept.setOnClickListener() {
            if (userNameField.text.toString() == "") {
                Toast.makeText(this, "Empty username", Toast.LENGTH_SHORT).show() // nie działa
            } else{
                userName = userNameField.text.toString()
                val text = findViewById<TextView>(R.id.nameText)
                text.setText("Nazwa gracza: $userName")
                dialog.dismiss()
                Toast.makeText(this, "Syncing...", Toast.LENGTH_LONG).show()
            }
        }
    }
}

