package eniso.ia2.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.text.SimpleDateFormat
import java.util.Calendar

class AuthenticationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_authentication,)


        val SignInBtn =findViewById<Button>(R.id.SignInBtn)
        val Time_Date = findViewById<TextView>(R.id.Time_Date)
        val Time_Date_btn = findViewById<Button>(R.id.Update)
        val EmailView = findViewById<EditText>(R.id.EmailView)
        val PasswordView = findViewById<EditText>(R.id.PasswordView)

        val currentTime = getCurrentDateTime()
        Time_Date.text = currentTime

        SignInBtn.setOnClickListener {
            val login = EmailView.text.toString()
            val password = PasswordView.text.toString()

            if (password == "pw$login") {
                Toast.makeText(this, R.string.login_success, Toast.LENGTH_SHORT).show()

                // Create the Intent to move to ComputeActivity
                val intent = Intent(this, ComputeActivity ::class.java)
                startActivity(intent)

            } else {
                Toast.makeText(this, R.string.login_failed, Toast.LENGTH_SHORT).show()
            }
        }
        /*SignInBtn.setOnClickListener{
            val currentTime = getCurrentDateTime()
            Time_Date.text = currentTime
        }*/
        Time_Date_btn.setOnClickListener {
            val currentTime = getCurrentDateTime()
            Time_Date.text = currentTime

        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
    }
    @SuppressLint("SimpleDateFormat")
    fun getCurrentDateTime(): String {
        val calendar = Calendar.getInstance()
        val simpleDateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
        return simpleDateFormat.format(calendar.time)

    }
}