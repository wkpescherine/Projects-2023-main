using System;

namespace Test{
    public static class Program{
        public static void Main(String [] args){
            int num = 3;
            Console.WriteLine(num);
            for(int a = 0; a<10; a++){
                if(a%2 == 0){
                    Console.WriteLine(a);
                }
            }
            String [] words = {"test","This", "out", "now"};
            Console.WriteLine(words[2]);
            String [] something = new String[10];
            something[0] = "Some";
            Console.WriteLine(something[0]);
        }
    }
}