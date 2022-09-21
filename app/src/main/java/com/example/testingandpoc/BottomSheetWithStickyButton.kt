package com.example.testingandpoc

import android.app.Dialog
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Button
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.get
import androidx.core.view.marginTop
import com.example.testingandpoc.databinding.BottomSheetLayoutBinding
import com.example.testingandpoc.databinding.LayoutDeliveryBottomSheetButtonsBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

/**
 * Created by Tehleel Mir
 * Date: 20.09.2022
 * Time: 09:26
 *
 * Description:
 */

class BottomSheetWithStickyButton: BottomSheetDialogFragment() {

    lateinit var binding: BottomSheetLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = BottomSheetLayoutBinding.inflate(inflater)
        return binding.root
    }


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val bottomSheetDialog = super.onCreateDialog(savedInstanceState) as BottomSheetDialog
        bottomSheetDialog.setOnShowListener {
            val containerLayout = dialog?.findViewById(
                com.google.android.material.R.id.container
            ) as? FrameLayout

            val buttonBinding = LayoutDeliveryBottomSheetButtonsBinding.inflate(
                LayoutInflater.from(requireContext())
            )

            val layoutParams = FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.WRAP_CONTENT,
                Gravity.BOTTOM
            )


            containerLayout?.addView(
                buttonBinding.root,
                layoutParams
            )

            buttonBinding.root.viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
                override fun onGlobalLayout() {
                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
                        buttonBinding.root.viewTreeObserver.removeOnGlobalLayoutListener(this)
                    else
                        buttonBinding.root.viewTreeObserver.removeGlobalOnLayoutListener(this)

                    val height = buttonBinding.root.measuredHeight
                    binding.root.setPadding(0, 0, 0, height ?: 0)
                }

            })

            buttonBinding.root.setOnClickListener {
                Log.i("here22", "blah blah!!!!")
            }
        }

        return bottomSheetDialog
    }
}