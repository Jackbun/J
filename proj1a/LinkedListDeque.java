public class LinkedListDeque<T>{
        public class Node<T> {
                T item;
                Node prev;
                Node next;

                public Node(Node prev, T i,  Node next) {
                        this.item = i;
                        this.prev = prev;
                        this.next = next;
                }
                public Node(){
                        this.prev = null;
                        this.next = null;
                }
        }

        public Node sentinel;
        public int size;
        public Node first;
        public Node last;



        public LinkedListDeque() {
                sentinel = new Node();
                sentinel.next = sentinel;
                sentinel.prev = sentinel;
                size = 0;
        }

        public void addFirst(T x) {
                first = sentinel.prev;
                first = new Node(null,x,first);
                size += 1;
        }

        public void addLast(T y) {
                last = sentinel.next;
                last = new Node(last, y,null);
                size += 1;
        }


        public boolean isEmpty() {
                System.out.println( size);
                if (size == 0 ) return true;
                else return false;
        }

        public int size() {
                return size;
        }
        public T get(int x) {
                if (x < 0 || x >= size && size == 0) {
                        return null;
                }
                for (int i=0; i<=x; i++){
                      first= first.next;
                }return (T) first.item;
        }

        public void printDeque() {
                for ( int i = 0; i< size;i++) {
                        System.out.println(get(i) + " ");
                }
        }

        public T removeFirst() {
                if (size == 0) return null;
                else  size = size - 1;
                        return (T) first.item;

                }

        public T removeLast(){
                if (size ==0) return null;

                else   size = size-1;
                        return (T)last.item;


        }
        }
