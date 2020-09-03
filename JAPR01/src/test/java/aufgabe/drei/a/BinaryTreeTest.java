package aufgabe.drei.a;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    @Test
    void binaryTree_implements_contains(){
        var tree = new BinaryTree();
        tree.add(3);
        tree.add(7);

        assertTrue(tree.contains(3));
        assertTrue(tree.contains(7));
        assertFalse(tree.contains(4));
    }

}