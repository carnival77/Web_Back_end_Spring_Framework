package com.company;

import java.io.FileWriter;
import java.io.IOException;

// checked exception vs unchecked exception
//
//    1. 공통 : 모두 일단 발생하면 해당 예외에 대한 처리 코드가 있어야 프로그램의 비정상 종료 막을 수 있다.
//    2. unchecked exception : RuntimeException의 하위 클래스들.
//        예외에 대한 처리 코드가 없어도 컴파일 오류가 발생하지 않는다.
//    3. checked exception : 예외에 대한 처리 코드가 없을 경우 컴파일 오류 발생.


public class ExceptionApp {
    public void File_practice() throws IOException {
        FileWriter f = null;
        try{
            f = new FileWriter("data.txt");
            f.write("Hello");
//            f.close();
        } catch(IOException e){
            e.printStackTrace();
        }
        finally { // try에서 예외가 발생해 catch가 실행하는가 여부에 관계 없이 finally안의 내용은 무조건 실행된다.
            System.out.println("텍스트 생성");
            if ( f != null) {
                try{
                    f.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }

        }
    }
}
