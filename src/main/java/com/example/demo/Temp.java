package com.example.demo;

import java.util.Scanner;
public class Temp {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int widths[]=new int[n];
        int heights[]=new int[n];
        int blockOrder[]=new int[n];
        int lengths[]=new int[n];
        int positionsForS1[]=new int[n];
        int positionsForS2[]=new int[n];
        System.out.println("Enter Widths");
        read(widths,sc);
        System.out.println("Enter heights");
        read(heights,sc);
        System.out.println("Enter blockOrder");
        read(blockOrder,sc);
        sc.nextLine();
        System.out.println("Enter S1 and S2");
        String s1=sc.nextLine();
        String s2=sc.nextLine();

        for(int i=0;i<s1.length();i++){
            char c=s1.charAt(i);
            start(c,blockOrder,positionsForS1,lengths,widths);
        }
        int width=lengths[heights.length-1];
        lengths=new int[n];
        for(int i=0;i<s2.length();i++){
            char c=s2.charAt(i);
            start(c,blockOrder,positionsForS2,lengths,heights);
        }
        int height=lengths[heights.length-1];
        System.out.println("Floorplan size: W= "+width+" X H= "+height);
        System.out.println("Coordinates of blocks");
        for(int i=0;i<n;i++){
            System.out.println(""+(char)(97+i)+"("+positionsForS1[i]+","+positionsForS2[i]+")");
        }

    }

    private static void start(char c, int[] blockOrder, int[] positions, int[] lengths,int[] ar) {
        int charToIndex=c-97;
        int index= blockOrder[charToIndex]-1;
        positions[charToIndex]=lengths[index];
        int sum=positions[charToIndex]+ar[charToIndex];
        update(index,sum,lengths);
    }

    private static void update(int index, int sum, int[] lengths) {
        for(int i=index;i< lengths.length;i++){
            if(sum>lengths[i]){
                lengths[i]=sum;
            }
        }
    }

    private static void read(int[] ar, Scanner sc) {
        for(int i=0;i<ar.length;i++){
            ar[i]=sc.nextInt();
        }
    }
}
