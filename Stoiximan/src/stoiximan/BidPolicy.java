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
public class BidPolicy {

    double budget;
    int maxRounds = 7;

    BidPolicy(double budget) {
        this.budget = budget;
    }

    int findIdealBID() {
        int iBid = 0;
        for (int BID = 2; BID < 50; BID++) {
            if ((BID * pow(2, (maxRounds - 1))) > budget) {
                break;
            } else {
                iBid = BID;
            }
        }
        return iBid;
    }
}
