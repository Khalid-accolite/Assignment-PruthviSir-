package com.company;

import java.util.ArrayList;
import java.util.Scanner;

class Count extends Thread{
    int start;
    int end;
    ArrayList<String> brr;
    int count;
    Count(int start, int end,ArrayList<String> inputs){
        this.start=start;
        this.end=end;
        this.brr=inputs;
    }
    public void run(){
        for (int i = start; i < end; i++) {
            String[] kk = brr.get(i).split(" ");
            int len=kk.length;
            count=count+len;
        }
    }


    public int getCount(){
        return count;
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException{
        Scanner sc = new Scanner(System.in);
        long start = System.currentTimeMillis();
        System.out.println("Input total no of lines");
        int l = sc.nextInt();
        sc.nextLine();
        ArrayList<String> inputs = new ArrayList<String>();
           for(int i=0;i<l;i++) {
               String sentence = sc.nextLine();
               inputs.add(sentence);
           }
        System.out.println("No of threads: ");
        int t=sc.nextInt();
        int size=l/t;
        int val=0;
        ArrayList<Count> ob = new ArrayList<>();

        while(val<l){
            Count c=new Count(val,val+size-1,inputs);
            ob.add(c);
            val=val+size;
        }
        for(Count w:ob){
            w.start();
        }
        for(Count w:ob){
            w.join();
        }
        int totalcount=0;
        for(Count w:ob) totalcount = totalcount + w.getCount();
        long end = System.currentTimeMillis();
        System.out.println("Total count of words: "+totalcount);
        long time=end-start;
        System.out.println("Total time taken by threads: "+time);

    }
}
