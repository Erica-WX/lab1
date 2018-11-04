package entity;

/**
 * @Author: 王轩
 * @Description:
 * @Date: 2018/11/3
 */
public class Num extends Token {

    private final int value;

    public Num(int v) {
        super(61); // NUM的类别码
        this.value = v;
        //this.toString();
    }

    @Override
    public String toString(){
        System.out.println("<" + this.value + ", " + this.tag + ">");
        return "<" + this.value + ", " + this.tag + ">";
    }
}
