package aufgabe.drei.b;

import aufgabe.drei.a.BinaryTree;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class GenericTreeNodeTest {
    @Nested
    class GenericBinaryTree_implements_contains{

        @Test
        void with_Integer(){
            var tree = new GenericBinaryTree<Integer>();
            tree.add(3);
            tree.add(7);

            assertTrue(tree.contains(3));
            assertTrue(tree.contains(7));
            assertFalse(tree.contains(4));
        }
        @Test
        void with_String(){
            var tree = new GenericBinaryTree<String>();
            tree.add("a");
            tree.add("b");

            assertTrue(tree.contains("a"));
            assertTrue(tree.contains("b"));
            assertFalse(tree.contains("c"));
        }
        @Test
        void with_Date(){
            var tree = new GenericBinaryTree<Date>();
            tree.add(new Date(0));
            tree.add(new Date(1));

            assertTrue(tree.contains(new Date(0)));
            assertTrue(tree.contains(new Date(1)));
            assertFalse(tree.contains(new Date(2)));
        }
    }
}