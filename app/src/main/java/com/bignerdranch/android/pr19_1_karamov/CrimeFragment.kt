package com.bignerdranch.android.pr19_1_karamov

import android.content.SharedPreferences.Editor
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText

class CrimeFragment : Fragment() {

    private lateinit var crime: Crime
    private lateinit var titleField :EditText
    private lateinit var dateButton : Button
    private lateinit var solvedCheckBox : CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        crime = Crime(title = "asdf", solved = false)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_crime, container, false)
        titleField = view.findViewById(R.id.titleEdit) as EditText
        dateButton = view.findViewById(R.id.buttonDate) as Button
        solvedCheckBox = view.findViewById(R.id.crime_solved) as CheckBox
        solvedCheckBox.isEnabled = false
        dateButton.apply {
            text = crime.date.toString()
            isEnabled = false
        }
        return view
    }
    override fun onStart() {
        super.onStart()
        val titleWatcher = object : TextWatcher
        {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                crime.title = s.toString()
                if (s.toString() != "")
                {
                    solvedCheckBox.isEnabled = true
                }
                else
                {
                    solvedCheckBox.isEnabled = false
                    dateButton.isEnabled = false
                    solvedCheckBox.isChecked = false
                }
            }

            override fun afterTextChanged(s: Editable?) {

            }
        }
        titleField.addTextChangedListener(titleWatcher)
        fun Check()
        {
            crime.solved = solvedCheckBox.isChecked
            dateButton.isEnabled = solvedCheckBox.isChecked
        }
        solvedCheckBox.apply {
            setOnCheckedChangeListener { _, isChecked -> Check()  }
        }
    }
}