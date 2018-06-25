/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stoiximan;

import static java.lang.Math.pow;

/**
 *
 * @author jonnie
 */
public class Round {

        double bid, initBid;
        int step;

        Round(double initBid) {
            this.initBid = initBid;
            step = 1;
        }

        double nextBid() {
            step += 1;
            double nextBid;
            nextBid = initBid * pow(2, (step - 1));
            bid = nextBid;
            return nextBid;
        }
    }
