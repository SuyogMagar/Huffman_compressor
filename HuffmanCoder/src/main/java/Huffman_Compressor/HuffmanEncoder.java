package Huffman_Compressor;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HuffmanEncoder {
    public Map<Character, String> generateCodes(HuffmanNode root) {
        Map<Character, String> huffmanCodes = new HashMap<>();
        encode(root, "", huffmanCodes);
        return huffmanCodes;
    }

    private void encode(HuffmanNode node, String code, Map<Character, String> huffmanCodes) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            huffmanCodes.put(node.character, code);
        }

        encode(node.left, code + "0", huffmanCodes);
        encode(node.right, code + "1", huffmanCodes);
    }

    public String encodeText(String text, Map<Character, String> huffmanCodes) {
        StringBuilder encodedString = new StringBuilder();
        for (char ch : text.toCharArray()) {
            encodedString.append(huffmanCodes.get(ch));
        }
        return encodedString.toString();
    }

    public void saveEncodedToFile(String encodedText, String filePath) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(encodedText);
        }
    }
}
