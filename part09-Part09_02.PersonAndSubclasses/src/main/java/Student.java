/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ensia
 */
public class Student extends Person {

   
    private int studyCredit;

    public Student(String name, String address) {
        super(name, address);
        this.studyCredit = 0;

    }
    
    public int credits(){
        return this.studyCredit;
    }
    
    public void study(){
        this.studyCredit = this.studyCredit + 1;
    }
    @Override
    public String toString(){
        return super.toString() + "\n  Study credits " + this.studyCredit;
    }
}
