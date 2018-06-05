/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f_10_graf;

/**
 *
 * @author tiago
 */
public class Vertex {
    public String name;
    
    public Vertex(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return name;
    }
}
