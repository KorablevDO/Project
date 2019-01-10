package library.utils.Message;

import library.utils.Object.Message;

public class ReadMessageBuffer {
    private static ReadMessageBuffer o;

    private ReadMessageBuffer(){}

    public static ReadMessageBuffer get(){
        if(o == null){
            o = new ReadMessageBuffer();
        }
        return o;
    }

    public void setMessage(Message o){
        System.out.println(o.message);
    }
}
