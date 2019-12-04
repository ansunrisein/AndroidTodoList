package com.example.androidtodolist.fragments

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageButton
import com.example.androidtodolist.R
import com.example.androidtodolist.repositories.Repository
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.textfield.TextInputEditText

class EditBottomDrawerFragment(private val position: Int) : BottomSheetDialogFragment() {
    public var onDismissListener: (() -> Unit)? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val result = inflater.inflate(R.layout.fragment_bottom, container, false)

        val buttonOK: AppCompatImageButton = result.findViewById(R.id.button_ok)
        val editText: TextInputEditText = result.findViewById(R.id.text_edit)

        buttonOK.setOnClickListener {
            Repository.items[position] = editText.text.toString()
            dismiss()
        }

        editText.setText(Repository.items[position])

        return result
    }

    override fun onDismiss(dialog: DialogInterface?) {
        super.onDismiss(dialog)
        onDismissListener?.invoke()
    }
}