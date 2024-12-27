package Huffman_Compressor;

public class HuffmanNode {
    int frequency;
    char character;
    HuffmanNode left;
    HuffmanNode right;

    public HuffmanNode(int frequency, char character) {
        this.frequency = frequency;
        this.character = character;
        this.left = null;
        this.right = null;
    }

    public HuffmanNode(int frequency, HuffmanNode left, HuffmanNode right) {
        this.frequency = frequency;
        this.left = left;
        this.right = right;
    }
}
