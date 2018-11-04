package entity;

/**
 * @Author: 王轩
 * @Description:
 * @Date: 2018/11/3
 */
public class Word extends Token{

    public final String lexeme;

    public Word(int t, String s){
        super(t);
        this.lexeme = s;
        //this.toString();
    }

    @Override
    public String toString() {
        System.out.println("<" + this.lexeme + ", " + this.tag + ">");
        return "<" + this.lexeme + ", " + this.tag + ">";
    }
}

