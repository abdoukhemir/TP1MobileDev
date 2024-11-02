package eniso.ia2.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ComputeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_compute)

        val radioSum: RadioButton = findViewById(R.id.radioButton)
        val radioSquare: RadioButton = findViewById(R.id.radioButton2)
        val value1TextView: TextView = findViewById(R.id.Value1)
        val value2TextView: TextView = findViewById(R.id.Value2)
        val inputValue1: EditText = findViewById(R.id.inputvalue1)
        val inputValue2: EditText = findViewById(R.id.inputvalue2)
        val calculateBtn: Button = findViewById(R.id.CalculateBtn)
        val resultOutput: TextView = findViewById(R.id.ResultOutput)
        val valueTextView: TextView = findViewById(R.id.Value)
        val inputValue: EditText = findViewById(R.id.InputValue)


        hideSquareFields(value1TextView, inputValue1, value2TextView, inputValue2, valueTextView, inputValue)

        radioSum.setOnClickListener {
            showSumFields(value1TextView, inputValue1, value2TextView, inputValue2, valueTextView, inputValue)
        }
        radioSquare.setOnClickListener {
            showSquareFields(value1TextView, inputValue1, value2TextView, inputValue2, valueTextView, inputValue)
        }

        calculateBtn.setOnClickListener {
            if (radioSum.isChecked) {
                calculateSum(inputValue1, inputValue2, resultOutput)
            } else if (radioSquare.isChecked) {
                calculateSquare(inputValue, resultOutput)
            }
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }
    private fun showSumFields(
        value1TextView: TextView, inputValue1: EditText,
        value2TextView: TextView, inputValue2: EditText,
        valueTextView: TextView, inputValue: EditText
    ) {
        value1TextView.visibility = View.VISIBLE
        inputValue1.visibility = View.VISIBLE
        value2TextView.visibility = View.VISIBLE
        inputValue2.visibility = View.VISIBLE
        valueTextView.visibility = View.GONE
        inputValue.visibility = View.GONE
    }

    private fun showSquareFields(
        value1TextView: TextView, inputValue1: EditText,
        value2TextView: TextView, inputValue2: EditText,
        valueTextView: TextView, inputValue: EditText
    ) {
        value1TextView.visibility = View.GONE
        inputValue1.visibility = View.GONE
        value2TextView.visibility = View.GONE
        inputValue2.visibility = View.GONE
        valueTextView.visibility = View.VISIBLE
        inputValue.visibility = View.VISIBLE
    }

    private fun hideSquareFields(
        value1TextView: TextView, inputValue1: EditText,
        value2TextView: TextView, inputValue2: EditText,
        valueTextView: TextView, inputValue: EditText
    ) {
        valueTextView.visibility = View.GONE
        inputValue.visibility = View.GONE
    }

    private fun calculateSum(inputValue1: EditText, inputValue2: EditText, resultOutput: TextView) {
        val value1 = inputValue1.text.toString().toDoubleOrNull()
        val value2 = inputValue2.text.toString().toDoubleOrNull()

        if (value1 != null && value2 != null) {
            val sum = value1 + value2
            resultOutput.text = "Result: $sum"
        } else {
            Toast.makeText(this, "Please enter valid numbers", Toast.LENGTH_SHORT).show()
        }
    }

    private fun calculateSquare(inputValue: EditText, resultOutput: TextView) {
        val value = inputValue.text.toString().toDoubleOrNull()

        if (value != null) {
            val square = value * value
            resultOutput.text = "Result: $square"
        } else {
            Toast.makeText(this, "Please enter a valid number", Toast.LENGTH_SHORT).show()
        }
    }



}