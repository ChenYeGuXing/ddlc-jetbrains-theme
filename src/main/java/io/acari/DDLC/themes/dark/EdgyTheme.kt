package io.acari.DDLC.themes.dark

import com.chrisrm.ideaddlc.utils.MTAccents
import io.acari.DDLC.themes.DokiDokiTheme
import javax.swing.plaf.ColorUIResource

//todo: should probably rename these to something more expected :|
class EdgyTheme : DokiDokiTheme("yuri.dark", "Edgy", true, "Yuri") {

    override fun getBackgroundColorString(): String = "322A45"

    override fun getClubMember(): String = "yuri_dark.png"

    override fun joyfulClubMember(): String = "yuri_dark_joy.png"

    override fun getSecondaryBackgroundColorString(): String = "412D62"

    override fun getSecondaryForegroundColorString(): String = "9965BC"

    override fun getSelectionForegroundColorString(): String = "B39EFF"

    override fun getSelectionBackgroundColorString(): String = "442463"

    override fun getTreeSelectionBackgroundColorString(): String = "65318F"

    override fun getInactiveColorString(): String = "3C1D55"

    override fun getMenuBarSelectionForegroundColorString(): String = "ffffff"

    override fun getMenuBarSelectionBackgroundColorString(): String = "56009D"

    override fun getNotificationsColorString(): String = "36274E"

    override fun getContrastColorString(): String = "473960"

    override fun getEditorTabColorString(): String = contrastColorString

    override fun getButtonBackgroundColor(): String = contrastColorString

    override fun getButtonForegroundColor(): String = "7469C7"

    override fun getSelectedButtonForegroundColor(): String = "ffffff"

    override fun getForegroundColorString(): String = "917DEA"

    override fun getDisabled(): String = "17C704"

    override fun getTextColorString(): String = "916ACE"

    override fun getNonProjectFileScopeColor(): String = "272132"

    override fun getTestScope(): String = "0c3118"

    override fun getSecondBorderColorString(): String = "50237C"

    override fun getDisabledColorString(): String = "000000"

    override fun getAccentColor(): String {
        return MTAccents.AMETHYST.hexColor
    }
    override fun getBackgroundColorResource(): ColorUIResource = ColorUIResource(0x3c3152)

    override fun getForegroundColorResource(): ColorUIResource = ColorUIResource(0x917DEA)

    override fun getTableSelectedColorString(): String = "2B204C"

    override fun getHighlightColorString(): String = "5D317D"

    override fun getStartColor(): String = "870AD2"

    override fun getStopColor(): String = "F667FF"
}