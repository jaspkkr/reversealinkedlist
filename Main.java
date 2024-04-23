public class Main {
    static class MyNode{
        private int id;
        private MyNode node;


        public MyNode getNext() {
            return node;
        }

        public MyNode(int id, MyNode node) {
            this.id = id;
            this.node = node;
        }

        public void setNode(MyNode node) {
            this.node = node;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "MyNode{" +
                    "id=" + id +
                    ", node=" + node +
                    '}';
        }
    }
    public static void main(String[] args) {

        MyNode list = new MyNode(1, new MyNode(2, new MyNode(3, null)));

        System.out.println("Actual List:");
        printList(list);

        System.out.println("Reversed List: " + reverse(list));
    }

    private static MyNode reverse(MyNode list) {
        MyNode start = list;
        MyNode finalList =  null;

        while (start != null){
            if (finalList ==null)
                finalList = new MyNode(start.getId(), null);
            else
                finalList = new MyNode(start.getId(), finalList);

            start = start.getNext();
        }

        return finalList;
    }



    //If I recall correctly this was the existing printList method in the coding challenge.
    private static void printList(MyNode list) {
        MyNode start = list;

        while (start.getNext() != null){
            System.out.println(start.getId());
            start = start.getNext();
        }

        //I don't recall completly if original printList method had code to print last node, but I never saw 3 getting printed
        //so if not, we need to add an extra line here to print last node because
        //last node will never be processed by above loop because it's node element is null so loop makes an exit before processing node data
        // so we need this line as a workaround.
        System.out.println(start.getId());

    }
}
