package com.example.animationfragment

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.TransitionDrawable
import android.os.Bundle
import android.transition.ChangeBounds
import android.transition.Scene
import android.transition.TransitionManager
import android.transition.TransitionSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment


class AnimationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_animation, container, false).also {
        it.findViewById<View>(R.id.launchButton).setOnClickListener {
            expand()
        }
    }

    private fun expand() {
        val scene = Scene.getSceneForLayout(
            requireView() as ViewGroup,
            R.layout.fragment_animation_changed,
            requireContext()
        )
        TransitionManager.go(scene, TransitionSet().apply {
            addTransition(ChangeBounds())
            duration = 400
        })
        val colorDrawables = arrayOf(
            ColorDrawable(Color.parseColor("#6200EE")),
            ColorDrawable(Color.parseColor("#FFFF2903"))
        )
        val transitionDrawable = TransitionDrawable(colorDrawables)
        requireView().findViewById<View>(R.id.square).background = transitionDrawable
        transitionDrawable.startTransition(400)
    }

}