package io.acari.DDLC.actions

import com.intellij.ide.util.PropertiesComponent

/**
 * Forged in the flames of battle by alex.
 */

class DarkMode {

    companion object {

        private var isOn = false
        private const val SAVED_STATE = "DARK_MODE_ON"

        init {
            isOn = PropertiesComponent.getInstance().getValue(SAVED_STATE)?.toBoolean() ?: false
        }

        @JvmStatic
        fun isOn(): Boolean = isOn

        fun toggle() {
            isOn = isOn.not()
            setState()
        }

        private fun setState() {
            PropertiesComponent.getInstance()
                    .setValue(SAVED_STATE, isOn)
        }

        @JvmStatic
        fun turnOn() {
            isOn = true
            setState()
        }

        @JvmStatic
        fun turnOff() {
            isOn = false
            setState()
        }
    }
}