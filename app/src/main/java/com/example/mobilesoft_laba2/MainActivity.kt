package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextN = findViewById<EditText>(R.id.editTextN)
        val editTextA = findViewById<EditText>(R.id.editTextA)
        val buttonCalculate = findViewById<Button>(R.id.buttonCalculate)
        val textViewResult = findViewById<TextView>(R.id.textViewResult)

        buttonCalculate.setOnClickListener {
            // Получаем значения n и a из EditText
            val nStr = editTextN.text.toString()
            val aStr = editTextA.text.toString()

            // Проверяем, что введены корректные значения
            if (nStr.isEmpty() || aStr.isEmpty()) {
                Toast.makeText(this, "Пожалуйста, введите n и a", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val n = nStr.toIntOrNull()
            val a = aStr.toDoubleOrNull()

            if (n == null || n <= 0 || a == null) {
                Toast.makeText(this, "Введите корректные значения", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Вычисляем сумму
            val result = calculateSum(n, a)

            // Отображаем результат на экране
            textViewResult.text = "Результат: $result"
        }
    }

    private fun calculateSum(n: Int, a: Double): Double {
        var sum = 0.0
        var denominator = 1.0

        for (i in 0 until n + 1) {
            // Умножаем текущий знаменатель на (a + i)
            denominator *= (a + i)

            // Добавляем текущий член суммы
            sum += 1 / denominator
        }

        return sum
    }
}