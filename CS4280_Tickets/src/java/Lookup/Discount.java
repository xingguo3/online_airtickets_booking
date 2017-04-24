/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lookup;

/**
 *
 * @author User
 */
public class Discount {
    public static int giveDiscountByMem(int price, int membership){
        double p=0;
        if(price>=500&price<800)
            p=price*(1-(double)membership/30);
        if(price>=800&&price<3000)
            p=price*(1-(double)membership/20);
        if(price>=3000)
            p=price*(1-(double)membership/10);//can have a dicount up to 0.9/0.8/0.7
        return (int)p;
    } 
    
    public static int giveDicountByRemainSeat(int price,int remainseat){
        double p=0;
        if(price>=500&price<800)
            p=price*(1-(double)remainseat/300);
        if(price>=800&&price<3000)
            p=price*(1-(double)remainseat/250);
        if(price>=3000)
            p=price*(1-(double)remainseat/200);//can have a dicount up to 0.9/0.8/0.7
        return (int)p;
    }
}
