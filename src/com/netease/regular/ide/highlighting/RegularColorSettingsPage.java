package com.netease.regular.ide.highlighting;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import com.netease.regular.icons.RegularIcons;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Map;

/**
 * Created by abnerzheng on 2017/2/9.
 */
public class RegularColorSettingsPage implements ColorSettingsPage {

    public static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
            new AttributesDescriptor("Brace", RegularSyntaxHighlighter.BRACES),
            new AttributesDescriptor("Rules", RegularSyntaxHighlighter.RULES)
    };

    @Nullable
    @Override
    public Icon getIcon() {
        return RegularIcons.FILE;
    }

    @NotNull
    @Override
    public SyntaxHighlighter getHighlighter() {
        return new RegularSyntaxHighlighter();
    }

    @NotNull
    @Override
    public String getDemoText() {
        return "{#if user.age >= 80 }\n" +
                "you are too old\n" +
                "{#elseif user.age <= 10}\n" +
                "you are too young\n" +
                "This is your age {user.age}\n" +
                "{#else}\n" +
                "Welcome, Friend\n" +
                "{/if}";
    }

    @Nullable
    @Override
    public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return null;
    }

    @NotNull
    @Override
    public AttributesDescriptor[] getAttributeDescriptors() {
        return DESCRIPTORS;
    }

    @NotNull
    @Override
    public ColorDescriptor[] getColorDescriptors() {
        return ColorDescriptor.EMPTY_ARRAY;
    }

    @NotNull
    @Override
    public String getDisplayName() {
        return "Regular";
    }
}
