package lexer;

import entity.Num;
import entity.Word;
import util.IOHelper;
import util.ReservedWordTable;

import java.util.ArrayList;

/**
 * @Author: 王轩
 * @Description:
 * @Date: 2018/11/3
 */
public class Lexer {

    private ReservedWordTable table = new ReservedWordTable();

    private int tag;
    private int v;
    private String s;
    private Num num;
    private Word w;
    private int line = 1;

    String result = "";

     String parse(){

        ArrayList<Character> characters = IOHelper.readTXT("test.txt");
        int length = characters.size();

        int index = 0;
        char[] buffer = new char[20];

        while(index < length){
            char c = characters.get(index);

            v = 0;

            if(Character.isDigit(c)){

                String str1 = "";

                while (Character.isDigit(c)){
                    //v = v * 10 + Character.digit(c, 10);
                    str1 += c;

                    index++;
                    c = characters.get(index);
                }

                index--;

                judge(str1);

            }else if(Character.isLetter(c)){
                StringBuffer b = new StringBuffer();

                while(Character.isLetter(c)){

                    b.append(c);
                    index++;
                    c = characters.get(index);
                }

                index--;

                s = b.toString();

                w = (Word)table.words.get(s);

                if(w != null){
                    result = result + w.toString() + '\n';
                }else {
                    tag = 23;
                    w = new Word(tag, s); // 字母类别码
                    table.words.put(s, w);
                    result = result + w.toString() + '\n';
                }
            }else {

                switch (c){
                    case '+':
                        index++;
                        c = characters.get(index);
                        if(c == '='){
                            tag = 24;
                            w = new Word(tag, "+=");
                            result = result + w.toString() + '\n';
                        }else if(Character.isDigit(c)){
                        v = 0;
                        String str3 = "";

                        while (Character.isDigit(c)){
                            //v = v * 10 + Character.digit(c, 10);
                            str3 += c;
                            index ++;
                            c = characters.get(index);
                        }

                        index--;

                        str3 = "+"+str3;
                        judge(str3);


                    }
                        else{
                            tag = 25;
                            index--;
                            w = new Word(tag, "+");
                            result = result + w.toString() + '\n';
                        }
                        break;

                    case '-':
                        index++;
                        c = characters.get(index);

                        String str2 = "";

                        // 负数
                        if(Character.isDigit(c)){
                            v = 0;

                            while (Character.isDigit(c)){
                                //v = v * 10 + Character.digit(c, 10);
                                str2 += c;
                                index ++;
                                c = characters.get(index);
                            }

                            index--;

                            str2 = "-"+str2;
                            judge(str2);


                        }else if(c == '='){
                            tag = 26;
                            w = new Word(tag, "-=");
                            result = result + w.toString() + '\n';
                        }else {
                            tag = 27;
                            w = new Word(tag, "-");
                            result = result + w.toString() + '\n';
                        }

                        break;

                    case '*':
                        index++;
                        c = characters.get(index);

                        if(c == '='){
                            tag = 28;
                            w = new Word(tag, "*=");
                            result = result + w.toString() + '\n';
                        }else if(c == '/'){
                            tag = 29;
                            w = new Word(tag, "*/");
                            result = result + w.toString() + '\n';
                        }else {
                            tag = 30;
                            w = new Word(tag, "*");
                            result = result + w.toString() + '\n';
                        }
                        break;

                    case '/':
                        index++;
                        c = characters.get(index);

                        if(c == '='){
                            tag = 31;
                            w = new Word(tag, "/=");
                            result = result + w.toString() + '\n';
                        }else if(c == '/'){
                            tag = 32;
                            w = new Word(tag, "//");
                            result = result + w.toString() + '\n';
                        }else if(c == '*'){
                            tag = 33;
                            w = new Word(tag, "/*");
                            result = result + w.toString() + '\n';
                        }else {
                            tag = 34;
                            w = new Word(tag, "/");
                            result = result + w.toString() + '\n';
                        }
                        break;

                    case '=':
                        index++;
                        c = characters.get(index);

                        if(c == '='){
                            tag = 35;
                            w = new Word(tag, "==");
                            result = result + w.toString() + '\n';
                        }else{
                            tag = 36;
                            w = new Word(tag, "=");
                            result = result + w.toString() + '\n';
                        }
                        break;

                    case '<':
                        index++;
                        c = characters.get(index);

                        if(c == '='){
                            tag = 37;
                            w = new Word(tag, "<=");
                            result = result + w.toString() + '\n';
                        }else{
                            tag = 38;
                            w = new Word(tag, "<");
                            result = result + w.toString() + '\n';
                        }
                        break;

                    case '>':
                        index++;
                        c = characters.get(index);

                        if(c == '='){
                            tag = 39;
                            w = new Word(tag, ">=");
                            result = result + w.toString() + '\n';
                        }else {
                            tag = 40;
                            w = new Word(tag, ">");
                            result = result + w.toString() + '\n';
                        }
                        break;

                    case '&':
                        index++;
                        c = characters.get(index);

                        if(c == '&'){
                            tag = 41;
                            w = new Word(tag, "&&");
                            result = result + w.toString() + '\n';
                        }else {
                            tag = 42;
                            w = new Word(tag, "&");
                            result = result + w.toString() + '\n';
                        }
                        break;

                    case '|':
                        index++;
                        c = characters.get(index);

                        if(c == '|'){
                            tag = 43;
                            w = new Word(tag, "||");
                            result = result + w.toString() + '\n';
                        }else {
                            tag = 44;
                            w = new Word(tag, "|");
                            result = result + w.toString() + '\n';
                        }
                        break;

                    case '!':
                        index++;
                        c = characters.get(index);

                        if(c == '='){
                            tag = 45;
                            w = new Word(tag, "!=");
                            result = result + w.toString() + '\n';
                        }else{
                            tag = 46;
                            w = new Word(tag, "!");
                            result = result + w.toString() + '\n';
                        }
                        break;

                    case '(':
                        tag = 47;
                        w = new Word(tag, "(");
                        result = result + w.toString() + '\n';
                        break;

                    case ')':
                        tag = 48;
                        w = new Word(tag, ")");
                        result = result + w.toString() + '\n';
                        break;

                    case '[':
                        tag = 49;
                        w = new Word(tag, "[");
                        result = result + w.toString() + '\n';
                        break;

                    case ']':
                        tag = 50;
                        w = new Word(tag, ")");
                        result = result + w.toString() + '\n';
                        break;

                    case '{':
                        tag = 51;
                        w = new Word(tag, "{");
                        result = result + w.toString() + '\n';
                        break;

                    case '}':
                        tag = 52;
                        w = new Word(tag, "}");
                        result = result + w.toString() + '\n';
                        break;

                    case ',':
                        tag = 53;
                        w = new Word(tag, ",");
                        result = result + w.toString() + '\n';
                        break;

                    case ':':
                        tag = 54;
                        w = new Word(tag, ":");
                        result = result + w.toString() + '\n';
                        break;

                    case ';':
                        tag = 55;
                        w = new Word(tag, ";");
                        result = result + w.toString() + '\n';
                        break;

                    case '\'':
                        tag = 56;
                        w = new Word(tag, "\'");
                        result = result + w.toString() + '\n';
                        break;

                    case '\"':
                        tag = 57;
                        w = new Word(tag, "\"");
                        result = result + w.toString() + '\n';
                        break;

                    case '.':
                        tag = 58;
                        w = new Word(tag, ".");
                        result = result + w.toString() + '\n';
                        break;

                    case '\n':
                        tag = 59;
                        line++;
                        break;

                    case ' ':
                        tag = 60;
                        break;

                        default:
                            System.out.println("Exception in line "+ line + ":Undefined Character");
                            result = result + "Exception in line "+ line + ":Undefined Character" + '\n';
                }

            }



           // index--;
            index++;
        }

        return result;

    }

    private void judge(String str){

         try{
             v = Integer.parseInt(str);
             num = new Num(v);
             result = result + num.toString() + '\n';
         }catch (Exception e){
             System.out.println("Exception in line "+ line + ": Number overflow");
             result = result + "Exception in line "+ line + ": Number overflow" + '\n';
         }
    }
}
