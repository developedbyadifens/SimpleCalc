package id.haonlabs.simplecalc

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
  private lateinit var etValA: EditText
  private lateinit var etValB: EditText
  private lateinit var btnCalculate: Button
  private lateinit var tvResTitle: TextView
  private lateinit var tvResVal: TextView

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContentView(R.layout.activity_main)
    ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
      val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
      v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
      insets
    }

    etValA = findViewById(R.id.etValA)
    etValB = findViewById(R.id.etValB)
    btnCalculate = findViewById(R.id.btnCalculate)
    tvResTitle = findViewById(R.id.tvResTitle)
    tvResVal = findViewById(R.id.tvResVal)

    btnCalculate.setOnClickListener {
      val valA = etValA.text.toString().toInt()
      val valB = etValB.text.toString().toInt()
      val result = valA + valB
      tvResTitle.visibility = TextView.VISIBLE
      tvResVal.visibility = TextView.VISIBLE
      tvResVal.text = "$result"
    }
  }
}
