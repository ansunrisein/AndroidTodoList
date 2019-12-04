package com.example.androidtodolist.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageButton
import com.example.androidtodolist.R
import com.example.androidtodolist.repositories.Repository
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.textfield.TextInputEditText

class CreateBottomDrawerFragment : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val result = inflater.inflate(R.layout.fragment_bottom, container, false)

        val buttonOK: AppCompatImageButton = result.findViewById(R.id.button_ok)
        val editText: TextInputEditText = result.findViewById(R.id.text_edit)

        buttonOK.setOnClickListener {
            Repository.items.add(editText.text.toString())
            dismiss()
        }
        return result
    }

}