package com.example.nikita.task_4_ny

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.nikita.task_4_ny.enities.ClassInfo
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var myAdapter : Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myAdapter = Adapter(createCollection())

        recycler_view.layoutManager = GridLayoutManager(applicationContext, 2)
        recycler_view.adapter = myAdapter

        val spinner = findViewById<Spinner>(R.id.filter_view)
        val spinnerList = resources.getStringArray(R.array.spin_list)

        spinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerList)

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                myAdapter.filter(if (position != 0) spinnerList[position] else null)
            }
        }
    }


    private fun createCollection(): List<ClassInfo> {
        return listOf(
            ClassInfo(
                resources.getString(R.string.java_title),
                resources.getString(R.string.java_author),
                1995,
                resources.getStringArray(R.array.java_paradigm),
                getBitmapById(R.drawable.java),
                "16.904",
                "https://ru.wikipedia.org/wiki/Java"
            ),
            ClassInfo(
                resources.getString(R.string.c_title),
                resources.getString(R.string.c_author),
                1972,
                resources.getStringArray(R.array.c_paradigm),
                getBitmapById(R.drawable.c),
                "13.337",
                "https://ru.wikipedia.org/wiki/%D0%A1%D0%B8_(%D1%8F%D0%B7%D1%8B%D0%BA_%D0%BF%D1%80%D0%BE%D0%B3%D1%80%D0%B0%D0%BC%D0%BC%D0%B8%D1%80%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D1%8F)"
            ),
            ClassInfo(
                resources.getString(R.string.py_title),
                resources.getString(R.string.py_author),
                1991,
                resources.getStringArray(R.array.py_paradigm),
                getBitmapById(R.drawable.python),
                "8.294",
                "https://ru.wikipedia.org/wiki/Python"
            ),
            ClassInfo(
                resources.getString(R.string.cpp_title),
                resources.getString(R.string.cpp_author),
                1983,
                resources.getStringArray(R.array.cpp_paradigm),
                getBitmapById(R.drawable.cpp),
                "8.158",
                "https://ru.wikipedia.org/wiki/C%2B%2B"
            ),
            ClassInfo(
                resources.getString(R.string.vbn_title),
                resources.getString(R.string.vbn_author),
                2001,
                resources.getStringArray(R.array.vbn_paradigm),
                getBitmapById(R.drawable.basic),
                "6.459",
                "https://ru.wikipedia.org/wiki/Visual_Basic_.NET"
            ),
            ClassInfo(
                resources.getString(R.string.js_title),
                resources.getString(R.string.js_author),
                1995,
                resources.getStringArray(R.array.js_paradigm),
                getBitmapById(R.drawable.js),
                "3.302",
                "https://ru.wikipedia.org/wiki/JavaScript"
            ),
            ClassInfo(
                resources.getString(R.string.csh_title),
                resources.getString(R.string.csh_author),
                2000,
                resources.getStringArray(R.array.csh_paradigm),
                getBitmapById(R.drawable.csharp),
                "3.284",
                "https://ru.wikipedia.org/wiki/C_Sharp"
            ),
            ClassInfo(
                resources.getString(R.string.php_title),
                resources.getString(R.string.php_author),
                1995,
                resources.getStringArray(R.array.php_paradigm),
                getBitmapById(R.drawable.php),
                "2.680",
                "https://ru.wikipedia.org/wiki/PHP"
            ),
            ClassInfo(
                resources.getString(R.string.sql_title),
                resources.getString(R.string.sql_author),
                1974,
                resources.getStringArray(R.array.sql_paradigm),
                getBitmapById(R.drawable.sql),
                "2.277",
                "https://ru.wikipedia.org/wiki/SQL"
            ),
            ClassInfo(
                resources.getString(R.string.objc_title),
                resources.getString(R.string.objc_author),
                1983,
                resources.getStringArray(R.array.objc_paradigm),
                getBitmapById(R.drawable.objectivec),
                "1.781",
                "https://ru.wikipedia.org/wiki/Objective-C"
            )
        )
    }


    private fun getBitmapById(id: Int): Bitmap? {
        return (resources.getDrawable(id) as BitmapDrawable).bitmap
    }
}
