/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ensia
 */
public class Person {

    private String name;
    private Education ed;
    
    public Person(String name, Education education){
        this.name = name;
        this.ed = education;
    }

    public Education getEducation(){
        return this.ed;
    }
    
   
    @Override
    public String toString(){
        return this.name + ", " + this.ed;
    }
    
    
}
