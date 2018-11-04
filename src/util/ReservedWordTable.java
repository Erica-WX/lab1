package util;

import entity.ReservedWord;
import entity.Word;

import java.util.Hashtable;

/**
 * @Author: 王轩
 * @Description:
 * @Date: 2018/11/3
 */
public class ReservedWordTable {

    public Hashtable words = new Hashtable();

    public ReservedWordTable(){
        reserve(new Word(ReservedWord.CLASS.ordinal(), "class"));
        reserve(new Word(ReservedWord.PUBLIC.ordinal(), "public"));
        reserve(new Word(ReservedWord.PROTECTED.ordinal(), "protected"));
        reserve(new Word(ReservedWord.PRIVATE.ordinal(), "private"));
        reserve(new Word(ReservedWord.VOID.ordinal(), "void"));
        reserve(new Word(ReservedWord.STATIC.ordinal(), "static"));
        reserve(new Word(ReservedWord.INT.ordinal(), "int"));
        reserve(new Word(ReservedWord.CHAR.ordinal(), "char"));
        reserve(new Word(ReservedWord.FLOAT.ordinal(), "float"));
        reserve(new Word(ReservedWord.DOUBLE.ordinal(), "double"));
        reserve(new Word(ReservedWord.STRING.ordinal(), "String"));
        reserve(new Word(ReservedWord.IF.ordinal(), "if"));
        reserve(new Word(ReservedWord.ELSE.ordinal(), "else"));
        reserve(new Word(ReservedWord.SWITCH.ordinal(), "switch"));
        reserve(new Word(ReservedWord.CASE.ordinal(), "case"));
        reserve(new Word(ReservedWord.FOR.ordinal(), "FOR"));
        reserve(new Word(ReservedWord.DO.ordinal(), "do"));
        reserve(new Word(ReservedWord.WHILE.ordinal(), "while"));
        reserve(new Word(ReservedWord.TRY.ordinal(), "try"));
        reserve(new Word(ReservedWord.CATCH.ordinal(), "catch"));
        reserve(new Word(ReservedWord.TRUE.ordinal(), "true"));
        reserve(new Word(ReservedWord.FALSE.ordinal(), "false"));
        reserve(new Word(ReservedWord.NEW.ordinal(), "new"));
    }

    private void reserve(Word t){
        words.put(t.lexeme, t);
    }
}
