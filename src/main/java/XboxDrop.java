/**
 * Created by NeelaGouda on 6/1/19.
 */
public class XboxDrop {

    /**
     * I had heard of this problem statement somewhere before -CTCI egg drop problem
     * Solved it on similar lines took about 20 mins to write approach
     *
     */


        /**
         * Assumptions:
         * Both Xbox are of same composition and break at same floor
         * We are looking for highest floor from where xbox of similar composition if dropped would not break
         * Of the 2 given Xboxes once the box is broken its gone
         * And Xbox definitely breaks if dropped from top of bldg at floor 120
         *
         * Approach 1 : Linear search
         * Ignoring the need to find minimun drops required
         * Start from floor 1 and increment the floor until the Xbox breaks
         * Worst case you will break only one Xbox and in worst case needs 120 drops
         *
         * Approach 2 : Binary Search
         * Divide the floors in half
         *          if the box breaks use the seconds box for lower hlaf
         *          else use the second box for upper half
         * Since we have only 2 xboxes we cannot iteratively divide in half
         * Worst case : First divide 120/2 = 60
         *              and check in upper 60 or lower 60 (depending on box breaks or not)
         *              need 59+1 = 60 drops to determine
         *
         * Approach 3: Even Division
         * Divide the floors evenly , 120 floors can be evenly divided in 10 floors
         * Would need 10 drops to figure out the range in which the next xbox drop lies
         * Say,
         *      drop1 is from floor 10 - No break
         *      drop2 is from floor 20 - No break
         *      drop3 is from floor 30 - No break
         *      drop4 is from floor 40 - Breaks
         *
         *  We know the box can break any where between Floor 30 to Floor 40
         *  Start from Floor 31, and 32, and 39 Needs 9 drops to figure out the floor
         *  Worst Case: needs 12+9= 21 drops
         *
         *  Similarly, can divide in groups of 12 floors , or 5 floors etc
         *
         *  Approach 4: Optimized Division of Floors
         *
         * Balance the linear drops -
         *      instead of evenly dividing the floors in size of x
         *      and checking (x-1) floors for finding number of drops
         *      Decrease the number of drops performed linearly
         *
         *  Say,
         *    drop1 is from floor 12 _ No break x
         *    drop2 is from floor 11 - No break x-1
         *    drop3 is from floor 10 - No break x-2
         *    drop4 is from floor 9 - No break x-3
         *    and so on until we have 1 floor to check
         *
         *    total drop is x + (x-1) + (x-2) + (x-3) + .... +1 = x(x+1)/2 = 120 (total number of floors)
         *    solve the quadratic function for x gives the mindrop.
         *
         *    x^2 + x - 240 = 0 factors are (x-15)(x+16) , Hence x=15 need 15 min drops to figure out the mindrop
         *
         *
         *
         */

}
