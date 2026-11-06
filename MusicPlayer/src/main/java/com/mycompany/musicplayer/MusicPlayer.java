/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.musicplayer;
import java.util.Scanner;
import javax.swing.JOptionPane;
//Course: CSC191
//Date: 4/12/2026
//Author: Aarion LLoyd
//Project: Music Player
//Purpose: To use doublyliked list to make a playlist of songs
class Node 
{
    //this is the song of the string
    String song;
    //next to get the next node 
    Node next;
    //previous to get the previous node
    Node previous;
    //constructor for the class
    Node(String data)
    {
        //getting the data  in this case our song
        this.song = data;
        // at the beginning, there is no next node (null)
        this.next = null;
        //then we get the previous node(null) 
        this.previous = null;
    }
}

class DoublyLinked
{
    //here i make a node from my node class that has a next and previous method
    Node head;
    //current node   
    Node Current;
    //here i make an insertEnd for the linkedList
    public void insertEnd(String song){
        //track is just a song, in this case our node
         Node track = new Node(song);
         //we check if head == null, signaling that theres space
         if(head == null){
             //make the hear and current track to represent the start of the list
             head = track;
             Current = track;
         }
         else
         {
          //otherwise our extensio becomes the head
          Node extension = head;
          //and while the head has nothing after
          while(extension.next != null)
          {
           //we would set extension = to extension.next
           extension = extension.next;
          }
          //the extension in this case would be our song back to our album
          extension.next = track;
         //but we arent on tthat album anymore so we in order to go back we link back
         //to our previous song
          track.previous = extension;
          Current = track;
         }
    }
    public String currentSong()
    {
        //if current song is null return an error
        if(Current.song == null)
        {
            String currentE = "There is no current Song";
            return currentE;
        }
        //else return current.song
        return Current.song;
    }
    public String nextSong()
    {
        //if song after head is null, i return the songErr
        if(Current.next == null)
        {
            //return the song
             String songE = "There is no next Song";
             return songE;
        }
        //set current to current.next
        Current = Current.next;
        //play current song
        return Current.song;
    }
    public String previousSong()
    {
        //then i check if their is a previous song
        if(Current.previous == null)
        {
            //return the error
             String previousE = "There is no previous song";
             return previousE;
        }
        //let current equal the previous osng
        Current = Current.previous;
        //return current
        return Current.song;
    }
    public void playlist()
    {
        //here we make a node that is the head
        Node list = this.head;
        //count for the amount of songs and plaement
        int count = 1;
        //son long as there is a song left
        while(list!= null)
        {
            //we print out the node's song
            System.out.println(count+" "+list.song);
            //move onto the next
            list = list.next;
            //increase our count by one
            count++;
        }
        //add space at the end 
        System.out.println();
    }
}
public class MusicPlayer 
{
    public static void main(String[] args) 
    {
        //make a boolean to keep the program going
        boolean main = true;
        //user chocie
        int choice;
        //temp to fix input validation error when dealing with ints and Strings
        String temp;
        //call the new playst object for the 
        DoublyLinked playlist = new DoublyLinked();
        //new input for the scanner
        Scanner input = new Scanner(System.in);
        //while the boolean is true, you run the menu at the
        //to give tne user some options
        while(main)
        {
        //this is the menu for the user's options
        System.out.println("Here are your choices");
        System.out.println("1. Add Song");
        System.out.println("2. Play Next Song");
        System.out.println("3. Play Previous Song");
        System.out.println("4. Show Current Song");
        System.out.println("5. Display Playlist");
        System.out.println("6. Exit");
        //here we get their choice every time
        choice = input.nextInt();
        //heres the choices
        switch(choice)
        {
            case 1:
                boolean valid = true;
                //song for user input
                String song;
                //let the user enter a song
                System.out.print("Enter song here: ");
                temp = input.nextLine();
                song = input.nextLine();
                //check if it's null
                if(song.length() == 0)
                {
                    //set valid to false
                    valid = false;
                    //while not true
                    while(!valid){
                     //do the same ask over again
                     System.out.print("Enter song here");
                     temp = input.nextLine();
                     song = input.nextLine();
                    }
                }else{
                    //otherwise set valid to true
                    valid = true;
                }
                //if true
                if(valid)
                {
                    //call our function
                playlist.insertEnd(song);
                    //let the user know that the song has been added
                    System.out.println(song+"has been added");
                }
            break;
            case 2:
                //play the enxt song
                System.out.println("Next Song Playing: "+playlist.nextSong());
            break;
            case 3:
                //play the previous song
                System.out.println("Previously: "+playlist.previousSong());
            break;
            case 4:
                //show the current song
                System.out.println("Current Song: "+playlist.currentSong());
            break;
            case 5:
                //show the playlist
                System.out.println("Playlist so far: ");
                playlist.playlist();
            break;
            case 6:
                //break out of the loop
            System.out.println("Exiting Music Player---Goodbye!");
            main = false;
            break;
        }
    }
}
}
