import app.trees.binary_tree.AVLTree;
import app.trees.binary_tree.BinarySearchTree;
import app.trees.binary_tree.SplayTree;

import java.util.ArrayList;
import java.util.List;

public class Main {

    /*public static void f(List<Integer> list) {
        list.add(42);
    }*/

    public static void main(String[] args) {
        //System.arraycopy();

        /*ArrayList<Set<Integer>> integers = new ArrayList<>();
        HashSet<Integer> set1 = new HashSet<>();
        set1.add(42);
        set1.add(13);
        set1.add(27);
        HashSet<Integer> set2 = new HashSet<>();
        set2.add(13);
        integers.add(set1);
        System.out.println(ListDemo.countOfNotIntersectedSets(integers, set2));

        Set<Human> humans = new HashSet<>();
        humans.add(new Human("Vasya", "Pupkin", 45));
        humans.add(new Student("Vasya", "Junior","Pupkin", 4));
        humans.add(new Human("Katrin", "Zeta", "NotJones", 37));
        humans.add (new Human("Gennadiy", "Vasil'evich", "Voronkov", 23));

        List<Human> listOfHumans = listOfHumanByLexicographicalFIO(humans);

        printCollectionToStdout(listOfHumans);

        Map<Integer, Student> map = new HashMap<>();
        map.put(42, new Student("Frodo", "Beggins", 37, "IMIT"));
        map.put(12, new Student("Roman", "Fins", 17, "FIMT"));
        Set<Integer> set = new HashSet<>();
        set.add(42);
        Set<Student> students = setOfHumansWithIdInSet(map, set);

        System.out.println();
        printCollectionToStdout(students);*/



        //LinkedHashSet<Integer> tree = new LinkedHashSet<>();
        //Class arr = tree.getClass().getSuperclass();
        //System.out.println(Object.class.getSuperclass());

        /*ArrayList<Integer> list = new ArrayList<>();
        f(list);
        System.out.println(list);
        System.out.println();*/


        AVLTree tree = new AVLTree();
        tree.insert( 9);
        tree.insert( 5);
        tree.insert( 10);
        tree.insert( 0);
        tree.insert( 6);
        tree.insert( 11);
        tree.insert( -1);
        tree.insert( 1);
        tree.insert( 2);

        System.out.println(tree.preOrderTraversal());

        tree.remove(10);
        System.out.println();
        System.out.println(tree.preOrderTraversal());

        System.out.println("#################");
        System.out.println();

        AVLTree avlTree = new AVLTree();
        avlTree.insert(10);
        avlTree.insert(20);
        avlTree.insert(30);
        avlTree.insert(40);
        avlTree.insert(50);
        avlTree.insert(25);

        avlTree.remove(10);
        avlTree.remove(25);
        avlTree.remove(50);

        avlTree.insert(1);
        System.out.println(avlTree.preOrderTraversal() + "\n");
        avlTree.insert(2);

        System.out.println(avlTree.preOrderTraversal() + "\n");

        System.out.println("fffff");

        System.out.println(avlTree.getRoot());
        System.out.println(avlTree.getRoot().getHeight());
        System.out.println(avlTree.getRoot().getLeft());
        System.out.println(avlTree.getRoot().getLeft().getHeight());
        System.out.println(avlTree.getRoot().getRight());
        System.out.println(avlTree.getRoot().getRight().getHeight());
        System.out.println();

        avlTree = new AVLTree();
        avlTree.insert(5);
        avlTree.insert(1);
        avlTree.insert(10);
        avlTree.insert(7);
        avlTree.insert(15);

        System.out.println(avlTree.preOrderTraversal() + "\n");

        avlTree.insert(6);

        System.out.println(avlTree.preOrderTraversal() + "\n");

        /*BinarySearchTree tree = new BinarySearchTree(21);
        tree.insert(42);
        tree.insert(12);
        tree.insert(0);
        tree.insert(13);
        tree.remove(13);
        tree.remove(0);
        tree.insert(42);
        tree.insert(253);
        tree.insert(100);
        tree.insert(99);
        tree.insert(22);
        tree.insert(24);
        tree.remove(21);
        tree.insert(19);
        System.out.println(tree.inOrderTraversal());
        System.out.println(tree.preOrderTraversal());
        System.out.println(tree.postOrderTraversal());
        System.out.println(tree.getRoot().getKey());

        System.out.println();

        AVLTree avlTree = new AVLTree(42);
        avlTree.insert(342);
        avlTree.insert(12);
        avlTree.insert(434);
        avlTree.insert(787);
        avlTree.insert(-2);
        avlTree.insert(0);
        System.out.println(avlTree.height());
        System.out.println(avlTree.getRoot().getKey());
        System.out.println(avlTree.preOrderTraversal());

        System.out.println();

        SplayTree splayTree = new SplayTree();
        splayTree.insert(23);
        splayTree.insert(11);
        splayTree.insert(5);
        splayTree.insert(8);
        System.out.println(splayTree.find(11));
        System.out.println(splayTree.getRoot());
        System.out.println(splayTree.preOrderTraversal());
        splayTree.find(23);
        System.out.println(splayTree.preOrderTraversal());
        System.out.println(splayTree.preOrderTraversal());*/
    }
}
