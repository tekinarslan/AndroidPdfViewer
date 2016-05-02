package com.artifex.mupdfdemo;

public class MuPDFAlert {
    public enum IconType {ERROR, WARNING, QUESTION, STATUS}

    ;

    public enum ButtonPressed {NONE, OK, CANCEL, NO, YES}

    ;

    public enum ButtonGroupType {OK, OK_CANCEL, YES_NO, YES_NO_CANCEL}

    ;

    public final String message;
    public final IconType iconType;
    public final ButtonGroupType buttonGroupType;
    public final String title;
    public ButtonPressed buttonPressed;

    MuPDFAlert(String aMessage, IconType aIconType, ButtonGroupType aButtonGroupType, String aTitle, ButtonPressed aButtonPressed) {
        message = aMessage;
        iconType = aIconType;
        buttonGroupType = aButtonGroupType;
        title = aTitle;
        buttonPressed = aButtonPressed;
    }
}
