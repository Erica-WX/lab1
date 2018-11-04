package util;

import java.io.*;
import java.util.ArrayList;

/**
 * @Author: 王轩
 * @Description:
 * @Date: 2018/11/3
 */
public class IOHelper {

    public static int line = 1;

    public static ArrayList<Character> readTXT(String path) {

        File file = new File(path);
        BufferedReader reader = null;

        char[] tempChars;

        ArrayList<Character> buffer = new ArrayList<>();

        try{
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

            String str;
            while((str = reader.readLine()) != null){
                tempChars = str.toCharArray();

                for(Character c:tempChars){
                    if(c== '\t'){
                        continue;
                    }else{
                        buffer.add(c);
                    }
                }
                buffer.add('\n');

                line++;
            }
            reader.close();

        } catch (IOException e){
            System.out.println("文件不存在");
        }


        return buffer;
    }

    public static void writeTXT(String path, String context){
        try{
            FileWriter writer = new FileWriter(path);
            writer.write(context);
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
