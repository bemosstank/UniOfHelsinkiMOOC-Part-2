/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ensia
 */
public class Book {

    private String bookName;
    private int recommendationAge;
       
    public Book(String bookN, int recAge) {
        this.bookName = bookN;
        this.recommendationAge = recAge;
    }
    
    public String getBookName(){
        return this.bookName;
    }
    
    public int getRecommendationAge(){
        return this.recommendationAge;
    }
    
    @Override
    public String toString(){
        return this.bookName + " (" + "recommended for " + this.recommendationAge + " year-olds or older)";
    }

}
