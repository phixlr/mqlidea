package ru.investflow.mql.parser.parsing;

import org.jetbrains.annotations.NotNull;

import com.intellij.lang.PsiBuilder;
import com.intellij.psi.tree.IElementType;

import static com.intellij.lang.parser.GeneratedParserUtilBase._NONE_;
import static com.intellij.lang.parser.GeneratedParserUtilBase.consumeToken;
import static com.intellij.lang.parser.GeneratedParserUtilBase.enter_section_;
import static com.intellij.lang.parser.GeneratedParserUtilBase.exit_section_;
import static com.intellij.lang.parser.GeneratedParserUtilBase.nextTokenIs;
import static com.intellij.lang.parser.GeneratedParserUtilBase.recursion_guard_;
import static ru.investflow.mql.psi.MQL4TokenTypes.BLOCK_COMMENT;
import static ru.investflow.mql.psi.MQL4TokenTypes.LINE_COMMENT;

public class CommentParsing {

    public static boolean parseComment(PsiBuilder b, int l) {
        return parseLineComment(b, l) || parseBlockComment(b, l);
    }

    public static boolean parseLineComment(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "rg-line-comment")) {
            return false;
        }
        if (!nextTokenIs(b, "<line-comment>", LINE_COMMENT)) {
            return false;
        }
        PsiBuilder.Marker m = enter_section_(b, l, _NONE_, "<line-comment>");
        boolean r = parse(b, l + 1, "rg-line-comment", LINE_COMMENT);
        exit_section_(b, l, m, LINE_COMMENT, r, false, null);
        return r;
    }

    public static boolean parseBlockComment(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "rg-block-comment")) {
            return false;
        }
        if (!nextTokenIs(b, "<block-comment>", BLOCK_COMMENT)) {
            return false;
        }
        PsiBuilder.Marker m = enter_section_(b, l, _NONE_, "<block-comment>");
        boolean r = parse(b, l + 1, "rg-block-comment", BLOCK_COMMENT);
        exit_section_(b, l, m, BLOCK_COMMENT, r, false, null);
        return r;
    }

    public static boolean parse(PsiBuilder b, int l, @NotNull String recursionGuard, IElementType type) {
        if (!recursion_guard_(b, l, recursionGuard)) {
            return false;
        }
        PsiBuilder.Marker m = enter_section_(b);
        boolean r = consumeToken(b, type);
        exit_section_(b, m, null, r);
        return r;
    }

}