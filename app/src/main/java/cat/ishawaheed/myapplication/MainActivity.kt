package cat.ishawaheed.myapplication

import android.os.Bundle
import android.widget.Button
import android.content.Intent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.TextView
import android.widget.SeekBar
class MainActivity : AppCompatActivity() {
    var weight = 170
    var age = 18
    var height = 73
    var selectedGender = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val txtWeight = findViewById<TextView>(R.id.txtWeight)

        val btnWeightPlus = findViewById<Button>(R.id.btnWeightPlus)
        val btnWeightMinus = findViewById<Button>(R.id.btnWeightMinus)
        val txtAge = findViewById<TextView>(R.id.txtAge)

        val btnAgePlus = findViewById<Button>(R.id.btnAgePlus)
        val btnAgeMinus = findViewById<Button>(R.id.btnAgeMinus)
        val txtHeight = findViewById<TextView>(R.id.txtHeight)
        val seekHeight = findViewById<SeekBar>(R.id.seekHeight)
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)
        val maleCard = findViewById<androidx.cardview.widget.CardView>(R.id.maleCard)
        val femaleCard = findViewById<androidx.cardview.widget.CardView>(R.id.femaleCard)


        btnCalculate.setOnClickListener {

            val bmi = weight * 703.0 / (height * height)

            val intent = Intent(this, ResultActivity::class.java)

            intent.putExtra("BMI_VALUE", bmi)

            startActivity(intent)
        }
        btnWeightPlus.setOnClickListener {

            weight++

            txtWeight.text = weight.toString()
        }
        btnWeightMinus.setOnClickListener {

            weight--

            txtWeight.text = weight.toString()
        }
        btnAgePlus.setOnClickListener {
            age++
            txtAge.text = age.toString()
        }

        btnAgeMinus.setOnClickListener {
            age--
            txtAge.text = age.toString()
        }
        maleCard.setOnClickListener {

            selectedGender = "male"

            maleCard.setCardBackgroundColor(
                resources.getColor(android.R.color.darker_gray, theme)
            )

            femaleCard.setCardBackgroundColor(
                resources.getColor(android.R.color.transparent, theme)
            )
        }
        femaleCard.setOnClickListener {

            selectedGender = "female"

            femaleCard.setCardBackgroundColor(
                resources.getColor(android.R.color.darker_gray, theme)
            )

            maleCard.setCardBackgroundColor(
                resources.getColor(android.R.color.transparent, theme)
            )
        }
        seekHeight.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(
                seekBar: SeekBar?,
                progress: Int,
                fromUser: Boolean
            ) {
                height = progress
                txtHeight.text = height.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}