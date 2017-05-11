package com.netease.regular.lang.file;

import com.intellij.lang.Language;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.util.Pair;
import com.intellij.psi.impl.source.tree.FileElement;
import com.intellij.psi.impl.source.tree.LeafElement;
import com.intellij.psi.templateLanguages.TemplateDataElementType;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by abnerzheng on 2017/2/14.
 */
public class RegularTemplateDataElementType extends TemplateDataElementType {
    ThreadLocal<ArrayList<Pair<Integer, String>>> hackyStringMapThreadLocal = new ThreadLocal<>();
    public RegularTemplateDataElementType(@NonNls String debugName, Language language, @NotNull IElementType templateElementType, @NotNull IElementType outerElementType) {
        super(debugName, language, templateElementType, outerElementType);
    }

    @Override
    protected void appendCurrentTemplateToken(StringBuilder result, CharSequence buf, Lexer lexer) {
        super.appendCurrentTemplateToken(result, buf, lexer);
        String tokenText = lexer.getTokenText();
        int length = tokenText.length();
        while(--length >= 0){
            char c = tokenText.charAt(length);
            if(c == ' '){
                continue;
            }else if(c == '='){
                break;
            }else {
                return;
            }
        }
        String s = "\"\"";
        int offset = result.length();
        result.append(s);
//             a hacky way to tuning the original html parser
        ArrayList<Pair<Integer, String>> pairs = hackyStringMapThreadLocal.get();
        if(pairs == null){
            pairs = new ArrayList<>();
        }
        if(lexer.getBufferEnd() != lexer.getTokenEnd()) {
            pairs.add(new Pair<>(offset, s));
            hackyStringMapThreadLocal.set(pairs);
        }
    }

    @Override
    protected void prepareParsedTemplateFile(@NotNull FileElement root) {
        super.prepareParsedTemplateFile(root);
        ArrayList<Pair<Integer, String>> pairs = hackyStringMapThreadLocal.get();
        if(pairs == null){
            return;
        }
        int size = pairs.size();
        for(int i = size -1; i >= 0; i--){
            Pair<Integer, String> entry = pairs.get(i);
            LeafElement oldLeaf = root.findLeafElementAt(entry.getFirst() + 1);
            oldLeaf.replaceWithText(oldLeaf.getText().replace("\"", ""));

            LeafElement oldLeaf2 = root.findLeafElementAt(entry.getFirst());
            oldLeaf2.replaceWithText(oldLeaf2.getText().replace("\"", ""));
        }
        pairs.clear();
        hackyStringMapThreadLocal.set(pairs);
    }
}
