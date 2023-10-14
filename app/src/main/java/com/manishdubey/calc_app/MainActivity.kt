package com.manishdubey.calc_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.EditText
import android.widget.Toast
import javax.script.ScriptEngine
import javax.script.ScriptEngineManager
import javax.script.ScriptException

class MainActivity : AppCompatActivity() {
    lateinit var input: EditText
    lateinit var output: EditText
    lateinit var cancel: android.widget.Button
    lateinit var modulus: android.widget.Button
    lateinit var back: android.widget.Button
    lateinit var divide: android.widget.Button
    lateinit var mult: android.widget.Button
    lateinit var sub: android.widget.Button
    lateinit var add: android.widget.Button
    lateinit var equal: android.widget.Button
    lateinit var seven: android.widget.Button
    lateinit var eight: android.widget.Button
    lateinit var nine: android.widget.Button
    lateinit var four: android.widget.Button
    lateinit var five: android.widget.Button
    lateinit var six: android.widget.Button
    lateinit var one: android.widget.Button
    lateinit var two: android.widget.Button
    lateinit var three: android.widget.Button
    lateinit var double_zero: android.widget.Button
    lateinit var zero: android.widget.Button
    lateinit var dot: android.widget.Button
    var check=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide() /// to hied the action back
        equal=findViewById(R.id.equalToBtn)
        dot=findViewById(R.id.decimalBtn)
        zero = findViewById(R.id.zeroBtn)
        one = findViewById(R.id.oneBtn)
        two = findViewById(R.id.twoBtn)
        three = findViewById(R.id.threeBtn)
        four = findViewById(R.id.fourBtn)
        five = findViewById(R.id.fiveBtn)
        six = findViewById(R.id.sixBtn)
        seven = findViewById(R.id.sevenBtn)
        eight = findViewById(R.id.eightBtn)
        nine = findViewById(R.id.nineBtn)
        double_zero = findViewById(R.id.double_zeroBtn)
        add = findViewById(R.id.plusBtn)
        sub = findViewById(R.id.minusBtn)
        mult = findViewById(R.id.multiplyBtn)
        divide = findViewById(R.id.divideBtn)
        modulus = findViewById(R.id.modulusBtn)
        cancel = findViewById(R.id.cancelBtn)
        back = findViewById(R.id.backBtn)
        input = findViewById(R.id.inputView)
        output = findViewById(R.id.outputView)
        input.movementMethod = ScrollingMovementMethod()
        input.isPressed = true
        input.isActivated = true
        var text: String
        one.setOnClickListener {
            text = input.text.toString() + "1"
            input.setText(text)
            result(text)
        }
        two.setOnClickListener {
            text = input.text.toString() + "2"
            input.setText(text)
            result(text)
        }
        three.setOnClickListener {
            text = input.text.toString() + "3"
            input.setText(text)
            result(text)
        }
        four.setOnClickListener {
            text = input.text.toString() + "4"
            input.setText(text)
            result(text)
        }
        five.setOnClickListener {
            text = input.text.toString() + "5"
            input.setText(text)
            result(text)
        }
        six.setOnClickListener {
            text = input.text.toString() + '6'
            input.setText(text)
            result(text)
        }
        seven.setOnClickListener {
            text = input.text.toString() + '7'
            input.setText(text)
            result(text)
        }
        eight.setOnClickListener {
            text = input.text.toString() + '8'
            input.setText(text)
            result(text)
        }
        nine.setOnClickListener {
            text = input.text.toString() + '9'
            input.setText(text)
            result(text)
        }
        zero.setOnClickListener {
            text = input.text.toString() + '0'
            input.setText(text)
            result(text)
        }
        double_zero.setOnClickListener {
            text = input.text.toString() + "00"
            input.setText(text)
            result(text)
        }
        dot.setOnClickListener {
            text=input.text.toString()+"."
            input.setText(text)
            result(text)
        }
        add.setOnClickListener {
            text = input.text.toString() + "+"
            input.setText(text)
            check += 1
        }
        sub.setOnClickListener {
            text = input.text.toString() + "-"
            input.setText(text)
            check += 1
        }
        divide.setOnClickListener {
            text = input.text.toString() + "/"
            input.setText(text)
            check += 1
        }
        modulus.setOnClickListener {
            text = input.text.toString() + "%"
            input.setText(text)
            check += 1
        }
        mult.setOnClickListener {
            text = input.text.toString() + "*"
            input.setText(text)
            check += 1
        }
        equal.setOnClickListener {
            text = output.text.toString()
            input.setText(text)
            output.text = null
        }
        cancel.setOnClickListener {
            input.text = null
            output.text = null
        }
        back.setOnClickListener {
            var backspace: String? = ""
            if (input.text.isNotEmpty()) {
                val stringBuilder: StringBuilder = StringBuilder(input.text)
                val find = input.text.toString()
                val find2 = find.last()

                if (find2.equals("+") || find2.equals("-") || find2.equals("*") || find2.equals("%") || find2.equals("/")) {
                    check -= 1
                }
                stringBuilder.deleteCharAt(input.text.length - 1)
                backspace = stringBuilder.toString()
                input.setText(backspace)
                result(backspace)
            }
        }
         }

        private fun result(text: String) {
//            if (!::input.isInitialized) {
//                // Handle the case where input has not been initialized
//                return
//            }
            val engine: ScriptEngine = ScriptEngineManager().getEngineByName("rhino")
            try {
                val result: Any = engine.eval(text)
                val mr = result.toString()
                if (check == 0) {
                    output.text = null
                } else {
                    output.setText(mr)
                }
            } catch (e: ScriptException) {
               // Toast.makeText(this, "Incorrect Format", Toast.LENGTH_SHORT).show()
                output.setText("Error")
            }
        }
}