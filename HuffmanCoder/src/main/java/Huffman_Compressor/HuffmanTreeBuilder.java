package Huffman_Compressor;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.Comparator;

public class HuffmanTreeBuilder {
    public HuffmanNode buildTree(Map<Character, Integer> frequencyMap) {
        PriorityQueue<HuffmanNode> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(node -> node.frequency));

        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            priorityQueue.add(new HuffmanNode(entry.getValue(), entry.getKey()));
        }

        while (priorityQueue.size() > 1) {
            HuffmanNode left = priorityQueue.poll();
            HuffmanNode right = priorityQueue.poll();

            HuffmanNode merged = new HuffmanNode(left.frequency + right.frequency, left, right);
            priorityQueue.add(merged);
        }

        return priorityQueue.poll();
    }
}
