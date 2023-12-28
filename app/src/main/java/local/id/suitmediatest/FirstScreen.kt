package local.id.suitmediatest

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class FirstScreen : AppCompatActivity() {

    private lateinit var nameInput: EditText
    private lateinit var palindromeInput: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_screen)

        nameInput = findViewById(R.id.nameInput)
        palindromeInput = findViewById(R.id.palindromeInput)
        val checkButton: ImageButton = findViewById(R.id.checkButton)
        val nextButton: ImageButton = findViewById(R.id.nextButton)

        checkButton.setOnClickListener {
            checkPalindrome()
        }

        nextButton.setOnClickListener {
            goToSecondScreen()
        }
    }

    private fun checkPalindrome() {
        val name = nameInput.text.toString().trim()
        val sentence = palindromeInput.text.toString().trim()

        val isPalindrome = isPalindrome(sentence)

        val message = if (isPalindrome) "isPalindrome" else "not palindrome"
        showAlert(message)
    }

    private fun showAlert(message: String) {
        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.setMessage(message)
        alertDialogBuilder.setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }

    private fun isPalindrome(str: String): Boolean {
        val cleanStr = str.replace("\\s".toRegex(), "").toLowerCase()
        return cleanStr == cleanStr.reversed()
    }

    private fun goToSecondScreen() {
        val intent = Intent(this, SecondScreen::class.java)
        startActivity(intent)
    }
}