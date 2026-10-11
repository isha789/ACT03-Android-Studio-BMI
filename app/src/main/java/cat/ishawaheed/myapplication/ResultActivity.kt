//package cat.ishawaheed.myapplication

//import android.os.Bundle
//import androidx.activity.enableEdgeToEdge
//import androidx.appcompat.app.AppCompatActivity
//import androidx.core.view.ViewCompat
//import androidx.core.view.WindowInsetsCompat

//class ResultActivity : AppCompatActivity() {
//  override fun onCreate(savedInstanceState: Bundle?) {
//      super.onCreate(savedInstanceState)
//       enableEdgeToEdge()
//      setContentView(R.layout.activity_result)
//      ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//          val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//          v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//          insets
//      }
//  }
//}

package cat.ishawaheed.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_result)
        val txtBmi = findViewById<TextView>(R.id.txtBmi)

        val bmi = intent.getDoubleExtra("BMI_VALUE", 0.0)

        txtBmi.text = String.format("%.2f", bmi)
        val txtStatus = findViewById<TextView>(R.id.txtStatus)
        val txtDescription = findViewById<TextView>(R.id.txtDescription)

        val btnRecalculate = findViewById<Button>(R.id.btnRecalculate)
        if (bmi < 18.5) {
            txtStatus.text = "UNDERWEIGHT"
            txtDescription.text = "Underweight"

        } else if (bmi < 25) {
            txtStatus.text = "NORMAL"
            txtDescription.text = "Normal"

        } else if (bmi < 30) {
            txtStatus.text = "OVERWEIGHT"
            txtDescription.text = "Overweight"

        } else {
            txtStatus.text = "OBESE"
            txtDescription.text = "Obese"
        }

        btnRecalculate.setOnClickListener {
            finish()
        }
    }
}