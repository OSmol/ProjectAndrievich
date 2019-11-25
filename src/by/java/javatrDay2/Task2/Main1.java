package javatrDay2.Task2;

import java.util.Scanner;

//1. Приветствовать любого пользователя при вводе его имени через командную строку.
public class Main1 {
    public static void main(String[] args) {
        String str = "Hello, ";
        if(args.length!=0){
            str+=args[0];
        }else{
            str+= "anonim";
        }
        System.out.println(str);
    }}
