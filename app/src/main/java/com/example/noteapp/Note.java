package com.example.noteapp;


//Kurucu metod, Note nesnesini oluştururken notun başlığını ve içeriğini alır ve bu değerleri sınıfın ilgili değişkenlerine atar. 
  //  getNoteHead metodu, notun başlığını döndürür. getNoteBody metodu ise notun içeriğini döndürür.

public class Note {

    private String noteHead;
    private String noteBody;


    public Note(String noteHead, String noteBody) {

        this.noteHead = noteHead;
        this.noteBody = noteBody;
    }




    public String getNoteHead() {
        return noteHead;
    }

    public String getNoteBody() {
        return noteBody;
    }

}
