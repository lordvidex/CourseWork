package ru.kpfu.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA
 * Date: 15.12.2020
 * Time: 21:17
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * <p>
 * Desc: Using BFS to calculate number of times
 * to get integer B from A with only two possible operations
 * <list>Adding 3</list>
 * <list>Multiplying by 4</list>
 * </p>
 */
public class Main {
    public static int commandCountBFS(int a,int b){

        //main queue
        Queue<Integer> queue = new LinkedList<>();
        //child queue
        Queue<Integer> buffer = new LinkedList<>();
        int counter = 0;
        queue.add(a);
        while(!(queue.isEmpty()&&buffer.isEmpty())) {
            if(!buffer.isEmpty())buffer.clear();
            while (!queue.isEmpty()) {
                int present = queue.remove();
                if (present == b) return counter;
                if ((present + 3) <= b) buffer.add(present + 3);
                if ((present * 4) <= b) buffer.add(present * 4);
            }
            ///main queue `queue` is empty
            ///move all children items in child queue `buffer` to `queue`
            queue.addAll(buffer);
            counter++;
        }
        //both queues are empty meaning it's impossible
        return -1;
    }
    public static void main(String[] args){
        int a,b;
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        System.out.println(commandCountBFS(a,b));
    }
}
