package edu.put.inf151764.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import edu.put.inf151764.viewmodel.MainViewModel
import edu.put.inf151764.R
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.uiState.onEach {

        }.launchIn(lifecycleScope)

        viewModel.events.onEach {
            when (it) {
                MainViewModel.Event.ShowLoginPopup -> {

                }
            }
        }.launchIn(lifecycleScope)

        val buttonGames = findViewById<ImageButton>(R.id.gamesButton)
        val buttonAddons = findViewById<ImageButton>(R.id.addonsButton)

        buttonGames.setOnClickListener {
            viewModel.test()
//            startActivity(Intent(this, GamesActivity::class.java))
        }

        buttonAddons.setOnClickListener {
            startActivity(Intent(this, GamesActivity::class.java))
        }

    }

    fun showLoginPopup() {
        val popupView: View = layoutInflater.inflate(R.layout.log, null)
        val userNameField: EditText = popupView.findViewById(R.id.editUsername)
        val accept: Button = popupView.findViewById(R.id.okButton)
        val dialogBuilder = AlertDialog.Builder(this).setView(popupView)
        val dialog: AlertDialog = dialogBuilder.create()
        dialog.show()
        accept.setOnClickListener() {
            if (userNameField.text.toString() == "") {
                Toast.makeText(this, "Empty username", Toast.LENGTH_SHORT).show() // nie działa
            } else {
                //userName = userNameField.text.toString()
                val text = findViewById<TextView>(R.id.nameText)
                //text.setText("Nazwa gracza: $userName")
                dialog.dismiss()
                Toast.makeText(this, "Syncing...", Toast.LENGTH_LONG).show()
            }
        }
    }
}