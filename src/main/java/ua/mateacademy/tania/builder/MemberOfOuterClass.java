package ua.mateacademy.tania.builder;

public class MemberOfOuterClass {
    static char star = '*';

    static class Inner1 {
        void print() {
            System.out.println(star);
        }
    }
}
