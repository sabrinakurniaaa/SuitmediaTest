package local.id.suitmediatest

//import .ThirdScreen
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondScreen : AppCompatActivity() {

    private lateinit var welcomeText: TextView
    private lateinit var showNameText: TextView
    private lateinit var selectedUserNameText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_screen)

        selectedUserNameText = findViewById(R.id.selectedUserName)
        val chooseUserButton: ImageButton = findViewById(R.id.choose_user_button)

        val showName = intent.getStringExtra("SHOW_NAME")
        val selectedUserName = intent.getStringExtra("SELECTED_USER_NAME")

        selectedUserNameText.text = selectedUserName

        chooseUserButton.setOnClickListener {
            goToThirdScreen()
        }
    }
    private fun goToThirdScreen() {
        val intent = Intent(this, ThirdScreen::class.java)
        startActivity(intent)
    }
}