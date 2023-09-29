package mpr;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Node {
	Character ch;
	Integer freq;
	Node left = null;
	Node right = null;

	Node(Character ch, Integer freq) {
		this.ch = ch;
		this.freq = freq;
	}

	public Node(Character ch, Integer freq, Node left, Node right) {
		this.ch = ch;
		this.freq = freq;
		this.left = left;
		this.right = right;
	}
}

public class huffman {
	public static StringBuilder createHuffmanTree(String text) {
		if (text == null || text.length() == 0) {
			// return; //to fix
		}
		Map<Character, Integer> freq = new HashMap<>();
		// loop iterates over the string and converts the text into character array
		for (char c : text.toCharArray()) {
			freq.put(c, freq.getOrDefault(c, 0) + 1);
		}
		// Here a point to note that the highest priority means the lowest frequency
		PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(l -> l.freq));
		// Loop iterate over the Map and returns a Set view of the mappings contained in
		// this Map
		for (var entry : freq.entrySet()) {
			// creates a leaf node and add it to the queue
			pq.add(new Node(entry.getKey(), entry.getValue()));
		}
		while (pq.size() != 1) {
			// removing the nodes having the highest priority (the lowest frequency) from
			// the queue
			Node left = pq.poll();
			Node right = pq.poll();
			int sum = left.freq + right.freq;
			pq.add(new Node(null, sum, left, right));
		}
		Node root = pq.peek();
		Map<Character, String> huffmanCode = new HashMap<>();
		encodeData(root, "", huffmanCode);
		System.out.println("Huffman Codes of the characters are: " + huffmanCode);
		System.out.println("The initial string is: " + text);
		StringBuilder sb = new StringBuilder();
		for (char c : text.toCharArray()) {
			sb.append(huffmanCode.get(c));
		}
		System.out.println("The encoded string is: " + sb);
		System.out.print("The decoded string is: ");
		if (isLeaf(root)) {
			// special case: For input like a, aa, aaa, etc.
			while (root.freq-- > 0) {
				System.out.print(root.ch);
			}
		} else {
			// decoding...
			int index = -1;
			while (index < sb.length() - 1) {
				index = decodeData(root, index, sb);
			}
		}
		return sb;
	}

	public static void encodeData(Node root, String str, Map<Character, String> huffmanCode) {
		if (root == null) {
			return;
		}
		if (isLeaf(root)) {
			huffmanCode.put(root.ch, str.length() > 0 ? str : "1");
		}
		encodeData(root.left, str + '0', huffmanCode);
		encodeData(root.right, str + '1', huffmanCode);
	}

	public static int decodeData(Node root, int index, StringBuilder sb) {
		// checks if the root node is null or not
		if (root == null) {
			return index;
		}
		// checks if the node is a leaf node or not
		if (isLeaf(root)) {
			System.out.print(root.ch);
			return index;
		}
		index++;
		root = (sb.charAt(index) == '0') ? root.left : root.right;
		index = decodeData(root, index, sb);
		return index;
	}

	// function to check if the Huffman Tree contains a single node
	public static boolean isLeaf(Node root) {
		// returns true if both conditions return true
		return root.left == null && root.right == null;
	}

	// driver code
	public static void main(String args[]) { // GUI
		Frame f2 = new Frame();
		f2.setVisible(true);
		f2.setSize(400, 400);
		f2.setLayout(null);

		Button b1 = new Button("SUBMIT");
		b1.setBounds(150, 180, 60, 70);
		f2.add(b1);

		Label height = new Label("Enter a STRING");
		height.setBounds(20, 50, 140, 20);
		f2.add(height);

		TextField t1 = new TextField();
		t1.setBounds(180, 50, 120, 20);
		f2.add(t1);

		Label finalt = new Label("Encoded String: ");
		finalt.setBounds(20, 140, 140, 20);
		f2.add(finalt);

		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = t1.getText();
				StringBuilder sbb = createHuffmanTree(text);
				String singleString = sbb.toString();
				finalt.setText(singleString);
			}
		});
	}
}
