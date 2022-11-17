package lotto.controller;

import lotto.view.Front;

public class Controller {

    Front front = new Front();
    public void run(){
        System.out.println(front.buyLotto());
    }
}
