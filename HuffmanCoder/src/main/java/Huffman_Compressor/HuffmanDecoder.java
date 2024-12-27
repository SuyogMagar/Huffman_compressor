package Huffman_Compressor;

public class HuffmanDecoder {
    public String decodeText(String encodedText, HuffmanNode root) {
        StringBuilder decodedString = new StringBuilder();
        HuffmanNode currentNode = root;
        for (char bit : encodedText.toCharArray()) {
            currentNode = (bit == '0') ? currentNode.left : currentNode.right;

            if (currentNode.left == null && currentNode.right == null) {
                decodedString.append(currentNode.character);
                currentNode = root;
            }
        }
        return decodedString.toString();
    }
}
