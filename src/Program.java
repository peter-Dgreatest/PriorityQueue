public class Program {

    public static void main(String[] args) {
        PQueue pQueue = new PQueue(new int[]{75,50,25,45,35,10,15,20,40});

        System.out.println(pQueue.peek());
        System.out.println(pQueue.size());
        System.out.println(pQueue);

        pQueue.push(90);


        System.out.println(pQueue.peek());
        System.out.println(pQueue.size());
        System.out.println(pQueue);



        pQueue.pop(0);


        System.out.println(pQueue.peek());
        System.out.println(pQueue.size());
        System.out.println(pQueue);

    }
}
