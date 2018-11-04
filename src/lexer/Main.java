package lexer;

import util.IOHelper;

/**
 * @Author: 王轩
 * @Description:
 * @Date: 2018/11/3
 */
public class Main {

    public static void main(String[] args) {
        Lexer lexer = new Lexer();
        String result = lexer.parse();
        IOHelper.writeTXT("test_result.txt",result);
    }
}
