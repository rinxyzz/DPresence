package com.rin.dpresence

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class Info : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) : View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.info, container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val githubButton : Button = view.findViewById(R.id.github)
        githubButton.setOnClickListener{ github() }
        val visit : Button = view.findViewById(R.id.visit)
        githubButton.setOnClickListener{ visit() }
        view.findViewById<Button>(R.id.viewLog).setOnClickListener { viewLog() }
    }

    private fun github() {
        startActivity(Intent("android.intent.action.VIEW", Uri.parse("https://github.com/rinxyzz/Presence-Android")))
    }

    private fun visit() {
        startActivity(Intent("android.intent.action.VIEW", Uri.parse("https://rin4ever.xyz")))
    }

    private fun viewLog() {
        parentFragmentManager.beginTransaction()
            .setReorderingAllowed(true)
            .setCustomAnimations(R.anim.fragment_enter, R.anim.fragment_exit, R.anim.fragment_enter, R.anim.fragment_exit)
            .addToBackStack(null)
            .replace(R.id.fragmentContainerView, LogViewer())
            .commit()
    }
}