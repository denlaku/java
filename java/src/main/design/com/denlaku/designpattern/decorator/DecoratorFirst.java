package com.denlaku.designpattern.decorator;
public class DecoratorFirst extends Decorator {  
  
    public DecoratorFirst(Human human) {  
        super(human);  
    }  
  
    public void goClothespress() {  
        System.out.println("去衣柜找找看。。");  
    }  
  
    public void findPlaceOnMap() {  
        System.out.println("在Map上找找。。");  
    }  
  
    @Override  
    public void wearClothes() {  
        super.wearClothes();  
        goClothespress();  
    }  
  
    @Override  
    public void walkToWhere() {  
        super.walkToWhere();  
        findPlaceOnMap();  
    }  
}  