package program;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Program {

	public static void main(String[] args) {

		String[] lines = new String[] { "bzacffvhnh", "dxhmjustqn", "vqiedveszq", "pxynjtyrik", "xgomgxkoof",
				"kcnvunklnb", "cwbirrcnvm", "etkngkfkiq", "nllchxamlq", "hdwyigrqgw", "optmdegdut", "twndyhtrkm",
				"cixpudkjlu", "bvymzrygtg", "omhbnghfmb", "rqbtopoazt", "dueuionnfg", "ngzzpriimc", "roumdkjzsq",
				"mxlyuyqxio" };

		String path = "./out.txt";

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) { // FileWriter(path, true) for append mode
			for (String line : lines) {
				bw.write(line);
				bw.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
