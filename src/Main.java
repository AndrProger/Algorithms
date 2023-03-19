import HashMap.HashMap;

public class Main {
    public static void main(String[] args) {
//        HashMap w=new HashMap<>();
//
//        System.out.println(w.put("name",1)+"");
//        System.out.println(w.put("name","Ansd")+"");
//        System.out.printf(w.get("name")+"");
//        System.out.printf("end");

        HashMap<String,String> map=new HashMap();
        map.add("name","stas");
        map.add("age","19");
        map.add("user","Sts");
        map.add("toke","23");
        map.add("surname","Yart");
        map.add("data","{text:eweweweeww}");
        map.add("wer","wer");
        map.add("toreew","qwwqe");
        map.add("qww","wqqwwww");
        map.add("ccd","ret");
        map.add("iyuyu","654");
        map.add("qwwedew","reewgtyu");
        map.add("12","ew3");
        map.add("3","3");
        map.add("4","4");
        map.add("5","4");
        map.add("6","4");
        map.add("7","4");
        map.add("8","4");
        map.add("9","4");
        map.printAllMap();

        System.out.println("user "+map.get("user"));


    }
}