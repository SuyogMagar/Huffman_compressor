package Huffman_Compressor;

import java.io.*;
import java.util.*;

public class HuffmanFileCompressor {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java HuffmanFileCompressor <input_file> <output_file>");
            return;
        }

        String inputFilePath = args[0];
        String outputFilePath = args[1];

        try {
            // Read input file
            StringBuilder textBuilder = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    textBuilder.append(line).append("\n");
                }
            }
            String text = textBuilder.toString();

            // Step 1: Calculate frequency
            FrequencyCalculator frequencyCalculator = new FrequencyCalculator();
            Map<Character, Integer> frequencyMap = frequencyCalculator.calculateFrequency(text);

            // Step 2: Build Huffman Tree
            HuffmanTreeBuilder treeBuilder = new HuffmanTreeBuilder();
            HuffmanNode root = treeBuilder.buildTree(frequencyMap);

            // Step 3: Generate Huffman Codes
            HuffmanEncoder encoder = new HuffmanEncoder();
            Map<Character, String> huffmanCodes = encoder.generateCodes(root);

            System.out.println("Huffman Codes:");
            for (Map.Entry<Character, String> entry : huffmanCodes.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

            // Step 4: Encode text
            String encodedString = encoder.encodeText(text, huffmanCodes);

            // Step 5: Save encoded text to file
            encoder.saveEncodedToFile(encodedString, outputFilePath);
            System.out.println("Encoded text saved to: " + outputFilePath);

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
